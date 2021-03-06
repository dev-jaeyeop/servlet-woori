package dao;

import dbcp.DatabaseConnectionPool;
import model.dto.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDAO {
    private DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int result;

    public int createCategory(String name, String icon, String createdBy) {
        String sql = "insert into category values (null, ?, ?, default, ?, null, null);";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, icon);
            preparedStatement.setString(3, createdBy);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public Category selectCategoryById(int categoryId) {
        String sql = "select * from category where id = ?";
        Category category = null;

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = new Category();
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
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return category;
    }

    public Category selectCategoryByName(String categoryName) {
        String sql = "select * from category where name = ?";
        Category category = null;

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = new Category();
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
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return category;
    }

    public ArrayList<Category> selectCategoryAll() {
        String sql = "select * from category";
        ArrayList<Category> categories = new ArrayList<>();

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
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
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return categories;
    }

    public int updateCategory(String categoryId, String name, String icon) {
        String sql = "update category set name = ?, icon = ? where id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, icon);
            preparedStatement.setInt(3, Integer.parseInt(categoryId));
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteCategory(String categoryId) {
        String sql = "delete from category where id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(categoryId));
            if (new BandDAO().selectBandAllByCategoryId(categoryId).size() == 0) {
                result = preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }
}
