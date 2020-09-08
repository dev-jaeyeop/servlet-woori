<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-09-07
  Time: 오후 5:12
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

        .account {
            position: absolute;
            border-radius: 5px 5px 5px 5px;
            width: 200px;
            height: 30px;
            top: 45%;
            left: 30%;
        }

        .password {
            position: absolute;
            border-radius: 5px 5px 5px 5px;
            width: 200px;
            height: 30px;
            top: 53%;
            left: 30%;
        }

        .login {
            position: absolute;
            border-radius: 5px 5px 5px 5px;
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
            transition: all .3s;
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

        .socialIcon {
            width: 10%;
            margin: 0 5px;
        }

        .socialIcon img {
            width: 100%;
        }

        .socialIcon:hover {
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

        .popJoin:hover {
            transition: all .3s;
            transform: scale(1.1);
        }

        .layerpop {
            position: fixed;
            width: 100%;
            height: 100vh;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 5;
            display: none;
        }

        .popwrap {
            width: 500px;
            height: 600px;
            position: absolute;
            margin: 0 auto;
            left: 0;
            right: 0;
            background-color: white;
            border: 1px solid black;
            display: none;
            z-index: 6000;
            top: 90px;
        }

        .poptop {
            width: 100%;
            height: 50px;
            text-align: center;
            font-weight: 900;
            font-size: 35px;
            color: white;
            background-color: #ec6169;
        }

        .poplogo {
            width: 200px;
            height: 200px;
            left: 30%;
            position: relative;
            background-image: url(/image/logo.png);
            background-repeat: no-repeat;
            background-size: cover;
        }

        .poptable {
            width: 100%;
            height: 280px;
        }

        .poptb {
            left: 20%;
            position: absolute;
            margin: 10px;
            padding: 10px;
            border-spacing: 15px;
            font-weight: 900;
            color: #fce77e;
            text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
        }

        .popButton {
            width: 100%;
            height: 55px;
            position: relative;
        }

        .popJoin {
            width: 50px;
            height: 50px;
            left: 30%;
            position: absolute;
            display: inline-block;
            border-radius: 50%;
            text-align: center;
            font-size: 30px;
            padding: 5px;
            color: green;
            background-color: #ffff;
            cursor: pointer;
        }

        .popCancel {
            width: 50px;
            height: 50px;
            left: 60%;
            position: absolute;
            display: inline-block;
            border-radius: 50%;
            text-align: center;
            font-size: 30px;
            padding: 5px;
            color: red;
            cursor: pointer;
        }

        .popJoin:hover {
            transition: .6s;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            background-color: green;
            color: white;
        }

        .popCancel:hover {
            transition: .6s;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            background-color: red;
            color: white;
        }
    </style>
    <script src="https://kit.fontawesome.com/4be9a87855.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="shorcut icon" href="../../../image/logo.png">
</head>
<body>
<div class="layerpop">
    <div class="popwrap">
        <div class="poptop">JOIN</div>
        <div class="poplogo"></div>
        <div class="poptable">
            <form action="/main/join" id="joinAction" method="post">
                <table class="poptb">
                    <tr>
                        <td>
                            account
                        </td>
                        <td>
                            <input type="text" name="joinAccount" id="joinAccount" required="required">
                        </td>
                        <td name="checkAccount" id="checkAccount"
                            style="width: 120px; border-left: 0; font-size: 11px"></td>
                    </tr>
                    <tr>
                        <td>
                            password
                        </td>
                        <td colspan="2">
                            <input type="password" name="password" required="required">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            name
                        </td>
                        <td colspan="2">
                            <input type="text" name="name" required="required">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            email
                        </td>
                        <td colspan="2">
                            <input type="email" name="email" required="required">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            phone
                        </td>
                        <td colspan="2">
                            <input type="text" name="phoneNumber" required="required">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            location
                        </td>
                        <td colspan="2">
                            <input type="text" name="location" required="required">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="popButton">
            <div class="popJoin" onclick="join()">
                <i class="fas fa-check"></i>
            </div>
            <div class="popCancel">
                <i class="fas fa-times"></i>
            </div>
        </div>
    </div>

</div>
<div class="wrap">
    <div id="page1" class="page">
        <div class="screen">
            <div class="logo"></div>
            <form action="/main/login" id="loginAction" method="post">
                <input type="text" name="account" class="account" placeholder="User ID">
                <input type="password" name="password" class="password" placeholder="User PW">
                <div class="login" style="cursor: pointer" onclick="login()">LOGIN</div>
            </form>
            <div class="social">
                <div class="socialIcon">
                    <a href="http://www.facebook.com"><img src="../../../image/facebook.png"></a>
                </div>
                <div class="socialIcon">
                    <a href="http://www.instagram.com"><img src="../../../image/insta.png"></a>
                </div>
                <div class="socialIcon">
                    <a href="http://www.twitter.com"><img src="../../../image/twitter.png"></a>
                </div>
                <div class="socialIcon">
                    <a href="https://www.kakaocorp.com"><img src="../../../image/kakao.png"></a>
                </div>
                <div class="socialIcon">
                    <a href="https://www.wechat.com"><img src="../../../image/wechat.png"></a>
                </div>
            </div>
            <div class="letter">지금 회원가입 하세요</div>
            <div class="join" style="cursor: pointer">JOIN</div>
        </div>
    </div>
    <div id="page2" class="page">

    </div>
</div>
</body>
<script>
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

    $(document).ready(function () {
        $(".join").click(function () {
            $(".layerpop").fadeIn(300, function () {
                $(".popwrap").fadeIn(300);
            });
        });
        $(".popCancel").click(function () {
            $(".popwrap").fadeOut(300, function () {
                $(".layerpop").fadeOut(300),
                    $("#joinAccount").val(""),
                    $("#checkAccount").html("");
                ;
            });
        });
    });

    $("#joinAccount").keyup(function () {
        $.ajax({
            type: "POST",
            url: "/main/checkAccount",
            data: "joinAccount=" + $("#joinAccount").val(),
            dataType: "text",
            success: function (data) {
                if ($("#joinAccount").val() != "") {
                    $("#checkAccount").html(data);
                    if (data == '사용 가능') {
                        $("#checkAccount").css("color", "green");
                    } else {
                        $("#checkAccount").css("color", "red");
                    }
                } else {
                    $("#checkAccount").html("");
                }
            },
            error: function () {
                alert("error!");
            }
        });
    });

    function join() {
        if (document.getElementById("checkAccount").innerHTML == "사용 가능") {
            document.getElementById("joinAction").submit();
            alert("회원가입 완료");
        } else {
            alert("아이디를 확인해주세요");
        }
    }

    function login() {
        document.getElementById("loginAction").submit();
    }
</script>
</html>
