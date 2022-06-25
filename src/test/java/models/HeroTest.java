package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTest {

    @Test
    public void hero_testClassInstantiatesCorrectly(){
        Hero newHero = new Hero("geoffrey",40,"flying","none");
        assertTrue(newHero instanceof Hero);
    }


}
