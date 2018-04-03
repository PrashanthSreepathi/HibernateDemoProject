package com.prashanth.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prashanth.hibernate.demo.entity.Instructor;
import com.prashanth.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

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
			//use session object to save object to database
			//create Objects
//			Instructor tempInstructor = new Instructor("chad","Darby","darby@gmail.com");
//			InstructorDetail tempIntructorDetail=new InstructorDetail("hhtp://www.luv2code.com/youtube","Luv 2 Code");
			
			Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@gmail.com");
			InstructorDetail tempIntructorDetail=new InstructorDetail("hhtp://www.luv2code.com/youtube","Guitar");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempIntructorDetail);
			
			//start Transaction
			session.beginTransaction();
			
			//save the object
			session.save(tempInstructor);
			//this will also save the associated object cause of cascade.ALL
			
			System.out.println("saving instructor: "+tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
