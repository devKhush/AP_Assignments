public interface Assessment {
    void closeAssessment(Course course,int id);
    void addAssessment(Course course);
    void submitAssessment(Student student, int id, Course course);
}
