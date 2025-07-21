-- Habilita extensão UUID (caso queira usar UUID como chave primária)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Tabela principal: eventos recebidos de dispositivos
CREATE TABLE IF NOT EXISTS device_event (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    device_id VARCHAR(255) NOT NULL,
    ip_address VARCHAR(255),
    os_type VARCHAR(100),
    location VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de score calculado do dispositivo
CREATE TABLE IF NOT EXISTS device_score (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    device_id VARCHAR(255) NOT NULL UNIQUE,
    score INTEGER CHECK (score >= 0 AND score <= 100),
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de alertas ou flags associadas ao dispositivo
CREATE TABLE IF NOT EXISTS device_alert (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    device_id VARCHAR(255) NOT NULL,
    alert_type VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para melhorar busca por device_id
CREATE INDEX IF NOT EXISTS idx_device_event_device_id ON device_event(device_id);
CREATE INDEX IF NOT EXISTS idx_device_alert_device_id ON device_alert(device_id);

-- Dados de exemplo (mock)
INSERT INTO device_event (device_id, ip_address, os_type, location)
VALUES
  ('device-001', '192.168.0.10', 'Android', 'São Paulo'),
  ('device-002', '10.0.0.20', 'iOS', 'Rio de Janeiro');

INSERT INTO device_score (device_id, score)
VALUES
  ('device-001', 87),
  ('device-002', 42);

INSERT INTO device_alert (device_id, alert_type, description)
VALUES
  ('device-002', 'IP_MISMATCH', 'IP address changed unexpectedly'),
  ('device-001', 'ROOT_DETECTED', 'Device appears to be rooted');
