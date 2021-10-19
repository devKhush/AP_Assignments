import java.util.Date;
import java.util.Scanner;

public class LectureSlides implements LectureMaterials{
    private String title;
    private int numOfSlides;
    private String[] content;
    private String dateOfUpload;
    private String uploadedByInstructor;

    public LectureSlides(String title, int numOfSlides, String dateOfUpload, String uploadedByInstructor, String[] content){
        this.title = title;
        this.numOfSlides = numOfSlides;
        this.dateOfUpload = dateOfUpload;
        this.uploadedByInstructor = uploadedByInstructor;
        this.content = content;
    }

    @Override
    public void viewLectureMaterials(Course course){
        LectureSlides currentSlide;
        for (String str: course.lectureSlides.keySet()){
            currentSlide = course.lectureSlides.get(str);
            System.out.println("Title: "+currentSlide.title);
            for (int i=0; i<currentSlide.content.length; i++){
                System.out.printf("Slide %d: %s \n",(i+1), currentSlide.content[i]);
            }
            System.out.println("Number of Slides: "+currentSlide.numOfSlides);
            System.out.println("Date of upload: "+currentSlide.dateOfUpload);
            System.out.println("Uploaded by: "+currentSlide.uploadedByInstructor);
            System.out.println();
        }
    }

    @Override
    public void addLectureMaterial(Course course, Instructor instructor){
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
        LectureSlides newSlide = new LectureSlides(title, slideNum, currentDate, instructor.getName(), slideContent);
        course.lectureSlides.put(currentDate, newSlide);
    }
}
