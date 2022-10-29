# Write your MySQL query statement below
Select employee_id, 
(CASE WHEN employee_id%2=1 and name NOT LIKE 'M%' THEN Salary
 ELSE 0 END)AS Bonus
 FROM Employees ORDER BY employee_id;