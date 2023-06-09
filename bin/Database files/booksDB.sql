-- --creating the database books 
SELECT * FROM books.books;
show databases;
use books;
-- --use this script to create the books table in books  
CREATE TABLE books (
  bookID int(11) NOT NULL,	
  ISBN char(30) NOT NULL,	
  Title char(20) NOT NULL,	
  Author char(20) NOT NULL,	
  studentID int(11) NOT NULL,	
  PRIMARY KEY (bookID),	
 FOREIGN KEY (studentID) REFERENCES users.students (studentID)	
);

show tables;
desc books;
