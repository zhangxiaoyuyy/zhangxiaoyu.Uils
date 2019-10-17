<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章标题列表</title>
</head>
<body>
	<div class="container">
		<div>
			<form action="">
				<table class="table table-light table-border table-hover table-sm">
					<tr align="center">
						<td>链接名称:<input type="text" name="text"></td>
					</tr>
					<tr align="center">
						<td>URL:<input type="text" name="url"></td>
					</tr>

					<tr>
						<th><button type="button" onclick="add()">保存</button></th>
					</tr>
				</table>

			</form>
		</div>
	</div>
	<script type="text/javascript">
	
		function add() {
			$.post("/links/save",$("form").serialize(),
					function(msg) {
						alert(msg)
						$('#content-wrapper').load("/links/selects");
					}
			)
		}
		
	</script>
	<script type="text/javascript" src="/resource/js/cms.js"></script>
</body>
</html>