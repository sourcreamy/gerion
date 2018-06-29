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
                    <a style="cursor:pointer;" onclick="javascript:history.go(-1);" class="goback"><img src="/img/back-icon.png" alt=""></a>  
                </div>
                <div class="page-title txt-medium">
                    추천 포트폴리오
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="divider"></div>
            <div class="swing-marketing content-box portfolio-container clearfix">
                <a href="#" class="title">스윙매매</a>
                <div class="portfolio-items clearfix">
                    <div class="portfolio-item">
                        <div id="item1" class="circle" data-color='#ff463c' data-value="83"></div>
                        <span>수익성</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="item2" class="circle" data-color='#1451f9' data-value="75"></div>
                        <span>위험성</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="item3" class="circle" data-color='#42783c' data-value="50"></div>
                        <span>모멘텀</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="item4" class="circle" data-color='#f47e1d' data-value="83"></div>
                        <span>분산투자</span>
                    </div>
                </div>
                <div class="btn-holder">
                    <a href="#">포트폴리오 구매</a>
                </div>
            </div>
            <div class="divider"></div>
            <div class="value-investment content-box portfolio-container clearfix">
                <a href="#" class="title">가치투자</a>
                <div class="portfolio-items clearfix">
                    <div class="portfolio-item">
                        <div id="item5" class="circle" data-color='#ff463c' data-value="83"></div>
                        <span>수익성</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="iten6" class="circle" data-color='#1451f9' data-value="75"></div>
                        <span>위험성</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="item7" class="circle" data-color='#42783c' data-value="50"></div>
                        <span>모멘텀</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="item8" class="circle" data-color='#f47e1d' data-value="83"></div>
                        <span>분산투자</span>
                    </div>
                </div>
                <div class="btn-holder">
                    <a href="#">포트폴리오 구매</a>
                </div>
            </div>
            <div class="divider"></div>
            <div class="value-investment content-box portfolio-container clearfix">
                <a href="#" class="title">가치투자</a>
                <div class="portfolio-items clearfix">
                    <div class="portfolio-item">
                        <div id="item9" class="circle" data-color='#ff463c' data-value="83"></div>
                        <span>수익성</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="item10" class="circle" data-color='#1451f9' data-value="75"></div>
                        <span>위험성</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="item11" class="circle" data-color='#42783c' data-value="50"></div>
                        <span>모멘텀</span>
                    </div>
                    <div class="portfolio-item">
                        <div id="item12" class="circle" data-color='#f47e1d' data-value="83"></div>
                        <span>분산투자</span>
                    </div>
                </div>
                <div class="btn-holder">
                    <a href="#">포트폴리오 구매</a>
                </div>
            </div>
        </div>


    <!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->  
    <script src="/js/progressbar.js"></script>       
    <script src="/js/main.js"></script>       
    </body>
</html>
