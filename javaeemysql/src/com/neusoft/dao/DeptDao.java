package com.neusoft.dao;

import java.util.List;


public interface DeptDao {
void insertDept(Dept dept);
void updateDept(Dept dept);
void deleteDept(int deptno);
List<Dept>  getDepts();
Dept getDeptByDeptno(int deptno);

}
