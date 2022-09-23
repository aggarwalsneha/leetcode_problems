# Write your MySQL query statement below

Select name as Customers from Customers where id NOT IN (SELECT customerID FROM Orders GROUP BY CustomerID);
