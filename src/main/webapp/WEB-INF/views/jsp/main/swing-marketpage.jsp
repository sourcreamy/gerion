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
                    스윙매매
                </div>
                <div class="menu-bar pull-right">
                    <a href="/main/home.do"><img src="/img/home-pink-icon.png" alt=""></a>
                </div>
            </header>
            <div class="divider"></div>
            <div class="swing-marketing portfolio-container clearfix">
                <div class="content-box">
                    <a href="#" class="title">스윙매매 추천 포트폴리오</a>
                    <a href="#" class="heart"></a>
                </div>
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
            </div>
            <div class="divider"></div>
            <div class="items-weight">
                <div class="content-box">
                    <span class="title">종목 비중</span>
                </div>
                <div class="items-weight-content">
                    <div class="items-overlay">
                        <span>구매 후 보실 수 있는 영역입니다 </span>
                        <a href="#">포트폴리오 구매</a>
                    </div>
                    <div class="clearfix halfchart active">
                        <div class="chart-container">
                            <div id="canvas-holder" style="width:90%; margin:0 auto;">
                                <canvas id="chart-area" width="220" height="220" 
                                class="chartjs-render-monitor"
                                data-red="35"
                                data-green="25"
                                data-orange="20"
                                data-yellow="10"
                                data-blue ="10"
                                ></canvas>
                            </div>
                        </div>
                        <div class="chart-legend">
                            <ul>
                                <li class="red">
                                    35%
                                    <span>삼성전자</span>
                                </li>
                                <li class="green">
                                    25%
                                    <span>신라젠</span>
                                </li>
                                <li class="orange">
                                    20%
                                    <span>코오롱머티리얼</span>
                                </li>
                                <li class="yellow">
                                    10%
                                    <span>행남자기</span>
                                </li>
                                <li class="blue">
                                    10%
                                    <span>티플랙스</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="view-events">
                        <a href="#">
                            <span class="sign plus active">종목 전체 보기</span>
                            <span class="sign minus">종목 닫기</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>


    <!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->  
    <script src="/js/progressbar.js"></script>       
    <script src="/js/Chart.bundle.js"></script>       
    <script src="/js/utils.js"></script>       
    <script src="/js/main.js"></script>       
    <script>
        window.onload = function() {
			var ctx = document.getElementById('chart-area').getContext('2d');
            window.myDoughnut = new Chart(ctx, config);
			var ctx2 = document.getElementById('chart-area2').getContext('2d');
            window.myDoughnut = new Chart(ctx2, config);
		};
        var value=$('#chart-area');
        var red = value.data('red')
        var green = value.data('green')
        var orange = value.data('orange')
        var yellow = value.data('yellow')
        var blue = value.data('blue')
        var config = {
            type: 'doughnut',
            labels: [
                    'Red',
                    'Green',
                    'Orange',
                    'Yellow',
                    'BLue'
                ],
			data: {
				datasets: [{
					data: [red, green, orange, yellow,blue],
					backgroundColor: [
						window.chartColors.red,
						window.chartColors.green,
						window.chartColors.orange,
						window.chartColors.yellow,
						window.chartColors.blue,
					],
                }],
			},
			options: {
                cutoutPercentage: 30,
				animation: {
					animateScale: true,
					animateRotate: true
                },
                            
			}
		};
    </script>
    </body>
</html>
