package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	//HandlerAdapter가 파라미터 자동 맵핑 시 적용할 포맷
	//적용은 했지만... 얘는 출력과 관련이 없음. 
	//통신을 기반으로해서 핸들러 어댑터..
	//단순 출력할때는 영향을 주지 않음. 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	
}
