In MySQL, **keys** and **constraints** are used to enforce rules and relationships between tables, ensuring data integrity, consistency, and efficient querying. Here's an overview of the different types of keys and constraints in MySQL, along with examples.

---

### **1. Primary Key**

A **Primary Key** uniquely identifies each record in a table. Each table can have only one primary key, which can consist of one or multiple columns (composite primary key). A primary key automatically enforces uniqueness and cannot contain `NULL` values.

#### Example:
```sql
CREATE TABLE employee (
    emp_id INT NOT NULL,
    emp_name VARCHAR(100),
    PRIMARY KEY (emp_id)
);
```
- Here, `emp_id` is the primary key, and it must be unique and non-null for each employee.

---

### **2. Foreign Key**

A **Foreign Key** establishes a relationship between two tables. It ensures that the value in one table matches a value in another table, usually referencing the primary key of another table. This maintains referential integrity between the two tables.

#### Example:
```sql
CREATE TABLE department (
    dept_id INT NOT NULL,
    dept_name VARCHAR(100),
    PRIMARY KEY (dept_id)
);

CREATE TABLE employee (
    emp_id INT NOT NULL,
    emp_name VARCHAR(100),
    dept_id INT,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);
```
- Here, the `dept_id` in the `employee` table is a foreign key that references the `dept_id` in the `department` table. This ensures that an employee's department must exist in the `department` table.

---

### **3. Unique Key**

A **Unique Key** constraint ensures that all values in a column are distinct (i.e., no duplicates). Unlike the primary key, it allows `NULL` values (but only one `NULL` value per column in most cases).

#### Example:
```sql
CREATE TABLE employee (
    emp_id INT NOT NULL,
    emp_name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    PRIMARY KEY (emp_id)
);
```
- Here, the `email` column must have unique values for each employee. No two employees can share the same email address.

---

### **4. Index**

An **Index** is used to improve the speed of query execution by providing quick lookup for rows in a table. Indexes are often created on columns that are frequently queried, sorted, or used in joins. An index does not enforce data integrity, but it enhances query performance.

#### Example:
```sql
CREATE INDEX idx_emp_name ON employee (emp_name);
```
- This creates an index on the `emp_name` column, which will speed up queries filtering or sorting by the `emp_name`.

---

### **5. Check Constraint**

A **Check Constraint** ensures that the values in a column meet a specific condition or criterion before they are accepted into the table. It is used to enforce data validity and consistency.

#### Example:
```sql
CREATE TABLE employee (
    emp_id INT NOT NULL,
    emp_name VARCHAR(100),
    age INT,
    PRIMARY KEY (emp_id),
    CHECK (age >= 18)  -- Ensures age is 18 or older
);
```
- Here, the `CHECK` constraint ensures that the `age` of an employee is at least 18. If you try to insert an employee with an age less than 18, it will be rejected.

---

### **6. Not Null Constraint**

The **Not Null Constraint** ensures that a column cannot have `NULL` values. It is often used for fields that are required, such as IDs or names.

#### Example:
```sql
CREATE TABLE employee (
    emp_id INT NOT NULL,
    emp_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (emp_id)
);
```
- Here, both the `emp_id` and `emp_name` columns cannot be `NULL`.

---

### **7. Default Constraint**

A **Default Constraint** assigns a default value to a column when no value is provided during an `INSERT` operation. This can be useful when you want to provide a value that is commonly used but still allow the column to be overwritten if needed.

#### Example:
```sql
CREATE TABLE employee (
    emp_id INT NOT NULL,
    emp_name VARCHAR(100),
    start_date DATE DEFAULT CURRENT_DATE,  -- Default to the current date
    PRIMARY KEY (emp_id)
);
```
- Here, if the `start_date` is not specified during insertion, the current date will be automatically assigned to it.

---

### **8. Auto Increment**

The **Auto Increment** attribute is used to automatically generate a unique value for a column, usually used with the primary key. The value is incremented each time a new record is inserted.

#### Example:
```sql
CREATE TABLE employee (
    emp_id INT NOT NULL AUTO_INCREMENT,
    emp_name VARCHAR(100),
    PRIMARY KEY (emp_id)
);
```
- The `emp_id` column is automatically incremented when a new row is inserted, eliminating the need to manually specify a value for the `emp_id`.

---

### **9. Composite Key**

A **Composite Key** is a primary key that consists of two or more columns. This is useful when a single column is not sufficient to uniquely identify records in a table.

#### Example:
```sql
CREATE TABLE project_assignment (
    emp_id INT,
    project_id INT,
    start_date DATE,
    end_date DATE,
    PRIMARY KEY (emp_id, project_id)
);
```
- In this example, a composite primary key is used consisting of `emp_id` and `project_id`. This ensures that each employee can be assigned to a project only once.

---

### **10. Cascade Options for Foreign Keys**

You can specify **CASCADE** options for foreign keys to automatically update or delete rows in child tables when the referenced row in the parent table is updated or deleted. The main options are:

- **ON DELETE CASCADE**: Automatically delete the rows in the child table when the corresponding row in the parent table is deleted.
- **ON UPDATE CASCADE**: Automatically update the rows in the child table when the corresponding row in the parent table is updated.

#### Example:
```sql
CREATE TABLE department (
    dept_id INT NOT NULL,
    dept_name VARCHAR(100),
    PRIMARY KEY (dept_id)
);

CREATE TABLE employee (
    emp_id INT NOT NULL,
    emp_name VARCHAR(100),
    dept_id INT,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id) 
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
```
- Here, if a department is deleted from the `department` table, all employees in that department will also be deleted automatically (cascade delete). Similarly, if a department's ID is updated, all corresponding references in the `employee` table will also be updated.

---

### Summary Table:

| **Key/Constraint**      | **Description**                                                                 |
|-------------------------|---------------------------------------------------------------------------------|
| **Primary Key**          | Uniquely identifies each record in a table. Cannot be `NULL`.                   |
| **Foreign Key**          | Establishes a relationship between two tables and ensures referential integrity.|
| **Unique Key**           | Ensures all values in a column are distinct. Can allow `NULL` values.           |
| **Index**                | Improves query performance but does not enforce data integrity.                 |
| **Check**                | Enforces a condition on the values of a column.                                 |
| **Not Null**             | Ensures that a column cannot have `NULL` values.                                |
| **Default**              | Assigns a default value to a column when no value is provided.                  |
| **Auto Increment**       | Automatically generates unique values for a column (typically for primary keys).|
| **Composite Key**        | A primary key that consists of multiple columns.                               |
| **Cascade (Foreign Key)**| Specifies automatic update or delete behavior for related rows.               |

These keys and constraints help maintain data integrity, optimize queries, and enforce business rules at the database level.

## Candidate Key

A **Candidate Key** is a set of one or more attributes (columns) in a database table that can uniquely identify a record in that table. Candidate keys have the following properties:

1. **Uniqueness**: The values of a candidate key must be unique for each row in the table.
2. **Minimality**: A candidate key is minimal, meaning that no subset of the candidate key can uniquely identify records. In other words, you cannot remove any column from the candidate key and still maintain uniqueness.

A table may have multiple candidate keys, but only one of them is chosen to be the **primary key**. The other candidate keys are known as **alternate keys**.

### Example:

Let's consider the following `employee` table:

| emp_id | emp_name  | emp_email          | emp_phone   |
|--------|-----------|--------------------|-------------|
| 1      | John      | john@example.com    | 1234567890  |
| 2      | Alice     | alice@example.com   | 2345678901  |
| 3      | Bob       | bob@example.com     | 3456789012  |

#### Candidate Keys:
- **`emp_id`**: It is a unique identifier for each employee and could be a candidate key.
- **`emp_email`**: It is also unique for each employee and could be a candidate key.
- **`emp_phone`**: It is also unique for each employee and could be a candidate key.

In this case, the table has **three candidate keys**: `emp_id`, `emp_email`, and `emp_phone`. One of these will be chosen as the **primary key** (typically `emp_id`), and the others (`emp_email`, `emp_phone`) would be **alternate keys**.

### Difference between **Candidate Key** and **Primary Key**:
- **Candidate Key**: Any column (or combination of columns) that can uniquely identify records in a table. There may be multiple candidate keys.
- **Primary Key**: The candidate key selected to uniquely identify records in a table. A table can have only one primary key.

### Example with Composite Candidate Key:

Consider the following `course_enrollment` table:

| student_id | course_id | enrollment_date |
|------------|-----------|-----------------|
| 1          | 101       | 2024-01-01      |
| 1          | 102       | 2024-02-01      |
| 2          | 101       | 2024-01-15      |

#### Candidate Keys:
- **`student_id + course_id`**: The combination of `student_id` and `course_id` can uniquely identify each enrollment. No single column can do this, so this is a **composite candidate key**.
- **`student_id`** or **`course_id`** alone is **not** a candidate key, as they do not uniquely identify each enrollment (a student can enroll in multiple courses).

In this case, the composite key `student_id + course_id` is the only candidate key, and if we choose it as the primary key, the other columns (`student_id` and `course_id`) would be alternate keys.

### Key Points to Remember:
1. A **candidate key** can consist of one or more columns (composite key).
2. A **primary key** is the selected candidate key for uniquely identifying records.
3. **Alternate keys** are candidate keys that are not selected as the primary key.
4. There can be multiple candidate keys in a table, but only one primary key.


