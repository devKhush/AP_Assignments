import javax.print.attribute.standard.OutputDeviceAssigned;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment implements Assessment{
    private String problemStatement;
    private int maxMarks;
    private boolean isOpen;
    private double grade;
    private boolean submitted;
    private boolean graded;
    private String submission;
    private String gradedBy;
    ArrayList<Student> submittedByStudents;

    public String getProblemStatement() {
        return problemStatement;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public double getGrade() {
        return grade;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public boolean isGraded() {
        return graded;
    }

    public String getSubmission() {
        return submission;
    }

    public String getGradedBy() {
        return gradedBy;
    }

    public ArrayList<Student> getSubmittedByStudents() {
        return submittedByStudents;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }

    public void setGradedBy(String gradedBy) {
        this.gradedBy = gradedBy;
    }

    public Assignment(String problemStatement, int maxMarks){
        this.maxMarks = maxMarks;
        this.problemStatement = problemStatement;
        this.isOpen = true;
        this.graded = false;
        this.submitted = false;
        this.grade = -1.00;
        this.submission = "";
        this.gradedBy = "";
        this.submittedByStudents = new ArrayList<Student>();
    }

    @Override
    public void addAssessment(Course course){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter problem statement: ");
        String problemStatement = scan.nextLine().trim();
        System.out.printf("Enter max marks: ");
        int maxMarks = Integer.parseInt(scan.nextLine().trim());
        Assignment assignment = new Assignment(problemStatement, maxMarks);
        course.getAllAssessments().put(course.getAssessmentCounter(),assignment);
        for (String name : course.getAllStudents().keySet()){
            Student currentStudent = course.getAllStudents().get(name);
            currentStudent.getAllAssessments().put(course.getAssessmentCounter(), new Assignment(problemStatement, maxMarks));
        }
        int currentCounter = course.getAssessmentCounter();
        currentCounter++;
        course.setAssessmentCounter(currentCounter);
    }

    @Override
    public void closeAssessment(Course course,int id){
        Assignment assignmentToBeClosed = (Assignment) course.getAllAssessments().get(id);
        assignmentToBeClosed.isOpen = false;
        for (String studentName: course.getAllStudents().keySet()){
            Student currentStudent = course.getAllStudents().get(studentName);
            assignmentToBeClosed = (Assignment) currentStudent.getAllAssessments().get(id);
            assignmentToBeClosed.isOpen = false;
        }
    }

    @Override
    public void submitAssessment(Student student, int id, Course course){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter filename of assignment submission: ");
        String fileName = scan.nextLine().trim();
        int fileNameLength = fileName.length();
        while(!((fileName.charAt(fileNameLength-1)=='p')&&(fileName.charAt(fileNameLength-2)=='i')&&(fileName.charAt(fileNameLength-3)=='z')&&(fileName.charAt(fileNameLength-4)=='.'))){
            System.out.println("Incorrect file format. Enter correct zip file with extension \".zip\"");
            System.out.printf("Enter filename of assignment submission: ");
            fileName = scan.nextLine().trim();
            fileNameLength = fileName.length();
        }
        Assignment toBeSubmitted = (Assignment) student.getAllAssessments().get(id);
        toBeSubmitted.submitted=true;
        toBeSubmitted.submission = fileName;
        Assignment assignmentOnTheCourse = (Assignment) course.getAllAssessments().get(id);
        assignmentOnTheCourse.submittedByStudents.add(student);
    }

}
