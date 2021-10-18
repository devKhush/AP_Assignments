public interface Assessment {
    //    void gradeAssessment();
    void closeAssessment(Course course,int id);
    void addAssessment(Course course);
    void submitAssessment(Student student, int id, Course course);
}
