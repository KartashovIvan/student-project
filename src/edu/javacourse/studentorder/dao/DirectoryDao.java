package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.Street;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DirectoryDao {

    private Connection getConnction () throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://usdb.test.local:5432/student_project",
                "student","Qq12345");
        return con;
    }

    public List<Street> firstStreet (String pattern) throws Exception{
        List <Street> result = new LinkedList<>();
        Connection con = getConnction();
        Statement stmt = con.createStatement();
        String sql = "select  street_code, street_name " +
                "from jc_streets js where upper(street_name)  like upper ('%" + pattern + "%')";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
            result.add(str);
        }

        return result;
    }
}
