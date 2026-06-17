# Write your MySQL query statement below
Select distinct Max(salary) as SecondHighestSalary from employee where salary<(Select Max(salary) from employee); 