package com.neusoft.service;

import java.util.List;

import com.neusoft.dao.Dept;
import com.neusoft.dao.DeptDao;
import com.neusoft.dao.DeptDaoImpl;

public class DeptServiceImpl implements DeptService {

	@Override
	public void insertDept(Dept dept) {
		// TODO Auto-generated method stub
		DeptDao deptDao=new DeptDaoImpl();
		deptDao.insertDept(dept);
	}

	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		DeptDao deptDao=new DeptDaoImpl();
	deptDao.updateDept(dept);
	}

	@Override
	public void deleteDept(int deptno) {
		// TODO Auto-generated method stub
		DeptDao deptDao=new DeptDaoImpl();
		deptDao.deleteDept(deptno);
	}

	@Override
	public List<Dept> getDepts() {
		DeptDao deptDao=new DeptDaoImpl();
		
		return deptDao.getDepts();
	}

	@Override
	public Dept getDeptByDeptno(int deptno) {
		// TODO Auto-generated method stub
		DeptDao deptDao=new DeptDaoImpl();
		return deptDao.getDeptByDeptno(deptno);
	}

	       

}
