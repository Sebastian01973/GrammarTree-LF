package views2.right;

import models.Production;
import views2.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JRightPanel extends JPanel {

    private JRHeader jrHeader;
    private JRBody jrBody;
    private JRFooter jrFooter;

    public JRightPanel(ActionListener actionListener) {
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout(0,0));
        this.setOpaque(true);
        initComponents(actionListener);

    }

    private void initComponents(ActionListener actionListener) {
        jrHeader = new JRHeader();
        this.add(jrHeader,BorderLayout.NORTH);

        jrBody = new JRBody(actionListener);
        this.add(jrBody,BorderLayout.CENTER);

        jrFooter = new JRFooter(actionListener);
        this.add(jrFooter,BorderLayout.SOUTH);

    }
    public String getGrammarName(){
        return jrHeader.getGrammarName();
    }

    public String[] getSigma(){
        return jrHeader.getSigma();
    }

    public String[] getNoTerminalSimbols(){
        return jrHeader.getNoTerminalSimbols();
    }

    public String getAxiom(){
        return jrHeader.getAxiom();
    }

    public void enableFields(){
        jrHeader.enableFields();
    }

    public void deleteContentFields(){
        jrHeader.deleteContentFields();
    }

    public ArrayList<Production> getProductions(){
        return jrBody.getProductions();
    }

    public void enableProductions(){
        jrBody.enableProductions();
    }
    public void deleteProductions(){
        jrBody.deleteProductions();
    }

    public void deleteProductionField(){
        jrBody.deleteProductionField();
    }

    public void addProductionField(){
        jrBody.addProductionField();
    }

}
