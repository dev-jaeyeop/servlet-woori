<%--
  Created by IntelliJ IDEA.
  User: Jaeyeop
  Date: 8/24/2020
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<h2>
    User
</h2>
<br>
<table>
    <tr>
        <th>
            id
        </th>
        <th>
            role
        </th>
        <th>
            account
        </th>
        <th>
            password
        </th>
        <th>
            name
        </th>
        <th>
            email
        </th>
        <th>
            phoneNumber
        </th>
        <th>
            location
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
    <c:forEach var="user" items="${users}" begin="0" step="1">
        <form id="userForm${user.id}" method="post">
            <input type="hidden" name="type" value="user">
            <tr>
                <td>
                    <input type="text" name="id" value="${user.id}" readonly="readonly">
                </td>
                <td>
                    <select name="role" class="userUpdateItem${user.id}" disabled>
                        <option value="${user.role}" selected hidden>${user.role}</option>
                        <option value="admin">admin</option>
                        <option value="user">user</option>
                    </select>
                </td>
                <td>
                    <input type="text" value="${user.account}" readonly="readonly">
                </td>
                <td>
                    <input type="text" name="password" class="userUpdateItem${user.id}" value="${user.password}"
                           readonly="readonly"
                           required="required">
                </td>
                <td class="name">
                    <input type="text" name="name" class="userUpdateItem${user.id}" value="${user.name}"
                           readonly="readonly"
                           required="required">
                </td>
                <td>
                    <input type="text" name="email" class="userUpdateItem${user.id}" value="${user.email}"
                           readonly="readonly"
                           required="required">
                </td>
                <td>
                    <input type="text" name="phoneNumber" class="userUpdateItem${user.id}" value="${user.phoneNumber}"
                           readonly="readonly"
                           required="required">
                </td>
                <td>
                    <input type="text" value="${user.location}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value="${user.createdAt}" readonly="readonly">
                </td>
                <td>
                    <input type="text" value="${user.updatedAt}" readonly="readonly">
                </td>
                <td>
                    <input type="text" name="updatedBy" value="${user.updatedBy}" readonly="readonly">
                </td>
                <td>
                    <i class="far fa-edit" name="updateButton" title="update"
                       onclick="action(this, 'userUpdateItem${user.id}', 'userForm${user.id}', 'update')"></i>
                    <i class="far fa-window-close" name="cancelButton" title="cancel"
                       onclick="action(this, 'userUpdateItem${user.id}', 'userForm${user.id}', 'cancel')"></i>
                    <i class="far fa-trash-alt" name="deleteButton" title="delete"
                       onclick="action(this, 'userUpdateItem${user.id}', 'userForm${user.id}', 'delete')"></i>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>
