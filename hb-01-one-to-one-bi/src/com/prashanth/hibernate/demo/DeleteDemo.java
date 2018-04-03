package com.prashanth.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prashanth.hibernate.demo.entity.Instructor;
import com.prashanth.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//session Object
		Session session = factory.getCurrentSession();
		
		try {
			//start the session
			session.beginTransaction();
			
			//get instructor bu primary id 
			int theId = 2;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("found instructor: "+tempInstructor);
			
			
			if(tempInstructor!=null) {
				System.out.println("Deleting: "+tempInstructor);
				//Note; will also delete Instructor details object associated with this object
				session.delete(tempInstructor);
			}
			
			
			//commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
