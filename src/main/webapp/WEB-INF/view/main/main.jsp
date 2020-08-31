<%--
  Created by IntelliJ IDEA.
  User: Jaeyeop
  Date: 8/29/2020
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
            /* 위치잡아주기 */
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
            left: 10%;
            top: 0%;
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
            top: -5%;
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
            top: -3%;
        }

        .social {
            position: relative;
            display: flex;
            justify-content: center;
            flex-flow: row wrap;
            left: 31%;
            top: 6%;
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
            width: 1520px;
            height: 500px;
            position: absolute;
            display: flex;
            justify-content: space-between;
            top: 20%;
        }

        .box {
            width: 1520px;
            height: 500px;
            position: absolute;
        }

        .box img {
            width: 1520px;
            height: 500px;
            border: 1px solid black;
        }

        button {
            width: 30px;
            height: 30px;
        }

        .moveL {
            left: 0%;
            top: 50%;
            position: absolute;
        }

        .moveR {
            left: 98%;
            top: 50%;
            position: absolute;
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
            <div class="login">Login</div>
            <div class="join">Join</div>

            <div class="social">
                <ul class="icon">
                    <li><a href="#"><i class="far fa-envelope"></i></a></li>
                    <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                    <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                    <li><a href="#"><i class="fab fa-weixin"></i></a></li>
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
        <button class="moveL">◀</button>
        <button class="moveR">▶</button>
    </div>
</div>
</body>
<script>
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
        });

        $(document).ready(function () {
            $(".moveR").click(function () {
                $(".bigBox").animate({left: "-210px"}, 500, function () {
                    var right = $(".box").eq(0).detach();
                    $(".bigBox").css("left", "8px");
                    $(".bigBox").append(right);
                });
            });
            $(".moveL").click(function () {
                var left = $(".box").eq(2).detach();
                $(".bigBox").prepend(left);
                $(".bigBox").css("left", "-210px");
                $(".bigBox").animate({
                    left: "8px"
                });
            });
        });
    })
</script>
</body>
</html>
