create database IF NOT EXISTS MovieManager;

use MovieManager;


CREATE TABLE IF NOT EXISTS users
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(255),
    password   VARCHAR(255),
    role       VARCHAR(255),
    avatar_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE (username) -- 确保用户名唯一
);

CREATE TABLE movies
(
    vod_id      INTEGER PRIMARY KEY,
    vod_name    TEXT,
    type_name   TEXT,
    vod_time    TEXT,
    vod_remarks TEXT
);
