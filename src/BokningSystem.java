import java.io.Console;
import java.time.LocalDate;

public class BokningSystem {

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
                    // DISPLAY lediga platser
                    break;

                case 3:
                    // BERÄKNA VINST
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

    public static void visaPlatser(Fordon fordon) {

        if (fordon instanceof Buss) {
            IO.println("Bussen: " + fordon.ID);
             for(int row = 0; row < 5; row++){    
                String p1 = String.format("%2s",fordon.platser[row*4]);
                String p2 = String.format("%2s",fordon.platser[row*4+1]);
                String p3 = String.format("%2s",fordon.platser[row*4+2]);
                String p4 = String.format("%2s",fordon.platser[row*4+3]);
                
                System.out.printf("\t[%s][%s]   [%s][%s]\n",p1.replace(' ', '0'),p2.replace(' ', '0'),p3.replace(' ', '0'), p4.replace(' ', '0'));
            } 
        }

        else if(fordon instanceof Flyg){
            IO.println("Flyget: " + fordon.ID);
              for(int row = 0; row < 9; row++){    
                String p1 = String.format("%2s", fordon.platser[row*6]);
                String p2 = String.format("%2s", fordon.platser[row*6+1]);
                String p3 = String.format("%2s", fordon.platser[row*6+2]);
                String p4 = String.format("%2s", fordon.platser[row*6+3]);
                String p5 = String.format("%2s", fordon.platser[row*6+4]);
                String p6 = String.format("%2s", fordon.platser[row*6+5]);
                
                System.out.printf("\t[%s][%s][%s]   [%s][%s][%s]\n", p1.replace(' ', '0'),p2.replace(' ', '0'),p3.replace(' ', '0'), p4.replace(' ', '0'), p5.replace(' ', '0'),p6.replace(' ', '0'));
            }
        }
        else if (fordon instanceof Tåg){
            IO.println("Det här är tåget "+ fordon.ID + ", TBC on proper displays");
        }
    }
}