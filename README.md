
## RabbitMQ
```bash
docker pull rabbitmq:3.7.17
docker run  --name my-rabbit -p 5672:5672 -p 5671:5671 -p 15672:15672 -d rabbitmq:3.7.17
```

### RabbitMQ console
localhost:15672 guest/guest