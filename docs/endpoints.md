# Endpoints da Sentinel API

## POST `/device-event`

Registra um novo evento de dispositivo.

### Request

```json
{
  "deviceId": "abc-123",
  "ip": "192.168.0.1",
  "os": "iOS",
  "location": "SP, Brazil",
  "isRooted": false
}
```

### Response

```json
{
  "status": "RECEIVED"
}
```

## GET `/device-score/{deviceId}`

Consulta a pontuação de confiança de um dispositivo.

### Response

```json
{
  "score": 87,
  "level": "MEDIUM",
  "flags": ["IP_CHANGE"]
}
```

## GET `/device-alerts/{deviceId}`

Retorna os alertas gerados pelo dispositivo.

### Response

```json
[
  {
    "type": "ROOTED_DEVICE",
    "severity": "HIGH"
  },
  {
    "type": "LOCATION_MISMATCH",
    "severity": "MEDIUM"
  }
]
```