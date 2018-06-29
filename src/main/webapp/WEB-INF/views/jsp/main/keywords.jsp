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
                    키워드 편집
                </div>
                <div class="save pull-right">
                    <a href="#">저장</a> 
                </div>
            </header>
            <div class="divider"></div>
            <div class="keywords-box">
                <ul>
                    <li><a href="#">정치</a></li>
                    <li><a href="#">IT</a> </li>
                    <li><a href="#">북한</a> </li>
                    <li><a href="#">건축</a> </li>
                    <li><a href="#">전기자동차</a> </li>
                    <li><a href="#">반도체</a> </li>
                </ul>
                <div class="text-center arrow-up">
                        <a href="#"><img src="/img/arrow-up-icon.png" alt=""></a>
                </div>
                <div class="keyword-enter input-box">
                    <input type="text" placeholder="예) 삼성전자, 신라젠, 셀트리온 등">
                    <span class="note">키워드를 설정하면 해당하는 기사를 불러옵니다</span>
                </div>
            </div>
            <div class="divider"></div>
            <div class="btn-holder">
                <a href="#" class="keyword-add">추가</a>
            </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="http://gfplant.com/js/jquery.viewportchecker.js"></script>    
    <script src="/js/main.js"></script>       
    </body>
</html>
