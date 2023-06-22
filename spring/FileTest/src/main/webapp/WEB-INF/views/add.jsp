<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	#attach-zone{
		border: 1px solid car(--border-color);
		background-color : var(--back-color);
		width: cal(100% - 20px);
		height: 150px;
		overflow: auto;
	}
	#attach-zone .item{
		display: flex;
		justify-content:space-around
	}
		
	
</style>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="/file/addok.do" method="post" enctype="multipart/form-data">
		<table class="vertical">
			<tr>
				<td>텍스트</td>
				<td><input type="text" name = "txt"></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name = "attach"></td>
			</tr>
		
		</table>
		<div>
			<button>보내기</button>
		</div>
	</form>
		
	<hr>
	<h1>다중 파일 업로드</h1>
	<form id="form2" action="/file/multiaddok.do" method="post" enctype="multipart/form-data">
		<table class="vertical">
			<tr>
				<td>텍스트</td>
				<td><input type="text" name = "txt"></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name = "attach" multiple></td>
			</tr>
		
		</table>
		<div>
			<button>보내기</button>
		</div>
	</form>
		
	<hr>
	<h1>다중 파일 업로드(Drag&drop)</h1>
	<form id="form3" action="/file/multiaddok.do" method="post" enctype="multipart/form-data">
		<table class="vertical">
			<tr>
				<td>텍스트</td>
				<td><input type="text" name = "txt"></td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
				<div id="attach-zone"></div>
				<input type="file" name = "attach" style="display:none;" id="attach3"></td>
			</tr>
		
		</table>
		<div>
			<button>보내기</button>
		</div>
	</form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	
	function checkFile(filename, filesize) {
	
	   //제한될 사이즈a
	   const maxsize = 10485760; //10MB
	
	   //업로드 못하게 막을 파일 유형
	   const regex = /(.*?)\.(exe|sh)$/gi;
	
	   if (filesize >= maxsize) {
	      alert('단일 파일의 크기가 10MB 이하만 가능합니다.');
	      return false;
	   }
	
	   //발견하면 true= 해당 파일 업로드 X 발견 못하면 false
	   if (regex.test(filename)) {
	      alert('해당 파일은 업로드 할 수 없습니다.');
	      return false;
	   }
	
	   //전부 통과하면 true
	   return true;
	
	}
	
	/* 10MB 넘어가는 것들 전송 안되게하는 처리*/
	
	//전송되기 바로 직전에 발생하는 이벤트
	$('#form1').submit(function() {
	
	   let filename = $('input[name=attach]')[0].files[0].name;
	   alert(filename);
	
	   let filesize = $('input[name=attach]')[0].files[0].size;
	   alert(filesize);
	
	   if (!checkFile(filename, filesize)) {
	
	      //전송 금지 / 전송 취소 처리
	      event.preventDefault();
	      return false;
	   }
	
	});
	
	$('#form2').submit(function() {
		let totalsize=0;
	   Array.from($('input[name=attach]')[1].files).forEach(file =>{
		   
		   if (!checkFile(file.name, file.size)) {
				
			      //전송 금지 / 전송 취소 처리
			      event.preventDefault();
			      return false;
			   }
		   totalsize += file.size;
	   });
	   if(totalsize >=52428800){
		   alert("총파일 크기의 합이 50MB이하만 가능");
	   	//전송 금지 / 전송 취소 처리
	      event.preventDefault();
	      return false;
	   }
	
	});
	
$('#attach-zone')
	.on('dragenter',function(e){
		e.preventDefault();
		e.stopPropagation();
	})
	.on('dragover',function(e){
		e.preventDefault();
		e.stopPropagation();
		$(this).css("background-color","gold");
	})
	.on('dragleave',function(e){
		e.preventDefault();
		e.stopPropagation();
		$(this).css("background-color","var(--back-color)");
	})
	.on('drop',function(e){
		e.preventDefault();
		let temp = '';
		$(this).html('');
		const files = e.originalEvent.dataTransfer.files;
		if(files!=null & files != undefined){
			for(let i =0; i< files.length; i++){
				let f = files[i];
				
				let filename= f.name;
				let filesize = f.size/1024/1024;//MB 반환
				
				filesize = filesize <1? filesize.toFixed(2):filesize.toFixed(1);
				temp +=`
					<div class="item">
						<span style="text-align:left;">\${filename}</span>
						<span style="text-align:right;">\${filesize}MB</span>
					</div>
				`;
			}
			$(this).append(temp);
		}
		$(this).css("background-color","var(--back-color)");
		$('#attach3').prop('files',files);
	});
	
</script>
</body>
</html>