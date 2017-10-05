import java.util.ArrayList;
import java.util.Arrays;
//
import org.joda.time.DateTime;

public class Test_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> ECEstudents = new ArrayList<Student>();

		for(int i=0; i<10; i++){
			Student ECElist = new Student("Michael Murphy", 21, new DateTime(1996,10,01,10,9,18),11);
			ECEstudents.add(ECElist);
		}
		Module SoftwareEngineering = new Module("SoftwareEngineering", "CT417");
		Module DSP = new Module("DSP","EE445");
		Module SystemOnChip = new Module("System on Chip", "EE451");
		Module Comms = new Module("Comms", "EE443");
		Module DataMining = new Module("Data Mining", "CT475");
		
		ArrayList<Module> ECEmodules = new ArrayList<Module>();
		ECEmodules.add(SystemOnChip);
		ECEmodules.add(DSP);	
		ECEmodules.add(SoftwareEngineering);	
		ECEmodules.add(Comms);	
		ECEmodules.add(DataMining);	
		
		DateTime StartDate = new DateTime(2017,9,01,0,0,0);
		DateTime EndDate = new DateTime(2018,9,01,0,0,0);
		CourseProgramme Engineering = new CourseProgramme("EC Engineering",ECEmodules,StartDate,EndDate);
		
		createCourse(ECEstudents,ECEmodules,Engineering);
		printStuCourseProg(ECEstudents);
			
	}
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
   public static void printDetails(Student student) {
        
        System.out.println("Student Name: " + student.getName()); 
        System.out.println("Age: " + student.getAge());
        System.out.println("Date of Birth: " + student.getDOB());
        System.out.println("ID: " + student.getID());
        System.out.println("Username: " + student.getUsername());
        }
   public static void printStuCourseProg(ArrayList<Student> students){
	   for(Student student : students){
		   printDetails(student);
		   CourseProgramme course = student.getCourse();
           System.out.println("Course Programme: " + course.getCourseName());
           System.out.println("Modules:" + getModNames(course.getModulesList()));
           System.out.println();
	   }
   }
}