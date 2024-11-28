https://microservices.io/patterns/data/cqrs.html

https://learn.microsoft.com/en-us/azure/architecture/patterns/cqrs

### **CQRS (Command Query Responsibility Segregation)**

CQRS is a design pattern that separates the responsibilities of **reading** and **writing** data in an application. Instead of using the same data model for handling commands (write operations) and queries (read operations), CQRS splits these into two distinct models:

1. **Command Model**: Handles operations that modify the state of the system (e.g., create, update, delete).
2. **Query Model**: Handles operations that retrieve data without modifying the system's state.

This segregation allows each side to be optimized for its specific purpose, improving scalability, performance, and maintainability in certain use cases.

---

### **How It Works**

1. **Write Side (Command Model)**:
   - Accepts commands to perform create, update, or delete operations.
   - May use a normalized database structure to ensure data consistency.
   - Can include validation and domain logic for state changes.

2. **Read Side (Query Model)**:
   - Handles queries to fetch data.
   - Often uses a denormalized database structure (e.g., pre-aggregated views) optimized for fast reads.

3. **Data Synchronization**:
   - Changes made in the command model are propagated to the query model, typically using events or messages.

---

### **Example**

#### **Command Side**
A user places an order, and the application saves the order details in a normalized database.

```java
public class PlaceOrderCommand {
    private String orderId;
    private String customerId;
    private List<Item> items;
    // Getters and setters
}

orderService.handle(new PlaceOrderCommand(orderId, customerId, items));
```

#### **Query Side**
A user queries their order history, which fetches pre-aggregated data from a read-optimized database.

```java
public class GetOrderQuery {
    private String customerId;
    // Getters and setters
}

List<OrderSummary> orders = orderQueryService.handle(new GetOrderQuery(customerId));
```

#### **Synchronization**
When the command model updates the database, events are published to synchronize the query model.

---

### **Pros**

1. **Scalability**:
   - Command and query sides can scale independently to handle different workloads.

2. **Performance Optimization**:
   - Use denormalized data structures for fast reads on the query side.
   - Normalize data on the command side for consistency during writes.

3. **Separation of Concerns**:
   - Simplifies the application by separating business logic (commands) from read logic (queries).

4. **Flexibility in Data Models**:
   - Each side can use a different database or storage technology suited to its needs.

5. **Event Sourcing Compatibility**:
   - Pairs well with event sourcing, where all state changes are stored as a sequence of events.

---

### **Cons**

1. **Increased Complexity**:
   - Requires additional infrastructure for handling events and synchronizing data between models.

2. **Eventual Consistency**:
   - The query model might not immediately reflect changes made in the command model due to asynchronous updates.

3. **Data Duplication**:
   - Denormalized data in the query model can lead to duplication and higher storage requirements.

4. **Maintenance Overhead**:
   - Maintaining two models (and possibly different databases) adds operational overhead.

---

### **When to Use CQRS**

1. **Complex Domains**:
   - Applications with complex business logic, where separating read and write models simplifies development.

2. **High Scalability Requirements**:
   - Systems where read and write workloads differ significantly in scale.

3. **Optimized Queries**:
   - Use cases requiring highly efficient and complex read queries (e.g., dashboards, reporting).

4. **Event-Driven Architectures**:
   - Systems leveraging event sourcing or requiring real-time updates to multiple views.

5. **Microservices**:
   - To decouple services with specific read or write responsibilities.

---

### **CQRS Architecture**

1. **Command Side**:
   - Receives commands (e.g., "Create Order") and executes the business logic.
   - Updates the database.
   - Publishes domain events for the query side to consume.

2. **Query Side**:
   - Subscribes to domain events and updates its read-optimized database or cache.
   - Handles queries and returns pre-processed, fast responses.

---

### **Diagram**

```
[ User ]
   ↓
Command → [ Write Model ] → [ Write Database ]
   ↑                      ↓
Query ← [ Read Model ] ← [ Read Database ]
```

---

CQRS is especially useful in systems with complex domains and high performance requirements but should be used judiciously due to the increased complexity it introduces.
