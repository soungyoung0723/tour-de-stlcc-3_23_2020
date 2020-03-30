package  business;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Michael Mueller
 */
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class ProgressBar extends JPanel
{

  JProgressBar pbar;

  static int min = 0;

  static int max = 100;

  private  static long progress =0;
  
  boolean createNew = false;
  
  double proGress =0.0;
  
  
  
       
 
  
  public ProgressBar(double progress,boolean neednewpanel)
  {
    
       JFrame frame =  new JFrame("JProgress Demo");;
       JProgressBar pb = new JProgressBar();
      if(neednewpanel==true)
      {
      
            frame = new JFrame("Progress");
            pb = new JProgressBar();
            
      } 
      else
      {
      
          
          
        pb.setMinimum(0);
        pb.setMaximum(100);
        pb.setStringPainted(true);
 
        // beggining of code for progress bar
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(pb);
 
        
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
 
        float  MAX = Math.round(progress);
        // update progressbar
        for (int i = 0; i <= progress; i++) 
        {
            final int currentValue = i;
            try 
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run() 
                    {
                //        pb.setValue(currentValue);
                    }
                });
                java.lang.Thread.sleep(0);
            } catch (InterruptedException e) 
            {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }
 
      }
      /*
    pbar = new JProgressBar();
    pbar.setMinimum(min);
    pbar.setMaximum(progress);
    add(pbar);
    
    JFrame frame = new JFrame("Progress Bar Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(this);
    frame.pack();
    frame.setVisible(true);

     for (int i = 0; i <= 100; i++) 
        {
            final int currentValue = i;
            try 
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run() 
                    {
                        pbar.setValue(currentValue);
                    }
                });
                java.lang.Thread.sleep(0);
            } catch (InterruptedException e) 
            {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }
  
     
     */
    /*
    for (int i = min; i <= max; i++) 
    {
        
      final int percent = i;
      try {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            updateBar(percent);
          }
        });
        Thread.sleep(100);
      } catch (InterruptedException e) 
      {
      }
    }
    */
  }
/*
  public void updateBar(int newValue)
  {
    pbar.setValue(newValue);
  }

  
  */
   
 
  
}