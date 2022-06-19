package views2;

import models.GeneralNode;
import models.Production;
import views2.left.JLeftPanel;
import views2.right.JRightPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JMainPanel extends JPanel {

    private JLeftPanel jLeftPanel;
    private JRightPanel jRightPanel;

    public JMainPanel(ActionListener actionListener, MouseListener mouseListener) {
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout(0,0));
        initComponents(actionListener,mouseListener);
    }

    private void initComponents(ActionListener actionListener,MouseListener mouseListener) {
        jLeftPanel = new JLeftPanel(actionListener);
        this.add(jLeftPanel,BorderLayout.WEST);

        jRightPanel = new JRightPanel(actionListener,mouseListener);
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

}
