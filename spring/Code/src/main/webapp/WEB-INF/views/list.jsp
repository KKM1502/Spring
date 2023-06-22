<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>code</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	* {
	  margin: 0;
	  padding: 0;
	  box-sizing: border-box;
	}
	.main{
		display:grid;
		grid-template-columns: 1fr 1fr 1fr;
	}
	.item{
		width:235px;
		border:1px solid #AAA;
		font-weight: bold;
		margin:10px;
	}
	.item:hover{
		cursor:pointer;
		opacity:0.8;
	}
	.item > div:nth-child(1){
		padding: 0.5rem;
	}
	.item > div:nth-child(2){
		min-height:150px;
		padding: 0.5rem;
		displa:flex;
		justify-content:center;
		align-items:center;
		border-top:1px solid #AAA;
		border-bottom:1px solid #AAA;
		
	
	}
	.item > div:nth-child(3){
		padding: 0.5rem;
	
	}
	.filter{
		text-align:right;
		padding-right: 2rem;
	}
	.filter input{
		background-color: #FFF;
	}
</style>
</head>
<body>
	<!--  -->
	<h1>Code <small>목록보기</small></h1>
	
	<div class="filter">
		<input type="button" value="Java" data-language="java" data-selected=0 data-color="tomato">
		<input type="button" value="SQL" data-language=sql data-selected=0 data-color="gold">
		<input type="button" value="HTML" data-language="html" data-selected=0 data-color="cornflowerblue">
	</div>
	
	<div class="main">
		<c:forEach items="${list }" var="dto">
			<div class="item" onclick="location.href='view.do?seq=${dto.seq }';">	
				<c:choose>
					<c:when test="${dto.language=='java' }">
						<c:set var="color" value="tomato"></c:set>
					</c:when>
					<c:when test="${dto.language=='sql' }">
						<c:set var="color" value="gold"></c:set>
					</c:when>
					<c:when test="${dto.language=='html' }">
						<c:set var="color" value="cornflowerblue"></c:set>
					</c:when>
				</c:choose>
				<div style="background-color:${color}">${dto.language}</div>
				<div>${dto.subject}</div>
				<div>${dto.regdate}</div>
			</div>	
		</c:forEach>
	</div>
	<button type="button" class="add" onclick="location.href='/add.do'"></button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	//list.do?language=java&language=sql&language=html
	let param = '';
	
	$('.filter > input').click(function(){
		if($(this).attr('data-selected')==0){
			$(this).css('background-color',$(this).data('color'));
			$(this).attr('data-selected','1');
		}else{
			$(this).css('background-color','#FFF');
			$(this).attr('data-selected','0');
		}
	console.clear();
	
	$('.filter > input').each((index,item)=>{
		
		if($(item).attr('data-selected')=='1'){
			console.log($(item).data('language'));
			param += 'language='+$(item).data('language')+'&'
		}
		
	});
	if(param!=''){
		location.href='/list.do?' + param;
	}else{
		location.href='/list.do';
	}
	
});
	
	<c:forEach items="${language}" var="lang">
	$('.filter input[data-language=${lang}]').attr('data-selected','1');
	$('.filter input[data-language=${lang}').css('background-color',$('.filter input[data-language=${lang}]').data('color'));

	</c:forEach>
	
	
</script>
</body>
</html>






