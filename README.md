# AMPOS Restaurant Demo Project

## Required Environment

- Git
- JDK 1.8+
- Maven 3.5.2+
- Docker installed with Docker Engine 1.13.0+ 

## Quick Start

Have Maven installed the project, and then docker-compose up.

```bash
$ git clone https://github.com/idontwannarock/demo-ampos-restaurant.git
$ mvn clean install -DskipTests -Pdocker
$ docker-compose up
```

## Documentation

[Static Documentation](https://idontwannarock.github.io/demo-ampos-restaurant/)

After docker compose are up and running, you can find live Swagger tester and documentation in below link.

[Live Swagger Documentation](http://localhost:9000/swagger-ui.html)

If you are using Docker Toolbox, you will find live Swagger tester and documentation in below link instead.

[Docker Toolbox's Live Swagger Documentation](http://192.168.99.100:9000/swagger-ui.html)

### Offline Document Generation

Run below script will generate Swagger static HTML doc in docs folder.

```bash
$ mvn clean test -Pdocument -Dfile.encoding=UTF-8
```