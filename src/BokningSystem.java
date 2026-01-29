import java.time.LocalDate;

public class BokningSystem {
    // Static?

    // hanterar menyn
    /*
     * Meny
     * lägg till - välj fordon
     * antal lediga platser - välj fordon
     * beräkna vinst beroende på typ och pris - total vinst och seperat vins
     * hitta bokning (personummer eller namn) - kollar igenom alla
     * ta bort bokning - kollar igenom alla
     * skriv ut alla platser sorterat på ålder - skriver ut separerat på fordon
     */

    public void Meny() {
        int val;
        boolean open = true;
        while (open) {

            IO.println("""
                        ---- Meny: ----
                        1. Lägga till en passagerare - Välj Fordon (TBC)
                        2. Leta Lediga platser - Välj Fordon (TBC)
                        3. Beräkna vinst - Total vinst och Separat Vinst  (TBC)
                        4. Hitta bokning - ange personnummer eller namn (TBC)
                        5. Radera bokning - ange personnummer eller namn (TBC)
                        6. Stäng meny
                    """);
            while (true) {
                try {
                    val = Integer.parseInt(IO.readln("Ange Alternativ (1-6): "));
                    break;
                } catch (Exception e) {
                    IO.println("FEL: måste vara ett heltal");
                }
            }

            switch (val) {
                case 1:
                    // BOKA
                    break;

                case 2:
                    //DISPLAY lediga platser 
                    break;

                case 3:
                    //BERÄKNA VINST 
                    break;
                case 4:
                    //HITTA BOKNING 
                    break;
                case 5:
                    //RADERA BOKNING 
                    break;
                case 6:
                    // STÄNG MENY
                    IO.println(" ---- Stänger menyn ---- "); 
                    open= false; 
                    break;

                default:
                    break;
            }
        }

    }
    // 

    static public void bokaTest(Kund kund, Fordon fordon){
        IO.println();
        fordon.läggTillIKunder(kund, kund.getPlatsIndex());;
        IO.println("Kunden: " + kund + " har lagts till på " + fordon);
    }

    static public void visaPlatser(Fordon fordon){
        if(fordon instanceof Buss){

            String display = "";
            for (int i = 0; i < fordon.getKunder().length; i++) {
                int kundPlatsIndex = fordon.getKunder()[i].getPlatsIndex();
                if(kundPlatsIndex == -1 && kundPlatsIndex < 10) display += "[0" + (i + 1) + "]";
                else if(kundPlatsIndex == -1 && kundPlatsIndex < 10) display += "[" + (i + 1) + "]";
                else display += "[XX]";
            }
            IO.println(display);
            IO.println("""
                    [XX][02]   [03][04]
                    [05][06]   [07][08]
                    [09][10]   [11][12]
                    [13][14]   [15][16]
                    [17][18]   [19][20]
                    """);
        }

    }
    

    /// - - BOKA - - ///
    /// Välj fordon
    /// Skriv ut listan med en forloop och kunder arrayen
    /// sätter vald plats till 0 
    /// while till användaren väljer giltig plats
    ///     tre Exception om kunder[vladplats] inte är ledig så typ personummer = 00000000 ||inte heltal, och inte med i listan så out of bounds
    /// while till användaren skriver in giltigt pnr använd localdate
    /// lägg till på indexet 
}

/// Hur ska jag hantera olika priser pris 1 och pris 2? skulle kunna fungera,
/// ger ingen flexibilitet dock ska kunden holla koll på priset? Varför? Varför
/// inte? Varje bokning som görs kan antingen innehålla ett rabaterat eller inte,
/// beroende på olika faktorer för varje BUSS: barn och Vuxen beroende på ålder
/// FLYG: första eller vanlig klass beroende på ja/nej, TÅG: Beroende på vald
/// plats Ska det faktiskt vara två olika klasser, en som hanterar olika typer av
/// fordon den andra som hanterar meny osv kanske gör det enklare att göra
/// bokningar. Tror nog kunden har kontroll på pengarna spenderat Verkar rimligt
/// Behöver inte då göra någon lista på olika mängd på vardera pris. Antingen har
/// Kund kontroll på exakta priset eller pris1 och pris2 och så får
/// bokningssytemet ha koll på hur mycket det kostar.
/// 
