--use basicbank;
--create table `users`  (
--`ID` INT NOT NULL auto_increment,
--`username` varchar(50) not null ,
--`password` varchar(50) not null,
--`enabled` int not null,
--primary key (`ID`)
--);
--
--create table authorities (
--`ID` INT NOT NULL auto_increment,
--`username` varchar(50) not null,
--`authority` varchar(50) not null,
--primary key(`ID`)
--);

--use basicbank;
--create table `customer`  (
--`ID` INT NOT NULL auto_increment,
--`email` varchar(50) not null ,
--`pwd` varchar(50) not null,
--`role` varchar(45) not null,
--primary key (`ID`)
--);
--insert dummy data
--insert ignore into `users` values (null, 'olive', '12345', '1');
--insert ignore into `authorities` values (null, 'olive', 'write')
--INSERT INTO `customer`(`email`, `pwd`, `role`) values ('olive@gmail.com', '12345', 'admin');