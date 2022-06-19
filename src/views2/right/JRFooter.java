package views2.right;

import controllers.Commands;
import views.Buttons;
import views2.Constant;
import views2.models.RoundedJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JRFooter extends JPanel {


    public JRFooter(ActionListener actionListener) {
        this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        RoundedJButton buttonGenerate = new RoundedJButton("Generar",Commands.ADD_GRAMMAR.toString(),actionListener,Constant.COLOR_ORANGE_1,Constant.COLOR_WHITE);
        buttonGenerate.setFont(Constant.FONT_ARIAL_ROUNDER_20);
        this.add(buttonGenerate);

        add(Box.createRigidArea(new Dimension(30,0)));

        RoundedJButton buttonEdit = new RoundedJButton("Editar",Commands.EDIT_GRAMMAR.toString(),actionListener,Constant.COLOR_ORANGE_1,Constant.COLOR_WHITE);
        buttonEdit.setFont(Constant.FONT_ARIAL_ROUNDER_20);
        this.add(buttonEdit);

        add(Box.createRigidArea(new Dimension(30,0)));

        RoundedJButton buttonDelete = new RoundedJButton("Borrar",Commands.DELETE_GRAMMAR.toString(),actionListener,Constant.COLOR_ORANGE_1,Constant.COLOR_WHITE);
        buttonDelete.setFont(Constant.FONT_ARIAL_ROUNDER_20);
        this.add(buttonDelete);
    }

}
