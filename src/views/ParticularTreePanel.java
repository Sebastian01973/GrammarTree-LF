package views;

import models.ParticularNode;
import models.Simbol;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class ParticularTreePanel extends JPanel{

    private static final String TITLE_HEADER = "Arbol Derivación Particular ";
    private static final String GRAMMAR_SIMBOL = "W";
    private static final Color COLOR_HEADER = Color.decode("#4992E6");
    public static final Font DESCRIPTION_FONT = new Font("Roboto", Font.BOLD, 16);

    private DefaultMutableTreeNode graphicRoot;
    private DefaultTreeModel treeModel;
    private JTree graphicTree;
    private JPanel panelCenter;

    private JLabel header;
    
    public ParticularTreePanel(){
        setLayout(new BorderLayout());
        setBackground(COLOR_HEADER);
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setOpaque(false);
        add(panelCenter,BorderLayout.CENTER);
        addHeader();
        treeModel = new DefaultTreeModel(graphicRoot);
        graphicTree = new JTree(treeModel);
        panelCenter.add(new JScrollPane(graphicTree) ,BorderLayout.CENTER);
    }

    private void addHeader(){
        header = new JLabel();
        header.setForeground(Color.WHITE);
        header.setHorizontalTextPosition(SwingConstants.RIGHT);
        header.setVerticalTextPosition(SwingConstants.CENTER);
        header.setFont(DESCRIPTION_FONT);
        header.setText(TITLE_HEADER);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);
        add(header,BorderLayout.PAGE_START);
    }

    public void showTree(ParticularNode<Simbol> root){
        header.setText(TITLE_HEADER + GRAMMAR_SIMBOL);
        graphicRoot = new DefaultMutableTreeNode(root.getSimbol());
        printTree(graphicRoot,root.getLeft(),root.getRight());
        treeModel.setRoot(graphicRoot);
        expandTree();
        graphicTree.setCellRenderer(new MyTreeCellRenderer());
        revalidate();
        repaint();
    }

    private void printTree(DefaultMutableTreeNode graphicBase, ParticularNode leftNode, ParticularNode righNode) {
            if(leftNode != null){
                DefaultMutableTreeNode actualLeft = new DefaultMutableTreeNode(leftNode.getSimbol());
                graphicBase.add(actualLeft);
                printTree(actualLeft,leftNode.getLeft(),leftNode.getRight());
            }
            if(righNode != null){
                DefaultMutableTreeNode actualRigth = new DefaultMutableTreeNode(righNode.getSimbol());
                graphicBase.add(actualRigth);
                printTree(actualRigth,righNode.getLeft(),righNode.getRight());
            }
        }

    public void expandTree() {
        expandAllNodes(graphicTree, 0, graphicTree.getRowCount());
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

}
