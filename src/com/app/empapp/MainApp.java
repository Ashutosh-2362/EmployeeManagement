package com.app.empapp;


import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Scanner s=new Scanner(System.in);
          while(true) {
        	  System.out.println(" ");
        	  System.out.println("Choose the operation");
        	  System.out.println("1. Display All Records");
        	  System.out.println("2. Insert Records");
        	  System.out.println("3. Delete Records");
        	  System.out.println("4. Search Records");
        	  System.out.println("5. Update records");
        	  System.out.println("6. Exit from Menu");
        	  
        	  System.out.println("Enter your choice");
        	  int choice=s.nextInt();
        	  
        	   if(choice==6)
        		   break;
        	   else {
        		   int id=0;
        		   String name="";
        		   double salary=0.0;
        		    int age=0;
        		   EmployeeDAO ed=new EmployeeDAO();
        		   
        		   switch(choice) {
        		   case 1:  List<Employee> emp=ed.getRecords();
        		             emp.forEach(n->System.out.println(n));
        		          break;
        		   case 2:  System.out.println("Enter your name");
        		            name=s.next();
        		            System.out.println("Enter your salary");
        		            salary=s.nextDouble();
        		            System.out.println("Enter your age");
        		            age=s.nextInt();
        		            boolean b=ed.insertRecord(name,salary,age);
        		            if(b)
        		            	System.out.println("Records inserted successfully");
        		            else
        		            	System.out.println("Records not inserted ");
 		                  break;
        		   case 3:  System.out.println("Delete");
        		            emp=ed.getRecords();
		                    emp.forEach(n->System.out.println(n));
		                    System.out.println("Enter Id which you want to delete");
		                    id=s.nextInt();
		                       b=ed.deleteRecord(id);
		                    if(b)
		                    	System.out.println("Record deleted");
 		                  break;  
        		   case 4:  System.out.println("Search");
        		            System.out.println("Enter the name you want to search");
        		             name=s.next();
        		             
        		             Employee employe= ed.searchRecord(name);
        		             if(employe==null)
        		            	 System.out.println("No record found");
        		             else
        		            	 System.out.println(employe);
 		                  break;   
        		   case 5:   System.out.println("Update");
        			          emp=ed.getRecords();
		                      emp.forEach(n->System.out.println(n));
		                      System.out.println("Enter the name of the student which you want to update");
        			           name=s.next();
        			           employe=ed.searchRecord(name);
        			           
        			           if(employe==null) {
        			        	   System.out.println("No Data Found");
        			           }
        			           else {
        			        	   
        			           
        		            System.out.println("What you want to update");
        		            System.out.println("a. Name ");
        		            System.out.println("b. Salary ");
        		            System.out.println("c. Age ");
        		            char updateChoice=s.next().charAt(0);
 		                    
        		            switch(updateChoice) {
        		            case 'a': System.out.print("Enter New Name");
        		                      name=s.next();
        		                      employe.setName(name);
        		                     break;
        		            case 'b': System.out.print("Update Salary");
        		                      salary=s.nextDouble();
        		                      employe.setSalary(salary);
        		                     break;
        		            case 'c': System.out.print("Update Age");
        		                      age=s.nextInt();
        		                      employe.setAge(age);
        		                     break;
        		            default:  System.out.println("Enter the Choice");
        		            }
        		            b=ed.updateRecord(employe);
        		            if(b)
        		            	System.out.println("records updated sucessfully");
        		           
        			           }
 		                  break;       
 		          default:  System.out.println("Enter the Choice");
    		             
        		   }
        	   }
          }
	}

}

