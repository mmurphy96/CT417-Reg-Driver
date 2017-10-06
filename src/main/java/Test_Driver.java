import java.util.ArrayList;
import java.util.Arrays;
//
import org.joda.time.DateTime;

public class Test_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create Student Arrays
		ArrayList<Student> ECEstudents = new ArrayList<Student>();
		ArrayList<Student> ComStudents = new ArrayList<Student>();
		
		//Initiate and add to arrays
		ECEstudents.add(new Student("MichaelMurphy", 21, new DateTime(1996,10,01,10,9,18),11));
		ECEstudents.add(new Student("BoudenBarrett", 28, new DateTime(1989,11,12,8,9,18),11));
		ComStudents.add(new Student("BenSmith", 31, new DateTime(1986,01,05,10,9,45),11));
		ComStudents.add(new Student("SonnyBillWilliams", 26, new DateTime(1990,11,10,18,9,18),11));
		
		//Create new modules
		Module SoftwareEngineering = new Module("SoftwareEngineering", "CT417");
		Module DSP = new Module("DSP","EE445");
		Module SystemOnChip = new Module("System on Chip", "EE451");
		Module Comms = new Module("Comms", "EE443");
		Module DataMining = new Module("Data Mining", "CT475");
		
		Module Economics = new Module("Economics", "CM123");
		Module Accounting = new Module("Accounting", "CM145");
		Module BusinessLaw = new Module("Business Law", "CM001");
		
		//Create Module arrays and add modules
		ArrayList<Module> ECEmodules = new ArrayList<Module>();
		ECEmodules.add(SystemOnChip);
		ECEmodules.add(DSP);	
		ECEmodules.add(SoftwareEngineering);	
		ECEmodules.add(Comms);	
		ECEmodules.add(DataMining);	
		
		ArrayList<Module> CommerceMods = new ArrayList<Module>();
		CommerceMods.add(BusinessLaw);
		CommerceMods.add(Economics);
		CommerceMods.add(Accounting);
		
		//Create Dates for Courses
		DateTime StartDate = new DateTime(2017,9,01,0,0,0);
		DateTime EndDate = new DateTime(2018,9,01,0,0,0);
		
		//Call Methods
		CourseProgramme Engineering = new CourseProgramme("EC Engineering",ECEmodules,StartDate,EndDate);
		CourseProgramme Commerce = new CourseProgramme("Commerce",CommerceMods,StartDate, EndDate);
		
		createCourse(ECEstudents,ECEmodules,Engineering);
		createCourse(ComStudents,CommerceMods,Commerce);
		printStuCourseProg(ECEstudents);
		printStuCourseProg(ComStudents);
			
	}
	
	//Create course method 
    public static void createCourse(ArrayList<Student> students, ArrayList<Module> modules, CourseProgramme course){
    	for (Module module : modules){
    		module.addStudents(students);
    	}
    	for(Student student : students){
    		student.addStutoCourse(course);
    	}
    }
   public static String getModNames(ArrayList<Module> modules){
	  String ModList ="";
	   for (Module module: modules){
		   ModList = ModList + module.getModName() + ",";
	   }
	   return ModList;
   }   
   
   //Print all details methods
   public static void printDetails(Student student) {
        
        System.out.println("\nStudent Details \nName: " +student.getName() +
        "\nAge: " + student.getAge() +
        " \nDate of Birth: " + student.getDOB() +
        " \nID: " + student.getID() +
        " \nUsername: " + student.getUsername());
        }
   public static void printStuCourseProg(ArrayList<Student> students){
	   for(Student student : students){
		   printDetails(student);
		   CourseProgramme course = student.getCourse();
           System.out.println("Course Programme: " + course.getCourseName() +
        		   "\nModules:" + getModNames(course.getModulesList()));
	   }
   }
}