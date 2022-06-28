package models;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Hero))return false;
        Hero hero = (Hero) o;
        return  getName() == hero.getName()&&
                getAge() == hero.getAge()&&
                getPower() == hero.getPower()&&
                Objects.equals(getWeakness(),hero.getWeakness());

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
