<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center ">
    <h1>About Us</h1>
    <p>Explore our amazing short tutorials</p>
</div>


<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Our Mission
            </h1>
            <p>We try to help people to practice working with data mining courses in meaningful way that help them grasp all the techniques
            and practice with useful tutorials in one website</p>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Our Team</h2>
        </div>
        <div class="col-lg-12 col-sm-6 text-center center-block">
            <img class="img-circle img-responsive img-center" src="img/aziz.png" width="304" height="236" alt="aziz">
            <h3>Aziz
                <small>Web and Tutorial developer</small>
            </h3>
            <p>Develop this webiste from the scratch!. Also, designed all the tutorials and practices.</p>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Contact Us</h2>
        </div>
    </div>

    <div class="row">
        <form class="well form-horizontal" id="contact_form">
            <fieldset>


                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">First Name</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input  name="first_name" placeholder="First Name" class="form-control"  type="text">
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label" >Last Name</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="last_name" placeholder="Last Name" class="form-control"  type="text">
                        </div>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">E-Mail</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input name="email" placeholder="E-Mail Address" class="form-control"  type="text">
                        </div>
                    </div>
                </div>


                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Phone #</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                            <input name="phone" placeholder="(845)555-1212" class="form-control" type="text">
                        </div>
                    </div>
                </div>




                <div class="form-group">
                    <label class="col-md-4 control-label">Message</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                            <textarea class="form-control" name="comment" placeholder="Message"></textarea>
                        </div>
                    </div>
                </div>

                <!-- Success message -->
                <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for contacting us, we will get back to you shortly.</div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-warning" >Send <span class="glyphicon glyphicon-send"></span></button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>

    <hr>

</div>

  <#include "footer.ftl">
</body>
</html>
