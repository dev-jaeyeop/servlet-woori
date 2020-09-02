<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>join</title>
    <style>
        #checkID {
            font-size: 10px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<form id="joinForm" action="/main/join/process" method="post">
    <table>
        <tr>
            <th colspan="2">
                JOIN
            </th>
        </tr>
        <tr>
            <td>
                account: <input type="text" id="account" name="account" required="required">
            </td>
            <td id="checkAccount" style="width: 120px; border-left: 0"></td>
        </tr>
        <tr>
            <td colspan="2">
                password: <input type="text" name="password" required="required">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                name: <input type="text" name="name" required="required">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                email: <input type="text" name="email" required="required">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                phone: <input type="text" name="phoneNumber" required="required">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                address: <input type="text" name="location" required="required">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="가입" onclick="joinFun()">
                <input type="button" value="취소" onclick="cancelFun()">
            </td>
        </tr>
    </table>
</form>

<script>
    $("#account").keyup(function () {
        var params = "account=" + $("#account").val();
        $.ajax({
            type: "POST",
            url: "/main/join/checkAccount",
            data: params,
            dataType: "json",

            error: function (error) {
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

    function joinFun() {
        document.getElementById("joinForm").submit(function () {
            window.close();
        });
    }

    function cancelFun() {
        window.close();
    }
</script>
</body>
</html>