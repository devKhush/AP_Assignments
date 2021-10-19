import java.util.LinkedHashMap;
import java.util.Map;

public class Course {
    private String name;
    Map<String, LectureSlides> lectureSlides;
    Map<String, LectureVideo> lectureVideos;
    Map<String, Student> allStudents;
    Map<String, Instructor> allInstructors;
    Map<String, Comment> allComments;
    Map<Integer, Assessment> allAssessments;
    // Map<Integer, Quiz> allQuizzes;

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
