package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.util.DBUtil;
import gr.aueb.cf.schoolapp.service.util.DateUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    @Override
    public Student insert(Student student) throws StudentDAOException {
        String sql = "INSERT INTO STUDENTS (FIRSTNAME, LASTNAME, GENDER, BIRTH_DATE, CITY_ID, USER_ID) " +
                "VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            String firstname = student.getFirstname();
            String lastname = student.getLastname();
            String gender = String.valueOf(student.getGender());
            String birthdate = student.getBirthday();
            int cityId = student.getCityId();
            int usernameId = student.getUserId();

            ps.setString(1, firstname);
            ps.setString(2,  lastname);
            ps.setString(3, gender);
            ps.setString(4, birthdate);
            ps.setInt(5, cityId);
            ps.setInt(6, usernameId);
            ps.executeUpdate();

            int n = ps.executeUpdate();
            if (n != 1) {
                return null;
            }
            JOptionPane.showMessageDialog(null, n + " rows affected", "Insert", JOptionPane.INFORMATION_MESSAGE);
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Insert Error In Student " + student);
        }
    }

    @Override
    public Student update(Student student) throws StudentDAOException {
        String sql = "UPDATE STUDENTS SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?";
        /* Ερωτηματικά βάζουμε για να μην έχουμε προβλήματα με SQL Injections */
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            int id = student.getId();
            String firstname = student.getFirstname();
            String lastname = student.getLastname();

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setInt(3, id);

            int n = ps.executeUpdate();
            if (n != 1) {
                return null;
            }
            JOptionPane.showMessageDialog(null, n + " rows affected", "Insert", JOptionPane.INFORMATION_MESSAGE);
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Insert Error In Student " + student);
        }
    }

    @Override
    public void delete(Integer id) throws StudentDAOException {
        String sql = "DELETE FROM STUDENTS WHERE ID = ?";

        try (Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Delete Error In Student With Id: " + id);
        }
    }

    @Override
    public Student getById(Integer id) throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS WHERE ID = ?";
        Student student = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs;

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("GENDER"),
                        rs.getString("BIRTH_DATE"),
                        rs.getInt("CITY_ID"),
                        rs.getInt("USER_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Get Id Error In Student With Id: " + id);
        }
        return student;
    }

    @Override
    public List<Student> getByLastname(String lastname) throws StudentDAOException {
        String sql = "SELECT * FROM STUDENTS WHERE LASTNAME LIKE ?";
        List<Student> students = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs;
            ps.setString(1, lastname + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("GENDER"),
                        rs.getString("BIRTH_DATE"),
                        rs.getInt("CITY_ID"),
                        rs.getInt("USER_ID"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException("SQL Get lastname Error In Student With lastname: " + lastname);
        }
        return students;
    }
}
