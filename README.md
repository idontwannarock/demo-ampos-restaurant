# AMPOS Restaurant Demo Project

## Required Environment

- JDK 1.8+
- Maven 3+
- Docker installed 

## Quick Start

Run MySQL container.

```bash
$ docker run -d -p 8889:3306 --name docker-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=demo_ampos_restaurant mysql:latest
```

Have Maven installed the project, and then build project image and run.

```bash
$ git clone https://github.com/idontwannarock/demo-ampos-restaurant.git
$ mvn clean installed -DskipTests
$ docker build -f Dockerfile -t docker-app .
$ docker run -t --name docker-app-container --link docker-mysql:mysql -p 9000:9000 docker-app
```

## Documentation

After application and mysql are up and running, you can find Swagger documentation in below link for more details of apis and models.

[Swagger Documentation](http://localhost:9000/swagger-ui.html)