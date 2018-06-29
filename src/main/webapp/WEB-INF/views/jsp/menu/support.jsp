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
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <div class="content-container">
            <header class="clearfix">
                <div class="search-icon">
                    <a href="/main/menu.do" class="goback"><img src="/img/back-icon.png" alt=""></a> 
                </div>
                <div class="page-title txt-medium">
                    고객지원센터
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="support-option option-box clearfix">
                <a href="#" class="option active">전체</a>
                <a href="#" class="option">알림</a>
                <a href="#" class="option">관심종목</a>
                <a href="#" class="option">뉴스</a>
                <a href="#" class="option">전체</a>
                <a href="#" class="option">환경설정</a>
            </div>
            <div class="divider"></div>
            <div class="support-container">
                <ul>
                    <li><a href="#">[알림] 알림은 어떻게 설정하나요?</a></li>
                    <li><a href="#">[관심종목] 관심종목을 어떻게 설정하나요?</a></li>
                    <li><a href="#">[결제] 결제는 어디서 할 수 있나요?</a></li>
                    <li><a href="support-content.do">[뉴스] 뉴스 카테고리.는 어떻게 추가하나요?</a></li>
                    <li><a href="#">[환경설정] 환경설정에선 무엇을 할 수 있나요?</a></li>
                    <li><a href="#">[환경설정] 환경설정에선 무엇을 할 수 있나요?</a></li>
                    <li><a href="#">[환경설정] 환경설정에선 무엇을 할 수 있나요?</a></li>
                    <li><a href="#">[환경설정] 환경설정에선 무엇을 할 수 있나요?</a></li>
                </ul>
            </div>
            <div class="bg-gray hours-box">
                <div class="clearfix">
                    <a href="" class="pull-left">카카오톡 문의</a>
                    <a href="" class="pull-right">전화 문의</a>
                </div>
                <span class="note">
                    상담가능시간 평일 9:00 - 6:00 ( 주말 및 공휴일 휴무 )
                </span>
            </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="http://gfplant.com/js/jquery.viewportchecker.js"></script>    
    <script src="/js/main.js"></script>       
    </body>
</html>
