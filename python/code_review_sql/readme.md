# SQL Assignment of the code review

## Objective:
The goal of this assignment is to help you practice writing SQL queries based on a given database schema. The schema includes tables for employees, departments, projects, a one-to-many relationship between employees and departments and a many-to-many relationship between employees and projects.

## Database Schema:
1. **employees**
   - `id` INT PK
   - `first_name` VARCHAR(45)
   - `last_name` VARCHAR(45)
   - `job_title` VARCHAR(45)
   - `salary` INT
   - `start_date` DATE
   - `department_dep_code` CHAR(3) FK
   - `update_at` DATETIME

2. **departments**
   - `dep_code` CHAR(3) PK
   - `dep_name` VARCHAR(45)

3. **projects**
   - `id` INT PK
   - `proj_name` VARCHAR(45)
   - `start_date` DATE
   - `end_date` DATE
   - `created_at` DATETIME
   - `update_at` DATETIME

4. **employees_projects**
   - `employee_id` INT FK
   - `project_id` INT FK

## Assignment Questions:

1. **Add records to the database:**
   Write SQL queries to add at least five records to each of the `employees`, `departments`, `projects`, and `employees_projects` tables.

2. **Retrieve all employees:**
   Write a SQL query to retrieve all columns from the `employees` table.

3. **Find employees in a specific department:**
   Write a SQL query to retrieve the first name, last name, and job title of employees who belong to the department with code 'HR'.

4. **List all projects:**
   Write a SQL query to retrieve all columns from the `projects` table.

5. **Find employees working on a specific project:**
   Write a SQL query to retrieve the first name and last name of employees who are working on the project with ID 5.

6. **Count the number of employees in each department:**
   Write a SQL query to count the number of employees in each department and display the department code and the count.

7. **Find the highest salary:**
   Write a SQL query to find the highest salary in the `employees` table.

8. **Update an employee's job title:**
   Write a SQL query to update the job title of the employee with ID 10 to 'Senior Developer'.

9. **Delete a project:**
   Write a SQL query to delete the project with ID 3 from the `projects` table.

10. **One-to-Many Left Join Departments with Employees:**
    Write a SQL query to perform a LEFT JOIN between the `departments` and `employees` tables to retrieve all departments and their employees, including departments without employees.

11. **Many-to-Many Join Employees - Projects:**
    Write a SQL query to retrieve all employees and the projects they are working on, including employees without projects and projects without employees.