<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"


<title>投票</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>
	<div class="card" align="left">
		<form action="">

			<input type="hidden" name="articleId" value="${article.id }">
			<div class="card-header">
				<h2>${article.title }</h2>
				<hr>
			</div>

			<div class="card-body">
				<c:forEach items="${mapList }" var="map">
					<c:forEach items="${map }" var="m">
						<div align="left">
							<input type="radio" name="optionId" value="${m.value }">
							<label>${m.value }</label> <br>
						</div>
					</c:forEach>
				</c:forEach>
			</div>
			<input type="button" class="" value="投票" onclick="vote()">
		</form>
	</div>
	<div>
		<c:forEach items="${mapListVote }" var="maps">
			<div class="progress">
				<div class="progress-bar" role="progressbar" style="width: ${maps.scale }%;"
					aria-valuenow="${maps.scale }" aria-valuemin="0" aria-valuemax="100">${maps.scale }%</div>
			</div><br>
		</c:forEach>
	</div>

	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
	<script type="text/javascript">
		function vote() {
			$.post("/article/vote", $("form").serialize(), function(obj) {
				if (obj) {
					alert("投票成功")
					location.reload();
				} else {
					alert("投票失败")
				}
			})
		}
	</script>
</body>
</html>