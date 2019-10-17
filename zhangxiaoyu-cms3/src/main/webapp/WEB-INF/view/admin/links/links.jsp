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
			<table class="table table-light table-border table-hover table-sm">
				<tr align="center">
					<th>序号</th>
					<th>链接名称</th>
					<th>URL</th>
					<th>修改日期</th>
					<th>操作|
						<button type="button" onclick="add()">增加</button>
					</th>
				</tr>
				<c:forEach items="${links }" var="u" varStatus="i">
					<tr align="center">
						<td>${i.index+1 }</td>
						<td>${u.text }</td>
						<td>${u.url }</td>
						<td><fmt:formatDate value="${u.created}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td></td>
					</tr>
				</c:forEach>

			</table>
			<div>${pages }</div>
		</div>

	</div>
	<script type="text/javascript">
		function add() {
			$('#content-wrapper').load("/links/add");
		}

		//获取分页连接的URL .并进行加载
		$(function() {
			$('.page-link').click(function(e) {
				//获取点击的的url
				var url = $(this).attr('data');

				//在中间区域显示地址的内容
				$('#content-wrapper').load(url);
			});

		})
	</script>
</body>
</html>