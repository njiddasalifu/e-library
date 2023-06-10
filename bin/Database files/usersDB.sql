use users;
create table students(
studentID int not null,
bookID int not null,
studentName varchar(40) not null,
Phone varchar(20) not null,
email varchar(20) null,
Address varchar(20),
Interest varchar(20) null default 'Read',
primary key(studentID),
foreign key(bookID) references books.books(bookID)
);
show tables;
desc students;
drop table students;
create table admin(
adminID int not null,
adminName varchar(40) not null,
Phone varchar(20) not null,
email varchar(20) null,
Address varchar(20),
primary key(adminID)
);
drop table admin;
desc admin;


