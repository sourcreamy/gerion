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
            <jsp:include page="/WEB-INF/views/jsp/common-top.jsp"></jsp:include>

            <div class="view-option">
                <ul>
                    <li class="option interest">
                        <a href="/interest/interest.do">관심종목</a>  
                    </li>
                    <li class="option advisor">
                        <a href="/main/index.do">어드바이저</a> 
                    </li>
                    <li class="option  research txt-bold">
                        <a href="/research/news.do">리서치</a> 
                    </li>
                </ul>
            </div>
            <div class="news-market-analysis clearfix">
                <ul>
                    <li><a href="/research/news.do">뉴스</a></li>
                    <li  class="active"><a href="/research/market.do">시황</a></li>
                    <li><a href="/research/premiumanalysis.do">프리미엄분석</a></li>
                </ul>
            </div>
            <div class="divider"></div>
            <div class="market-list">
                <a href="market-content.do" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
                <a href="#" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
                <a href="#" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
                <a href="#" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
                <a href="#" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
                <a href="#" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
                <a href="#" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
                <a href="#" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
                <a href="#" class="market-item">
                    <span class="condition">2018년 3월 27일 장전 시황</span>
                    <span class="date">2018/03/26</span>
                </a>
            </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="/js/main.js"></script>       
    </body>
</html>
