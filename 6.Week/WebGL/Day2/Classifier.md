# webgl中uniform、varying、attribute的差别

- **uniform** 表示一次渲染过程中保存不变的，GPU的工作模式是多管道的，相当于一个像素点对应着一个管道. 当然并不是说有这么多管道，只是表示他是一一对应并且一起处理；那么把整个屏幕处理时uniform    是持不变的



- **attribute** 表示是实时在改变的，比如通常我们用了存放顶点和颜色



- **varying** 用来着色器之间的通讯, 也就是顶点着色器和片段着色去之间的桥梁；比如你要传一个顶点颜色，你需要在两个着色器里声明一个变量，然后你把颜色传入到顶点着色器中，并在main()函数里赋值，这才能把赋值给你声明的varying vec4 color



```javascript
<script id="vs" type="x-shader/x-vertex"> 
    attribute vec3 position; 
    attribute vec4 color; 
    uniform mat4 mvpMatrix; 
    varying vec4 vColor; 
    
    void main(void){ 
    	vColor = color; 
    	gl_Position = mvpMatrix * vec4(position,1.0); 
    } 
    </script> 
    <script id="fs" type="x-shader/x-fragment"> 
    precision mediump float; 
    varying vec4 vColor; 
    
    void main(void){ 
    	gl_FragColor = vColor; 
    } 
</script> 
```

