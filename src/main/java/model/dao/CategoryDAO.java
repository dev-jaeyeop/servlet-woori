package model.dao;

import dbConnection.DBConnectionMgr;
import model.dto.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDAO {
    private DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int result;

    public int createCategory(String id, String name, String icon, String createdBy) {
        String sql = "insert into category values (id = ?, name = ?, icon = ?, created_at = default, created_by = ?, updated_at = null, updated_by = null);";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, icon);
            preparedStatement.setString(4, createdBy);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public Category selectCategoryById(int categoryId) {
        Category category = new Category();
        String sql = "select * from category where id = ?";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setIcon(resultSet.getString("icon"));
                category.setCreatedAt(resultSet.getDate("created_at"));
                category.setCreatedBy(resultSet.getString("created_by"));
                category.setUpdatedAt(resultSet.getDate("updated_at"));
                category.setUpdatedBy(resultSet.getString("updated_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return category;
    }

    public Category selectCategoryByName(String categoryName) {
        Category category = new Category();
        String sql = "select * from category where name = ?";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setIcon(resultSet.getString("icon"));
                category.setCreatedAt(resultSet.getDate("created_at"));
                category.setCreatedBy(resultSet.getString("created_by"));
                category.setUpdatedAt(resultSet.getDate("updated_at"));
                category.setUpdatedBy(resultSet.getString("updated_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return category;
    }

    public ArrayList<Category> selectCategoryAll() {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "select * from category";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setIcon(resultSet.getString("icon"));
                category.setCreatedAt(resultSet.getDate("created_at"));
                category.setCreatedBy(resultSet.getString("created_by"));
                category.setUpdatedAt(resultSet.getDate("updated_at"));
                category.setUpdatedBy(resultSet.getString("updated_by"));
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement, resultSet);
        }

        return categories;
    }

    public int updateCategory(String categoryId, String name) {
        String sql = "update category set name = ? where id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(categoryId));
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteCategory(String categoryId) {
        String sql = "delete from category where id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(categoryId));
            if (new BandDAO().selectBandAllByCategoryId(categoryId).size() == 0) {
                result = preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }
}
