public class Slot {
    final int dayOfSlot;
    final String vaccineInThisSlot;
    int availableQuantity;

    public Slot(String vaccineInThisSlot, int availableQuantity, int dayOfSlot){
        this.availableQuantity=availableQuantity;
        this.dayOfSlot=dayOfSlot;
        this.vaccineInThisSlot=vaccineInThisSlot;
    }
}
