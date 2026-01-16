CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select distinct salary
      from (select salary, dense_rank() over(order by salary desc) ranks 
      from Employee) as t
       #yaha par t alias ki trh use kia hai 
      where t.ranks=N
      limit 1

  );
END