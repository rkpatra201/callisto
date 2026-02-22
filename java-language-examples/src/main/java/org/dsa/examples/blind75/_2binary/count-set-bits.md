### **Brian Kernighan’s Algorithm to Count Set Bits (1s)**
Brian Kernighan’s algorithm efficiently counts the number of `1` bits in an integer by repeatedly clearing the rightmost `1` bit until the number becomes `0`.

---

### **Key Idea**
Instead of checking each bit individually, we repeatedly perform the operation:

\[
\text{num} = \text{num} \& (\text{num} - 1)
\]

This operation **removes the rightmost `1` bit** in the binary representation of `num`.

---

### **How Does num & (num - 1) Work?**
When you subtract `1` from a number, all the bits **after the rightmost `1` bit flip**.

For example:
- `num = 29` (Binary: `11101`)
- `num - 1 = 28` (Binary: `11100`)
- `num & (num - 1) = 11101 & 11100 = 11100`

This effectively **removes the lowest set bit** in `num`.

---

### **Step-by-Step Example**
Let's count the number of `1` bits in `num = 29` (`11101` in binary).

#### **Initial value:**
```
num = 29  → Binary:  11101
```

#### **Iteration 1:**
```
num = num & (num - 1)
    = 11101 & 11100
    = 11100  (count = 1)
```

#### **Iteration 2:**
```
num = 11100 & 11011
    = 11000  (count = 2)
```

#### **Iteration 3:**
```
num = 11000 & 10111
    = 10000  (count = 3)
```

#### **Iteration 4:**
```
num = 10000 & 01111
    = 00000  (count = 4)
```

✅ Since `num` is now `0`, we stop. The final count is **4**, which is the number of `1`s in `11101`.

---

### **Java Implementation**
```java
public class CountSetBits {
    public static int countBits(int num) {
        int count = 0;
        while (num != 0) {
            num &= (num - 1); // Remove the rightmost 1-bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 29; // Binary: 11101
        System.out.println("Number of 1 bits: " + countBits(num)); // Output: 4
    }
}
```

---

### **Time Complexity**
- **Best case:** O(1) (if `num` is `0`)
- **Worst case:** O(k), where `k` is the number of `1`s in `num`
- **Average case:** Much faster than looping through all bits (O(log n))

**Why is it efficient?**
- Instead of checking all `32` bits in an integer, it only runs **k** times (where `k` is the number of `1`s).
- If `num` is sparse (few `1`s), this method is **much faster** than checking each bit individually.

---

### **Comparison with Simple Right Shift Method**
| Method | Worst-Case Complexity | Iterations for `n = 29` (`11101`) |
|--------|-----------------------|----------------------------------|
| Right shift (`>>`) | **O(log n)** | 5 |
| Kernighan’s method | **O(k)** (k = number of 1s) | 4 |

**💡 Key takeaway:**  
Brian Kernighan’s approach is **better for sparse-bit numbers** since it only loops as many times as there are `1`s. 🚀