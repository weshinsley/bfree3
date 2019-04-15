import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.RuntimeUtil;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class TestOverlays {
    
    public static void main(String[] args) {
      final EmbeddedMediaPlayerComponent mp;
      
      NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
      //Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
      mp = new EmbeddedMediaPlayerComponent();
      JFrame movie = new JFrame();
      movie.setSize(1280,720);
      movie.setContentPane(mp);
      movie.setUndecorated(true);
      mp.setSize(1280,720);
      movie.setVisible(true);
      mp.mediaPlayer().media().play("Media/LightStreaksDeepBlueHD.mp4");
      //mp.mediaPlayer().media().getMediaPlayer().parseMedia();
      
      JDialog textFrame = new JDialog();
      textFrame.setSize(1280,720);
      textFrame.setUndecorated(true);
      textFrame.setBackground(new Color(0f,0f,0f,0f));
      textFrame.setForeground(new Color(1f,1f,1f,1f));
      JEditorPane jep = new JEditorPane();
      jep.setOpaque(false);
      jep.setBackground(new Color(0f,0f,0f,0f));
      jep.setForeground(new Color(1f,1f,1f,1f));
      
      jep.setContentType("text/html");
      jep.setText("<html><center><span style=\"font-family:Calibri; font-size:48pt; color:#ffffff\">Jesus is alive! Jesus is alive!<br/>He is risen from the grave and He's alive!<br/>The stone is rolled away! The stone is rolled away!<br/>Did you hear the angel say that He's alive!</span></html>");
      jep.setFont(new Font("Calibri",Font.PLAIN,48));
      textFrame.setContentPane(jep);
      textFrame.setVisible(true);
      textFrame.setAlwaysOnTop(true);
      try { Thread.sleep(5000); } catch (Exception e) {}
      jep.setText("<html><center><span style=\"font-family:Calibri; font-size:48pt; color:#ffffff\">Sing for joy, you've set me free!<br/>All my praise I give to You</span></html>");
      textFrame.update(textFrame.getGraphics());
      jep.update(jep.getGraphics());
      
    }

}