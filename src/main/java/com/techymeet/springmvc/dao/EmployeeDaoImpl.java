package com.techymeet.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techymeet.springmvc.vo.EmployeeVo;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
@Autowired
	private SessionFactory sessionfactory;
	
	
	@Override
	public EmployeeVo addEmployee(EmployeeVo employeevo) {
		try {
			Session session=sessionfactory.getCurrentSession();
		int check=	(int) session.save(employeevo);
			if(check!=0) {
				employeevo.setEmpId(check);
				return employeevo;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<EmployeeVo> getAllEmployees() {
		
		try {
			List<EmployeeVo> employeesList=new ArrayList<EmployeeVo>();
			Session session=sessionfactory.getCurrentSession();
			Criteria criteria=session.createCriteria(EmployeeVo.class);
			
		     employeesList=criteria.list();
		    if(null!=employeesList&&employeesList.size()>0&&!employeesList.isEmpty()) {
		    	return employeesList;
		    }
		    }catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public EmployeeVo getEmployeeById(int id) {
		EmployeeVo employeevo=new EmployeeVo();
		try {
		Session session=sessionfactory.getCurrentSession();
		Criteria criteria=session.createCriteria(EmployeeVo.class);
		criteria.add(Restrictions.eq("empId",id));
		employeevo=(EmployeeVo) criteria.uniqueResult();
		if(null!=employeevo) {
			return employeevo;
		}
	   
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		return null;
	}


	@Override
	public EmployeeVo updateEmployee(EmployeeVo employeevo) {
		try {
			Session session=sessionfactory.getCurrentSession();
		 session.update(employeevo);
			if(null!=employeevo) {
				
				return employeevo;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public int deleteEmployeeById(int id) {
		try {
			EmployeeVo employeevo=new EmployeeVo();
			employeevo.setEmpId(id);
		Session session=sessionfactory.getCurrentSession();
	 session.delete(employeevo);
		if(id>0) {
			
			return id;
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return 0;
	}

}
