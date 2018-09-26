
function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
var sub_app_name=getContextPath();

// reset cookies
// $.cookie('email', null);
// $.cookie('password', null);
// $.cookie('remember', null);


var this_acc="123";
var this_pass="123";

$(document).ready(function() {

    var remember = $.cookie('remember');
    if (remember == 'true')
    {
        var email = $.cookie('email');
        var password = $.cookie('password');
        // autofill the fields
        $('#email').val(email);
        $('#password').val(password);

    }

});


function changeindentify()
{
    document.getElementById("indentifyview").innerHTML="<img height=\"34\" width=\"105\" src='"+sub_app_name+"/backstage/getValidateCode?"+new Date()+"' style='vertical-align: center;'/>";
}



function validateForm(){
    var email = $('#email').val();
    var password = $('#password').val();

    //if ((email=="123")&&(password=="123")) {
    if (true) {
        if ($('#remember').is(':checked')) {
            var email = $('#email').val();
            var password = $('#password').val();

            // set cookies to expire in 14 days
            $.cookie('email', email, { expires: 14 });
            $.cookie('password', password, { expires: 14 });
            $.cookie('remember', true, { expires: 14 });
        }
        else
        {
            // reset cookies
            $.cookie('email', null);
            $.cookie('password', null);
            $.cookie('remember', null);
        }


        return true;
    }
    else{
        alert("aaaa");
        return false;
    }
}



function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function checkCookie() {
    var user = getCookie("username");
    if (user != "") {
        alert("Welcome again " + user);
    } else {
        user = prompt("Please enter your name:", "");
        if (user != "" && user != null) {
            setCookie("username", user, 365);
        }
    }
}