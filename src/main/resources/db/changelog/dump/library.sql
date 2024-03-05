CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       genre VARCHAR(255) NOT NULL,
                       year_of_publishing INT NOT NULL

);
