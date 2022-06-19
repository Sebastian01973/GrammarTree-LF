package controllers;

import models.GrammarManager;
import views.PrincipalFrame;
import views.ProductionsDialog;
import views2.JMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener {

    private GrammarManager manager;
    //Update views
    private PrincipalFrame frame;
    private ProductionsDialog productionsDialog;

    private JMainFrame jMainFrame;

    public Controller(){
        manager = new GrammarManager();
        frame = new PrincipalFrame(this);
        jMainFrame = new JMainFrame(this,this);
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
                //News
                jMainFrame.addProductionField();
                break;
            case DELETE_PRODUCION:
                productionsDialog.deleteProductionField();
                //News
                jMainFrame.deleteProductionField();
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

        //News
        System.out.println("Crear");
        manager.createGrammar(jMainFrame.getGrammarName(),jMainFrame.getNoTerminalSimbols(),jMainFrame.getSigma(),
                jMainFrame.getAxiom(),jMainFrame.getProductions()); // Ojo producciones
        jMainFrame.showGeneralTree(manager.getGeneralRoot(),manager.getGrammarName());

    }

    private void editParameters(){
        System.out.println("Editar");
        frame.enableFields();
        productionsDialog.enableProductions();

        //News
        jMainFrame.enableFields();
        jMainFrame.enableProductions();
    }

    private void deleteParameters(){
        System.out.println("eliminar");
        frame.deleteContentFields();
        productionsDialog.deleteProductions();

        //News
        jMainFrame.deleteContentFields();
        jMainFrame.deleteProductions();
    }

    private void validateWordOnGrammar(){
        //To do...
        String word = frame.getWord();
        frame.showTree(manager.getParticularRoot(word));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
