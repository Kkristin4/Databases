select Лечение.id_животного, Болезнь, КЛИЧКА, ЛЕЧЕНИЕ, ДАТА_НАЧАЛА as "ЗАБОЛЕЛ", ДАТА_КОНЦА as "ВЫЗДОРОВЕЛ", ИЗОЛЯЦИЯ FROM ЛЕЧЕНИЕ
join ОБИТАТЕЛИ on ОБИТАТЕЛИ.id_животного = ЛЕЧЕНИЕ.id_животного