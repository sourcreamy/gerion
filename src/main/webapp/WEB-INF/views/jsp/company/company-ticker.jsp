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
 
 
 	$(document).ready(function(){
		
		//getNewsData("${searchWord}");
		
	}); 
 
 	var rgx1 = /\D/g;  // /[^0-9]/g 와 같은 표현
 	var rgx2 = /(\d+)(\d{3})/; 

 	
 	function setComma(inNum){
 	     
 	     var outNum;
 	     outNum = inNum; 
 	     while (rgx2.test(outNum)) {
 	          outNum = outNum.replace(rgx2, '$1' + ',' + '$2');
 	      }
 	     return outNum;

 	}
 	
 	function comma(str) {
 	    str = String(str);
 	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
 	}
 	
 	function getNumber(obj){
 		
 	     var num01;
 	     var num02;
 	     num01 = obj.value;
 	     num02 = num01.replace(rgx1,"");
 	      num01 = setComma(num02); 
 	     //num01 = num02;
 	     obj.value =  num01;
 	     
 	}	
 
 	
 	
 function removeComma(str){
	 
		n = parseInt(str.replace(/,/g,""));
		return n;
		
	}

 	
 	
  function setAmount(val){
	  
	 // alert(removeComma($("#trdPrc").html()));
	 
	  var value = removeComma($("#trdPrc").html());
	  $("#priceOrder").val(comma(parseInt(Number(value * (1 + val / 100)))));
  }
 
 
 
 function priceOrderPlus(){
	 
	 if($("#priceOrder").val() != ""){
		 var val = removeComma($("#priceOrder").val());
		 val += 1;
	 	$("#priceOrder").val(comma(val));
	 }
	 
 }
 
 
 function priceOrderMinus(){
	 
	 if($("#priceOrder").val() != ""){
		 var val = removeComma($("#priceOrder").val());
		 val -= 1;
	 	$("#priceOrder").val(comma(val));	 
	 }
	 
 }
 
 
 function deleteTargetPriceAlarm(targetPriceAlarmId,obj){
	 
	 
	 //alert(targetPriceAlarmId);
	 
	  $.ajax({ 
	 		type: 'post' ,
	 		url : "/company/deleteTargetPriceAlarm.do" ,
	 		dataType : 'json' ,
	 		data : {
	 			targetPriceAlarmId : targetPriceAlarmId
	 		},
	 		success : function(data, textStatus, jqXHR)
	 		{
	 			if(data.resultCode == "0000"){
	 				$(obj).parent().remove();
	 			}else if(data.resultCode == "E002"){
	 				//	alert("로그인 되지 않음");
	 			}
	 		} ,
	 		error : function(xhRequest, ErrorText, thrownError) {
	 		}
	 	});  
	 
 }
 
 
 function selectInterestItem(itemCd,marketCd,obj){
 	
	 if(obj == null){
		 obj = $("#forHeart"); 
	 }
	 	 
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
 				insertTargetPriceAlarm(itemCd,marketCd,obj);
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
 				insertTargetPriceAlarm(itemCd,marketCd,obj);
 			}else if(data.resultCode == "E002"){
 					alert("로그인 되지 않음");
 			}
 		} ,
 		error : function(xhRequest, ErrorText, thrownError) {
 		}
 	}); 
 }    
     
 
 function insertTargetPriceAlarm(itemCd,marketCd,obj){
	 
	 	$.ajax({ 
	 		type: 'post' ,
	 		url : "/company/insertTargetPriceAlarm.do" ,
	 		dataType : 'json' ,
	 		data : {
	 			itemSrtCd : itemCd,
	 			marketCd : marketCd,
	 			targetPrice : removeComma($("#priceOrder").val())
	 		},
	 		success : function(data, textStatus, jqXHR)
	 		{
	 			if(data.resultCode == "0000"){
	 				alert("알림 목록에 추가 되었습니다.");
	 				var result = "";
	 				result += '<div class="ticker-item">';
	 				result += '<span>'+$("#priceOrder").val()+'원 </span>';
	 				result += '<a onclick="javascript:deleteTargetPriceAlarm(\''+data.resultData.targetPriceAlarmId+'\',this);" class="delete"></a>';
	 				result += '</div>';
	 				$("#ticker-list").append(result);
	 				
	 			}else if(data.resultCode == "E002"){
	 				//	alert("로그인 되지 않음");
	 			}
	 		} ,
	 		error : function(xhRequest, ErrorText, thrownError) {
	 		}
	 	}); 
	 
 }
 
 
 
 function addAlarm(itemCd,marketCd){

	 if($("#priceOrder").val() == ""){
		 alert("지정가가 설정 되지 않았습니다.");
		 return false;
	 }else{
		 //관심종목이 아닌경우 관심종목으로 등록 한다.
		 selectInterestItem(itemCd,marketCd,null);		 
	 }
	 
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
                    	<a onclick="javascript:selectInterestItem('${itemMap.item_srt_cd}','${itemMap.market_cd}',this)" id="forHeart" class="heart heart-full"></a>
                    </c:if>
                    <c:if test="${itemMap.interest_item_id == null}">
                    	<a onclick="javascript:selectInterestItem('${itemMap.item_srt_cd}','${itemMap.market_cd}',this)" id="forHeart" class="heart"></a>
                    </c:if>
                </div>
                <div class="company-views">
                    <ul>
                        <li class="active"><a href="company-ticker.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">시세알림설정</a></li>
                        <li><a href="company.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">기업개요</a></li>
                        <li><a href="company-news.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">뉴스</a></li>
                        <li><a href="company-analysis.do?itemSrtCd=${itemMap.item_srt_cd}&marketCd=${itemMap.market_cd}">프리미엄 종목 분석</a></li>
                    </ul>
                </div>         
                <div class="ticker-notifications view-details">
                    <div class="overview detail-box">
                        <span class="price">현재가</span>
                        <%-- <div class="price-info-box">
                            <span class="price-val blue" id="trdPrc">${trdPrc}</span>
                            <div class="percent-value">
                                <span>${cmpprevddPer}%</span>
                                <span>${cmpprevddPrc}</span>
                            </div>
                        </div> --%>
                        <div class="price-info-box">
                                	<c:if test="${cmpprevddTpCd == '1' || cmpprevddTpCd == '2'}">
	                                    <span class="price-val"  id="trdPrc">${trdPrc}</span>
	                                    <div class="percent-value">
	                                        <span>${cmpprevddPer}%</span>
	                                        <span>${cmpprevddPrc}</span>
	                                    </div>
                                    </c:if>
                                    <c:if test="${cmpprevddTpCd == '3' || cmpprevddTpCd == '6' || cmpprevddTpCd == '7' || cmpprevddTpCd == '8' || cmpprevddTpCd == '9'}">
	                                    <span class="price-val"  id="trdPrc">${trdPrc}</span>
	                                    <div class="percent-value">
	                                        <span>${cmpprevddPer}%</span>
	                                        <span>${cmpprevddPrc}</span>
	                                    </div>
                                    </c:if>
                                    <c:if test="${cmpprevddTpCd == '4' || cmpprevddTpCd == '5'}">
	                                    <span class="price-val-blue" id="trdPrc">${trdPrc}</span>
	                                    <div class="percent-value-blue">
	                                        <span>${cmpprevddPer}%</span>
	                                        <span>${cmpprevddPrc}</span>
	                                    </div>
                                    </c:if>
                                </div>
                    </div>
                </div>
                <div class="divider"></div>
                <div class="add-ticker-container">
                    <div class="add-ticker">
                        <div class="ticker">
                            <span>시세 알림 추가</span>  
                            <img src="/img/qm-icon.png" alt="">
                        </div>
                        <div class="note">
                            <span>매수가를 입력하면 실시간으로</span> 
                            <span>수익률을 알려드립니다.</span> 
                        </div>          
                    </div>
                    <div class="number-sheets">
                        <span class="head">매수가 입력</span>
                        <div class="label-input">
                            <input type="text" placeholder="매수가 입력" id="purchasePrice">
                        </div>
                        <div class="checker" onclick="javascript:purchaseNone();">
                            <img src="/img/check-sheet-icon.png" alt="">
                            <span>해당없음</span>
                        </div>
                    </div>    
                    <div class="divider"></div>
                    <div class="assigned-setting">
                        <span class="title">지정가 설정 </span>
                        <div class="price-input-box">
                            <select onchange="javascript:setAmount(this.value)">
                            	<c:forEach var="val" begin="0" end="60" step="1" varStatus="status">
                            		<c:if test="${val == 30}">
								    	<option value="${30-val}"  selected>현재가 대비 ${30-val}%</option>
								    </c:if>
								    <c:if test="${val != 30}">
								    	<option value="${30-val}">현재가 대비 ${30-val}%</option>
								    </c:if>
								</c:forEach>
                            </select>
                            <div class="direct-input">
                                <input type="text"  onkeyup="javascript:getNumber(this);" placeholder="직접 입력" id="priceOrder">
                                <div class="add-minus-box">
                                    <a onclick="javascript:priceOrderMinus();"></a>
                                    <a onclick="javascript:priceOrderPlus();"></a>
                                </div>
                                <a onclick="javascript:addAlarm('${itemMap.item_srt_cd}','${itemMap.market_cd}');" class="btn-addnotif">알림 추가</a>
                            </div>
                        </div>
                    </div>
                    <div class="divider"></div>
                    <div class="ticker-list-container content-box">
                        <span class="title">시세 알림 목록</span>
                        <div class="ticker-list" id="ticker-list">
                        	<c:forEach var="data" items="${targetPriceAlarmList}" varStatus="status">
                        		<div class="ticker-item">
	                                <span><fmt:formatNumber value="${data.target_price}" groupingUsed="true"/>원 <!-- ( -3% ) --></span>
	                                <a onclick="javascript:deleteTargetPriceAlarm('${data.target_price_alarm_id}',this);" class="delete"></a>
	                            </div>
                        	</c:forEach>
                        
                            <!-- <div class="ticker-item">
                                <span>259원 ( -3% )</span>
                                <a href="#" class="delete"></a>
                            </div>
                            <div class="ticker-item">
                                <span>259원 ( -3% )</span>
                                <a href="#" class="delete"></a>
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
