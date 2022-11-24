CREATE TABLE eqmanager.USER_TBL (
    id serial PRIMARY KEY,
    phone VARCHAR(60) unique not null
);

CREATE TABLE eqmanager.MARKERS (
    id serial primary key,
    X_Coordinate VARCHAR(60) not null default '',
    Y_Coordinate VARCHAR(60) not null default '',
    comments VARCHAR(200) not null default '',
    plusCount INT not null default 0,
    minusCount INT not null default 0,
    approved BOOLEAN not null default false
);

INSERT INTO eqmanager.markers (x_coordinate, y_coordinate, comments, pluscount, minuscount, approved) values ( '62.03', '129.67', 'uchugey', 0, 0, false)

