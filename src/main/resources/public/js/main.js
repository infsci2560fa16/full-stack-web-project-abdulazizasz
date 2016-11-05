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

});

  $(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
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
                        message: 'Please supply your first name'
                    }
                }
            },
             last_name: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply your last name'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your phone number'
                    },
                    phone: {
                        country: 'US',
                        message: 'Please supply a vaild phone number with area code'
                    }
                }
            },
            address: {
                validators: {
                     stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please supply your street address'
                    }
                }
            },
            city: {
                validators: {
                     stringLength: {
                        min: 4,
                    },
                    notEmpty: {
                        message: 'Please supply your city'
                    }
                }
            },
            state: {
                validators: {
                    notEmpty: {
                        message: 'Please select your state'
                    }
                }
            },
            zip: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your zip code'
                    },
                    zipCode: {
                        country: 'US',
                        message: 'Please supply a vaild zip code'
                    }
                }
            },
            comment: {
                validators: {
                      stringLength: {
                        min: 10,
                        max: 200,
                        message:'Please enter at least 10 characters and no more than 200'
                    },
                    notEmpty: {
                        message: 'Please supply a description of your project'
                    }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow"); // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});

