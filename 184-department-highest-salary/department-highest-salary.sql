-- SELECT d.name as Department, e.name AS Employee,e.salary AS Salary
-- FROM Employee e 
-- JOIN Department d 
-- On e.departmentId=d.id
-- JOIN (SELECT departmentId,MAX(salary) AS maxSalary
--     FROM Employee
--     GROUP BY departmentId
-- ) t
-- ON e.departmentId = t.departmentId
-- where e.salary = t.maxSalary;




-- SELECT D.name AS Department,E.name AS Employee,E.salary AS Salary
-- FROM Employee E
-- JOIN 
--     Department D 
--     ON E.departmentId = D.id
-- WHERE 
--     (E.departmentId, E.salary) IN (
--         SELECT 
--             departmentId, 
--             MAX(salary)
--         FROM 
--             Employee
--         GROUP BY 
--             departmentId
--     );



SELECT d.name AS Department, 
       e.name AS Employee, 
       e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE e.salary = (
    SELECT MAX(salary)
    FROM Employee
    WHERE departmentId = e.departmentId
);