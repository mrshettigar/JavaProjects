package person;

import static person.HairColor.*;

public class Person {

    HairColor hairColor= BLACK;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Person peterParker = new Person();
        Person spiderMan = peterParker;
        
        peterParker.hairColor = PINK;
        System.out.println("Hair color of Peter Parker: " + peterParker.hairColor);
        System.out.println("Hair color of Spiderman: "+ spiderMan.hairColor);
    }
    
}
