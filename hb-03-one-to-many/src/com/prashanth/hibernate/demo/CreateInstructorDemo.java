package com.prashanth.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prashanth.hibernate.demo.entity.Course;
import com.prashanth.hibernate.demo.entity.Instructor;
import com.prashanth.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		//session Object
		Session session = factory.getCurrentSession();
		
		try {
			//use session object to save object to database
			
			Instructor tempInstructor = new Instructor("Susan","Public","susan.public@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Vide");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
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
