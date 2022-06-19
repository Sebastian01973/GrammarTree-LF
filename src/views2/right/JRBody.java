package views2.right;

import controllers.Commands;
import models.Production;
import views2.Constant;
import views2.models.JModelLabel;
import views2.models.RoundedJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JRBody extends JPanel{

    JProductions jProduction;

    JPanel panelNorth;
    public JRBody(ActionListener actionListener, MouseListener mouseListener) {
        this.setLayout(new BorderLayout(0,0));
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener,mouseListener);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        panelNorth = new JPanel();
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
        panelNorth.setBorder(BorderFactory.createEmptyBorder(5,5,25,5));
        panelNorth.setBackground(Constant.COLOR_WHITE);
        addBottonsPanel(actionListener);
        this.add(panelNorth,BorderLayout.NORTH);

        jProduction = new JProductions(mouseListener);
        this.add(jProduction,BorderLayout.CENTER);
    }

    private void addBottonsPanel(ActionListener actionListener) {

        JPanel labelProduction = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelProduction.setBackground(Constant.COLOR_WHITE);
        JModelLabel production = new JModelLabel("Producciones",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        production.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        production.setColorPaint(Constant.COLOR_WHITE);
        labelProduction.add(production);
        panelNorth.add(labelProduction);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.setBackground(Constant.COLOR_WHITE);

        RoundedJButton buttonAddProduction = new RoundedJButton("Agregar", Commands.ADD_PRODUCION.toString(),actionListener,Constant.COLOR_GREEN_1,Constant.COLOR_WHITE);
        buttonAddProduction.setFont(Constant.FIELDS_FONT);

        p.add(buttonAddProduction);

        p.add(Box.createRigidArea(new Dimension(80,0)));

        RoundedJButton buttonDeleteProduction = new RoundedJButton("Eliminar", Commands.DELETE_PRODUCION.toString(),actionListener,Constant.COLOR_RED_LIGHT_1,Constant.COLOR_WHITE);
        buttonDeleteProduction.setFont(Constant.FIELDS_FONT);

        p.add(buttonDeleteProduction);

        panelNorth.add(p);

    }

    public ArrayList<Production> getProductions(){
        return jProduction.getProductions();
    }

    public void enableProductions(){
        jProduction.enableProductions();
    }
    public void deleteProductions(){
        jProduction.deleteProductions();
    }

    public void deleteProductionField(){
        jProduction.deleteProductionField();
    }

    public void addProductionField(){
        jProduction.addProductionField();
    }

}
