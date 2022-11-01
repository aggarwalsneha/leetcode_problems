# Write your MySQL query statement below
Select customer_id,count(customer_id) AS count_no_trans FROM visits WHERE visit_id NOT IN (Select visit_id FROM Transactions) GROUP BY customer_id;