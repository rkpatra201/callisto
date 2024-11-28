Message ordering in Kafka is **guaranteed** under certain conditions but can vary depending on how Kafka is configured and used. Here's an explanation of when Kafka ensures message ordering and when it may not:

---

### **When Message Ordering is Guaranteed**

1. **Within a Partition**:
   - Kafka guarantees the order of messages **within a single partition**. 
   - Producers append messages to a partition, and consumers read them in the same order.
   - This is because each partition is written and read sequentially.

2. **Single Producer per Partition**:
   - If there is only one producer writing to a specific partition, Kafka ensures that messages are written in the same order as they were sent by the producer.

3. **Single Consumer per Partition**:
   - When a single consumer reads from a partition, messages are consumed in the exact order they were produced.

---

### **When Message Ordering is Not Guaranteed**

1. **Across Partitions**:
   - Kafka does **not** guarantee ordering of messages across multiple partitions of a topic.
   - This is because each partition can be processed independently and in parallel.

2. **Multiple Producers**:
   - If multiple producers send messages to the same partition, the order of messages from different producers is **not guaranteed**.

3. **Consumer Groups**:
   - If a consumer group reads from multiple partitions, there is no global ordering guarantee across those partitions. 
   - For example, Consumer A may read Partition 1, and Consumer B may read Partition 2; the sequence of delivery between partitions may differ.

4. **Retries**:
   - If message retries are enabled on the producer and a message fails to deliver initially, Kafka may resend the message, potentially leading to out-of-order delivery for that partition.

---

### **Best Practices to Ensure Ordering**

1. **Use a Single Partition**:
   - Assign all messages to a single partition to maintain a global order. However, this limits scalability since only one broker will handle all messages for the topic.

2. **Partition by Key**:
   - Use a partitioning strategy (e.g., key-based partitioning) to route messages with the same key to the same partition. This ensures ordering for messages with the same key.

3. **Avoid Multiple Producers per Partition**:
   - Use a single producer to send messages to a partition to ensure the order is preserved.

4. **Disable Retries (if critical)**:
   - Disabling retries eliminates the possibility of reordering due to retry mechanisms but may lead to data loss in case of transient failures.

---

### **Scenario Example**

#### **Topic with 3 Partitions**
- **Messages:**
  - Producer sends: M1, M2, M3, M4, M5, M6
- **Partitioning:**
  - M1 → Partition 1  
  - M2 → Partition 2  
  - M3 → Partition 3  
  - M4 → Partition 1  
  - M5 → Partition 2  
  - M6 → Partition 3

- **Result:**
  - Order is maintained **within each partition**:
    - Partition 1: M1, M4
    - Partition 2: M2, M5
    - Partition 3: M3, M6
  - **No global ordering** across partitions:
    - Consumers may receive messages in the order: M1, M3, M2, M4, M5, M6.

---

### **Conclusion**

Kafka guarantees message ordering **within partitions**, provided that:
- Messages with the same key are routed to the same partition.
- A single producer writes to the partition.
- A single consumer processes messages from that partition.

For global ordering across a topic, you must use a single partition, but this sacrifices scalability and throughput.
