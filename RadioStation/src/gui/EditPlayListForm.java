package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import misc.DBManager;
import misc.MyWindowEvent;
import pojos.AlbumSong;
import pojos.PlayList;
import pojos.PlayListSong;
import pojos.Song;

public class EditPlayListForm extends javax.swing.JFrame {
    
    private PlayList playList1;
    private boolean readOnly;
    private EntityManager em;
    private Song song;
    private PlayListSong playListSong;
    private Long cnt = 0L;
    private AddPlayListSongForm aplsf;
    private JFrame thisFrame;

    /**
     * Creates new form EditMusicGroupAlbumForm
     */
    public EditPlayListForm() {
        initComponents();
    }

    public EditPlayListForm(PlayList pl, boolean readOnly) {
        playList1 = pl;
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

        myTableRenderer1 = new misc.MyTableRenderer();
        playList2 = playList1;
        songQuery = em.createQuery("SELECT pls.songid FROM PlayListSong pls WHERE pls.playlistid=:playlist").setParameter("playlist",playList2);
        songList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(songQuery.getResultList());
        songList.add(new Song(-1L));
        playListSongQuery = em.createQuery("SELECT pls FROM PlayListSong pls WHERE pls.playlistid=:playlist").setParameter("playlist",playList2);
        playListSongList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(playListSongQuery.getResultList());
        albumSongQuery = albumSongQuery = em.createQuery("SELECT albsong FROM AlbumSong albsong WHERE albsong.songid IN :songlist").setParameter("songlist",songList);
        albumSongList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(albumSongQuery.getResultList());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        myTableRenderer1.setText("myTableRenderer2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Διαχείριση Λίστας");

        jLabel2.setText("Περιγραφή:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, playList2, org.jdesktop.beansbinding.ELProperty.create("${name}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Λίστα Τραγουδιών");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, albumSongList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${songid.title}"));
        columnBinding.setColumnName("Τίτλος");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${albumid}"));
        columnBinding.setColumnName("Καλλιτέχνης / Συγκρότημα");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${songid.duration}"));
        columnBinding.setColumnName("Διάρκεια");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setCellRenderer(myTableRenderer1);
        }

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

        jLabel4.setText("Ημερομηνία δημιουργίας:");

        jTextField2.setFocusable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, playList2, org.jdesktop.beansbinding.ELProperty.create("${creationdate}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
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
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 539, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        try {
            playListSong = new PlayListSong();
            playListSong.setPlaylistid(playList1);
            em.persist(playListSong);
            
            aplsf = new AddPlayListSongForm(playListSong, albumSongList);
            aplsf.setTitle("Επιλογή τραγουδιού");
            aplsf.setVisible(true);
            thisFrame = this;
            thisFrame.setEnabled(false);
            aplsf.addWindowListener(new WindowListener() {
                public void windowClosed(WindowEvent arg0) {
                    System.out.println("Window close event occur");
                    if (((MyWindowEvent)arg0).exitAndSave) {
                        playListSongList.add(playListSong);
                        //songList.add(((PlayListSong)playListSong).getSongid());
                        
                        int row = albumSongList.size() - 1;                    
                        jTable1.setRowSelectionInterval(row, row);
                        jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true ));
                        thisFrame.setEnabled(true);
                    }
                    else {
                        thisFrame.setEnabled(true);
                        em.remove(playListSong);                       
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
        
        for (Object o : playListSongList)
            if (((PlayListSong)o).getSongid().equals(((AlbumSong)albumSongList.get(row)).getSongid())) {
                playListSong = (PlayListSong)o;
                em.remove(o); // διαγραφή τραγουδιού από PlayListSong
            }
        
        //songList.remove(((PlayListSong)playListSong).getSongid()); // διαγραφή τραγουδιού από songList
        playListSongList.remove(playListSong); // διαγραφή τραγουδιού από playListSongList
                
        albumSongList.remove(row); // διαγραφή τραγουδιού από albumSongList
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    //Δημιουργία μεθόδου για πάτημα κουμπιού SAVE
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // Υπολογισμός διάρκειας τραγουδιών της λίστας
         for (Object o : playListSongList)   
            if (((PlayListSong)o).getSongid().getDuration() != null)
                cnt += ((PlayListSong)o).getSongid().getDuration().longValue();
        
        // ΑΜΥΝΤΙΚΟΣ ΠΡΟΓΡΑΜΜΑΤΙΣΜΟΣ ΓΙΑ ΔΙΑΡΚΕΙΑ ΛΙΣΤΑΣ ΜΙΣΗΣ ΩΡΑΣ
        if (readOnly == true || cnt >= 1800) {
            MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, true);
            for (WindowListener l : this.getWindowListeners())
            l.windowClosed(we);
            this.setVisible(false); } 
        else {
            String message = "Η λίστα πρέπει να διαθέτει τραγούδια τουλάχιστον μισής ώρας!";
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
            java.util.logging.Logger.getLogger(EditPlayListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPlayListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPlayListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPlayListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditPlayListForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List albumSongList;
    private javax.persistence.Query albumSongQuery;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private misc.MyTableRenderer myTableRenderer1;
    private javax.swing.JButton newButton;
    private pojos.PlayList playList2;
    private java.util.List playListSongList;
    private javax.persistence.Query playListSongQuery;
    private javax.swing.JButton saveButton;
    private java.util.List songList;
    private javax.persistence.Query songQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
