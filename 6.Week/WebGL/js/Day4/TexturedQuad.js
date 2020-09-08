// Vertex shader program
/* 顶点着色器中接受顶点的纹理坐标，光栅化后传递给片元着色器 */
var VSHADER_SOURCE =
	'attribute vec4 a_Position;\n' +
	'attribute vec2 a_TexCoord;\n' +
	'varying vec2 v_TexCoord;\n' +
	'void main() {\n' +
	'  gl_Position = a_Position;\n' +
	'  v_TexCoord = a_TexCoord;\n' +
	'}\n';

// Fragment shader program
/* 片元着色器根域片元的纹理坐标，从纹理图像中抽取纹素颜色，赋给当前片元 */
var FSHADER_SOURCE =
	'#ifdef GL_ES\n' +
	'precision mediump float;\n' +
	'#endif\n' +
	'uniform sampler2D u_Sampler;\n' +
	'varying vec2 v_TexCoord;\n' +
	'void main() {\n' +
	// 从纹理图像上获取纹素的颜色 texture2D
	'  gl_FragColor = texture2D(u_Sampler, v_TexCoord);\n' +
	'}\n';

function main() {
	// Retrieve <canvas> element
	var canvas = document.getElementById('webgl');

	// Get the rendering context for WebGL
	var gl = getWebGLContext(canvas);
	if (!gl) {
		console.log('Failed to get the rendering context for WebGL');
		return;
	}

	// Initialize shaders
	if (!initShaders(gl, VSHADER_SOURCE, FSHADER_SOURCE)) {
		console.log('Failed to intialize shaders.');
		return;
	}

	// Set the vertex information
	var n = initVertexBuffers(gl);
	if (n < 0) {
		console.log('Failed to set the vertex information');
		return;
	}

	// Specify the color for clearing <canvas>
	gl.clearColor(0.0, 0.0, 0.0, 1.0);

	// Set texture
	if (!initTextures(gl, n)) {
		console.log('Failed to intialize the texture.');
		return;
	}
}

/* 设置纹理坐标 */
function initVertexBuffers(gl) {
	var verticesTexCoords = new Float32Array([
		// Vertex coordinates, texture coordinate
		-0.5, 0.5, 0.0, 1.0,
		-0.5, -0.5, 0.0, 0.0,
		0.5, 0.5, 1.0, 1.0,
		0.5, -0.5, 1.0, 0.0,
	]);
	var n = 4; // The number of vertices

	// Create the buffer object
	var vertexTexCoordBuffer = gl.createBuffer();
	if (!vertexTexCoordBuffer) {
		console.log('Failed to create the buffer object');
		return -1;
	}

	// Bind the buffer object to target
	gl.bindBuffer(gl.ARRAY_BUFFER, vertexTexCoordBuffer);
	gl.bufferData(gl.ARRAY_BUFFER, verticesTexCoords, gl.STATIC_DRAW);

	var FSIZE = verticesTexCoords.BYTES_PER_ELEMENT;
	
	//Get the storage location of a_Position, assign and enable buffer
	var a_Position = gl.getAttribLocation(gl.program, 'a_Position');
	if (a_Position < 0) {
		console.log('Failed to get the storage location of a_Position');
		return -1;
	}
	gl.vertexAttribPointer(a_Position, 2, gl.FLOAT, false, FSIZE * 4, 0);
	gl.enableVertexAttribArray(a_Position); // Enable the assignment of the buffer object

	// Get the storage location of a_TexCoord
	var a_TexCoord = gl.getAttribLocation(gl.program, 'a_TexCoord');
	if (a_TexCoord < 0) {
		console.log('Failed to get the storage location of a_TexCoord');
		return -1;
	}
	// Assign the buffer object to a_TexCoord variable
	gl.vertexAttribPointer(a_TexCoord, 2, gl.FLOAT, false, FSIZE * 4, FSIZE * 2);
	gl.enableVertexAttribArray(a_TexCoord); // Enable the assignment of the buffer object

	return n;
}

/* 配置和加载纹理 */
function initTextures(gl, n) {
	var texture = gl.createTexture(); // Create a texture object
	
	if (!texture) {
		console.log('Failed to create the texture object');
		return false;
	}

	// Get the storage location of u_Sampler
	var u_Sampler = gl.getUniformLocation(gl.program, 'u_Sampler');
	if (!u_Sampler) {
		console.log('Failed to get the storage location of u_Sampler');
		return false;
	}
	
	var image = new Image(); // Create the image object
	if (!image) {
		console.log('Failed to create the image object');
		return false;
	}
	// Register the event handler to be called on loading an image
	image.onload = function() {
		loadTexture(gl, n, texture, u_Sampler, image);
	};
	
	// Tell the browser to load an image
	image.src = '../../img/sky.jpg';

	return true;
}

/* 为WebGL配置纹理 */
function loadTexture(gl, n, texture, u_Sampler, image) {
	// 对纹理图像进行y轴反转
	/* 第一个参数pname可以是以下二者之一:
		- UNPACK_FLIP_Y_WEBGL 					y轴反转
		- UNPACK_PREMULTIPLY_ALPHA_WEBGL		将图像RGB的每一个分量乘以A
	*/
	gl.pixelStorei(gl.UNPACK_FLIP_Y_WEBGL, 1);
	
	// Enable texture unit0
	/* 激活纹理单元，纹理单元的机制是用来同时使用多个纹理 */
	gl.activeTexture(gl.TEXTURE0);
	
	// Bind the texture object to the target
	/* 或者是TEXTURE_CUBE_MAP 立方体纹理 */
	gl.bindTexture(gl.TEXTURE_2D, texture);

	// Set the texture parameters
	/* 详情见README */
	gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);

	// 将纹理图像分配给纹理对象
	gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGB, gl.RGB, gl.UNSIGNED_BYTE, image);

	// 将纹理单元传递给元着色器， 0代表纹理单元的编号
	gl.uniform1i(u_Sampler, 0);

	gl.clear(gl.COLOR_BUFFER_BIT); // Clear <canvas>

	gl.drawArrays(gl.TRIANGLE_STRIP, 0, n); // Draw the rectangle
}
