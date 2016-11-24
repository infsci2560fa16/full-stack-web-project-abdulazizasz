<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center ">
    <h1>Instructors</h1>
    <p>Our Amazing Instructors</p>
</div>

<div class="container">

    <div class = "row">
        <div class="col-sm-4"  id ='azizToggle'>
            <h2>Aziz</h2>
            <p><small>University of Pittsburgh</small></p>
            <img src="img/aziz.png" class="img-circle" alt="aziz" width="250" height="250">
            <div id = "panelAziz">
                <ul>
                    <li>A Senior Programmer</li>
                    <li>8 years experience</li>
                    <li>aaa169@pitt.edu<small> Email </small></li>
                </ul>
            </div>
        </div>

        <div class="col-sm-4 " id ='mikeToggle'>
            <h2>Mike</h2>
            <p><small>University of California</small></p>
            <img src="img/man.png" class="img-circle" alt="mike" width="250" height="250">
            <div id = "panelMike">
                <ul>
                    <li>A Data analyst</li>
                    <li>Interested in machine learning</li>
                    <li>mike@cla.edu<small> Email </small></li>
                </ul>
            </div>
        </div>

        <div class="col-sm-4" id ='annToggle'>
            <h2>Ann</h2>
            <p><small>Stanford University</small></p>
            <img src="img/woman.png" class="img-circle" alt="ann" width="250" height="250">
            <div id = "panelAnn">
                <ul>
                    <li>A statistician</li>
                    <li>Worked at Yahoo Lab for 19 years</li>
                    <li>ann@stanford.edu<small> Email </small></li>
                </ul>
            </div>
        </div>
    </div>
</div>


  <#include "footer.ftl">
</body>
</html>
