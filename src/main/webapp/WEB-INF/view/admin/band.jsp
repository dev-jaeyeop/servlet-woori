<%--
  Created by IntelliJ IDEA.
  User: Jaeyeop
  Date: 8/24/2020
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<h2>
    Band
</h2>
<br>
<table>
    <tr>
        <th>
            id
        </th>
        <th>
            category
        </th>
        <th>
            name
        </th>
        <th>
            introduction
        </th>
        <th>
            location
        </th>
        <th>
            capacity
        </th>
        <th>
            createdAt
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
    <c:forEach var="band" items="${bands}" begin="0" step="1">
        <form id="bandForm${band.id}" method="post">
            <input type="hidden" name="type" value="band">
            <tr>
                <td>
                    <input type="text" name="id" value="${band.id}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value="${band.category}" readonly="readonly">
                </td>
                <td>
                    <input type="text" name="name" class="bandUpdateItem${band.id}" value="${band.name}"
                           readonly="readonly" required="required">
                </td>
                <td>
                    <input type="text" value="${band.introduction}" readonly="readonly">
                </td>
                <td>
                    <input type="text" name="location" class="bandUpdateItem${band.id}" value="${band.location}"
                           readonly="readonly" required="required">
                </td>
                <td>
                    <input type="text" name="capacity" class="bandUpdateItem${band.id}" value="${band.capacity}"
                           readonly="readonly" required="required">
                </td>
                <td>
                    <input type="text" value="${band.createdAt}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value=" ${band.updatedAt}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value="${band.updatedBy}" readonly="readonly">
                </td>
                <td>
                    <i class="far fa-edit" name="updateButton" title="update"
                       onclick="action(this, 'bandUpdateItem${band.id}', 'bandForm${band.id}', 'update')"></i>
                    <i class="far fa-window-close" name="cancelButton" title="cancel"
                       onclick="action(this, 'bandUpdateItem${band.id}', 'bandForm${band.id}', 'cancel')"></i>
                    <i class="far fa-trash-alt" name="deleteButton" title="delete"
                       onclick="action(this, 'bandUpdateItem${band.id}', 'bandForm${band.id}', 'delete')"></i>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>

