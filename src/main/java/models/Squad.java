package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Squad {

    private int id;
    private String name;
    private String cause;
    private int size;

    private static ArrayList<Squad> mInstances = new ArrayList();
    private  List<Hero> mHero = new ArrayList<Hero>(this.size);

    public Squad(String name, String cause , int size){
        this.name = name;
        this.cause = cause;
        this.size = size;
        this.mInstances.add(this);
        this.id = mInstances.size();


    }


    @Override
    public boolean equals(Object o){
        if(this ==o) return true;
        if(!(o instanceof Squad))return false;
        Squad squad = (Squad) o;
        return  getName()  == squad.getName()&&
                getCause() == squad.getCause()&&
                getSize()  == squad.getSize()&&
                Objects.equals(mHero , squad.mHero);

    }

    public int getSize() {
        return size;
    }

    public String getCause() {
        return cause;
    }

    public String getName() {
        return name;
    }


    public void addHero(Hero hero){
        try{
            mHero.add(hero);
        }catch(Exception e){
            System.out.println("You can not have more than "+this.size+" heroes in this squad");
        }
    }

    public List getHeroes(){
        return mHero;
    }


}
