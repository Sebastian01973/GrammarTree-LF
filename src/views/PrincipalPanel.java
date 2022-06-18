package views;

import models.GeneralNode;
import models.ParticularNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class PrincipalPanel extends JPanel{
    
    private ParametersPanel parametersPanel;
    private PanelGeneralTree generalTreePanel;
    private PanelWordValidate panelWordValidate;

    public PrincipalPanel(ActionListener listener){
        setLayout(new BorderLayout());
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        JPanel panelLeft = new JPanel(new BorderLayout());
        panelLeft.setBackground(Color.WHITE);
        parametersPanel = new ParametersPanel(listener);
        panelLeft.add(parametersPanel, BorderLayout.NORTH);
        generalTreePanel = new PanelGeneralTree();
        panelLeft.add(generalTreePanel, BorderLayout.CENTER);
        add(panelLeft, BorderLayout.WEST);
        panelWordValidate = new PanelWordValidate(listener);
        add(panelWordValidate, BorderLayout.CENTER);
    }

    public void showGeneralTree(GeneralNode root, String grammarName){
        generalTreePanel.showTree(root,grammarName);
    }

    public String getGrammarName(){
        return parametersPanel.getGrammarName();
    }

    public String[] getSigma(){
        return parametersPanel.getSigma();
    }

    public String[] getNoTerminalSimbols(){
        return parametersPanel.getNoTerminalSimbols();
    }

    public String getAxiom(){
        return parametersPanel.getAxiom();
    }

    public void enableFields(){
        parametersPanel.enableFields();
    }

    public void deleteContentFields(){
        parametersPanel.deleteContentFields();
    }

    public String getWord(){
        return panelWordValidate.getWord();
    }

    public void showTree(ParticularNode root){
        panelWordValidate.showTree(root);
    }
}
