public class Bokning {
   
    private Kund kund; 
    private int platsIndex; 
    private Fordon fordon;

    Bokning(Kund kund, Fordon fordon, int platsIndex){
        this.kund = kund;
        this.fordon = fordon;
        this.platsIndex = platsIndex;
    }
}
