-- creating a new database named student management system with multiple tables and relationships

-- creating a table named students
CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- creating a table named Enrollments
CREATE TABLE enrollments (
    enrollment_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    grade VARCHAR(2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- creating a table named courses
CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    course_code VARCHAR(10) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


-- creating a table named teachers
CREATE TABLE teachers (
    teacher_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- creating a table named courses_teachers
CREATE TABLE courses_teachers (
    course_teacher_id SERIAL PRIMARY KEY,
    course_id INT NOT NULL,
    teacher_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
);

-- Inserting data into the students table

INSERT INTO students (first_name, last_name) VALUES ('John', 'Doe');
INSERT INTO students (first_name, last_name) VALUES ('Jane', 'Doe');
INSERT INTO students (first_name, last_name) VALUES ('Alice', 'Smith');
INSERT INTO students (first_name, last_name) VALUES ('Bob', 'Johnson');

-- Inserting data into the courses table

INSERT INTO courses (course_name, course_code) VALUES ('Mathematics', 'MATH101');
INSERT INTO courses (course_name, course_code) VALUES ('English', 'ENG101');
INSERT INTO courses (course_name, course_code) VALUES ('Science', 'SCI101');
INSERT INTO courses (course_name, course_code) VALUES ('History', 'HIST101');

-- Inserting data into the teachers table

INSERT INTO teachers (first_name, last_name) VALUES ('Mr.', 'Smith');
INSERT INTO teachers (first_name, last_name) VALUES ('Mrs.', 'Johnson');
INSERT INTO teachers (first_name, last_name) VALUES ('Dr.', 'Brown');
INSERT INTO teachers (first_name, last_name) VALUES ('Ms.', 'Davis');

-- Inserting data into the enrollments table

INSERT INTO enrollments (student_id, course_id, grade) VALUES (1, 1, 'A');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (1, 2, 'B');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (2, 3, 'A');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (2, 4, 'B');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (3, 1, 'A');
INSERT INTO enrollments (student_id, course_id, grade) VALUES (3, 3, 'B');  

-- Inserting data into the courses_teachers table

INSERT INTO courses_teachers (course_id, teacher_id) VALUES (1, 1);
INSERT INTO courses_teachers (course_id, teacher_id) VALUES (2, 2);
INSERT INTO courses_teachers (course_id, teacher_id) VALUES (3, 3);
INSERT INTO courses_teachers (course_id, teacher_id) VALUES (4, 4);

-- Retrieve a list of unique course names
SELECT DISTINCT course_name 
FROM courses;

-- Retrieve all enrollments for a specific student
SELECT * FROM enrollments 
WHERE student_id = 1;

-- Retrieve enrollments for a specific student in a specific course or in another specified course
SELECT * FROM enrollments 
WHERE student_id = 1 AND course_id = 101 
OR course_id = 102;

-- Retrieve all courses, ordering them by their creation date in descending order
SELECT * FROM courses
ORDER BY created_at DESC;

-- Update the grade for a specific enrollment
UPDATE enrollments 
SET grade = 'A' 
WHERE student_id = 1 AND course_id = 101;

-- Delete a specific enrollment
DELETE FROM enrollments 
WHERE enrollment_id = 1;

-- Retrieve only the top 5 courses
SELECT * FROM courses ORDER BY created_at DESC LIMIT 5;

-- Retrieve students whose first name starts with 'J'
SELECT * FROM students WHERE first_name LIKE 'J%';

-- Retrieve all students enrolled in a specific course
SELECT * FROM students 
WHERE student_id IN (
    SELECT student_id FROM enrollments WHERE course_id = 101
);

-- Retrieve all enrollments made between two dates
SELECT * FROM enrollments WHERE created_at BETWEEN '2024-01-01' AND '2024-12-31';

-- Using aliases for columns and tables
SELECT s.first_name AS "First Name", s.last_name AS "Last Name", c.course_name AS "Course Name"
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
JOIN courses c ON e.course_id = c.course_id;

-- Inner Join to retrieve students with their courses
SELECT s.first_name, s.last_name, c.course_name 
FROM students s
INNER JOIN enrollments e ON s.student_id = e.student_id
INNER JOIN courses c ON e.course_id = c.course_id;

-- Left Join to retrieve all courses and the corresponding teachers if any
SELECT c.course_name, t.first_name, t.last_name 
FROM courses c
LEFT JOIN courses_teachers ct ON c.course_id = ct.course_id
LEFT JOIN teachers t ON ct.teacher_id = t.teacher_id;

-- Create an index on the students' last name for faster searches
CREATE INDEX idx_last_name ON students (last_name);

-- Retrieve all student and teacher names
SELECT first_name, last_name FROM students
UNION
SELECT first_name, last_name FROM teachers
ORDER BY last_name;

-- Retrieve the number of students enrolled in each course
SELECT course_id, COUNT(*) AS student_count
FROM enrollments
GROUP BY course_id;

-- Retrieve students without an enrollment
SELECT * FROM students 
WHERE student_id NOT IN (SELECT student_id FROM enrollments);

-- Retrieve courses with more than 10 enrollments
SELECT course_id, COUNT(*) AS enrollment_count
FROM enrollments
GROUP BY course_id
HAVING COUNT(*) > 10;

-- Create and call a stored procedure to get student details by student ID
DELIMITER //
CREATE PROCEDURE GetStudent(IN studentID INT)
BEGIN
    SELECT * FROM students WHERE student_id = studentID;
END //
DELIMITER ;

-- Calling the stored procedure
CALL GetStudent(1);

-- Creating and using views

-- Creating a view
CREATE VIEW Student_Enrollments AS
SELECT 
    s.first_name, s.last_name, c.course_name, e.grade
FROM 
    students s
JOIN 
    enrollments e ON s.student_id = e.student_id
JOIN 
    courses c ON e.course_id = c.course_id;

-- Select data from view
SELECT * FROM Student_Enrollments;

-- Filter data from view
SELECT * FROM Student_Enrollments
WHERE first_name = 'John';

-- Retrieve the count of students enrolled in each course using aggregation on view
SELECT course_name, COUNT(*) AS student_count
FROM Student_Enrollments
GROUP BY course_name;

-- Update data in view
UPDATE enrollments
SET grade = 'B'
WHERE enrollment_id = 1;

-- Delete data from view
DELETE FROM enrollments
WHERE enrollment_id = 1;

-- Drop the index created on the students' last name
DROP INDEX idx_last_name ON students;