package views2.right;

import views2.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class JRBody extends JPanel{

    JPRProduction jprProduction;
    JPRCreateProduction jprCreateProduction;
    public JRBody(ActionListener actionListener, MouseListener mouseListener) {
        this.setLayout(new BorderLayout(0,0));
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener,mouseListener);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        jprCreateProduction = new JPRCreateProduction(actionListener);
        this.add(jprCreateProduction,BorderLayout.NORTH);

        jprProduction = new JPRProduction(mouseListener);
        this.add(jprProduction,BorderLayout.CENTER);
    }


}
