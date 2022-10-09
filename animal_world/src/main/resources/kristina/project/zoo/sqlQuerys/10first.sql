SELECT кличка, Обитатели.вид, возраст_начала,
возраст_конца, дата_рождения,
COUNT(*) over () as общее_число
FROM Обитатели, Рекомендации
WHERE (Обитатели.вид = Рекомендации.вид)AND((SYSDATE-дата_рождения)/365>= возраст_начала)AND((SYSDATE-дата_рождения)/365<= возраст_конца)AND(дата_смерти is NULL)AND(дата_уезда is NULL)
AND ((растительного = 100)OR(живого = 100)OR(мяса = 100)OR(комбикорма = 100)) AND (ОБИТАТЕЛИ.вид = ?)