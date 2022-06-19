package views2.right;

import views2.Constant;
import views2.models.JModelLabel;
import views2.models.PanelTextFields2;

import javax.swing.*;
import java.awt.*;

public class JRHeader extends JPanel {

    private PanelTextFields2 txtGramar;
    private PanelTextFields2 txtSigma;
    private PanelTextFields2 txtNoTerminal;
    private PanelTextFields2 txtAxiom;
    public JRHeader() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents();
    }

    private void initComponents() {
        JPanel intro = new JPanel(new FlowLayout(FlowLayout.CENTER));
        intro.setBackground(Constant.COLOR_ORANGE_1);
        JModelLabel introduction = new JModelLabel(Constant.SETTINGS_GRAMMAR,Constant.FONT_ARIAL_ROUNDER_25,Constant.COLOR_ORANGE_1,Constant.COLOR_WHITE);
        introduction.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        introduction.setColorPaint(Constant.COLOR_ORANGE_1);
        intro.add(introduction);
        this.add(intro);

        add(Box.createRigidArea(new Dimension(0,10)));

        JPanel jgrammar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jgrammar.setBackground(Constant.COLOR_WHITE);
        JModelLabel grammarField = new JModelLabel("Nombre o Numero de la Gramatica ",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        grammarField.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        grammarField.setColorPaint(Constant.COLOR_WHITE);
        jgrammar.add(grammarField);
        this.add(jgrammar);

        txtGramar = new PanelTextFields2("Ej: 10","Ingrese número de la gramática",Constant.FIELDS_FONT,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);

        this.add(txtGramar);

        add(Box.createRigidArea(new Dimension(0,10)));

        JPanel jsigma = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jsigma.setBackground(Constant.COLOR_WHITE);
        JModelLabel labolSigma = new JModelLabel("Variables Sigma (Separado por comas)",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        labolSigma.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        labolSigma.setColorPaint(Constant.COLOR_WHITE);
        jsigma.add(labolSigma);
        this.add(jsigma);

        txtSigma = new PanelTextFields2("Ej: a,b,c,d,e","Ingrese las variables de Sigma",Constant.FIELDS_FONT,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);
        this.add(txtSigma);

        add(Box.createRigidArea(new Dimension(0,10)));

        JPanel jnoTerminal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jnoTerminal.setBackground(Constant.COLOR_WHITE);
        JModelLabel labolterminal = new JModelLabel("Variables no Terminales (Separado por comas)",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        labolterminal.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        labolterminal.setColorPaint(Constant.COLOR_WHITE);
        jnoTerminal.add(labolterminal);
        this.add(jnoTerminal);

        txtNoTerminal = new PanelTextFields2("Ej: S,A,C,D,E","Ingrese las variables no terminales",Constant.FIELDS_FONT,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);
        this.add(txtNoTerminal);

        add(Box.createRigidArea(new Dimension(0,10)));

        JPanel jAxiom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jAxiom.setBackground(Constant.COLOR_WHITE);
        JModelLabel labolaxiom = new JModelLabel("Variable Axiomatico ",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        labolaxiom.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        labolaxiom.setColorPaint(Constant.COLOR_WHITE);
        jAxiom.add(labolaxiom);
        this.add(jAxiom);

        txtAxiom = new PanelTextFields2("Ej: S","Ingrese la Variable Axiomatica",Constant.FIELDS_FONT,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);
        this.add(txtAxiom);

    }

    public String getGrammarName(){
        return txtGramar.getText();
    }

    public String[] getSigma(){
        return txtSigma.getText().split(",");
    }

    public String[] getNoTerminalSimbols(){
        return txtNoTerminal.getText().split(",");
    }

    public String getAxiom(){
        return txtAxiom.getText();
    }

    public void enableFields(){
        txtGramar.enableTextField();
        txtSigma.enableTextField();
        txtNoTerminal.enableTextField();
        txtAxiom.enableTextField();
    }

    public void deleteContentFields(){
        txtGramar.deletContentTextField();
        txtSigma.deletContentTextField();
        txtNoTerminal.deletContentTextField();
        txtAxiom.deletContentTextField();
    }


}
