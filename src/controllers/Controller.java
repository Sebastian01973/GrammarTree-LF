package controllers;

import models.GrammarManager;
import views2.Constant;
import views2.JMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{

    private GrammarManager manager;
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
        System.out.println("Crear");
        manager.createGrammar(jMainFrame.getGrammarName(),jMainFrame.getNoTerminalSimbols(),jMainFrame.getSigma(),
                jMainFrame.getAxiom(),jMainFrame.getProductions()); // Ojo producciones
        jMainFrame.showGeneralTree(manager.getGeneralRoot(),manager.getGrammarName());
        jMainFrame.setVisibleWordValidate(true);

    }

    private void editParameters(){
        System.out.println("Editar");
        jMainFrame.enableFields();
        jMainFrame.enableProductions();
    }

    private void deleteParameters(){
        System.out.println("eliminar");
        jMainFrame.deleteContentFields();
        jMainFrame.deleteProductions();
    }

    private void validateWordOnGrammar(){
        System.out.println("Validar Palabra");
        String word = jMainFrame.getWord();
        jMainFrame.setVisibleSouthPanel(true);
        jMainFrame.setWordValidate(Constant.WORD_VALIDATE,Constant.COLOR_GREEN_1);
    }
}
