public class Bokning {
    //koppling mellan fordon och Kund
    // innehåller, FordonID Kund och platsIndex
    private Kund kund; 
    private int platsIndex; 
    private Fordon fordon;

    Bokning(Kund kund, Fordon fordon, int platsIndex){
       //TODO Kontroller att inte ogiltigt parametrar matas in, mest Platsindex 
        this.kund = kund;
        this.fordon = fordon;
        this.platsIndex = platsIndex;
    }
}
