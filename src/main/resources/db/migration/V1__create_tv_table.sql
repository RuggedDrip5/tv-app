CREATE TABLE IF NOT EXISTS televisions (
                                           id SERIAL PRIMARY KEY,
                                           brand VARCHAR(255) NOT NULL,
                                           model VARCHAR(255) NOT NULL,
                                           price DECIMAL(10, 2) NOT NULL,
                                           screen_size INTEGER NOT NULL,
                                           resolution VARCHAR(50) NOT NULL,
                                           smart_tv BOOLEAN NOT NULL,
                                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);