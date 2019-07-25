[![Scrutinizer Code Quality](https://scrutinizer-ci.com/g/idontwannarock/demo-ampos-restaurant/badges/quality-score.png?b=master)](https://scrutinizer-ci.com/g/idontwannarock/demo-ampos-restaurant/?branch=master)
[![Build Status](https://scrutinizer-ci.com/g/idontwannarock/demo-ampos-restaurant/badges/build.png?b=master)](https://scrutinizer-ci.com/g/idontwannarock/demo-ampos-restaurant/build-status/master)

This is a back-end demo app for the AMPOS restaurant project, providing order related apis.

# Required Environment

- JDK 1.8+
- Maven 3.5.2+
- Docker Desktop or Docker Toolbox installed with Docker Engine 1.13.0+ 
- (Optional) Git

# Quick Start

Run below bash scripts in project directory.

```bash
mvn clean package -DskipTests -Pdocker

docker-compose up
```

Basically it will have Maven packaged the project, and then use docker-compose to run both the app and MySQL container.

# Documentation

For the documentation of APIs, please refer to below link.

[APIs Documentation](https://idontwannarock.github.io/demo-ampos-restaurant/)

If you would like to test APIs, please first run the bash scripts in [Quick Start](#quick-start).

And for different Docker tools, be it Docker Desktop or Docker Toolbox, there are two different URLs to access the live tester and documentation:

- [Docker Desktop's Live Tester and Documentation](http://127.0.0.1:9000/swagger-ui.html)
- [Docker Toolbox's Live Tester and Documentation](http://192.168.99.100:9000/swagger-ui.html)

[//]: # (mvn clean test -Pdocument -Dfile.encoding=UTF-8)