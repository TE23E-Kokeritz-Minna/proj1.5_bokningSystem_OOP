void main() {

    /* 
        BUSS : 
            > 18  - 149.99 
            < 18  - 299.99  
        FLYG 
            1a    - 90000.0
            2a    - 699.99
        TÅG
            1a    - 999.99
            2a    - 195.99 
    */
    
    
    
    System.out.println("Hello, World!");
    // TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST
    Buss bussTest = new Buss("MysterieBussen");
    Flyg flygTest = new Flyg("Falcon", false);
    Flyg flygTest2 = new Flyg("Athena", true);
    Tåg tågTest = new Tåg("Thomas");
    Tåg tågTest2 = new Tåg("Polar express");

    Kund k1 = new Kund("Jim", "19530201");
    Kund k2 = new Kund("Elsa", "20231203");
    Kund k3 = new Kund("Zoey", "20250505");
    Kund k4 = new Kund("Karina", "15681230");
    Kund k5 = new Kund("Steve", "20010911");
    Kund k6 = new Kund("Elenore", "10661014");
    Kund k7 = new Kund("Willy", "16160423");
    Kund k8 = new Kund("Ariel", "19980503");
    

    Bokning bok1 = new Bokning(k1, bussTest, 3);
    Bokning bok2 = new Bokning(k4, flygTest, 0);
    Bokning bok3 = new Bokning(k2, bussTest, 5);
    Bokning bok4 = new Bokning(k3, flygTest2, 13);
    Bokning bok5 = new Bokning(k6, tågTest, 15);
    Bokning bok6 = new Bokning(k5, bussTest, 2);
    Bokning bok7 = new Bokning(k7, flygTest, 20);
    Bokning bok8 = new Bokning(k8, tågTest2, 1);

    bussTest.setPlats(0, true);
    bussTest.setPlats(12, true);

    // Programmet crashar inte av fel index
    flygTest.setPlats(50, true);
    flygTest.setPlats(30, true);
    flygTest.setPlats(12, true);
    flygTest.setPlats(0, true);

    //BokningSystem.Meny();

    BokningSystem.visaPlatser(tågTest2);
    BokningSystem.visaPlatser(flygTest);
    BokningSystem.visaPlatser(bussTest);
}
