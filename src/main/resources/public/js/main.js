//$(document).ready(function(){
//
//	$("button").click(function(){
//		$("div").not(".container").css("backgroundColor","Yellow");
//	});
//
//
//});
//

// A function to show the active courses right now

$(document).ready(function(){
		    $("#activeNow").click(function(){
		        $("tbody > tr:nth-child(2), tr:nth-child(3), tr:nth-child(4)").addClass('active');
		    });

		    $("#coursesToggle").hover(function(){
                    $("#panelCourses").slideToggle("slow").delay(1500);
                });

            $("#practiceToggle").hover(function(){
                $("#panelPractice1, panelPractice2").slideToggle("slow").delay(1500);
            });

            $("#teacherToggle").hover(function(){
                $("#panelTeachers1, panelTeachers2").slideToggle("slow").delay(1500);
            });

            $("#azizToggle").hover(function(){
               $("#panelAziz").slideToggle("slow");
            });

             $("#mikeToggle").hover(function(){
                 $("#panelMike").slideToggle("slow");
              });

              $("#annToggle").hover(function(){
                 $("#panelAnn").slideToggle("slow");
              });

             $('nav li a').mouseover(function () {
                 $('nav li a').not($(this)).addClass('hover');
             });

             $('nav li a').mouseout(function () {
                 $('nav li a').not($(this)).removeClass('hover');
             });

            $("#allCourses tbody > tr").mouseover(function () {
                 $("#allCourses tbody > tr").not($(this)).addClass('hover');
             });

             $("#allCourses tbody > tr").mouseout(function () {
                              $("#allCourses tbody > tr").not($(this)).removeClass('hover');
               });

             $("#showQuote").click(function(){

                $('#quote').css('visibility','visible').show();
             });

             // Add new rows

               $(".addRow").click(function(){
                 var course = $("#course").val();
                 var area = $("#area").val();
                 var instructor = $("#instructor").val();
                 var duration = $("#duration").val();
                 var startingDate = $("#startingDate").val();
                 var result = "<tr><td>" + course + "</td><td>" + area +
                 "</td><td>" + instructor + "</td><td>" + duration + "</td><td>" +
                 startingDate + "</td><td class = 'deleteRow'><button type='button' class='btn btn-danger'>Delete</button></td></tr>";
                 $("#courseManagement tbody").append(result);
               });
               // Delete and add rows in course management page
                                   $(".deleteRow").click(function(){
                                             var delete_row = $(this).parent('tr');
                                                 delete_row.addClass("danger");
                                                 delete_row.fadeOut(2000, function(){
                                                     $(this).remove();
                                                 });
                                          });
});


// Home page quotes
$(document).ready(function () {
    var divs = $('.quotesCollection>.quotes');
    var now = 0;
    divs.hide().first().show();
    $("button[name=next]").click(function (e) {
        divs.eq(now).hide();
        now = (now + 1 < divs.length) ? now + 1 : 0;
        divs.eq(now).show();
    });
    $("button[name=previous]").click(function (e) {
        divs.eq(now).hide();
        now = (now > 0) ? now - 1 : divs.length - 1;
        divs.eq(now).show(); // or .css('display','block');
        //console.log(divs.length, now);
    });
});

// To validate a form in aboutus.html
$(document).ready(function(){
    $('#contact_form').bootstrapValidator({
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        first_name: {
            validators: {
                stringLength: {
                min: 2,
                },
                notEmpty: {
                message: "Please enter your first name"
                }
            }
        },
        last_name: {
            validators: {
                stringLength: {
                min: 2,
                },
                notEmpty: {
                message: "Please enter your last name"
                }
            }
        },
        email: {
            validators: {
                notEmpty: {
                    message: 'Please do not email address empty'
                },
                emailAddress: {
                    message: "The email you used is not valid"
                }
            }
        },
        phone: {
            validators: {
                notEmpty: {
                message: "Please enter a phone number"
                },
                phone :{
                    country: 'US',
                    message: "Not Valid a US number"
                }
            }
        },
        comment: {
            validators: {
                stringLength: {
                    min: 20,
                    max: 200,
                    message: "Please enter an enough message"
                },
                notEmpty: {
                    message: 'Please enter your message'
                }
            }
        }
    }
}).on('success.form.bv', function(e){
    $('#success_message').slideDown({ opacity: "show"}, "slow");
        $('#contact_form').data('bootstrapValidator').resetForm();

    e.preventDefault();

    var $form = $(e.target);

    var bv = $form.data('bootstrapValidator');

    $.post($form.attr('action'), $form.serialize(), function(result){
        console.log(result);
    }, 'json');
    });
});

/// Validate the login Form

function validate(){

    var userName = document.getElementById("login-username").value;
    var userPassword = document.getElementById("login-password").value;

    if( userName === "" || userPassword === "")
        alert("You should enter your user name and password");
    else
        alert("Succeed!!!");

}


function listAllUsers () {
                $.ajax({
                    url: "/all-users",
                    success: function (result) {
                        var data = JSON.parse(result);
                        $(data).each(function(i, val){
                                 $("#users-list").append("<li>" + val.firstName +  " " + val.lastName + "</li>"+ "<br>");
                        });

                    }});
            }

function listAllCourses () {
                $.ajax({
                    url: "/all-courses",
                    success: function (result) {
                        var data = JSON.parse(result);
                        $(data).each(function(i, val){
                                 $("#courses-list").append("<li>" + val.name + " : " + val.area + " : " + val.duration +
                                  " : " + val.startingDate + "</li>" + "<br>");
                        });

                    }});
            }
function listAllInstructors () {
                $.ajax({
                    url: "/all-instructors",
                    success: function (result) {
                        var data = JSON.parse(result);
                        $(data).each(function(i, val){
                                 $("#instructors-list").append("<li>" + val.name + " " +
                                 val.email + " " + val.experience +  "</li><br>");
                        });

                    }});
            }

/// Getting all the data from xml
function loadXML(){

var xhttp;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        listAllCoursesName(this);
    }
};
xhttp.open("GET", "/courses_xml", true);
xhttp.send();

}


function listAllCoursesName(xml) {

    var x, i, txt, xmlDoc;
    xmlDoc = xml.responseXML;
    txt = "";
    x = xmlDoc.getElementsByTagName("course_name");
    for (i = 0; i < x.length; i++) {
        txt += x[i].childNodes[0].nodeValue + "<br>";

    }
    document.getElementById("courses_names").innerHTML = txt;
}

/// Getting all the data from xml
function loadXML_areas(){

var xhttp;
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        listAllAreaName(this);
    }
};
xhttp.open("GET", "/courses_xml", true);
xhttp.send();

}


function listAllAreaName(xml) {

    var x, i, txt, xmlDoc;
    xmlDoc = xml.responseXML;
    txt = "";
    x = xmlDoc.getElementsByTagName("area_name");
    for (i = 0; i < x.length; i++) {
        txt += x[i].childNodes[0].nodeValue + "<br>";

    }
    document.getElementById("areas_names").innerHTML = txt;
}
