CREATE TABLE scheduling (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    room_id VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    CONSTRAINT fk_scheduling_room FOREIGN KEY (room_id) REFERENCES room(id)
);
