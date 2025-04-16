CREATE TABLE room (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
     CONSTRAINT uq_room_name UNIQUE (name)
);
