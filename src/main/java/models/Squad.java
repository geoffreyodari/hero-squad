package models;

public class Squad {
    private String name;
    private String cause;
    private int size;



    public Squad(String name, String cause , int size){
        this.name = name;
        this.cause = cause;
        this.size = size;

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
}
