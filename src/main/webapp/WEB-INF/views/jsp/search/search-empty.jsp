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
            <header>
                <div class="search-icon">
                    <a href="search.do"><img src="/img/search-icon.png" alt=""></a> 
                </div>
                <div class="search-container">
                    <input type="text" name="" id="" placeholder="종목명/코드 또는 키워드 입력
                    ">
                </div>
                <div class="cancel">
                    <a href="#">취소</a>
                </div>
            </header>

            <!-- <div class="recent-searches">
                <div class="head foricon">
                    <span>종목(2)</span>
                    <a href="#" class="delete-all">전체삭제</a>
                    <a href="#" class="icon-box delete"></a>
                </div>
                <div class="searches">
                    <div class="search-box foricon">
                        <a href="#" class="search ">삼성전자</span>
                        <a href="#" class="icon-box heart"></a>
                    </div>
                    <div class="search-box foricon">
                        <a href="#" class="search">LG전자</span>
                        <a href="#" class="icon-box heart heart-full"></a>
                    </div>
                </div>
            </div> -->

            <div class="no-result content-box">
                <div class="notfound">
                    <span>최근에 검색한 내역이 없습니다</span>
                    <img src="/img/alert-icon.png" alt="">
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
