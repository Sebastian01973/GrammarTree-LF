package views2.left;

import controllers.Commands;
import views.Buttons;
import views2.Constant;
import views2.models.JModelButton;
import views2.models.JModelLabel;
import views2.models.JModelTextField;
import views2.models.RoundedJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JLNorthPanel extends JPanel {

    private JModelTextField wordTextField;
    private JPanel panelBox;

    public JLNorthPanel(ActionListener actionListener) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
        //To do .. Change
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener) {
        panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.setBackground(Constant.COLOR_BLUE_DARK_2);
        panelBox.setOpaque(true);
        addLabel();
        addTextFieldAndButton(actionListener);
        add(panelBox, BorderLayout.PAGE_START);
    }

    private void addTextFieldAndButton(ActionListener actionListener) {
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHeader.setOpaque(false);
        JLabel word = new JLabel(Constant.GRAMMAR_SIMBOL_WORD + Constant.EQUAL_SYMBOL);
        word.setFont(Constant.LABEL_FONT);
        word.setForeground(Constant.COLOR_WHITE);
        panelHeader.add(word);
        wordTextField = new JModelTextField(Constant.WATER_WORD,Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_WHITE,Constant.COLOR_GRAY_LIGHT_1);
        panelHeader.add(wordTextField);

        RoundedJButton validateButton = new RoundedJButton(Constant.BUTTON_TEXT,Commands.VALIDATE_WORD.toString(),actionListener,Constant.COLOR_RED_LIGHT_1,Constant.COLOR_WHITE);
        validateButton.setFont(Constant.FONT_ARIAL_ROUNDER_17);
        panelHeader.add(validateButton);

        panelBox.add(panelHeader);
    }

    private void addLabel(){
        JPanel panelDescription = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDescription.setBackground(Constant.COLOR_BLUE_DARK_2);
        panelDescription.setOpaque(false);
        JLabel description = new JLabel(Constant.DESCRIPTION);
        description.setFont(Constant.FONT_ARIAL_ROUNDER_17);
        description.setBackground(Constant.COLOR_BLUE_DARK_2);
        description.setForeground(Constant.COLOR_WHITE);
        panelDescription.add(description);
        panelBox.add(panelDescription);
    }

    public String getWord(){
        return wordTextField.getText().trim();
    }

    public void setVisibleWordValidate(boolean status){
        this.setVisible(status);
    }
}
