package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import misc.DBManager;
import misc.MyWindowEvent;
import pojos.Album;
import pojos.AlbumSong;
import pojos.Song;

public class EditMusicGroupAlbumForm extends javax.swing.JFrame {
    
    private Album album1;
    private boolean readOnly;
    private EntityManager em;
    private Song song;
    private AlbumSong albumSong;
    private Boolean ok;
    
    /**
     * Creates new form EditMusicGroupAlbumForm
     */
    public EditMusicGroupAlbumForm() {
        initComponents();
    }

    public EditMusicGroupAlbumForm(Album a, boolean readOnly) {
        album1 = a;
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

        album2 = album1;
        musicProductionCompanyQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT c FROM MusicProductionCompany c");
        musicProductionCompanyList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(musicProductionCompanyQuery.getResultList());
        musicGroupQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT mg FROM MusicGroup mg");
        musicGroupList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(musicGroupQuery.getResultList());
        myRenderer1 = new misc.MyRenderer();
        songQuery = em.createQuery("SELECT s FROM AlbumSong s WHERE s.albumid=:album").setParameter("album",album2);
        songList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(songQuery.getResultList());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        myRenderer1.setText("renderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Άλμπουμ Συγκροτήματος");

        jLabel2.setText("Τίτλος:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album2, org.jdesktop.beansbinding.ELProperty.create("${title}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Τύπος:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Λίστα Τραγουδιών");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, songList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${songid.tracknr}"));
        columnBinding.setColumnName("Θέση");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${songid.title}"));
        columnBinding.setColumnName("Τίτλος");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${songid.duration}"));
        columnBinding.setColumnName("Διάρκεια");
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        newButton.setText("Εισαγωγή τραγουδιού");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Διαγραφή τραγουδιού");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
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

        jLabel4.setText("Αριθμός άλμπουμ:");

        jLabel5.setText("Εταιρία παραγωγής:");

        jLabel6.setText("Συγκρότημα:");

        jLabel7.setText("Ημερομηνία κυκλοφορίας:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CS", "EP", "LP" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album2, org.jdesktop.beansbinding.ELProperty.create("${type}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox2.setRenderer(myRenderer1);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, musicProductionCompanyList, jComboBox2);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album2, org.jdesktop.beansbinding.ELProperty.create("${musicproductioncompanyid}"), jComboBox2, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox3.setRenderer(myRenderer1);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, musicGroupList, jComboBox3);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album2, org.jdesktop.beansbinding.ELProperty.create("${musicgroupid}"), jComboBox3, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album2, org.jdesktop.beansbinding.ELProperty.create("${disknumber}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("1");
        bindingGroup.addBinding(binding);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album2, org.jdesktop.beansbinding.ELProperty.create("${releasedate}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    //Δημιουργία μεθόδου για πάτημα κουμπιού NEW
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        albumSong = new AlbumSong();
        song = new Song();
        albumSong.setSongid(song);
        albumSong.setAlbumid(album1);
        em.persist(albumSong);
        em.persist(song);
        songList.add(albumSong);
        int row = songList.size() - 1;
        jTable1.setRowSelectionInterval(row, row);
        jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true));          
    }//GEN-LAST:event_newButtonActionPerformed

    //Δημιουργία μεθόδου για πάτημα κουμπιού DELETE
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = jTable1.getSelectedRow();
        albumSong = (AlbumSong)songList.get(row);    
        em.remove(albumSong); // διαγραφή τραγουδιού από τον πίνακα AlbumSong
        em.remove(albumSong.getSongid()); // διαγραφή τραγουδιού από τον πίνακα Song
        songList.remove(row);
    }//GEN-LAST:event_deleteButtonActionPerformed

    //Δημιουργία μεθόδου για πάτημα κουμπιού SAVE
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (songList.size() == 1) { 
           MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, true);
           for (WindowListener l : this.getWindowListeners())
           l.windowClosed(we);
           this.setVisible(false); 
        }
        else if (songList.size() > 1) { // Έλεγχοι για έγκυρες καταχωρήσεις τραγουδιών
            ok = true;
            outerloop:
            for (int i=0; i<songList.size()-1; i++) {
                for (int j=i+1; j<songList.size(); j++) {
                    if (((AlbumSong)songList.get(i)).getSongid().getTracknr() != null && ((AlbumSong)songList.get(j)).getSongid().getTracknr() != null){
                        if (((AlbumSong)songList.get(i)).getSongid().getTracknr().equals(((AlbumSong)songList.get(j)).getSongid().getTracknr())) {
                            // Υπάρχουν τραγούδια με τον ίδιο αριθμό θέσης
                            String message = "Το άλμπουμ περιέχει τραγούδια με τον ίδιο αριθμό θέσης!";
                            JOptionPane.showMessageDialog(this, message);
                            ok = false;
                            break outerloop;
                        }
                    }
                    if (((AlbumSong)songList.get(i)).getSongid().getTitle()!= null && ((AlbumSong)songList.get(j)).getSongid().getTitle()!= null){
                        if (((AlbumSong)songList.get(i)).getSongid().getTitle().toLowerCase().equals(((AlbumSong)songList.get(j)).getSongid().getTitle().toLowerCase())) {
                            // Υπάρχουν τραγούδια με τον ίδιο τίτλο
                            String message = "Το άλμπουμ περιέχει τραγούδια με τον ίδιο τίτλο";
                            JOptionPane.showMessageDialog(this, message);
                            ok = false;
                            break outerloop;
                        }
                    }
                }
            }
            if (ok == true) {
                MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, true);
                for (WindowListener l : this.getWindowListeners())
                    l.windowClosed(we);
                this.setVisible(false);
            }
             
        }
        else { 
            // Το άλμπουμ δεν έχει κανένα τραγούδι
            String message = "Το άλμπουμ πρέπει να περιέχει τουλάχιστον ένα τραγούδι!";
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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(EditMusicGroupAlbumForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMusicGroupAlbumForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMusicGroupAlbumForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMusicGroupAlbumForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditMusicGroupAlbumForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pojos.Album album2;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.util.List musicGroupList;
    private javax.persistence.Query musicGroupQuery;
    private java.util.List musicProductionCompanyList;
    private javax.persistence.Query musicProductionCompanyQuery;
    private misc.MyRenderer myRenderer1;
    private javax.swing.JButton newButton;
    private javax.swing.JButton saveButton;
    private java.util.List songList;
    private javax.persistence.Query songQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
