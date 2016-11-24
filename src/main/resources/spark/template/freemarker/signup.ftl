<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="container">



    <div id="signupbox"  margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign Up</div>
                <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
            </div>
            <div class="panel-body" >


                <form id="signupform" method='POST' action='/insert_users' class="form-horizontal">

                    <div id="signupalert" style="display:none" class="alert alert-danger">
                        <p>Error:</p>
                        <span></span>
                    </div>
                    <div class="form-group">
                        <label for="firstname" class="col-md-3 control-label">First Name</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="first-name" id="firstname" placeholder="First Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-md-3 control-label">Last Name</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="last-name" id ="lastname" placeholder="Last Name">
                        </div>
                    </div>
                    <div class="form-group">
                         <label for="username" class="col-md-3 control-label">User Name</label>
                         <div class="col-md-9">
                              <input type="text" class="form-control" name="user-name" id ="username" placeholder="User Name">
                    </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">Password</label>
                        <div class="col-md-9">
                            <input type="password" class="form-control" name="user-password" id = "password" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <button id="btn-signup" form = "signupform" type="submit" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp; Sign Up</button>
                        </div>
                    </div>
                    <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>



  <#include "footer.ftl">
</body>
</html>
