SELECT кличка, номер_клетки, дата_рождения, вес, рост, пол,
COUNT (*) OVER() AS общее_число
FROM Обитатели
JOIN (SELECT id_животного, вес, рост
      		FROM (SELECT id_животного, дата_осмотра, вес, рост,
  ROW_NUMBER() over (partition by id_животного order by дата_осмотра desc) as num
     	 FROM медосмотр)
       	WHERE num = 1)med on med.id_животного = Обитатели.id_животного


