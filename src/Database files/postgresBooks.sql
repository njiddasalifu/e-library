CREATE TABLE books (
    bookID SERIAL NOT NULL PRIMARY KEY,
    ISBN VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    status VARCHAR(255) DEFAULT 'available',
    quantity INT NOT NULL
);
CREATE TABLE borrowers (
  borrowerID SERIAL PRIMARY KEY,
  studentID INT NOT NULL,
  bookID INT NOT NULL,
  borrowDate DATE NOT NULL,
  returnDate DATE NOT NULL,
  FOREIGN KEY (studentID) REFERENCES users.students (studentID),
  FOREIGN KEY (bookID) REFERENCES books (bookID)
);
