package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class HeroTest {

    @Test
    public void hero_testClassInstantiatesCorrectly(){
        Hero newHero = new Hero("geoffrey",40,"flying","none");
        assertTrue(newHero instanceof Hero);
    }


    @Test
    public void hero_testGetsName(){
        String name = "James";
        Hero newHero = new Hero("James",40,"flying","none");
        assertEquals(name,newHero.getName());
    }

    @Test
    public void hero_testGetsAge(){
        int age = 20;
        Hero newHero = new Hero("James",20,"flying","none");
        assertEquals(age,newHero.getAge());
    }
    @Test
    public void hero_testGetsPower(){
        String power = "Swimming";
        Hero newHero = new Hero("James",40,"Swimming","none");
        assertEquals(power,newHero.getPower());
    }
    @Test
    public void hero_testGetWeakness(){
        String weakness = "darkness";
        Hero newHero = new Hero("James",40,"flying","darkness");
        assertEquals(weakness,newHero.getWeakness());
    }

    



}
