package views2.right;

import controllers.Commands;
import views.PanelTextFields;
import views.ParametersPanel;
import views2.Constant;
import views2.models.JModelLabel;
import views2.models.JModelTextField;
import views2.models.PanelTextFields2;
import views2.models.RoundedJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPRCreateProduction extends JPanel {

    private JModelTextField noTerminalSimbol;
    private JModelTextField production;
    public JPRCreateProduction(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        JPanel labelProduction = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelProduction.setBackground(Constant.COLOR_WHITE);
        JModelLabel production = new JModelLabel("Producciones",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        production.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        production.setColorPaint(Constant.COLOR_WHITE);
        labelProduction.add(production);
        this.add(labelProduction);

        JPanel createProduction = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelProduction.setBackground(Constant.COLOR_WHITE);
        addFields(actionListener);
    }

    private void addFields(ActionListener actionListener){
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBackground(Constant.COLOR_WHITE);

        noTerminalSimbol = new JModelTextField("Variable",Constant.FIELDS_FONT,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);
        noTerminalSimbol.setColumns(10);
        p.add(noTerminalSimbol);

        p.add(Box.createRigidArea(new Dimension(10,0)));

        JLabel arrow = new JLabel("→");
        arrow.setFont(ParametersPanel.PARAMETERS_FONT);
        p.add(arrow);

        p.add(Box.createRigidArea(new Dimension(10,0)));

        production = new JModelTextField("Alfabeto",Constant.FIELDS_FONT,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);
        production.setColumns(10);
        p.add(production);

        p.add(Box.createRigidArea(new Dimension(40,0)));

        RoundedJButton buttonAddProduction = new RoundedJButton("Agregar", Commands.ADD_PRODUCION.toString(),actionListener,Constant.COLOR_GREEN_1,Constant.COLOR_WHITE);
        buttonAddProduction.setFont(Constant.FIELDS_FONT);

        p.add(buttonAddProduction);

        p.add(Box.createRigidArea(new Dimension(20,0)));

        RoundedJButton buttonDeleteProduction = new RoundedJButton("Eliminar", Commands.DELETE_PRODUCION.toString(),actionListener,Constant.COLOR_RED_LIGHT_1,Constant.COLOR_WHITE);
        buttonDeleteProduction.setFont(Constant.FIELDS_FONT);

        p.add(buttonDeleteProduction);

        this.add(p);
    }
}
