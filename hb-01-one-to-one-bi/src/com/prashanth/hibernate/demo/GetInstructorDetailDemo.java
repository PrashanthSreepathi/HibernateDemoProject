package com.prashanth.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prashanth.hibernate.demo.entity.Instructor;
import com.prashanth.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailDemo {

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
			
			// get the instructor detail object
			int id=1;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("Saving object: "+theInstructorDetail);
			
			System.out.println("the associated instructor: "+theInstructorDetail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
