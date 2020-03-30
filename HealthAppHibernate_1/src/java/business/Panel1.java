/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author miken
 */
public class Panel1 extends JFrame
{
    
    public Panel1(double  progressOfSteps)
    {
        
        final JFrame frame = new JFrame("JProgress Demo");
        
        // creates progress bar
        final JProgressBar pb = new JProgressBar();        
        pb.setMinimum(0);
        pb.setMaximum(100);
        pb.setStringPainted(true);
 
        // beggining of code for progress bar
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(pb);
 
        
        //frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(90, 90);
        //frame.setVisible(true);
 
        float  MAX = Math.round(progressOfSteps);
        // update progressbar
        for (int i = 0; i <= progressOfSteps; i++) 
        {
            final int currentValue = i;
            try 
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run() 
                    {
                        pb.setValue(currentValue);
                    }
                });
                java.lang.Thread.sleep(0);
            } catch (InterruptedException e) 
            {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }
        
        
      
        
        
        
        
    }
    
    
}
