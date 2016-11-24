<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center ">
    <h1>Tutorials</h1>
    <p>Explore our amazing short tutorials</p>
</div>


<div class="container" id="shortTutorials">


            <div class="page-header"></div>

        <div class="col-lg-4 col-sm-6 text-center">
            <a href="">
                <img class="img-circle img-responsive img-center" src="./img/ml.png" alt="machine learning" width="420" height="420"
                >
            </a>
            <h3>Machine Learning
                <small>Advanced</small>
            </h3>
            <p>Combine your machine learning skills with more advanced skills</p>
        </div>
        <div class="col-lg-4 col-sm-6 text-center">
            <a href="">
                <img class="img-circle img-responsive img-center" src="./img/Data-Analyst.png" alt="data-analyst" width="420" height="420" >
            </a>
            <h3>Data Analyst
                <small>Intermediate</small>
            </h3>
            <p>Learn basic data manipulation and exploration</p>
        </div>
        <div class="col-lg-4 col-sm-6 text-center">
            <a href="" >
                <img class="img-circle img-responsive img-center" src="./img/R.png" alt="R" width="420" height="420">
            </a>
            <h3>R Programming
                <small>Basic</small>
            </h3>
            <p>Enhance your programming skills by learning how to work with data</p>
        </div>
    </div>


  <#include "footer.ftl">
</body>
</html>
