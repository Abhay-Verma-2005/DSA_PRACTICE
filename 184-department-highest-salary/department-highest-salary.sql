SELECT d.name as Department, e.name AS Employee,e.salary AS Salary
FROM Employee e 
JOIN Department d 
On e.departmentId=d.id
JOIN ( SELECT departmentId,MAX(salary) AS maxSalary
    FROM Employee
    GROUP BY departmentId
) t
ON e.departmentId = t.departmentId
where e.salary = t.maxSalary;




