package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("Press 1 for add new Student ");
			System.out.println("Press 2 for display all Students ");
			System.out.println("Press 3 for get Detail of Single Student ");
			System.out.println("Press 4 for delete Student ");
			System.out.println("Press 5 for add Update Student ");
			System.out.println("Press 6 for exit ");
		

		try {
			int input = Integer.parseInt(br.readLine());

			switch (input) {
			case 1:
				System.out.println("--------------------------------------------------");
				System.out.println("Enter user id   :");
				int uId = Integer.parseInt(br.readLine());
				System.out.println("Enter user name :");
				String uName = br.readLine();
				System.out.println("Enter user city : ");
				String uCity = br.readLine();

				Student s = new Student();
				s.setStudentId(uId);
				s.setStudentName(uName);
				s.setStudentCity(uCity);
				int r=studentDao.insert(s);
				System.out.println(r + " Student Added");
				System.out.println("--------------------------------------------------");
				System.out.println();
				break;
			case 2:
				System.out.println("--------------------------------------------------");
				List<Student> allstudents = studentDao.getAllStudent();
				for (Student st : allstudents) {
					System.out.println("ID   : " + st.getStudentId());
					System.out.println("Name : " + st.getStudentName());
					System.out.println("City : " + st.getStudentCity());
				}
				System.out.println("--------------------------------------------------");
				break;
			case 3:

				System.out.println("Enter User Id : ");
				int userId = Integer.parseInt(br.readLine());
				Student student = studentDao.getStudent(userId);
				System.out.println("ID   : " + student.getStudentId());
				System.out.println("Name : " + student.getStudentName());
				System.out.println("City : " + student.getStudentCity());
				System.out.println("--------------------------------------------------");
				break;
			case 4:
				System.out.println("Enter User Id : ");
				int id = Integer.parseInt(br.readLine());
				studentDao.deleteStudent(id);
				System.out.println("Student Deleted !!");
				break;
			case 5:
				break;
			case 6:
				go = false;
				break;
			}

		} catch (Exception e) {
			System.out.println("Invalid Input Try With Another One!!");
			System.out.println(e.getMessage());
		}
		
		
		}
		System.out.println("Thankyou Using My Application !!");
		System.out.println("See you Soon !!");
	}
}
