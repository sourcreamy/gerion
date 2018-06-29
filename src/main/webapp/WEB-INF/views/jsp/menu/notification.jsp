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
    
<body class="bg-gray">
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <div class="content-container">
            <header class="clearfix">
                <div class="search-icon">
                    <a href="/main/menu.do" class="goback"><img src="/img/back-icon.png" alt=""></a>  
                </div>
                <div class="page-title txt-medium">
                    알림설정
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="divider"></div>
            <div class="notification-settings content-box">
                <span class="title">전체 알림</span>
                <div class="notif-box">
                    <span class="notif">
                        이벤트/마케팅 관련 알림
                    </span>
                    <div class="track-holder">
                        <input type="checkbox" id="event" hidden>
                        <label for="event"></label>
                    </div>
                </div>
                <div class="divider-3x"></div>
                <div class="notif-box pl22">
                    <span class="notif">
                        시세 알림
                    </span>
                    <div class="track-holder">
                        <input type="checkbox" id="price/notice" hidden checked>
                        <label for="price/notice"></label>
                    </div>
                </div>
                <div class="divider-3x"></div>
                <span class="title">관심 종목 관련</span>
                <div class="notif-box pl22">
                    <span class="notif">
                        뉴스 알림
                    </span>
                    <div class="track-holder">
                        <input type="checkbox" id="newsalerts" hidden>
                        <label for="newsalerts"></label>
                    </div>
                </div>
                <div class="notif-box pl22">
                    <span class="notif">
                        프리미엄 분석 알림
                    </span>
                    <div class="track-holder">
                        <input type="checkbox" id="analytics" hidden checked>
                        <label for="analytics"></label>
                    </div>
                </div>
                <div class="notif-box pl22">
                    <span class="notif">
                        전문가 종목 추천 알림
                    </span>
                    <div class="track-holder">
                        <input type="checkbox" id="notifexperts" hidden>
                        <label for="notifexperts"></label>
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
