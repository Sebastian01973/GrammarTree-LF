package views2.right;

import models.Production;
import views2.Constant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class JProductions extends JPanel  {

    private JPanel productions;
    private boolean isEnable;

    public JProductions() {
        isEnable = true;
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Constant.COLOR_WHITE);
        this.setBorder(new EmptyBorder(1,1,1,1));
        initComponents();
    }

    private void initComponents() {
        productions = new JPanel();
        productions.setLayout(new BoxLayout(productions, BoxLayout.Y_AXIS));
        productions.setBackground(Color.WHITE);
        productions.add(new JPanelProduction());

        JScrollPane jScrollPaneTech = new JScrollPane(productions);
        jScrollPaneTech.setForeground(Color.white);
        jScrollPaneTech.setBorder(null);
        jScrollPaneTech.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(jScrollPaneTech,BorderLayout.CENTER);
    }

    public ArrayList<Production> getProductions(){
        ArrayList<Production> productionsList = new ArrayList<>();
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
            JPanelProduction production = (JPanelProduction)componentsProductions[i];
            productionsList.add(new Production(production.getNoTerminalSimbol(),production.getProduction()));
        }
        productions.revalidate();
        productions.repaint();
        isEnable = false;
        return productionsList;
    }

    public void enableProductions(){
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
            ((JPanelProduction)componentsProductions[i]).enableTextFields();
        }
        isEnable = true;
        productions.revalidate();
        productions.repaint();
    }

    public void deleteProductions(){
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
            ((JPanelProduction)componentsProductions[i]).deleteContentTextFields();
        }
        isEnable = true;
        productions.revalidate();
        productions.repaint();
    }

    public void deleteProductionField(){
        Component[] componentsProductions = productions.getComponents();
        if(componentsProductions.length > 1 && isEnable){
            productions.remove(componentsProductions.length - 1);
            productions.revalidate();
            productions.repaint();
        }
    }

    public void addProductionField(){
        if(isEnable){
            productions.add(new JPanelProduction());
            productions.revalidate();
            productions.repaint();
        }
    }

}
