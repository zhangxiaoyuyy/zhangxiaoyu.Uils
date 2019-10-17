<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${article.title }</title>
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
	<div class="card" align="center">

		<div class="card-header">
			<h2>${article.title }</h2>

			作者:${general.username}&nbsp;&nbsp;&nbsp;&nbsp; 
			<input type="button"
				value="收藏"  onclick="like(${general.id})">
			<hr>
		</div>

		<div class="card-body">${article.content }</div>


	</div>
	<script type="text/javascript">
		function like(uid) {
			var uid = '${general.id}'
			//alert(uid)
			var aid = '${article.id }'
			//alert(aid)
			$.post("/conllection/to", {
				uid : uid,
				aid : aid
			}, function(flag) {
				if (flag) {
					alert("收藏成功")
				} else {
					alert("收藏失败")
				}
			}, "json")
		}
	</script>
</body>
</html>