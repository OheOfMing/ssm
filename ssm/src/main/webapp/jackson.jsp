<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//项目名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath %>static/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="<%=basePath %>static/js/jackson.js"></script>

</head>
<body>
	<input type="hidden" value="25" id="u_id"/>
	<button id="one">单个新增</button>
	<button id="two">单个修改</button>
	<button id="three">查询对象</button>
	<button id="four">删除对象</button>
	
	 
	<p>
	<form id="userform" method="post" onsubmit="return changeurl()">
		<fieldset>
			<legend>表单提交PUT/DELETE</legend>
			<input type="hidden" value="delete" name="_method"/>
			
			<input type="hidden" value="25" name="id"/>
			<input type="text" value="王五" name="userName"/>
			<input type="text" value="ww" name="loginName"/>
			<input type="password" value="123456" name="password"/>
			<input type="text" value="18" name="age"/>
			<br/>
			<input type="submit" value="提交"/>
		</fieldset>
	</form>
	
	
	
	
	
	
</body>
</html>