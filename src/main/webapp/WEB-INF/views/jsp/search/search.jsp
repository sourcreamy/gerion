<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%

%>

<!DOCTYPE html>
<html lang="ko">      
<jsp:include page="/WEB-INF/views/jsp/common-header.jsp"></jsp:include>
    
<body>


<script type="text/javascript">  
  
function goSearch(){

	if($("#searchWord").val() == ""){
		alert("키워드가 입력되지 않았습니다.");
		return false;
	}else{
		
		document.location.href = "/search/search-result.do?searchWord="+encodeURIComponent($("#searchWord").val());
	}
	
}
  
function goSearchByResult(result){
	if(result != ""){
		document.location.href = "/search/search-result.do?searchWord="+encodeURIComponent(result);	
	}else{
		return false;
	}
	
}

function deleteSearchItem(keywordId,obj){
	
	
	$.ajax({ 
		type: 'post' ,
		url : "/search/deleteSearchItem.do" ,
		dataType : 'json' ,
		data : {
			keywordId : keywordId
		},
		success : function(data, textStatus, jqXHR)
		{
			if(data.resultCode == "0000"){
				
				$(obj).parent().remove();
				
				if($("#searchList").find("div").length == 0){
					$("#deleteAll").remove();
					var result = "";
					result += '<div class="no-result content-box">'; 
					result += '<div class="notfound">';
					result += '<span>최근에 검색한 내역이 없습니다</span>';
					result += '<img src="/img/alert-icon.png" alt="">';
					result += '</div>';
					result += '</div>';
					$("#recent-searches").append(result);
				}
			}else{
				alert("검색어를 삭제 하는데 오류가 발생 하였습니다.\r\n관리자에게 문의 하세요");	
			}
		} ,
		error : function(xhRequest, ErrorText, thrownError) {
		}
	}); 
	
}

function deleteSearchItemAll(){
	
	if(confirm("최근 검색어를 모두 삭제 하시겠습니까?")){
		$.ajax({ 
			type: 'post' ,
			url : "/search/deleteSearchItemAll.do" ,
			dataType : 'json' ,
			data : {
			},
			success : function(data, textStatus, jqXHR)
			{
				if(data.resultCode == "0000"){
					$("#deleteAll").remove();
					$("#searchList").remove();
					var result = "";
					result += '<div class="no-result content-box">'; 
					result += '<div class="notfound">';
					result += '<span>최근에 검색한 내역이 없습니다</span>';
					result += '<img src="/img/alert-icon.png" alt="">';
					result += '</div>';
					result += '</div>';
					$("#recent-searches").append(result);
				}else{
					alert("검색어를 삭제 하는데 오류가 발생 하였습니다.\r\n관리자에게 문의 하세요");	
				}
			} ,
			error : function(xhRequest, ErrorText, thrownError) {
			}
		});	
	}
	 
		
}


</script>




        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <div class="content-container">
            <header>
                <div class="search-icon">
                    <a style="cursor:pointer;" onclick="javascript:goSearch();"><img src="/img/search-icon.png" alt=""></a> 
                </div>
                <div class="search-container">
                    <input type="text" name="searchWord" id="searchWord" placeholder="종목명/코드 또는 키워드 입력">
                </div>
                <div class="cancel">
                    <a href="/main/home.do">취소</a>
                </div>
            </header>

            <div class="recent-searches" id="recent-searches">
            	<c:if test="${searchList != null && fn:length(searchList) != 0}">
	                <div class="head foricon" id="deleteAll">
	                    <span>최근 검색어</span>
	                    <a href="#" class="delete-all">전체삭제</a>
	                    <a onclick="javascript:deleteSearchItemAll()" class="icon-box delete"></a>
	                </div>
                </c:if>
                <c:if test="${searchList != null && fn:length(searchList) != 0}">
	                <div class="searches" id="searchList">
		                <c:forEach var="data" items="${searchList}" varStatus="status">
							<div class="search-box foricon">
		                        <a style="cursor:pointer;" onclick="javascript:goSearchByResult('${data.keyword_name}')" class="search ">${data.keyword_name}</a>
		                        <a onclick="javascript:deleteSearchItem('${data.keyword_id}',this)" class="icon-box delete"></a>
		                    </div>			
						</c:forEach>
    	            </div>
				</c:if>
                <c:if test="${searchList == null || fn:length(searchList) == 0}">
	                <div class="no-result content-box">
		                <div class="notfound">
		                    <span>최근에 검색한 내역이 없습니다</span>
		                    <img src="/img/alert-icon.png" alt="">
		                </div>
	            	</div>
                </c:if>
            </div>
        </div>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <script src="/js/main.js"></script>       
    </body>
</html>
