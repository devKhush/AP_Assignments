import java.util.LinkedHashMap;
import java.util.Map;

public class Course {
    private String name;
    private Map<String, LectureSlides> lectureSlides;
    private Map<String, LectureVideo> lectureVideos;
    private Map<String, Student> allStudents;
    private Map<String, Instructor> allInstructors;
    private Map<String, Comment> allComments;
    private Map<Integer, Assessment> allAssessments;
    // Map<Integer, Quiz> allQuizzes;


    public Map<Integer, Assessment> getAllAssessments() {
        return allAssessments;
    }

    public Map<String, Student> getAllStudents() {
        return allStudents;
    }

    public Map<String, Instructor> getAllInstructors() {
        return allInstructors;
    }

    public Map<String, LectureVideo> getLectureVideos() {
        return lectureVideos;
    }

    public Map<String, Comment> getAllComments() {
        return allComments;
    }

    public Map<String, LectureSlides> getLectureSlides() {
        return lectureSlides;
    }

    // helper variables
    private int assessmentCounter;

    public int getAssessmentCounter() {
        return assessmentCounter;
    }

    public void setAssessmentCounter(int assessmentCounter) {
        this.assessmentCounter = assessmentCounter;
    }

    public Course(String name){
        this.name=name;
        lectureSlides = new LinkedHashMap<>();
        lectureVideos = new LinkedHashMap<>();
        allStudents = new LinkedHashMap<>();
        allInstructors = new LinkedHashMap<>();
        allComments = new LinkedHashMap<>();
        assessmentCounter =0;
        allAssessments = new LinkedHashMap<>();
        //allQuizzes = new LinkedHashMap<>();
    }

    public void viewAssessment(){
        Assessment currentAssessment;
        for(int id : this.allAssessments.keySet()){
            currentAssessment = this.allAssessments.get(id);
            if (currentAssessment instanceof Assignment currentAssignment){
                System.out.printf("ID: %d, Assignment: %s, Max Marks: %d \n",id,currentAssignment.getProblemStatement(),currentAssignment.getMaxMarks());
                System.out.println("--------------------");
            }
            else if (currentAssessment instanceof Quiz currentQuiz){
                System.out.printf("ID: %d, Question: %s\n",id,currentQuiz.getQuestion());
                System.out.println("--------------------");
            }
        }
    }
}
