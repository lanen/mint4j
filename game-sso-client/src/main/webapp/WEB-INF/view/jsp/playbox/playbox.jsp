<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page session="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>play box</title>

<!-- 资源从CDN 抓取。注入游戏网关ip就ok -->
<script type="text/javascript" src="/static/swfobject.js"></script>
<script type="text/javascript">
swfobject.embedSWF("/static/test.swf", "myContent", "300", "120", "9.0.0", "/static/expressInstall.swf");
</script>

</head>
<body>
	${gate_type} ${gate } ${playbox_version }${game_version } ${account}
		
		
	<div id="myContent">
		<h1>Alternative content</h1>
		<p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" /></a></p>
	</div>
	${copyright }
</body>
</html>