Rest Spring Boot 
========

 This rest full application built with Spring Boot 

Technologies 
----
* JAVA (Back end language)
* Spring MVC 4 (Back end framework)
* Gradle (Back end dependency management) 

How to RUN 
----
* [Install JDK 1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Install Gradle](https://docs.gradle.org/current/userguide/installation.html)
* [Clone this project](https://help.github.com/articles/cloning-a-repository/)
* Go to project root folder and execute the command: ```$gradle build```
* Still on root project folder run ```$ gradle bootRun ```
* Open your web browser and access [localhost:8082](http://localhost:8082/)

If you want to import the project in eclipse run ```$gradle eclipse ``` at project root folder.

no database needed.

End Points
----
* POST /categories
```{ "code": "string", "title": "string", "superCategoryCode": "string" or null } ```
* POST /books
```{ "title": "string", "categoryCodes": ["code1", "code2", ...] } ```
* POST /subscribers
```{ "email": "string", "categoryCodes": ["code1", "code2", ...] }```
* GET /newsletters
