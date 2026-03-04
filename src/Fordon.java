public abstract class Fordon {

    /* * * * * Variabler * * * * */
    protected double pris1;
    protected double pris2;
    protected String ID;

    protected String[] platser;

    /* * * * * Konstruktor * * * * */
    Fordon(String ID, double pris1, double pris2, int antalKunder) {
        if (ID == null || ID.isBlank())
            throw new IllegalArgumentException("fordons ID får inte var tomt");
        if (pris1 < 0 || pris2 < 0)
            throw new IllegalArgumentException("Priset får inte vara negativ"); // går tekniskt inte att komma hit
        if (antalKunder <= 0)
            throw new IllegalArgumentException("Fordonet måste aceptera kunder"); // går tekniskt inte att komma hit

        this.ID = ID;
        this.pris1 = pris1;
        this.pris2 = pris2;
        platser = new String[antalKunder];

        // Fyller platserna med plats nummer
        for (int i = 0; i < platser.length; i++) {
            platser[i] = Integer.toString(i + 1);
        }
        // lägger till fordonet i fordonsregistret
        FordonRegister.läggTill(this);
    }

    /* * * * * Getters och Setters * * * * */
    public double getPris(Bokning bokning) {
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
            // Kollar att platsindexet är giltigt
            if (platsIndex < 0 || platsIndex + 1 > platser.length)
                throw new IllegalArgumentException("platsIndex finns inte på fordonet");
            else {
                // Om de bokar platsen
                if (bokad == true)
                    platser[platsIndex] = "XX";
                // Om platsen avbokas 
                else
                    platser[platsIndex] = String.valueOf(platsIndex + 1);
            }
        } catch (Exception e) {
            IO.println("FEL: " + e.getMessage());
        }
    }

    /* * * * * To String * * * * */
    @Override
    public abstract String toString();
}
