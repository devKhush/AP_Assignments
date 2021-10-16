public class LectureVideo implements LectureMaterials{
    String title;
    String videoFileName;
    String dateOfUpload;
    String uploadedByInstructor;

    public LectureVideo(String title,  String dateOfUpload, String uploadedByInstructor, String videoFileName){
        this.title = title;
        this.dateOfUpload = dateOfUpload;
        this.uploadedByInstructor = uploadedByInstructor;
        this.videoFileName = videoFileName;
    }

    @Override
    public void viewLectureMaterials(Course course){
        LectureVideo currentVideo;
        for (String str: course.lectureVideos.keySet()){
            currentVideo = course.lectureVideos.get(str);
            System.out.println("Title: "+currentVideo.title);
            System.out.println("Video file: "+currentVideo.videoFileName);
            System.out.println("Date of upload: "+currentVideo.dateOfUpload);
            System.out.println("Uploaded by: "+currentVideo.uploadedByInstructor);
        }
    }

    public void addLectureMaterials(Course course){

    }
}
