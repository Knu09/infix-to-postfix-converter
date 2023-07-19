
package infixpostfix;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Table extends javax.swing.JFrame {

    int mousepX,mousepY;
    String infix;
    public Table(String infix) {
        this.infix = infix;
        
        initComponents();
        getContentPane().setBackground(new Color(30,30,30));
//        setBackground((new Color(0,0,0,0)));
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 58, 58));
        tableDark1.fixTable(jScrollPane1);
        
        DefaultTableModel mode = (DefaultTableModel) tableDark1.getModel();

        
        InfixToPostfixCalculator tableValues = new InfixToPostfixCalculator(infix);
        String[] stackValue = tableValues.getStackTable().toArray(new  String[0]);
        String[] postfixValue = tableValues.getPostfixTable().toArray(new  String[0]);
        ArrayList<String> current = new ArrayList<>();
        current.addAll(Arrays.asList(infix.split("(?<=\\D)|(?=\\D)")));
        while (current.size() < postfixValue.length){
            current.add("");
        } //to keep current's size as equal as postfix :)
        
        //diplay the values
        mode.addRow(new Object[]{"0", infix, "", ""});
        for(int i = 0; i<postfixValue.length; i++){
            mode.addRow(new Object[]{i+1, current.get(i), stackValue[i], postfixValue[i]});
        }

        

        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        closeBTN1 = new buttons.CloseBTN();
        minimizeBTN1 = new buttons.MinimizeBTN();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new infixpostfix.TableDark();
        Text1 = new javax.swing.JLabel();
        Text2 = new javax.swing.JLabel();
        MouseDrag = new javax.swing.JLabel();
        Interface = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setForeground(new java.awt.Color(30, 30, 30));
        jPanel1.setLayout(null);

        closeBTN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Group 1 (1).png"))); // NOI18N
        closeBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBTN1ActionPerformed(evt);
            }
        });
        jPanel1.add(closeBTN1);
        closeBTN1.setBounds(920, 0, 50, 20);

        minimizeBTN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Line 4_1.png"))); // NOI18N
        minimizeBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBTN1ActionPerformed(evt);
            }
        });
        jPanel1.add(minimizeBTN1);
        minimizeBTN1.setBounds(870, 0, 50, 20);

        tableDark1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Current", "Stack", "Postfix"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDark1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(90, 140, 820, 530);

        Text1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        Text1.setForeground(new java.awt.Color(218, 217, 217));
        Text1.setText("Infix to Postfix Calculator");
        jPanel1.add(Text1);
        Text1.setBounds(30, 10, 160, 19);

        Text2.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        Text2.setForeground(new java.awt.Color(227, 227, 227));
        Text2.setText("Infix to Postfix Table");
        jPanel1.add(Text2);
        Text2.setBounds(320, 60, 390, 55);

        MouseDrag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MouseDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MouseDragMouseDragged(evt);
            }
        });
        MouseDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MouseDragMousePressed(evt);
            }
        });
        jPanel1.add(MouseDrag);
        MouseDrag.setBounds(0, 0, 1000, 40);

        Interface.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Desktop_2.png"))); // NOI18N
        jPanel1.add(Interface);
        Interface.setBounds(0, 0, 1000, 780);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 998, 779);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBTN1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_closeBTN1ActionPerformed

    private void minimizeBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBTN1ActionPerformed
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeBTN1ActionPerformed

    private void MouseDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseDragMouseDragged
        int CordinateX = evt.getXOnScreen();
        int CordinateY = evt.getYOnScreen();

        this.setLocation(CordinateX-mousepX, CordinateY-mousepY);
    }//GEN-LAST:event_MouseDragMouseDragged

    private void MouseDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseDragMousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_MouseDragMousePressed


    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Table().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Interface;
    private javax.swing.JLabel MouseDrag;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Text2;
    private buttons.CloseBTN closeBTN1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private buttons.MinimizeBTN minimizeBTN1;
    private infixpostfix.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables
}
