public class Comment {
    private String message;
    private String uploadedByMember;
    private String uploadDate;

    public Comment(String message, String uploadDate, String uploadedByMember){
        this.uploadedByMember = uploadedByMember;
        this.uploadDate = uploadDate;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getUploadedByMember() {
        return uploadedByMember;
    }

    public String getUploadDate() {
        return uploadDate;
    }
}
