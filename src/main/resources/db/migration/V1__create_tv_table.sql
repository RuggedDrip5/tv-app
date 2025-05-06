CREATE TABLE televisions (
                             id BIGSERIAL PRIMARY KEY,
                             brand VARCHAR(255) NOT NULL,
                             model VARCHAR(255) NOT NULL,
                             price DECIMAL(10,2) NOT NULL,
                             screen_size INT NOT NULL,
                             resolution VARCHAR(255) NOT NULL,
                             smart_tv BOOLEAN NOT NULL,
                             created_at TIMESTAMP,
                             updated_at TIMESTAMP
);