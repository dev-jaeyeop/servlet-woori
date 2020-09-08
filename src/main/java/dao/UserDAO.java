package dao;

import dbcp.DatabaseConnectionPool;
import model.dto.Member;
import model.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int result;

    public int createUser(String account, String password, String name, String email, String phoneNumber, String location) {
        String sql = "insert into user values (null, default, ?, ?, ?, ?, ?, ?, default, null, null);";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, location);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public ArrayList<User> selectUserAll() {
        String sql = "select * from user;";
        ArrayList<User> users = new ArrayList<>();

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setRole(resultSet.getString("role"));
                user.setAccount(resultSet.getString("account"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setLocation(resultSet.getString("location"));
                user.setCreatedAt(resultSet.getDate("created_at"));
                user.setUpdatedAt(resultSet.getDate("updated_at"));
                user.setUpdatedBy(resultSet.getString("updated_by"));
                user.setBookmark(new BookmarkDAO().selectBookmark(user.getId()));
                user.setInterest(new InterestDAO().selectInterestByUserId(user.getId()));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return users;
    }

    public User selectUserByAccount(String account) {
        String sql = "select * from user where account = ?;";
        User user = null;

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setRole(resultSet.getString("role"));
                user.setAccount(resultSet.getString("account"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setLocation(resultSet.getString("location"));
                user.setCreatedAt(resultSet.getDate("created_at"));
                user.setUpdatedAt(resultSet.getDate("updated_at"));
                user.setUpdatedBy(resultSet.getString("updated_by"));
                user.setBookmark(new BookmarkDAO().selectBookmark(user.getId()));
                user.setInterest(new InterestDAO().selectInterestByUserId(user.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return user;
    }

    public User selectUserById(String id) {
        String sql = "select * from user where id = ?;";
        User user = null;

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setRole(resultSet.getString("role"));
                user.setAccount(resultSet.getString("account"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setLocation(resultSet.getString("location"));
                user.setCreatedAt(resultSet.getDate("created_at"));
                user.setUpdatedAt(resultSet.getDate("updated_at"));
                user.setUpdatedBy(resultSet.getString("updated_by"));
                user.setBookmark(new BookmarkDAO().selectBookmark(user.getId()));
                user.setInterest(new InterestDAO().selectInterestByUserId(user.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return user;
    }

    public int updateUser(String id, String role, String password, String name, String email, String phoneNumber, String updatedBy) {
        String sql = "update user set role = ?, password = ?, name = ?, email = ?, phone_number = ?, updated_by = ? where id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, updatedBy);
            preparedStatement.setInt(7, Integer.parseInt(id));
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteUser(String id) {
        String sql = "delete from user where id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            if (selectUserById(id) != null) {
                new BookmarkDAO().deleteBookmarkByUserId(Integer.parseInt(id));
                new InterestDAO().deleteInterestByUserId(Integer.parseInt(id));
                ArrayList<Member> members = new MemberDAO().selectMemberAllByUserId(Integer.parseInt(id));
                if (members != null) {
                    ReplyDAO replyDAO = new ReplyDAO();
                    BoardDAO boardDAO = new BoardDAO();
                    for (int i = 0; i < members.size(); i++) {
                        replyDAO.deleteReplyByMemberId(members.get(i).getId());
                        boardDAO.deleteBoardByMemberId(members.get(i).getId());
                    }
                    new MemberDAO().deleteMemberByUserId(Integer.parseInt(id));
                }
                result = preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public boolean existAccount(String account) {
        String sql = "select * from user where account = ?;";
        boolean exist = false;

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return exist;
    }

    public boolean existUser(String account, String password) {
        String sql = "select * from user where account = ? and password = ?;";
        boolean exist = false;

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return exist;
    }
}
