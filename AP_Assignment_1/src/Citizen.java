import java.util.Scanner;

public class Citizen {
    private final String name;
    private final int age;
    private final long uniqueID;
    private String vaccinationStatus;
    private String vaccineGiven;
    private int numOfDosesGiven;
    private int nextDueDate;

    public Citizen(String name, int age, long uniqueID){
        this.name=name;
        this.age=age;
        this.uniqueID=uniqueID;
        this.vaccinationStatus="REGISTERED";
        this.numOfDosesGiven=0;
        this.vaccineGiven="None";
        this.nextDueDate=0;
    }

    public void setVaccinationStatus(String vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }

    public String getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void checkVaccinationStatus(CoWinPortal portal, long uniqueID){
        Citizen thatCitizen = portal.allRegisteredCitizens.get(uniqueID);
        String status = thatCitizen.getVaccinationStatus();
        if (status.equals("REGISTERED")){
            System.out.println("Citizen Registered");
        }
        if (status.equals("FULLY VACCINATED")){
            System.out.println(status);
            System.out.println("Vaccine Given: "+thatCitizen.vaccineGiven);
            System.out.println("Number of Doses given: "+thatCitizen.numOfDosesGiven);
        }
        else if (status.equals("PARTIALLY VACCINATED")){
            System.out.println(status);
            System.out.println("Vaccine Given: "+thatCitizen.vaccineGiven);
            System.out.println("Number of Doses given: "+thatCitizen.numOfDosesGiven);
            System.out.println("Next Dose due date: "+thatCitizen.nextDueDate);
        }
    }

    public void bookSlot(CoWinPortal portal){
        Scanner scan = new Scanner(System.in);

        System.out.printf("Enter Citizen Unique ID: ");
        String citizenID = scan.nextLine().trim();
        if (citizenID.length() !=12){
            System.out.println("Citizen Unique ID must be of 12 digit. Try again");
            return;
        }
        if (portal.allRegisteredCitizens.get(Long.parseLong(citizenID))==null){
            System.out.println("Citizen with this ID is not registered");
            return;
        }

        Citizen thatCitizen = portal.allRegisteredCitizens.get(Long.parseLong(citizenID));
        if (thatCitizen.getVaccinationStatus().equals("FULLY VACCINATED")){
            System.out.println("This citizen is fully vaccinated. Can't take any more vaccine");
            return;
        }

        System.out.println("1. Search by area");
        System.out.println("2. Search by Vaccine");
        System.out.println("3. Exit");
        System.out.printf("Enter option: ");
        String _option = scan.nextLine().trim();
        int option= Integer.parseInt(_option);
        while (option!=1 && option!=2 && option!=3){
            System.out.printf("Enter correct Input '1 or 2 or 3': ");
            _option = scan.nextLine().trim();
            option= Integer.parseInt(_option);
        }
        if (option==1){
            System.out.printf("Enter pincode: ");
            String pincode = scan.nextLine().trim();
            if (pincode.length()!=6){
                System.out.println("Pincode should be 6 digit. Try again");
                return;
            }
            boolean hospitalFound = false;
            for (Integer hospitalID: portal.allRegisteredHospitals.keySet()){
                if (portal.allRegisteredHospitals.get(hospitalID).pinCode.equals(pincode)){
                    hospitalFound = true;
                }
            }
            if (hospitalFound) {
                bookSlotByPincodeSearch(pincode, portal, Long.parseLong(citizenID));
            }
            else {
                System.out.println("No hospital in this area");
                return;
            }
        }
        else if (option==2){
            System.out.printf("Enter Vaccine name: ");
            String vaccineName = scan.nextLine().trim();
            if (portal.allVaccines.get(vaccineName)==null){
                System.out.println("This Vaccine doesn't exists. Try again");
                return;
            }
            bookSlotByVaccineSearch(vaccineName, portal, Long.parseLong(citizenID));
        }
        else if (option==3) {
            return;
        }
    }

    public void bookSlotByPincodeSearch(String pincode, CoWinPortal portal, long citizenID){
        Scanner scan = new Scanner(System.in);

        for(Integer uniqueID: portal.allRegisteredHospitals.keySet()){
            if (portal.allRegisteredHospitals.get(uniqueID).pinCode.equals(pincode)){
                System.out.println(uniqueID+" "+portal.allRegisteredHospitals.get(uniqueID).name);
            }
        }
        System.out.print("Enter hospital id: ");
        String _hospitalID = scan.nextLine().trim();
        int hospitalID = Integer.parseInt(_hospitalID);
        if (Integer.toString(hospitalID).length()!=6){
            System.out.println("Invalid Hospital ID. Try again");
            return;
        }
        if (portal.allRegisteredHospitals.get(hospitalID)==null){
            System.out.println("No Hospital registered with this ID");
            return;
        }

        Hospital selectedHospital = portal.allRegisteredHospitals.get(hospitalID);
        Citizen thisCitizenToBeVaccinated = portal.allRegisteredCitizens.get(citizenID);
        if (selectedHospital.allSlots.keySet().isEmpty()){
            System.out.println("No slots available for this Hospital");
            return;
        }

        boolean citizenToBeVacinated =true;
        for (int slotNumber: selectedHospital.allSlots.keySet()){
            if ( (!thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) && thisCitizenToBeVaccinated.nextDueDate == selectedHospital.allSlots.get(slotNumber).dayOfSlot){
                citizenToBeVacinated = true;
                break;
            }
            else if ( (!thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) && (thisCitizenToBeVaccinated.nextDueDate < selectedHospital.allSlots.get(slotNumber).dayOfSlot)){
                citizenToBeVacinated = true;
                break;
            }
            else if ( (!thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) && thisCitizenToBeVaccinated.nextDueDate > selectedHospital.allSlots.get(slotNumber).dayOfSlot){
                citizenToBeVacinated = false;
            }
        }
        if (thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")){
            citizenToBeVacinated = true;
        }
        if (!citizenToBeVacinated){
            System.out.println("No slots available");
            return;
        }

        if (thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")){
            for (Integer slotNumber: selectedHospital.allSlots.keySet()){
                Slot slotOfSelectedHospital = selectedHospital.allSlots.get(slotNumber);
                System.out.println(slotNumber+"-> Day: "+slotOfSelectedHospital.dayOfSlot+", Available Qty: "+slotOfSelectedHospital.availableQuantity+", Vaccine: "+slotOfSelectedHospital.vaccineInThisSlot);
            }
        }
        else{
            for (Integer slotNumber: selectedHospital.allSlots.keySet()){
                Slot slotOfSelectedHospital = selectedHospital.allSlots.get(slotNumber);
                if ((slotOfSelectedHospital.dayOfSlot >= thisCitizenToBeVaccinated.nextDueDate) && (slotOfSelectedHospital.vaccineInThisSlot.equals(thisCitizenToBeVaccinated.vaccineGiven)))
                    System.out.println(slotNumber+"-> Day: "+slotOfSelectedHospital.dayOfSlot+", Available Qty: "+slotOfSelectedHospital.availableQuantity+", Vaccine: "+slotOfSelectedHospital.vaccineInThisSlot);
            }
        }
        System.out.printf("Choose Slot: ");
        String _slotChoosen = scan.nextLine().trim();
        int slotChoosen = Integer.parseInt(_slotChoosen);
        if (selectedHospital.allSlots.get(slotChoosen)==null){
            System.out.println("Invalid slot chosen. Try again");
            return;
        }

        if (selectedHospital.allSlots.get(slotChoosen).availableQuantity<=0){
            System.out.println("Slot for this vaccine is finished. Try another day");
            return;
        }
        Vaccine vaccineToBeGiven = portal.allVaccines.get(selectedHospital.allSlots.get(slotChoosen).vaccineInThisSlot);
        if ((!thisCitizenToBeVaccinated.vaccineGiven.equals("None")) && (!thisCitizenToBeVaccinated.vaccineGiven.equals(vaccineToBeGiven.name))){
            System.out.println("This Citizen is vaccinated with some other vaccine. Try again");
            return;
        }
      if ((!thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) && (thisCitizenToBeVaccinated.nextDueDate > selectedHospital.allSlots.get(slotChoosen).dayOfSlot)){
            System.out.println("Due Date is not over");
            return;
        }
        selectedHospital.allSlots.get(slotChoosen).availableQuantity--;
        System.out.println(thisCitizenToBeVaccinated.name+" vaccinated with "+vaccineToBeGiven.name);
        thisCitizenToBeVaccinated.numOfDosesGiven++;
        thisCitizenToBeVaccinated.vaccineGiven = vaccineToBeGiven.name;
        if (thisCitizenToBeVaccinated.numOfDosesGiven == vaccineToBeGiven.numOfDoses){
            thisCitizenToBeVaccinated.setVaccinationStatus("FULLY VACCINATED");
            thisCitizenToBeVaccinated.nextDueDate = Integer.MIN_VALUE;
        }
        else if (thisCitizenToBeVaccinated.numOfDosesGiven < vaccineToBeGiven.numOfDoses){
            thisCitizenToBeVaccinated.setVaccinationStatus("PARTIALLY VACCINATED");
            thisCitizenToBeVaccinated.nextDueDate = vaccineToBeGiven.gapBtwDoses +1;
        }
    }

    public void bookSlotByVaccineSearch(String vaccineName, CoWinPortal portal, long citizenID){
        Scanner scan = new Scanner(System.in);

        Hospital searchedHospital;
        Slot searchedSlot;

        boolean hospitalNotFound = true;
        hospital_loop:
        for (Integer hospitalId: portal.allRegisteredHospitals.keySet()){
            searchedHospital = portal.allRegisteredHospitals.get(hospitalId);
            for (Integer slotNumber: searchedHospital.allSlots.keySet()){
                searchedSlot = searchedHospital.allSlots.get(slotNumber);
                if (searchedSlot.vaccineInThisSlot.equals(vaccineName)){
                    System.out.println(searchedHospital.uniqueID+" "+searchedHospital.name);
                    hospitalNotFound = false;
                    continue hospital_loop;
                }
            }
        }
        if (hospitalNotFound){
            System.out.println("No hospital has slot for this vaccine");
            return;
        }

        System.out.print("Enter hospital id: ");
        String _hospitalID = scan.nextLine().trim();
        int hospitalID = Integer.parseInt(_hospitalID);
        if (Integer.toString(hospitalID).length()!=6){
            System.out.println("Invalid Hospital ID");
            return;
        }
        if (portal.allRegisteredHospitals.get(hospitalID)==null){
            System.out.println("No Hospital registered with this ID");
            return;
        }

        Hospital selectedHospital = portal.allRegisteredHospitals.get(hospitalID);
        Citizen thisCitizenToBeVaccinated = portal.allRegisteredCitizens.get(citizenID);

        boolean citizenToBeVacinated =true;
        for (int slotNumber: selectedHospital.allSlots.keySet()){
            if ( (!thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) && (thisCitizenToBeVaccinated.vaccineGiven.equals(vaccineName)) && (thisCitizenToBeVaccinated.nextDueDate==selectedHospital.allSlots.get(slotNumber).dayOfSlot)){
                citizenToBeVacinated = true;
                break;
            }
            else if ( (!thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) && (thisCitizenToBeVaccinated.vaccineGiven.equals(vaccineName)) && (thisCitizenToBeVaccinated.nextDueDate<selectedHospital.allSlots.get(slotNumber).dayOfSlot)){
                citizenToBeVacinated = true;
                break;
            }
            else if ( (!thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) && (thisCitizenToBeVaccinated.vaccineGiven.equals(vaccineName)) && (thisCitizenToBeVaccinated.nextDueDate>selectedHospital.allSlots.get(slotNumber).dayOfSlot)){
                citizenToBeVacinated = false;
            }
        }
        if (thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")){
            citizenToBeVacinated = true;
        }
        if (!citizenToBeVacinated){
            System.out.println("No slots available");
            return;
        }
        if (thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) {
            for (Integer slotNumber : selectedHospital.allSlots.keySet()) {
                Slot slotOfSelectedHospital = selectedHospital.allSlots.get(slotNumber);
                if (slotOfSelectedHospital.vaccineInThisSlot.equals(vaccineName)) {
                    System.out.println(slotNumber + "-> Day: " + slotOfSelectedHospital.dayOfSlot + ", Available Qty: " + slotOfSelectedHospital.availableQuantity + ", Vaccine: " + slotOfSelectedHospital.vaccineInThisSlot);
                }
            }
        }
        else{
            for (Integer slotNumber : selectedHospital.allSlots.keySet()) {
                Slot slotOfSelectedHospital = selectedHospital.allSlots.get(slotNumber);
                if (slotOfSelectedHospital.vaccineInThisSlot.equals(vaccineName) && (thisCitizenToBeVaccinated.nextDueDate<=slotOfSelectedHospital.dayOfSlot)) {
                    System.out.println(slotNumber + "-> Day: " + slotOfSelectedHospital.dayOfSlot + ", Available Qty: " + slotOfSelectedHospital.availableQuantity + ", Vaccine: " + slotOfSelectedHospital.vaccineInThisSlot);
                }
            }
        }
        System.out.printf("Choose Slot: ");
        String _slotChoosen = scan.nextLine().trim();
        int slotChoosen = Integer.parseInt(_slotChoosen);
        if (selectedHospital.allSlots.get(slotChoosen)==null){
            System.out.println("Invalid slot chosen");
            return;
        }

        if (selectedHospital.allSlots.get(slotChoosen).availableQuantity<=0){
            System.out.println("Slot for this vaccine is finished. Try another day");
            return;
        }
        Vaccine vaccineToBeGiven = portal.allVaccines.get(selectedHospital.allSlots.get(slotChoosen).vaccineInThisSlot);
        if ((!thisCitizenToBeVaccinated.vaccineGiven.equals("None")) && (!thisCitizenToBeVaccinated.vaccineGiven.equals(vaccineToBeGiven.name))){
            System.out.println("This Citizen is vaccinated with some other vaccine. Try again");
            return;
        }
        if ( (!thisCitizenToBeVaccinated.getVaccinationStatus().equals("REGISTERED")) && (thisCitizenToBeVaccinated.nextDueDate > selectedHospital.allSlots.get(slotChoosen).dayOfSlot)){
            System.out.println("Due Date is not over");
            return;
        }
        selectedHospital.allSlots.get(slotChoosen).availableQuantity--;
        System.out.println(thisCitizenToBeVaccinated.name+" vaccinated with "+vaccineToBeGiven.name);
        thisCitizenToBeVaccinated.numOfDosesGiven++;
        thisCitizenToBeVaccinated.vaccineGiven = vaccineToBeGiven.name;
        if (thisCitizenToBeVaccinated.numOfDosesGiven == vaccineToBeGiven.numOfDoses){
            thisCitizenToBeVaccinated.setVaccinationStatus("FULLY VACCINATED");
            thisCitizenToBeVaccinated.nextDueDate = Integer.MIN_VALUE;
        }
        else if (thisCitizenToBeVaccinated.numOfDosesGiven < vaccineToBeGiven.numOfDoses){
            thisCitizenToBeVaccinated.setVaccinationStatus("PARTIALLY VACCINATED");
            thisCitizenToBeVaccinated.nextDueDate = vaccineToBeGiven.gapBtwDoses +1;
        }
    }

    public String toString(){
        return "Citizen name: "+name+",Age: "+age+",Unique ID: "+ String.format("%012d",uniqueID);
    }

}
