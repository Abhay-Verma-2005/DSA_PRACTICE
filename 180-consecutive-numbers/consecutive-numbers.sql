SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1
Join Logs l2 on l1.id= l2.id+1 AND l1.num = l2.num
Join Logs l3 on l1.id= l3.id+2 AND l1.num = l3.num;

