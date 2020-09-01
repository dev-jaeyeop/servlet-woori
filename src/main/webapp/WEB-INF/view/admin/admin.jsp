<%--
  Created by IntelliJ IDEA.
  User: Jaeyeop
  Date: 8/24/2020
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        header {
            border: 1px solid black;
            width: 100%;
            height: 5%;
        }

        nav {
            border: 1px solid black;
            width: 5%;
            height: 95%;
            text-align: center;
            float: left;
        }

        nav div {
            width: 100%;
            height: 5%;
            margin: 20% auto;
            font-weight: bold;
        }

        nav div:hover {
            opacity: 60%;
            cursor: pointer;
        }

        section {
            border: 1px solid black;
            width: 95%;
            height: 95%;
            float: left;
        }

        article {
            width: 100%;
            padding: 10px;
        }

        #band, #category {
            display: none;
        }

        table {
            border-collapse: collapse;
        }

        tr {
            border: 1px solid black;
        }

        td, th {
            text-align: center;
            padding: 5px;
            height: 30px;
        }

        input[type=text] {
            width: 80px;
            text-align: center;
            border: none;
            outline: none;
        }

        input[type=checkbox] {
            cursor: pointer;
        }

        .far {
            cursor: pointer;
        }
    </style>
    <script src="https://kit.fontawesome.com/4be9a87855.js" crossorigin="anonymous"></script>
</head>
<body>
<header>
    <h1>Admin</h1>
</header>
<nav>
    <div onclick="view('user')">
        <i class="fas fa-user-cog"></i><br>User
    </div>
    <div onclick="view('band')">
        <i class="fas fa-users-cog"></i><br>Band
    </div>
    <div onclick="view('category')">
        <i class="fas fa-wrench"></i><br>Category
    </div>
</nav>
<main>
    <section>
        <article id="user">
            <%@include file="user.jsp" %>
        </article>
        <article id="band">
            <%@include file="band.jsp" %>
        </article>
        <article id="category">
            <%@include file="category.jsp" %>
        </article>
    </section>
</main>
</body>
<script>
    function view(view) {
        switch (view) {
            case "user":
                document.getElementById("user").style.display = "revert";
                document.getElementById("band").style.display = "none";
                document.getElementById("category").style.display = "none"
                break;
            case "band":
                document.getElementById("band").style.display = "revert";
                document.getElementById("user").style.display = "none";
                document.getElementById("category").style.display = "none"
                break;
            case "category":
                document.getElementById("category").style.display = "revert";
                document.getElementById("user").style.display = "none";
                document.getElementById("band").style.display = "none"
                break;
        }
    }

    function action(object, updateItem, formId, action) {
        let form = document.getElementById(formId);
        let updateItems = document.getElementsByClassName(updateItem);

        switch (action) {
            case "create" :
                window.open("/createCategory");
                break;
            case "delete" :
                if (formId.indexOf("band") != -1) {
                    if (confirm("삭제 하시겠습니까?") && confirm("현재 속해있는 멤버가 있을 수 있습니다 삭제 하시겠습니까?")) {
                        form.action = "/delete";
                        form.submit();
                    }
                } else if (confirm("삭제 하시겠습니까?")) {
                    form.action = "/admin/delete";
                    form.submit();
                }
                break;
            case "update" :
                if (object.className == "fas fa-edit") {
                    if (confirm("업데이트 하시겠습니까?")) {
                        form.action = "/admin/update";
                        form.submit();
                    } else {
                        location.reload();
                    }
                }

                object.className = "fas fa-edit";
                object.style.cursor = "pointer";
                object.title = "update";

                for (let j = 0; j < updateItems.length; j++) {
                    switch (updateItems.item(j).tagName) {
                        case "INPUT":
                            updateItems.item(j).readOnly = false;
                            updateItems.item(j).style.outline = "revert";
                            updateItems.item(j).style.border = "revert";
                            break;
                        case "SELECT":
                            updateItems.item(j).disabled = false;
                            break;
                    }
                }
                break;
            case "cancel" :
                let fas = document.getElementsByClassName("fas fa-edit");

                for (let i = 0; i < fas.length; i++) {
                    fas[i].className = "far fa-edit";
                }

                for (let j = 0; j < updateItems.length; j++) {
                    updateItems.item(j).readOnly = true;
                    updateItems.item(j).style.outline = "none";
                    updateItems.item(j).style.border = "none";
                }
                break;
        }
    }
</script>
</html>
