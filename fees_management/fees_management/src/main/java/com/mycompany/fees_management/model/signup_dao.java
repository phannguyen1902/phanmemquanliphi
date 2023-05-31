/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fees_management.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class signup_dao {

    public boolean insert(TTsign_up signu) throws Exception {

        String sql = "insert into signup (id,firstname,lastname,username,password,dob,contact_no) values (?,?,?,?,?,?,?)";
       
        try (
                Connection con = databaseHelper.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, signu.getId());
            pstmt.setString(2, signu.getFirstname());
            pstmt.setString(3, signu.getLastname());
            pstmt.setString(4, signu.getUsername());
            pstmt.setString(5, signu.getPassword());
            //định dạng ngày chuan 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdf.format(signu.getDob());
            pstmt.setString(6, dateStr);
            pstmt.setString(7, signu.getContact_no());
            return pstmt.executeUpdate() > 0;

        }
    }
}
