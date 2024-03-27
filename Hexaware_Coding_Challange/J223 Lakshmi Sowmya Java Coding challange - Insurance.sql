-- 25/03/2024
-- Coding Challange - Insurance
-- J223 Lakshmi Sowmya Java Coding challange - Insurance

-------------------------------------------------------------------------

create database if not exists Java_coding_challange;
use Java_coding_challange;
-- drop database Java_coding_challange;
CREATE TABLE User (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
) AUTO_INCREMENT = 1000;


CREATE TABLE Client (
    clientId INT AUTO_INCREMENT PRIMARY KEY,
    clientName VARCHAR(255),
    contactInfo Bigint,
    policy VARCHAR(100)
) AUTO_INCREMENT = 2000;


CREATE TABLE Claim (
    claimId INT AUTO_INCREMENT PRIMARY KEY,
    claimNumber VARCHAR(50),
    dateFiled DATE,
    claimAmount DECIMAL(10,2),
    status VARCHAR(50),
    policy VARCHAR(100),
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
) AUTO_INCREMENT = 3000;


CREATE TABLE Payment (
    paymentId INT AUTO_INCREMENT PRIMARY KEY,
    paymentDate DATE,
    paymentAmount DECIMAL(10,2),
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
) AUTO_INCREMENT = 4000;

CREATE TABLE Policy (
    policy_id INT AUTO_INCREMENT PRIMARY KEY,
    clientId INT,
    start_date DATE,
    end_date DATE,
    policy_type VARCHAR(255),
    policy_status VARCHAR(50),
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);
-- Insert values into the User table
INSERT INTO User (username, password, role) VALUES
('john_doe', 'password123', 'admin'),
('jane_smith', 'qwerty', 'user'),
('alice_wonderland', 'alice123', 'user'),
('bob_marley', 'reggae123', 'user'),
('charlie_brown', 'peanuts', 'user');

-- Insert values into the Client table
INSERT INTO Client (clientName, contactInfo, policy) VALUES
('ABC Insurance Company', 1234567890, 'policy1'),
('XYZ Corporation', 9876543210, 'policy2'),
('Smith & Co.', 5555555555, 'policy3'),
('Johnson Insurance Agency', 1111111111, 'policy4'),
('Doe Enterprises', 2222222222, 'policy5');
select * from client;

-- Insert values into the Claim table
INSERT INTO Claim (claimNumber, dateFiled, claimAmount, status, policy, clientId) VALUES
('CLAIM001', '2024-01-15', 5000.00, 'pending', 'policy1', 2001),
('CLAIM002', '2024-02-20', 8000.00, 'approved', 'policy2', 2002),
('CLAIM003', '2024-03-10', 3000.00, 'pending', 'policy3', 2003),
('CLAIM004', '2024-03-25', 6000.00, 'rejected', 'policy4', 2004),
('CLAIM005', '2024-04-05', 4000.00, 'pending', 'policy5', 2000);

-- Insert values into the Payment table
INSERT INTO Payment (paymentDate, paymentAmount, clientId) VALUES
('2024-01-20', 2000.00, 2001),
('2024-02-15', 1500.00, 2002),
('2024-03-05', 3000.00, 2003),
('2024-04-10', 2500.00, 2004),
('2024-05-01', 1800.00, 2000);

-- Insert values into the Policy table
INSERT INTO Policy (clientid, start_date, end_date, policy_type, policy_status) VALUES
(2001, '2024-01-01', '2025-01-01', 'Auto Insurance', 'active'),
(2002, '2024-02-01', '2025-02-01', 'Health Insurance', 'active'),
(2003, '2024-03-01', '2025-03-01', 'Life Insurance', 'active'),
(2004, '2024-04-01', '2025-04-01', 'Home Insurance', 'active'),
(2000, '2024-05-01', '2025-05-01', 'Travel Insurance', 'active');

select * from policy;