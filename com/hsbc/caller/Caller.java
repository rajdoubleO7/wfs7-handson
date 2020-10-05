/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsbc.caller;

import com.hsbc.Doa.Doa;
import com.hsbc.model.Employee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author surya
 */
public class Caller {
    public static void main(String array[]){
        Doa doa = new Doa();
        Scanner sc = new Scanner(System.in);
        
        doa.store(new Employee(12,"raj",1000000,LocalDate.of(1996, 7, 25)));
        doa.store(new Employee(15,"xyz",1000,LocalDate.of(2000, 9, 26)));
        doa.store(new Employee(9,"abs",100,LocalDate.of(1999, 8, 20)));
        doa.store(new Employee(11,"jhon",10000,LocalDate.of(1995, 7, 26)));
        doa.store(new Employee(55,"rohit",90000,LocalDate.of(1993, 1, 3)));
        doa.store(new Employee(30,"ramesh",99000,LocalDate.of(1994, 8, 10)));
        
        boolean exit = false;
		while(!exit) {
			System.out.println("1. Store");
			System.out.println("2. Sort and Display");
			System.out.println("3. Pick Top 3");
			System.out.println("4. Exit");
			int n = sc.nextInt();
			switch(n) {
			case 1:
                            System.out.println("Enter the employeeId:");
				int id = sc.nextInt();
				System.out.println("Enter the employee name:");
				String name = sc.next();
				
				System.out.println("Enter the employee salary");
				double salary = sc.nextDouble();
				
				System.out.println("Enter the employee birth data(dd/mm/yyyy):");
				String date = sc.next();
				LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				Employee eNew = new Employee(id ,name, salary, localDate);
				doa.store(eNew);			
				
				break;
			case 2:
				System.out.println("Choose type of sort:");
				System.out.println("1. Ascending Order by Id");
				System.out.println("2. Descending Order by Id");
				System.out.println("3. Ascending Order by Name");
				System.out.println("4. Descending Order by Name");
				System.out.println("5. Ascending Order by DOB");
				System.out.println("6. Descending Order by DOB");
				System.out.println("7. Ascending Order by Salary");
				System.out.println("8. Descending Order by Salary");
				int s = sc.nextInt();
                                switch(s){
                                    case 1:
                                        Collections.sort(doa.getList(),(a,b) -> a.getId()-b.getId());
                                        System.out.println("sort by id: \n"+doa.getEmployeeList());
                                        break;
                                    case 2:
                                        Collections.sort(doa.getList(),(a,b) -> b.getId()-a.getId());
                                        System.out.println("sort by id: \n"+doa.getEmployeeList());
                                        break;
                                    case 3:
                                        Collections.sort(doa.getList(),(a,b) -> a.getName().compareTo(b.getName()));
                                        System.out.println("sort by Name: \n"+doa.getEmployeeList());
                                        break;
                                    case 4:
                                        Collections.sort(doa.getList(),(a,b) -> b.getName().compareTo(a.getName()));
                                        System.out.println("sort by Name: \n"+doa.getEmployeeList());
                                        break;
                                    case 5:
                                        Collections.sort(doa.getList(),(a,b) -> a.getDob().compareTo(b.getDob()));
                                        System.out.println("sort by Date of Birth: \n"+doa.getEmployeeList());
                                        break;
                                    case 6:
                                        Collections.sort(doa.getList(),(a,b) -> b.getDob().compareTo(a.getDob()));
                                        System.out.println("sort by Date of Birth: \n"+doa.getEmployeeList());
                                        break;
                                    case 7:
                                        Collections.sort(doa.getEmployeeList(),(a,b) -> (int)(a.getSalary()-b.getSalary()));
                                        System.out.println("sort by Salary: \n"+doa.getEmployeeList());
                                        break;
                                    case 8:
                                        Collections.sort(doa.getEmployeeList(),(a,b) -> (int)(b.getSalary()-a.getSalary()));
                                        System.out.println("sort by Salary: \n"+doa.getEmployeeList());
                                        break;
                                        
                                }
				display(doa.getEmployeeList());			
				
				break;
			case 3:
				display(doa.getEmployeeList());
				break;
			case 4:
				exit = true;
				break;
			default:
				break;
			}
			
		}
	}
        public static void display(List<Employee> list) {
		
		for(Employee emp : list) {
			System.out.println(emp);
            }
        }
}
