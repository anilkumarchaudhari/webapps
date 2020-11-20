package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class EmployeeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee();
		e1.setEid(1l);
		e1.setEname("ANILKUMAR");
		e1.setEdepartment("IT");
		e1.setEsalary(5000l);
		e1.setJoin_date(new Date());
		insertEmployee(e1);
	}
	public static void insertEmployee(Employee emp) {
		 
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(emp);
            System.out.println("inserted employee: "+emp.getEname());
            transaction.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
    }
}
