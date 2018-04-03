package com.prashanth.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prashanth.hibernate.demo.entity.Course;
import com.prashanth.hibernate.demo.entity.Instructor;
import com.prashanth.hibernate.demo.entity.InstructorDetail;
import com.prashanth.hibernate.demo.entity.Review;


public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		//session Object
		Session session = factory.getCurrentSession();
		
		try {
			//use session object to save object to database
			//start the session
			session.beginTransaction();
			
			//get the course 
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println(tempCourse);
			
			//delete course
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
