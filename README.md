# MELi-LV3
Mercadolibre - Mutantes - LV3

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Start the application locally

```shell
mvn -Plocal clean install spring-boot:run
```

## Test basic EndPoint

```shell
curl -X GET  http://localhost:5000
```
It must return a status "200", with an "OK" message.

## REST API
### Know if a DNA is mutant o not
#### Request
```
curl --location --request POST 'localhost:5000/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
"dna" : ["ATGCGA","CAGTGC","TTATGT","AGATGG","CCCCTA","TCACGT"]
}
'
```
#### Response
- Status 200 OK if is a mutant
- Status 403 Forbidden if is a human

### Get mutant/human statistics 
#### Request
```
curl --location --request GET 'localhost:5000/stats'
```
#### Response
- Status 200 OK
```JSON
{
    "count_human_dna": 3,
    "count_mutant_dna": 2,
    "ratio": 0.6666666666666666
}
```