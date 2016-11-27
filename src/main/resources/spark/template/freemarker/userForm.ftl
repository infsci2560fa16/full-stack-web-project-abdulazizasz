<div class="starter-template">
    <form class="form-horizontal" role="form" id='user-create-form' method='POST' action='/current_users/update/'>

<div class="form-group">
                   <label class="col-sm-3 control-label">ID: </label>
                   <div class="col-sm-5">
                       <input class="form-control" type='text' id="id" name='user-id' placeholder="Enter an id" />
                   </div>
               </div>

        <div class="form-group">
                   <label class="col-sm-3 control-label">user name: </label>
                   <div class="col-sm-5">
                       <input class="form-control" type='text' id="userName" name='user-name' placeholder="Enter a current user name" />
                   </div>
               </div>


        <div class="form-group">
            <label class="col-sm-3 control-label">First name: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="firstName" name='first-name' placeholder="Enter a new name" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Last Name: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="lastName" name='last-name' placeholder="Enter a new last Name" />
            </div>
        </div>
        <div class="form-group">
                    <label class="col-sm-3 control-label">Password: </label>
                    <div class="col-sm-5">
                        <input class="form-control" type='text' id="password" name='password' placeholder="Enter a new password" />
                    </div>
                </div>
    </form>

    <input type='submit' value='Submit' class="btn btn-primary" form='user-create-form' />
</div>