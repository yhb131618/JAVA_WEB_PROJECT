<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

회원가입화면

<form action ="${ctx}/memberInsert.do" method="post"> 
<table class="table">
<colgroup>
<col style="width: 112.099099px">
<col style="width: 190.099099px">
</colgroup>
<thead>
  <tr>
    <td>아이디</td>
    <td><input type="text" name="id"/></td>
  </tr>
</thead>
  <tr>
    <td>패스워드</td>
    <td><input type="password" name="pass"/></td>
  </tr>
  <tr>
    <td>이름</td>
    <td><input type="text" name="name"/></td>
  </tr>
  <tr>
    <td>나이</td>
    <td><input type="text" name="age"/></td>
  </tr>
  <tr>
    <td>이메일</td>
    <td><input type="text" name="email"/></td>
  </tr>
  <tr>
    <td>전화번호</td>
    <td><input type="text" name="phone"/></td>
  </tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="전송" class="bt btn-primary"/>
			<input type="reset" value="취소" class="bt btn-warning"/>
		</td>
	</tr>

</table>
</form>
</body>
</html>