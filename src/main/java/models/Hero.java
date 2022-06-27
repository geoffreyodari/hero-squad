package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;

    private ArrayList<Hero> mInstance = new ArrayList<>();

    public Hero(String name,int age,String power,String weakness){
        this.name =name;
        this.age =age;
        this.power =power;
        this.weakness = weakness;
        this.mInstance.add(this);
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getPower() {
        return power;
    }

    public String getWeakness() {
        return weakness;
    }

    public ArrayList getHero(){
        return mInstance;
    }

}
