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
<!--[if gt IE 8]><!--> <html class="no-js" lang="kr"> <!--<![endif]-->
    <jsp:include page="/WEB-INF/views/jsp/common-header.jsp"></jsp:include>
    <body class=>
    
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
                    <a href="/search/search.do"><img src="/img/search-icon.png" alt=""></a>
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
                        <li class="active"><a href="company.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">기업개요</a></li>
                        <li><a href="company-news.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">뉴스</a></li>
                        <li><a href="company-analysis.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">프리미엄 종목 분석</a></li>
                    </ul>
                </div>
                <div class="overview-box active content-view">
                        <div class="view-details">
                            <div class="overview detail-box">
                                <span class="price">현재가</span>
                                <div class="price-info-box">
                                	<c:if test="${cmpprevddTpCd == '1' || cmpprevddTpCd == '2'}">
	                                    <span class="price-val">${trdPrc}</span>
	                                    <div class="percent-value">
	                                        <span>${cmpprevddPer}%</span>
	                                        <span>${cmpprevddPrc}</span>
	                                    </div>
                                    </c:if>
                                    <c:if test="${cmpprevddTpCd == '3' || cmpprevddTpCd == '6' || cmpprevddTpCd == '7' || cmpprevddTpCd == '8' || cmpprevddTpCd == '9'}">
	                                    <span class="price-val">${trdPrc}</span>
	                                    <div class="percent-value">
	                                        <span>${cmpprevddPer}%</span>
	                                        <span>${cmpprevddPrc}</span>
	                                    </div>
                                    </c:if>
                                    <c:if test="${cmpprevddTpCd == '4' || cmpprevddTpCd == '5'}">
	                                    <span class="price-val-blue">${trdPrc}</span>
	                                    <div class="percent-value-blue">
	                                        <span>${cmpprevddPer}%</span>
	                                        <span>${cmpprevddPrc}</span>
	                                    </div>
                                    </c:if>
                                </div>
                                <div class="other-info d-table">
                                    <div class="list-category left t-cell">
                                        <span class="label-text">상장구분</span>
                                        <c:if test="${itemMap.market_cd == 'kospi'}">
                                        	<span class="value">코스피</span>
                                        </c:if>
                                        <c:if test="${itemMap.market_cd == 'kosdaq'}">
                                        	<span class="value">코스닥</span>
                                        </c:if>
                                    </div>
                                    <div class="sector t-cell right">
                                        <span class="label-text">업종</span>
                                        <span class="value">
                                            ${itemMap.midclss_name}
                                        </span>
                                    </div>
                                </div>
                                <div class="other-info d-table">
                                    <div class="market-capitaliztion left t-cell">
                                        <span class="label-text">시가총액</span>
                                        <span class="value">${rtnval}</span>
                                    </div>
                                    <div class="sector t-cell right">
                                        <span class="label-text">거래량</span>
                                        <span class="value">
                                            ${accTrdvol}
                                            <span class="sub">전일대비 <br/>${accTrdvolPer}%</span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="divider"></div>
                        <div class="view-details bottom">
                            <div class="detail-box">
                                <div class="other-info d-table">
                                    <div class="eps left t-cell">
                                        <span class="label-text">EPS</span>
                                        <span class="value">${eps}</span>
                                    </div>
                                    <div class="per t-cell right">
                                        <span class="label-text">PER</span>
                                        <span class="value">${per}</span>
                                    </div>
                                </div>
                                <div class="other-info d-table">
                                	<div class="per t-cell left">
                                        <span class="label-text">BPS</span>
                                        <span class="value">${bps}</span>
                                    </div>
                                    <div class="eps right t-cell">
                                        <span class="label-text">PBR</span>
                                        <span class="value">${pbr}</span>
                                    </div>
                                </div>
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
