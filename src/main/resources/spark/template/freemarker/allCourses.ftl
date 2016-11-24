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
    <h2 id = "nothing">Current Courses</h2>
    <table class="table" id ="allCourses">
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
            <td>Data Analytics</td>
            <td>Statistical Learning</td>
            <td>Aziz</td>
            <td>30 hr</td>
            <td>2016-10-27</td>
            <td><button type="button" class="btn btn-danger">Enroll</button></td>

        </tr>
        <tr>
            <td>Machine Learning</td>
            <td>Big Data</td>
            <td>Mike</td>
            <td>6 hr</td>
            <td>2016-10-28</td>
            <td><button type="button" class="btn btn-danger">Enroll</button></td>

        </tr>
        <tr>
            <td>Cloud Computing</td>
            <td>Advanced Computing</td>
            <td>Ann</td>
            <td>10 hr</td>
            <td>2016-10-29</td>
            <td><button type="button" class="btn btn-danger">Enroll</button></td>

        </tr>
        <tr>
            <td>Database Management Systems</td>
            <td>Big Data</td>
            <td>Sam</td>
            <td>10 hr</td>
            <td>2016-11-02</td>
            <td><button type="button" class="btn btn-danger">Enroll</button></td>

        </tr>
        <tr>
            <td>Statistical Inference</td>
            <td>Statistical Learning</td>
            <td>Aziz</td>
            <td>23 hr</td>
            <td>2016-11-13</td>
            <td><button type="button" class="btn btn-danger">Enroll</button></td>

        </tr>
        </tbody>
    </table>
    <button type="button" id = "activeNow" class="btn btn-danger">Show me all the active courses</button>
</div>



  <#include "footer.ftl">
</body>
</html>
