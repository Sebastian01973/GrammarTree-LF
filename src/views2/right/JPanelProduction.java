package views2.right;

import views2.Constant;
import views2.models.JModelTextField;

import javax.swing.*;
import java.awt.*;

public class JPanelProduction extends JPanel {

    private JModelTextField noTerminalSimbol;
    private JModelTextField production;
    public JPanelProduction() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        initComponents();
    }

    private void initComponents() {
        addFields();
    }

    private void addFields(){
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBackground(Constant.COLOR_WHITE);

        noTerminalSimbol = new JModelTextField("Variable",Constant.FIELDS_FONT,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);
        noTerminalSimbol.setColumns(10);
        p.add(noTerminalSimbol);

        p.add(Box.createRigidArea(new Dimension(10,0)));

        JLabel arrow = new JLabel("→");
        arrow.setFont(Constant.FIELDS_FONT);
        p.add(arrow);

        p.add(Box.createRigidArea(new Dimension(10,0)));

        production = new JModelTextField("Alfabeto",Constant.FIELDS_FONT,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);
        production.setColumns(10);
        p.add(production);

        p.add(Box.createRigidArea(new Dimension(40,0)));

        this.add(p);
    }

    public String getNoTerminalSimbol() {
        noTerminalSimbol.setEnabled(false);
        noTerminalSimbol.setDisabledTextColor(Constant.DISABLE_COLOR);
        noTerminalSimbol.setBackground(Color.WHITE);
        return noTerminalSimbol.getText();
    }

    public String getProduction() {
        production.setEnabled(false);
        production.setDisabledTextColor(Constant.DISABLE_COLOR);
        production.setBackground(Color.WHITE);
        return production.getText();
    }

    public void enableTextFields(){
        noTerminalSimbol.setBackground(Constant.COLOR_TEXT_FIELD);
        noTerminalSimbol.setEnabled(true);
        production.setBackground(Constant.COLOR_TEXT_FIELD);
        production.setEnabled(true);
    }

    public void deleteContentTextFields(){
        noTerminalSimbol.setText("");
        noTerminalSimbol.setBackground(Constant.COLOR_TEXT_FIELD);
        noTerminalSimbol.setEnabled(true);
        production.setText("");
        production.setBackground(Constant.COLOR_TEXT_FIELD);
        production.setEnabled(true);
    }
}
