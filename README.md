# SofkaU-DomainDrivenDesign-Challenge

## Table of Contents
1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [Dependencies](#dependencies)
4. [Execution](#execution)

### General Info
***
#### This is a Spring Boot Domain Driven Design implementation that consists of the following:
#### Domain model of a general store
#### The following aggregate roots and their respective entities are defined within the domain:
### Store
* Product
* Invoice
### Cart
* Item
* Offer
### User
* Order
* Pqr

#### Use case and unit test implementation:
* Create an invoice
* Create a cart
* Update a user name
* Create an item
* Notify invoice process
* Create an offer
* Create an order
* Create a pqr
* Notify offer process
* Create a user
* Create a store
* Create a product

## Technologies
***
* Maven Project
* Java 11
* Spring Boot 2.6.7

## Dependencies
***
* spring-boot-starter
* spring-boot-starter-test
* sofka-domain
* sofka-business
* mockito-junit-jupiter
* junit-jupiter
* mockito-core


## Execution
***
The Spring Boot Domain Driven Design implementation can be test by running the unit tests to all the different implemented use cases.
