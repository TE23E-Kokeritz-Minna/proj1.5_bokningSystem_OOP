public abstract class Fordon {

    protected double pris1;
    protected double pris2;
    protected String ID;

    protected String[] platser;
    // Ger Fordonet information om vilka platser som är fyllda.
    // Innehåller alla platser 1-antal platser och en metod som ersätter en sagd
    // plats till XX

    Fordon(String ID, double pris1, double pris2, int antalKunder) {
        this.ID = ID;
        this.pris1 = pris1;
        this.pris2 = pris2;
        platser = new String[antalKunder];

        for (int i = 0; i < platser.length; i++) {
            platser[i] = Integer.toString(i + 1);
        }
        FordonRegister.läggTill(this);
    }

    public void skrivUtPlatserTEST() {
        for (int i = 0; i < platser.length; i++) {
            IO.println(platser[i]);
        }
    }

    public double getPris() {
        return pris1;
    }

    public String getID() {
        return ID;
    }

    public String[] getPlatser() {
        return platser;
    }
    

    public void setPlats(int platsIndex, boolean bokad) {
        try {
            if (platsIndex < 0 || platsIndex + 1 > platser.length)
                throw new IllegalArgumentException("platsIndex finns inte på fordonet");
            else {
                if (bokad == true)
                    platser[platsIndex] = "XX";
                else
                    platser[platsIndex] = String.valueOf(platsIndex + 1);
            }
        } catch (Exception e) {
            IO.println("FEL: " + e.getMessage());
        }
    }

    @Override
    public abstract String toString();
}
