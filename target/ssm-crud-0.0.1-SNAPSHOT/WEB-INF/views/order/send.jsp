<!DOCTYPE html>
<html>
<head>
    <title>WebSocket Test</title>
</head>
<body>
<script>
    var wsObj = new WebSocket("ws://localhost:8080/ssm-crud/websocket/socketServer");   //建立连接
    wsObj.onopen = function(){  //发送请求
        alert("open");
        wsObj.send("Hello WebSocket");
    };
    wsObj.onmessage = function(ev){  //获取后端响应
        alert(ev.data);
    };
    wsObj.onclose = function(ev){
        alert("close");
    };
    wsObj.onerror = function(ev){
        alert("error");
    };
</script>
</body>
</html>

