https://microservices.io/patterns/data/transactional-outbox.html

### **Transactional Outbox Pattern**

The **Transactional Outbox Pattern** is a design pattern used to ensure data consistency across services when using event-driven architectures or messaging systems. It solves the problem of coordinating a database transaction and the emission of events to a message broker in a distributed system. The primary goal is to avoid issues like the **dual-write problem**, where a failure occurs after updating the database but before publishing an event, or vice versa.

---

### **How It Works**

1. **Outbox Table**:
   - An "outbox" table is added to the same database where the application stores its primary data.
   - This table stores messages (events) that need to be sent to other systems or services.

2. **Transactional Update**:
   - Both the main database operation (e.g., updating or inserting a record) and writing the event to the outbox table happen within a **single database transaction**.
   - This ensures atomicity — either both actions succeed or both are rolled back.

3. **Event Polling**:
   - A separate process (or thread) polls the outbox table for new messages.
   - When new messages are found, they are sent to the message broker (e.g., Kafka, RabbitMQ, SNS).

4. **Deletion of Processed Events**:
   - Once an event is successfully delivered to the message broker, it is marked as processed or deleted from the outbox table.

---

### **Steps**

1. A service performs a transaction involving business logic (e.g., order creation).
2. During the transaction, it writes the domain event (e.g., "OrderCreated") to the outbox table.
3. The transaction commits, ensuring the outbox entry is consistent with the database state.
4. A background worker or integration layer reads the outbox table, processes events, and publishes them to the message broker.
5. The worker marks the event as processed or deletes it from the outbox table.

---

### **Example**

#### **Outbox Table Schema**
```sql
CREATE TABLE Outbox (
    id SERIAL PRIMARY KEY,
    event_type VARCHAR(255),
    event_payload TEXT,
    status VARCHAR(50) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### **Database Transaction**
```sql
BEGIN;

-- Insert order details
INSERT INTO Orders (id, customer_id, amount) VALUES (1, 101, 200);

-- Insert event into the outbox
INSERT INTO Outbox (event_type, event_payload) VALUES (
    'OrderCreated',
    '{"orderId": 1, "customerId": 101, "amount": 200}'
);

COMMIT;
```

#### **Event Processing**
A worker fetches the `PENDING` events, publishes them to the broker, and updates their status:
```sql
SELECT * FROM Outbox WHERE status = 'PENDING';

-- After publishing
UPDATE Outbox SET status = 'PROCESSED' WHERE id = ?;
```

---

### **Pros**

1. **Data Consistency**:
   - Ensures the database state and the emitted events are consistent by using a single transaction.

2. **Resiliency**:
   - Prevents data loss since events are stored in the database until successfully processed.

3. **Simple Implementation**:
   - No need for distributed transactions or 2PC (Two-Phase Commit), making it less complex.

4. **Idempotency**:
   - Enables retrying event publication without side effects since events are persisted until acknowledged.

---

### **Cons**

1. **Increased Database Load**:
   - The outbox table adds more writes and reads to the database, which could impact performance.

2. **Event Delivery Latency**:
   - There may be a delay between when an event is written to the outbox and when it is published.

3. **Complexity of Polling**:
   - The background worker needs careful implementation to handle retries, batching, and failures.

4. **Message Ordering**:
   - Outbox events might not always be processed in the same order as they were created.

---

### **Best Practices**

1. **Use Optimized Polling**:
   - Use batching or change data capture (CDC) techniques to minimize database load.

2. **Monitor the Outbox Table**:
   - Regularly clean up processed events to prevent table bloat.

3. **Ensure Idempotency**:
   - Make event consumers idempotent to handle duplicate messages during retries.

4. **Scale Workers**:
   - Deploy multiple workers to process events faster in high-throughput systems.

5. **Use Schema Evolution**:
   - Add versioning to the `event_payload` field to handle schema changes over time.

---

### **When to Use**

- In systems requiring **event-driven communication** with strong consistency.
- When there’s a need to **avoid distributed transactions** or 2PC.
- For **microservices architectures** where services rely on asynchronous communication via events.

The transactional outbox is a powerful pattern that simplifies achieving consistency while maintaining flexibility in modern architectures.
