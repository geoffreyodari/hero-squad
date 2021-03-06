package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquadTest {

    @Test
    public void test_SquadClassInstantiatesCorrectly(){
        Squad newSquad = new Squad("Avengers","Fight Crime",5);
        assertTrue(newSquad instanceof Squad);
    }

    @Test
    public void test_SquadClassGetName(){
        String name = "Avengers";
        Squad newSquad = new Squad("Avengers","Fight Crime",5);
        assertEquals(name,newSquad.getName());

    }

    @Test
    public void test_SquadClassGetCause(){
        String cause = "Fight Crime";
        Squad newSquad = new Squad("Avengers","Fight Crime",5);
        assertEquals(cause,newSquad.getCause());
    }

    @Test
    public void test_SquadClassGetSize(){
        int size = 1;
        Squad newSquad = new Squad("Avengers","Fight Crime",1);
        assertEquals(size,newSquad.getSize());
    }


    @Test
    public void test_HeroCanBeAddedToSquad(){
        Squad newSquad = new Squad("Avengers","Fight Crime",4);
        Hero newHero = new Hero("Jims",40,"Swimming","Singing");
        newSquad.addHero(newHero);
        assertTrue(newSquad.getMembers().equals(newHero.getHero()));

    }

    @Test
    public void test_DuplicateHeroCannotBeAddedToSquad(){
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
        Squad mySquad2 = new Squad("Avengers","Fight Crime",5);
        Hero firstHero = new Hero("James",40,"Swimming","Singing");
        Hero secondHero = new Hero("James",41,"Swimming","Singing");
        mySquad2.addHero(firstHero);
        mySquad2.addHero(secondHero);
        },"The hero already Exists!");

    }
    @Test
    public void test_ThrowsExceptionHeroCannotBeAddedToFullSquad(){
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            Squad mySquad = new Squad("Avengers","Fight Crime",1);
            Hero firstHero = new Hero("James",40,"Swimming","Singing");
            Hero secondHero = new Hero("Jack",40,"Swimming","Singing");
            mySquad.addHero(firstHero);
            mySquad.addHero(secondHero);
        },"You cannot add hero to a full squad!");
    }






}
