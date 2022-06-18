package models;

import java.util.ArrayList;

public class GeneralNode {

    private static int secuential;
    private int id;
    private Simbol simbol;
    private ArrayList<GeneralNode> childrenSimbol;

    public GeneralNode(Simbol simbol){
        this.id = secuential++;
        this.simbol = simbol;
        this.childrenSimbol = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public Simbol getSimbol() {
        return simbol;
    }

    public void setSimbol(Simbol simbol) {
        this.simbol = simbol;
    }

    public ArrayList<GeneralNode> getChildrenSimbol() {
        return childrenSimbol;
    }

    public void setChildrenSimbol(ArrayList<GeneralNode> childrenSimbol) {
        this.childrenSimbol = childrenSimbol;
    }

    public void addChild(GeneralNode child){
        this.childrenSimbol.add(child);
    }

    @Override
    public String toString() {
        return " simbol=" + simbol.getSimbol();
    }
}
