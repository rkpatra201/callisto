When a new broker joins or leaves a Kafka cluster, the **consumers** and **consumer groups** are affected, but Kafka has mechanisms in place to handle such changes smoothly. Here's what happens in each case:

### **When a New Broker Joins the Kafka Cluster**

1. **Rebalancing of Consumer Group Partitions**:
   - Kafka will trigger a **rebalance** of the partitions assigned to each consumer in the consumer group to distribute the load evenly across all brokers, including the new broker.
   - Consumers in the group will **reclaim** or **lose partitions** based on the new partition assignments. This rebalance ensures that the work is distributed across the new broker as well as the existing brokers.

2. **Partition Assignment**:
   - If a consumer group is consuming from a topic that has partitions on the new broker, Kafka might reassign some of the partitions from the existing brokers to the new broker.
   - Kafka uses a **partition assignment strategy** (like **range** or **round-robin**) to allocate partitions to consumers. The goal is to balance the number of partitions among consumers and ensure that no consumer is overloaded.

3. **Consumer Rebalancing**:
   - Each consumer will participate in the **rebalance protocol** to discover the new partition assignments. During this period, **consumers may experience a brief interruption** in consumption as Kafka redistributes the partitions.
   - Consumers will stop consuming messages from the old partition assignments and start consuming from the new ones once the rebalance is complete.

4. **Performance Impact**:
   - The rebalance process introduces some temporary overhead. There may be a **short delay** while consumers are re-assigned their partitions and Kafka reassigns the leaders.
   - However, once the rebalance is complete, consumption continues as usual, and consumers now consume from the new set of partitions, which may include those hosted on the newly added broker.

---

### **When a Broker Leaves the Kafka Cluster**

1. **Consumer Group Rebalancing**:
   - If a broker leaves the cluster (due to failure or manual removal), **Kafka triggers a rebalance** to reassign partitions that were previously assigned to the departing broker to other brokers in the cluster.
   - Consumers that were reading from the partitions on the departing broker will be reassigned to new partitions.
   
2. **Leader Re-election**:
   - If the broker leaving was the leader for some partitions, **leader election** will occur, and the partition leaders may shift to other brokers. This can result in a brief period of unavailability for the affected partitions.
   - Consumers might experience a slight delay during the leader election and the reassignment of partitions, as they need to sync with the new leader and receive updated partition assignments.

3. **Temporary Unavailability of Partitions**:
   - If no in-sync replicas (ISR) are available for partitions assigned to the leaving broker, those partitions might become **under-replicated** or temporarily unavailable for consumption.
   - Consumers that are assigned those partitions may **lose access** to data until the replication is restored, or a new leader is elected.

4. **Rebalancing of Partitions**:
   - After the rebalance, consumers will be assigned to new partitions. If the rebalance happens smoothly (e.g., there are enough in-sync replicas), the partition assignments will change, but the consumers will continue reading from the newly assigned partitions.
   - The rebalance process can introduce a **temporary pause** or **latency** for consuming messages as Kafka adjusts the partition assignments.

5. **Possible Duplicate Consumption**:
   - In some cases, especially if a consumer is reading data while the broker leaves and leader elections happen, a **consumer may reconsume messages** that were previously read. This happens because Kafka may reassign partitions, and when a consumer resumes consuming from a new leader, it could read some messages again, resulting in **duplicate consumption**. This is typically not a problem if the consumer logic handles idempotency (e.g., by tracking offsets).

---

### **Consumer Group Offset Management**

- Kafka keeps track of the **consumer group's offsets** for each partition it is consuming. Even if brokers join or leave, the consumer group offsets are stored in Kafka itself (in `__consumer_offsets` topic), not on the broker, so consumers can **resume from where they left off** after a rebalance.
  
- **Commit Offset Behavior**:
  - If a consumer crashes or is slow to rejoin during rebalance, it might **lose track** of which messages were successfully processed. However, Kafka allows consumers to **commit offsets** at their own pace (either automatically or manually), so even during broker changes, consumers can resume from the last committed offset.
  - If a consumer group loses track of messages (due to partitions reassigned to new leaders), it may **reconsume some messages**. However, Kafka guarantees at least once delivery semantics, meaning no messages will be lost, though duplicate messages may appear in this case.

---

### **How Kafka Ensures Consumer Resilience**

1. **Zookeeper or KRaft**:
   - In a traditional Kafka setup (with Zookeeper), **Zookeeper** coordinates the cluster state, including partition assignments and consumer group metadata. When a broker leaves or joins, Zookeeper helps Kafka rebalance and update the metadata across consumers.
   - In Kafka’s new **KRaft mode** (Kafka Raft), this metadata is managed directly by Kafka, which removes the reliance on Zookeeper, but the rebalancing and consumer group management process remains the same.

2. **Consumer Group Coordination**:
   - Kafka ensures that all consumers in the group are **coordinated** during a rebalance. Each consumer tracks its own partition assignments and offsets, ensuring that even if brokers leave or join, consumers can continue consuming messages without much disruption.

3. **Graceful Shutdown**:
   - If a broker is being removed (for maintenance or failure), a **graceful shutdown** process is important to avoid issues for consumers. Kafka ensures that consumer groups are notified of changes and can continue operating while partitions are being reassigned.

---

### **Summary: Effects on Consumers**

- **When a New Broker Joins**: Consumers may experience a temporary disruption while Kafka performs **partition rebalancing** and assigns partitions to the new broker. Once the rebalance is complete, consumers will continue reading from their new partitions.
  
- **When a Broker Leaves**: Consumers will be affected by **rebalancing** and **leader election**. There may be a short period of unavailability, especially if the broker that left was the leader of some partitions, or if no in-sync replicas are available. However, once rebalancing is complete, consumers will continue reading from the new partitions, and **offsets** will ensure they resume processing without losing data.

- **Impact on Consumption**: There may be **temporary pauses**, **reassignments**, and in some cases **duplicate messages** when a broker joins or leaves, but Kafka ensures that consumers can resume with minimal data loss or disruption by maintaining offsets and partition assignments.
