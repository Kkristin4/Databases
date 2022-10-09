SELECT название, вес
FROM(SELECT название, кормления * РАЦИОН.вес * 30 as в_месяц, Производство.вес
FROM Рацион
JOIN Обитатели on Обитатели.id_животного = Рацион.id_животного
JOIN Производство on Рацион.название = Производство.название_корма)
WHERE в_месяц  <= вес
