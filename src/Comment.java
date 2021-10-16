public class Comment {
    String message;
    String uploadedByMember;
    String uploadDate;

    public Comment(String message, String uploadDate, String uploadedByMember){
        this.uploadedByMember = uploadedByMember;
        this.uploadDate = uploadDate;
        this.message = message;
    }
}
