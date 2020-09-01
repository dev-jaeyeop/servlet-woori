<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>join</title>
    <style>
        #checkID {
            font-size: 10px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form action="/Woori/joinProcess.do" method="post" id="frm">
    <table>
        <tr>
            <td colspan="3">
                JOIN
            </td>
        </tr>
        <tr>
            <td>
                account
            </td>
            <td>
                <input type="text" name="account" required="required" id="account">
            </td>
            <td name="checkAccount" id="checkAccount" style="width: 120px; border-left: 0">

            </td>
        </tr>
        <tr>
            <td>
                password
            </td>
            <td colspan="2">
                <input type="text" name="pw" required="required">
            </td>
        </tr>
        <tr>
            <td>name</td>
            <td colspan="2"><input type="text" name="name"
                                   required="required"></td>
        </tr>
        <tr>
            <td>email</td>
            <td colspan="2"><input type="text" name="email"
                                   required="required"></td>
        </tr>
        <tr>
            <td>phone</td>
            <td colspan="2"><input type="text" name="phone"
                                   required="required"></td>
        </tr>
        <tr>
            <td>address</td>
            <td colspan="2"><input type="text" name="address"
                                   required="required"></td>
        </tr>
        <tr>
            <td>photo</td>
            <td colspan="2"><input type="text" name="photo"
                                   required="required"></td>
        </tr>
        <tr>
            <td colspan="3"><input type="button" value="가입" onclick="reg()">
                <input type="button" value="취소" onclick="can()"></td>
        </tr>
    </table>
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
        document.getElementById("frm").submit();
    }

    function can() {
        location.href = "join.jsp";
    }
</script>
</body>
</html>