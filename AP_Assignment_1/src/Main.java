import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CoWinPortal coWinPortal = new CoWinPortal();

        boolean toBeContinued = true;

        while (toBeContinued){
            System.out.println("\n--------------------------------------------------------------------------");
            System.out.printf("Menu Option :\n> ");
            String _menuOption = scan.nextLine().trim();
            int menuOption=-1;
            try{
                menuOption = Integer.parseInt(_menuOption);
            }
            catch (Exception error){
                System.out.println("Enter only numeric values");
            }

            if (menuOption==1){
                System.out.printf("Vaccine Name: ");
                String vaccineName = scan.nextLine().trim();
                System.out.printf("Number of Doses: ");
                String numDoses = scan.nextLine().trim();
                int numOfDoses = Integer.parseInt(numDoses);
                int gapBtwDoses;
                if (numOfDoses!=1) {
                    System.out.printf("Gap between Doses: ");
                    String gap = scan.nextLine().trim();
                    gapBtwDoses = Integer.parseInt(gap);
                }
                else {
                    gapBtwDoses = 0;
                }
                coWinPortal.addVaccine(vaccineName, numOfDoses,gapBtwDoses );
            }
            else if (menuOption==2){
                System.out.printf("Hospital Name: ");
                String hospitalName = scan.nextLine().trim();
                System.out.printf("PinCode: ");
                String pinCode  = scan.nextLine().trim();
                coWinPortal.registerHospital(hospitalName, pinCode);
            }
            else if (menuOption==3){
                System.out.printf("Citizen Name: ");
                String name = scan.nextLine().trim();
                System.out.printf("Age: ");
                String _age = scan.nextLine().trim();
                int age = Integer.parseInt(_age);
                System.out.printf("Citizen Unique ID: ");
                String ID = scan.nextLine().trim();
                coWinPortal.registerCitizen(name, age, ID);
            }
            else if (menuOption==4){
                System.out.printf("Enter Hospital ID: ");
                String _ID = scan.nextLine().trim();
                int ID = Integer.parseInt(_ID);
                System.out.printf("Enter number of Slots to be added: ");
                String numSlot = scan.nextLine().trim();
                int numOfSlot = Integer.parseInt(numSlot);
                coWinPortal.addSlotsForHospital(ID, numOfSlot);
            }
            else if (menuOption==5){
                coWinPortal.bookSlot();
            }
            else if (menuOption==6){
                System.out.printf("Enter Hospital ID: ");
                String _ID = scan.nextLine().trim();
                int ID = Integer.parseInt(_ID);
                coWinPortal.listAllSlotsForAHospital(ID);
            }
            else if (menuOption==7){
                System.out.printf("Enter Citizen Unique ID: ");
                String ID = scan.nextLine().trim();
                coWinPortal.checkVaccineStatusOfCitizen(ID);
            }
            else if (menuOption==8){
                toBeContinued=false;
            }
            else{
                System.out.println("Invalid menu option");
            }
        }
    }
}
