<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .wrap {
            width: 500px;
            height: 500px;
            background-color: white;
            border: 1px solid black;
        }

        .top {
            width: 100%;
            height: 50px;
            text-align: center;
            font-weight: 900;
            font-size: 35px;
            color: white;
            background-color: #fce77e;
        }

        .logo {
            width: 200px;
            height: 200px;
            top: 5%;
            left: 30%;
            position: relative;
            background-image: url(woori.png);
            background-repeat: no-repeat;
            background-size: cover;
        }

        .table {
            width: 100%;
            height: 150px;
        }

        .tb {
            left: 5%;
            position: absolute;
            margin: 10px;
            padding: 10px;
            border-spacing: 15px;
            font-weight: 900;
            color: #fce77e;
        }

        .bottom {
            width: 100%;
            height: 55px;
            position: relative;
        }

        .login {
            width: 50px;
            height: 50px;
            left: 20%;
            position: absolute;
            display: inline-block;
            border-radius: 50%;
            text-align: center;
            font-size: 30px;
            padding: 10px;
            color: skyblue;
            background-color: #ffff;
        }

        .join {
            width: 50px;
            height: 50px;
            left: 45%;
            position: absolute;
            display: inline-block;
            border-radius: 50%;
            text-align: center;
            font-size: 30px;
            padding: 10px;
            color: #fce77e;
            background-color: #ffff;
        }

        .login:hover {
            transition: .6s;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            background-color: skyblue;
            color: white;
        }

        .join:hover {
            transition: .6s;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            background-color: #fce77e;
            color: white;
        }

        .exit {
            width: 50px;
            height: 50px;
            left: 70%;
            position: absolute;
            display: inline-block;
            border-radius: 50%;
            text-align: center;
            font-size: 30px;
            padding: 10px;
            color: red;
            background-color: #ffff;
        }

        .exit:hover {
            transition: .6s;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            background-color: red;
            color: white;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
</head>
<body>
<form action="/Woori/loginProcess.do">
    <div class="wrap">
        <div class="top">Login</div>
        <div class="logo"></div>
        <div class="table">
            <table class="tb">
                <tr>
                    <td><span style="color:#ec6169; font-size: 30px; font-weight: 900;"> ID </span></td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td><span style="color:#ec6169; font-size: 30px; font-weight: 900;"> PW </span></td>
                    <td><input type="text" name="pw"></td>
                </tr>
            </table>
        </div>
        <div class="bottom">
            <div class="login" onclick="login()"><i class="fas fa-user-check"></i></div>
            <div class="join" onclick="reg()"><i class="fas fa-user-plus"></i></div>
            <div class="exit" onclick="exit()"><i class="fas fa-times"></i></div>
        </div>
    </div>
</form>
<script>
    function login() {

    }

    function reg() {
        location.href = "join.jsp";
    }

    function exit() {
        location.href = "";
    }
</script>
</body>
</html>