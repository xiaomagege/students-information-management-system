package com.neusoft.service;

import java.util.List;

import com.neusoft.dao.Dept;

public interface DeptService {
	void insertDept(Dept dept);
	void updateDept(Dept dept);
	void deleteDept(int deptno);
	List<Dept>  getDepts();
	Dept getDeptByDeptno(int deptno);
}
