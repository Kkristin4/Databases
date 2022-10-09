SELECT кличка, ПОЛ, ДАТА_РОЖДЕНИЯ,
COUNT (*) OVER() AS общее_число
FROM Обитатели
WHERE (id_животного in( SELECT id_животного
FROM Привитые
WHERE (прививка = ?) AND (дата_уезда is NULL) AND (дата_смерти is NULL)))

