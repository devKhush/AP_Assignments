public interface CourseMember {
    public String getName();
    public void viewLectureMaterial(Course course);
    public void viewComments(Course course);
    public void addComment(Course course);
    void logOut();
}
