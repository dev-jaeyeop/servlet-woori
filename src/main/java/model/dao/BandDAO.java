package model.dao;

import dbConnection.DBConnectionMgr;
import model.dto.Band;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BandDAO {
    private DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int result;

    public int createBand(String category, String name, String introduction, String location, String photo, int capacity, String createdBy) {
        String sql = "insert into band values (null, ?, ?, ?, ?, ?, ?, default, ?, null, null);";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, new CategoryDAO().selectCategoryByName(category).getId());
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, introduction);
            preparedStatement.setString(4, location);
            preparedStatement.setString(5, photo);
            preparedStatement.setInt(6, capacity);
            preparedStatement.setString(7, createdBy);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public ArrayList<Band> selectBandAll() {
        ArrayList<Band> bands = new ArrayList<>();
        String sql = "select * from band;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Band band = new Band();
                band.setId(resultSet.getInt("id"));
                band.setCategory(new CategoryDAO().selectCategoryById(resultSet.getInt("category_id")).getName());
                band.setName(resultSet.getString("name"));
                band.setIntroduction(resultSet.getString("introduction"));
                band.setLocation(resultSet.getString("location"));
                band.setPhoto(resultSet.getString("photo"));
                band.setCapacity(resultSet.getInt("capacity"));
                band.setCreatedAt(resultSet.getDate("created_at"));
                band.setUpdatedAt(resultSet.getDate("updated_at"));
                band.setUpdatedBy(resultSet.getString("updated_by"));

                bands.add(band);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return bands;
    }

    public ArrayList<Band> selectBandAllByCategoryId(String categoryId) {
        ArrayList<Band> bands = new ArrayList<>();
        String sql = "select * from band where category_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(categoryId));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Band band = new Band();
                band.setId(resultSet.getInt("id"));
                band.setCategory(new CategoryDAO().selectCategoryById(resultSet.getInt("category_id")).getName());
                band.setName(resultSet.getString("name"));
                band.setIntroduction(resultSet.getString("introduction"));
                band.setLocation(resultSet.getString("location"));
                band.setPhoto(resultSet.getString("photo"));
                band.setCapacity(resultSet.getInt("capacity"));
                band.setCreatedAt(resultSet.getDate("created_at"));
                band.setUpdatedAt(resultSet.getDate("updated_at"));
                band.setUpdatedBy(resultSet.getString("updated_by"));
                bands.add(band);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return bands;
    }

    public Band selectBandByBandId(int bandId) {
        Band band = null;
        String sql = "select * from band where id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bandId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                band = new Band();
                band.setId(resultSet.getInt("id"));
                band.setCategory(new CategoryDAO().selectCategoryById(resultSet.getInt("category_id")).getName());
                band.setName(resultSet.getString("name"));
                band.setIntroduction(resultSet.getString("introduction"));
                band.setLocation(resultSet.getString("location"));
                band.setPhoto(resultSet.getString("photo"));
                band.setCapacity(resultSet.getInt("capacity"));
                band.setCreatedAt(resultSet.getDate("created_at"));
                band.setUpdatedAt(resultSet.getDate("updated_at"));
                band.setUpdatedBy(resultSet.getString("updated_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return band;
    }

    public int updateBand(String bandId, String name, String location, String capacity, String updatedBy) {
        String sql = "update band set name = ?, location = ?, capacity = ?, updated_by = ? where id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, location);
            preparedStatement.setInt(3, Integer.parseInt(capacity));
            preparedStatement.setString(4, updatedBy);
            preparedStatement.setInt(5, Integer.parseInt(bandId));
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteBand(String bandId) {
        String sql = "delete from band where id = ?;";
        UserDAO userDAO = new UserDAO();

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(bandId));
            userDAO.deleteMemberByBandId(Integer.parseInt(bandId));
            userDAO.deleteBookmarkByBandId(Integer.parseInt(bandId));
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

}
