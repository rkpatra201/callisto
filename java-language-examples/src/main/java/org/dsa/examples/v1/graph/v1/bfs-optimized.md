Yes, exactly! If you **mark visited before enqueueing**, it prevents adding `B` multiple times, making BFS more efficient. Let's walk through your example step by step.

---

### **Scenario: Marking on Dequeue (Inefficient)**
#### **Graph Example**
```
    A
   /|\ \
  K B C D
  | |
  B C
```
#### **BFS Process (Marking on Dequeue)**
```java
while (!queue.isEmpty()) {
    Node node = queue.poll();  // Dequeue

    if (visited.contains(node)) continue;  // Mark here (AFTER dequeueing)
    visited.add(node);  // 🔴 Late marking!

    for (Node neighbor : node.getNeighbors()) {
        if (!visited.contains(neighbor)) {
            queue.add(neighbor);  // Adding unvisited neighbor
        }
    }
}
```
#### **Problem**
1. Start BFS from `A`. Queue: `[A]`
2. Process `A`: Add `K, B, C, D` to queue. Queue: `[K, B, C, D]`
3. Process `K`: Adds `B, C` to queue **again**! Queue: `[B, C, D, B, C]`
4. Now `B` and `C` appear **twice** in the queue before getting dequeued and marked visited.

**Issue:**
- `B` and `C` are added multiple times before getting marked visited.
- BFS wastes extra queue space and processing time.

---

### **Scenario: Marking on Enqueue (Optimized)**
```java
while (!queue.isEmpty()) {
    Node node = queue.poll();  // Dequeue

    for (Node neighbor : node.getNeighbors()) {
        if (!visited.contains(neighbor)) {
            visited.add(neighbor);  // ✅ Mark **before** enqueueing
            queue.add(neighbor);
        }
    }
}
```
#### **Optimized BFS Process**
1. Start BFS from `A`. Queue: `[A]`
2. Process `A`:
    - Add `K, B, C, D` to queue **and mark them visited immediately**.
    - Queue: `[K, B, C, D]`
3. Process `K`:
    - Sees `B` and `C`, but **they are already visited** → **skips them**.
    - Queue remains `[B, C, D]` (no duplicates added!)
4. Process `B`, `C`, `D` normally.

**Benefit:**  
✅ **Each node enters the queue only once** → BFS runs **faster** and **uses less memory**.

---

### **🚀 Key Takeaway**
🔹 **Mark before enqueueing** to avoid duplicate insertions.  
🔹 **Mark on dequeue only when necessary (like when all edges must be explored in weighted graphs).**  
✔ **In grid-based BFS and shortest path BFS, always mark before enqueueing!** 🚀