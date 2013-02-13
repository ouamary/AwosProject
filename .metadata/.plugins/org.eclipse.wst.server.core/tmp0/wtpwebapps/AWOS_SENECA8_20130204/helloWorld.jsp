<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Spring MVC Ajax Demo</title>
  <script type="text/javascript" src="scripts/jquery.js"></script>
  <script type="text/javascript">
    function doAjax() {
      $.ajax({
        url: 'helloWorld.action',
        data: ({name : "AWOOOOS!"}),
        success: function(data) {
          $('#time').html(data);
        }
      });
    }
  </script>
</head>
<body>
${message}
<button id="demo" onclick="doAjax()" title="Button">Get the time!</button>
<div id="time">
</div>
</body>
</html>
