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
  
function logout(){

	if(confirm("로그아웃 하시겠습니까?")){
		document.location.href = "/kakao/logout.do";	
	}
	
}
    
</script>









        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <div class="content-container">
            <header class="bg-pink clearfix">
                <div class="search-icon">
                    <a style="cursor:pointer;" href="/main/home.do"><img src="/img/close-white-icon.png" alt=""></a> 
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-icon.png" alt=""></a>
                </div>
            </header>
            <div class="menu-container bg-pink">
                <span class="img-holder">
                    <img src="${thumbnail}" alt="">
                </span>
                <div class="qoute-emotion-holder">
                    <span class="qoute txt-bold">
                        성공투자하세요
                    </span>
                    <span class="emotion txt-bold">
                         ${usernick}
                    </span>
                </div>

                <div class="clearfix">
                    <span class="label-text">보유포인트</span>
                    <a href="purchase-history.do">
                        <span class="points roboto">
                            14,500
                            <img src="/img/arrow-white-right-icon.png" alt="">
                        </span>
                    </a>
                    <a onclick="javascript:logout();" class="log-out">로그아웃</a>
                </div>
            </div>
            
            <div class="divider"></div>
            <div class="main-menu-container">
                <a href="notification-list.do" class="menu-link">
                    <img src="/img/bar-white-icon.png" alt="">
                    <span class="text">알림목록</span>
                </a>
                <a href="notification.do" class="menu-link">
                    <img src="/img/bell-icon.png" alt="">
                    <span class="text">알림설정</span>
                </a>
                <a href="#" class="menu-link">
                    <img src="/img/folder-icon.png" alt="">
                    <span class="text">나의 포트폴리오</span>
                </a>
                <a href="primary.do" class="menu-link">
                    <img src="/img/coin-icon.png" alt="">
                    <span class="text">유료결제</span>
                </a>
                <a href="event.do" class="menu-link">
                    <img src="/img/star-icon.png" alt="">
                    <span class="text">이벤트</span>
                </a>
                <a href="support.do" class="menu-link">
                    <img src="/img/support-icon.png" alt="">
                    <span class="text">고객지원센터</span>
                </a>
            </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="http://gfplant.com/js/jquery.viewportchecker.js"></script>    
    <script src="/js/main.js"></script> 
</html>
