SELECT имя, фамилия, ДАТА_НАЙМА, ПОЛ, ДАТА_РОЖДЕНИЯ, ЗАРПЛАТА,
COUNT (*) OVER() AS Число_служащих
FROM РАБОТНИКИ
JOIN РАБОТА on РАБОТА.id_работы = РАБОТНИКИ.id_работы
where (id_работника in (Select id_работника from ДРЕССИРОВЩИКИ))