<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center ">
    <h1>Courses Management</h1>
    <p>Admin</p>
</div>


<div class="container">
    <h2>Manage Courses</h2>
    <table class="table" id ="courseManagement">
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
            <td class = "deleteRow"><button type="button" class="btn btn-danger">Delete</button></td>

        </tr>

        <tr>
            <td>Human Information Processing</td>
            <td>Visualization</td>
            <td>Aziz</td>
            <td>40 hr</td>
            <td>2016-11-27</td>
            <td class = 'deleteRow'><button type='button' class='btn btn-danger'>Delete</button></td>

        </tr>

        <tr>
            <td>Information Analysis</td>
            <td>Data</td>
            <td>Aziz</td>
            <td>40 hr</td>
            <td>2016-11-27</td>
            <td class = 'deleteRow'><button type='button' class='btn btn-danger'>Delete</button></td>

        </tr>

        </tbody>
    </table>


    <fieldset class="scheduler-border">
        <legend class="scheduler-border">Add a class</legend>
            <form >
                <div class="form-group col-xs-3">
                    <input  class="form-control" id="course" placeholder="Course Name">
                </div>
                <div class="form-group col-xs-3">
                    <input  class="form-control" id="area" placeholder="Area">
                </div>
                <div class="form-group col-xs-3">
                    <input  class="form-control" id="instructor" placeholder="instructor">
                </div>
                <div class="form-group col-xs-3">
                    <input  class="form-control" id="duration" placeholder="duration">
                </div>
                <div class="form-group col-xs-3">
                    <input  class="form-control" id="startingDate" placeholder="Starting Date">
                </div>
            </form>

            <div>
                <button type="submit" class="btn btn-primary addRow">Add a Class</button>
            </div>
    </fieldset>

</div>

  <#include "footer.ftl">
</body>
</html>
