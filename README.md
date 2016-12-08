[![Build Status](https://travis-ci.org/infsci2560fa16/full-stack-web.svg?branch=master)](https://travis-ci.org/infsci2560fa16/full-stack-web)

# java-getting-started

A barebones Java app, which can easily be deployed to Heroku.  

This application support the [Getting Started with Java on Heroku](https://devcenter.heroku.com/articles/getting-started-with-java) article - check it out.

## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

```sh
$ git clone git@github.com:infsci2560fa16/full-stack-web.git
$ cd java-getting-started
$ mvn install
$ foreman start web
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

If you're going to use a database, ensure you have a local `.env` file that reads something like this:

```
DATABASE_URL=postgres://localhost:5432/java_database_name
```

## Deploying to Heroku

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Documentation

For more information about using Java on Heroku, see these Dev Center articles:

- [Java on Heroku](https://devcenter.heroku.com/categories/java)


#########################################################################################
##########################################################################################
#########################################################################################

### The local url for the database

DATABASE_URL=postgres://localhost:5432/ischoolera 

### Pushing the database to the app using this command

heroku pg:push postgres://localhost:5432/ischoolera DATABASE_URL –app lit-lake-25415