public class Vaccine {
    final String name;
    final int numOfDoses;
    final int gapBtwDoses; // make it 0, for 1 no. of doses

    public Vaccine(String name, int numOfDoses, int gapBtwDoses){
        this.gapBtwDoses=gapBtwDoses;
        this.name=name;
        this.numOfDoses=numOfDoses;
        if (numOfDoses==1)
            gapBtwDoses=0;
    }

    public String toString(){
        return "Vaccine Name: "+name+", Number of Doses: "+numOfDoses+", Gap Between Doses: "+gapBtwDoses;
    }
}
