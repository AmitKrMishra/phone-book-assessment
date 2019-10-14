$(document).ready(function() {
	var displayResources = $("#display-resources");
    displayResources.text("Loading data from JSON source...");
    $.ajax({
        url: "http://localhost:8080/all/phone/info"
    }).then(function(data) {
    	 console.log(data);
       var output ="<table><thead><tr><th>Name</th><th>PhoneNumber</th><th>URL</th></thead><tbody>";
         for (var i in data) {
              output += "<tr><td>" + data[i].phone +"</td><td>" + data[i].phone +"</td></tr>";
         }
         output += "</tbody></table>";
         displayResources.html(output);
         $("table").addClass("table");
    });
});
