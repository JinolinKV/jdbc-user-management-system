create database if not exists ums;

CREATE TABLE if not exists users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT(3),
    email VARCHAR(100)
);