SELECT название_корма, вес,
COUNT(*) over () as общее_число
FROM Производство
