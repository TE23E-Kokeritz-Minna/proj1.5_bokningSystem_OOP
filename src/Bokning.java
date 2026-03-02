public class Bokning {

    private Kund kund;
    private int platsIndex;
    private Fordon fordon;
    private double pris;

    // Finns egentlgen inte någon anledning att den finns
    Bokning(Kund kund, Fordon fordon, int platsIndex) {
        // kontrollera giltiga parametrar
        // Hittas Kund och Fordon i resp Register
        // existerar det platsindexet på det fordonet
        this.kund = kund;
        this.fordon = fordon;
        this.platsIndex = platsIndex;
        if (fordon instanceof Buss || fordon instanceof Tåg)
            pris = fordon.getPris(this);
        else
            throw new IllegalArgumentException("Ogilitg bokning");
        BokningsRegister.läggTill(this);
    }
/*     Bokning(){
        kund = new Kund();
        fordon = null;
        platsIndex = -1;
    } */

    Bokning(Kund kund, Fordon fordon, int platsIndex, boolean förstaKlass) {
        this.kund = kund;
        this.fordon = fordon;
        this.platsIndex = platsIndex;
        switch (fordon) {
            case Flyg f -> pris = f.getPris(förstaKlass);
            case Buss b -> pris = b.getPris(this);
            case Tåg t -> pris = t.getPris(this);
            default -> throw new IllegalArgumentException("Ogilitg bokning");
        }

        BokningsRegister.läggTill(this);
    }

    public Kund getKund() {
        return kund;
    }

    public Fordon getFordon() {
        return fordon;
    }

    public int getPlatsIndex() {
        return platsIndex;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return kund + " " + fordon + " (" + (platsIndex + 1) + ")";
    }

}
