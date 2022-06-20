package views2;

import models.GeneralNode;
import models.Production;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JMainFrame extends JFrame {

    private JMainPanel jMainPanel;

    public JMainFrame(ActionListener actionListener) {
        this.setIconImage( new ImageIcon(getClass().getResource( Constant.LOGO_PATH)).getImage());
        this.setTitle( Constant.TITLE );
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(Constant.SCREEN_SIZE);
        this.getContentPane().setBackground(Constant.COLOR_WHITE);
        this.getContentPane().setLayout(new BorderLayout(0,0));
        initComponents(actionListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener) {
        jMainPanel = new JMainPanel(actionListener);

        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
    }

    public void showGeneralTree(GeneralNode root, String grammarName){
        jMainPanel.showGeneralTree(root,grammarName);
    }

    public String getGrammarName(){
        return jMainPanel.getGrammarName();
    }

    public String[] getSigma(){
        return jMainPanel.getSigma();
    }

    public String[] getNoTerminalSimbols(){
        return jMainPanel.getNoTerminalSimbols();
    }

    public String getAxiom(){
        return jMainPanel.getAxiom();
    }

    public void enableFields(){
        jMainPanel.enableFields();
    }

    public void deleteContentFields(){
        jMainPanel.deleteContentFields();
    }

    public ArrayList<Production> getProductions(){
        return jMainPanel.getProductions();
    }

    public void enableProductions(){
        jMainPanel.enableProductions();
    }
    public void deleteProductions(){
        jMainPanel.deleteProductions();
    }

    public void deleteProductionField(){
        jMainPanel.deleteProductionField();
    }

    public void addProductionField(){
        jMainPanel.addProductionField();
    }

    public String getWord(){
        return jMainPanel.getWord();
    }

    public void setVisibleWordValidate(boolean status){
        jMainPanel.setVisibleWordValidate(status);
    }
    public void setVisibleSouthPanel(boolean status){
        jMainPanel.setVisibleSouthPanel(status);
    }

    public void setWordValidate(String word,Color bg){
        jMainPanel.setWordValidate(word,bg);
    }
}
