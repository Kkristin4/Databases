
SELECT кличка
FROM Обитатели
JOIN Животные ON Животные.вид = Обитатели.вид
WHERE (пол in 'F') AND ((дата_рождения +  Нач_размножения * 365  ) <= to_date(?)) AND ((дата_рождения +  кон_размножения * 365 ) >= to_date(?)) AND (дата_смерти is NULL) AND (дата_уезда is NULL)
