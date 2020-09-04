<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-09-04
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Woori</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        li {
            list-style: none;
        }

        .wrap {
            position: relative;
        }

        .back {
            position: absolute;
            width: 100%;
            height: 100vh;
            background-color: aliceblue;
            opacity: 50%;
            z-index: 1;
            /*display: none;*/
        }

        #page1 {
            width: 100%;
            height: 100vh;
            left: 0;
            top: 0;
            position: relative;
            background-image: url(/image/illu.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            overflow: hidden;
        }

        #page2 {
            width: 100%;
            height: 100vh;
            left: 0;
            top: 0;
            position: relative;
            background-color: #fce77e;
            overflow: hidden;
        }

        .screen {
            width: 500px;
            height: 590px;
            position: relative;
            left: 36%;
        }

        .logo {
            left: 30%;
            top: 5%;
            width: 200px;
            height: 200px;
            background-image: url(/image/logo.png);
            background-repeat: no-repeat;
            background-size: cover;
            position: absolute;
            animation: dungdung 1s infinite alternate;
        }

        @keyframes dungdung {
            0% {
                transform: translate(0, 0);
            }
            100% {
                transform: translate(0, 30px);
            }
        }

        .id {
            position: absolute;
            border-radius: 5px;
            width: 200px;
            height: 30px;
            top: 45%;
            left: 30%;
        }

        .pw {
            position: absolute;
            border-radius: 5px;
            width: 200px;
            height: 30px;
            top: 53%;
            left: 30%;
        }

        .login {
            position: absolute;
            border-radius: 5px;
            width: 200px;
            height: 30px;
            top: 63%;
            left: 30%;
            background-color: #ec6169;
            text-align: center;
            color: white;
            padding: 5px;
        }

        .login:hover {
            transition: all .5s;
            transform: scale(1.1);
        }

        .social {
            position: absolute;
            width: 100%;
            height: 60px;
            top: 71%;
            text-align: center;
            display: flex;
            justify-content: center;
        }

        .box1, .box2, .box3, .box4, .box5 {
            width: 10%;
            margin: 0 5px;
        }

        .box1 img, .box2 img, .box3 img, .box4 img, .box5 img {
            width: 100%;
        }

        .box1:hover, .box2:hover, .box3:hover, .box4:hover, .box5:hover {
            transition: all .5s;
            transform: scale(1.1);
        }

        .letter {
            position: absolute;
            width: 100%;
            height: 30px;
            top: 85%;
            text-align: center;
            color: gray;
            font-weight: 900;
        }

        .join {
            position: absolute;
            border-radius: 5px 5px 5px 5px;
            width: 200px;
            height: 30px;
            top: 90%;
            left: 30%;
            background-color: #fce77e;
            text-align: center;
            color: black;
            padding: 5px;
        }

        .join:hover {
            transition: all .5s;
            transform: scale(1.1);
        }
    </style>
    <script src="https://kit.fontawesome.com/4be9a87855.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="wrap">
    <div class="back"></div>
    <div id="joinPage">

    </div>
    <div id="page1" class="page">
        <div class="screen">
            <div class="logo"></div>
            <form action="">
                <input type="text" class="id" name="account" placeholder="User ID">
                <input type="text" class="pw" name="password" placeholder="User PW">
                <div class="login" style="cursor: pointer">LOGIN</div>
            </form>
            <div class="social">
                <div class="box1"><a href="http://www.facebook.com"><img src="/image/facebook.png"></a></div>
                <div class="box2"><a href="http://www.instagram.com"><img src="/image/insta.png"></a></div>
                <div class="box3"><a href="http://www.twitter.com"><img src="/image/twitter.png"></a></div>
                <div class="box4"><a href="http://www.kakaocorp.com"><img src="/image/kakao.png"></a></div>
                <div class="box5"><a href="http://www.wechat.com"><img src="/image/wechat.png"></a></div>
            </div>
            <div class="letter">지금 회원가입 하세요</div>
            <div class="join" style="cursor: pointer" onclick="joinForm()">JOIN</div>
        </div>
    </div>
    <div id="page2" class="page">
    </div>
</div>
</body>
<script>
    function joinForm() {
        window.open("/main/join", "_blank", "width=500, height=600");
    }

    $(document).ready(function () {
        $(".page").on("mousewheel DOMMouseScroll", function (e) {
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
            $("html, body").stop().animate({
                scrollTop: moveTop + "px"
            }, 800)
        });
    });
    //            $(".page2").on("mousewheel DOMMouseScroll",function(e){
    //                e.preventDefault();
    //                var e = e.originalEvent;
    //                var delta=0;
    //                if(e.detail){
    //                    delta = e.detail * -40;
    //                }else{
    //                    delta = e.wheelDelta;
    //                }
    //
    //                var moveTop = 0;
    //                if(delta<0){
    //                    moveTop = $(this).next().offset().top;
    //                }else{
    //                    moveTop = $(this).prev().offset().top;
    //                }
    //                $("html, body").animate({
    //                    scrollTop : moveTop+"px"
    //                },800)
    //            });
</script>
</html>