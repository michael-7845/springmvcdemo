CREATE DATABASE mvcdemo;
CREATE TABLE `t_user` ( `USER_ID` int(11) NOT NULL AUTO_INCREMENT, `USER_NAME` char(30) NOT NULL, `USER_PASSWORD` char(10) NOT NULL, PRIMARY KEY (`USER_ID`), KEY `IDX_NAME` (`USER_NAME`) ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD) VALUES (1, 'luoguohui', '123456');
INSERT INTO t_user (USER_ID, USER_NAME, USER_PASSWORD) VALUES (2, 'zhangsan', '123456');
