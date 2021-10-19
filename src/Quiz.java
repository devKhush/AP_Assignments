import java.util.ArrayList;
import java.util.Scanner;

public class Quiz implements Assessment{
    private String question;
    private int maxMarks;
    private boolean isOpen;
    private double grade;
    private boolean submitted;
    private boolean graded;
    private String answer;
    private String gradedBy;
    ArrayList<Student> submittedByStudents;

    public int getMaxMarks() {
        return maxMarks;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public void setGradedBy(String gradedBy) {
        this.gradedBy = gradedBy;
    }

    public Quiz(String question){
        this.question = question;
        this.maxMarks = 1;
        this.isOpen = true;
        this.graded = false;
        this.submitted = false;
        this.grade = -1.00;
        this.answer = "";
        this.gradedBy = "";
        this.submittedByStudents = new ArrayList<Student>();
    }

    @Override
    public void addAssessment(Course course){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter quiz question: ");
        String quizQuestion = scan.nextLine().trim();
        Quiz quiz = new Quiz(quizQuestion);
        course.getAllAssessments().put(course.getAssessmentCounter(),quiz);
        for (String name : course.getAllStudents().keySet()){
            Student currentStudent = course.getAllStudents().get(name);
            currentStudent.getAllAssessments().put(course.getAssessmentCounter(), new Quiz(quizQuestion));
        }
        int currentCounter = course.getAssessmentCounter();
        currentCounter++;
        course.setAssessmentCounter(currentCounter);
    }

    @Override
    public void closeAssessment(Course course,int id){
        Quiz quizToBeClosed = (Quiz) course.getAllAssessments().get(id);
        quizToBeClosed.isOpen = false;
        for (String studentName: course.getAllStudents().keySet()){
            Student currentStudent = course.getAllStudents().get(studentName);
            quizToBeClosed = (Quiz) currentStudent.getAllAssessments().get(id);
            quizToBeClosed.isOpen = false;
        }
    }

    @Override
    public void submitAssessment(Student student, int id, Course course){
        Scanner scan = new Scanner(System.in);
        Quiz toBeSubmitted = (Quiz) student.getAllAssessments().get(id);
        System.out.printf(toBeSubmitted.question +"? ");
        String solution = scan.nextLine().trim();
        toBeSubmitted.submitted=true;
        toBeSubmitted.answer = solution;
        Quiz quizOnTheCourse = (Quiz) course.getAllAssessments().get(id);
        quizOnTheCourse.submittedByStudents.add(student);
    }
}
