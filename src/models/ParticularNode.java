package models;

public class ParticularNode<T> {

    private T simbol;
    private ParticularNode<T> left;
    private ParticularNode<T> right;

    public ParticularNode(T simbol){
        this.simbol = simbol; 
    }

    public T getSimbol() {
        return simbol;
    }

    public void setSimbol(T simbol) {
        this.simbol = simbol;
    }

    public ParticularNode<T> getLeft() {
        return left;
    }

    public void setLeft(ParticularNode<T> left) {
        this.left = left;
    }

    public ParticularNode<T> getRight() {
        return right;
    }

    public void setRight(ParticularNode<T> right) {
        this.right = right;
    }

    public void addToBottom(ParticularNode<T> node){
        ParticularNode<T> actual = this;
        while (actual.right != null){
            actual = actual.right;
        }
        actual.right = node;
    }
    
}
