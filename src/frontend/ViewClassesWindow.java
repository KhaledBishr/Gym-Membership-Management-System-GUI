package frontend;

import backend.TrainerRole;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ViewClassesWindow extends javax.swing.JFrame {

    TrainerRoleWindow trainerRoleWindow;
    TrainerRole trainerRole;

    public ViewClassesWindow(TrainerRole trainerRole, TrainerRoleWindow trainerRoleWindow) {
        initComponents();
        this.trainerRole = trainerRole;
        this.trainerRoleWindow = trainerRoleWindow;
        classTable();
    }

    public void classTable() {
        ArrayList<backend.Class> m = trainerRole.getListOfClasses();
        DefaultTableModel t = (DefaultTableModel) classTable.getModel();
        for (int i = 0; i < m.size(); i++) {
            t.addRow(new Object[]{m.get(i).classID, m.get(i).className, m.get(i).trainerID, m.get(i).duration, m.get(i).maxParticipants});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Classes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class Id", "Class Name", "Trainer Id", "Duration", "Max Participants"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(classTable);
        if (classTable.getColumnModel().getColumnCount() > 0) {
            classTable.getColumnModel().getColumn(0).setResizable(false);
            classTable.getColumnModel().getColumn(1).setResizable(false);
            classTable.getColumnModel().getColumn(2).setResizable(false);
            classTable.getColumnModel().getColumn(3).setResizable(false);
            classTable.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        trainerRoleWindow.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable classTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
