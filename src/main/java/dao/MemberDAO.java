package dao;

import controller.dbcp.DatabaseConnectionPool;
import model.dto.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
    DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int result;

    public int createMember(int userId, int bandId, String role) {
        String sql = "insert into member values (null, ?, ?, ?, default);";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, bandId);
            preparedStatement.setString(3, role);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public ArrayList<Member> selectMemberAllByUserId(int userId) {
        String sql = "select * from member where user_id = ?;";
        ArrayList<Member> members = new ArrayList<>();

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
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
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return members;
    }

    public ArrayList<Member> selectMemberAllByBandId(int bandId) {
        String sql = "select * from member where band_id = ?;";
        ArrayList<Member> members = new ArrayList<>();

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
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
        String sql = "delete from member where user_id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteMemberByBandId(int bandId) {
        String sql = "delete from member where band_id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bandId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }
}
