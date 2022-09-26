# Write your MySQL query statement below
SELECT user_id AS buyer_id,join_date,(SELECT COUNT(*) FROM Orders WHERE buyer_id=user_id AND year(order_date)=2019) AS orders_in_2019 FROM USERS;