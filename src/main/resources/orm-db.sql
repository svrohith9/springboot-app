/*

CREATE TABLE images (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        image BLOB,
                        upload_date TIMESTAMP,
                        content_type VARCHAR(255)
);

-- Create the school table
CREATE TABLE school (
                        school_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        school_name VARCHAR(255) NOT NULL,
                        established_year INT NOT NULL,
                        principal_name VARCHAR(255) NOT NULL,
                        address TEXT
);

-- Create the student table with a foreign key to school
CREATE TABLE student (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         age INT NOT NULL,
                         school_id BIGINT,
                         FOREIGN KEY (school_id) REFERENCES school(school_id)
);


--  show tables
-- Inserting data into the school table
INSERT INTO school (school_name, established_year, principal_name, address) VALUES
                                                                                ('Prestige International School', 2005, 'Mr. Alan Smith', '123 Prestige Road, Cityville'),
                                                                                ('Greenwood High', 1999, 'Mrs. Jessica Alba', '456 Greenwood Street, Townsville'),
                                                                                ('Harmony Public School', 2010, 'Mr. Mike Ross', '789 Harmony Avenue, Riverside'),
                                                                                ('Sunrise Elementary', 1995, 'Ms. Rachel Zane', '101 Sunrise Blvd, Mountainville'),
                                                                                ('Hilltop Academy', 2008, 'Dr. Louis Litt', '202 Hilltop Lane, Valleyville');

-- Inserting data into the student table
-- Assuming the school IDs generated were 1 to 5 respectively:
INSERT INTO student (name, age, school_id) VALUES
                                               ('John Doe', 15, 1),
                                               ('Jane Doe', 14, 1),
                                               ('Alice Johnson', 16, 2),
                                               ('Bob Brown', 15, 2),
                                               ('Charlie Clark', 17, 2),
                                               ('Diana Prince', 16, 3),
                                               ('Edward Cullen', 17, 3),
                                               ('Fiona Apple', 14, 4),
                                               ('George Best', 15, 4),
                                               ('Hannah Montana', 14, 4),
                                               ('Ian Somerhalder', 16, 5),
                                               ('Jill Valentine', 15, 5),
                                               ('Kevin Hart', 17, 5),
                                               ('Lana Kane', 16, 1),
                                               ('Maria Hill', 17, 1),
                                               ('Ned Stark', 16, 2),
                                               ('Oscar Wilde', 17, 3),
                                               ('Pam Beesly', 16, 4),
                                               ('Quincy Adams', 15, 5),
                                               ('Rita Ora', 17, 1);

*/

-- select * from STUDENT
show tables
