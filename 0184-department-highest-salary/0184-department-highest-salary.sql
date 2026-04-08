# Write your MySQL query statement below
select d.name as Department,e.name as Employee,e.salary as Salary
 from Employee as e join department as d
 ON e.departmentId=d.id
  where (e.departmentId,e.salary) IN 
(select departmentId , MAX(salary) from employee group by departmentId);