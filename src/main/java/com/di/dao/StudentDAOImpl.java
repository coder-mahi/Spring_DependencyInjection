package com.di.dao;

import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.di.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
    private static final String STUDENT_INSERT_QUERY = "INSERT INTO SP_STUDENT VALUES(?,?,?,?,?)";
    private DataSource dataSource;

    public StudentDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int insert(StudentBO bo) {
        int result = 0;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(STUDENT_INSERT_QUERY)) {
            ps.setInt(1, bo.getSno());
            ps.setString(2, bo.getSname());
            ps.setInt(3, bo.getTotal());
            ps.setFloat(4, bo.getAvg());
            ps.setString(5, bo.getResult());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return result;
    }
}
