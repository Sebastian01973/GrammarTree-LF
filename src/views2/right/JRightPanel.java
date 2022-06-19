package views2.right;

import views2.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class JRightPanel extends JPanel {

    private JRHeader jrHeader;
    private JRBody jrBody;
    private JRFooter jrFooter;

    public JRightPanel(ActionListener actionListener, MouseListener mouseListener) {
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout(0,0));
        this.setOpaque(true);
        initComponents(actionListener,mouseListener);

    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        jrHeader = new JRHeader();
        this.add(jrHeader,BorderLayout.NORTH);

        jrBody = new JRBody(actionListener,mouseListener);
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


}
