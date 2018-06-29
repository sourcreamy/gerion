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

        <div class="content-container interest-page">
            <jsp:include page="/WEB-INF/views/jsp/common-top.jsp"></jsp:include>

            <div class="view-option">
                <ul>
                    <li class="option interest txt-bold">
                        <a href="/interest/interest.do">관심종목</a>  
                    </li>
                    <li class="option advisor">
                        <a href="/main/home.do">어드바이저</a> 
                    </li>
                    <li class="option  research ">
                        <a href="/research/news.do">리서치</a> 
                    </li>
                </ul>
            </div>
            <div class="sort-edit">
                <a href="#" class="btn-sort">정렬</a>
                <a>|</a>
                <a href="#" class="btn-edit">편집</a>
            </div>
            <div class="check-items-holder content-box">
                <span class="title">어드바이저 추천 종목</span>
                <div class="check-items">
                    <img src="/img/check-items-img.png" alt="">
                    <p class="txt-bold">빅데이터 알고리즘으로 <br>
                        추천한 종목을 지금 바로 확인하세요</p>
                    <div class="btn-holder txt-bold">
                        <a href="interest-item.html">추천 종목 확인하기</a>
                    </div>
                </div>
                <!-- <div class="items-recommended">
                        <div class="item">
                            <div class="interest-item ribboned">
                                <div class="interest-info">
                                    <span class="name">코오롱머티리얼</span>
                                </div>
                                <div class="value red">
                                    2,700,010
                                </div>
                                <div class="percent-value red">
                                    <span class="percent">+1.85%</span>
                                    <span class="value">+170</span>
                                </div>
                                <div class="bell-holder">
                                    <a href="#" class="bell bell-full"></a>
                                </div>
                            </div>         
                            <div class="line-holder clearfix">
                                <div class="blue color-box" data-value="">
                                    <span></span>
                                </div>
                                <div class="color-box red active" data-value="80">
                                    <span></span>
                                </div>
                            </div>
                            <div class="goal-box">
                                <div class="left goal-content">
                                    <span class="goal">1차 목표가 달성 완료!</span>
                                    <span class="date">2018/04/18 09:38</span>
                                </div>
                                <div class="right goal-content text-right">
                                    <span class="goal red">2차 목표가 확인하기</span>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="interest-item ribboned">
                                <div class="interest-info">
                                    <span class="name">롯데</span>
                                </div>
                                <div class="value blue">
                                    300,010
                                </div>
                                <div class="percent-value blue">
                                    <span class="percent">-1.85%</span>
                                    <span class="value">-170</span>
                                </div>
                                <div class="bell-holder">
                                    <a href="#" class="bell bell-full"></a>
                                </div>
                            </div>         
                            <div class="line-holder clearfix">
                                <div class="blue color-box active" data-value="50">
                                    <span></span>
                                </div>
                                <div class="color-box red" data-value="20">
                                    <span></span>
                                </div>
                            </div>
                            <div class="goal-box">
                                <div class="left goal-content">
                                    <span class="goal">손절가 200,000원</span>
                                </div>
                                <div class="right goal-content text-right">
                                    <span class="goal">1차 목표가 500,000원</span>
                                </div>
                            </div>
                        </div>
                </div> -->
            </div>
            <div class="divider"></div>
            <div class="content-box interes-list-container">
                <span class="title">나의 관심 종목</span>
                <div class="interest-list">
                    <c:forEach var="data" items="${interestItemList}" varStatus="status">
	                    <div class="interest-item"  onclick="javascript:goCompanyPage('${data.item_srt_cd}','${data.market_cd}');">
	                        <div class="interest-info">
	                            <span class="name">${data.item_name}</span>
	                            <c:if test="${data.purchase_price == null || data.purchase_price == ''}">
		                            <span class="info">매수가 미지정
		                            </span>
	                            </c:if>	
	                            <c:if test="${data.purchase_price != null && data.purchase_price != ''}">
		                            <span class="info">매수가 대비
		                            	<span class="blue">${upDownPer}%</span>
		                            </span>
	                            </c:if>		
	                        </div>
	                        
	                        <c:if test="${data.cmpprevddTpCd == '0'}">
                            	<div class="value red">${data.trdPrc}</div>
	                            <div class="percent-value red">
	                                <span class="percent">${data.cmpprevddPer}%</span>
	                                <span class="value">${data.cmpprevddPrc}</span>
	                            </div>
                           </c:if>
	                        <c:if test="${data.cmpprevddTpCd == '1' || data.cmpprevddTpCd == '2'}">
                            	<div class="value red">${data.trdPrc}</div>
	                            <div class="percent-value red">
	                                <span class="percent">${data.cmpprevddPer}%</span>
	                                <span class="value">${data.cmpprevddPrc}</span>
	                            </div>
                           </c:if>
                           <c:if test="${data.cmpprevddTpCd == '3' || data.cmpprevddTpCd == '6' || data.cmpprevddTpCd == '7' || data.cmpprevddTpCd == '8' || data.cmpprevddTpCd == '9'}">
                            	<div class="value red">${data.trdPrc}</div>
                            	<div class="percent-value red">
                                	<span class="percent">${data.cmpprevddPer}%</span>
                                	<span class="value">${data.cmpprevddPrc}</span>
                            	</div>
                           </c:if>
                           <c:if test="${data.cmpprevddTpCd == '4' || data.cmpprevddTpCd == '5'}">
                            	<div class="value blue">${data.trdPrc}</div>
                            	<div class="percent-value blue">
                                	<span class="percent">${data.cmpprevddPer}%</span>
                                	<span class="value">${data.cmpprevddPrc}</span>
                            	</div>
                           </c:if>
	                        <div class="bell-holder">
	                        	<c:if test="${data.alarm_cnt != '0'}">
	                            	<a href="#" class="bell bell-full"></a>
	                            </c:if>
	                            <c:if test="${data.alarm_cnt == '0'}">
	                            	<a href="#" class="bell"></a>
	                            </c:if>
	                        </div>
	                    </div>
                   	</c:forEach>
                    
                    <!-- <div class="interest-item">
                        <div class="interest-info">
                            <span class="name">티플랙스</span>
                            <span class="info">매수가 대비 
                                <span class="blue">+ 70.45%</span>
                            </span>
                        </div>
                        <div class="value red">
                            300,000
                        </div>
                        <div class="percent-value red">
                            <span class="percent">+300.85%</span>
                            <span class="value">+200,750</span>
                        </div>
                        <div class="bell-holder">
                            <a href="#" class="bell"></a>
                        </div>
                    </div>  -->
                   <!--  <div class="interest-item">
                        <div class="interest-info">
                            <span class="name">티플랙스</span>
                            <span class="info">
                                매수가 대비 
                                <span class="red">+ 10.45%</span>
                            </span>
                        </div>
                        <div class="value red">
                            300,000
                        </div>
                        <div class="percent-value red">
                            <span class="percent">+300.85%</span>
                            <span class="value">+200,750</span>
                        </div>
                        <div class="bell-holder">
                            <a href="#" class="bell"></a>
                        </div>
                    </div>
                    <div class="interest-item">
                        <div class="interest-info">
                            <span class="name">티플랙스</span>
                            <span class="info">
                                매수가 대비 <span class="red">+ 70.45%</span>
                            </span>
                        </div>
                        <div class="value red">
                        1,984,000
                        </div>
                        <div class="percent-value red">
                            <span class="percent">-1.85%</span>
                            <span class="value">-6</span>
                        </div>
                        <div class="bell-holder">
                            <a href="#" class="bell"></a>
                        </div>
                    </div>
                    <div class="interest-item">
                        <div class="interest-info">
                            <span class="name">티플랙스</span>
                            <span class="info">
                                매수가 대비 <span class="red">+ 70.45%</span>
                            </span>
                        </div>
                        <div class="value red">
                        1,910
                        </div>
                        <div class="percent-value red">
                            <span class="percent">+20.85%</span>
                            <span class="value">+2,750</span>
                        </div>
                        <div class="bell-holder">
                            <a href="#" class="bell"></a>
                        </div>
                    </div>
                    <div class="interest-item">
                        <div class="interest-info">
                            <span class="name">티플랙스</span>
                            <span class="info">
                                매수가 대비 <span class="red">+ 70.45%</span>
                            </span>
                        </div>
                        <div class="value blue">
                        300,000
                        </div>
                        <div class="percent-value blue">
                            <span class="percent">-8.85%</span>
                            <span class="value">-2100</span>
                        </div>
                        <div class="bell-holder">
                            <a href="#" class="bell"></a>
                        </div>
                    </div>
                    <div class="interest-item">
                        <div class="interest-info">
                            <span class="name">티플랙스</span>
                            <span class="info">
                                매수가 대비 <span class="red">+ 70.45%</span>
                            </span>
                        </div>
                        <div class="value red">
                            300,000
                        </div>
                        <div class="percent-value red">
                            <span class="percent">+300.85%</span>
                            <span class="value">+200,750</span>
                        </div>
                        <div class="bell-holder">
                            <a href="#" class="bell"></a>
                        </div>
                    </div> -->
                </div>
            </div>
            <div class="forads">
                <img src="/img/ads-img.png" alt="">
            </div>
            <div class="for-sort">
                <div class="sort-option">
                    <ul>
                        <li><a href="#" class="checked">사용자지정</a></li>
                        <li><a href="#">최근조회</a></li>
                        <li><a href="#">상승률</a></li>
                        <li><a href="#">하락률</a></li>
                        <li><a href="#">수익률</a></li>
                    </ul>
                </div>
            </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="/js/main.js"></script>       
    </body>
</html>
