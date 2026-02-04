import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Kund {
    
    /************************************
    ------------- VARIABLER -------------
    *************************************/

    private String namn;
    private String personummer; // ÅÅÅÅMMDD
   
    Kund() {
        namn = "okänt";
        personummer = "00000000";
        KundRegister.läggTill(this);
    }

    Kund(String namn, String personummer) {
        try {
            LocalDate.parse(personummer, DateTimeFormatter.BASIC_ISO_DATE); 
            if (namn == null || namn.isBlank())
                throw new IllegalArgumentException("Namn får inte vara tomt");
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
