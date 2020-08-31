package model.dao;

import dbConnection.DBConnectionMgr;
import model.dto.Band;
import model.dto.Category;
import model.dto.Member;
import model.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
    DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int result;

    public ArrayList<User> selectUserAll() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "select * from user;";

        try {
            connection = dbConnectionMgr.getConnection();
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
                user.setPhoto(resultSet.getString("photo"));
                user.setCreatedAt(resultSet.getDate("created_at"));
                user.setUpdatedAt(resultSet.getDate("updated_at"));
                user.setUpdatedBy(resultSet.getString("updated_by"));
                user.setBookmark(selectBookmark(user.getId()));
                user.setInterest(selectInterestByUserId(user.getId()));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return users;
    }

    public int updateUser(String userId, String role, String password, String name, String email, String phoneNumber, String updatedBy) {
        String sql = "update user set role = ?, password = ?, name = ?, email = ?, phone_number = ?, updated_by = ? where id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, updatedBy);
            preparedStatement.setInt(7, Integer.parseInt(userId));
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteUser(String userId) {
        String sql = "delete from user where id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(userId));
            deleteBookmarkByUserId(Integer.parseInt(userId));
            deleteInterest(Integer.parseInt(userId));
            ArrayList<Member> members = selectMemberAllByUserId(Integer.parseInt(userId));
            if (members != null) {
                for (int i = 0; i < members.size(); i++) {
                    deleteReply(members.get(i).getId());
                    deleteBoard(members.get(i).getId());
                    // 얘가 만든 밴드도 삭제 해야함
                }
                deleteMemberByUserId(Integer.parseInt(userId));
            }
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public ArrayList<Band> selectBookmark(int userId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Band> bookmark = new ArrayList<>();
        String sql = "select * from bookmark where user_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Band band = new BandDAO().selectBandByBandId(resultSet.getInt("band_id"));
                bookmark.add(band);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return bookmark;
    }

    public int deleteBookmarkByUserId(int userId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String sql = "delete from bookmark where user_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteBookmarkByBandId(int bandId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String sql = "delete from bookmark where band_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bandId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public ArrayList<Category> selectInterestByUserId(int userId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Category> interest = new ArrayList<>();
        String sql = "select * from interest where user_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new CategoryDAO().selectCategoryById(resultSet.getInt("category_id"));
                interest.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return interest;
    }

    public ArrayList<Category> selectInterestByCategoryId(int categoryId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Category> interest = new ArrayList<>();
        String sql = "select * from interest where category_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new CategoryDAO().selectCategoryById(resultSet.getInt("category_id"));
                interest.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return interest;
    }

    public int deleteInterest(int userId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String sql = "delete from interest where user_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int createMember(int userId, int bandId, String role) {
        String sql = "insert into member values (null, ?, ?, ?, default);";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, bandId);
            preparedStatement.setString(3, role);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public ArrayList<Member> selectMemberAllByUserId(int userId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Member> members = new ArrayList<>();
        String sql = "select * from member where user_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Member member = new Member();
                member.setId(resultSet.getInt("id"));
                member.setUserId(resultSet.getInt("user_id"));
                member.setBandId(resultSet.getInt("band_id"));
                member.setRole(resultSet.getString("role"));
                member.setRegisteredAt(resultSet.getDate("registered_at"));
                members.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return members;
    }

    public ArrayList<Member> selectMemberAllByBandId(int bandId) {
        ArrayList<Member> members = new ArrayList<>();
        String sql = "select * from member where band_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bandId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Member member = new Member();
                member.setId(resultSet.getInt("id"));
                member.setUserId(resultSet.getInt("user_id"));
                member.setBandId(resultSet.getInt("band_id"));
                member.setRole(resultSet.getString("role"));
                member.setRegisteredAt(resultSet.getDate("registered_at"));
                members.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return members;
    }

    public int deleteMemberByUserId(int userId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String sql = "delete from member where user_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteMemberByBandId(int bandId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String sql = "delete from member where band_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bandId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteReply(int memberId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String sql = "delete from reply where member_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, memberId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteBoard(int memberId) {
        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;

        String sql = "delete from board where member_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, memberId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }
}
