import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Student implements CourseMember{
    String name;
    int id;
    Map<Integer, Assessment> allAssessments;

    public Student(String name, int id){
        this.name=name;
        this.id = id;
        this.allAssessments=new LinkedHashMap<>();
    }

    @Override
    public void addComment(Course course, CourseMember student){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter comment: ");
        String message = scan.nextLine().trim();
        String dateString = new Date().toString();
        Comment commentToBeAdded = new Comment(message, dateString, ((Student)student).name);
        course.allComments.put(commentToBeAdded.uploadDate, commentToBeAdded);
    }

    @Override
    public void viewComments(Course course){
        Comment currentComment;
        for (String str : course.allComments.keySet()){
            currentComment = course.allComments.get(str);
            System.out.println(currentComment.message+" - "+currentComment.uploadedByMember);
            System.out.println(currentComment.uploadDate);
        }
    }

    @Override
    public void logOut(){

    }

    public void studentSubmitAssessment(Course course){
        System.out.println("Pending assessments :");
        Assessment toBeSubmitted;
        for( int id : this.allAssessments.keySet()){
            toBeSubmitted = this.allAssessments.get(id);
            if (toBeSubmitted instanceof Assignment assignment){
                if ((assignment.isOpen) && (!assignment.submitted)) {
                    System.out.printf("ID: %d, Assignment: %s, Max Marks: %d \n", id, assignment.problemStatement, assignment.maxMarks);
                }
            }
            else if (toBeSubmitted instanceof Quiz quiz){
                if ((quiz.isOpen) && (!quiz.submitted)) {
                    System.out.printf("ID: %d, Question: %s\n", id, quiz.question);
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
                if (assignment.graded) {
                    System.out.println("Submission: "+assignment.submission);
                    System.out.printf("Marks scored: %.2f \n",assignment.grade);
                    System.out.println("Graded by: ");
                    System.out.println("----------------------------");
                }
            }
            else if (toBeChecked instanceof Quiz quiz){
                if (quiz.graded) {
                    System.out.println("Your answer: "+quiz.answer);
                    System.out.printf("Marks scored: %.2f \n",quiz.grade);
                    System.out.println("Graded by: ");
                    System.out.println("----------------------------");
                }
            }
        }

        System.out.println("UnGraded submissions: ");
        for( int id : this.allAssessments.keySet()){
            toBeChecked = this.allAssessments.get(id);
            if (toBeChecked instanceof Assignment assignment){
                if ((!assignment.graded) && (assignment.submitted)) {
                    System.out.println("Assignment Problem Statement: "+assignment.problemStatement);
                    System.out.println("----------------------------");
                }
            }
            else if (toBeChecked instanceof Quiz quiz){
                if ((!quiz.graded) && (quiz.submitted)) {
                    System.out.println("Question: "+quiz.question);
                    System.out.println("----------------------------");
                }
            }
        }
    }
}
