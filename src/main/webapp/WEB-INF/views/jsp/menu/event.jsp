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
                    이벤트
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <a href="index.do" class="addnew">
                <img src="/img/plus-white-icon.png" alt="">
            </a>
            <div class="event-list">
                <a href="event-content.do" class="event-item">
                    <div class="event-img"><img src="/img/event-img-1.png" alt=""></div>
                    <div class="event-info">
                        <span class="event-name">
                            주락펴락 오픈 이벤트!
                        </span>
                        <span class="event-date">
                            2018/04/26	 ~ 2018/04/26 
                        </span>
                        <span class="proceeding">진행중</span>
                    </div>
                </a>  
                <a href="event-content.do" class="event-item">
                    <div class="event-img"><img src="/img/event-img-2.png" alt=""></div>
                    <div class="event-info">
                        <span class="event-name">
                            주락펴락 가입 인증하면 혜택이!
                        </span>
                        <span class="event-date">
                            2018/04/26	 ~ 2018/04/26 
                        </span>
                        <span class="proceeding">진행중</span>
                    </div>
                </a>  
                <a href="event-content.do" class="event-item">
                    <div class="event-img"><img src="/img/event-img-3.png" alt=""></div>
                    <div class="event-info">
                        <span class="event-name">
                            주락펴락 가입 인증하면 혜택이!
                        </span>
                        <span class="event-date">
                            2018/04/26	 ~ 2018/04/26 
                        </span>
                        <span class="proceeding">진행중</span>
                    </div>
                </a>  
            </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="http://gfplant.com/js/jquery.viewportchecker.js"></script>    
    <script src="/js/main.js"></script>       
    </body>
</html>
