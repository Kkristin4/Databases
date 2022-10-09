
SELECT кличка, Обитатели.вид,
COUNT (*) OVER() AS общее_число
FROM Обитатели
JOIN Животные ON Обитатели.вид = Животные.вид
WHERE (перевозка in 'Y') AND (дата_уезда is NULL) AND (дата_смерти is NULL)
