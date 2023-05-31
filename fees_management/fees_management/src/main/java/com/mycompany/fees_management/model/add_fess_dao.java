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
public class add_fess_dao {

	public boolean insert(TT_add_fess t_add_fess) throws Exception {
		String sql = "insert into fess_details values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (
			Connection con = databaseHelper.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, t_add_fess.getReciept_no());
			pstmt.setString(2, t_add_fess.getStudent_name());
			pstmt.setString(3, t_add_fess.getRoll_no());
			pstmt.setString(4, t_add_fess.getPayment_mode());
			pstmt.setString(5, t_add_fess.getCheque_no());
			pstmt.setString(6, t_add_fess.getBank_name());
			pstmt.setString(7, t_add_fess.getDd_no());
			pstmt.setString(8, t_add_fess.getCourse_name());
			pstmt.setString(9, t_add_fess.getGstin());
			pstmt.setFloat(10, t_add_fess.getTotal_amount());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(t_add_fess.getDate());
			pstmt.setString(11, dateStr);
			pstmt.setFloat(12, t_add_fess.getAmount());
			pstmt.setFloat(13, t_add_fess.getCgst());
			pstmt.setFloat(14, t_add_fess.getSgst());
			pstmt.setString(15, t_add_fess.getTotal_in_words());
			pstmt.setString(16, t_add_fess.getRemark());
			pstmt.setInt(17, t_add_fess.getYear1());
			pstmt.setInt(18, t_add_fess.getYear2());
			return pstmt.executeUpdate()>0;
		}
	}
}
