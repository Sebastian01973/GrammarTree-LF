package views2;

import controllers.Controller;
import models.GeneralNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class JMainFrame extends JFrame {

    private JMainPanel jMainPanel;

    public JMainFrame(ActionListener actionListener, MouseListener mouseListener) {
        this.setIconImage( new ImageIcon(getClass().getResource( Constant.LOGO_PATH)).getImage());
        this.setTitle( Constant.TITLE );
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(Constant.SCREEN_SIZE);
        this.getContentPane().setBackground(Constant.COLOR_WHITE);
        this.getContentPane().setLayout(new BorderLayout(0,0));
        initComponents(actionListener,mouseListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        jMainPanel = new JMainPanel(actionListener,mouseListener);

        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
    }

    public void showGeneralTree(GeneralNode root, String grammarName){
        jMainPanel.showGeneralTree(root,grammarName);
    }
}
