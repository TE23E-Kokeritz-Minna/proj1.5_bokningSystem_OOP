import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BokningSystem {

    public static void Meny() {
        int val;
        boolean open = true;
        while (open) {

            IO.println("""
                        ---- Meny: ----
                        1. Lägga till en passagerare - Välj Fordon
                        2. Leta Lediga platser - Välj Fordon
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
                    IO.println("--- Boka en plats ---");
                    /// Välj fordonstyp
                    Fordon valtFordon = väljFordonsTyp();
                    int platsIndex;
                    visaPlatser(valtFordon);
                    while (true) {
                        try {
                            platsIndex = Integer.parseInt(IO.readln("Ange plats att boka: ")) - 1;
                            if (platsIndex < 0 || platsIndex > valtFordon.getPlatser().length - 1)
                                throw new IllegalArgumentException("Det valda fordonet har inte den platsen");
                            else if (valtFordon.getPlatser()[platsIndex] == "XX")
                                throw new IllegalArgumentException("platsen är redan bokad");
                            break;
                        } catch (Exception e) {
                            IO.println("FEL: " + e.getMessage());
                        }
                    }

                    String personnummer;
                    String namn;

                    // ? Ändra så personummer och namn blir olika tryCatch ? //
                    while (true) {
                        try {
                            personnummer = IO.readln("Ange personummer: ");
                            LocalDate.parse(personnummer, DateTimeFormatter.BASIC_ISO_DATE);
                            namn = IO.readln("Ange namn: ");
                            if (namn == null || namn.isBlank())
                                throw new IllegalArgumentException("Namn får inte vara tomt");
                            break;
                        } catch (Exception e) {
                            IO.println("FEL: " + e.getMessage());
                        }
                    }

                    Kund kund = new Kund(namn, personnummer);
                    new Bokning(kund, valtFordon, platsIndex);
                    valtFordon.setPlats(platsIndex, true);

                    // TODOhantera om fordon inte finns
                    // Ange gitligt platsindex
                    // Skriv in personummer och namn kolla att de är gilitga
                    // skapa bokning
                    // ändrar i Fordon

                    break;

                case 2:
                    // DISPLAY lediga platser
                    IO.println("--- Visa plaster ---");
                    Fordon valtFordon2 = väljFordonsTyp();
                    visaPlatser(valtFordon2);
                    break;

                case 3:
                    // BERÄKNA VINST
                    // loopa igenom alla bokningar i bokningsregister
                    // bokning.fordon.getpris(bokning )
                    IO.println("--- Beräkna Vinst ---");
                    double summa = 0;
                    try {
                        String svar = IO.readln("Vill du beräkna total vinst eller specifik vinst (tot/spec): ");
                        switch (svar.toLowerCase()) {
                            case "tot":
                                for (Bokning bokning : BokningsRegister.getAllaBokninger()) {
                                    summa += bokning.getFordon().getPris(bokning);

                                    IO.println("summa: " + summa + " Bokning Kund: " + bokning.getKund()
                                            + " Bokning fordon: " + bokning.getFordon() + " Pris: "
                                            + bokning.getFordon().getPris(bokning));
                                }
                                summa = Math.floor(summa * 100) / 100;
                                IO.println("Total vinsten är: " + summa + " kr");
                                break;
                            case "spec":
                                Fordon valtFordon3 = väljFordonsTyp();
                                for (Bokning bokning : BokningsRegister.getAllaBokninger()) {
                                    if (bokning.getFordon() == valtFordon3) {
                                        summa += bokning.getFordon().getPris(bokning);
                                    }
                                }
                                break;
                            default:
                                throw new IllegalArgumentException("Ogiltigt Alternativ");
                        }
                    } catch (Exception e) {
                        IO.println("FEL: " + e.getMessage());
                    }

                    /*
                     * double summa = 0;
                     * for (Bokning bokning : BokningsRegister.getAllaBokninger()) {
                     * summa += bokning.getFordon().getPris(bokning);
                     * }
                     * IO.println("Total vinsten är: " + summa + " kr");
                     */

                    break;
                case 4:
                    // HITTA BOKNING
                    break;
                case 5:
                    // RADERA BOKNING
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

    private static Fordon väljFordonsTyp() {
        Fordon valtFordon = null;

        boolean giltigtFordon = false;
        while (!giltigtFordon) {
            String svar = IO.readln("Boka på Flyg/Buss/Tåg: ");
            try {
                switch (svar.toLowerCase().trim()) {
                    case "flyg":
                        /*
                         * TODO Välj mellan de specifika fordonen. Try catch integer förmodligen
                         * TODO Be om ny Fordonstyp om "alla" är tom
                         */
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

    private static Fordon väljFordon(Class<?> typ) {
        ArrayList<Fordon> alla = FordonRegister.getAllaTyp(typ);
        if (alla.isEmpty()) {
            IO.println("Inga Fordon finns av den typen");
            return null;
        } else {
            for (int i = 0; i < alla.size(); i++) {
                IO.println((i + 1) + ". " + alla.get(i).ID);
            }
            int fordonNr;
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
            return alla.get(fordonNr - 1);
        }
    }

    public static void visaPlatser(Fordon fordon) {
        if (fordon instanceof Buss) {
            IO.println("Bussen: " + fordon.ID);
            for (int row = 0; row < 5; row++) {
                String p1 = String.format("%2s", fordon.platser[row * 4]);
                String p2 = String.format("%2s", fordon.platser[row * 4 + 1]);
                String p3 = String.format("%2s", fordon.platser[row * 4 + 2]);
                String p4 = String.format("%2s", fordon.platser[row * 4 + 3]);

                System.out.printf("\t[%s][%s]   [%s][%s]\n", p1.replace(' ', '0'), p2.replace(' ', '0'),
                        p3.replace(' ', '0'), p4.replace(' ', '0'));
            }
        }

        else if (fordon instanceof Flyg) {
            IO.println("Flyget: " + fordon.ID);
            for (int row = 0; row < 9; row++) {
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
            IO.println("=========== K A B I N E R ===========");
            for (int row = 0; row < 6; row++) {
                String p1 = String.format("%2s", fordon.platser[row * 4]);
                String p2 = String.format("%2s", fordon.platser[row * 4 + 1]);
                String p3 = String.format("%2s", fordon.platser[row * 4 + 2]);
                String p4 = String.format("%2s", fordon.platser[row * 4 + 3]);

                System.out.printf("\t[%s][%s]   [%s][%s]\n", p1.replace(' ', '0'), p2.replace(' ', '0'),
                        p3.replace(' ', '0'), p4.replace(' ', '0'));
                if ((row -1) % 2 == 0 && row !=5) 
                    IO.println();
            }
            IO.println("=====================================");

            for (int row = 6; row < 15; row++) {
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