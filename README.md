# MELi-LV2
Mercadolibre - Mutantes - LV2

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Start the application locally

```shell
mvn clean install spring-boot:run
```

## Test basic EndPoint

```shell
curl -X GET  http://localhost:5000
```
It must return a status "200", with an "OK" message.