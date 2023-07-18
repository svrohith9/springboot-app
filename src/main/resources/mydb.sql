show tables;

CREATE TABLE IF NOT EXISTS lead_detail
(
    id            INT PRIMARY KEY,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    email_address VARCHAR(100),
    phone_number  VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS consultant_detail
(
    id            INT PRIMARY KEY,
    lead_id       INT,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    email_address VARCHAR(100),
    phone_number  VARCHAR(20),
    FOREIGN KEY (lead_id) REFERENCES lead_detail (id)
    );


CREATE TABLE IF NOT EXISTS submission
(
    id                     INT PRIMARY KEY,
    consultant_id          INT,
    submission_date        DATE,
    vendor_company         VARCHAR(100),
    vendor_name            VARCHAR(50),
    vendor_email_address   VARCHAR(100),
    vendor_phone_number    VARCHAR(20),
    implementation_partner VARCHAR(100),
    client_name            VARCHAR(100),
    pay_rate               DECIMAL(10, 2),
    submission_status      VARCHAR(20),
    submission_type        VARCHAR(20),
    city                   VARCHAR(50),
    state                  VARCHAR(50),
    zip                    VARCHAR(20),
    FOREIGN KEY (consultant_id) REFERENCES consultant_detail (id)
    );

CREATE TABLE IF NOT EXISTS submission_update
(
    id            INT PRIMARY KEY,
    submission_id INT,
    update_text   VARCHAR(200),
    created_date  DATE,
    FOREIGN KEY (submission_id) REFERENCES submission (id)
    );

show tables;


-- Inserting sample data into lead_detail table
INSERT INTO lead_detail (id, first_name, last_name, email_address, phone_number)
VALUES (1, 'John', 'Doe', 'johndoe@example.com', '123-456-7890'),
       (2, 'Jane', 'Smith', 'janesmith@example.com', '987-654-3210');

-- Inserting sample data into consultant_detail table
INSERT INTO consultant_detail (id, lead_id, first_name, last_name, email_address, phone_number)
VALUES (1, 1, 'Consultant1', 'Lastname1', 'consultant1@example.com', '111-111-1111'),
       (2, 2, 'Consultant2', 'Lastname2', 'consultant2@example.com', '222-222-2222');

-- Inserting sample data into submission table
INSERT INTO submission (id, consultant_id, submission_date, vendor_company, vendor_name, vendor_email_address,
                        vendor_phone_number, implementation_partner, client_name, pay_rate, submission_status,
                        submission_type, city, state, zip)
VALUES (1, 1, '2023-07-01', 'Vendor Company 1', 'Vendor 1', 'vendor1@example.com', '111-111-1111',
        'Implementation Partner 1', 'Client 1', 100.00, 'Submitted', 'Type 1', 'City 1', 'State 1', '12345'),
       (2, 2, '2023-07-02', 'Vendor Company 2', 'Vendor 2', 'vendor2@example.com', '222-222-2222',
        'Implementation Partner 2', 'Client 2', 200.00, 'Submitted', 'Type 2', 'City 2', 'State 2', '67890');

-- Inserting sample data into submission_update table
INSERT INTO submission_update (id, submission_id, update_text, created_date)
VALUES (1, 1, 'Update 1 for Submission 1', '2023-07-05'),
       (2, 2, 'Update 1 for Submission 2', '2023-07-06');


select * from consultant_detail;

-- query to update email_address on the consultant_detail table
Update consultant_detail set email_address='updated@email.com' where email_address='consultant1@example.com';

-- find total number of submissions for each constulant.

-- select *, count(*)
-- from consultant_detail inner join submission s
--     on consultant_detail.id = s.consultant_id;
show tables;

CREATE TABLE IF NOT EXISTS lead_detail
(
    id            INT PRIMARY KEY,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    email_address VARCHAR(100),
    phone_number  VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS consultant_detail
(
    id            INT PRIMARY KEY,
    lead_id       INT,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    email_address VARCHAR(100),
    phone_number  VARCHAR(20),
    FOREIGN KEY (lead_id) REFERENCES lead_detail (id)
    );


CREATE TABLE IF NOT EXISTS submission
(
    id                     INT PRIMARY KEY,
    consultant_id          INT,
    submission_date        DATE,
    vendor_company         VARCHAR(100),
    vendor_name            VARCHAR(50),
    vendor_email_address   VARCHAR(100),
    vendor_phone_number    VARCHAR(20),
    implementation_partner VARCHAR(100),
    client_name            VARCHAR(100),
    pay_rate               DECIMAL(10, 2),
    submission_status      VARCHAR(20),
    submission_type        VARCHAR(20),
    city                   VARCHAR(50),
    state                  VARCHAR(50),
    zip                    VARCHAR(20),
    FOREIGN KEY (consultant_id) REFERENCES consultant_detail (id)
    );

CREATE TABLE IF NOT EXISTS submission_update
(
    id            INT PRIMARY KEY,
    submission_id INT,
    update_text   VARCHAR(200),
    created_date  DATE,
    FOREIGN KEY (submission_id) REFERENCES submission (id)
    );

show tables;


-- Inserting sample data into lead_detail table
INSERT INTO lead_detail (id, first_name, last_name, email_address, phone_number)
VALUES (1, 'John', 'Doe', 'johndoe@example.com', '123-456-7890'),
       (2, 'Jane', 'Smith', 'janesmith@example.com', '987-654-3210');

-- Inserting sample data into consultant_detail table
INSERT INTO consultant_detail (id, lead_id, first_name, last_name, email_address, phone_number)
VALUES (1, 1, 'Consultant1', 'Lastname1', 'consultant1@example.com', '111-111-1111'),
       (2, 2, 'Consultant2', 'Lastname2', 'consultant2@example.com', '222-222-2222');

-- Inserting sample data into submission table
INSERT INTO submission (id, consultant_id, submission_date, vendor_company, vendor_name, vendor_email_address,
                        vendor_phone_number, implementation_partner, client_name, pay_rate, submission_status,
                        submission_type, city, state, zip)
VALUES (1, 1, '2023-07-01', 'Vendor Company 1', 'Vendor 1', 'vendor1@example.com', '111-111-1111',
        'Implementation Partner 1', 'Client 1', 100.00, 'Submitted', 'Type 1', 'City 1', 'State 1', '12345'),
       (2, 2, '2023-07-02', 'Vendor Company 2', 'Vendor 2', 'vendor2@example.com', '222-222-2222',
        'Implementation Partner 2', 'Client 2', 200.00, 'Submitted', 'Type 2', 'City 2', 'State 2', '67890');

-- Inserting sample data into submission_update table
INSERT INTO submission_update (id, submission_id, update_text, created_date)
VALUES (1, 1, 'Update 1 for Submission 1', '2023-07-05'),
       (2, 2, 'Update 1 for Submission 2', '2023-07-06');


select * from consultant_detail;

-- query to update email_address on the consultant_detail table
Update consultant_detail set email_address='updated@email.com' where email_address='consultant1@example.com';

-- find total number of submissions for each constulant.

select consultant_id,consultant_detail.first_name, count(*)
from consultant_detail inner join submission s
    on consultant_detail.id = s.consultant_id
group by consultant_detail.first_name;

delete from submission where pay_rate is null;