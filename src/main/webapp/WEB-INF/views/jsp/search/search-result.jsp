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

$(document).ready(function(){
	
	//getNewsData("${searchWord}");
	
});


/* function getNewsData(keyword){
	
	$.ajax({ 
		type: 'post' ,
		url : "http://newssearch.naver.com/search.naver?where=rss&query="+keyword ,
		dataType : 'xml' ,
		data : {
			
		},
		success : function(data, textStatus, jqXHR)
		{
			alert(data);
		} ,
		error : function(xhRequest, ErrorText, thrownError) {
		}
	}); 
	
} */


function goSearch(){

	if($("#searchWord").val() == ""){
		alert("키워드가 입력되지 않았습니다.");
		return false;
	}else{
		document.location.href = "/search/search-result.do?searchWord="+encodeURIComponent($("#searchWord").val());
	}
	
}
  

function replaceAll(str, searchStr, replaceStr) {
	  return str.split(searchStr).join(replaceStr);
	}

function goNewsPage(uri){
	
	//var replaceUrlStr = replaceAll(url, "?", "^");
	//replaceUrlStr = replaceAll(replaceUrlStr, "=", "+");
	
	var replaceUrlStr = encodeURIComponent(uri)
	document.location.href = "/news/newsPage.do?newsUri="+replaceUrlStr;
}    
    
    
    
function selectInterestItem(itemCd,marketCd,obj){
	
	$.ajax({ 
		type: 'post' ,
		url : "/interest/selectInterestItem.do" ,
		dataType : 'json' ,
		data : {
			itemCd : itemCd,
			marketCd : marketCd
		},
		success : function(data, textStatus, jqXHR)
		{
			if(data.resultCode == "0000"){
				insertInterestItem(itemCd,marketCd,obj);
			}else{
				deleteInterestItem(itemCd,marketCd,obj);
			}
		} ,
		error : function(xhRequest, ErrorText, thrownError) {
		}
	}); 
	
	
}    
    
function insertInterestItem(itemCd,marketCd,obj){
	
	$.ajax({ 
		type: 'post' ,
		url : "/interest/insertInterestItem.do" ,
		dataType : 'json' ,
		data : {
			itemSrtCd : itemCd,
			marketCd : marketCd
		},
		success : function(data, textStatus, jqXHR)
		{
			if(data.resultCode == "0000"){
				$(obj).addClass('heart-full');
			}else if(data.resultCode == "E002"){
					alert("로그인 되지 않음");
			}
		} ,
		error : function(xhRequest, ErrorText, thrownError) {
		}
	}); 
}    
    
  

function deleteInterestItem(itemCd,marketCd,obj){
	
	$.ajax({ 
		type: 'post' ,
		url : "/interest/deleteInterestItem.do" ,
		dataType : 'json' ,
		data : {
			itemSrtCd : itemCd,
			marketCd : marketCd
		},
		success : function(data, textStatus, jqXHR)
		{
			if(data.resultCode == "0000"){
				$(obj).removeClass('heart-full');
			}else if(data.resultCode == "E002"){
					alert("로그인 되지 않음");
			}
		} ,
		error : function(xhRequest, ErrorText, thrownError) {
		}
	}); 
}    


function goCompanyPage(itemSrtCd,marketCd){
	
	document.location.href = "/company/company.do?itemSrtCd="+itemSrtCd+"&marketCd="+marketCd;
	
}

function goCompanyNewsPage(itemSrtCd,marketCd){
	
	document.location.href = "/company/company-news.do?itemSrtCd="+itemSrtCd+"&marketCd="+marketCd;
	
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
                    <a style="cursor:pointer;" onclick="javascript:history.go(-1);">취소</a>
                </div>
            </header>

            <div class="recent-searches">
                <div class="head foricon">
                    <span>종목(${itemListCount})</span>
                    <!-- <a href="#" class="delete-all">전체삭제</a>
                    <a href="#" class="icon-box delete"></a> -->
                </div>
                <div class="searches">
                	<c:forEach var="data" items="${itemList}" varStatus="status">
						<div class="search-box foricon">
                        	<a onclick="javascript:goCompanyPage('${data.item_srt_cd}','${data.market_cd}');" class="search ">${data.item_name}(${data.item_srt_cd})</span></a>
                        	<c:if test="${data.interest_item_id != null}">
                        		<a onclick="javascript:selectInterestItem('${data.item_srt_cd}','${data.market_cd}',this)" class="icon-box heart heart-full"></a>
                        	</c:if>
                        	<c:if test="${data.interest_item_id == null}">
                        		<a onclick="javascript:selectInterestItem('${data.item_srt_cd}','${data.market_cd}',this)" class="icon-box heart"></a>
                        	</c:if>
                    	</div>			
					</c:forEach>
                    <!-- <div class="search-box foricon">
                        <a href="#" class="search ">삼성전자</span>
                        <a href="#" class="icon-box heart"></a>
                    </div>
                    <div class="search-box foricon">
                        <a href="#" class="search">LG전자</span>
                        <a href="#" class="icon-box heart heart-full"></a>
                    </div> -->
                </div>
            </div>

            <div class="search-result content-box">
                <span class="title withchev" onclick="javascript:goCompanyNewsPage('${itemSrtCd}','${marketCd}');">뉴스(${feedListCount})</span>
                <div class="news-container clearfix">
                	<c:forEach var="data" items="${feedList}" varStatus="status">
                		<c:if test="${data.thumbnailUrl != ''}">
			                <div class="news-box">
			                        <div class="news-info clearfix">
			                            <img src="${data.thumbnailUrl}" alt="">
			                            <div class="news-content" linkUrl="${data.link}" onclick="javascript:goNewsPage('${data.link}');">
			                                <span class="news-title">
			                                    ${data.title} 
			                                </span>
			                                <div class="category-box">
			                                    <span class="category">${data.author}</span>
			                                    <span class="timepost">38분전</span>
			                                </div>
			                            </div>
			                        </div>
			                    </div>
		                   </c:if>
	                    <c:if test="${data.thumbnailUrl == ''}">
		                	<div class="news-box">
		                        <div class="news-info clearfix">
		                            <div class="news-content noimg" linkUrl="${data.link}" onclick="javascript:goNewsPage('${data.link}');">
		                                <span class="news-title">
		                                    ${data.title} 
		                                </span>
		                                <div class="category-box">
		                                    <span class="category">아시아경제</span>
		                                    <span class="timepost">38분전</span>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
	                    </c:if>
                		</c:forEach>
                
                
                
                   <!--  <div class="news-box">
                        <div class="news-info clearfix">
                            <img src="/img/news-pic.png" alt="">
                            <div class="news-content">
                                <span class="news-title">
                                    [집단행동 나선 중소소상공인]
                                    주물공업동조합, 생산중단 오늘 결론
                                </span>
                                <div class="category-box">
                                    <span class="category">아시아경제</span>
                                    <span class="timepost">38분전</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="news-box">
                        <div class="news-info clearfix">
                            <div class="news-content noimg">
                                <span class="news-title">
                                    [집단행동 나선 중소소상공인]
                                    주물공업동조합, 생산중단 오늘 결론
                                </span>
                                <div class="category-box">
                                    <span class="category">아시아경제</span>
                                    <span class="timepost">38분전</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="news-box">
                        <div class="news-info clearfix">
                            <img src="/img/news-pic.png" alt="">
                            <div class="news-content">
                                <span class="news-title">
                                    [집단행동 나선 중소소상공인]
                                    주물공업동조합, 생산중단 오늘 결론
                                </span>
                                <div class="category-box">
                                    <span class="category">아시아경제</span>
                                    <span class="timepost">38분전</span>
                                </div>
                            </div>
                        </div>
                    </div> -->
                </div>
            </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="http://gfplant.com/js/jquery.viewportchecker.js"></script>    
    <script src="/js/main.js"></script>       
    </body>
</html>
