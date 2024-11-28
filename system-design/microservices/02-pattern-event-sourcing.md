https://microservices.io/patterns/data/event-sourcing.html

https://learn.microsoft.com/en-us/azure/architecture/patterns/event-sourcing

### **Event Sourcing Pattern**

**Event Sourcing** is a design pattern in which the state of an application is derived from a sequence of events, rather than directly storing the current state in a database. Each event represents a state change in the system, and the state can always be reconstructed by replaying these events from the beginning.

Instead of persisting the current state of an entity (e.g., as rows in a database table), event sourcing stores a log of all the changes (events) that have occurred. The current state is a derived projection of these events.

---

### **How It Works**

1. **Capture Events**:
   - When an operation occurs (e.g., creating an order, updating its status), an **event** is generated to represent that change.
   - Example events: `OrderCreated`, `OrderPaid`, `OrderShipped`.

2. **Store Events**:
   - Each event is saved in an **event store** (a log-like database) in chronological order.

3. **Rebuild State**:
   - To determine the current state of an entity, events are replayed from the event store in order.

4. **Event Projections**:
   - For performance optimization, projections (read models) can be created by processing events into a denormalized and query-friendly structure.

---

### **Example**

#### **Event Store**
Imagine an order system where we record events like this:

| Event ID | Entity ID | Event Type      | Data (Payload)             | Timestamp           |
|----------|-----------|-----------------|----------------------------|---------------------|
| 1        | 123       | `OrderCreated`  | {"orderId": 123, "items": [...] } | 2024-11-28 10:00:00 |
| 2        | 123       | `OrderPaid`     | {"orderId": 123, "amount": 100}   | 2024-11-28 10:05:00 |
| 3        | 123       | `OrderShipped`  | {"orderId": 123, "carrier": "DHL"}| 2024-11-28 10:10:00 |

#### **Rebuild State**
The current state of `Order 123` can be rebuilt by applying the events in order:

1. Start with an empty order.
2. Apply `OrderCreated` → The order is initialized with items.
3. Apply `OrderPaid` → Mark the order as paid.
4. Apply `OrderShipped` → Update the shipping status.

#### **Projections**
To speed up queries, a background process listens to events and updates a projection:

| Order ID | Status   | Total Amount | Last Updated        |
|----------|----------|--------------|---------------------|
| 123      | Shipped  | 100          | 2024-11-28 10:10:00 |

---

### **Benefits**

1. **Auditability**:
   - Every state change is recorded as an event, providing a complete and immutable history.

2. **Replayability**:
   - Allows reconstruction of the state at any point in time (useful for debugging or analytics).

3. **Scalability**:
   - Events are append-only, making event stores highly scalable and efficient for writes.

4. **Flexibility**:
   - Enables building multiple projections or read models optimized for specific queries.

5. **Decoupling**:
   - Event-driven architectures naturally decouple components, as consumers only process events.

6. **Temporal Queries**:
   - Supports querying the state of an entity at a specific point in time.

---

### **Challenges**

1. **Complexity**:
   - Requires significant effort to design and implement compared to traditional CRUD systems.

2. **Event Evolution**:
   - Events need versioning to handle schema changes over time.

3. **Storage Growth**:
   - The event store can grow large over time; snapshots are needed to optimize state reconstruction.

4. **Consistency**:
   - Achieving eventual consistency between the event store and projections can be tricky.

5. **Debugging**:
   - Debugging an event-driven system may be more challenging due to the distributed and asynchronous nature.

---

### **Best Practices**

1. **Use Snapshots**:
   - Periodically save the current state of an entity to speed up state reconstruction.

2. **Implement Idempotency**:
   - Ensure event handlers are idempotent to handle duplicate event deliveries.

3. **Version Events**:
   - Add versioning to your events to handle changes in event structure over time.

4. **Optimize Projections**:
   - Use projections for read-intensive queries to avoid reconstructing the state repeatedly.

5. **Event Validation**:
   - Validate events to ensure they are meaningful and consistent with business logic.

---

### **When to Use Event Sourcing**

1. **Applications with Complex Workflows**:
   - Systems where state changes need to be carefully tracked and audited.

2. **Event-Driven Systems**:
   - Microservices architectures or systems relying on message brokers.

3. **High Write-Volume Applications**:
   - Where write throughput is critical and an append-only log is advantageous.

4. **Temporal Data**:
   - Scenarios where the state at any given time needs to be queryable (e.g., financial systems).

5. **Event Replay Requirements**:
   - Systems requiring replay of past events for testing, debugging, or analytics.

---

### **Comparison to CQRS**

- **CQRS** focuses on separating reads and writes; it can use event sourcing as an underlying mechanism but doesn’t require it.
- **Event Sourcing** focuses on persisting state changes as events and can complement CQRS for data consistency and scalability.

Together, **CQRS** and **Event Sourcing** form a powerful combination for building scalable and resilient systems.
