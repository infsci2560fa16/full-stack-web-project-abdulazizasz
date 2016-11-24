<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center ">
      <h1>Ischooera <small>University of Pittsburgh</small></h1>
      <p>Enrich your knowledge by learning!</p>
</div>

<div  class="container">
    <div class = "row">
        <div id = 'coursesToggle' class="col-sm-4">
            <h3>Courses <small>Details</small></h3>
            <img src="img/courses.png" class="img-circle" alt="courses" width="100" height="100">
            <!--<p class = "text-danger">My name is Abdulaziz and I am a student</p>-->
            <p id ="panelCourses" >Explore our current courses to learn more about Data mining world.
            <a href="allCourses.html">Courses</a></p>
        </div>
        <div id = 'practiceToggle' class="col-sm-4">
            <h3 >Practice <small>Details</small></h3>
            <img src="img/practice.png" class="img-circle" alt="practice" width="100" height="100">
            <p id="panelPractice1">Tutorials are designed to help you understand the courses more thoroughly.
                <a href="shortTutorials.html">Tutorials</a></p>
            <p id = "panelPractice2">There are multiple real-world problems that you can practice with to give a better understanding
            of how to implement all the concepts in order to solve real world data mining problems.</p>
        </div>
        <div id = 'teacherToggle' class="col-sm-4">
            <h3>Teachers <small>Details</small></h3>
            <img src="img/teachers.png" class="img-circle" alt="teacher" width="100" height="100">
            <p id = 'panelTeachers1'>All courses and tutorials are taught by knowledgeable teachers who had strong experience in this area.
                <a href="instructors.html">Instructors</a></p>
            <p id = 'panelTeachers2'>Teachers aim to link the courses with tutorials, so it becomes much easier and faster to learn<a href="allCourses.html">Courses</a></p>
        </div>
    </div>

    <div class="h-divider"></div>

    <br/><br/>
    <div class = "quotesCollection">
        <h3>Useful quotes</h3>
        <div class = "row quotes">
            <div class="col-sm-6 ">
                <blockquote>
                    <p>"You can have data without information, but you cannot have information without data"</p>
                    <footer> <b>Daniel Keys Moran</b>, an American computer programmer and science fiction writer.</footer>
                </blockquote>
            </div>
        </div>

        <div class = "row quotes">
            <div class="col-sm-6">
                <blockquote>
                    <p>"All models are wrong!. A few of them are useful"</p>
                    <footer> <b>Aziz</b> a data scientist chief technology.</footer>
                </blockquote>
            </div>
        </div>
        <div class = "row quotes">
            <div class="col-sm-6">
                <blockquote>
                    <p>"The goal is to turn data into information, and information into insight."</p>
                    <footer> <b>Carly Fiorina</b>former executive, president, and chair of Hewlett-Packard Co.</footer>
                </blockquote>
            </div>
        </div>
    </div>

    <div class = "col-md-offset">
        <button  id = "showQuoteNext" name = "next" class="btn btn-danger"> Previous Quote</button>
        <button  id = "showQuotePrevious" name = "previous" class="btn btn-danger"> Next Quote </button>
    </div>



</div>

  <#include "footer.ftl">
</body>
</html>
