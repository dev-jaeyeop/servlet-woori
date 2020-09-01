package dao;

import dbConnection.DBConnectionMgr;
import model.dto.Band;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookmarkDAO {
    DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int result;

    public ArrayList<Band> selectBookmark(int userId) {
        String sql = "select * from bookmark where user_id = ?;";
        ArrayList<Band> bookmark = new ArrayList<>();

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
}
