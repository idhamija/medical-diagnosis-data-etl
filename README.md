# Medical Diagnosis Test Data ETL Pipeline

An ETL Pipeline which extracts data from medical facility's database, transforms and loads data to the central data warehouse which the [medical-diagnosis-data-api](https://github.com/idhamija/medical-diagnosis-data-api) uses to fetch data.

Created using MySQL database.

### Installation

```
git clone https://github.com/idhamija/medical-diagnosis-data-etl.git
cd medical-diagnosis-data-etl
```

### Setup

Create a `/src/main/resources/application.properties` file in the following format:

```
# sourceDB
spring.source.driver-class-name=<SOURCE_DB_DRIVER_CLASS_NAME>
spring.source.jdbc-url=<SOURCE_DB_JDBC_URL>
spring.source.username=<SOURCE_DB_USERNAME>
spring.source.password=<SOURCE_DB_PASSWORD>

# targetDB
spring.target.driver-class-name=<TARGET_DB_DRIVER_CLASS_NAME>
spring.target.jdbc-url=<TARGET_DB_JDBC_URL>
spring.target.username=<TARGET_DB_USERNAME>
spring.target.password=<TARGET_DB_PASSWORD>

spring.batch.jdbc.initialize-schema=always
spring.batch.job.enabled=false;
```

### Built Using

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Batch](https://spring.io/projects/spring-batch)
