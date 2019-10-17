<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章标题列表</title>
</head>
<body>
	<div id="content">

		<ul class="list-unstyled">

			<c:forEach items="${articles }" var="a">
				<li class="media"><a href="/article/select?id=${a.id }" target="_blank" ><img  class="mr-3" src="/pic/${a.picture }"
					alt="no pic" width="150px" height="100px" >
					</a>
					<div class="media-body">
					     <dl>
					      <dt><a href="/article/select?id=${a.id }" target="_blank">${a.title}</a></dt>
					      <dd>${a.nickname } ${a.updated }</dd>
					     </dl>
					</div></li>
<hr>
			</c:forEach>

		</ul>
         ${pages }
	</div>
<script type="text/javascript">

$(function(){
      $('.page-link').click(function (e) {
      	  //获取点击的的url
          var url = $(this).attr('data');
      
         //在中间区域显示地址的内容
         $('#content').load(url);
      });
	
})
</script>
</body>
</html>