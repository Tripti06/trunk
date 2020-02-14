INSERT INTO TBL_MANAGERDETAILS (
  manager_id,  manager_name, designation) VALUES ('01', 'Pankaj', 'Tech Specialist'),('02', 'Nilesh', 'Manager'),('03', 'Subrat', 'Team Lead');

INSERT INTO TBL_EMPLOYEEDETAILS (emp_id,first_Name, last_Name, role, salary, manager_id_fk) VALUES
  ('1','Tripti', 'Belanke', 'Developer', '50000', '01'),
  ('2','Subrat', 'Das', 'Lead', '80000', '01'),
  ('3','Pankaj', 'Khandelwal', 'Manager', '100000', '02'),
  ('4','Amit', 'Mane', 'Developer', '70000', '03');
  

insert into users(username, password, enabled)values('tripti','{noop}tripti',true);
insert into authorities(username,authority)values('tripti','ROLE_ADMIN');
insert into authorities(username,authority)values('tripti','ROLE_USER');
 
insert into users(username, password, enabled)values('employee','{noop}employee',true);
insert into authorities(username,authority)values('employee','ROLE_USER');