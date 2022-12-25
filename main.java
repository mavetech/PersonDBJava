import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.stream.*;

public class Main
{
	public static void main(String[] args) {
	    
	    int age;
	    String country;
	    ArrayList<Employee> objEmployee = new ArrayList<>();
	    ArrayList<Employee> filteredEmployee = new ArrayList<>();
	    
	    Scanner myObj = new Scanner(System.in); 
        System.out.println("Press 1: Enter Employee Record");
        String number = myObj.nextLine();
        
        while(true){
            
            switch(number){
                case "1": Employee empl = enterRecord();
                          objEmployee.add(empl);
                          System.out.println("Employee data entered successfully!");
                          break;
                case "2": System.out.println("Enter age: ");
                          age = Integer.parseInt(myObj.nextLine());
                          filteredEmployee = filterEmployeesBasedOnAge(objEmployee, age);
                          break;
                case "3": System.out.println("Enter country: ");
                          country = myObj.nextLine();
                          filteredEmployee = filterEmployeesBasedOnCountry(objEmployee, country);
                          break;
                case "4": System.out.println("Enter country: ");
                          country = myObj.nextLine();
                          System.out.println("Enter age: ");
                          age = Integer.parseInt(myObj.nextLine());
                          filteredEmployee = filterEmployeesBasedOnCountryAndAge(objEmployee, country, age);
                          break;
                default: return;
            }
            
            System.out.println();
            System.out.println("---------------------------");
            
            for(Employee emp:filteredEmployee){
                System.out.println(emp.toString());
                System.out.println("---------------------------");
            }
            System.out.println();
            System.out.println("Press 1: Enter Employee Record");
            System.out.println("Press 2: Filter based on age");
            System.out.println("Press 3: Filter based on country");
            System.out.println("Press 4: Filter based on country and age");
            System.out.println("Press anyother key to exit");
            number = myObj.nextLine();
        }

	}
	
	
	static Employee enterRecord(){
	    Scanner myObj = new Scanner(System.in); 
	    System.out.print("Firstname: ");
        String firstname = myObj.nextLine();
        System.out.print("Lastname: ");
        String lastname = myObj.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(myObj.nextLine());
        System.out.print("Please enter Gender from(MALE, FEMALE): ");
        String strGender = myObj.nextLine();
        Gender gender = Gender.valueOf(strGender);
        System.out.print("City: ");
        String city = myObj.nextLine();
        System.out.print("Country: ");
        String country = myObj.nextLine();
        System.out.print("Company: ");
        String company = myObj.nextLine();
        System.out.print("Department: ");
        String department = myObj.nextLine();
        System.out.print("Role: ");
        String role = myObj.nextLine();
        System.out.print("Please enter highest qualification from(Master, Bachelor, PHD): ");
        String strQualification = myObj.nextLine();
        HighestQualification qualification = HighestQualification.valueOf(strQualification);
        
        return new Employee(firstname, lastname, age, gender, city, country, company, role, department, qualification);
		
	}
	
	static ArrayList<Employee> filterEmployeesBasedOnAge(ArrayList<Employee> emp, int age){
	    return new ArrayList<Employee>(
	        emp.stream()
	            .filter(x->(x.getAge()>age))
	            .collect(Collectors.toList())
            );
	}
	
	static ArrayList<Employee> filterEmployeesBasedOnCountry(ArrayList<Employee> emp, String country){
	    return new ArrayList<Employee>(
	        emp.stream()
	        .filter(x->x.getCountry().equals(country))
	        .collect(Collectors.toList())
        );
	    
	    
	}
	
	static ArrayList<Employee> filterEmployeesBasedOnCountryAndAge(ArrayList<Employee> emp, String country, int age){
	   return new ArrayList<Employee>(
	        emp.stream()
	         .filter(x->(x.getAge()>age))
	        .filter(x->x.getCountry().equals(country))
	        .collect(Collectors.toList())
        );
	}
}

enum Gender{
    MALE, FEMALE;
}

class Person{
    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;
    private String city;
    private String country;
    
    Person(String firstname, String lastname, int age, Gender gender, String city, String country){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.country = country;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
        
    public String getLastname(){
        return this.lastname;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public Gender getGender(){
        return this.gender;
    }
        
    public String getCity(){
        return this.city;
    }
    
    public String getCountry(){
        return this.country;
    }
    
    public String toString(){
        return "Firstname: "+this.firstname+"\n"+"Lastname: "+this.lastname+"\n"+"Age: "+this.age+"\n"+"Gender: "+this.gender;
    }
}

enum HighestQualification{
    Master, Bachelor, PHD;
}

class Employee extends Person{
    private String company;
    private String role;
    private String department;
    private HighestQualification qualification;
    
    Employee(String firstname, String lastname, int age, Gender gender, String city, String country, 
                     String company, String role, String department, HighestQualification qualification){
        super(firstname, lastname, age, gender, city, country);
        this.company = company;
        this.role = role;
        this.department = department;
        this.qualification = qualification;
    }
    
    public String toString(){
        return "Firstname: "+this.getFirstname()+"\n"+"Lastname: "+this.getLastname()+"\n"+"Age: "+this.getAge()+"\n"+"Gender: "+this.getGender()+"\n"+"Country: "+this.getCountry()+"\n"+"City: "+this.getCity()+"\n"+"Company: "+this.company+"\n"+"Department: "+this.department+"\n"+"Role: "+this.role+"\n"+"Highest Qualification: "+this.qualification;
    }
}



