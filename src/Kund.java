import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Kund {
    // Namn personummer fordon och plats
    // Getter and setters
    // Static ArrayList alla kunder

    //? SKA KLASSEN ELLER APPEN HANTERA FEL ? JUST NU KLASS
        // ! TROR DET ÄR BÄTTRE I APP  

    /************************************
    ------------- VARIABLER -------------
    *************************************/

    private String namn;
    private String personummer; // ÅÅÅÅMMDD
    private Fordon fordon; // FLEXIBELT
    private int platsIndex;

    Kund() {
        namn = "okänt";
        personummer = "00000000";
        fordon = null;
        platsIndex = -1;
        // lägg till i kundregister?
        KundRegister.läggTill(this);

    }

    Kund(String namn, String personummer, Fordon fordon, int platsIndex) {

        try {
            LocalDate.parse(personummer, DateTimeFormatter.BASIC_ISO_DATE); // Hitta på ett sätt at kasta egen Exception
            if (namn == null || namn.isBlank())
                throw new IllegalArgumentException("Namn får inte vara tomt");
            else if (platsIndex < 0 || platsIndex > 20)
                throw new IllegalArgumentException("Plats index finns inte på detta fordon");
            // Om allt lyckades lägg till i KundRegister
            else {
                this.namn = namn;
                this.personummer = personummer;
                this.fordon = fordon;
                this.platsIndex = platsIndex;
                KundRegister.läggTill(this);
            }
        } catch (Exception e) {
            IO.println("FEL: " + e.getMessage());
        }
    }

    /************************************
    --------- GETTERS O SETTERS ---------
    *************************************/

    public String getNamn() {
        return namn;
    }

    public Fordon getFordon() {
        return fordon;
    }

    public String getPersonummer() {
        return personummer;
    }

    public int getPlatsIndex() {
        return platsIndex;
    }


// SE TILL ATT ALLA SETTERS BEHÖVS 
    public void setFordon(Fordon fordon) {
        this.fordon = fordon;
    }

    public void setNamn(String namn){
        try {
            if(namn == null || namn.isBlank()) throw new IllegalArgumentException ("Namn får inte vara tomt");
            else this.namn = namn;
        } catch (Exception e) {
            IO.println("FEL: " + e.getMessage());
        }
    }

    public void setPlatsIndex(int platsIndex) {
        try {
            if(platsIndex < 0 || platsIndex > 20) throw new IllegalArgumentException("PlatsIndexet finns inte på detta fordon");
            else this.platsIndex = platsIndex;
        } catch (Exception e) {
            IO.println("FEL: " + e.getMessage());
        }
    }

    // TODO Skriv bättre toString()
    @Override
    public String toString() {
        return "namn: " + namn + " pnr: " + personummer + " Fordon: " + fordon + " Platsindex: " + platsIndex;
    }

}
