package me.legadyn.jframe;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.security.auth.login.LoginException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import me.legadyn.config.AuthKeys;
import me.legadyn.config.Keys;
import me.legadyn.discord.DiscordBot;
import me.legadyn.twitter.TweetSender;
import org.json.simple.parser.ParseException;
import twitter4j.TwitterException;


public class MainFrame extends javax.swing.JFrame {

    static JFrame frame;
    static File tempFile;
    private File selectedFile;
    private Font customFont;
    private OptionsFrame options;
    int px, py;
    
    public MainFrame() throws LoginException, IOException {
        try {
            this.options = new OptionsFrame();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
    //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, MainFrame.class.getResourceAsStream("/Roboto-Medium.ttf")).deriveFont(14f);   

            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(customFont);
            // makesure to derive the size when use

        } catch (IOException e) {        
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
       
        initComponents();
        myInitComponents();
       
        jLabel6.setFont(customFont);
        jLabel6.paintImmediately(jLabel6.getVisibleRect());
        /*CHECKING IF THERE IS A KEYS.JSON FILE IN USERS*/
        if(!areKeyFile(new File(System.getProperty("user.home")))) {
            File createFile = new File(System.getProperty("user.home")+"\\keys.json");
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

        jPanel1 = new javax.swing.JPanel();
        optionTweet = new javax.swing.JCheckBox();
        optionDiscord = new javax.swing.JCheckBox();
        closeButton = new javax.swing.JLabel();
        closeBG = new javax.swing.JLabel();
        optionsButton = new javax.swing.JLabel();
        invisiblegallerybutton = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        areusure = new javax.swing.JLabel();
        gallery = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yesbutton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nobutton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        tweetcount = new javax.swing.JLabel();
        limit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Discordpart = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Twiscord");
        setBackground(new java.awt.Color(102, 153, 255));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(29, 161, 242));

        optionTweet.setBackground(new java.awt.Color(29, 161, 242));
        optionTweet.setFont(customFont.deriveFont(12f));
        optionTweet.setForeground(new java.awt.Color(255, 255, 255));
        optionTweet.setText("Solo Twittear");
        optionTweet.setActionCommand("Solo twittear");
        optionTweet.setBorder(null);
        optionTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionTweetActionPerformed(evt);
            }
        });
        jPanel1.add(optionTweet);

        optionDiscord.setBackground(new java.awt.Color(29, 161, 242));
        optionDiscord.setFont(customFont.deriveFont(12f));
        optionDiscord.setForeground(new java.awt.Color(255, 255, 255));
        optionDiscord.setText("Solo Discord");
        optionDiscord.setActionCommand("Solo twittear");
        optionDiscord.setBorder(null);
        optionDiscord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionDiscordActionPerformed(evt);
            }
        });
        jPanel1.add(optionDiscord);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        closeButton.setBackground(new java.awt.Color(255, 255, 255));
        closeButton.setForeground(new java.awt.Color(255, 153, 204));
        closeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/X.png"))); // NOI18N
        closeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeButtonMousePressed(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 50, 40));

        closeBG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RedBG.png"))); // NOI18N
        closeBG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(closeBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, -1, -1));

        optionsButton.setBackground(new java.awt.Color(255, 255, 255));
        optionsButton.setFont(customFont.deriveFont(18f));
        optionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/options.png"))); // NOI18N
        optionsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsButtonMouseClicked(evt);
            }
        });
        getContentPane().add(optionsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 40, 20));

        invisiblegallerybutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invisiblegallerybutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invisiblegallerybuttonMouseClicked(evt);
            }
        });
        getContentPane().add(invisiblegallerybutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 40, 30));

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 50, 40));

        areusure.setBackground(new java.awt.Color(255, 255, 255));
        areusure.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        areusure.setForeground(new java.awt.Color(255, 255, 255));
        areusure.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        areusure.setText("�Seguro de que quieres enviarlo?");
        getContentPane().add(areusure, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 240, 20));

        gallery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/camicon.png"))); // NOI18N
        getContentPane().add(gallery, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 50, 40));

        jLabel6.setBackground(new java.awt.Color(153, 170, 181));
        jLabel6.setFont(customFont);
        jLabel6.setForeground(new java.awt.Color(153, 170, 181));
        jLabel6.setText("Publica tu anuncio:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        yesbutton.setBackground(new java.awt.Color(88, 101, 242));
        yesbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesbuttonMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SI");
        jLabel1.setPreferredSize(new java.awt.Dimension(15, 18));
        yesbutton.add(jLabel1);

        getContentPane().add(yesbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 40, 30));

        nobutton.setBackground(new java.awt.Color(88, 101, 242));
        nobutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nobuttonMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NO");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setMaximumSize(new java.awt.Dimension(30, 18));
        jLabel5.setMinimumSize(new java.awt.Dimension(30, 17));
        jLabel5.setPreferredSize(new java.awt.Dimension(25, 19));
        nobutton.add(jLabel5);

        getContentPane().add(nobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 40, 30));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setBackground(new java.awt.Color(55, 59, 64));
        jTextArea1.setColumns(10);
        jTextArea1.setForeground(new java.awt.Color(225, 232, 237));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(1);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMinimumSize(new java.awt.Dimension(210, 120));
        jTextArea1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 230, 120));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Componente 2 � 1.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        tweetcount.setBackground(new java.awt.Color(153, 170, 181));
        tweetcount.setForeground(new java.awt.Color(153, 170, 181));
        tweetcount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tweetcount.setText("0");
        getContentPane().add(tweetcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 30, 30));

        limit.setBackground(new java.awt.Color(153, 170, 181));
        limit.setForeground(new java.awt.Color(153, 170, 181));
        limit.setText("/  280");
        getContentPane().add(limit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Componente 1 � 1.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 290, 80));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(235, 232, 237));
        jLabel4.setText("\"write once, announce twice\"");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 250, 90));

        jPanel2.setBackground(new java.awt.Color(88, 101, 242));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setDoubleBuffered(false);
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(235, 232, 237));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ENVIAR");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 90, 40));

        Discordpart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sustracci�n 1.png"))); // NOI18N
        Discordpart.setText("alksdlkajsdkjaksd");
        getContentPane().add(Discordpart, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 382, 400));

        background.setBackground(new java.awt.Color(204, 255, 255));
        background.setForeground(new java.awt.Color(29, 162, 242));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rect�ngulo 2.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void myInitComponents() throws LoginException, IOException {
        //NEW DOCUMENT FOR CUSTOM INSERT STRING AND LIMIT THE CHARACTERS
        jTextArea1.setDocument(new PlainDocument() {
        
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null || jTextArea1.getText().length() >= 280) { //IF LENGTH IS MORE THAN 280, THE DOCUMENT DOESN'T INSERTS AN STRING
            return;
            }
 
        super.insertString(offs, str, a);
        }
    });
        /*GETTING CHARACTER COUNT*/
        jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
          
            @Override
            public void insertUpdate(DocumentEvent e) {
                tweetcount.setText(String.valueOf(e.getDocument().getLength()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tweetcount.setText(String.valueOf(e.getDocument().getLength()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                tweetcount.setText(String.valueOf(e.getDocument().getLength()));
            }
      });
      
        areusure.setVisible(false);
        yesbutton.setVisible(false);
        nobutton.setVisible(false);
        closeBG.setVisible(false);
      
        //START DISCORD BOT
        try {
            new DiscordBot(); 
        } catch(Exception e) {
            
        }
           
    }
    //SEND BUTTON
    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
         //CHEKING IF TEXT ISN'T EMPTY OR IMAGE ISN'T NULL FOR SHOWING AREUSURE DIALOG
        if(jTextArea1.getText().length() >= 1 || image.getIcon() != null) {
            evt.getComponent().setVisible(false);
            areusure.setVisible(true);
            yesbutton.setVisible(true);
            nobutton.setVisible(true);
            image.setVisible(false);
            gallery.setVisible(false);
            jTextArea1.setEnabled(false);
        } else {
            //SEND BUTTON BAD ACTION ANIMATION
            badAction(jPanel2);
         }
    }//GEN-LAST:event_jPanel2MouseClicked

    private void yesbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesbuttonMouseClicked
        
        //CHECKING IF DISCORD TOKEN IS FINE
       try {
            //ONLY TWITTER SEND
            if(optionTweet.isSelected() && !optionDiscord.isSelected()) {
                sendTweet(jTextArea1.getText(), selectedFile);
                
                
            } //ONLY DISCORD SEND 
            else if(!optionTweet.isSelected() && optionDiscord.isSelected()) {
                sendDiscordMessage(jTextArea1.getText(), selectedFile, new Keys().getKey(AuthKeys.CHANNEL_ID));
                
              //BOTH SENDING
            } else {
                sendDiscordMessage(jTextArea1.getText(), selectedFile, new Keys().getKey(AuthKeys.CHANNEL_ID));
                sendTweet(jTextArea1.getText(), selectedFile);
                
            }
            
        } catch (TwitterException ex) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ErrorFrame().setLocationRelativeTo(frame);
                    Logger.getLogger(OptionsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            });           
            jTextArea1.setEnabled(true);
            return;
        } catch (IOException ex) {
            
        } catch(NullPointerException ex) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ErrorFrame().setLocationRelativeTo(frame);
                    Logger.getLogger(OptionsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            });           
            jTextArea1.setEnabled(true);
            return;
        }
       
        
        jTextArea1.setEnabled(false);
        areusure.setText("Espera...");
        areusure.paintImmediately(areusure.getVisibleRect()); //UPDATE TEXT
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        areusure.setText("�Anuncio publicado!");
        areusure.paintImmediately(areusure.getVisibleRect()); //UPDATE TEXT
        yesbutton.setVisible(false);
        nobutton.setVisible(false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        areusure.setVisible(false);
        areusure.setText("�Seguro que quieres enviarlo?");
        areusure.paintImmediately(areusure.getVisibleRect()); //UPDATE TEXT
        jPanel2.setVisible(true);
        //CHECKS IF IMAGE IS NULL OR NOT TO SHOW IT 
        if(image.getIcon() == null) {
            gallery.setVisible(true);
        } else {
                image.setVisible(true);
        }
        
        jTextArea1.setEnabled(true);
        
        
    }//GEN-LAST:event_yesbuttonMouseClicked

    private void nobuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nobuttonMouseClicked
        areusure.setVisible(false);
        yesbutton.setVisible(false);
        nobutton.setVisible(false);
        jPanel2.setVisible(true);
        if(image.getIcon() == null) {
            gallery.setVisible(true);
        } else {
            image.setVisible(true);
        }
        
    }//GEN-LAST:event_nobuttonMouseClicked

    private void invisiblegallerybuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invisiblegallerybuttonMouseClicked
         JFileChooser chooser = new JFileChooser();
        
        int result = chooser.showOpenDialog(null); //RESULT IS FOR GETTING APROVED OR NOT
        if (result == JFileChooser.APPROVE_OPTION) {
            image.setVisible(true);
            gallery.setVisible(false);
            selectedFile = chooser.getSelectedFile(); //CHOOSED IMAGE IN A FILE
        }
        if (result == JFileChooser.CANCEL_OPTION) {
            gallery.setVisible(true);
            image.setVisible(false);
            return;
        }
        ImageIcon img = null;
        //CHECKING IF IMAGE ISN'T NULL AND IF IT'S A PNG, JPG, ETC.
        if(selectedFile != null && isImage(selectedFile)) {
            img = new ImageIcon(selectedFile.getAbsolutePath());
        } else {
            //BAD IMAGE ANIMATION
            gallery.setVisible(true);
            gallery.setIcon(new ImageIcon(getClass().getResource("/camiconx.png")));
            gallery.paintImmediately(gallery.getVisibleRect());
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            gallery.setIcon(new ImageIcon(getClass().getResource("/camicon.png")));
            gallery.paintImmediately(gallery.getVisibleRect());
            return;
        }
        Image img1 = img.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH); //SCALING IMAGE
        Icon imageIcon = new ImageIcon(img1); //PASSING IMAGE TO ICON
        image.setIcon(imageIcon);
        image.paintImmediately(image.getVisibleRect()); //UPDATING LABEL
    }//GEN-LAST:event_invisiblegallerybuttonMouseClicked

    private void optionTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionTweetActionPerformed
        if (optionDiscord.isSelected()) {
            optionDiscord.setSelected(false);
            return;
        }
    }//GEN-LAST:event_optionTweetActionPerformed

    private void optionDiscordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionDiscordActionPerformed
        if (optionTweet.isSelected()) {
            optionTweet.setSelected(false);
            return;
        }
    }//GEN-LAST:event_optionDiscordActionPerformed

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        closeBG.setVisible(true);
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        closeBG.setVisible(false);
    }//GEN-LAST:event_closeButtonMouseExited

    private void closeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMousePressed
        System.exit(0);
    }//GEN-LAST:event_closeButtonMousePressed
    //GETTING PX AND PY TO MOVE FRAME SYSTEM
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        px = evt.getX();
        py = evt.getY(); 
    }//GEN-LAST:event_formMousePressed
    //MOVING FRAME WHEN DRAGGING
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        evt.getComponent().setLocation(frame.getLocation().x + evt.getX() - px, frame.getLocation().y + evt.getY() - py);
    }//GEN-LAST:event_formMouseDragged

    private void optionsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsButtonMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    options.setLocationRelativeTo(frame);
                    options.setVisible(true);

            }
        });
    }//GEN-LAST:event_optionsButtonMouseClicked
    
       public void sendTweet(String message, File img) throws TwitterException, IOException {
        new TweetSender(message, img);
    }
    public void sendDiscordMessage(String message, File img, String channelID) {
        
        if(message.isEmpty()) message = " ";
        if(img == null) {
            DiscordBot.jda.getTextChannelById(channelID).sendMessage(message + "\n \n @everyone").queue();
        } else {
            DiscordBot.jda.getTextChannelById(channelID).sendMessage(message + "\n \n @everyone").addFile(img).queue();
        }
        
    }
    
    public boolean isImage(File file) {
        
        String[] filename = file.getName().split("\\.");
        System.out.println(filename[1]);
        if(filename[1].equalsIgnoreCase("jpg") || filename[1].equalsIgnoreCase("png") || filename[1].equalsIgnoreCase("jpeg")) {
            return true;
        } else {
            return false;
        }
      
    }
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try {
                    frame = new MainFrame(); //PROGRAM AND COMPONENTS INITIALIZE
                    frame.setLocationRelativeTo(null);
                    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/twisclogo.png")));
                //tempFile = new File(System.getProperty("user.home")+"/keys.json");
                } catch (LoginException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.setVisible(true);
                
                
            }
        });
    }
    public void badAction(JPanel jpanel) {
            jpanel.setBackground(Color.red);
            jpanel.paintImmediately(jpanel.getVisibleRect());
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            jpanel.setBackground(new Color(88,101,242));
            jpanel.paintImmediately(jpanel.getVisibleRect());
            return;
        }
    public boolean areKeyFile(final File folder) {
        for(File file : folder.listFiles()) {
            if(file.getName().equalsIgnoreCase("keys.json")) {
                return true;
            } 
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Discordpart;
    public static javax.swing.JLabel areusure;
    public static javax.swing.JLabel background;
    public static javax.swing.JLabel closeBG;
    public static javax.swing.JLabel closeButton;
    public static javax.swing.JLabel gallery;
    public static javax.swing.JLabel image;
    public static javax.swing.JLabel invisiblegallerybutton;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JLabel limit;
    public static javax.swing.JPanel nobutton;
    public static javax.swing.JCheckBox optionDiscord;
    public static javax.swing.JCheckBox optionTweet;
    public static javax.swing.JLabel optionsButton;
    public static javax.swing.JLabel tweetcount;
    public static javax.swing.JPanel yesbutton;
    // End of variables declaration//GEN-END:variables
}
