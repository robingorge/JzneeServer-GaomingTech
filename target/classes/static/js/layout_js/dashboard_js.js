function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
var sub_app_name=getContextPath();



$("#nav_content").load(sub_app_name+"/include/left_tool.html",function(){
    $("#sidebar_1").addClass("current-page");
});