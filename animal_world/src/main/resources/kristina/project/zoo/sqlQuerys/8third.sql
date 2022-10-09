SELECT поставщик, kg as "ВСЕГО ПОСТАВИЛ", manny as "ЦЕНА", ДАТА_ПОСТАВКИ,
COUNT(*) over () as общее_число
FROM(SELECT поставщик, вес, название_корма, дата_поставки,
  ROW_NUMBER() over (partition by поставщик order by дата_поставки desc) as num,
  SUM(вес) over(partition by поставщик) as kg,
  SUM(цена) over (partition by поставщик)as manny
   		 FROM поставки
   		 WHERE (дата_поставки > to_date(?) ) and (дата_поставки < to_date(?)) and (название_корма = ?))
WHERE num = 1