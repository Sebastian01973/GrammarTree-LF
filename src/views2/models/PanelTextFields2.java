package views2.models;

import views.Buttons;
import views2.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelTextFields2 extends JPanel{


    public static final int SIZE_TEXT_FIELD = 20;

    private JModelTextField textField;

    public PanelTextFields2(String water, String messageTool, Font font, Color bg, Color fg){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setOpaque(false);
        addTextField(water,messageTool,font,bg,fg);
    }

    public PanelTextFields2(String text, String buttonText , String message, ActionListener listener, String command){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setOpaque(false);
        addLabel(text);
        addButton(buttonText,message, listener, command);
    }

    private void addLabel(String text){
        JLabel title = new JLabel(text);
        title.setFont(Constant.TITLE_FONT);
        add(title);
    }

    private void addTextField(String water,String messageTool, Font font, Color bg, Color fg){
        textField = new JModelTextField(water,font,bg,fg);
        textField.setColumns(SIZE_TEXT_FIELD);
        textField.setToolTipText(messageTool);
        this.add(textField);
    }

    private void addButton(String text, String message, ActionListener listener, String command){
        Buttons button = new Buttons(text);
        button.setToolTipText(message);
        button.addActionListener(listener);
        button.setActionCommand(command);
        add(button);
    }

    public String getText(){
        textField.setEnabled(false);
        textField.setDisabledTextColor(Constant.DISABLE_COLOR);
        textField.setBackground(Color.WHITE);
        return textField.getText();
    }

    public void enableTextField(){
        textField.setBackground(Constant.COLOR_TEXT_FIELD);
        textField.setEnabled(true);
    }

    public void deletContentTextField(){
        textField.setText("");
        textField.setBackground(Constant.COLOR_TEXT_FIELD);
        textField.setEnabled(true);
    }
}
