import java.util.Date;
import java.util.Scanner;

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
            System.out.println();
        }
    }

    @Override
    public void addLectureMaterial(Course course, Instructor instructor){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter topic of video: ");
        String title = scan.nextLine().trim();
        System.out.printf("Enter filename of video: ");
        String fileName = scan.nextLine().trim();
        int fileNameLength = fileName.length();
        while(!((fileName.charAt(fileNameLength-1)=='4')&&(fileName.charAt(fileNameLength-2)=='p')&&(fileName.charAt(fileNameLength-3)=='m')&&(fileName.charAt(fileNameLength-4)=='.'))){
            System.out.println("Incorrect file format. Enter correct video file with extension \".mp4\"");
            System.out.printf("Enter filename of video: ");
            fileName = scan.nextLine().trim();
            fileNameLength = fileName.length();
        }
        Date date = new Date();
        String currentDate = date.toString();
        LectureVideo newVideo = new LectureVideo(title, currentDate, instructor.name, fileName);
        course.lectureVideos.put(currentDate, newVideo);
    }
}
