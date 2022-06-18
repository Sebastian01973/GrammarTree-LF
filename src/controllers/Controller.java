package controllers;

import models.GrammarManager;
import views.PrincipalFrame;
import views.ProductionsDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Pruebas con el branch Develop
public class Controller implements ActionListener{

    private GrammarManager manager;
    private PrincipalFrame frame;
    private ProductionsDialog productionsDialog;

    public Controller(){
        manager = new GrammarManager();
        frame = new PrincipalFrame(this);
        productionsDialog = new ProductionsDialog(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())) {
            case ADD_PRODUCTIONS:
                productionsDialog.openDialog(frame);
                break;
            case ADD_GRAMMAR:
                createAndAddGrammar();
                break;
            case ACEPT_PRODUCTION:
                productionsDialog.setVisible(false);
                break;
            case DELETE_GRAMMAR:
                deleteParameters();
                break;
            case EDIT_GRAMMAR:
                editParameters();
                break;
            case ADD_PRODUCION:
                productionsDialog.addProductionField();
                break;
            case DELETE_PRODUCION:
                productionsDialog.deleteProductionField();
                break;
            case VALIDATE_WORD:
                validateWordOnGrammar();
                break;
        }
    }
    
    private void createAndAddGrammar(){
        manager.createGrammar(frame.getGrammarName(),frame.getNoTerminalSimbols(),frame.getSigma(), 
        frame.getAxiom(),productionsDialog.getProductions());

        frame.showGeneralTree(manager.getGeneralRoot(),manager.getGrammarName());
    }

    private void editParameters(){
        frame.enableFields();
        productionsDialog.enableProductions();
    }

    private void deleteParameters(){
        frame.deleteContentFields();
        productionsDialog.deleteProductions();
    }

    private void validateWordOnGrammar(){
        String word = frame.getWord();
        frame.showTree(manager.getParticularRoot(word));
    }

    public static void main(String[] args) {
        new Controller();
    }
}
