CREATE DATABASE IF NOT EXISTS petistaan;
USE petistaan;

CREATE TABLE owner_table (
    id INT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(10) NOT NULL UNIQUE,
    email_id VARCHAR(255) NOT NULL UNIQUE,
    pet_id INT NOT NULL,
    pet_name VARCHAR(255) NOT NULL,
    pet_date_of_birth DATE NOT NULL,
    pet_gender VARCHAR(255) NOT NULL,
    pet_type VARCHAR(255) NOT NULL 
);

SELECT * FROM owner_table;