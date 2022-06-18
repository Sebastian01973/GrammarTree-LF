package views;

import controllers.Commands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ParametersPanel extends JPanel{

    public static final String SIGMA = "Σ";
    public static final String V = "V";
    public static final String GRAMMAR = "G";
    public static final String AXIOM = "S";
    public static final String PRODUCTION = "P";
    public static final String GENERATE_BUTTON_TEXT = "Generar";
    public static final String EQUAL_SYMBOL = " = ";
    public static final String DESCRIPTION = "Ingrese los valores de la gramática";
    public static final Font PARAMETERS_FONT = new Font("Cambria Math", Font.BOLD, 20);
    public static final Font DESCRIPTION_FONT = new Font("Roboto", Font.BOLD, 13);

    private JPanel panelBox;
    private PanelTextFields grammarField;
    private PanelTextFields sigmaField;
    private PanelTextFields noTerminalField;
    private PanelTextFields axiomField;
    private PanelTextFields productionsField;
    
    public ParametersPanel(ActionListener listener){
        setLayout(new FlowLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        initComponents(listener);
        addButtons(listener);
    }

    private void initComponents(ActionListener listener){
        panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.setOpaque(false);
        addLable();
        addParameters(listener);
        add(panelBox);
    }

    private void addLable(){
        JPanel panelDescription = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDescription.setOpaque(false);
        JLabel description = new JLabel(DESCRIPTION);
        description.setFont(DESCRIPTION_FONT);
        panelDescription.add(description);
        panelBox.add(panelDescription);
    }

    private void addParameters(ActionListener listener){
        grammarField = new PanelTextFields(GRAMMAR + EQUAL_SYMBOL,"Ingrese número de la gramática");
        panelBox.add(grammarField);
        sigmaField = new PanelTextFields(SIGMA + EQUAL_SYMBOL,"Sim 1, Sim 2 Ej.(a,b)");
        panelBox.add(sigmaField);
        noTerminalField = new PanelTextFields(V + EQUAL_SYMBOL,"Sim 1, Sim 2 Ej.(X,Y)");
        panelBox.add(noTerminalField);
        axiomField = new PanelTextFields(AXIOM + EQUAL_SYMBOL,"Simbolo Ej.(X)");
        panelBox.add(axiomField);
        productionsField = new PanelTextFields(PRODUCTION + EQUAL_SYMBOL,"Abrir","(Sim 1, Sim 2);(Sim 3, Sim 4) Ej.(X,a);(Y,b)",listener,Commands.ADD_PRODUCTIONS.toString());
        panelBox.add(productionsField);
    }

    private void addButtons(ActionListener listener){
        JPanel panelButtons = new JPanel(new GridLayout(3, 1, 0, 5));
        panelButtons.setOpaque(false);
        Buttons buttonGenerate = new Buttons(GENERATE_BUTTON_TEXT);
        buttonGenerate.addActionListener(listener);
        buttonGenerate.setActionCommand(Commands.ADD_GRAMMAR.toString());
        panelButtons.add(buttonGenerate);
        Buttons buttonEdit = new Buttons("Editar");
        buttonEdit.addActionListener(listener);
        buttonEdit.setActionCommand(Commands.EDIT_GRAMMAR.toString());
        panelButtons.add(buttonEdit);
        Buttons buttonDelete = new Buttons("Borrar");
        buttonDelete.addActionListener(listener);
        buttonDelete.setActionCommand(Commands.DELETE_GRAMMAR.toString());
        panelButtons.add(buttonDelete);
        add(panelButtons);
    }

    public String getGrammarName(){
        return grammarField.getText();
    }

    public String[] getSigma(){
        return sigmaField.getText().split(",");
    }

    public String[] getNoTerminalSimbols(){
        return noTerminalField.getText().split(",");
    }

    public String getAxiom(){
        return axiomField.getText();
    }

    public void enableFields(){
        grammarField.enableTextField();
        sigmaField.enableTextField();
        noTerminalField.enableTextField();
        axiomField.enableTextField();
    }

    public void deleteContentFields(){
        grammarField.deletContentTextField();
        sigmaField.deletContentTextField();
        noTerminalField.deletContentTextField();
        axiomField.deletContentTextField();
    }
}
