package views2.left;

import models.GeneralNode;
import views2.MyTreeCellRenderer;
import views2.Constant;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class JLGeneralTree extends JPanel{


    private DefaultMutableTreeNode graphicRoot;
    private DefaultTreeModel treeModel;
    private JTree graphicTree;
    private JPanel panelCenter;

    private JLabel header;

    public JLGeneralTree(){
        setLayout(new BorderLayout());
        setBackground(Constant.COLOR_WHITE);
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setOpaque(false);
        this.add(panelCenter,BorderLayout.CENTER);
        addHeader();
        treeModel = new DefaultTreeModel(graphicRoot);
        graphicTree = new JTree(treeModel);
        panelCenter.add(new JScrollPane(graphicTree) ,BorderLayout.CENTER);
    }

    private void addHeader(){
        header = new JLabel();
        header.setForeground(Color.BLACK);
        header.setHorizontalTextPosition(SwingConstants.RIGHT);
        header.setVerticalTextPosition(SwingConstants.CENTER);
        header.setFont(Constant.FONT_ARIAL_ROUNDER_17);
        header.setText(Constant.SPACE + Constant.TITLE_HEADER_LEFT + Constant.SPACE);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);
        add(header,BorderLayout.PAGE_START);
    }

    public void showTree(GeneralNode root, String grammarName){
        header.setText(Constant.SPACE + Constant.TITLE_HEADER_LEFT + Constant.GRAMMAR_SIMBOL + grammarName + Constant.SPACE);
        graphicRoot = new DefaultMutableTreeNode(root.getSimbol());
        printTree(graphicRoot,root);
        treeModel.setRoot(graphicRoot);
        expandTree();
        graphicTree.setCellRenderer(new MyTreeCellRenderer());
        revalidate();
        repaint();
    }

    private void printTree(DefaultMutableTreeNode graphicBase, GeneralNode base) {
        for (GeneralNode node : base.getChildrenSimbol()) {
            DefaultMutableTreeNode actual = new DefaultMutableTreeNode(node.getSimbol());
            graphicBase.add(actual);
            printTree(actual,node);
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
