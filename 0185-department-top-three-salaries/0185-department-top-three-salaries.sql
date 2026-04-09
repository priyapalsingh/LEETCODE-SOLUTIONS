# Write your MySQL query statement below
select d.name as Department , e.name as Employee , e.salary as Salary from (
    select departmentId,name,salary,dense_rank()
     over (
        partition by departmentId order by salary desc
    )as rnk from employee 
)as e
Join Department as d on e.departmentId=d.id
where e.rnk<=3;
