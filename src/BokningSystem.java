import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BokningSystem {

    // Metod för att köra menyn
    public static void Meny() {
        // Varibler som kontrollerar menyn
        int val;
        boolean open = true;

        while (open) {

            IO.println("""
                        ---- Meny: ----
                        1. Lägga till en passagerare - Välj Fordon
                        2. Leta Lediga platser - Välj Fordon
                        3. Beräkna vinst - Total vinst och Separat Vinst
                        4. Hitta bokning - ange personnummer eller namn
                        5. Radera bokning - ange personnummer eller namn
                        6. Stäng meny
                    """);
            // Får ett giltigt alternativ från användaren
            while (true) {
                try {
                    val = Integer.parseInt(IO.readln("Ange Alternativ (1-6): ").trim());
                    break;
                } catch (Exception e) {
                    IO.println("FEL: måste vara ett heltal");
                }
            }
            // Alla meny alternativ
            switch (val) {
                case 1:
                    // BOKA
                    IO.println("--- Boka en plats ---");

                    /// Välj fordonstyp
                    Fordon valtFordon = väljFordonsTyp();
                    int platsIndex;

                    visaPlatser(valtFordon);

                    // Kontrroller giltigt plats
                    while (true) {
                        try {
                            // platsindex är indexet (0 based) inte plats nummret (1 based )
                            platsIndex = Integer.parseInt(IO.readln("Ange plats att boka: ").trim()) - 1;

                            // kontrollerar att fordonet har platsen annars felmedelnade
                            if (platsIndex < 0 || platsIndex > valtFordon.getPlatser().length - 1)
                                throw new IllegalArgumentException("Det valda fordonet har inte den platsen");
                            // kontrollerar att den är ledig annars felmedelande
                            else if (valtFordon.getPlatser()[platsIndex] == "XX")
                                throw new IllegalArgumentException("platsen är redan bokad");
                            break;
                        } catch (Exception e) {
                            IO.println("FEL: " + e.getMessage());
                        }
                    }

                    String personnummer;
                    String namn;

                    // Sammlar Personummer och Namn på Kund
                    while (true) {
                        try {
                            personnummer = IO.readln("Ange personummer: ").trim();
                            // Kommmer skicka ett fel om personummer är ogiltigt
                            LocalDate.parse(personnummer, DateTimeFormatter.BASIC_ISO_DATE);
                            // ↑ det som parsas ↑ formaterarer ↑ ÅÅÅÅMMDD formatet

                            namn = IO.readln("Ange namn: ").trim();
                            // kontrollerar att namn inte är tomt
                            if (namn == null || namn.isBlank())
                                throw new IllegalArgumentException("Namn får inte vara tomt");
                            break;
                        } catch (Exception e) {
                            IO.println("FEL: " + e.getMessage());
                        }
                    }
                    // om ett flyg bokas ska även förstaklass frågan ställs
                    boolean förstaKlass = false;
                    if (valtFordon instanceof Flyg) {
                        while (true) {
                            try {
                                // ! svag, om de skriver ture eller liknade blir det false
                                förstaKlass = Boolean
                                        .parseBoolean(IO.readln("Förstaklass på flyget? (true/false)").trim());
                                break;
                            } catch (Exception e) {
                                IO.println("FEL: " + e.getMessage());
                            }
                        }
                    }
                    // skapar kund med korrekt information
                    Kund kund = new Kund(namn, personnummer);

                    // skapar bokningen med alla infromation.
                    new Bokning(kund, valtFordon, platsIndex, förstaKlass);
                    // Ser till att ändra visuelt i plats listan
                    valtFordon.setPlats(platsIndex, true);

                    break;

                case 2:
                    // DISPLAY lediga platser
                    IO.println("--- Visa plaster ---");
                    Fordon valtFordon2 = väljFordonsTyp();
                    visaPlatser(valtFordon2);
                    break;

                case 3:
                    // BERÄKNA VINST
                    IO.println("--- Beräkna Vinst ---");

                    double summa = 0;

                    try {
                        String svar = IO.readln("Vill du beräkna total vinst eller specifik vinst (tot/spec): ").trim();

                        switch (svar.toLowerCase()) {
                            case "tot":
                                for (Bokning bokning : BokningsRegister.getAllaBokninger()) {
                                    summa += bokning.getPris(); // lägger till alla priser i en summa
                                }

                                summa = Math.floor(summa * 100) / 100; // avrundar till 2 decimaler
                                IO.println("Total vinsten är: " + summa + " kr");
                                break;

                            case "spec":
                                // väljer ett specifikt fordon
                                Fordon valtFordon3 = väljFordonsTyp();

                                for (Bokning bokning : BokningsRegister.getAllaBokninger()) {
                                    if (bokning.getFordon() == valtFordon3) {
                                        summa += bokning.getPris(); // lägger till alla framkommna priser på det
                                                                    // fordonet
                                    }
                                }
                                summa = Math.floor(summa * 100) / 100; // avrundar till 2 deci
                                IO.println("Vinsten för " + valtFordon3 + " är: " + summa + " kr");
                                break;

                            default:
                                // om ett ogiltigt alternativ valdes
                                throw new IllegalArgumentException("Ogiltigt Alternativ");
                        }

                    } catch (Exception e) {
                        IO.println("FEL: " + e.getMessage());
                    }
                    break;

                case 4:
                    // HITTA BOKNING
                    IO.println("--- Hitta Bokning ---");

                    Boolean hittadeBokning = false;

                    String söktPnrNamn = IO.readln("Ange Personummer eller namn av den sökta bokningen: ").trim();
                    for (Bokning bokning : BokningsRegister.getAllaBokninger()) {
                        // kollar om antingen personummer eller namnet matchar med något i listan
                        if (bokning.getKund().getNamn().equalsIgnoreCase(söktPnrNamn)
                                || bokning.getKund().getPersonummer().equalsIgnoreCase(söktPnrNamn)) {
                            // skriver ut bokningen
                            IO.println(bokning);
                            hittadeBokning = true;
                            break;
                        }
                    }
                    // om bokningen inte hittades
                    if (!hittadeBokning)
                        IO.println("Bokningen hittades inte");

                    break;

                case 5:
                    // RADERA BOKNING
                    IO.println("--- Radera Bokning ---");
                    hittadeBokning = false;

                    söktPnrNamn = IO.readln("Ange Personummer eller namn av den sökta bokningen: ").trim();
                    for (Bokning bokning : BokningsRegister.getAllaBokninger()) {
                        if (bokning.getKund().getNamn().equalsIgnoreCase(söktPnrNamn)
                                || bokning.getKund().getPersonummer().equalsIgnoreCase(söktPnrNamn)) {

                            // ändrar b´visulet så att platsen blir ledig
                            bokning.getFordon().setPlats(bokning.getPlatsIndex(), false);
                            // Tar bort bokningen
                            BokningsRegister.getAllaBokninger().remove(bokning);

                            hittadeBokning = true;
                            IO.println(bokning + " har raderats från registret");
                            break;
                        }
                    }
                    // om bokningen inte hittades
                    if (!hittadeBokning)
                        IO.println("Bokningen fanns inte");
                    break;

                case 6:
                    // STÄNG MENY
                    IO.println(" ---- Stänger menyn ---- ");
                    open = false;
                    break;

                default:
                    break;
            }
        }
    }

    // Metod för att välja mellan FLYG BUSS och TÅG
    private static Fordon väljFordonsTyp() {
        Fordon valtFordon = null;

        boolean giltigtFordon = false;
        while (!giltigtFordon) {
            String svar = IO.readln("Boka på Flyg/Buss/Tåg: ");
            try {
                switch (svar.toLowerCase().trim()) {
                    case "flyg":
                        valtFordon = väljFordon(Flyg.class);
                        giltigtFordon = true;
                        break;

                    case "buss":
                        valtFordon = väljFordon(Buss.class);
                        giltigtFordon = true;
                        break;

                    case "tåg":
                        valtFordon = väljFordon(Tåg.class);
                        giltigtFordon = true;
                        break;

                    default:
                        throw new IllegalArgumentException("Ogiltigt fordons alternativ");
                }
            } catch (Exception e) {
                IO.println("FEL: " + e.getMessage());
            }
        }
        return valtFordon;
    }

    // Metod för att välja mellan Fordonen av en specfik typ (BUSS FLYG TÅG)
    private static Fordon väljFordon(Class<?> typ) {
        // lista för alla fordon av den typen
        ArrayList<Fordon> alla = FordonRegister.getAllaTyp(typ);

        if (alla.isEmpty()) {
            IO.println("Inga Fordon finns av den typen");
            return null;
        } else {
            // Skriver ut listan
            for (int i = 0; i < alla.size(); i++) {
                IO.println((i + 1) + ". " + alla.get(i).ID);
            }

            int fordonNr;
            // får giltigt fordons
            while (true) {
                try {
                    fordonNr = Integer.parseInt(IO.readln("Välj Fordon nr: "));
                    if (fordonNr < 1 || fordonNr - 1 >= alla.size())
                        throw new IndexOutOfBoundsException("Ogiltigt Index");
                    else
                        break;
                } catch (Exception e) {
                    IO.println("FEL: " + e.getMessage());
                }
            }
            // returnera det valda fordonet
            return alla.get(fordonNr - 1);
        }
    }

    // Metod för att visa alla platser på ett specifkt fordon.
    public static void visaPlatser(Fordon fordon) {
        if (fordon instanceof Buss) {
            IO.println("Bussen: " + fordon.ID);

            for (int row = 0; row < 5; row++) {
                // ↑ 5 rader
                // ↓ de 4 platserna på rader ↓ 2 chars av ↓ denna array ↓ på denna plats
                String p1 = String.format("%2s", fordon.platser[row * 4]);
                String p2 = String.format("%2s", fordon.platser[row * 4 + 1]);
                String p3 = String.format("%2s", fordon.platser[row * 4 + 2]);
                String p4 = String.format("%2s", fordon.platser[row * 4 + 3]);

                // Skriver ut hela raden
                System.out.printf("\t[%s][%s]   [%s][%s]\n", p1.replace(' ', '0'), p2.replace(' ', '0'),
                        p3.replace(' ', '0'), p4.replace(' ', '0'));
            }
        }

        else if (fordon instanceof Flyg) {
            IO.println("Flyget: " + fordon.ID);

            for (int row = 0; row < 9; row++) {
                // 9 rader, 6 platser på varje rad
                String p1 = String.format("%2s", fordon.platser[row * 6]);
                String p2 = String.format("%2s", fordon.platser[row * 6 + 1]);
                String p3 = String.format("%2s", fordon.platser[row * 6 + 2]);
                String p4 = String.format("%2s", fordon.platser[row * 6 + 3]);
                String p5 = String.format("%2s", fordon.platser[row * 6 + 4]);
                String p6 = String.format("%2s", fordon.platser[row * 6 + 5]);

                System.out.printf("\t[%s][%s][%s]   [%s][%s][%s]\n", p1.replace(' ', '0'), p2.replace(' ', '0'),
                        p3.replace(' ', '0'), p4.replace(' ', '0'), p5.replace(' ', '0'), p6.replace(' ', '0'));
            }
        } else if (fordon instanceof Tåg) {
            IO.println("Tåget: " + fordon.ID);

            // första sektionen med 6 rader 4 platser var
            IO.println("=========== K A B I N E R ===========");
            for (int row = 0; row < 6; row++) {
                String p1 = String.format("%2s", fordon.platser[row * 4]);
                String p2 = String.format("%2s", fordon.platser[row * 4 + 1]);
                String p3 = String.format("%2s", fordon.platser[row * 4 + 2]);
                String p4 = String.format("%2s", fordon.platser[row * 4 + 3]);

                System.out.printf("\t[%s][%s]   [%s][%s]\n", p1.replace(' ', '0'), p2.replace(' ', '0'),
                        p3.replace(' ', '0'), p4.replace(' ', '0'));

                // Skriver en tom rad mellan 2 och 3 // (Finns enklare, ville bara öva med %)
                if ((row - 1) % 2 == 0 && row != 5)
                    IO.println();
            }
            IO.println("=====================================");

            // andra sektionen med billigare
            for (int row = 6; row < 15; row++) {
                // 9 rader 4 paltser var
                String p1 = String.format("%2s", fordon.platser[row * 4]);
                String p2 = String.format("%2s", fordon.platser[row * 4 + 1]);
                String p3 = String.format("%2s", fordon.platser[row * 4 + 2]);
                String p4 = String.format("%2s", fordon.platser[row * 4 + 3]);

                System.out.printf("\t[%s][%s]   [%s][%s]\n", p1.replace(' ', '0'), p2.replace(' ', '0'),
                        p3.replace(' ', '0'), p4.replace(' ', '0'));
            }
        }
    }
}