# 1. Context

Desktop application for sharing your taste in cinema.  
Users can search for films in the application's database, review films, create lists of their favorite films, and subscribe to other users' lists, for example.  
The application was developed as part of a six-week school project. The project involved developing a Java/Swing application using the MVC programming pattern.

## 1.1. Elevator pitch

1. **For whom ?**  
   For movie lovers 

2. **Who wants to ?**  
    Share their taste in cinema with others

3. **What is it ?**  
    A desktop application that allows users to search for films, review them, create lists of their favorite films, and subscribe to other users' lists.

4. **Unlike ?**
    Unlike other applications that can allow users to share one movie at a time.

5. **Our product**  
    Allows users to share whole lists of movies, and the reason why they like or dislike them. 

# 2. Built with

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)   
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)  
UI was created with **Swing** library for **Java 17**.


# 3. Getting started

## 3.1. Prerequisites

- Java 17
- Maven
- IntelliJ IDEA (GUI Designer .form files are used)

## 3.2. Database setup

1. See [database_setup.md](doc/database/database_setup.md)
2. Setup [dao/DatabaseConnection.java](src/main/java/dao/DatabaseConnection.java) with your database credentials

## 3.3. Building and running

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. `mvn clean install -DskipTests`
4. Build > Rebuild Project
5. Run `Application` class

## 3.4. Generating an executable JAR with dependencies

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Settings > Editor > GUI Designer > Generate GUI into: Java source code
4. `mvn clean compile assembly:single`
5. `java -jar target/M-Library-1.0-SNAPSHOT-jar-with-dependencies.jar`

# 4. Contact

**anton.xu@etu.inp-n7.fr  
farouk.abidi@etu.inp-n7.fr  
ruddy.kinsiclounon@etu.inp-n7.fr  
paul.arago@etu.inp-n7.fr**
