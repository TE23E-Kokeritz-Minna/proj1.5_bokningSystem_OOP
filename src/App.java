void main(){

/* 
    klasser
        Kund
        Bokning 
            Bil
            Flyg
            tåg
    
    array med alla passagerar 
    personummer (namn)?
    pris 
    visa grafiskt
    
    Meny 
        lägg till - välj fartyg 
        antal lediga platser - välj fartyg 
        beräkna vinst beroende på typ och pris - total vinst och seperat vins 
            hitta bokning (personummer eller namn) - kollar igenom alla 
            ta bort bokning - kollar igenom alla 
            skriv ut alla platser sorterat på ålder - skriver ut separerat på fartyg
*/
/// BUS - 20 passagerare Barn och Vuxen priser, hela menyn
/// FLYG - 50 passagerar, första klass normal priser, hela menyn 
/// Tåg - 100 passagerare, kabin sitt priser, hela menyn 

    //Buss bussTest = new Buss();

    //Kund k1 = new Kund();
    //Kund k2 = new Kund("Jim" ,"20031224", bussTest, 0);

 //   IO.println(k2 + " <- k2 || k1 -> " + k1);

    System.out.println("Hello, World!");

    int[] plats = new int[20];
    for (int i=0; i<20; i++) {
        plats[i]=i+1;
    }
    for (int row=0; row < 5; row++) {
        System.out.printf("\t[%02d][%02d]   [%02d][%02d]\n", 
        plats[row*4], plats[row*4+1], plats[row*4+2], plats[row*4+3]);
    }
//            System.out.printf();
    //Bokning.bokaTest(k2, bussTest);
  //  Bokning.visaPlatser(bussTest);

}
