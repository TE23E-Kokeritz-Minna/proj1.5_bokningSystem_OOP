public class Bokning {
   
    private Kund kund; 
    private int platsIndex; 
    private Fordon fordon;

    Bokning(Kund kund, Fordon fordon, int platsIndex){
        // kontrollera giltiga parametrar
            // Hittas Kund och Fordon i resp Register 
            // existerar det platsindexet på det fordonet
        this.kund = kund;
        this.fordon = fordon;
        this.platsIndex = platsIndex;

        BokningsRegister.läggTill(this);
    }
}
