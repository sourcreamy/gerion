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
            <a href="index.do" class="addnew">
                <img src="/img/plus-white-icon.png" alt="">
            </a>
            <div class="view-option">
                <ul>
                    <li class="option interest">
                        <a href="interest.do">관심종목</a>  
                    </li>
                    <li class="option advisor txt-bold">
                        <a href="index.do">어드바이저</a> 
                    </li>
                    <li class="option  research ">
                        <a href="research.do">리서치</a> 
                    </li>
                </ul>
            </div>

            <div class="list-option">
                <ul>
                    <li><a href="home.do">홈</a></li>
                    <li  class="active"><a href="profile.do">리처드 개리</a></li>
                    <li><a href="#">알렉스 강</a></li>
                    <li><a href="#">피터 린치</a></li>
                    <li><a href="#">피터 린치</a></li>
                </ul>
            </div>
            <div class="divider"></div>
            <div class="profile-contents">
                <div class="profile-info">
                    <div class="img-holder">
                        <span>
                            <img src="/img/profile-pic.png" alt="">
                        </span>
                    </div>
                    <div class="profile-details">
                        <a href="#" class="btn-request">
                            <img src="/img/add-icon.png" alt="">
                        </a>
                        <span class="name txt-bold">리처드 개리</span>
                        <span class="subname">재무제표 분석의 귀재</span>
                        <p>
                            정통 재무제표 분석 위에 리처드 개리엇만의
                            회계적 분석에 기인한 기업자금 흐름의 분석
                            으로 실제 주가에 영향을 미치는 기업의
                            가치를 측정합니다.
                        </p>
                        <ul class="tags-list">
                            <li class="tags"><a href="#">#재무재표</a></li>
                            <li class="tags"><a href="#">#중소형주</a></li> 
                            <li class="tags"><a href="#">#변동성</a></li> 
                        </ul>
                    </div>
                </div>
                <div class="divider"></div>
                <div class="algorithm-container content-box">
                    <span class="title">
                        종목 발굴 알고리즘 성향
                        <span class="sub-info">
                            발굴 알고리즘으로 상승 예상 <br>
                            종목을 확인하세요.
                        </span>
                    </span>
                    <div class="algorithm-content">
                        <div class="algorithm">
                            <div class="bar-holder" data-width="180">
                                <span></span>
                            </div>
                            <div class="clearfix">
                                <span class="pull-left">장기</span>
                                <span class="pull-right">단기</span>
                            </div>
                        </div>
                        <div class="algorithm">
                            <div class="bar-holder" data-width="88">
                                <span></span>
                            </div>
                            <div class="clearfix">
                                <span class="pull-left">우량주</span>
                                <span class="pull-right">소형주</span>
                            </div>
                        </div>
                        <div class="algorithm">
                            <div class="bar-holder" data-width="545">
                                <span></span>
                            </div>
                            <div class="clearfix">
                                <span class="pull-left">안정성</span>
                                <span class="pull-right">수익성</span>
                            </div>
                        </div>
                        <a href="#" class="search-algorithm">알고리즘 종목 검색</a>
                    </div>
                </div>
                <div class="divider"></div>
                <div class="recommended-items content-box">
                    <!-- <span class="title">추천종목</span> -->
                    <span class="title">알고리즘 무료 검색 종목</span>
                    <div class="recommended-item">
                        <div class="name-sub-box">
                            <p class="name">
                                <span>신라젠</span> 008800
                            </p>
                            <span class="subinfo">
                                2018/04/18 09:38 추천
                            </span>
                        </div>
                        <a href="#" class="heart"></a>
                        <p class="desc">
                            면역항암 병용치료제 개발로 600억원 투자 유치 소식
                        </p>
                        <div class="buying-offense-box">
                            <div class="buying-box clearfix">
                                <span class="label-text red">매수가</span>
                                <span class="value">100,000원 이하</span>
                            </div>
                            <div class="offense-box clearfix">
                                <span class="label-text blue">손절가</span>
                                <span class="value">98,700원</span>
                            </div>
                        </div>
                        <div class="other-details clearfix">
                            <ul class="clearfix">
                                <li>
                                    <span class="heading">상장구분</span>
                                    <span class="value">코스닥</span>
                                </li>
                                <li>
                                    <span class="heading">테마/업종</span>
                                    <span class="value">4차산업</span>
                                </li>
                                <li>
                                    <span class="heading">리스크/수익률</span>
                                    <span class="value">고위험/고수익</span>
                                </li>
                                <li>
                                    <span class="heading">투자분류</span>
                                    <span class="value">단타</span>
                                </li>
                            </ul>
                        </div>
                        <div class="buy-portfolio">
                            <a href="#" class="btn-buy">포트폴리오 구매</a>
                        </div>
                    </div>
                    <div class="recommended-item">
                        <div class="name-sub-box">
                            <p class="name">
                                <span>ARIRANG S&P 글...</span> 008800
                            </p>
                            <span class="subinfo">
                                2018/04/18 09:38 추천
                            </span>
                        </div>
                        <a href="#" class="heart"></a>
                        <p class="desc">
                            면역항암 병용치료제 개발로 600억원 투자 유치 소식
                        </p>
                        <div class="buying-offense-box">
                            <div class="buying-box clearfix">
                                <span class="label-text red">매수가</span>
                                <span class="value">100,000원 이하</span>
                            </div>
                            <div class="offense-box clearfix">
                                <span class="label-text blue">손절가</span>
                                <span class="value">98,700원</span>
                            </div>
                        </div>
                        <div class="other-details clearfix">
                            <ul class="clearfix">
                                <li>
                                    <span class="heading">상장구분</span>
                                    <span class="value">코스닥</span>
                                </li>
                                <li>
                                    <span class="heading">테마/업종</span>
                                    <span class="value">4차산업</span>
                                </li>
                                <li>
                                    <span class="heading">리스크/수익률</span>
                                    <span class="value">고위험/고수익</span>
                                </li>
                                <li>
                                    <span class="heading">투자분류</span>
                                    <span class="value">단타</span>
                                </li>
                            </ul>
                        </div>
                        <div class="order-box">
                            <div class="item-order clearfix ribbon">
                                <div class="item-left">
                                    <span class="img-holder"><img src="/img/order-box-img.png" alt=""></span>
                                    <span class="date">2018/04/18 09:38 달성</span>
                                </div>
                                <div class="item-right text-right">
                                    <a href="#" class="btn-order">1차 103,900 원</a>
                                    <span class="achieved">2018/04/18 09:38 달성</span>
                                </div>
                            </div>
                            <div class="item-order clearfix ribbon">
                                <div class="item-left">
                                    <span class="img-holder"><img src="/img/order-box-img.png" alt=""></span>
                                    <span class="date">2018/04/18 09:38 달성</span>
                                </div>
                                <div class="item-right text-right">
                                    <a href="#" class="btn-order">2차 118,200 원</a>
                                    <span class="achieved">2018/04/18 09:38 달성</span>
                                </div>
                            </div>
                        </div>
                        <div class="buy-portfolio">
                            <a href="#" class="btn-buy">3차 목표가 확인</a>
                        </div>
                    </div>
                    <div class="recommended-item">
                        <div class="name-sub-box">
                            <p class="name">
                                <span>ARIRANG S&P 글...</span> 008800
                            </p>
                            <span class="subinfo">
                                2018/04/18 09:38 추천
                            </span>
                        </div>
                        <a href="#" class="heart"></a>
                        <p class="desc">
                            면역항암 병용치료제 개발로 600억원 투자 유치 소식
                        </p>
                        <div class="buying-offense-box">
                            <div class="buying-box clearfix">
                                <span class="label-text red">매수가</span>
                                <span class="value">100,000원 이하</span>
                            </div>
                            <div class="offense-box clearfix">
                                <span class="label-text blue">손절가</span>
                                <span class="value">98,700원</span>
                            </div>
                        </div>
                        <div class="other-details clearfix">
                            <ul class="clearfix">
                                <li>
                                    <span class="heading">상장구분</span>
                                    <span class="value">코스닥</span>
                                </li>
                                <li>
                                    <span class="heading">테마/업종</span>
                                    <span class="value">4차산업</span>
                                </li>
                                <li>
                                    <span class="heading">리스크/수익률</span>
                                    <span class="value">고위험/고수익</span>
                                </li>
                                <li>
                                    <span class="heading">투자분류</span>
                                    <span class="value">단타</span>
                                </li>
                            </ul>
                        </div>
                        <div class="order-box">
                            <div class="item-order clearfix ribbon">
                                <div class="item-left">
                                    <span class="img-holder"><img src="/img/order-box-img.png" alt=""></span>
                                    <span class="date">2018/04/18 09:38 달성</span>
                                </div>
                                <div class="item-right text-right">
                                    <a href="#" class="btn-order">1차 103,900 원</a>
                                    <span class="achieved">2018/04/18 09:38 달성</span>
                                </div>
                            </div>
                            <div class="item-order clearfix ribbon">
                                <div class="item-left">
                                    <span class="img-holder"><img src="/img/order-box-img.png" alt=""></span>
                                    <span class="date">2018/04/18 09:38 달성</span>
                                </div>
                                <div class="item-right text-right">
                                    <a href="#" class="btn-order">2차 118,200 원</a>
                                    <span class="achieved">2018/04/18 09:38 달성</span>
                                </div>
                            </div>
                        </div>
                        <div class="buy-portfolio">
                            <a href="#" class="btn-buy">3차 목표가 확인</a>
                        </div>
                    </div>
                </div>
            </div>
            <footer>
                <div class="footer-logo-holder text-center">
                    <img src="/img/footer-logo.png" alt="">
                </div>
            </footer>
        </div>
    <script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>      <script src="/js/vendor/bootstrap.min.js"></script>       
    <!-- veiwport for countnumber -->
    <script src="http://gfplant.com/js/jquery.viewportchecker.js"></script>    
    <script src="/js/main.js"></script>       
    </body>
</html>
