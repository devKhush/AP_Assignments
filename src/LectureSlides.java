public class LectureSlides implements LectureMaterials{
    String title;
    int numOfSlides;
    String[] content;
    String dateOfUpload;
    String uploadedByInstructor;

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
        }
    }
}
