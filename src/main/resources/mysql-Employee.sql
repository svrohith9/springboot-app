CREATE TABLE Employee
(
    first_name     VARCHAR(50),
    last_name      VARCHAR(50),
    job_start_date DATE,
    salary         DECIMAL(10, 2)
);

ALTER TABLE Employee
    ADD department VARCHAR(50);


INSERT INTO Employee (first_name, last_name, job_start_date, salary, department)
VALUES ('John', 'Doe', '2021-01-01', 5000.00, 'HR'),
       ('Jane', 'Smith', '2020-03-15', 6000.00, 'IT'),
       ('Michael', 'Johnson', '2019-06-30', 7000.00, 'Finance'),
       ('Emily', 'Williams', '2022-02-10', 5500.00, 'Sales'),
       ('David', 'Brown', '2018-11-05', 8000.00, 'Marketing'),
       ('Sarah', 'Lee', '2023-04-20', 4500.00, 'Operations'),
       ('Robert', 'Taylor', '2017-09-15', 6500.00, 'IT'),
       ('Jennifer', 'Davis', '2021-07-01', 5500.00, 'Finance'),
       ('Andrew', 'Wilson', '2019-12-12', 6000.00, 'Sales'),
       ('Karen', 'Anderson', '2020-08-25', 7000.00, 'HR');

SELECT MAX(salary)
FROM Employee;

SELECT *
FROM Employee
WHERE job_start_date >= CURDATE() - INTERVAL '6' MONTH;


select department, count(*)
from Employee
group by DEPARTMENT;
