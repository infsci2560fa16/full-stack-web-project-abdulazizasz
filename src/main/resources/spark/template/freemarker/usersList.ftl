<h1> Current Users </h1>
<hr>
<br/>
<#if hasNoUsers??>
    <div class="starter-template">
        <h1>${hasNoUsers}</h1>
    </div>

<#else>
    <div class="starter-template">
    <table class="table" id ="current_users">
    <thead>
            <tr>
                <th> Name</th>
                <th>User Name</th>
            </tr>
    </thead>
        <#list users as user>
            <tbody>
            <tr>
                <td>${user.getFirstName()} ${user.getLastName()}</td>
                <td>${user.getUsername()}</td>
                <td>${user.getEditUser()} | ${user.getDeleteUser()}</td>
            </tr>
            </tbody>
        </#list>
    </table>
   </div>
</#if>









</div>