function updatetable_alert(object){

    content="";
    for (i=0;i<object.length;i++){
        var temp=object[i];

        content=content+"<tr>"+"<th>"+temp.id+"</th>"+"<td>"+temp.type+"</td>"+"<td>"+temp.content+"</td>"+"<td>"+temp.location+"</td>"+"<td>"+time_convert(temp.time)+"</td>"+"<td>"+temp.status+"</td>"+"<td>"+temp.result+"</td>"+"</tr>";
    }

    $("#warning_all").html(content);

    $("#warning_all tr").click(function(e){
        var a = $(this).children("td")[0].innerHTML;
        var b = $(this).children("td")[1].innerHTML;
        var c = $(this).children("td")[2].innerHTML;
        var d = $(this).children("td")[3].innerHTML;
        var r = $(this).children("td")[4].innerHTML;

        var rinfo = $(this).children("td")[5].innerHTML;

        var n= $(this).children("th")[0].innerHTML;

        if ((a!="")&&(a!="&nbsp;")) {
            $("#demoform2_1").val(n);
            $("#demoform2_2").val(a);
            $("#demoform2_3").val(b);
            $("#demoform2_4").val(c);
            $("#demoform2_5").val(d);

            if ((rinfo!="")&&(rinfo!="&nbsp;")) {
                $("#demoform2_6").val(rinfo);
            }
            else{
                $("#demoform2_6").val("");
            }

            if (r=="已处理"){
                $("#demoform2_submit").hide();
            }
            else{
                $("#demoform2_submit").show();
            }
        }
        else{
            $("#demo-form2")[0].reset();
            $("#demoform2_submit").hide();
        }
    });

}



function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
var sub_app_name=getContextPath();




$( document ).ready( function() {

    $("#nav_content").load(sub_app_name+"/include/left_tool.html",function(){
        $("#sidebar_3").addClass("current-page");
    });


    getWarnings();

    $("#demoform2_clear").click(function(e){

        $("#demoform2_1").val("");
        $("#demoform2_2").val("");
        $("#demoform2_3").val("");
        $("#demoform2_4").val("");
        $("#demoform2_5").val("");
    });


    $('#demoform2_submit').click(function(e){
        e.preventDefault();

        var a=$("#demoform2_1").val();
        var b=$("#demoform2_6").val();

        if (b==""){
            alert("结果不能为空");
            return;
        }

        if (a==""){
            alert("ID不能为空，请点击左边列表");
            return;
        }

        updateWarning(a,b);


    });


});

