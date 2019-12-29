<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 12/6/2017
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <button value="start" onclick="onStart()">start</button>
  <button value="stop" onclick="onStop()">stop</button>
  <div>Time from server:</div>
  <div id="time" />
  <script>
      var socket = new WebSocket("ws://localhost:8016/actions");
      socket.onopen = onOpen;
      socket.onmessage = onMessage;

      function onOpen() {
      }

      function onStart() {
          socket.send("start");
      }

      function onStop() {
          socket.send("stop");
      }

      function onMessage(event) {
          var data = JSON.parse(event.data);
          document.getElementById('time').innerHTML += "<div>" + data.time + "</div>";
      }
  </script>
  </body>
</html>
