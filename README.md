# Rest API
Made by Ninon Vrignaud and Simon Duval for CS 8803-MAS.
## Repository presentation

This repository contains the code to launch our common REST API.
We based our implementation on the [firebase4j](https://github.com/bane73/firebase4j) library which provides an interface to the Google firebase REST API in java.

## What we added

We added the framework Spring in order to launch our server and we used the functions provided by the library to create the package "Controller" with the class UserController in order to make the HTTP requests. We have implemented the methods GET to get all the users in the Firebase Realtime Database, and GET by username to get only one user with its username. 

## How to run
* Download this repository
* This is a maven project, so you should have maven installed
* Run the main function in src/net/thegreshams/firebase4j/FirebaseMain.java 

This will launch the webservice at localhost:8080.
