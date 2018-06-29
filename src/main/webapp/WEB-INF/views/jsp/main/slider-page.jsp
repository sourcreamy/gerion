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
            <div class="slider-page"> 
                <div id="slider" class="owl-carousel owl-theme">
                    <div class="item">
                        <img src="/img/slider-img-1.png" alt="" class="img-responsive">
                    </div>
                    <div class="item">
                        <img src="/img/slider-img-2.png" alt="" class="img-responsive">
                    </div>
                    <div class="item">
                        <img src="/img/slider-img-3.png" alt="" class="img-responsive">
                    </div>
                    <div class="item">
                        <img src="/img/slider-img-4.png" alt="" class="img-responsive">
                    </div>
                    <div class="item">
                        <img src="/img/slider-img-5.png" alt="" class="img-responsive">
                    </div>
                </div>
                <a href="home.do" class="get-started">
                    시작하기
                </a>
            </div>
        </div>

    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="/js/owl.carousel.min.js"></script>       
    <script src="/js/main.js"></script>       
    <script>
        var owl =$('#slider');
        owl.owlCarousel({
            items:1,
            loop:false,
            margin:0,
            dots:true,
            nav:false,
        })
    </script>
    </body>
</html>
