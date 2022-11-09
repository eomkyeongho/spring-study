CREATE TABLE tbl_board(
boardId Long auto_increment,
title varchar(30) not null,
writer varchar(30) not null,
content varchar(100) not null,
primary key(boardId)
);