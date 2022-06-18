package models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class WordChecker {

    private Grammar grammar;

    public WordChecker(Grammar grammar) {
        this.grammar = grammar;
    }

    public ParticularNode<Simbol> getTreeWord(String word){
        System.out.println("word = " + word);
        System.out.println(checkWord(word));
        return getTree(checkWord(word));
    }

    private ParticularNode<Simbol> getTree(ParticularNode<Production> language){
        if (language != null) {
            ParticularNode<Simbol> tree = new ParticularNode<>(new AxiomSimbol(language.getSimbol().getNoTerminalSimbol()));
            ParticularNode<Simbol> next = tree;
            while (language != null){
                NoTerminalSimbol noTerminalSimbol = new NoTerminalSimbol(language.getSimbol().getNoTerminalSimbol());
                TerminalSimbol terminalSimbol = new TerminalSimbol(language.getSimbol().getProduction());
                next.setRight(new ParticularNode<>(noTerminalSimbol));
                next.setLeft(new ParticularNode<>(terminalSimbol));
                next = next.getRight();
                language = language.getRight();
            }
            return tree;
        }
        return null;
    }

    /**
     * Valida si la palabra ingresada se encuentra en el lenguake construido por la
     * gramática
     * @param word
     * @return
     */
    private ParticularNode<Production> checkWord(String word){
        //Construye el lenguaje desde el simbolo axiomático de la gramática
        ParticularNode<Production> language = new ParticularNode<>(grammar.getProductions().get(0));

        String actualNonTerminal = grammar.getAxiomSimbol();
        ArrayList<Production> actualProductions = getProductions(actualNonTerminal);
        for (int i = 0; i < word.length(); i++) {
            if (i + 1 == word.length()){//Verifica si es el último caracter de la palabra
                Production production = getTerminalProduction(""+word.charAt(i), actualProductions);
                if (production != null) {//La palabra pertenece al lenguaje
                    language.addToBottom(new ParticularNode<>(production));
                    return language;
                }
            }else {
                Production production = getNonTerminalProductions(actualNonTerminal, actualProductions);
                //el simbolo no pertenece al lenguaje
                System.out.println("(production == null) = " + (production == null));
                if (production == null)  return null;
                language.addToBottom(new ParticularNode<>(production));
                actualNonTerminal = production.getNoTerminalSimbol();
                actualProductions = getProductions(actualNonTerminal);
            }
        }
        return null;
    }

    /**
     * Obtiene las producciones cuyo simbolo no terminal es igual
     * al simbolo no terminal especificado
     * @param nonTerminalSymbol
     * @return
     */
    private ArrayList<Production> getProductions(String nonTerminalSymbol){
        return (ArrayList<Production>) grammar.getProductions().stream()
                .filter(p -> p.getNoTerminalSimbol().equals(nonTerminalSymbol))
                .collect(Collectors.toList());
    }

    private Production getNonTerminalProductions(String symbol, ArrayList<Production> productions) {
        for (Production p: productions) {
            String production = p.getProduction();
            if (!production.equals(production.toLowerCase())){
                if (p.getProduction().equals(symbol)){
                    return p;
                }
            }
        }
        return null;
    }

    private Production getTerminalProduction(String symbol, ArrayList<Production> productions){
        for (Production p: productions) {
            String production = p.getProduction();
            if (production.equals(production.toLowerCase())){
                if (p.getProduction().equals(symbol)){
                    return p;
                }
            }
        }
        return null;
    }
}
