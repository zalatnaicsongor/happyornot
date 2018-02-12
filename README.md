# Happy or not
A Spring Boot example application showing the use of Spring Cloud Stream & the Kafka bindings.

## Purpose

The ultimate feedback solution! This application lets the customers leave negative or positive feedback for the owner of the service
who can then query the feedbacks left.

## API documentation

### POST /positive
Leaves a positive feedback.

### POST /negative
Leaves a negative feedback.

### GET /ratings
Retrieves the feedbacks left by customers.
Example response:
```
{
  "positive": 231415,
  "negative": 2
}
```

## CI/CD

[![CircleCI](https://circleci.com/gh/zalatnaicsongor/happyornot/tree/master.svg?style=svg)](https://circleci.com/gh/zalatnaicsongor/happyornot/tree/master)

A simple CI/CD pipeline is set up for this project. Whenever a commit is made to the `master` branch, the service gets automatically built
and then promoted onto GKE by CircleCI.

## Local build

* Clone the repository
* Run the tests: `./mvnw clean verify`
* Run the application: `./mvnw spring-boot:run -Dspring.profiles.active={{profile}}`

Available profiles:

* `local`: Uses an in-process channel to transfer messages from the producer to the consumer, does not have any external dependencies
* `kafka`: Uses Spring Cloud Stream & Kafka to transfer messages from the producer to the consumer. This profiles requires a Kafka broker running.
