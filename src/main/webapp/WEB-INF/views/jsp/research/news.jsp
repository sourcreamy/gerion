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


 function getNewsData(obj,keyword){
	
	 
	// alert($("#selectedStatus").children().length);
	 
	//alert($("#selectedStatus").children().first().get(0));	
	//alert($(obj).parent().get(0));
	
 	 if($("#selectedStatus").children().first().get(0) == $(obj).parent().get(0)){				//전체를 클릭 한경우
					
 		$("#selectedStatus").children().each(function(index,element){
 			$(this).removeClass('selected');
 		});
 		$(obj).parent().addClass('selected');
	}else{
			
	} 
	
	
	
/* 	
	
	$.ajax({ 
		type: 'post' ,
		url : "/research/newsSearch.do?&keyword="+keyword ,
		dataType : 'json' ,
		data : {
			
		},
		success : function(data, textStatus, jqXHR)
		{
			alert(data);
		} ,
		error : function(xhRequest, ErrorText, thrownError) {
		}
	});
	
	 */
	
	
} 

 function goNewsPage(uri){
		
		//var replaceUrlStr = replaceAll(url, "?", "^");
		//replaceUrlStr = replaceAll(replaceUrlStr, "=", "+");
		
		var replaceUrlStr = encodeURIComponent(uri)
		document.location.href = "/news/newsPage.do?newsUri="+replaceUrlStr;
	}  


    
</script>


        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <div class="content-container">
            <jsp:include page="/WEB-INF/views/jsp/common-top.jsp"></jsp:include>
            <div class="view-option">
                <ul>
                    <li class="option interest">
                        <a href="/interest/interest.do">관심종목</a>  
                    </li>
                    <li class="option advisor">
                        <a href="/main/home.do">어드바이저</a> 
                    </li>
                    <li class="option  research txt-bold">
                        <a href="/research/news.do">리서치</a> 
                    </li>
                </ul>
            </div>
            <div class="news-market-analysis clearfix">
                <ul>
                    <li class="active"><a href="/research/news.do">뉴스</a></li>
                    <li><a href="/research/market.do">시황</a></li>
                    <li><a href="/research/premiumanalysis.do">프리미엄분석</a></li>
                </ul>
            </div>
            <div class="view-category">
                <a href="/main/keywords.do" class="plus"><img src="/img/plus-black-icon.png" alt=""></a>
                <div class="cactegory-list-container">
                    <ul id="selectedStatus">
                        <li class="selected">
                            <a onclick="javascript:getNewsData(this,'${searchWord}');">전체</a>
                        </li>
                    	<c:forEach var="data" items="${newsCategoryList}" varStatus="status">
							<li>
                            <a onclick="javascript:getNewsData(this,'${data.news_category_name}');">${data.news_category_name}</a>
                        </li>		
						</c:forEach>
                        <c:forEach var="data" items="${userCategoryList}" varStatus="status">
							<li>
                            <a onclick="javascript:getNewsData(this,'${data.category_name}');">${data.category_name}</a>
                        </li>		
						</c:forEach>
                        
                        <!-- <li>
                            <a href="#">정치</a>
                        </li>
                        <li>
                            <a href="#">경제</a>
                        </li>
                        <li>
                            <a href="#">사회</a>
                        </li>
                        <li>
                            <a href="#">IT</a>
                        </li>
                        <li>
                            <a href="#">문화</a>
                        </li>
                        <li>
                            <a href="#">세계</a>
                        </li>
                        <li>
                            <a href="#">연예</a>
                        </li> -->
                    </ul>
                </div>  

            </div>
            <div class="search-result news-list content-box">
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
                    
                        <!-- <div class="news-box clearfix">
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
                        <div class="news-box clearfix">
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
                        <div class="news-box clearfix">
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
                        <div class="news-box clearfix">
                                <div class="news-info ">
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
                            </div> -->
                    </div>
                </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="/js/main.js"></script>       
    </body>
</html>
