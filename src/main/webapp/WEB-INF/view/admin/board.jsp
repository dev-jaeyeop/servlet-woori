<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-09-08
  Time: 오전 11:10
  To change this template use File | Settings | File Templates.
--%>
<h2 style="display: inline-block">
    Board
</h2>
<i class="far fa-plus-square" name="createButton" title="create"
   onclick="action(this, 'createBoard', 'createBoard', 'create')"></i>
<br><br>
<table>
    <tr>
        <th>
            id
        </th>
        <th>
            title
        </th>
        <th>
            createdAt
        </th>
        <th>
            updatedAt
        </th>
        <th>
            Action
        </th>
    </tr>
    <c:forEach var="board" items="${boards}" begin="0" step="1">
        <form id="boardForm${board.id}" method="post">
            <input type="hidden" name="type" value="board">
            <tr>
                <td>
                    <input type="text" name="id" value="${board.id}" readonly="readonly">
                </td>
                <td>
                    <input type="text" name="name" value="${board.title}" readonly="readonly" required="required">
                </td>
                <td>
                    <input type="text" value="${board.createdAt}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value="${board.updatedAt}" readonly="readonly">
                </td>
                <td>
<%--                    <i class="far fa-edit" name="updateButton" title="update"--%>
<%--                       onclick="action(this, 'categoryUpdateItem${category.id}', 'categoryForm${category.id}', 'update')"></i>--%>
                    <i class="far fa-trash-alt" name="deleteButton" title="delete"
                       onclick="action(this, 'boardUpdateItem${board.id}', 'boardForm${board.id}', 'delete')"></i>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>


