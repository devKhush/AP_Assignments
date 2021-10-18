import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Course AP = new Course("Advanced Programming");
        Scanner scan = new Scanner(System.in);

        Student S0 = new Student("S0", 0);
        Student S1 = new Student("S1", 1);
        Student S2 = new Student("S2", 2);
        Student S3 = new Student("S3", 3);
        Student S4 = new Student("S4", 4);
        AP.allStudents.put("S0",S0);
        AP.allStudents.put("S1",S1);
        AP.allStudents.put("S2",S2);
        AP.allStudents.put("S3",S3);
        AP.allStudents.put("S4",S4);
        Instructor I0 = new Instructor("I0", 0);
        Instructor I1 = new Instructor("I1", 1);
        Instructor I2 = new Instructor("I2", 2);
        AP.allInstructors.put("I0", I0);
        AP.allInstructors.put("I1", I1);
        AP.allInstructors.put("I2", I2);

        Student student;
        Instructor instructor;

        mainWhile:
        while(true){
            System.out.println("\n==========================================================");
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            System.out.printf("> ");
            int option = Integer.parseInt(scan.nextLine().trim());

            if (option==3){
                System.out.println("==========================================================");
                break mainWhile;
            }

            else if (option==1){
                //instructor
                System.out.println("Instructors: ");
                for (String instructorName: AP.allInstructors.keySet()){
                    System.out.println(AP.allInstructors.get(instructorName).id + " - "+instructorName);
                }
                System.out.printf("Choose ID: ");
                int instructorIDChosen = Integer.parseInt(scan.nextLine().trim());
                instructor = AP.allInstructors.get("I"+instructorIDChosen);

                instructorWhile:
                while (true){
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Welcome "+instructor.name);
                    System.out.println("{INSTRUCTOR MENU}");
                    System.out.printf("> ");
                    int optionByInstructor = Integer.parseInt(scan.nextLine().trim());
                    if (optionByInstructor==1){
                        instructor.addLectureMaterials(AP);
                    }
                    else if (optionByInstructor==2){
                        instructor.addAssessmentByInstructor(AP);
                    }
                    else if (optionByInstructor==3){
                        instructor.viewLectureMaterial(AP);
                    }
                    else if (optionByInstructor==4){
                        AP.viewAssessment();
                    }
                    else if (optionByInstructor==5){
                        instructor.instructorGradeAssessment(AP);
                    }
                    else if (optionByInstructor==6){
                        instructor.closeAssessmentByInstructor(AP);
                    }
                    else if(optionByInstructor==7){
                        instructor.viewComments(AP);
                    }
                    else if (optionByInstructor==8){
                        instructor.addComment(AP);
                    }
                    else if (optionByInstructor==9){
                        instructor.logOut();
                        break instructorWhile;
                    }
                }
            }

            else if (option==2){
                //student
                System.out.println("Students: ");
                for (String studentName: AP.allStudents.keySet()){
                    System.out.println(AP.allStudents.get(studentName).id + " - "+studentName);
                }
                System.out.printf("Choose ID: ");
                int studentIDChosen = Integer.parseInt(scan.nextLine().trim());
                student = AP.allStudents.get("S"+studentIDChosen);

                studentWhile:
                while(true){
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Welcome "+student.name);
                    System.out.println("{STUDENT MENU}");
                    System.out.printf("> ");
                    int optionByStudent = Integer.parseInt(scan.nextLine().trim());
                    if (optionByStudent==1){
                        student.viewLectureMaterial(AP);
                    }
                    else if (optionByStudent==2){
                        AP.viewAssessment();
                    }
                    else if (optionByStudent==3){
                        student.studentSubmitAssessment(AP);
                    }
                    else if (optionByStudent==4){
                        student.viewGrades(AP);
                    }
                    else if (optionByStudent==5){
                        student.viewComments(AP);
                    }
                    else if (optionByStudent==6){
                        student.addComment(AP);
                    }
                    else if (optionByStudent==7){
                        student.logOut();
                        break studentWhile;
                    }
                }
            }

        }

    }
}
