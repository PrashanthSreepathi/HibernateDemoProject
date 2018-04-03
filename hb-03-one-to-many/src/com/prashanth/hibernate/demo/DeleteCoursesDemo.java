package com.prashanth.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prashanth.hibernate.demo.entity.Course;
import com.prashanth.hibernate.demo.entity.Instructor;
import com.prashanth.hibernate.demo.entity.InstructorDetail;


public class DeleteCoursesDemo {

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
			
			
			// start the transaction
			session.beginTransaction();
			
			//get the instructor from db
			int theId =10;
			Course tempCourse = session.get(Course.class, theId);
			
			//delete course
			System.out.println("Deleting the Course: "+tempCourse);
			
			session.delete(tempCourse);
			
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
