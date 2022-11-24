CREATE TABLE IF NOT EXISTS MARKERS(
    id INT primary key AUTO_INCREMENT,
    X_Coordinate VARCHAR(60) not null default '',
    Y_Coordinate VARCHAR(60) not null default '',
    comments VARCHAR(200) not null default '',
    plusCount INT not null default 0,
    minusCount INT not null default 0,
    approved BOOLEAN not null default false
);

CREATE TABLE IF NOT EXISTS USER(
    id INT PRIMARY KEY AUTO_INCREMENT,
    phone VARCHAR(60) not null default ''
);