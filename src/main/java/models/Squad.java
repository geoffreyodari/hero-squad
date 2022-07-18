package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {

    private int id;
    private String name;
    private String cause;
    private int size;
    private static int squadSize = 0 ;

    private static ArrayList<Squad> mInstances = new ArrayList();
    private  ArrayList<Hero> members = new ArrayList<Hero>();

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
                members.equals(squad.getMembers());

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


    public Boolean addHero(Hero hero){
        if (squadSize >= size){
            throw new UnsupportedOperationException("You cannot add heroes to a full squad!");
        }

        if (this.heroExists(hero)){
           return false;
        }

        this.members.add(hero);

        squadSize++;
        return true;
    }



    public Boolean heroExists(Hero hero){
        Boolean exists = false;
        for(Squad mySquad : this.mInstances){
            for( Hero hero1 : mySquad.members){
                exists = hero1.getName().equals(hero.getName());
            }
        }
        return exists;
    }



    public List getMembers(){
        return this.members;
    }




}
