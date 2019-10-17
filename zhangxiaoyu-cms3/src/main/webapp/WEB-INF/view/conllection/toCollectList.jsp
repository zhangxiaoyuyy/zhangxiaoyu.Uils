<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${article.title }</title>
</head>
<body>
	<div id="center">
		<div class="card" align="center">

			<div class="card-header">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">姓名</th>
							<th scope="col">收藏文章</th>
							<th scope="col">作者</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${collectList }" var="c" varStatus="i">
							<tr>
								<th scope="row">${i.index+1 }</th>
								<td>${c.username }</td>
								<td>${c.title }</td>
								<td>${general.username}</td>

							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>
			<div>${pages }</div>
		</div>
	</div>
	<script type="text/javascript">
		$('.page-link').click(function(e) {
			//获取点击的的url
			var url = $(this).attr('data');

			//在中间区域显示地址的内容
			$('#content').load(url);
		});
	</script>
</body>
</html>