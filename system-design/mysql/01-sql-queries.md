## SQL Queries
- Find employees who are getting minimum salary in each department.
- Return last 3 animal types from animal table. Last meaning frequency count from the bottom when sorted in increasing order.
- Find employees earning more than their manager's salary using CTE, JOIN, SUBQUERY, INNER QUERY

## Find employees earning more than their manager's salary using CTE, JOIN, SUBQUERY, INNER QUERY

Here are the solutions to find employees earning more than their manager's salary using different approaches:

### 1. **Using CTE**

```sql
WITH ManagerSalaries AS (
    SELECT e.employee_id, e.manager_id, e.salary AS employee_salary, m.salary AS manager_salary
    FROM employee e
    JOIN employee m ON e.manager_id = m.employee_id
)
SELECT employee_id
FROM ManagerSalaries
WHERE employee_salary > manager_salary;
```

---

### 2. **Using JOIN**

```sql
SELECT e.employee_id
FROM employee e
JOIN employee m ON e.manager_id = m.employee_id
WHERE e.salary > m.salary;
```

---

### 3. **Using Subquery**

```sql
SELECT employee_id
FROM employee e
WHERE salary > (
    SELECT salary
    FROM employee m
    WHERE m.employee_id = e.manager_id
);
```

---

### 4. **Using Inner Query**

```sql
SELECT e.employee_id
FROM employee e, employee m
WHERE e.manager_id = m.employee_id
  AND e.salary > m.salary;
```

---

### Explanation:
- **CTE**: Calculates the employee-manager salary relationship in the `WITH` clause, then filters employees whose salary exceeds their manager’s.  
- **JOIN**: Joins the table with itself on `manager_id` and `employee_id`, then filters employees with higher salaries.  
- **Subquery**: For each employee, a subquery retrieves their manager's salary, and employees with higher salaries are selected.  
- **Inner Query**: Uses a Cartesian join-like syntax (less common in modern SQL) to achieve the same result.  

Each method works effectively, but the choice depends on readability, performance, and preference.

## Return last 3 animal types from animal table. Last meaning frequency count from the bottom when sorted in increasing order.

### Solution 3 (CTE)
Here’s the solution using a **Common Table Expression (CTE)**:

```sql
WITH FrequencyCounts AS (
    SELECT animal_type, COUNT(*) AS frequency
    FROM animal
    GROUP BY animal_type
    ORDER BY COUNT(*) ASC
    LIMIT 3
)
SELECT a.animal_type
FROM animal a
INNER JOIN FrequencyCounts fc
ON a.animal_type = fc.animal_type;
``` 

### Explanation:
1. **CTE (`FrequencyCounts`)**:  
   - Groups animals by `animal_type`, calculates their frequency, orders them in ascending order, and limits the result to the last 3 based on frequency.

2. **Main Query**:  
   - Performs an `INNER JOIN` between the main `animal` table (`a`) and the CTE (`FrequencyCounts`) to select the `animal_type` values that are among the last 3 based on frequency.

### Solution 2 (INNER JOIN)


```sql
SELECT a.animal_type
FROM animal a
JOIN (
    SELECT animal_type, COUNT(*) AS frequency
    FROM animal
    GROUP BY animal_type
    ORDER BY COUNT(*) ASC
    LIMIT 3
) subquery
ON a.animal_type = subquery.animal_type;

```

### Solution 1 (INNER QUERY)
You are correct! The last three animal types based on frequency count (sorted in ascending order) should indeed be **Cat**, **Rabbit**, and **Dog**, assuming we interpret "last" as selecting the lowest frequency counts first. Here’s the revised explanation and query:

### Correct SQL Query:

```sql
SELECT animal_type
FROM (
    SELECT animal_type, COUNT(*) AS frequency
    FROM animal
    GROUP BY animal_type
    ORDER BY frequency ASC
) ordered_animals
LIMIT 3;
```

### How It Works:
1. **Group and Count**:  
   - Group the animals by their type and count the occurrences of each type.

2. **Order by Frequency**:  
   - Sort the result in ascending order of frequency (`ORDER BY frequency ASC`), so the least frequent types come first.

3. **Limit to 3 Rows**:  
   - Select only the first three rows from the sorted result (`LIMIT 3`).

### Example Table (`animal`):

| animal_id | animal_type |
|-----------|-------------|
| 1         | Dog         |
| 2         | Cat         |
| 3         | Dog         |
| 4         | Bird        |
| 5         | Bird        |
| 6         | Fish        |
| 7         | Fish        |
| 8         | Fish        |
| 9         | Rabbit      |

### Step-by-Step:

1. **Count Frequencies**:
   | animal_type | frequency |
   |-------------|-----------|
   | Dog         | 2         |
   | Cat         | 1         |
   | Bird        | 2         |
   | Fish        | 3         |
   | Rabbit      | 1         |

2. **Order by Frequency**:
   | animal_type | frequency |
   |-------------|-----------|
   | Cat         | 1         |
   | Rabbit      | 1         |
   | Dog         | 2         |
   | Bird        | 2         |
   | Fish        | 3         |

3. **Limit to the Last 3 (Lowest Frequency First)**:
   | animal_type | frequency |
   |-------------|-----------|
   | Cat         | 1         |
   | Rabbit      | 1         |
   | Dog         | 2         |

### Final Result:
| animal_type |
|-------------|
| Cat         |
| Rabbit      |
| Dog         | 

This query and interpretation align with selecting the last three unique animal types based on the lowest frequency counts. Thank you for catching that!


## Find employees who are getting minimum salary in each department

### Solution 3 (CTE)
You can solve the problem using a **Common Table Expression (CTE)** to make the query more readable and modular. Here's how:

```sql
WITH MinSalaries AS (
    SELECT department_id, MIN(salary) AS min_salary
    FROM employees
    GROUP BY department_id
)
SELECT e.*
FROM employees e
JOIN MinSalaries ms
ON e.department_id = ms.department_id AND e.salary = ms.min_salary;
```

### Explanation:
1. **CTE (`MinSalaries`)**:  
   - The CTE calculates the minimum salary for each department by grouping employees by `department_id` and finding the `MIN(salary)`.
   - It returns two columns: `department_id` and `min_salary`.

2. **Main Query**:  
   - The main query uses a `JOIN` between the `employees` table (`e`) and the CTE (`MinSalaries`), matching:
     - `department_id` from both.
     - `salary` in the `employees` table with `min_salary` from the CTE.

3. **Result**:  
   - All employees with the minimum salary in their respective departments are selected.

### Example Table:

| employee_id | name     | department_id | salary |
|-------------|----------|---------------|--------|
| 1           | Alice    | 101           | 5000   |
| 2           | Bob      | 101           | 3000   |
| 3           | Charlie  | 101           | 3000   |
| 4           | David    | 102           | 4000   |
| 5           | Eve      | 102           | 6000   |

### CTE (`MinSalaries`) Result:
| department_id | min_salary |
|---------------|------------|
| 101           | 3000       |
| 102           | 4000       |

### Final Result:
| employee_id | name    | department_id | salary |
|-------------|---------|---------------|--------|
| 2           | Bob     | 101           | 3000   |
| 3           | Charlie | 101           | 3000   |
| 4           | David   | 102           | 4000   |

Using a CTE improves the readability of the query, especially when working with more complex logic or multiple levels of grouping.

### Solution 2 (JOIN)
Yes, the problem can be solved using a `JOIN` to match each employee's salary with the minimum salary for their department. Here’s the SQL query:

```sql
SELECT e.*
FROM employees e
JOIN (
    SELECT department_id, MIN(salary) AS min_salary
    FROM employees
    GROUP BY department_id
) min_salaries
ON e.department_id = min_salaries.department_id AND e.salary = min_salaries.min_salary;
```

### Explanation:
1. **Subquery (`min_salaries`)**:  
   - This subquery groups employees by `department_id` and calculates the `MIN(salary)` for each department. It returns two columns: `department_id` and `min_salary`.

2. **JOIN**:  
   - The main `employees` table (`e`) is joined with the result of the subquery (`min_salaries`) on two conditions:
     - The `department_id` matches.
     - The employee's salary matches the `min_salary` for that department.

3. **Result**:  
   - The result includes all employees whose salary equals the minimum salary in their department.

### Example Table:

| employee_id | name     | department_id | salary |
|-------------|----------|---------------|--------|
| 1           | Alice    | 101           | 5000   |
| 2           | Bob      | 101           | 3000   |
| 3           | Charlie  | 101           | 3000   |
| 4           | David    | 102           | 4000   |
| 5           | Eve      | 102           | 6000   |

### Subquery Result (`min_salaries`):
| department_id | min_salary |
|---------------|------------|
| 101           | 3000       |
| 102           | 4000       |

### Final Result:
| employee_id | name    | department_id | salary |
|-------------|---------|---------------|--------|
| 2           | Bob     | 101           | 3000   |
| 3           | Charlie | 101           | 3000   |
| 4           | David   | 102           | 4000   |

This approach is efficient and often preferred for scenarios involving grouped calculations with row matching.

### Solution 1 (INNER QUERY)
To find employees with the minimum salary in each department (allowing duplicates), you can use the following SQL query:

```sql
SELECT e.*
FROM employees e
WHERE e.salary = (
    SELECT MIN(salary)
    FROM employees
    WHERE department_id = e.department_id
);
```

### Explanation:
1. **Subquery**:  
   - The subquery `(SELECT MIN(salary) FROM employees WHERE department_id = e.department_id)` gets the minimum salary for the department of the current employee (`e.department_id`).

2. **Main query**:  
   - The outer query selects all columns of the employees whose salary matches the minimum salary of their department.

3. **Duplicate Handling**:  
   - Since we're not using `DISTINCT` or any aggregation to eliminate duplicates, if multiple employees in the same department have the same minimum salary, they will all appear in the result.

### Example Table:

| employee_id | name     | department_id | salary |
|-------------|----------|---------------|--------|
| 1           | Alice    | 101           | 5000   |
| 2           | Bob      | 101           | 3000   |
| 3           | Charlie  | 101           | 3000   |
| 4           | David    | 102           | 4000   |
| 5           | Eve      | 102           | 6000   |

### Result:
For this table, the query will return:

| employee_id | name    | department_id | salary |
|-------------|---------|---------------|--------|
| 2           | Bob     | 101           | 3000   |
| 3           | Charlie | 101           | 3000   |
| 4           | David   | 102           | 4000   |
