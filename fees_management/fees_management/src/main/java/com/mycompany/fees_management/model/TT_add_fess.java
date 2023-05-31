/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fees_management.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class TT_add_fess {

	private int reciept_no, year1, year2;
	private float cgst, sgst, amount, total_amount;
	private String student_name, roll_no, payment_mode, cheque_no, bank_name;
	private String dd_no, course_name, gstin, total_in_words, remark;
	private Date date;

	public TT_add_fess(int reciept_no, int year1, int year2, float cgst, float sgst, float amount, float total_amount, String student_name, String roll_no, String payment_mode, String cheque_no, String bank_name, String dd_no, String course_name, String gstin, String total_in_words, String remark, Date date) {
		this.reciept_no = reciept_no;
		this.year1 = year1;
		this.year2 = year2;
		this.cgst = cgst;
		this.sgst = sgst;
		this.amount = amount;
		this.total_amount = total_amount;
		this.student_name = student_name;
		this.roll_no = roll_no;
		this.payment_mode = payment_mode;
		this.cheque_no = cheque_no;
		this.bank_name = bank_name;
		this.dd_no = dd_no;
		this.course_name = course_name;
		this.gstin = gstin;
		this.total_in_words = total_in_words;
		this.remark = remark;
		this.date = date;
	}

	public TT_add_fess() {
	}

	public int getReciept_no() {
		return reciept_no;
	}
	

	

	public void setReciept_no(int reciept_no) {
		this.reciept_no = reciept_no;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getYear1() {
		return year1;
	}

	public void setYear1(int year1) {
		this.year1 = year1;
	}

	public int getYear2() {
		return year2;
	}

	public void setYear2(int year2) {
		this.year2 = year2;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getCheque_no() {
		return cheque_no;
	}

	public void setCheque_no(String cheque_no) {
		this.cheque_no = cheque_no;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getDd_no() {
		return dd_no;
	}

	public void setDd_no(String dd_no) {
		this.dd_no = dd_no;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getTotal_in_words() {
		return total_in_words;
	}

	public void setTotal_in_words(String total_in_words) {
		this.total_in_words = total_in_words;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
