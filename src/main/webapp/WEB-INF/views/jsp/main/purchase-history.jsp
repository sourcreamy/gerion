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
                    고객지원센터
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="divider"></div>
            <div class="products-use items-box">
                <span class="title">사용 중인 상품</span>
                <div class="products">
                    <a class="product-box">
                        <div class="img-holder">
                            <img src="/img/product-1-icon.png" alt="">
                        </div>
                        <div class="product-info">
                            <span class="name">프리미엄 종목분석 <span class="red txt-bold">1개월 이용권</span></span>
                            <span class="availability">2018/04/26	 까지 이용 가능</span>
                        </div>
                    </a>
                    <a class="product-box">
                        <div class="img-holder">
                            <img src="/img/product-2-icon.png" alt="">
                        </div>
                        <div class="product-info">
                            <span class="name">목표가 확인  <span class="red txt-bold">3회권 (2회 남음)</span></span>
                            <span class="availability">2018/04/26 까지 이용 가능</span>
                        </div>
                    </a>
                    <a class="product-box">
                        <div class="img-holder">
                            <img src="/img/product-2-icon.png" alt="">
                        </div>
                        <div class="product-info">
                            <span class="name">목표가 확인  <span class="red txt-bold">3회권 (2회 남음)</span></span>
                            <span class="availability">2018/04/26 까지 이용 가능</span>
                        </div>
                    </a>
                </div>
            </div>
            <div class="divider"></div>
            <div class="expired-items items-box">
                <span class="title">사용이 만료된 상품</span>
                <div class="expired-item-list">
                    <div class="item">
                        <div class="item-info">
                            <span class="name">목표가 확인 <span class="red txt-bold">3회권</span> </span>
                            <span class="expiration">2018/04/26	 사용</span>
                        </div>
                        <a href="#" class="btn-repurchase">
                            재구매 하기
                        </a>
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
