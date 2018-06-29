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
    
<body class="">
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <div class="content-container">
            <header class="clearfix">
                <div class="search-icon">
                    <a href="/main/menu.do" class="goback"><img src="/img/back-icon.png" alt=""></a>  
                </div>
                <div class="page-title txt-medium">
                    알림 목록
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="divider"></div>
            <div class="content-box">
                <span class="title">새로운 알림</span>
            </div>
            <div class="notification-list">
                <div class="notification">
                    <div class="img-box-holder">
                        <span class="img-holder">
                            <img src="" alt="">
                        </span>
                    </div>
                    <div class="notification-info">
                        <p class="name">알렉스 강 전문가가 <span class="red txt-bold">추천 종목을 등록했습니다</span> 
                        </p>
                        <span class="notify">1분 전</span>
                    </div>
                </div>
                <div class="notification">
                    <div class="img-box-holder">
                        <span class="img-holder">
                            <img src="" alt="">
                        </span>
                    </div>
                    <div class="notification-info">
                        <p class="name">알렉스 강 전문가가 추천한 종목이 급등하 고있습니다 지금바로 
                            <span class="red txt-bold">추천 종목을 확인해보세요</span> 
                        </p>
                        <span class="notify">5분 전</span>
                    </div>
                </div>
                <div class="notification">
                    <div class="img-box-holder">
                        <span class="img-holder">
                            <img src="" alt="">
                        </span>
                    </div>
                    <div class="notification-info">
                            
                        <p class="name">알렉스 강 전문가가  
                            <span class="gray txt-bold">추천 종목을 등록했습니다</span> 
                        </p>
                        <span class="notify">5분 전</span>
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
