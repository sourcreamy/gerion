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

<script type="text/javascript">  
  
function kakaoLogin(){

	/* document.location.href = "https://kauth.kakao.com/oauth/authorize?client_id=e3a057034847accf088ffd0b3ad83801&redirect_uri=http://localhost:8080/kakao/kakaoLogin.do&response_type=code"; */

	//아래는 테스트 키 이므로 변경 해야함... 컨트롤러도 변경 해야 함....
	document.location.href = "https://kauth.kakao.com/oauth/authorize?client_id=277a32547c7c92f4f1592a6691307b80&redirect_uri=http://localhost:8080/kakao/kakaoLogin.do&response_type=code";
	
	
	
}
    
</script>


        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <div class="content-container">
            <header class="bg-pink clearfix">
                <div class="search-icon">
                    <a style="cursor:pointer;" onclick="javascript:history.go(-1);" class="goback"><img src="/img/back-icon.png" alt=""></a>  
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-icon.png" alt=""></a>
                </div>
            </header>
            <div class="menu-container bg-pink">
                <span class="img-holder">
                    <img src="/img/user-img.png" alt="">
                </span>
                <a class="kakao" style="cursor:pointer;" onclick="javascript:kakaoLogin();">
                    카카오계정으로 로그인
                </a>
            </div>
            <div class="divider"></div>
            <div class="main-menu-container">
                <a href="#" class="menu-link">
                    <img src="/img/bar-white-icon.png" alt="">
                    <span class="text">알림목록</span>
                </a>
                <a href="#" class="menu-link">
                    <img src="/img/audio-icon.png" alt="">
                    <span class="text">알림설정</span>
                </a>
                <a href="#" class="menu-link">
                    <img src="/img/folder-icon.png" alt="">
                    <span class="text">나의 포트폴리오</span>
                </a>
                <a href="#" class="menu-link">
                    <img src="/img/coin-icon.png" alt="">
                    <span class="text">유료결제</span>
                </a>
                <a href="#" class="menu-link">
                    <img src="/img/star-icon.png" alt="">
                    <span class="text">이벤트</span>
                </a>
                <a href="#" class="menu-link">
                    <img src="/img/support-icon.png" alt="">
                    <span class="text">고객지원센터</span>
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
