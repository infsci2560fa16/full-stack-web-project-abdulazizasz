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


});

