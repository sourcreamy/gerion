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

<script>
	$(document).ready(function () {
		
			 $("#newsFrame").attr('src',"${newsUri}"); 
			
			 /* $("#newsFrame").attr('src',"/main/home.do"); */

		});
</script>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <div class="content-container">
            <header class="clearfix">
                <div class="search-icon">
                    <a style="cursor:pointer;" onclick="javascript:history.go(-1);" class="goback"><img src="/img/back-icon.png" alt=""></a>  
                </div>
                <div class="page-title txt-medium">
                </div>
                <div class="menu-bar pull-right">
                    <a href="#"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="divider"></div>
            <div class="market-content" style="padding:0;">
                <!-- <iframe style="width: 100%; border: none; height:100vh;" frameBorder="0" id="newsFrame" scrolling="no" src=""></iframe> -->
                <iframe style="width: 100%; border: none; height:100vh;" frameBorder="0" id="newsFrame" scrolling="no" src=""></iframe>
            </div>
        </div>


    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="/js/main.js"></script>   
     
     
     <script type="text/javascript" src="/js/vendor/iframeResizer.js"></script>
     <script type="text/javascript">

     iFrameResize({

			log                     : true,                  // Enable console logging

			inPageLinks             : true,

			resizedCallback         : function(messageData){ // Callback fn when resize is received

				alert(messageData);

			},

			messageCallback         : function(messageData){ // Callback fn when message is received

				alert(messageData);
			},

			closedCallback         : function(id){ // Callback fn when iFrame is closed

				alert(messageData);
			}

		});

    </script>
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    </body>
</html>
