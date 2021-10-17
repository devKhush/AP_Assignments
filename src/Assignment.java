import javax.print.attribute.standard.OutputDeviceAssigned;
import java.util.Scanner;

public class Assignment implements Assessment{
    String problemStatement;
    int maxMarks;
    boolean isOpen;
    double grade;
    boolean submitted;
    boolean graded;
    String submission;
    String gradedBy;

    public Assignment(String problemStatement, int maxMarks){
        this.maxMarks = maxMarks;
        this.problemStatement = problemStatement;
        this.isOpen = true;
        this.graded = false;
        this.submitted = false;
        this.grade = -1.00;
        this.submission = "";
        this.gradedBy = "";
    }

    @Override
    public void addAssessment(Course course){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter problem statement: ");
        String problemStatement = scan.nextLine().trim();
        System.out.printf("Enter max marks: ");
        int maxMarks = Integer.parseInt(scan.nextLine().trim());
        Assignment assignment = new Assignment(problemStatement, maxMarks);
        course.allAssessments.put(course.assessmentCounter,assignment);
        for (String name : course.allStudents.keySet()){
            Student currentStudent = course.allStudents.get(name);
            currentStudent.allAssessments.put(course.assessmentCounter, new Assignment(problemStatement, maxMarks));
        }
        course.assessmentCounter++;
    }

    @Override
    public void closeAssessment(Course course,int id){
        Assignment assignmentToBeClosed = (Assignment) course.allAssessments.get(id);
        assignmentToBeClosed.isOpen = false;
        for (String studentName: course.allStudents.keySet()){
            Student currentStudent = course.allStudents.get(studentName);
            assignmentToBeClosed = (Assignment) currentStudent.allAssessments.get(id);
            assignmentToBeClosed.isOpen = false;
        }
    }

    @Override
    public void submitAssessment(Student student, int id){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter filename of assignment: ");
        String fileName = scan.nextLine().trim();
        int fileNameLength = fileName.length();
        while(!((fileName.charAt(fileNameLength-1)=='p')&&(fileName.charAt(fileNameLength-2)=='i')&&(fileName.charAt(fileNameLength-3)=='z')&&(fileName.charAt(fileNameLength-4)=='.'))){
            System.out.println("Incorrect file format.Enter correct zip file with extension \".zip\"");
            fileName = scan.nextLine();
            fileNameLength = fileName.length();
        }
        Assignment toBeSubmitted = (Assignment) student.allAssessments.get(id);
        toBeSubmitted.submitted=true;
        toBeSubmitted.submission = fileName;
    }

}
