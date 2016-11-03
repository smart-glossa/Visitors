$(document).ready(function() {
  $(document).on('click','#ssr',function() {
    // Get the value from the textbox
    var Name = $('#Name').val();
    var Address = $('#Address').val();
    var mobileNumber = $('#mobileNumber').val();
    var EmailId = $('#EmailId').val();
    var Purpose = $('#Purpose').val();

    var url = "/visitors/vist?operation=add&Name="+Name+"&Address="+Address+"&mobileNumber="+mobileNumber+"&EmailId="+EmailId+"&Purpose="+Purpose;
    // Call this URL for Server side actions
$.ajax(url).
  done(function(result) {
  //console.log(result);
  //alert(result);
   
   var se=JSON.parse(result);
   if(se.status==1){
    window.location.href="view.html";
   }
  }).
  fail(function(result) {
    //console.log(result);
alert(result);
  });

});
});
