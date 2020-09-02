<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>woori</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        li {
            list-style: none;
        }

        #wrap {
            position: relative;
        }

        .page1 {
            width: 100%;
            height: 100vh;
            left: 0;
            top: 0;
            position: relative;
            background-color: rgba(0, 0, 0, 0.8);
            overflow: hidden;
        }

        .screen {
            width: 40%;
            height: 100%;
            background-color: #ffffff;
            background-color: rgba(0, 0, 0, 0.5);
            float: right;
            position: relative;
        }

        #myVideo {
            position: absolute;
            min-width: 100%;
            max-height: 120%;
            top: 0;
            left: 0;
            z-index: -100;
        }

        .page1 ul {
            position: absolute;
            padding: 0;
            margin: 0;
            transform: translate(-50%, -50%);
            display: flex;
        }

        .page1 ul li {
            margin: 0 15px;
        }

        .page1 ul li .far, .page1 ul li .fab, .page1 ul li .fas {
            font-size: 30px;
            line-height: 60px;
            transition: .6s;
            color: #000;
        }

        .page1 ul li .far:hover, .page1 ul li .fab:hover, .page1 ul li .fas:hover {
            color: #fff;
        }

        .page1 ul li a {
            position: relative;
            display: block;
            width: 60px;
            height: 60px;
            border-radius: 50%;
            background-color: #ffff;
            text-align: center;
            transition: .6s;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
        }

        .page1 ul li a:hover {
            transform: translate(0, -10px);
        }

        .page1 ul li:nth-child(1) a:hover {
            background-color: #00c300;
        }

        .page1 ul li:nth-child(2) a:hover {
            background-color: #3b5999;
        }

        .page1 ul li:nth-child(3) a:hover {
            background-color: #e4405f;
        }

        .page1 ul li:nth-child(4) a:hover {
            background-color: #09b83e;
        }

        .logo {
            width: 500px;
            height: 500px;
            border-radius: 50%;
            left: 17%;
            top: 10%;
            text-align: center;
            position: relative;
            background-image: url(woori.png);
            background-repeat: no-repeat;
            background-size: 470px;
        }

        .login {
            position: relative;
            text-align: center;
            font-size: 25px;
            transition: .6s;
            background-color: white;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            font-family: 'Cute Font', cursive;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
            width: 200px;
            height: 30px;
            left: 35%;
            top: 7%;
        }

        .join {
            position: relative;
            text-align: center;
            font-size: 25px;
            transition: .6s;
            background-color: white;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            font-family: 'Cute Font', cursive;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
            width: 200px;
            height: 30px;
            left: 35%;
            top: 10%;
        }

        .social {
            position: relative;
            display: flex;
            justify-content: center;
            flex-flow: row wrap;
            left: 22%;
            top: 17%;
        }

        .login:hover {
            background-color: #ec6169;
        }

        .join:hover {
            background-color: #fce77e;
        }

        .page2 {
            width: 100%;
            height: 100vh;
            left: 0;
            top: 0;
            position: relative;
            /*background-image: url(그라데이션.jpg);*/
            background-repeat: no-repeat;
            background-size: cover;
        }

        .screen2 {
            width: 100%;
            height: 500px;
            position: absolute;
            display: flex;
            justify-content: space-between;
            top: 20%;
        }

        .box {
            width: 100%;
            height: 500px;
            position: absolute;
        }

        .box img {
            width: 100%;
            height: 500px;
            border: 1px solid black;
        }

        button {
            width: 30px;
            height: 30px;
        }

        .moveL {
            top: 50%;
            left: 97.3%;
            opacity: .3;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            position: absolute;
            background-color: #ffffff;
        }

        .moveR {
            top: 50%;
            left: 97.3%;
            opacity: .3;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            position: absolute;
            background-color: #ffffff;
        }


        @media (max-width: 780px) {
            .screen {
                width: 100%
            }
        }
    </style>
</head>
<body>
<div id="wrap">
    <div class="page1">
        <video autoplay muted loop id="myVideo">
            <source src="Seoul.mp4" type="Video/mp4">
            이 브라우저는 html5를 지원하지 않습니다.
        </video>
        <div class="screen">
            <div class="logo"></div>
            <div class="login" onclick="loginFun()" style="cursor: pointer">Login</div>
            <div class="join" onclick="joinFun()" style="cursor: pointer">Join</div>

            <div class="social">
                <ul class="icon">
                    <li><a href="http://www.naver.com"><i class="far fa-envelope"></i></a></li>
                    <li><a href="http://www.facebook.com"><i class="fab fa-facebook-f"></i></a></li>
                    <li><a href="http://www.instagram.com"><i class="fab fa-instagram"></i></a></li>
                    <li><a href="http://www.wechat.com/ko/"><i class="fab fa-weixin"></i></a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="page2">
        <div class="screen2">
            <div class="bigBox">
                <div class="box"><img src="humanities.jpg"></div>
                <div class="box"><img src="cooking.jpg"></div>
                <div class="box"><img src="language.png"></div>
                <div class="box"><img src="pet.jpg"></div>
                <div class="box"><img src="sport.jpg"></div>
                <div class="box"><img src="travel.jpg"></div>
                <div class="box"><img src="사교.jpg"></div>
                <div class="box"><img src="클라이밍.jpg"></div>
            </div>
        </div>
        <div class="moveL"><img src="arrowleft.jpg"></div>
        <div class="moveR"><img scr="arrowright.png"></div>
    </div>
</div>
</body>
<script>
    let joinForm;

    function joinFun() {
        joinForm = window.open("/main/join", "_blank", "width=400, height=600");
    }

    function joinCloseFun() {

    }

    $(document).ready(function () {
        $(".page1").on("mousewheel DOMMouseScroll", function (e) {
            e.preventDefault();
            var e = e.originalEvent;
            var delta = 0;
            if (e.detail) {
                delta = e.detail * -40;
            } else {
                delta = e.wheelDelta;
            }

            var moveTop = 0;
            if (delta < 0) {
                moveTop = $(this).next().offset().top;
            } else {
                moveTop = $(this).prev().offset().top;
            }
            $("html, body").animate({
                scrollTop: moveTop + "px"
            }, 800)
        });

        $(".page2").on("mousewheel DOMMouseScroll", function (e) {
            e.preventDefault();
            var e = e.originalEvent;
            var delta = 0;
            if (e.detail) {
                delta = e.detail * -40;
            } else {
                delta = e.wheelDelta;
            }

            var moveTop = 0;
            if (delta < 0) {
                moveTop = $(this).next().offset().top;
            } else {
                moveTop = $(this).prev().offset().top;
            }
            $("html, body").animate({
                scrollTop: moveTop + "px"
            }, 800)
        })
    });

    $(document).ready(function () {
        $(".moveR").click(function () {
            $(".bigbox").animate({left: "-210px"}, 500, function () {
                var right = $(".box").eq(0).detach();
                $(".bigbox").css("left", "8px");
                $(".bigbox").append(right);
            });
        });

        $(".moveL").click(function () {
            var left = $(".box").eq(2).detach();
            $(".bigbox").prepend(left);
            $(".bigbox").css("left", "-210px");
            $(".bigbox").animate({
                left: "8px"
            });
        });
    });
</script>
</html>