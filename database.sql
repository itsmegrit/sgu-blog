create database sgublog;
use sgublog;

select * from article;
select * from user;
select * from category;
select * from image;
select * from feedback;

CREATE TABLE category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255),
    description TEXT,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(255),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    address TEXT,
    is_active TINYINT(1) DEFAULT 1,
    role int,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE article (
    article_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    author_id INT,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    category_id INT,
    status int,
    view_count INT
);

CREATE TABLE image (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    imgUrl VARCHAR(255),
    articleId INT,
    uploadDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title nvarchar(255),
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status int
);

ALTER TABLE article
ADD CONSTRAINT fk_article_category
FOREIGN KEY (category_id) REFERENCES category(category_id);

ALTER TABLE article
ADD CONSTRAINT fk_article_user
FOREIGN KEY (author_id) REFERENCES user(user_id);

ALTER TABLE image
ADD CONSTRAINT fk_image_article
FOREIGN KEY (articleId) REFERENCES article(article_id);

INSERT INTO category (category_name, description)
VALUES
('Tiếng Anh', 'Các bài viết vè tiếng Anh'),
('Công nghệ', 'Các bài viết về công nghệ'),
('Phổ biến', 'Các bài viết phổ biến');

INSERT INTO user (username, password, first_name, last_name, email, phone, address, role)
VALUES
('user1', '123456', 'John', 'Doe', 'john@example.com', '0123456789', '123 Main St', 1),
('user2', '123456', 'Jane', 'Doe', 'jane@example.com', '0123456788', '456 Park Ave', 1),
('user3', '123456', 'Bob', 'Smith', 'bob@example.com', '0123456787', '789 Elm St', 2),
('user4', '123456', 'Mary', 'Johnson', 'mary@example.com', '0123456786', '246 Pine Rd', 2),
('user5', '123456', 'Tom', 'Wilson', 'tom@example.com', '0123456785', '135 Oak Ln', 3);

INSERT INTO article (title, content, author_id, category_id, status, view_count)
VALUES

('Bài viết 1', 'Nội dung bài viết 1', 1, 1, 1, 10),
('Bài viết 2', 'Nội dung bài viết 2', 2, 2, 1, 20),
('Bài viết 3', 'Nội dung bài viết 3', 3, 3, 1, 30),
('Bài viết 4', 'Nội dung bài viết 4', 4, 1, 1, 40),
('Bài viết 5', 'Nội dung bài viết 5', 5, 2, 1, 50),
('Bài viết 6', 'Nội dung bài viết 6', 1, 3, 1, 15),
('Bài viết 7', 'Nội dung bài viết 7', 2, 1, 1, 25),

('Bài viết 8', 'Nội dung bài viết 8', 3, 2, 1, 35),
('Bài viết 9', 'Nội dung bài viết 9', 4, 3, 1, 45),
('Bài viết 10', 'Nội dung bài viết 10', 5, 1, 1, 55),
('Bài viết 11', 'Nội dung bài viết 11', 1, 2, 1, 65),
('Bài viết 12', 'Nội dung bài viết 12', 2, 3, 1, 75),
('Bài viết 13', 'Nội dung bài viết 13', 3, 1, 1, 85),
('Bài viết 14', 'Nội dung bài viết 14', 4, 2, 1, 95),
('Bài viết 15', 'Nội dung bài viết 15', 5, 3, 1, 105),

('Bài viết 16', 'Nội dung bài viết 16', 1, 1, 1, 110),
('Bài viết 17', 'Nội dung bài viết 17', 2, 2, 1, 120),
('Bài viết 18', 'Nội dung bài viết 18', 3, 3, 1, 130),
('Bài viết 19', 'Nội dung bài viết 19', 4, 1, 1, 140),
('Bài viết 20', 'Nội dung bài viết 20', 5, 2, 1, 150);

INSERT INTO image (name, imgUrl, articleId)

VALUES
('Hình 1', 'https://image1.jpg', 1),
('Hình 2', 'https://image2.jpg', 2),
('Hình 3', 'https://image3.jpg', 3),
('Hình 4', 'https://image4.jpg', 4),
('Hình 5', 'https://image5.jpg', 5),
('Hình 6', 'https://image6.jpg', 6),
('Hình 7', 'https://image7.jpg', 7),
('Hình 8', 'https://image8.jpg', 8),
('Hình 9', 'https://image9.jpg', 9),
('Hình 10', 'https://image10.jpg', 10),
('Hình 11', 'https://image11.jpg', 11),
('Hình 12', 'https://image12.jpg', 12),
('Hình 13', 'https://image13.jpg', 13),
('Hình 14', 'https://image14.jpg', 14),
('Hình 15', 'https://image15.jpg', 15),
('Hình 16', 'https://image16.jpg', 16),

('Hình 17', 'https://image17.jpg', 17),
('Hình 18', 'https://image18.jpg', 18),
('Hình 19', 'https://image19.jpg', 19),
('Hình 20', 'https://image20.jpg', 20);

INSERT INTO feedback (title, content, status)
VALUES
('Phản hồi 1', 'Nội dung phản hồi 1', 1),
('Phản hồi 2', 'Nội dung phản hồi 2', 1),
('Phản hồi 3', 'Nội dung phản hồi 3', 1),
('Phản hồi 4', 'Nội dung phản hồi 4', 1),

('Phản hồi 5', 'Nội dung phản hồi 5', 1),
('Phản hồi 6', 'Nội dung phản hồi 6', 1),
('Phản hồi 7', 'Nội dung phản hồi 7', 1),
('Phản hồi 8', 'Nội dung phản hồi 8', 1),
('Phản hồi 9', 'Nội dung phản hồi 9', 1),

('Phản hồi 10', 'Nội dung phản hồi 10', 1),
('Phản hồi 11', 'Nội dung phản hồi 11', 1),
('Phản hồi 12', 'Nội dung phản hồi 12', 1);
