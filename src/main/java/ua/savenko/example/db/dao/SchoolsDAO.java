package ua.savenko.example.db.dao;

import ua.savenko.example.db.medol.School;

import java.util.List;

public interface SchoolsDAO {
    String TABLE_NAME = "school";
    String SQL_SELECT = "SELECT * FROM " + TABLE_NAME;
    String SQL_SELECT_BY_ID = "SELECT " + School.COLUMN_NAME + ", " + School.COLUMN_DESCRIPTION + ", "+School.COLUMN_PRINCIPAL+" FROM " + TABLE_NAME + " WHERE " + School.COLUMN_ID + " = ?";
    String SQL_INSERT = "INSERT INTO " + TABLE_NAME + "(" + School.COLUMN_NAME + ", " + School.COLUMN_DESCRIPTION + ", "+School.COLUMN_PRINCIPAL+") VALUES(?,?)";
    String SQL_DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + "WHERE " + School.COLUMN_ID + "=?";
    String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + School.COLUMN_NAME + " = ?, " +School.COLUMN_PRINCIPAL + " = ?, "+ School.COLUMN_DESCRIPTION + " = ? WHERE " + School.COLUMN_ID + " = ?";

    List<School> findAll();

    School getById(int id);

    void add(School school);

    void delete(int id);

    void update(School school);
}
