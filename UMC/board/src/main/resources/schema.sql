CREATE TABLE tbl_board(
boardId Long auto_increment,
title varchar (30) not null,
content varchar (30) not null,
name varchar (30) not null,
read varchar (30) not null default 0,
primary key(boardId)
);