delete from ДОСТУП WHERE (id_работника in (Select id_работника from Работники where (имя = ?)AND(фамилия = ?)))AND(id_животного = (
Select id_животного FROM ОБИТАТЕЛИ WHERE кличка
))