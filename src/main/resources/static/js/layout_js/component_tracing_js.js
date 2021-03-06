
function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}
var sub_app_name=getContextPath();



$("#nav_content").load(sub_app_name+"/include/left_tool.html",function(){
    $("#sidebar_2").addClass("current-page");
});



//3D obj图像

var components;

var container;

var camera, scene, renderer;

var mouseX = 0, mouseY = 0;

var windowX=$('#test3d').width();
var windowY=$('#test3d').height();
var windowHalfX = windowX / 2;
var windowHalfY = windowY / 2;

var intersects;

init();

controls = new THREE.OrbitControls( camera, renderer.domElement );

animate();


function init() {

    camera = new THREE.PerspectiveCamera( 45, windowX / windowY, 1, 2000 );
    camera.position.z = 250;
    camera.position.y = 250;
    // scene

    scene = new THREE.Scene();

    var ambientLight = new THREE.AmbientLight( 0xcccccc, 0.4 );
    scene.add( ambientLight );

    var pointLight = new THREE.PointLight( 0xffffff, 0.8 );
    camera.add( pointLight );
    scene.add( camera );

    // texture

    var manager = new THREE.LoadingManager();
    manager.onProgress = function ( item, loaded, total ) {

        console.log( item, loaded, total );

    };


    var onProgress = function ( xhr ) {
        if ( xhr.lengthComputable ) {
            var percentComplete = xhr.loaded / xhr.total * 100;
            console.log( Math.round(percentComplete, 2) + '% downloaded' );
        }
    };

    var onError = function ( xhr ) {
    };

    var loader = new THREE.OBJLoader( manager );



    //声明raycaster和mouse变量
    var raycaster = new THREE.Raycaster();
    var mouse = new THREE.Vector3();


    loader.load( 'assets/lib/three/model/obj/DD23.obj', function ( object ) {

        components = [];

        object.scale.set (0.1, 0.1, 0.1);
        object.position.y = -150;
        scene.add( object );



        function onMouseMove( event ) {

            //通过鼠标点击的位置计算出raycaster所需要的点的位置，以屏幕中心为原点，值的范围为-1到1.

            mouse.x = ( (event.clientX - $('#test3d').offset().left) / $('#test3d').width() ) * 2 - 1;
            mouse.y = -( (event.clientY - $('#test3d').offset().top + document.documentElement.scrollTop) / $('#test3d').height() ) * 2 + 1;


            // 通过鼠标点的位置和当前相机的矩阵计算出raycaster
            raycaster.setFromCamera( mouse, camera );

            if (intersects) {
                for (var i = 0; i < intersects.length; i++) {
                    intersects[i].object.material.color.set(0xffffff);
                }
            }

            // 获取raycaster直线和所有模型相交的数组集合
            intersects = raycaster.intersectObjects( object.children );


            //将所有的相交的模型的颜色设置为红色，如果只需要将第一个触发事件，那就数组的第一个模型改变颜色即可
            for ( var i = 0; i < intersects.length; i++ ) {
                if (i==0){
                    intersects[ i ].object.material.color.set( 0xff0000 );
                    var guige_name=intersects[i].object.name;
                    console.log(guige_name);
                    $('#guige_info').html(guige_name);

                    if (guige_name=="big1"){
                        var srcc=sub_app_name+"/images/sample.png";
                        $("#unit_image").attr("src",srcc);

                        var bb=[0,1];
                        all_sequence(bb);


                    }
                    else if(guige_name=="big2"){
                        var srcc=sub_app_name+"/images/sample2.png";
                        $("#unit_image").attr("src",srcc);

                        var bb=[0,1,2,3];
                        all_sequence(bb);

                    }
                    else{
                        var srcc=sub_app_name+"/images/image_default.jpg";
                        $("#unit_image").attr("src",srcc);

                        var bb=[0,1,2,3,4,5];
                        all_sequence(bb);
                    }
                }
            }
        }
        $( "#test3d" ).mousemove(onMouseMove);
    }, onProgress, onError );

    renderer = new THREE.WebGLRenderer();
    renderer.setPixelRatio( window.devicePixelRatio );
    renderer.setSize( windowX, windowY );
    //container.appendChild( renderer.domElement );
    $('#test3d').append( renderer.domElement );

    window.addEventListener( 'mousemove', onDocumentMouseMove, false );
    window.addEventListener( 'resize', onWindowResize, false );
}

function onWindowResize() {
    windowX=$('#test3d').width();
    windowY=$('#test3d').height();
    windowHalfX = windowX / 2;
    windowHalfY = windowY / 2;

    camera.aspect = windowX / windowY;
    camera.updateProjectionMatrix();

    renderer.setSize( windowX, windowY );
}

function onDocumentMouseMove( event ) {
    mouseX = ( event.clientX - windowHalfX ) / 2;
    mouseY = ( event.clientY - windowHalfY ) / 2;
}

function animate() {
    requestAnimationFrame( animate );
    controls.update()
    render();
}

function render() {
    renderer.render( scene, camera );
}






// 有关流程图的方程

function single_sequece(a,name,time,info){
    var single_content="<li><div class=\"block\"><div class=\"block_content\"><h2 class=\"title\"><strong>"+a+"</strong></h2><div class=\"byline\"><a>"+name+"</a>，<span>"+time+"</span>\n" +
        "</div><p class=\"excerpt\">设备信息：\n" +info+ "</p></div></div></li>";

    return single_content;
}

function all_sequence(arryofnum){
    var all_content="";
    for (i=0;i<arryofnum.length;i++){
        var temp=arryofnum[i];
        if(temp==0){
            all_content=all_content+single_sequece("下料","王海滨","2018-5-18 13:12:23","aaa");
        }
        else if (temp==1){
            all_content=all_content+single_sequece("打磨","王海滨","2018-5-18 13:12:23","aaa");
        }
        else if (temp==2){
            all_content=all_content+single_sequece("组装","王海滨","2018-5-18 13:12:23","aaa");
        }
        else if (temp==3){
            all_content=all_content+single_sequece("焊接","王海滨","2018-5-18 13:12:23","aaa");
        }
        else if (temp==4){
            all_content=all_content+single_sequece("喷砂","王海滨","2018-5-18 13:12:23","aaa");
        }
        else if (temp==5){
            all_content=all_content+single_sequece("涂装","王海滨","2018-5-18 13:12:23","aaa");
        }

    }
    $("#sequence_change").html(all_content);


}

