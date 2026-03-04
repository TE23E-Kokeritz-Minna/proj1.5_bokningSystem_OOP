
import models.*;
import system.*;

void main() {

    /* * * * * START FORDON * * * * */
    // Syntax för nya: Typ namn = new Typ("namnID");
    Buss b1 = new Buss("MysterieBussen");
    Buss b2 = new Buss("KattBussen");
    Flyg f1 = new Flyg("Falcon");
    Flyg f2 = new Flyg("Athena");
    Tåg t1 = new Tåg("Thomas");
    Tåg t2 = new Tåg("Polar express");

    BokningSystem.Meny();
}
