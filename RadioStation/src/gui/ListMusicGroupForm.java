package gui;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import misc.DBManager;
import pojos.MusicGroup;
import misc.MyWindowEvent;
import pojos.MusicGroupArtist;

public class ListMusicGroupForm extends JPanel {
    
    private MusicGroup mg;
    private EditMusicGroupForm emgf;
    private final EntityManager em;
    private JFrame thisFrame;
    
    public ListMusicGroupForm() {
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

        query1 = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT m FROM MusicGroup m");
        list1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query1.getResultList());
        albumQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT alb.musicgroupid FROM Album alb");
        albumList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(albumQuery.getResultList());
        musicGroupArtistQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT mga FROM MusicGroupArtist mga");
        musicGroupArtistList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(musicGroupArtistQuery.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        exitButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list1, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Επωνυμία");
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

        newButton.setText("Εισαγωγή νέου");
        newButton.addActionListener(formListener);

        deleteButton.setText("Διαγραφή");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Πίνακας Συγκροτημάτων");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, editButton, exitButton, newButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
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
                ListMusicGroupForm.this.exitButtonActionPerformed(evt);
            }
            else if (evt.getSource() == editButton) {
                ListMusicGroupForm.this.editButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ListMusicGroupForm.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ListMusicGroupForm.this.deleteButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    

    @SuppressWarnings("unchecked")
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int row = jTable1.getSelectedRow();
        mg = list1.get(row);
        emgf = new EditMusicGroupForm(mg, false);
        emgf.setTitle("Ενημέρωση συγκροτήματος");
        emgf.setVisible(true);
        thisFrame = (JFrame)this.getRootPane().getParent();
        thisFrame.setEnabled(false);
        
        emgf.addWindowListener(new WindowListener() {
            public void windowClosed(WindowEvent arg0) {
                System.out.println("Window close event occur");
                if (((MyWindowEvent)arg0).exitAndSave) {
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                    list1.set(row, mg);
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
        mg = list1.get(row);
        
        // Έλεγχος για δυνατότητα διαγραφής 
        if (albumList.contains(mg)) { // Το συγκρότημα υπάρχει στον πίνακα Album
            String message = "Η διαγραφή είναι αδύνατη, το συγκρότημα έχει τουλάχιστον ένα άλμπουμ!";
            JOptionPane.showMessageDialog(this, message);
        }
        else {
            emgf = new EditMusicGroupForm(mg, true);
            emgf.setTitle("Διαγραφή συγκροτήματος");
            emgf.setVisible(true);
            thisFrame = (JFrame)this.getRootPane().getParent();
            thisFrame.setEnabled(false);

            emgf.addWindowListener(new WindowListener() {
                public void windowClosed(WindowEvent arg0) {
                    System.out.println("Window close event occur");
                    if (((MyWindowEvent)arg0).exitAndSave) {
                        
                        // Ανανέωση musicGroupArtistQuery και musicGroupArtistList
                        java.util.Collection data = musicGroupArtistQuery.getResultList();
                        for (Object entity : data) 
                            em.refresh(entity);
                        musicGroupArtistList.clear();
                        musicGroupArtistList.addAll(data);
                        
                        // Διαγραφή καταχωρήσεων του συγκροτήματος από MusicGroupArtist
                        for (Object o : musicGroupArtistList) 
                            if (((MusicGroupArtist)o).getMusicgroupid().equals(mg)) 
                                em.remove(o); 
                           
                        em.remove(mg); // Διαγραφή του γκρουπ από MusicGroup
                        
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
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        mg = new MusicGroup();
        em.persist(mg);
        emgf = new EditMusicGroupForm(mg, false);
        emgf.setTitle("Εισαγωγή νέου συγκροτήματος");
        emgf.setVisible(true);
        thisFrame = (JFrame)this.getRootPane().getParent();
        thisFrame.setEnabled(false);
        
        emgf.addWindowListener(new WindowListener() {
            public void windowClosed(WindowEvent arg0) {
                System.out.println("Window close event occur");
                if (((MyWindowEvent)arg0).exitAndSave) {
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                    list1.add(mg);
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
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.setVisible(false);
        getRootPane().getJMenuBar().getComponent(0).setEnabled(true); 
        getRootPane().getParent().remove(this);
    }//GEN-LAST:event_exitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List albumList;
    private javax.persistence.Query albumQuery;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jTable1;
    private java.util.List<pojos.MusicGroup> list1;
    private javax.swing.JScrollPane masterScrollPane;
    private java.util.List musicGroupArtistList;
    private javax.persistence.Query musicGroupArtistQuery;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
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
    }
    
}
