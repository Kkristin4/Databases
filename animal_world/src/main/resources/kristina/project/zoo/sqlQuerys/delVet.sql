delete from ВЕТЕРИНАРЫ WHERE (id_работника in (Select id_работника from РАБОТНИКИ where(имя = ?) AND (фамилия = ?)))