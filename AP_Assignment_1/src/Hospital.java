import java.util.*;

public class Hospital {
    final String name;
    final String pinCode;
    final int uniqueID;
    static private int ID = 100000;
    Map<Integer, Slot> allSlots = new LinkedHashMap<>();
    private int slotCounter = 0;

    {
        ID++;
    }
    public Hospital(String name, String pinCode){
        this.name=name;
        this.pinCode=pinCode;
        this.uniqueID=ID;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void createSlots(int uniqueID, int numOfSlots, CoWinPortal portal){
        Hospital thatHospital = portal.allRegisteredHospitals.get(uniqueID);
        Scanner scan = new Scanner(System.in);
        Slot slot;
        if (portal.allVaccineCodes.keySet().isEmpty()){
            System.out.println("No vaccine available");
            return;
        }
        for(int i=1; i<=numOfSlots; i++){

            System.out.printf("Enter Day Number: ");
            String _dayNumber = scan.nextLine().trim();
            int dayNumber = Integer.parseInt(_dayNumber);
            if (dayNumber<0){
                System.out.println("Day number should be positive. Try again");
                return;
            }

            System.out.printf("Enter Quantity: ");
            String _quantity = scan.nextLine().trim();
            int quantity = Integer.parseInt(_quantity);
            if (quantity<0){
                System.out.println("Quantity should be positive. Try again");
                return;
            }

            System.out.println("Select Vaccine: ");
            for (int vaccineCode: portal.allVaccineCodes.keySet())
                System.out.println(vaccineCode+". "+portal.allVaccineCodes.get(vaccineCode));
            System.out.printf("Choose Vaccine: ");
            String _codeOfVaccineEntered = scan.nextLine().trim();
            int codeOfVaccineEntered = Integer.parseInt(_codeOfVaccineEntered);
            if (portal.allVaccineCodes.get(codeOfVaccineEntered)==null){
                System.out.println("Invalid Vaccine chosen. Try again");
                return;
            }

            String vaccineName = portal.allVaccineCodes.get(codeOfVaccineEntered);
            slot = new Slot(vaccineName, quantity, dayNumber);
            thatHospital.allSlots.put(thatHospital.slotCounter, slot);
            thatHospital.slotCounter++;
            System.out.println("Slot added by Hospital "+thatHospital.uniqueID+" for Day: "+slot.dayOfSlot+", Available Quantity: "+slot.availableQuantity+" of Vaccine "+slot.vaccineInThisSlot);
            if (i!=numOfSlots){
                System.out.println();
            }
        }
    }

    public void listAllSlots(int uniqueID, CoWinPortal portal){
        if(portal.allRegisteredHospitals.keySet().isEmpty()){
            System.out.println("No slots are added for this Hospital");
            return;
        }
        Hospital thatHospital = portal.allRegisteredHospitals.get(uniqueID);
        Set<Integer> thatHospitalAllSlots = thatHospital.allSlots.keySet();
        for (Integer slotNumber: thatHospitalAllSlots){
            System.out.println("Day: "+thatHospital.allSlots.get(slotNumber).dayOfSlot +", Vaccine: "+thatHospital.allSlots.get(slotNumber).vaccineInThisSlot+", Available Qty: "+thatHospital.allSlots.get(slotNumber).availableQuantity);
        }
    }

    public String toString(){
        return "Hospital Name: "+name+", PinCode: "+pinCode+", Unique ID: "+uniqueID;
    }
}
