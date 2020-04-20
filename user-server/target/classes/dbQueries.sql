-- query to create user table
CREATE TABLE user_server.user (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
age INT,
weight DOUBLE)

-- query to create user_login table
CREATE TABLE user_server.user_login(
user_login_id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY(user_id) references user(id))


