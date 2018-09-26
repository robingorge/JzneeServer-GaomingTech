function time_convert(time) {
    if (time) {
        var time_string = time.toString();
        return time_string.substr(0,10)+' '+time_string.substr(11,8);;
    }
    else{
        return "";
    }
}





function addTool(number,warehouseby,location,type) {

        var locnum=0;
        if (location=="位置1"){
            locnum=1;
        }
        else if (location=="位置2"){
            locnum=2;
        }
        else if (location=="位置3"){
            locnum=3;
        }

        $.post("tool/addTool", {"number":number,"warehouseBy":warehouseby,"location":locnum,"type":type},function(data,status){
            if(status=="success"){
                console.log(data);
                if (data.code == 1) {
                    getTools();
                } else {
                    alert("insert fail");

                }
            } else{
                alert("network fail");
            }
        });
}


function updateTool(number,receiveby){
    $.post("tool/updateTool", {"number":number,"receiveBy":receiveby},function(data,status){
        if(status=="success"){
            console.log(data);
            if (data.code == 1) {
                getTools();
            } else {
                alert("update fail");

            }
        } else{
            alert("network fail");
        }
    });


}


function getTools(){
    $.post("tool/getTools", {},function(data,status){
        if(status=="success"){
            console.log(data);
            if (data.code == 1) {
                updatetable(data.object);
            } else {
                alert("update fail");

            }
        } else{
            alert("network fail");
        }
    });

}









function updateWarning(id,result){
    $.post("warning/updateWarning", {"warningId":id,"result":result},function(data,status){
        if(status=="success"){
            console.log(data);
            if (data.code == 1) {
                getWarnings();
            } else {
                alert("update warning fail");

            }
        } else{
            alert("network fail");
        }
    });


}




function getWarnings(){
    //alert("sucess");
    $.post("warning/getWarnings", {},function(data,status){
        if(status=="success"){
            console.log(data);
            if (data.code == 1) {
                updatetable_alert(data.object);
            } else {
                alert("get warnings fail");

            }
        } else{
            alert("network fail");
        }
    });

}