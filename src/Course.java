import java.util.LinkedHashMap;
import java.util.Map;

public class Course {
    Map<String, LectureSlides> lectureSlides;
    Map<String, LectureVideo> lectureVideos;
    Map<String, Student> allStudents;
    Map<String, Instructor> allInstructors;
    Map<String, Comment> allComments;

    // helper variables

    {
        lectureSlides = new LinkedHashMap<>();
        lectureVideos = new LinkedHashMap<>();
        allStudents = new LinkedHashMap<>();
        allInstructors = new LinkedHashMap<>();
        allComments = new LinkedHashMap<>();
    }
}
