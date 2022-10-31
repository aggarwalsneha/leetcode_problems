# Write your MySQL query statement below
SELECT id AS 'Id',
CASE WHEN tree.p_id IS NULL Then 'Root'
WHEN tree.id IN (SELECT t.p_id FROM tree t) THEN 'Inner'
ELSE 'Leaf'
END AS Type FROM Tree ORDER BY 'Id';