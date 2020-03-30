/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
/**
 *
 * @author miken
 */

       
    
      
public class MyTimerTask extends TimerTask 
{

    @Override
    public void run() 
    {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask() 
    {
        try
        {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(20000);
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
    
}
    
    
    
    
    
 

