<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center ">
    <h1>Courses</h1>
    <p>Explore our amazing courses</p>
</div>


<div class="container">
    <h2>New Courses</h2>
    <table class="table" id ="newCourses">
        <thead>
        <tr>
            <th>Course</th>
            <th>Area</th>
            <th>Instructor</th>
            <th>Duration</th>
            <th>Starting Date</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Natural Language Processing</td>
            <td>Machine Learning</td>
            <td>Aziz</td>
            <td>40 hr</td>
            <td>2016-11-27</td>
            <td><button type="button" class="btn btn-danger">Enroll</button></td>

        </tr>
        <tr>
            <td>Advanced Data Semantic</td>
            <td>Big Data</td>
            <td>Mike</td>
            <td>60 hr</td>
            <td>2016-12-28</td>
            <td><button type="button" class="btn btn-danger">Enroll</button></td>

        </tr>
        <tr>
            <td>Web Semantic</td>
            <td>Advanced Web</td>
            <td>Ann</td>
            <td>12 hr</td>
            <td>2016-11-29</td>
            <td><button type="button" class="btn btn-danger">Enroll</button></td>

        </tr>

        </tbody>
    </table>

</div>



  <#include "footer.ftl">
</body>
</html>
