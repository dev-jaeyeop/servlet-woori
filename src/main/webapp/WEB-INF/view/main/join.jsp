<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Join</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            overflow: hidden;
        }

        .wrap {
            width: 500px;
            height: 600px;
            /*background-color: white;*/
        }

        .top {
            width: 100%;
            height: 50px;
            text-align: center;
            font-weight: 900;
            font-size: 35px;
            color: white;
            background-color: #ec6169;
        }

        .logo {
            width: 200px;
            height: 200px;
            left: 30%;
            position: relative;
            background-image: url(/image/logo.png);
            background-repeat: no-repeat;
            background-size: cover;
        }

        .table {
            width: 100%;
            height: 280px;
        }

        .tb {
            left: 5%;
            position: absolute;
            margin: 10px;
            padding: 10px;
            border-spacing: 15px;
            font-weight: 900;
            color: #fce77e;
            text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
        }

        .button {
            width: 100%;
            height: 55px;
            position: relative;
        }

        .join {
            width: 50px;
            height: 50px;
            left: 30%;
            position: absolute;
            display: inline-block;
            border-radius: 50%;
            text-align: center;
            font-size: 30px;
            padding: 10px;
            color: green;
            background-color: #ffff;

        }

        .cancel {
            width: 50px;
            height: 50px;
            left: 60%;
            position: absolute;
            display: inline-block;
            border-radius: 50%;
            text-align: center;
            font-size: 30px;
            padding: 10px;
            color: red;
        }

        .join:hover {
            transition: .6s;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            background-color: green;
            color: white;
        }

        .cancel:hover {
            transition: .6s;
            box-shadow: 0 5px 4px rgba(0, 0, 0, .5);
            background-color: red;
            color: white;
        }
    </style>
    <script src="https://kit.fontawesome.com/4be9a87855.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<form action="/Woori/joinProcess.do" method="post" name="frm">
    <div class="wrap">
        <div class="top">JOIN</div>
        <div class="logo"></div>
        <div class="table">
            <table class="tb">
                <tr>
                    <td>account</td>
                    <td><input type="text" name="account" required="required" id="account"></td>
                    <td name="checkAccount" id="checkAccount" style="width: 120px; border-left: 0"></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td colspan="2"><input type="text" name="pw" required="required"></td>
                </tr>
                <tr>
                    <td>name</td>
                    <td colspan="2"><input type="text" name="name" required="required"></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td colspan="2"><input type="text" name="email" required="required"></td>
                </tr>
                <tr>
                    <td>phone</td>
                    <td colspan="2"><input type="text" name="phone" required="required"></td>
                </tr>
                <tr>
                    <td>address</td>
                    <td colspan="2"><input type="text" name="address" required="required"></td>
                </tr>

            </table>

        </div>
        <div class="button">
            <div class="join"><i class="fas fa-check"></i></div>
            <div class="cancel"><i class="fas fa-times"></i></div>
        </div>
    </div>
</form>

<script>
    $("#account").keyup(function () {
        var params = "account=" + $("#account").val();
        $.ajax({
            type: "POST",
            url: "joinProc.jsp",
            data: params,
            dataType: "json",

            error: function (error) {
                alert("error!");
            },

            success: function (args) {
                if ($("#account").val() != "") {
                    $("#checkAccount").html(args.result);
                    if (args.result == '사용 가능') {
                        $("#checkAccount").css("color", "green");
                    } else {
                        $("#checkAccount").css("color", "red");
                    }
                } else {
                    $("#checkAccount").html("");
                }

            }
        });

    });

    function reg() {
        frm.submit();
    }

    function can() {
        location.href = "join.jsp";
    }
</script>
</body>
</html>