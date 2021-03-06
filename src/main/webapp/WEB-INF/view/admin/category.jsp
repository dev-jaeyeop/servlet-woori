<%--
  Created by IntelliJ IDEA.
  User: Jaeyeop
  Date: 8/26/2020
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<h2 style="display: inline-block">
    Category
</h2>
<form id="createCategory" method="post" style="display: inline-block">
    <input type="hidden" name="type" value="category">
    name: <input type="text" name="name" required="required" style="outline: revert; border: revert">
    tag: <input type="text" name="icon" required="required" style="outline: revert; border: revert">
    <i class="far fa-plus-square" name="createButton" title="create"
       onclick="action(this, 'createCategory', 'createCategory', 'create')"></i>
</form>
<br><br>
<table>
    <tr>
        <th>
            id
        </th>
        <th>
            name
        </th>
        <th>
            icon
        </th>
        <th>
            createdAt
        </th>
        <th>
            createdBy
        </th>
        <th>
            updatedAt
        </th>
        <th>
            updatedBy
        </th>
        <th>
            Action
        </th>
    </tr>
    <c:forEach var="category" items="${categories}" begin="0" step="1">
        <form id="categoryForm${category.id}" method="post">
            <input type="hidden" name="type" value="category">
            <tr>
                <td>
                    <input type="text" name="id" value="${category.id}" readonly="readonly">
                </td>
                <td>
                    <input type="text" name="name" class="categoryUpdateItem${category.id}" value="${category.name}"
                           readonly="readonly" required="required">
                </td>
                <td>
                        ${category.icon}
                    <input type="text" name="icon" class="categoryUpdateItem${category.id}" value='${category.icon}'
                           readonly="readonly" required="required" style="width: 100%">
                </td>
                <td>
                    <input type="text" value="${category.createdAt}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value="${category.createdBy}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value="${category.updatedAt}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value="${category.updatedBy}" readonly="readonly">
                </td>
                <td>
                    <i class="far fa-edit" name="updateButton" title="update"
                       onclick="action(this, 'categoryUpdateItem${category.id}', 'categoryForm${category.id}', 'update')"></i>
                    <i class="far fa-window-close" name="cancelButton" title="cancel"
                       onclick="action(this, 'categoryUpdateItem${category.id}', 'categoryForm${category.id}', 'cancel')"></i>
                    <i class="far fa-trash-alt" name="deleteButton" title="delete"
                       onclick="action(this, 'categoryUpdateItem${category.id}', 'categoryForm${category.id}', 'delete')"></i>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>
