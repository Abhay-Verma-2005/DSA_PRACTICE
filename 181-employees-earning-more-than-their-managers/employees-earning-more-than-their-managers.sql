Select name as Employee from (Select e.name,e.salary,m.salary as manager_salary from Employee e 
Join Employee m on e.managerId = m.Id) t
where salary > manager_salary;