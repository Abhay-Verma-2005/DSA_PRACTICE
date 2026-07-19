Select Distinct(n1) as ConsecutiveNums from (Select a.num as n1, b.num as n2, c.num as n3 from Logs a Join Logs b on a.id=b.id-1 Join Logs c on a.id=c.id-2) t 
where n1=n2 And n1=n3;