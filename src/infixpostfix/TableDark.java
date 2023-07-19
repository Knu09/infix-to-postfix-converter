package infixpostfix;

import ScrollBarTableDark.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableDark extends JTable{
    
    public TableDark() {
        getTableHeader().setDefaultRenderer(new TableDarkHeader());
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, new TableDarkCell());
        setRowHeight(30);
    }
     
    public void fixTable(JScrollPane scroll){
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30,30,30));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER,panel);
        scroll.getViewport().setBackground(new Color(30,30,30));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60,60,60), 2));
    }
    
    private class TableDarkHeader extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            com.setBackground(new Color(30,30,30));
            com.setForeground(new Color(200, 200, 200));
            com.setFont(new Font("Poppins", Font.BOLD, 12));
            return com;
        }
        
    }
    private class TableDarkCell extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            if(isCellSelected(row, column)){
                if(row % 2 == 0){
                    com.setBackground(new Color(50,103,153));
                } else{
                    com.setBackground(new Color(29,86,127));
                }
            } else{
                if(row % 2 == 0){
                    com.setBackground(new Color(50,50,50));
                } else{
                    com.setBackground(new Color(30,30,30));
                }
            }
            com.setForeground(new Color(200, 200, 200));
            setBorder(new EmptyBorder(0,5,0,5));
            com.setFont(new Font("Poppins",Font.PLAIN, 12));
            
            return com;
        }
        
    }

    
    
}
