package com.yedam.app.emp.service;

import java.util.Date;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//최상위 root com.yedam.app밑에 있어야함.

//@Data Data 생각보다 잘 안씀
//구분해서 만든다?
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	
	
}
