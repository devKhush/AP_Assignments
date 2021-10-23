import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Student implements CourseMember{
    private String name;
    private int id;
    private Map<Integer, Assessment> allAssessments;

    public Student(String name, int id){
        this.name=name;
        this.id = id;
        this.allAssessments=new LinkedHashMap<>();
    }

    public Map<Integer, Assessment> getAllAssessments() {
        return allAssessments;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    @Override
    public void addComment(Course course){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter comment: ");
        String message = scan.nextLine().trim();
        String dateString = new Date().toString();
        Comment commentToBeAdded = new Comment(message, dateString, this.name);
        course.getAllComments().put(commentToBeAdded.getUploadDate(), commentToBeAdded);
    }

    @Override
    public void viewComments(Course course){
        Comment currentComment;
        for (String str : course.getAllComments().keySet()){
            currentComment = course.getAllComments().get(str);
            System.out.println(currentComment.getMessage()+" - "+currentComment.getUploadedByMember());
            System.out.println(currentComment.getUploadDate());
            System.out.println();
        }
    }

    @Override
    public void logOut(){
        // logged out successfully
    }

    public void studentSubmitAssessment(Course course){
        if (course.getAllAssessments().keySet().isEmpty()){
            System.out.println("No assessments uploaded yet");
            return;
        }
        boolean pendingAssessmentAvailable = false;
        Assessment toBeSubmitted;
        for( int id : this.allAssessments.keySet()){
            toBeSubmitted = this.allAssessments.get(id);
            if (toBeSubmitted instanceof Assignment assignment){
                if ((assignment.isOpen()) && (!assignment.isSubmitted())) {
                    pendingAssessmentAvailable = true;
                }
            }
            else if (toBeSubmitted instanceof Quiz quiz){
                if ((quiz.isOpen()) && (!quiz.isSubmitted())) {
                    pendingAssessmentAvailable = true;
                }
            }
        }
        if (!pendingAssessmentAvailable){
            System.out.println("No pending assessments");
            return;
        }

        System.out.println("Pending assessments :");
        for( int id : this.allAssessments.keySet()){
            toBeSubmitted = this.allAssessments.get(id);
            if (toBeSubmitted instanceof Assignment assignment){
                if ((assignment.isOpen()) && (!assignment.isSubmitted())) {
                    System.out.printf("ID: %d, Assignment: %s, Max Marks: %d \n", id, assignment.getProblemStatement(), assignment.getMaxMarks());
                }
            }
            else if (toBeSubmitted instanceof Quiz quiz){
                if ((quiz.isOpen()) && (!quiz.isSubmitted())) {
                    System.out.printf("ID: %d, Question: %s\n", id, quiz.getQuestion());
                }
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter ID of assessment: ");
        int id = Integer.parseInt(scan.nextLine().trim());
        Assessment assessmentToBeSubmitted =  this.allAssessments.get(id);
        if (assessmentToBeSubmitted instanceof Assignment assignmentToBeClosed){
            new Assignment("XYZ", 0).submitAssessment(this,id, course);
        }
        else if (assessmentToBeSubmitted instanceof Quiz quizToBeClosed){
            new Quiz("XYZ").submitAssessment(this, id, course);
        }
    }

    public void viewGrades(Course course){
        System.out.println("Graded submissions: ");
        Assessment toBeChecked;
        for( int id : this.allAssessments.keySet()){
            toBeChecked = this.allAssessments.get(id);
            if (toBeChecked instanceof Assignment assignment){
                if (assignment.isGraded()) {
                    System.out.println("Submission: "+assignment.getSubmission());
                    System.out.printf("Marks scored: %.2f \n",assignment.getGrade());
                    System.out.println("Graded by: "+assignment.getGradedBy());
                    System.out.println("----------------------------");
                }
            }
            else if (toBeChecked instanceof Quiz quiz){
                if (quiz.isGraded()) {
                    System.out.println("Your answer: "+quiz.getAnswer());
                    System.out.printf("Marks scored: %.2f \n",quiz.getGrade());
                    System.out.println("Graded by: "+quiz.getGradedBy());
                    System.out.println("----------------------------");
                }
            }
        }
        System.out.println();

        System.out.println("UnGraded submissions: ");
        for( int id : this.allAssessments.keySet()){
            toBeChecked = this.allAssessments.get(id);
            if (toBeChecked instanceof Assignment assignment){
                if ((!assignment.isGraded()) && (assignment.isSubmitted())) {
                    System.out.println("Assignment Submission: "+assignment.getSubmission());
                    System.out.println("----------------------------");
                }
            }
            else if (toBeChecked instanceof Quiz quiz){
                if ((!quiz.isGraded()) && (quiz.isSubmitted())) {
                    System.out.println("Quiz Question: "+quiz.getQuestion()+", Answer: "+quiz.getAnswer());
                    System.out.println("----------------------------");
                }
            }
        }
        System.out.println();
    }

    @Override
    public void viewLectureMaterial(Course course){
        new LectureSlides("", 1, "", "", new String[1]).viewLectureMaterials(course);
        new LectureVideo("", "", "", "").viewLectureMaterials(course);
    }
}
