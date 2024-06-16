
# Student Management System Normalization

Normalization is a database design technique that reduces data redundancy and improves data integrity by organizing tables and their relationships. In the context of your student management system, normalization involves structuring the database tables to ensure that each piece of data is stored in its most appropriate place, thereby minimizing duplication and ensuring consistency.


### Original Table Design (Not Fully Normalized)

Suppose we had a single table containing student and course data, which might look like this:

```sql
CREATE TABLE student_courses (
    student_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    course_id INT,
    course_name VARCHAR(100),
    course_code VARCHAR(10),
    grade VARCHAR(2)
);
```

### Normalized Design

To normalize the above design, we separate the data into multiple tables to remove redundancy and ensure data integrity.

1. **Students Table**

    ```sql
    CREATE TABLE students (
        student_id SERIAL PRIMARY KEY,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );
    ```

2. **Courses Table**

    ```sql
    CREATE TABLE courses (
        course_id SERIAL PRIMARY KEY,
        course_name VARCHAR(100) NOT NULL,
        course_code VARCHAR(10) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );
    ```

3. **Enrollments Table**

    ```sql
    CREATE TABLE enrollments (
        enrollment_id SERIAL PRIMARY KEY,
        student_id INT NOT NULL,
        course_id INT NOT NULL,
        grade VARCHAR(2),
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        FOREIGN KEY (student_id) REFERENCES students(student_id),
        FOREIGN KEY (course_id) REFERENCES courses(course_id)
    );
    ```

4. **Teachers Table**

    ```sql
    CREATE TABLE teachers (
        teacher_id SERIAL PRIMARY KEY,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );
    ```

5. **Courses_Teachers Table**

    ```sql
    CREATE TABLE courses_teachers (
        course_teacher_id SERIAL PRIMARY KEY,
        course_id INT NOT NULL,
        teacher_id INT NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        FOREIGN KEY (course_id) REFERENCES courses(course_id),
        FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
    );
    ```

## Benefits of Normalization
- **Reduced Data Redundancy**: By storing each piece of information only once, normalization reduces the amount of data duplication in the database.
- **Improved Data Integrity**: Ensuring that each piece of data is stored in a consistent and logical place helps maintain accuracy and consistency across the database.
- **Easier Maintenance**: Updates and changes to the data are simpler and less error-prone because each piece of data is stored in only one place.
