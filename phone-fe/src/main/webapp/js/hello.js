function addFunction1() {
		console.log("Inside addFunction");
		var pname = $('#pname').val();
		var pnumber = $('#pnumber').val();
		console.log("pname:"+pname+" pnumber:"+pnumber);	
}
function viewFunction() {			
console.log("Inside viewFunction");
$(document).ready(function() {
	var displayResources = $("#display-resources");
    displayResources.text("Loading data from JSON source...");
    $.ajax({
        url: "http://localhost:9000/all/phone/info",
		dataType: 'application/json',
		
    }).then(function(data) {
    	 console.log(data);
		 var output ="<table><thead><tr><th>Name</th><th>PhoneNumber</th></thead><tbody>";
         for (var i in data.phone) {
              output += "<tr><td>" + data.phone[i].name +"</td><td>" + data.phone[i].phoneNumber +"</td></tr>";
         }
         output += "</tbody></table>";
		 displayResources.html(output);
        
    });
});
}
