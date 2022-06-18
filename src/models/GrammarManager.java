package models;

import java.util.ArrayList;
import java.util.Arrays;

public class GrammarManager {
    
    private Grammar grammar;
    private GeneralNode generalRoot;
    private WordChecker checker;

    public GrammarManager(){

    }
// metodo que crea la gramática
    public void createGrammar(String grammarName, String[] noTerminalSimbols, String[] terminalSimbols, 
    String axiomSimbol, ArrayList<Production> productions){
        this.grammar = new Grammar(changeToList(noTerminalSimbols), changeToList(terminalSimbols), axiomSimbol);
        grammar.setGrammarName(grammarName);
        grammar.setProductions(productions);
        generateGeneralTree();
        checker = new WordChecker(grammar);
    }

// metodo que convierte la lista de palabras entrantes en arraylist
    public ArrayList<String> changeToList(String[] list){
        return new ArrayList<>(Arrays.asList(list));
    }

//  metodos para generar el arbol general de la gramática
    public void generateGeneralTree(){
        generalRoot = new GeneralNode(new AxiomSimbol(grammar.getAxiomSimbol()));
        addBranch(generalRoot,0);
    }

    public void addBranch(GeneralNode father, int level){
        if(level < 5){
            String simbols = father.getSimbol().getSimbol();
            for (int i = 0; i < simbols.length(); i++) {
                char simbol = simbols.charAt(i);
                if(isNoTerminal(simbol)){
                    addWordsToFather(father, simbols, i, simbol);
                    break;
                }
            }
            level++;
            for (GeneralNode childSimbol : father.getChildrenSimbol()) {
                addBranch(childSimbol,level);
            }
        }
    }

    private void addWordsToFather(GeneralNode father, String simbols, int i, char simbol) {
        ArrayList<String> simbolsProductions = searchProduction(String.valueOf(simbol));
        for (String string : simbolsProductions) {
            father.addChild(new GeneralNode(new WordSimbol(formatWord(simbols,string,i))));
        }
    }

    private String formatWord(String simbols, String production, int simbolPosition){
        String word = "";
        for (int i = 0; i < simbols.length(); i++) {
            char simbol = simbols.charAt(i);
            if(i == simbolPosition){
                word += production;
            }else{
                word += simbol;
            }
        }
        return word;
    }

    // Métodos que valida si un simbolo es o no terminal
    private boolean isNoTerminal(char character){
        return grammar.getNoTerminalSimbols().contains(String.valueOf(character));
    }

    private boolean isTerminal(char character){
        return grammar.getNoTerminalSimbols().contains(String.valueOf(character));
    }
    
    //método que busca una producción dentro de la lista de producciones de la gramatica 
    public ArrayList<String> searchProduction(String noTerminalSimbol){
        ArrayList<String> simbolsProductions =  new ArrayList<>();
        ArrayList<Production> productions =  grammar.getProductions();
        for (Production production : productions) {
            if(noTerminalSimbol.equals(production.getNoTerminalSimbol())){
                simbolsProductions.add(production.getProduction());
            }
        }
        return simbolsProductions;
    }

    public ArrayList<Production> searchProductionsGrammar(String noTerminalSimbol){
        ArrayList<Production> productionsList =  new ArrayList<>();
        ArrayList<Production> productions =  grammar.getProductions();
        for (Production production : productions) {
            if(noTerminalSimbol.equals(production.getNoTerminalSimbol())){
                productionsList.add(production);
            }
        }
        return productionsList;
    }
    
    public void searchSimbol(ParticularNode<Simbol> node, int iterator, String word){
        if(iterator < word.length()){
            String simbol = node.getSimbol().getSimbol();
            ArrayList<String> simbolsProductions = searchProduction(simbol);
            for (String string : simbolsProductions) {
                for (int i = 0; i < string.length(); i++) {
                    if(word.charAt(iterator) == string.charAt(i)){

                    }
                }
            }
        }
    }

    public void searchSimbolProduction(String production, int iterator, String word){
        for (int i = 0; i < production.length(); i++) {
            if(isNoTerminal(production.charAt(i))){

            }
        }
    }

    public void print(){
        System.out.println("Simbolos no terminales-------");
        ArrayList<String> simbolListOne = grammar.getNoTerminalSimbols();
        for (String string : simbolListOne) {
            System.out.println(string);
        }
        System.out.println("Simbolos terminales--------");
        ArrayList<String> simbolListTwo = grammar.getTerminalSimbols();
        for (String string : simbolListTwo) {
            System.out.println(string);
        }
        System.out.println("Axioma---------");
        System.out.println(grammar.getAxiomSimbol());
        ArrayList<Production> productions = grammar.getProductions();
        for (Production production : productions) {
            System.out.println(production);
        }
    }

    public void printTree(){
        printNode(generalRoot,1,-1);
    }

    public void printNode(GeneralNode node, int level, int fatherId){
        System.out.println(node + " - FatherId=" + fatherId + " - level=" +level);
        level++;
        for (GeneralNode child: node.getChildrenSimbol()) {
            printNode(child, level, node.getId());
        }
    }

    public GeneralNode getGeneralRoot(){
        return generalRoot;
    }

    public ParticularNode<Simbol> getParticularRoot(String word){
        return checker.getTreeWord(word);
    }

    public String getGrammarName(){
        return grammar.getGrammarName();
    }
}
