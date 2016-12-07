<h1> Current APIs </h1>
<hr>
<br/>

<h2> JSON </h2>
<div class = "row">
    <div class="col-sm-3">
        <h3> Users <small><a href = "/all-users">JSON Format</a></small> </h3>

        <div id="users-list"></div>
        <button type="submit" class="btn btn-primary" onclick="listAllUsers()">See all Users</button>
    </div>

    <div class="col-sm-5">
      <h3> Courses <small><a href = "/all-courses">JSON Format</a></small> </h3>
      <div id="courses-list"></div>
      <button type="submit" class="btn btn-primary" onclick="listAllCourses()">See all Courses</button>
    </div>

    <div class="col-sm-4">
        <h3> Instructors <small><a href = "/all-instructors">JSON Format</a></small> </h3>
       <div id="instructors-list"></div>
       <button type="submit" class="btn btn-primary" onclick="listAllInstructors()">See all Instructors</button>
    </div>

</div>


<hr>
<h2> XML </h2>
<div class = "row">
    <div class="col-sm-3">
        <h3>Courses <small><a href = "/courses_xml">xml format</a></small></h3>

        <div id="courses_names"></div>
        <button type="submit" class="btn btn-primary" onclick="loadXML()">See courses names</button>
    </div>
    <div class="col-sm-3">
            <h3>Topics</h3>

            <div id="areas_names"></div>
            <button type="submit" class="btn btn-primary" onclick="loadXML_areas()">See Topics names</button>
        </div>
</div>
