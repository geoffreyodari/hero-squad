package models;

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



}
