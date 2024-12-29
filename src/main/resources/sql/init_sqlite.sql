CREATE TABLE IF NOT EXISTS users
(
    id INTEGER PRIMARY KEY,
    username TEXT UNIQUE,
    password TEXT,
    role TEXT,
    avatar_url TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS movies
(
    vod_id INTEGER PRIMARY KEY,
    vod_name TEXT,
    type_name TEXT,
    vod_time TEXT,
    vod_remarks TEXT
);