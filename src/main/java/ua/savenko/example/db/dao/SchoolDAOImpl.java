package ua.savenko.example.db.dao;

import ua.savenko.example.db.medol.School;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAOImpl implements SchoolsDAO {

    @Override
    public List<School> findAll() {
        List<School> schools = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DAOFabrica.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL_SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                schools.add(new School(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));
            }
        } catch (SQLException e) {
        } finally {
            DAOFabrica.closeConnection(conn);
        }
        return schools;
    }

    @Override
    public School getById(int id) {
        School school  = null;
        Connection conn = null;
        try {
            conn = DAOFabrica.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                school = new School(id,
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(4));
            }
        } catch (SQLException e) {
        } finally {
            DAOFabrica.closeConnection(conn);
        }
        return school;
    }

    @Override
    public void add(School school) {
        Connection conn = null;
        try {
            conn = DAOFabrica.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL_INSERT);
            statement.setString(1, school.getName());
            statement.setString(2, school.getDescription());
            statement.setString(3, school.getPrincipal());
            statement.execute();
        } catch (SQLException e) {
        } finally {
            DAOFabrica.closeConnection(conn);
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        try {
            conn = DAOFabrica.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL_DELETE_BY_ID);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
        } finally {
            DAOFabrica.closeConnection(conn);
        }
    }

    @Override
    public void update(School school) {
        Connection conn = null;
        try {
            conn = DAOFabrica.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL_UPDATE);
            statement.setString(1, school.getName());
            statement.setString(2, school.getPrincipal());
            statement.setString(3, school.getDescription());
            statement.setInt(4, school.getId());
            statement.execute();
        } catch (SQLException e) {
        } finally {
            DAOFabrica.closeConnection(conn);
        }
    }
}