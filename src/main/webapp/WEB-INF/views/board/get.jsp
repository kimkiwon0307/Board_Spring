<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../includes/header.jsp" %>
          
           <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Register</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
           <!--  태그 name 속성과 BoardVO 클래스의 변수와 일치 시켜야 한다. -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
            				Board Register
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                        		<div class="form-group">
                       				<label>Bno</label> 
                       				<input class="form-control" name='bno' value='<c:out value="${board.bno}"/>' readonly="readonly">
                       			</div>
                       		
                       			<div class="form-group">
                       				<label>Title</label>
                       				 <input class="form-control" name='title' value='<c:out value="${board.title}"/>' readonly="readonly">
                       			</div>
                       			<div class="form-group">
                       				<label>Text area</label>
                       				<textarea class="form-control" rows="3" name='content' readonly="readonly">
                       				<c:out value="${board.content}"/></textarea>
                       			</div>
                       			<div class="form-group">
                       				<label>Writer</label>
                       				<input class="form-control" name='writer' value='<c:out value="${board.writer}"/>' readonly="readonly">
                       			</div>
                       			<button data-oper='modify' class="btn btn-default">modify</button>
                       			<button data-oper='list' class="btn btn-info">List</button>
                       			
                       						<!-- Reply Form {s} -->
	<%-- 		<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
				
					<form role="form" action="/reply/getReplyList" method="post">
                       			
                       			<div class="form-group">
                       				<input type="hidden" class="form-control" name='bno'>
                       			</div>
                       			<div class="form-group">
                       				<label>댓글</label>
                       				<textarea class="form-control" rows="3" name='reply'></textarea>
                       			</div>
                       			<div class="form-group">
                       				<label>작성자</label><input class="form-control" name='replyer'>
                       			</div>
                       			<button type="submit" class="btn btn-default" id="btnReplySave">작성</button>
                       		</form>
			</div>
 --%>

			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">

			<form:form name="form" id="form" role="form" modelAttribute="reply" method="post">

				<form:hidden path="bno" id="bno"/>

				<div class="row">

					<div class="col-sm-10">
						<form:textarea path="reply" id="reply" class="form-control" rows="3" placeholder="댓글을 입력해 주세요"></form:textarea>
					</div>

					<div class="col-sm-2">
						<form:input path="replyer" class="form-control" id="replyer" placeholder="댓글 작성자"></form:input>
						<button type="submit" class="btn btn-sm btn-primary" id="btnReplySave" style="width: 100%; margin-top: 10px"> 저 장 </button>

					</div>

				</div>

				</form:form>

			</div> 

			<!-- Reply Form {e} -->

			<!-- Reply List {s}-->

			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">

				<h6 class="border-bottom pb-2 mb-0">Reply list</h6>

				<div id="replyList"></div>

			</div> 
                       			<form id='operForm' action="/board/modify" method="get" model>
                       				<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
                       			</form>
                       			
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
       <%@include file="../includes/footer.jsp" %>
<script>
	$(document).ready(function(){
		
		var operForm = $("#operForm");
		
		showReplyList();
		
		$("button[data-oper='modify']").on("click",function(e){
			
			operForm.attr("action","/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click",function(e){
			
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list")
			operForm.submit();
		});
		
		
		function showReplyList(){

			var url = "/reply/getReqlyList";
			
			
			var paramData = {"bno" : "${board.bno}"};

			$.ajax({

	            type: 'POST',

	            url: url,

	            data: paramData,

	            dataType: 'json',

	            success: function(result) {

	               	var htmls = "";

				if(result.length < 1){

					htmls.push("등록된 댓글이 없습니다.");

				} else {

		                    $(result).each(function(){

		                     htmls += '<div class="media text-muted pt-3" id="rno' + this.rno + '">';

		                     htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';

		                     htmls += '<title>Placeholder</title>';

		                     htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';

		                     htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';

		                     htmls += '</svg>';

		                     htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';

		                     htmls += '<span class="d-block">';

		                     htmls += '<strong class="text-gray-dark">' + this.replyer + '</strong>';

		                     htmls += '<span style="padding-left: 7px; font-size: 9pt">';

		                     htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.rno + ', \'' + this.replyer + '\', \'' + this.reply + '\' )" style="padding-right:5px">수정</a>';

		                     htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.rno + ')" >삭제</a>';

		                     htmls += '</span>';

		                     htmls += '</span>';

		                     htmls += this.reply;

		                     htmls += '</p>';

		                     htmls += '</div>';

		                });	//each end
				}
				$("#replyList").html(htmls);

	            }	   // Ajax success end

			});	// Ajax end
		}
		
		

	});

	

	
	
</script>