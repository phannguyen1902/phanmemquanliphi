/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fees_management;

import com.mycompany.fees_management.model.TT_add_fess;
import com.mycompany.fees_management.model.add_fess_dao;
import com.mycompany.fees_management.model.databaseHelper;
import com.mycompany.fees_management.model.number_in_amount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Add_Fess extends javax.swing.JFrame {

	/**
	 * Creates new form Add_Fess
	 */
	public Add_Fess() throws Exception {
		initComponents();
                setLocationRelativeTo(null);
		displayCashFirst();
		FillCbb();
		int reciept = getRecieptno();
		txt_reclept.setText(Integer.toString(reciept));

	}

	public int getRecieptno() {
		String sql = "select max(reciept_no) from fess_details";
		int reciept_no = 0;
		try {
			Connection con = databaseHelper.openConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == true) {
				reciept_no = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reciept_no + 1;
	}

	public void displayCashFirst() {
		jlb_ddo.setVisible(false);
		jlb_cheque_no.setVisible(false);
		jlb_bankname.setVisible(false);

		txt_DDno.setVisible(false);
		txt_cheque.setVisible(false);
		txt_bankname.setVisible(false);
	}

	public boolean validation() {
		if (txt_reclept.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập user name !");
			return false;
		}
		if (txt_date.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập date! ");
			return false;
		}
		if (txt_amount.getText().equals("") && txt_amount.getText().matches("[0-9] +") == false) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập amout(Số) !");
			return false;
		}
		if (cbb_payment.getSelectedItem().toString().equalsIgnoreCase("DD")) {
			if (txt_DDno.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập DD no! ");
				return false;
			}
			if (txt_bankname.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập bank name! ");
				return false;
			}
		}
		if (cbb_payment.getSelectedItem().toString().equalsIgnoreCase("Cheque")) {
			if (txt_cheque.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập cheque no! ");
				return false;
			}
			if (txt_bankname.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập bank name! ");
				return false;
			}

		}
		if (cbb_payment.getSelectedItem().toString().equalsIgnoreCase("Card")) {
			if (txt_bankname.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập bank name! ");
				return false;
			}
		}
		return true;
	}

	public void FillCbb() throws Exception {
		String sql = "select course from TT_course";
		try (
			Connection con = databaseHelper.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cbb_course.addItem(rs.getString("course"));
			}
		}

	}

	public void save_data_add__fess() {
		try {

			TT_add_fess tT_add_fess = new TT_add_fess();
			tT_add_fess.setReciept_no(Integer.parseInt(txt_reclept.getText()));
			tT_add_fess.setStudent_name(txt_student_name.getText());
			tT_add_fess.setRoll_no(txt_rollno.getText());
			tT_add_fess.setPayment_mode(cbb_payment.getSelectedItem().toString());
			tT_add_fess.setCheque_no(txt_cheque.getText());
			tT_add_fess.setBank_name(txt_bankname.getText());
			tT_add_fess.setDd_no(txt_DDno.getText());
			tT_add_fess.setCourse_name(txt_coursename.getText());
			tT_add_fess.setGstin(txt_GSTIN.getText());
			tT_add_fess.setTotal_amount(Float.parseFloat(txt_total_amount.getText()));
			tT_add_fess.setDate(txt_date.getDate());
			tT_add_fess.setAmount(Float.parseFloat(txt_amount.getText()));
			tT_add_fess.setCgst(Float.parseFloat(txt_cgst.getText()));
			tT_add_fess.setSgst(Float.parseFloat(txt_sgst.getText()));
			tT_add_fess.setTotal_in_words(txt_total_word.getText());
			tT_add_fess.setRemark(txt_remark.getText());
			tT_add_fess.setYear1(Integer.parseInt(txt_year1.getText()));
			tT_add_fess.setYear2(Integer.parseInt(txt_year2.getText()));
			add_fess_dao add_dao = new add_fess_dao();
			add_dao.insert(tT_add_fess);
			JOptionPane.showMessageDialog(this, "luu thanh cong");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Luu khong thanh cong ");
			e.printStackTrace();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_search_record = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_edit = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_course_list = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_view_all_record = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_back = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_logout = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txt_GSTIN = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_reclept = new javax.swing.JTextField();
        cbb_payment = new javax.swing.JComboBox<>();
        txt_cheque = new javax.swing.JTextField();
        cbb_course = new javax.swing.JComboBox<>();
        txt_coursename = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        txt_sgst = new javax.swing.JTextField();
        txt_total_amount = new javax.swing.JTextField();
        txt_remark = new javax.swing.JTextField();
        txt_total_word = new javax.swing.JTextField();
        txt_date = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btn_print = new javax.swing.JButton();
        jlb_bankname = new javax.swing.JLabel();
        jlb_cheque_no = new javax.swing.JLabel();
        jlb_ddo = new javax.swing.JLabel();
        txt_bankname = new javax.swing.JTextField();
        txt_rollno = new javax.swing.JTextField();
        txt_DDno = new javax.swing.JTextField();
        txt_year1 = new javax.swing.JTextField();
        txt_student_name = new javax.swing.JTextField();
        txt_recieved_form3 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        btn_home.setBackground(new java.awt.Color(0, 102, 102));
        btn_home.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
        });
        btn_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home.png"))); // NOI18N
        jLabel2.setText("  Home");
        btn_home.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 190, 70));

        btn_search_record.setBackground(new java.awt.Color(0, 102, 102));
        btn_search_record.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_search_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_search_recordMouseClicked(evt);
            }
        });
        btn_search_record.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search2.png"))); // NOI18N
        jLabel3.setText("Search Record");
        btn_search_record.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 200, 70));

        btn_edit.setBackground(new java.awt.Color(0, 102, 102));
        btn_edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });
        btn_edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit2.png"))); // NOI18N
        jLabel4.setText("Edit");
        btn_edit.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 190, 70));

        btn_course_list.setBackground(new java.awt.Color(0, 102, 102));
        btn_course_list.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_course_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_course_listMouseClicked(evt);
            }
        });
        btn_course_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/list_1.png"))); // NOI18N
        jLabel5.setText("Course List");
        btn_course_list.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 190, 70));

        btn_view_all_record.setBackground(new java.awt.Color(0, 102, 102));
        btn_view_all_record.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_view_all_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_view_all_recordMouseClicked(evt);
            }
        });
        btn_view_all_record.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view all record.png"))); // NOI18N
        jLabel6.setText("View All Record");
        btn_view_all_record.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 210, 70));

        btn_back.setBackground(new java.awt.Color(0, 102, 102));
        btn_back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });
        btn_back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left-arrow.png"))); // NOI18N
        jLabel7.setText("Back");
        btn_back.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 190, 70));

        btn_logout.setBackground(new java.awt.Color(0, 102, 102));
        btn_logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
        });
        btn_logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        jLabel8.setText("Logout");
        btn_logout.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 190, 70));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_view_all_record, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_course_list, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search_record, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_search_record, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_course_list, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_view_all_record, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 400, 790));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Student name:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 173, 163, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Reclept no : SOC-");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 28, 163, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Mode of Payment :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 71, 163, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Total in words :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 588, 125, 39));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("The following payment i the college office for the year :");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 399, 28));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Remark :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 671, 138, 40));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 381, 839, 9));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 434, 839, 10));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Date :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 51, -1));

        txt_GSTIN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_GSTIN.setText("27AAATLO123");
        jPanel2.add(txt_GSTIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 163, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Roll No :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 85, 22));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Sr.No");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 397, 67, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Amount (Rs)");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 397, 104, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("SGST 9%");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 95, 30));

        txt_reclept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_recleptActionPerformed(evt);
            }
        });
        jPanel2.add(txt_reclept, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 151, -1));

        cbb_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash\t", "Card" }));
        cbb_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_paymentActionPerformed(evt);
            }
        });
        jPanel2.add(cbb_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 151, -1));
        jPanel2.add(txt_cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 151, -1));

        cbb_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_courseActionPerformed(evt);
            }
        });
        jPanel2.add(cbb_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 344, 161, -1));

        txt_coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursenameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 451, 235, -1));

        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        jPanel2.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 451, 210, -1));
        jPanel2.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 491, 210, -1));
        jPanel2.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 531, 210, -1));
        jPanel2.add(txt_total_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 597, 210, -1));
        jPanel2.add(txt_remark, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 645, 337, 95));
        jPanel2.add(txt_total_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 597, 239, -1));
        jPanel2.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 165, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel22.setText("-");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 23, 34));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 571, 210, 10));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Reciever Signature.");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 662, 155, 17));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 645, 210, 10));

        btn_print.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel2.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 697, 115, 43));

        jlb_bankname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlb_bankname.setText("Bank  name :");
        jPanel2.add(jlb_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 90, -1));

        jlb_cheque_no.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlb_cheque_no.setText("Cheque no:");
        jPanel2.add(jlb_cheque_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jlb_ddo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlb_ddo.setText("DD no:");
        jPanel2.add(jlb_ddo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 60, -1));
        jPanel2.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 290, -1));
        jPanel2.add(txt_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 70, -1));
        jPanel2.add(txt_DDno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 151, -1));
        jPanel2.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 70, -1));
        jPanel2.add(txt_student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 290, -1));
        jPanel2.add(txt_recieved_form3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 290, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("GSTIN: ");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 60, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("CGST  9%");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 95, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Heads");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 397, 95, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Course :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 110, 40));
        jPanel2.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 70, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 890, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void cbb_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_paymentActionPerformed
		// TODO add your handling code here:
		if (cbb_payment.getSelectedItem().equals("DD")) {
			jlb_ddo.setVisible(true);
			jlb_cheque_no.setVisible(false);
			jlb_bankname.setVisible(true);
			txt_DDno.setVisible(true);
			txt_cheque.setVisible(false);
			txt_bankname.setVisible(true);
		}
		if (cbb_payment.getSelectedItem().equals("Cheque")) {
			jlb_ddo.setVisible(false);
			jlb_cheque_no.setVisible(true);
			jlb_bankname.setVisible(true);
			txt_DDno.setVisible(false);
			txt_cheque.setVisible(true);
			txt_bankname.setVisible(true);
		}
		if (cbb_payment.getSelectedItem().equals("Cash	")) {
			jlb_ddo.setVisible(false);
			jlb_cheque_no.setVisible(false);
			jlb_bankname.setVisible(false);

			txt_DDno.setVisible(false);
			txt_cheque.setVisible(false);
			txt_bankname.setVisible(false);
		}
		if (cbb_payment.getSelectedItem().equals("Card")) {
			jlb_ddo.setVisible(false);
			jlb_cheque_no.setVisible(false);
			jlb_bankname.setVisible(true);

			txt_DDno.setVisible(false);
			txt_cheque.setVisible(false);
			txt_bankname.setVisible(true);
		}
        }//GEN-LAST:event_cbb_paymentActionPerformed

        private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
		// TODO add your handling code here:
		if (!validation()) {
			JOptionPane.showMessageDialog(this, "thong tin khong hop le");
		} else {
			save_data_add__fess();
			Print_reciept p = new Print_reciept();
			p.setVisible(true);
			this.dispose();
		}
        }//GEN-LAST:event_btn_printActionPerformed

        private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
		// TODO add your handling code here:
		Float amnt = Float.parseFloat(txt_amount.getText());
		Float cgst = (float) (amnt * 0.09);
		Float sgst = (float) (amnt * 0.09);
		txt_cgst.setText(sgst.toString());
		txt_sgst.setText(sgst.toString());
		float total = amnt + sgst + cgst;
		txt_total_amount.setText(Float.toString(total));
                txt_total_word.setText(number_in_amount.convert((int) total)); 
        }//GEN-LAST:event_txt_amountActionPerformed

        private void cbb_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_courseActionPerformed
		// TODO add your handling code here:
		txt_coursename.setText(cbb_course.getSelectedItem().toString());
        }//GEN-LAST:event_cbb_courseActionPerformed

        private void txt_coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursenameActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_txt_coursenameActionPerformed

        private void txt_recleptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_recleptActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_txt_recleptActionPerformed

        private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked

		home home = new home();
		home.show();
		this.dispose();
        }//GEN-LAST:event_btn_homeMouseClicked

        private void btn_search_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_search_recordMouseClicked
              search_record search = new search_record();
	      search.show();
	      this.dispose();
        }//GEN-LAST:event_btn_search_recordMouseClicked

        private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
 
		update_fess_details update = null;
		try {
			update = new update_fess_details();
		} catch (Exception ex) {
			Logger.getLogger(Add_Fess.class.getName()).log(Level.SEVERE, null, ex);
		}
			update.show();
		this.dispose();
        }//GEN-LAST:event_btn_editMouseClicked

        private void btn_course_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_course_listMouseClicked
                // TODO add your handling code here:
		edit_sourse edit = new edit_sourse();
		edit.show();
		this.dispose();
        }//GEN-LAST:event_btn_course_listMouseClicked

        private void btn_view_all_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_view_all_recordMouseClicked
                // TODO add your handling code here:
		View_ALL_record view = null;
		try {
			view = new View_ALL_record();
		} catch (Exception ex) {
			Logger.getLogger(Add_Fess.class.getName()).log(Level.SEVERE, null, ex);
		}
		view.show();
		this.dispose();
		
        }//GEN-LAST:event_btn_view_all_recordMouseClicked

        private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
                // TODO add your handling code here:
		System.exit(0);
        }//GEN-LAST:event_btn_backMouseClicked

        private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
                // TODO add your handling code here:
		Login_page login = new Login_page();
		login.show();
		this.dispose();
        }//GEN-LAST:event_btn_logoutMouseClicked

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Add_Fess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Add_Fess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Add_Fess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Add_Fess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Add_Fess().setVisible(true);
				} catch (Exception ex) {
					Logger.getLogger(Add_Fess.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_back;
    private javax.swing.JPanel btn_course_list;
    private javax.swing.JPanel btn_edit;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_logout;
    private javax.swing.JButton btn_print;
    private javax.swing.JPanel btn_search_record;
    private javax.swing.JPanel btn_view_all_record;
    private javax.swing.JComboBox<String> cbb_course;
    private javax.swing.JComboBox<String> cbb_payment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel jlb_bankname;
    private javax.swing.JLabel jlb_cheque_no;
    private javax.swing.JLabel jlb_ddo;
    private javax.swing.JTextField txt_DDno;
    private javax.swing.JLabel txt_GSTIN;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque;
    private javax.swing.JTextField txt_coursename;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_recieved_form3;
    private javax.swing.JTextField txt_reclept;
    private javax.swing.JTextField txt_remark;
    private javax.swing.JTextField txt_rollno;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_student_name;
    private javax.swing.JTextField txt_total_amount;
    private javax.swing.JTextField txt_total_word;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    // End of variables declaration//GEN-END:variables

	private int getReciept_no() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
