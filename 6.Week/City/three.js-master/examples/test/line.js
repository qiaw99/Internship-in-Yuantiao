var camera, scene, renderer;
var geometry, material, light;
 

function initRenderer () {
    renderer = new THREE.WebGLRenderer( { antialias: true } );
	renderer.setSize( window.innerWidth, window.innerHeight );
    document.body.appendChild( renderer.domElement );
    // renderer.setClearColor(0xFFFFFF, 1.0);
}

function initCamera () {
    camera = new THREE.PerspectiveCamera(45, window.innerWidth / window.innerHeight, 1, 10000);
    // camera.position.x = 0;
    // camera.position.y = 1000;
    // camera.position.z = 0;
    camera.position.set(0, 1000, 0);
    // camera.up.x = 0;
    // camera.up.y = 1;
    // camera.up.z = 0;
    camera.up.set(0, 1, 0)
    camera.lookAt(0, 0, 0)
}

function initScene () {
    scene = new THREE.Scene();
}

function initLight() {
    light = new THREE.DirectionalLight(0xFF0000, 1.0, 0);
    light.position.set(100, 100, 200);
    scene.add(light);
}

function initObject () {
    geometry = new THREE.Geometry();
    geometry.vertices.push(
        new THREE.Vector3(-100, 0, 100),
        new THREE.Vector3(100, 0, -100)
    );
    geometry.colors.push(
        new THREE.Color( 0x444444 ), 
        new THREE.Color( 0xFF0000 )
    )
    material = new THREE.LineBasicMaterial({ vertexColors: true });
    
    var line = new THREE.Line(geometry, material);
    scene.add(line);
}

function animate () {
    requestAnimationFrame( animate );

    renderer.render( scene, camera );
};

function loadPic(){
    const VERTEXSHADER = 
    "varying vec2 vUv;"+
    "void main(){"+
        "gl_Position = vec4(vUv, 0.0, 0.0);"+
    "}"
    ;
    const FRAGMENTSHADER = 
    "varying vec2 vUV;"+
    "uniform sampler2D texture1;//map"+
    "uniform sampler2D texture2;//road"+
    // "uniform vec3 defaultColor = vec3(0,0,0);"+
    // "uniform float defaultOpacity = 0.0"+
    // "uniform float luminosityThreshold;"+
    // "uniform float smoothWidth;"+

    "void main(){"+
        "vec4 texel1 = texture2D( texture1, vUv);"+
        "vec4 vec3texel1 = texel1.xyz;"+
        "vec4 texel2 = texture2D( texture2, vUv );"+
        "vec4 vec3texel2 = texel2.xyz"+
        "if(vec3texel2 != vec(0.0, 0.0, 0.0)){"+
            "gl_FragColor = texel2;"+
        "}else{"+
            "gl_FragColor = texel1;"+
        "}"+
    "}"
    ;
}
function init() {
    initRenderer()
    initCamera ();
    initScene();
    initLight();
    initObject();
    animate();
}
 
window.onload = init;