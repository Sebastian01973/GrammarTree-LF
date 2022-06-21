package views2.left;

import models.GeneralNode;
import views2.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JLeftPanel extends JPanel {

    private JLNorthPanel jLeftNorthPanel;
    private JLSouthPanel jLeftSouthPanel;
    private JLGeneralTree jlGeneralTree;

    public JLeftPanel(ActionListener actionListener) {
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Constant.COLOR_WHITE);
        this.setBorder(null);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jLeftNorthPanel = new JLNorthPanel(actionListener);
        this.add(jLeftNorthPanel,BorderLayout.NORTH);

        jlGeneralTree = new JLGeneralTree();
        this.add(jlGeneralTree,BorderLayout.CENTER);

        jLeftSouthPanel = new JLSouthPanel();
        this.add(jLeftSouthPanel,BorderLayout.SOUTH);

    }

    public void showGeneralTree(GeneralNode root, String grammarName){
        jlGeneralTree.showTree(root,grammarName);
    }

    public String getWord(){
        return jLeftNorthPanel.getWord();
    }

    public void setVisibleWordValidate(boolean status){
        jLeftNorthPanel.setVisibleWordValidate(status);
    }

    public void setVisibleSouthPanel(boolean status){
        jLeftSouthPanel.setVisibleSouthPanel(status);
    }

    public void setWordValidate(String word,Color bg){
        jLeftSouthPanel.setWordValidate(word,bg);
    }

}
