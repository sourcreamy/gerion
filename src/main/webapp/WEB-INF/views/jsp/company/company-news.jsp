<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%

%>

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <jsp:include page="/WEB-INF/views/jsp/common-header.jsp"></jsp:include>
    <body>
    
   <script type="text/javascript">  
    
    
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
            <header class="clearfix">
                <div class="search-icon">
                    <a style="cursor:pointer;" onclick="javascript:history.go(-1);" class="goback"><img src="/img/back-icon.png" alt=""></a> 
                </div>
                <div class="page-title txt-medium">
                    기업상세
                </div>
                <div class="menu-bar pull-right withsearch">
                    <a href="search.do"><img src="/img/search-icon.png" alt=""></a>
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="divider"></div>
            <div class="company-details-container">
                <div class="company-name">
                    <span class="name txt-bold">${itemMap.item_name} (${itemMap.item_srt_cd})</span>
                    <c:if test="${itemMap.interest_item_id != null}">
                    	<a onclick="javascript:selectInterestItem('${itemMap.item_srt_cd}','${itemMap.market_cd}',this)" class="heart heart-full"></a>
                    </c:if>
                    <c:if test="${itemMap.interest_item_id == null}">
                    	<a onclick="javascript:selectInterestItem('${itemMap.item_srt_cd}','${itemMap.market_cd}',this)" class="heart"></a>
                    </c:if>
                </div>
                <div class="company-views">
                    <ul>
                        <li><a href="company-ticker.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">시세알림설정</a></li>
                        <li><a href="company.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">기업개요</a></li>
                        <li class="active"><a href="company-news.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">뉴스</a></li>
                        <li><a href="company-analysis.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">프리미엄 종목 분석</a></li>
                    </ul>
                </div>
                <div class="companynews-container content-view">
                        <div class="search-result content-box">
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
                                </div> -->
                            </div>
                        </div>
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