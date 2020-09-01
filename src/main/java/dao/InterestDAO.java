package dao;

import dbConnection.DBConnectionMgr;
import model.dto.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InterestDAO {
    DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int result;

    public ArrayList<Category> selectInterestByUserId(int userId) {
        String sql = "select * from interest where user_id = ?;";
        ArrayList<Category> interest = new ArrayList<>();

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                interest.add(new CategoryDAO().selectCategoryById(resultSet.getInt("category_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return interest;
    }

    public ArrayList<Category> selectInterestByCategoryId(int categoryId) {
        String sql = "select * from interest where category_id = ?;";
        ArrayList<Category> interest = new ArrayList<>();

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                interest.add(new CategoryDAO().selectCategoryById(resultSet.getInt("category_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return interest;
    }

    public int deleteInterestByUserId(int userId) {
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
}
