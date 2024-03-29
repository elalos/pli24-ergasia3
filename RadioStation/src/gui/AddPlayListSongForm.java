package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import misc.DBManager;
import misc.MyWindowEvent;
import pojos.AlbumSong;
import pojos.PlayListSong;
import pojos.Song;

public class AddPlayListSongForm extends javax.swing.JFrame {

    private EntityManager em;
    private PlayListSong playListSong;
    private List songsAlreadyInPlayList;
    private List albumSongList;
    private Set hashSet;
    private List tempAlbumSongList;
    
    /**
     * Creates new form AddPlayListSong
     */
    public AddPlayListSongForm() {
        initComponents();
    }
    
    public AddPlayListSongForm(PlayListSong playListSong, List albumSongList) {
        this.playListSong = playListSong;
        this.albumSongList = albumSongList;
        
        hashSet = new HashSet<AlbumSong>();
        
        // Αποθήκευση των <Long>songid των τραγουδιών που 
        // υπάρχουν ήδη στη λίστα τραγουδιών σε λίστα
        songsAlreadyInPlayList = new ArrayList();
        for (Object o : albumSongList) {
            songsAlreadyInPlayList.add(((AlbumSong)o).getSongid().getSongid());
        }
        
        // Αντιμετώπιση περίπτωσης η songsAlreadyInPlayList 
        // να είναι άδεια
        if (songsAlreadyInPlayList.isEmpty()) songsAlreadyInPlayList.add(-1);
        
        em = DBManager.em;
        if ( !(em.getTransaction().isActive()) )
            em.getTransaction().begin();
        
        initComponents(); 
        
        tempAlbumSongList = new ArrayList(albumSongList2);
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
        albumSongQuery2 = em.createQuery("SELECT albsong FROM AlbumSong albsong WHERE albsong.songid NOT IN :songlist").setParameter("songlist",songsAlreadyInPlayList);
        albumSongList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(albumSongQuery2.getResultList());
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        myTableRenderer1.setText("myTableRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, albumSongList2, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${songid.title}"));
        columnBinding.setColumnName("Τίτλος");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${albumid}"));
        columnBinding.setColumnName("Καλλιτέχνης / Συγκρότημα");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${albumid.title}"));
        columnBinding.setColumnName("Άλμπουμ");
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

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Τραγούδια");

        searchButton.setText("Αναζήτηση");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        selectButton.setText("Επιλογή");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), selectButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Ακύρωση");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        // Επιλογή τραγουδιού
        int row = jTable1.getSelectedRow();
        playListSong.setSongid(((AlbumSong)albumSongList2.get(row)).getSongid());
        albumSongList.add(albumSongList2.get(row));
        
        MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, true);
        for (WindowListener l : this.getWindowListeners())
            l.windowClosed(we);
        this.setVisible(false);
    }//GEN-LAST:event_selectButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, false);
            for (WindowListener l : this.getWindowListeners())
        l.windowClosed(we);
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        albumSongList2.clear();
        hashSet.clear();
        String str = searchTextField.getText().toLowerCase();
        
        if (searchTextField.getText().isEmpty())
            albumSongList2.addAll(tempAlbumSongList);
        else {
            for (Object o : tempAlbumSongList) {
                if ((((AlbumSong)o).getSongid().getTitle()!=null&&
                        ((AlbumSong)o).getSongid().getTitle().toLowerCase().contains(str))||
                        (((AlbumSong)o).getAlbumid().getArtistid()!=null&&
                        ((AlbumSong)o).getAlbumid().getArtistid().getArtisticname()!=null&&
                        ((AlbumSong)o).getAlbumid().getArtistid().getArtisticname().toLowerCase().contains(str))||
                        (((AlbumSong)o).getAlbumid().getArtistid()!=null&&
                        ((AlbumSong)o).getAlbumid().getArtistid().getLastname()!=null&&
                        ((AlbumSong)o).getAlbumid().getArtistid().getLastname().toLowerCase().contains(str))||
                        (((AlbumSong)o).getAlbumid().getMusicgroupid()!=null&&
                        ((AlbumSong)o).getAlbumid().getMusicgroupid().getName()!=null&&
                        ((AlbumSong)o).getAlbumid().getMusicgroupid().getName().toLowerCase().contains(str)))
                    hashSet.add(o);
            }
            albumSongList2.addAll(hashSet);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddPlayListSongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlayListSongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlayListSongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlayListSongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPlayListSongForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List albumSongList2;
    private javax.persistence.Query albumSongQuery2;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private misc.MyTableRenderer myTableRenderer1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton selectButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
