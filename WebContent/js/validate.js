function validate() {
    var Name = document.getElementById("Name").value;
    var Address = document.getElementById("Address").value;
    var EmailId= document.getElementById("EmailId").value;
    var mobileNumber = document.getElementById("mobileNumber").value;
    var Purpose= document.getElementById("Purpose").value;

    if ((Name == "") || (/^\s*$/.test(Name))) {
        alert("Name can't be blank");
    } else if (Name.match(/^[a-zA-Z]+$/)) {

    } else {
        alert("Use alphabets only");
    }
    if ((Address == "") || (/^\s*$/.test(Address))) {
        alert("Address can't blank");
    } else {}
    if ((EmailId == "") || (/^\s*$/.test(EmailId))) {
        alert("EmailId can't blank");
    } else if (EmailId.match(/^[a-zA-Z0-9]*$/)) {

    } else {
        alert("Enter EmailId here");
    }
    if ((mobileNumber== "") || (/^\s*$/.test(mobileNumber))) {
        alert("Enter mobileNumber here");
    } else if (mobileNumber.length < 10) {
        alert("mobileNumber length is minimum ten")
    } else if (mobileNumber.match(/^[a-zA-Z0-9]+$/)) {

    } else {}


}