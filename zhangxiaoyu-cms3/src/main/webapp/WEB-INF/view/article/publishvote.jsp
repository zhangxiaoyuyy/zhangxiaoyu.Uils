<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>发布文章</title>

</head>

<body>

	<button type="button" class="btn btn-info" onclick="addCard()">增加选项</button>
	<button type="button" class="btn btn-success" onclick="publishVote()">发起投票</button>

	<form id="form1">
		<div class="form-group">
			<label for="title">标题</label> <input type="text" class="form-control"
				name="title" id="title">

		</div>
		<hr>

		<div id="mdiv" align="left" >
			<input type="text" name="descr" class="form-control" placeholder="选项1"><br>
		</div>

	</form>

	<script type="text/javascript">
		var i = 2;
		function addCard() {
			$("#mdiv")
					.append(
							"<input type='text' name='descr' class='form-control' placeholder='选项"+i+"' ><br>");
			i++;
		}

		//发布文章
		function publishVote() {
			var formData = new FormData($("#form1")[0]);
			$.ajax({
				type : "post",
				data : formData,
				// 告诉jQuery不要去处理发送的数据
				processData : false,
				// 告诉jQuery不要去设置Content-Type请求头
				contentType : false,
				url : "/article/publishVote",
				success : function(flag) {
					if (flag) {
						alert("发布成功");
					} else {
						alert("发布失败")
					}
				}
			})
		}
	</script>
</body>
</html>



</body>
</html>