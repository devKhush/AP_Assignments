public class Comment {
    private String message;
    private CourseMember uploadedByMember;
    private String uploadDate;

    public Comment(String message, String uploadDate, CourseMember uploadedByMember){
        this.uploadedByMember = uploadedByMember;
        this.uploadDate = uploadDate;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getUploadedByMember() {
        return uploadedByMember.getName();
    }

    public String getUploadDate() {
        return uploadDate;
    }
}
