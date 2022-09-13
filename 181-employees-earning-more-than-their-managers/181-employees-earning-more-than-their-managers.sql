# Write your MySQL query statement below
SELECT e.name AS Employee from Employee e where e.salary>(SELECT salary from Employee where id=e.managerId);