import java.util.Date;
import java.util.Scanner;

public class Student implements CourseMember{
    String name;
    int id;

    public void addComment(Course course, Student student){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter comment: ");
        String message = scan.nextLine().trim();
        String dateString = new Date().toString();
        Comment commentToBeAdded = new Comment(message, dateString, student.name);
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
}
