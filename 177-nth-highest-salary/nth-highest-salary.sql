CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare i int;
set i = N - 1;
  RETURN (
      select distinct salary from employee order by salary desc limit 1 offset i
  );
END