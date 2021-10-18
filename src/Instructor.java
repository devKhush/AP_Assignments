import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Instructor implements CourseMember{
    int id;
    String name;

    public Instructor(String name, int id){
        this.name=name;
        this.id = id;
    }

    @Override
    public void addComment(Course course){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter comment: ");
        String message = scan.nextLine().trim();
        String dateString = new Date().toString();
        Comment commentToBeAdded = new Comment(message, dateString, this.name);
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
        //logged out successfully
    }

    public void addLectureMaterials(Course course){
        Scanner scan = new Scanner(System.in);
        System.out.println(("1. Add Lecture Slide\n" +
                "2. Add Lecture Video"));
        int option = Integer.parseInt(scan.nextLine().trim());
        if (option==1){
            LectureSlides dummy = new LectureSlides("", 0, "", "", new String[1]);
            dummy.addLectureMaterial(course, this);
        }
        else if (option==2){
            LectureVideo dummy = new LectureVideo("", "", "", "");
            dummy.addLectureMaterial(course, this);
        }
    }

    public void addAssessmentByInstructor(Course course){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Add Assignment");
        System.out.println("2. Add Quiz");
        int option = Integer.parseInt(scan.nextLine().trim());
        if (option==1){
            Assignment dummy = new Assignment("XYZ", 0);
            dummy.addAssessment(course);
        }
        else if (option==2){
            Quiz dummy = new Quiz("XYZ");
            dummy.addAssessment(course);
        }
    }

    public void closeAssessmentByInstructor(Course course){
        Scanner scan = new Scanner(System.in);
        Assessment currentAssessment;
        System.out.println("List of Open Assessments: ");
        for(int id : course.allAssessments.keySet()){
            currentAssessment = course.allAssessments.get(id);
            if (currentAssessment instanceof Assignment currentAssignment){
                if (currentAssignment.isOpen) {
                    System.out.printf("ID: %d, Assignment: %s, Max Marks: %d \n", id, currentAssignment.problemStatement, currentAssignment.maxMarks);
                    System.out.println("--------------------");
                }
            }
            else if (currentAssessment instanceof Quiz currentQuiz){
                if (currentQuiz.isOpen) {
                    System.out.printf("ID: %d, Question: %s\n", id, currentQuiz.question);
                    System.out.println("--------------------");
                }
            }
        }
        System.out.printf("Enter id of assessment to close: ");
        int id = Integer.parseInt(scan.nextLine().trim());
        Assessment assessmentToBeClosed =  course.allAssessments.get(id);
        if (assessmentToBeClosed instanceof Assignment assignmentToBeClosed){
            new Assignment("XYZ", 0).closeAssessment(course,id);
        }
        else if (assessmentToBeClosed instanceof Quiz quizToBeClosed){
            new Quiz("XYZ").closeAssessment(course, id);
        }
    }

    public void instructorGradeAssessment(Course course) {
        Scanner scan = new Scanner(System.in);

        System.out.println("List of assessments: ");
        course.viewAssessment();
        System.out.printf("Enter ID of assessment to grade submissions: ");
        int assessmentID = Integer.parseInt(scan.nextLine().trim());
        System.out.println("Choose ID from these ungraded submissions");
        Assessment assessmentToBeGraded = course.allAssessments.get(assessmentID);
        if (assessmentToBeGraded instanceof Assignment assignmentToBeGraded) {
            for (Student studentSubmitted : assignmentToBeGraded.submittedByStudents) {
                System.out.println(studentSubmitted.id + ". " + studentSubmitted.name);
            }
        } else if (assessmentToBeGraded instanceof Quiz quizToBeGraded) {
            for (Student studentSubmitted : quizToBeGraded.submittedByStudents) {
                System.out.println(studentSubmitted.id + ". " + studentSubmitted.name);
            }
        }
        System.out.printf("> ");
        int studentID = Integer.parseInt(scan.nextLine().trim());
        Student studentWhoseAssessmentToBeGraded = course.allStudents.get("S" + studentID);
        assessmentToBeGraded = studentWhoseAssessmentToBeGraded.allAssessments.get(assessmentID);
        if (assessmentToBeGraded instanceof Assignment assignmentToBeGraded) {
            System.out.println("Submission: " + assignmentToBeGraded.submission);
            System.out.println("-------------------------------");
            System.out.println("Marks marks: " + assignmentToBeGraded.maxMarks);
            System.out.printf("Marks scored: ");
            double grade = Double.parseDouble(scan.nextLine().trim());
            assignmentToBeGraded.grade = grade;
            assignmentToBeGraded.graded = true;
            assignmentToBeGraded.gradedBy = this.name;
        }
        if (assessmentToBeGraded instanceof Quiz quizToBeGraded) {
            System.out.println("Answer submitted: " + quizToBeGraded.answer);
            System.out.println("-------------------------------");
            System.out.println("Marks marks: " + quizToBeGraded.maxMarks);
            System.out.printf("Marks scored: ");
            double grade = Double.parseDouble(scan.nextLine().trim());
            quizToBeGraded.grade = grade;
            quizToBeGraded.graded = true;
            quizToBeGraded.gradedBy = this.name;
        }
    }

    @Override
    public void viewLectureMaterial(Course course){
        new LectureSlides("", 1, "", "", new String[1]).viewLectureMaterials(course);
        new LectureVideo("", "", "", "").viewLectureMaterials(course);
    }

}
