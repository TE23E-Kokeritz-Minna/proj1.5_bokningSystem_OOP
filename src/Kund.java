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
    //private Fordon fordon; // FLEXIBELT
    //private int platsIndex;

    Kund() {
        namn = "okänt";
        personummer = "00000000";
        // lägg till i kundregister?
        KundRegister.läggTill(this);

    }

    Kund(String namn, String personummer) {

        try {
            LocalDate.parse(personummer, DateTimeFormatter.BASIC_ISO_DATE); // Hitta på ett sätt at kasta egen Exception
            if (namn == null || namn.isBlank())
                throw new IllegalArgumentException("Namn får inte vara tomt");
            // Om allt lyckades lägg till i KundRegister
            else {
                this.namn = namn;
                this.personummer = personummer;
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

   
    public String getPersonummer() {
        return personummer;
    }

// SE TILL ATT ALLA SETTERS BEHÖVS 

    public void setNamn(String namn){
        try {
            if(namn == null || namn.isBlank()) throw new IllegalArgumentException ("Namn får inte vara tomt");
            else this.namn = namn;
        } catch (Exception e) {
            IO.println("FEL: " + e.getMessage());
        }
    }


    // TODO Skriv bättre toString()
    @Override
    public String toString() {
        return "namn: " + namn + " pnr: " + personummer;
    }

}
