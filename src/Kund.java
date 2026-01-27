import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Kund {
    // Namn personummer fartyg och plats
    // Getter and setters
    // Static ArrayList alla kunder

    private String namn;
    private String personummer; // ÅÅÅÅMMDD
    private Bokning fartyg; // FLEXIBELT
    private int platsIndex;

    Kund() {
        namn = "okänt";
        personummer = "00000000";
        fartyg = null;
        platsIndex = 0;
        // lägg till i kundregister?
        KundRegister.läggTill(this);

    }

    Kund(String namn, String personummer, Bokning fartyg, int platsIndex) {

        try {
            LocalDate.parse(personummer, DateTimeFormatter.BASIC_ISO_DATE); // DUBBLE CHECK //
            if (namn == null || namn.trim().isEmpty())
                throw new IllegalArgumentException("Namn får inte vara tomt");
            // TODO: FUNGERAR SOM SKA?
            else if (platsIndex < 0 || platsIndex > 20)
                throw new IllegalArgumentException("Plats index finns inte på detta fartyg");
            else {
                this.namn = namn;
                this.personummer = personummer;
                this.fartyg = fartyg;
                this.platsIndex = platsIndex;
                KundRegister.läggTill(this);
            }
        } catch (Exception e) {
            IO.println("FEL: " + e.getMessage());
        }

    }

    // TODO Skriv bättre toString()
    @Override
    public String toString() {
        return "namn: " + namn + " pnr: " + personummer + " Fartyg: " + fartyg + " Platsindex: " + platsIndex;
    }

}
