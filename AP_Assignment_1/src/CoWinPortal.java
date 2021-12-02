import java.util.LinkedHashMap;
import java.util.Map;

public class CoWinPortal {

    // all three are composition
    Map<Integer, Hospital> allRegisteredHospitals = new LinkedHashMap<>();
    Map<Long, Citizen> allRegisteredCitizens = new LinkedHashMap<>();
    Map<String, Vaccine> allVaccines = new LinkedHashMap<>();
    Map<Integer, String> allVaccineCodes = new LinkedHashMap<>();

    // all these variables are used to help the the Portal to work
    Citizen citizen = new Citizen("Dummy Citizen", 21, -1);   // dummyCitizen, all three are composition
    Hospital hospital = new Hospital("Dummy ospital",""); // dummyHospital
    Vaccine vaccine ;   // dummyVaccine
    private int counterVaccineCode=0;

    public CoWinPortal(){
        System.out.println("CoWin Portal initialized.... \n");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("1. Add Vaccine ");
        System.out.println("2. Register Hospital ");
        System.out.println("3. Register Citizen ");
        System.out.println("4. Add Slot for Vaccination ");
        System.out.println("5. Book Slot for Vaccination ");
        System.out.println("6. List all slots for a hospital ");
        System.out.println("7. Check Vaccination Status ");
        System.out.println("8. Exit \n");
    }

    public void registerCitizen(String name, int age, String uniqueId){
        if (age<=18){
            System.out.println("Only above 18 are allowed ");
            return;
        }
//        if (age >= 130){
//            System.out.println("Invalid age");
//            return;
//        }
        if (uniqueId.length() !=12){
            System.out.println("Citizen Unique ID must be of 12 digit");
            return;
        }
        if (allRegisteredCitizens.get(Long.parseLong(uniqueId))!=null){
            System.out.println("Citizen with this ID is already registered");
            return;
        }
        citizen = new Citizen(name, age, Long.parseLong(uniqueId));
        System.out.println(citizen);
        System.out.println(citizen.getVaccinationStatus());
        allRegisteredCitizens.put(Long.parseLong(uniqueId),citizen);
    }

    public void registerHospital(String name, String pinCode){
        if (pinCode.length()!=6){
            System.out.println("Pincode should be 6 digit");
            return;
        }
        hospital = new Hospital(name,pinCode);
        System.out.println(hospital);
        allRegisteredHospitals.put(hospital.getUniqueID(), hospital);
    }

    public void addVaccine(String name, int numOfDoses, int gapBtwDoses) {
        if (allVaccines.get(name)!=null){
            System.out.println("This Vaccine already exists");
            return;
        }
        if (numOfDoses<=0){
            System.out.println("Invalid number of doses");
            return;
        }
        if (gapBtwDoses<0){
            System.out.println("Invalid Gap b/w doses");
            return;
        }
        vaccine = new Vaccine(name,numOfDoses,gapBtwDoses);
        System.out.println(vaccine);
        allVaccines.put(name,vaccine);
        allVaccineCodes.put(this.counterVaccineCode, name);
        this.counterVaccineCode++;
    }

    public void checkVaccineStatusOfCitizen(String uniqueID){
        if (uniqueID.length() !=12){
            System.out.println("Enter a 12 Digit unique ID");
            return;
        }
        if (allRegisteredCitizens.get(Long.parseLong(uniqueID))==null){
            System.out.println("No citizen registered with this ID");
            return;
        }
        citizen.checkVaccinationStatus(this, Long.parseLong(uniqueID));
    }

    public void listAllSlotsForAHospital(int uniqueID){
        if (Integer.toString(uniqueID).length()!=6){
            System.out.println("Invalid Hospital ID");
            return;
        }
        if (allRegisteredHospitals.get(uniqueID)==null){
            System.out.println("No Hospital registered with this ID");
            return;
        }
        hospital.listAllSlots(uniqueID, this);
    }

    public void addSlotsForHospital(int uniqueID, int numOfSlots){
        if (Integer.toString(uniqueID).length()!=6){
            System.out.println("Hospital ID must be of 6 digits");
            return;
        }
        if (allRegisteredHospitals.get(uniqueID)==null){
            System.out.println("No Hospital registered with this ID");
            return;
        }
        if (numOfSlots<1){
            System.out.println("Invalid number of Slots");
            return;
        }
        hospital.createSlots(uniqueID, numOfSlots, this);
    }

    public void bookSlot(){
        citizen.bookSlot(this);
    }

}
