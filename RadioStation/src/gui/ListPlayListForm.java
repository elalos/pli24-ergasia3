package gui;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import misc.DBManager;
import misc.MyWindowEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import pojos.PlayList;

public class ListPlayListForm extends JPanel {
    
    private final EntityManager em;
    private EditPlayListForm eplf;
    private PlayList pl;
    private JFrame thisFrame;
    
    public ListPlayListForm() {
        em = DBManager.em;
        if ( !(em.getTransaction().isActive()) )
            em.getTransaction().begin();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        query1 = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT p FROM PlayList p");
        list1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query1.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        exitButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        exportButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list1, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(jTable1);

        exitButton.setText("Έξοδος");
        exitButton.addActionListener(formListener);

        editButton.setText("Ενημέρωση");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), editButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        editButton.addActionListener(formListener);

        newButton.setText("Δημιουργία");
        newButton.addActionListener(formListener);

        deleteButton.setText("Διαγραφή");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Λίστες Τραγουδιών");

        exportButton.setText("Εξαγωγή Λίστας σε αρχείο XML");
        exportButton.addActionListener(formListener);

        importButton.setText("Εισαγωγή Λίστας από αρχείο XML");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(exportButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(importButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, editButton, exitButton, newButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportButton)
                    .addComponent(importButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == exitButton) {
                ListPlayListForm.this.exitButtonActionPerformed(evt);
            }
            else if (evt.getSource() == editButton) {
                ListPlayListForm.this.editButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ListPlayListForm.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ListPlayListForm.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == exportButton) {
                ListPlayListForm.this.exportButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    

    @SuppressWarnings("unchecked")
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int row = jTable1.getSelectedRow();
        pl = (PlayList)list1.get(row);
        eplf = new EditPlayListForm(pl, false);
        eplf.setTitle("Ενημέρωση λίστας τραγουδιών");
        eplf.setVisible(true);
        thisFrame = (JFrame)this.getRootPane().getParent();
        thisFrame.setEnabled(false);
        
        eplf.addWindowListener(new WindowListener() {
            public void windowClosed(WindowEvent arg0) {
                System.out.println("Window close event occur");
                if (((MyWindowEvent)arg0).exitAndSave) {
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                    list1.set(row, pl);
                    jTable1.setRowSelectionInterval(row, row);
                    jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true ));
                    thisFrame.setEnabled(true);
                }
                else {
                    thisFrame.setEnabled(true);
                    em.getTransaction().rollback();
                    em.getTransaction().begin();
                    java.util.Collection data = query1.getResultList();
                    for (Object entity : data) 
                        em.refresh(entity);
                    list1.clear();
                    list1.addAll(data);
                        
                }
            }
            public void windowActivated(WindowEvent arg0) {
                System.out.println("Window Activated");
            }

            public void windowClosing(WindowEvent arg0) {
                System.out.println("Window Closing");
            }

            public void windowDeactivated(WindowEvent arg0) {
                System.out.println("Window Deactivated");
            }

            public void windowDeiconified(WindowEvent arg0) {
                System.out.println("Window Deiconified");
            }

            public void windowIconified(WindowEvent arg0) {
                System.out.println("Window Iconified");
            }

            public void windowOpened(WindowEvent arg0) {
                System.out.println("Window Opened");
            }
        });
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = jTable1.getSelectedRow();
        pl = (PlayList)list1.get(row);
        eplf = new EditPlayListForm(pl, false);
        eplf.setTitle("Διαγραφή λίστας τραγουδιών");
        eplf.setVisible(true);
        thisFrame = (JFrame)this.getRootPane().getParent();
        thisFrame.setEnabled(false);
        
        eplf.addWindowListener(new WindowListener() {
            public void windowClosed(WindowEvent arg0) {
                System.out.println("Window close event occur");
                if (((MyWindowEvent)arg0).exitAndSave) {
                    em.remove(pl);
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                    list1.remove(row);
                    thisFrame.setEnabled(true);
                }
                else {
                    thisFrame.setEnabled(true);
                    em.getTransaction().rollback();
                    em.getTransaction().begin();
                    java.util.Collection data = query1.getResultList();
                    for (Object entity : data) 
                        em.refresh(entity);
                    list1.clear();
                    list1.addAll(data);
                        
                }
            }
            public void windowActivated(WindowEvent arg0) {
                System.out.println("Window Activated");
            }

            public void windowClosing(WindowEvent arg0) {
                System.out.println("Window Closing");
            }

            public void windowDeactivated(WindowEvent arg0) {
                System.out.println("Window Deactivated");
            }

            public void windowDeiconified(WindowEvent arg0) {
                System.out.println("Window Deiconified");
            }

            public void windowIconified(WindowEvent arg0) {
                System.out.println("Window Iconified");
            }

            public void windowOpened(WindowEvent arg0) {
                System.out.println("Window Opened");
            }
        });
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        pl = new PlayList();
        em.persist(pl);
        eplf = new EditPlayListForm(pl, false);
        eplf.setTitle("Δημιουργία λίστας τραγουδιών");
        eplf.setVisible(true);
        thisFrame = (JFrame)this.getRootPane().getParent();
        thisFrame.setEnabled(false);
        
        eplf.addWindowListener(new WindowListener() {
            public void windowClosed(WindowEvent arg0) {
                System.out.println("Window close event occur");
                if (((MyWindowEvent)arg0).exitAndSave) {
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                    list1.add(pl);
                    int row = list1.size() - 1;                    
                    jTable1.setRowSelectionInterval(row, row);
                    jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true ));
                    thisFrame.setEnabled(true);
                }
                else {
                    thisFrame.setEnabled(true);
                    em.getTransaction().rollback();
                    em.getTransaction().begin();
                    java.util.Collection data = query1.getResultList();
                    for (Object entity : data) 
                        em.refresh(entity);
                    list1.clear();
                    list1.addAll(data);
                        
                }
            }
            public void windowActivated(WindowEvent arg0) {
                System.out.println("Window Activated");
            }

            public void windowClosing(WindowEvent arg0) {
                System.out.println("Window Closing");
            }

            public void windowDeactivated(WindowEvent arg0) {
                System.out.println("Window Deactivated");
            }

            public void windowDeiconified(WindowEvent arg0) {
                System.out.println("Window Deiconified");
            }

            public void windowIconified(WindowEvent arg0) {
                System.out.println("Window Iconified");
            }

            public void windowOpened(WindowEvent arg0) {
                System.out.println("Window Opened");
            }
        });
    }                                         
                                     
               
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListMusicGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMusicGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMusicGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMusicGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new ListMusicGroupForm());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        setVisible(false);
        getRootPane().getJMenuBar().getComponent(0).setEnabled(true);
        getRootPane().getParent().remove(this);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        try {
            DocumentBuilderFactory docFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = 
                    docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("playlist");
            doc.appendChild(rootElement);
            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } 

    }//GEN-LAST:event_exportButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jTable1;
    private java.util.List list1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
}
