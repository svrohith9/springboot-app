-- Inserting data into the school table
INSERT INTO school (school_name, established_year, principal_name, address)
VALUES
    ('Greenwood High', 1995, 'John Smith', '123 Maple St, Cityville'),
    ('Riverside Academy', 2000, 'Jane Doe', '456 Pine Rd, Townsville'),
    ('Sunshine Public School', 1985, 'Samuel Brown', '789 Cedar Ave, Lakedale'),
    ('Starlight International', 2002, 'Emma Watson', '101 Oak Lane, Hilltop'),
    ('Blue Mountain Elementary', 1990, 'Robert White', '202 Birch Blvd, Foresttown'),
    ('Moonbeam Kindergarten', 2005, 'Lily Green', '303 Spruce Way, Meadowland'),
    ('Oceanside Secondary', 1988, 'Ethan Grey', '404 Palm Pkwy, Beachside'),
    ('Golden Gate Prep', 1992, 'Sophia Black', '505 Redwood Rte, Bridgetown'),
    ('Diamond District School', 2001, 'Michael Silver', '606 Elm Expy, Crystalcity'),
    ('Cosmic Charter School', 1998, 'Ava Purple', '707 Fir Freeway, Starstate');

-- Inserting data into the student table
INSERT INTO student (name, age, school_id)
VALUES
    ('Alice Johnson', 15, 1),
    ('Bob Williams', 14, 1),
    ('Charlie Brown', 15, 2),
    ('David Wilson', 16, 2),
    ('Eve Davis', 17, 3),
    ('Frank White', 18, 3),
    ('Grace Miller', 14, 4),
    ('Harry Smith', 16, 4),
    ('Ivy Clark', 15, 5),
    ('Jack Taylor', 14, 5),
    ('Kathy Martin', 15, 6),
    ('Louis Allen', 16, 6),
    ('Monica King', 17, 7),
    ('Nathan Hall', 18, 7),
    ('Olivia Adams', 14, 8),
    ('Paul Young', 16, 8),
    ('Quincy Scott', 15, 9),
    ('Rachel Lee', 14, 9),
    ('Steve Green', 17, 10),
    ('Tiffany Lewis', 18, 10);
