package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import misc.DBManager;
import pojos.MusicGroup;
import misc.MyWindowEvent;
import pojos.MusicGroupArtist;

public class EditMusicGroupForm extends javax.swing.JFrame {

    private MusicGroup musicGroup1;
    private boolean readOnly;
    private EntityManager em;
    private MusicGroupArtist musicGroupArtist;
    private JFrame thisFrame;
    private AddMusicGroupArtistForm amgaf;
    
    /**
     * Creates new form EditMusicGroupForm
     */
    public EditMusicGroupForm() {
        initComponents();
    }

    public EditMusicGroupForm(MusicGroup mg, boolean readOnly) {
        musicGroup1 = mg;
        this.readOnly = readOnly;
        em = DBManager.em;
        if ( !(em.getTransaction().isActive()) )
            em.getTransaction().begin();
        initComponents(); 
        
        // Διαμόρφωση φόρμας διαγραφής
         if (readOnly == true) {
            for (int i = 0 ; i < getContentPane().getComponentCount() ; i++) {
                if (getContentPane().getComponent(i) instanceof JTextField) 
                    getContentPane().getComponent(i).setFocusable(false);
            }
            remove(newButton);
            remove(deleteButton);
            saveButton.setText("Διαγραφή");
        }
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

        musicGroup2 = musicGroup1;
        artistQuery = em.createQuery("SELECT a FROM MusicGroupArtist a WHERE a.musicgroupid=:musicgroup").setParameter("musicgroup",musicGroup2);
        artistList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(artistQuery.getResultList());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Συγκρότημα");

        jLabel2.setText("Επωνυμία:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, musicGroup2, org.jdesktop.beansbinding.ELProperty.create("${name}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ημερομηνία δημιουργίας: ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, musicGroup2, org.jdesktop.beansbinding.ELProperty.create("${formationdate}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        saveButton.setText("Αποθήκευση");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Ακύρωση");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Λίστα Καλλιτεχνών");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, artistList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${artistid.artisticname}"));
        columnBinding.setColumnName("Καλλιτεχνικό όνομα");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${artistid.lastname}"));
        columnBinding.setColumnName("Επώνυμο");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${artistid.firstname}"));
        columnBinding.setColumnName("Όνομα");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        newButton.setText("Εισαγωγή καλλιτέχνη");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Διαγραφή καλλιτέχνη");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(deleteButton))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    //Δημιουργία μεθόδου για πάτημα κουμπιού SAVE
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
       //ΑΜΥΝΤΙΚΟΣ ΠΡΟΓΡΑΜΜΑΤΙΣΜΟΣ ΓΙΑ ΝΑ ΕΧΕΙ ΤΟΥΛΑΧΙΣΤΟΝ 2 ΚΑΛΛΙΤΕΧΝΕΣ ΤΟ ΓΚΡΟΥΠ
        if (artistList.size() >= 2) {
            MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, true);
            for (WindowListener l : this.getWindowListeners())
                l.windowClosed(we);
            this.setVisible(false); } 
        else {            
            String message = "Το γκρουπ πρέπει να αποτελείται από δύο ή περισσότερους καλλιτέχνες!";
            JOptionPane.showMessageDialog(this, message);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

//Δημιουργία μεθόδου για πάτημα κουμπιού CANCEL
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, false);
        for (WindowListener l : this.getWindowListeners())
            l.windowClosed(we);
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    //Δημιουργία μεθόδου για πάτημα κουμπιού NEW
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        
        try {
            musicGroupArtist = new MusicGroupArtist();
            musicGroupArtist.setMusicgroupid(musicGroup1);
            em.persist(musicGroupArtist);

            amgaf = new AddMusicGroupArtistForm(musicGroupArtist, artistList);
            amgaf.setTitle("Επιλογή καλλιτέχνη");
            amgaf.setVisible(true);
            thisFrame.setEnabled(false);
            thisFrame = this;
            amgaf.addWindowListener(new WindowListener() {
                public void windowClosed(WindowEvent arg0) {
                    System.out.println("Window close event occur");
                    if (((MyWindowEvent)arg0).exitAndSave) {
                        artistList.add(musicGroupArtist);
                        int row = artistList.size() - 1;                    
                        jTable1.setRowSelectionInterval(row, row);
                        jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true ));
                        thisFrame.setEnabled(true);
                    }
                    else {
                        thisFrame.setEnabled(true);
                        em.remove(musicGroupArtist);                       
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
        catch (RuntimeException e) {
                String message = "Αδυναμία εγγραφής, ελέγξτε τα δεδομένα!";
                JOptionPane.showMessageDialog(thisFrame, message);  
                                
                MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, false);
                for (WindowListener l : this.getWindowListeners())
                    l.windowClosed(we);
                this.setVisible(false);
                
        }
        
    }//GEN-LAST:event_newButtonActionPerformed

    //Δημιουργία μεθόδου για πάτημα κουμπιού DELETE
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = jTable1.getSelectedRow();
        musicGroupArtist = (MusicGroupArtist)artistList.get(row);    
        em.remove(musicGroupArtist); // διαγραφή καλλιτέχνη από τον πίνακα MusicGroupArtist
        artistList.remove(row);
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    //ΚΛΑΣΣΗ MAIN
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(EditMusicGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMusicGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMusicGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMusicGroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditMusicGroupForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<pojos.MusicGroupArtist> artistList;
    private javax.persistence.Query artistQuery;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private pojos.MusicGroup musicGroup2;
    private javax.swing.JButton newButton;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
