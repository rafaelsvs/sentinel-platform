CREATE TABLE device_event (
    id UUID PRIMARY KEY,
    device_id VARCHAR(100) NOT NULL,
    ip VARCHAR(45),
    os VARCHAR(100),
    location VARCHAR(255),
    is_rooted BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);