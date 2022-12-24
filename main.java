import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
		Employee employee1 = new Employee("John", "Smith", 28, Gender.MALE, "NY", "USA", "Google", "Developer", "Development", HighestQualification.Master);
		Employee employee2 = new Employee("Alex", "Jones", 25, Gender.MALE, "Toronto", "Canada", "Amazon", "Developer", "Development", HighestQualification.Bachelor);
		
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(employee1);
		emp.add(employee2);
		
		ArrayList<Employee> newFilteredEmployees = filterEmployeesBasedOnAge(emp);
		
		for(Employee filteredEmployee : newFilteredEmployees) {
		        System.out.println(filteredEmployee.toString());     
		}
		
		System.out.println();
		
		ArrayList<Employee> newFilteredEmployees2 = filterEmployeesBasedOnCountry(emp);
		
		for(Employee filteredEmployee : newFilteredEmployees2) {
		        System.out.println(filteredEmployee.toString());     
		}

	}
	
	static ArrayList<Employee> filterEmployeesBasedOnAge(ArrayList<Employee> emp){
	    ArrayList<Employee> filteredEmployee = new ArrayList<>();
	    int counter = 0;
	    for(Employee employee: emp){
	        if(employee.getAge()>25){
	            filteredEmployee.add(employee);
	        }
	    }
	    return filteredEmployee;
	}
	
	static ArrayList<Employee> filterEmployeesBasedOnCountry(ArrayList<Employee> emp){
	    ArrayList<Employee> filteredEmployee = new ArrayList<>();
	    int counter = 0;
	    for(Employee employee: emp){
	        if(employee.getCountry()=="Canada"){
	            filteredEmployee.add(employee);
	        }
	    }
	    return filteredEmployee;
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
