package controllers;

import models.GrammarManager;
import views.PrincipalFrame;
import views.ProductionsDialog;
import views2.JMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener{

    private GrammarManager manager;
    private PrincipalFrame frame;
    private JMainFrame jMainFrame;

    public Controller(){
        manager = new GrammarManager();

        jMainFrame = new JMainFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())) {

            case ADD_GRAMMAR:
                createAndAddGrammar();
                break;
            case DELETE_GRAMMAR:
                deleteParameters();
                break;
            case EDIT_GRAMMAR:
                editParameters();
                break;
            case ADD_PRODUCION:
                //News
                jMainFrame.addProductionField();
                break;
            case DELETE_PRODUCION:
                //News
                jMainFrame.deleteProductionField();
                break;
            case VALIDATE_WORD:
                validateWordOnGrammar();
                break;
        }
    }
    
    private void createAndAddGrammar(){

        //News
        System.out.println("Crear");
        manager.createGrammar(jMainFrame.getGrammarName(),jMainFrame.getNoTerminalSimbols(),jMainFrame.getSigma(),
                jMainFrame.getAxiom(),jMainFrame.getProductions()); // Ojo producciones
        jMainFrame.showGeneralTree(manager.getGeneralRoot(),manager.getGrammarName());

    }

    private void editParameters(){
        System.out.println("Editar");

        //News
        jMainFrame.enableFields();
        jMainFrame.enableProductions();
    }

    private void deleteParameters(){
        System.out.println("eliminar");
        //News
        jMainFrame.deleteContentFields();
        jMainFrame.deleteProductions();
    }

    private void validateWordOnGrammar(){
        //To do...
        String word = frame.getWord();
        frame.showTree(manager.getParticularRoot(word));
    }

}
