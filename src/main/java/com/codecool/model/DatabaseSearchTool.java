package com.codecool.model;

import com.codecool.testfiles.JavaPostgreSqlRetrieve;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseSearchTool {
    private String url = "jdbc:postgresql://localhost:5432/application_process_db";
    private String user = "postgres";
    private String password = "sMuGa1@1";

    public DatabaseSearchTool() {
        ;
    }

    public void selectMentorsNames() {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("SELECT * FROM mentors");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaPostgreSqlRetrieve.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}
