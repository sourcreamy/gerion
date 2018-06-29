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
                    <a style="cursor:pointer;" onclick="javascript:history.go(-1);" class="goback"><img src="/img/back-icon.png" alt=""></a>  
                </div>
                <div class="page-title txt-medium">
                    유료 결제
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="support-option payment-option option-box clearfix">
                    <a href="primary.do" class="option ">1차 목표가</a>
                    <a href="excavation.do" class="option"> 발굴 알고리즘</a>
                    <a href="analysis.do" class="option">프리미엄분석</a>
                    <a href="portfolio.do" class="option">포트폴리오</a>
                    <a href="vip.do" class="option ">VIP</a>
                    <a href="vvip.do" class="option active">VVIP</a>
            </div>
            <div class="divider"></div>
            <div class="content-box">
                <span class="title">올프리패스 상품 기간제</span>
                <div class="primary-goal-items">
                    <div class="item">
                        <div class="img-holder-box">
                            <span class="img-holder"><img src="/img/ticket-vvip-1.png" alt=""></span>
                        </div>
                        <div class="ticket txt-bold">
                            <span>1개월 이용권</span> 
                        </div>
                        <a href="#" class="btn-price">390,000 원</a>
                    </div>
                    <div class="item">
                        <div class="img-holder-box">
                            <span class="img-holder"><img src="/img/ticket-vvip-3.png" alt=""></span>
                        </div>
                        <div class="ticket txt-bold">
                            <span>3개월 이용권</span> 
                        </div>
                        <a href="#" class="btn-price">790,000 원</a>
                    </div>
                    <div class="item">
                        <div class="img-holder-box">
                            <span class="img-holder"><img src="/img/ticket-vvip-5.png" alt=""></span>
                        </div>
                        <div class="ticket txt-bold">
                            <span>6개월 이용권</span> 
                        </div>
                        <a href="#" class="btn-price">1,190,000 원</a>
                    </div>
                    <div class="item">
                        <div class="img-holder-box">
                            <span class="img-holder"><img src="/img/ticket-vvip-12.png" alt=""></span>
                        </div>
                        <div class="ticket txt-bold">
                            <span>12개월 이용권</span> 
                        </div>
                        <a href="#" class="btn-price">1,990,000 원</a>
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
