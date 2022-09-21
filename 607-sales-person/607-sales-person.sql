# Write your MySQL query statement below
SELECT name from SalesPerson where sales_id NOT IN (SELECT sales_id FROM ORDERS where com_id IN (SELECT com_id FROM Company where name="RED"));