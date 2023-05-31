		/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fees_management.model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class databaseHelper {
    
    public static Connection openConnection()throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;database=fess;trustServerCertificate=true;sslProtocol=TLSv1.2";
            Connection con = DriverManager.getConnection(connectionUrl, "sa", "1234");
        return con;
    }
}
