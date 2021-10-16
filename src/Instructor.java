import java.util.Date;
import java.util.Scanner;

public class Instructor implements CourseMember{
    String name;

    public void addComment(Course course, Instructor instructor){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter comment: ");
        String message = scan.nextLine().trim();
        String dateString = new Date().toString();
        Comment commentToBeAdded = new Comment(message, dateString, instructor.name);
        course.allComments.put(commentToBeAdded.uploadDate, commentToBeAdded);
    }

    @Override
    public void viewComments(Course course){
        Comment currentComment;
        for (String str : course.allComments.keySet()){
            currentComment = course.allComments.get(str);
            System.out.println(currentComment.message+" - "+currentComment.uploadedByMember);
            System.out.println(currentComment.uploadDate);
        }
    }

    @Override
    public void logOut(){
    }

    public void addLectureSlides(Course course, Instructor instructor){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter topic of slides: ");
        String title = scan.nextLine().trim();
        System.out.printf("Enter number of slides: ");
        int slideNum = Integer.parseInt(scan.nextLine().trim());
        String[] slideContent = new String[slideNum];
        for(int i=0; i<slideNum; i++){
            System.out.printf("Content of slide %d: ",i+1);
            String contentIth = scan.nextLine().trim();
            slideContent[i] = contentIth;
        }
        Date date = new Date();
        String currentDate = date.toString();
        LectureSlides newSlide = new LectureSlides(title, slideNum, currentDate, instructor.name, slideContent);
        course.lectureSlides.put(currentDate, newSlide);
    }

    public void addLectureVideo(Course course, Instructor instructor){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter topic of video: ");
        String title = scan.nextLine().trim();
        System.out.printf("Enter filename of video: ");
        String fileName = scan.nextLine();
        int fileNameLength = fileName.length();
        while(!((fileName.charAt(fileNameLength-1)=='4')&&(fileName.charAt(fileNameLength-2)=='p')&&(fileName.charAt(fileNameLength-3)=='m')&&(fileName.charAt(fileNameLength-4)=='.'))){
            System.out.println("Incorrect file format.Enter correct video file extension \".mp4\"");
            fileName = scan.nextLine();
            fileNameLength = fileName.length();
        }
        Date date = new Date();
        String currentDate = date.toString();
        LectureVideo newVideo = new LectureVideo(title, currentDate, instructor.name, fileName);
        course.lectureVideos.put(currentDate, newVideo);
    }

}
