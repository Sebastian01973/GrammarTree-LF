package views2;

import models.GeneralNode;
import models.Production;
import views2.left.JLeftPanel;
import views2.right.JRightPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JMainPanel extends JPanel {

    private JLeftPanel jLeftPanel;
    private JRightPanel jRightPanel;

    public JMainPanel(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout(0,0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jLeftPanel = new JLeftPanel(actionListener);
        this.add(jLeftPanel,BorderLayout.WEST);

        jRightPanel = new JRightPanel(actionListener);
        this.add(jRightPanel,BorderLayout.CENTER);
    }

    public void showGeneralTree(GeneralNode root, String grammarName){
        jLeftPanel.showGeneralTree(root,grammarName);
    }

    public String getGrammarName(){
        return jRightPanel.getGrammarName();
    }

    public String[] getSigma(){
        return jRightPanel.getSigma();
    }

    public String[] getNoTerminalSimbols(){
        return jRightPanel.getNoTerminalSimbols();
    }

    public String getAxiom(){
        return jRightPanel.getAxiom();
    }

    public void enableFields(){
        jRightPanel.enableFields();
    }

    public void deleteContentFields(){
        jRightPanel.deleteContentFields();
    }

    public ArrayList<Production> getProductions(){
        return jRightPanel.getProductions();
    }

    public void enableProductions(){
        jRightPanel.enableProductions();
    }
    public void deleteProductions(){
        jRightPanel.deleteProductions();
    }

    public void deleteProductionField(){
        jRightPanel.deleteProductionField();
    }

    public void addProductionField(){
        jRightPanel.addProductionField();
    }

    public String getWord(){
        return jLeftPanel.getWord();
    }
    public void setVisibleWordValidate(boolean status){
        jLeftPanel.setVisibleWordValidate(status);
    }

    public void setVisibleSouthPanel(boolean status){
        jLeftPanel.setVisibleSouthPanel(status);
    }
    public void setWordValidate(String word,Color bg){
        jLeftPanel.setWordValidate(word,bg);
    }

}
