package views2.left;

import views2.Constant;
import views2.models.JModelLabel;

import javax.swing.*;
import java.awt.*;

public class JLSouthPanel extends JPanel {

    public JModelLabel wordValidate;

    public JLSouthPanel(){
        this.setBackground(Constant.COLOR_RED_LIGHT_1);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(BorderFactory.createEmptyBorder(5,3,2,3));
        this.setVisible(false);
        initComponents();
    }

    private void initComponents() {
        wordValidate = new JModelLabel(Constant.WORD_INVALIDATE,Constant.FONT_ARIAL_ROUNDER_25,Constant.COLOR_RED_LIGHT_1,Constant.COLOR_WHITE);
        wordValidate.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        wordValidate.setColorPaint(Constant.COLOR_RED_LIGHT_1);
        this.add(wordValidate);
    }

    public void setWordValidate(String word,Color bg){
        wordValidate.setBackground(bg);
        this.setBackground(bg);
        wordValidate.setColorPaint(bg);
        this.wordValidate.setText(word);
    }

    public void setVisibleSouthPanel(boolean status){
        this.setVisible(status);
    }
}
