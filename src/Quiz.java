import java.util.Scanner;

public class Quiz implements Assessment{
    String question;
    int maxMarks;
    boolean isOpen;
    double grade;
    boolean submitted;
    boolean graded;
    String answer;
    String gradedBy;

    public Quiz(String question){
        this.question = question;
        this.maxMarks = 1;
        this.isOpen = true;
        this.graded = false;
        this.submitted = false;
        this.grade = -1.00;
        this.answer = "";
        this.gradedBy = "";
    }

    @Override
    public void addAssessment(Course course){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter problem statement: ");
        String quizQuestion = scan.nextLine().trim();
        Quiz quiz = new Quiz(quizQuestion);
        course.allAssessments.put(course.assessmentCounter,quiz);
        for (String name : course.allStudents.keySet()){
            Student currentStudent = course.allStudents.get(name);
            currentStudent.allAssessments.put(course.assessmentCounter, new Quiz(quizQuestion));
        }
        course.assessmentCounter++;
    }

    @Override
    public void closeAssessment(Course course,int id){
        Quiz quizToBeClosed = (Quiz) course.allAssessments.get(id);
        quizToBeClosed.isOpen = false;
        for (String studentName: course.allStudents.keySet()){
            Student currentStudent = course.allStudents.get(studentName);
            quizToBeClosed = (Quiz) currentStudent.allAssessments.get(id);
            quizToBeClosed.isOpen = false;
        }
    }

    @Override
    public void submitAssessment(Student student, int id){
        Scanner scan = new Scanner(System.in);
        Quiz toBeSubmitted = (Quiz) student.allAssessments.get(id);
        System.out.printf(toBeSubmitted.question +"? ");
        String solution = scan.nextLine().trim();
        toBeSubmitted.submitted=true;
        toBeSubmitted.answer = solution;
    }
}
