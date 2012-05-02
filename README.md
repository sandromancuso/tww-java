# Spring MVC and Hibernate Heroku template application

This is a template for a web application that uses Spring MVC and Hibernate. The sample code is a simple CRUD page that manipulates records for a single model object.

## Running the application locally

First build with:

    $mvn clean install

Then run it with:

    $java -jar target/dependency/webapp-runner.jar target/*.war

Deploy on heroku:

    $git push heroku master

Push to github
    $git push -u origin master

I hope to be doing something with it when I have some time.
