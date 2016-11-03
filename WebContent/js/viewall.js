$(window).on('load',function(){
	//$(document).on('click','#how',function(){
		var url="/visitors/vist?operation=getAllvisitors";

		$.ajax(url)
		.done(function(result){
			var gr=JSON.parse(result);
			 var count=gr.length;
			 //console.log(result);
			  var table=$('#div1').children();
  var tablebody=table.remove();
  $('#div1').append("<table class='table-fill'></table>");
  var table=$('#div1').children();        
  table.append("<tr><th class='text-left'>NAME</th><th class='text-left'>ADDRESS</th><th class='text-left'>MOBILENUMBER</th><th class='text-left'>EMAILID</th><th class='text-left'>PURPOSE</th></tr>");
  for(var i=0;i<count;i++){
     var jsonObj =gr[i];
     var rowString = "<tr><td class='text-left'>" + jsonObj.Name +  "</td><td class='text-left'>"  + jsonObj.Address + "</td><td class='text-left'>" + jsonObj.mobileNumber + "</td><td class='text-left'>" + jsonObj.EmailId + "</td><td class='text-left'>" +  jsonObj.Purpose + "</td>";
  table.append(rowString);
 }
 

})
  .fail(function(result){
    alert("error");
  });


//alert("Internal error occurs");
//}
});



