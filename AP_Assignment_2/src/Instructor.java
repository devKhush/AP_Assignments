import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Instructor implements CourseMember{
    private int id;
    private String name;

    public Instructor(String name, int id){
        this.name=name;
        this.id = id;
    }

    public String getName(){
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
        if (course.getAllAssessments().keySet().isEmpty()){
            System.out.println("No assessments uploaded yet");
            return;
        }

        Assessment currentAssessment;
        System.out.println("List of Open Assessments: ");
        for(int id : course.getAllAssessments().keySet()){
            currentAssessment = course.getAllAssessments().get(id);
            if (currentAssessment instanceof Assignment currentAssignment){
                if (currentAssignment.isOpen()) {
                    System.out.printf("ID: %d, Assignment: %s, Max Marks: %d \n", id, currentAssignment.getProblemStatement(), currentAssignment.getMaxMarks());
                    System.out.println("--------------------");
                }
            }
            else if (currentAssessment instanceof Quiz currentQuiz){
                if (currentQuiz.isOpen()) {
                    System.out.printf("ID: %d, Question: %s\n", id, currentQuiz.getQuestion());
                    System.out.println("--------------------");
                }
            }
        }
        System.out.printf("Enter id of assessment to close: ");
        int id = Integer.parseInt(scan.nextLine().trim());
        Assessment assessmentToBeClosed =  course.getAllAssessments().get(id);
        if (assessmentToBeClosed instanceof Assignment assignmentToBeClosed){
            new Assignment("XYZ", 0).closeAssessment(course,id);
        }
        else if (assessmentToBeClosed instanceof Quiz quizToBeClosed){
            new Quiz("XYZ").closeAssessment(course, id);
        }
    }

    public void instructorGradeAssessment(Course course) {
        Scanner scan = new Scanner(System.in);
        if (course.getAllAssessments().keySet().isEmpty()){
            System.out.println("No assessments uploaded yet");
            return;
        }

        System.out.println("List of assessments: ");
        course.viewAssessment();
        System.out.printf("Enter ID of assessment to grade submissions: ");
        int assessmentID = Integer.parseInt(scan.nextLine().trim());
        Assessment assessmentToBeGraded = course.getAllAssessments().get(assessmentID);
        if (assessmentToBeGraded instanceof Assignment assignmentToBeGraded) {
            if (assignmentToBeGraded.submittedByStudents.isEmpty()){
                System.out.println("Either No submissions yet OR all submissions graded");
                return;
            }
        } else if (assessmentToBeGraded instanceof Quiz quizToBeGraded) {
            if (quizToBeGraded.submittedByStudents.isEmpty()){
                System.out.println("Either No submissions yet OR all submissions graded");
                return;
            }
        }


        System.out.println("Choose student IDs from these ungraded submissions");
        if (assessmentToBeGraded instanceof Assignment assignmentToBeGraded) {
            for (Student studentSubmitted : assignmentToBeGraded.submittedByStudents) {
                Student currentStudent = course.getAllStudents().get(studentSubmitted.getName());
                Assignment toBeGraded = (Assignment) currentStudent.getAllAssessments().get(assessmentID);
                if (!toBeGraded.isGraded()) {
                    System.out.println(studentSubmitted.getId() + ". " + studentSubmitted.getName());
                }
            }
        }
        else if (assessmentToBeGraded instanceof Quiz quizToBeGraded) {
            for (Student studentSubmitted : quizToBeGraded.submittedByStudents) {
                Student currentStudent = course.getAllStudents().get(studentSubmitted.getName());
                Quiz toBeGraded = (Quiz) currentStudent.getAllAssessments().get(assessmentID);
                if (!toBeGraded.isGraded()) {
                    System.out.println(studentSubmitted.getId() + ". " + studentSubmitted.getName());
                }
            }
        }
        System.out.printf("> ");
        int studentID = Integer.parseInt(scan.nextLine().trim());
        Student studentWhoseAssessmentToBeGraded = course.getAllStudents().get("S" + studentID);
        assessmentToBeGraded = studentWhoseAssessmentToBeGraded.getAllAssessments().get(assessmentID);
        if (assessmentToBeGraded instanceof Assignment assignmentToBeGraded) {
            System.out.println("Submission: " + assignmentToBeGraded.getSubmission());
            System.out.println("-------------------------------");
            System.out.println("Marks marks: " + assignmentToBeGraded.getMaxMarks());
            System.out.printf("Marks scored: ");
            double grade = Double.parseDouble(scan.nextLine().trim());
            assignmentToBeGraded.setGrade(grade); //= grade;
            assignmentToBeGraded.setGraded(true); // = true;
            assignmentToBeGraded.setGradedBy(this.name); // = this.name;
            Assignment assignmentGradedInCourseClass = (Assignment) course.getAllAssessments().get(assessmentID);
            assignmentGradedInCourseClass.submittedByStudents.remove(studentWhoseAssessmentToBeGraded);
        }
        else if (assessmentToBeGraded instanceof Quiz quizToBeGraded) {
            System.out.println("Answer submitted: " + quizToBeGraded.getAnswer());
            System.out.println("-------------------------------");
            System.out.println("Marks marks: " + quizToBeGraded.getMaxMarks());
            System.out.printf("Marks scored: ");
            double grade = Double.parseDouble(scan.nextLine().trim());
            quizToBeGraded.setGrade(grade); // = grade;
            quizToBeGraded.setGraded(true); // = true;
            quizToBeGraded.setGradedBy(this.name); // = this.name;
            Quiz quizGradedInCourseClass = (Quiz)course.getAllAssessments().get(assessmentID);
            quizGradedInCourseClass.submittedByStudents.remove(studentWhoseAssessmentToBeGraded);
        }
    }

    @Override
    public void viewLectureMaterial(Course course){
        new LectureSlides("", 1, "", "", new String[1]).viewLectureMaterials(course);
        new LectureVideo("", "", "", "").viewLectureMaterials(course);
    }

}
