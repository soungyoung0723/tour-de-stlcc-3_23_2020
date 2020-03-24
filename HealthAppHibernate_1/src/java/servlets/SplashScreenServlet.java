/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Member;
import business.MemberDB;
import business.ProgressBar;
import business.RouteWithSteps;
import business.RouteWithStepsDB;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sun.util.locale.LocaleUtils;

/**
 *
 * @author Michael Mueller
 */
public class SplashScreenServlet extends HttpServlet
{

    public static boolean isInteger(final String s) 
    {
    try
    {
        Integer.parseInt(s);
        return true;
    } catch(NumberFormatException e) 
    {
        return false;
    }
}
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        
        boolean enterWasPressed = true;
        String URL = "/index.jsp"; 
        String msg2 =  "";
        String msg3 ="";
       boolean tourFinished =false;
      
       
        
           String msg4 ="";
        String msg5a ="";
        String msg5 ="";
        String msg6 ="";
        String msg7 ="";
        String msg8 ="";
        String msg9 ="";
        
        String msgTest ="";
        
        
        String msg28 ="";
       String msg29 ="";
        String msgTooManySteps = "";
         String msg10 ="";
        String msg11 ="";
        String msg12 ="";
        String msg13 ="";
        String msg14 ="";
         String msg15 ="";
        String msg16 ="";
        String msg17 ="";
        String msg18 ="";
        String msg19 ="";
         String msg20 ="";
        String msg21 ="";
        String msg26 ="";
        String msg23 ="";
        String msg24 ="";
       
        String msg25 ="";
        
         String msg30 ="";
        String msg31 ="";
        String msg32 ="";
        String msg33 ="";
       
        String msg34 ="";
        
        
        boolean noErrorsAbove =false;
        HttpSession session = request.getSession();
        
         Member  m1=  (Member)session.getAttribute("member");
         request.setAttribute("m1", m1);
         Member member1 = (Member)session.getAttribute("member1");
       
        
        Member m = (Member)session.getAttribute("member");
        int steps = 0;
        
         RouteWithSteps route = new RouteWithSteps();
        
        //Member m3 = (Member)session.getAttribute("member");
      
        
       
        String stepsAsString="";
        try
        {
           
           
            
            
            stepsAsString = request.getParameter("howmanystepstoday");
            
            if("false".equals(m1.getTourfinished().trim()))
            {
                steps = Integer.parseInt(request.getParameter("howmanystepstoday"));
            
            
            }
          
            noErrorsAbove=true;
            
        }
        catch(Exception e)
        {
            
            //msg2 += "ERROR: " + e.getMessage();
            //msg2 +="Enter a number of steps 0 or greater ";
            
            if(steps < 0)
            {
                msg2 += "Enter a number greater than 0 ";
                
            }
           
            BigInteger largerThanInt = new BigInteger((Integer.MAX_VALUE)+""); 
            BigInteger stepsAsBigInt = new BigInteger("0");
           int result=0;
           try
           {
             stepsAsBigInt = new BigInteger(stepsAsString);
             
           }
           catch(Exception r)
           {
               
               
               
               msg2 +="number entered was not a integer number " + "Error: " + r.getMessage() + " <br>";
               
             
               
           }
            
  
           result = stepsAsBigInt.compareTo(largerThanInt);
            
            
                try
                {
                   Integer.parseInt(stepsAsString);
                }
             catch (Exception e1)
             {
                 
                if(result ==0)
                {
                
                
                }
                else if(result==1)    
                {
                
                    msg2 += " number entered was too large " +"<br>" + ""
                            + "number must be less than or equal to "+Integer.MAX_VALUE;
                
                }
                else if(result ==-1)
                {
                
                }  
                else
                {     
                    msg2 += "number entered was not a integer number or was too large "
                        + "of a number " +"<br>";
                }    
             }
                
        }
        
        
        
      
        Member m4 = new Member();
        int steps1 = 0;
       
       
        
        
        int counter = MemberDB.getCurrentCounter(m);
       
        
        
        
        if(counter == (int)Double.NaN)
        {
            MemberDB.setTotalCounter(0, m);
            MemberDB.setTimeStamp(m);
             
        }
      
        
        
        
        
        
        
      
       
        
        if(enterWasPressed==true && steps >= 0 &&noErrorsAbove==true)
        {
            
           
            
            
            
            try
            {
                
                
             
             
             
             //boolean noErrors =true;
                     
           // m.setNoErrors(noErrors);
            }
            
            
            //get the location and store it in a database
            
            catch(Exception r)
            {
                URL = "/HealthLogon.jsp";
                msg2 = "Error: fix later " + r.getMessage();
                request.setAttribute("msg2", msg2);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
        
            }
            
           // MemberDB.DestinationUnlocked(MemberDB.getCurrentSteps(m));
        }
        else
        {
            
            if(steps < 0)
            {
                msg2 += "Enter a number greater than 0 ";
                
            }
            
            if(steps > Integer.MAX_VALUE)
            {
                msg2 += "steps entered was too large of a number ";
                
            }
            
//            if(steps==(int)Double.NaN)
//            {
//                
//                msg2 +="steps entered was not a integer number  ";
//                
//            }
            
            
            
        }
         
        
        
        
        
        
        
      
       
        
        if(enterWasPressed==true && steps >= 0 &&noErrorsAbove==true)
        {
            
            int counter1 =0;
            
            int counter2 = steps;
            if(counter2 > 30000)
            {
                
                while(counter2 > 30000)
                {
                   if(counter2 > 30000)
                   {
                       counter2--;
                       
                   }
                    
                   // counter1++;
                }
                
                steps = counter2;
                msgTooManySteps = "The limit for steps for the day is 30000"+ "<br>";
            }
            else if(steps <=30000)
            {
                
                steps=steps;
                
            }
            
            
            
            
            steps1 =  MemberDB.getCurrentSteps(m);
        
             
            
             
            int stepsFromDataBase =steps1;
           
             double caloriesBurnedForDay = 0.0;
                  caloriesBurnedForDay =  ((steps * 30.0)/63360)* m .getWeight() * .653; 
            //calculation comes from site http://www.jsmadeeasy.com/javascripts/Calculators/Calorie%20Calculator/index.htm
            //there are 63360 inches in a mile
        
           
            
            
            
            
            m.setCaloriesBurned(caloriesBurnedForDay);
            
            MemberDB.setCaloriesForDay(caloriesBurnedForDay,m);
          //  msgTest += "calories burned for day " + MemberDB.getCaloriesForTheDay(m);
            double totalCaloriesBurned =0.0;
            
           
            
            totalCaloriesBurned = caloriesBurnedForDay + ((stepsFromDataBase * 30.0)
                    /63360)*m .getWeight() * .653;
            
           
             Double truncatedDouble = BigDecimal.valueOf(totalCaloriesBurned)
    .setScale(4, RoundingMode.HALF_UP)
    .doubleValue();
            //msgTest += "total calories burned " + totalCaloriesBurned;
            
           // totalCaloriesBurned =  MemberDB.getCurrentTotalCalories(m) + MemberDB.getCaloriesForTheDay(m);
            
         
           
           
            m.setTotalcaloriesburned(truncatedDouble);
            MemberDB.settotalCalories(truncatedDouble, m);
            
            
            int totalSteps = steps + stepsFromDataBase; 
        
            MemberDB.setTotalSteps(totalSteps, m);
           
          
            
            double progressOfSteps = (totalSteps/205920.0) * 100;
            
            String percentComplete =""; 
          Double truncatedDouble1=0.0;
        if( (int)progressOfSteps > 100)
        {
            if((((int)progressOfSteps))>100)
            {
                m.setTourfinished("true");
                MemberDB.updateMember(m);
                
                
                session.setAttribute("member", m1);
                tourFinished=true;
                percentComplete = " The Tour is complete ";
                request.setAttribute("progressofsteps",percentComplete);
                
            }
        }    
        else
            {
                truncatedDouble1 = BigDecimal.valueOf(progressOfSteps)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue();
                
                
                
                m.setTourfinished("false");
                MemberDB.updateMember(m);
                
                session.setAttribute("member", m1);
                percentComplete = truncatedDouble1 + " % of tour complete " + "<br>" ;
                
                request.setAttribute("progressofsteps", percentComplete);
            
            
            }
 
            int myMinimum =0;
            int myMaximum = 205920;
    
           // ProgressBar bar = new ProgressBar();
            
           // bar.updateBar((int)progressOfSteps);
            
            
            //convert steps to miles    
            //difference = (myDistance * myWeight) * .653;
          
           // double totalCurrentCaloriesFromDatabase = MemberDB.getCurrentCalories(m);
            
            
           
            
            
            ++counter;
            Member m3 = m;
            MemberDB.setTotalCounter(counter,m);
            String date = "";
             
            if(counter > 0)
            {
                
              
                //msg2+="startdate " + m3.getStartdate();
            }    
            date = MemberDB.getTheDateStamp(m); 
          
            boolean noErrors = false;
            
           
            
       
             msg2 = "Your total steps of single walking steps(30 inches in a step) since " + date +"<br>"+
                    "is " + MemberDB.getCurrentSteps(m) + " and you've burned around "
                     + MemberDB.getCurrentTotalCalories(m) + " " + "calories since you started!!";
                     
            m.setNoErrors(noErrors);
            
            
            //add a location count in db later to tell when to print you unlocked
            //the location and to deternmine whether to print 
            //how many feet until next locaiton
           
           
              boolean destinationVisited2 =false;
        
            if(MemberDB.getCurrentSteps(m) >= 0 )  
            {
                
                
                
             if((MemberDB.getCurrentSteps(m) >= 0) )       
            {
                
                boolean setToTrue = true;
                 int locID = 1; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),1)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),1)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(1);
                    m.setLoctorf1(setToTrue);
                    destinationVisited2=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                
                
                
                 
                
            }
            
           
          
            if((MemberDB.getCurrentSteps(m) >= 5702) )       
            {
                
                boolean setToTrue = true;
                 int locID = 2; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),2)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),2)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(2);
                    m.setLoctorf2(setToTrue);
                    destinationVisited2=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                
                
                
                 
                
            }
            
            
            
           
       {
           
             boolean destinationVisited3 =false;
          
            if((MemberDB.getCurrentSteps(m) >= 31046) )       
            {
                
                boolean setToTrue = true;
                 int locID = 3; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(3);
                    m.setLoctorf3(setToTrue);
                    destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
            
            
             if((MemberDB.getCurrentSteps(m) >= 73206) )       
            {
                
                 boolean setToTrue = true;
                 int locID = 7; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(7);
                    m.setLoctorf7(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
            
            
             
              if((MemberDB.getCurrentSteps(m) >= 82579) )       
            {
                
                boolean setToTrue = true;
                 int locID = 8; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(8);
                    m.setLoctorf8(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
             
              if((MemberDB.getCurrentSteps(m) >= 92294) )       
             {
                
                 boolean setToTrue = true;
                 int locID = 9; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(9);
                    m.setLoctorf9(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }  
             
             
             if((MemberDB.getCurrentSteps(m) >= 96730) )       
            {
                
                boolean setToTrue = true;
                 int locID = 10; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(10);
                    m.setLoctorf10(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }  
             
             if((MemberDB.getCurrentSteps(m) >= 99898) )       
            {
                
                boolean setToTrue = true;
                 int locID = 11; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(11);
                    m.setLoctorf11(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            } 
             
             
              if((MemberDB.getCurrentSteps(m) >= 110246) )       
            {
                
                boolean setToTrue = true;
                 int locID = 12; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(12);
                    m.setLoctorf12(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
             
             if((MemberDB.getCurrentSteps(m) >= 120806) )       
            {
                
                boolean setToTrue = true;
                 int locID = 13; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),13)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(true,13,route);
                     MemberDB.setLocationValueForMemberToTrue(true,m3.getMemid(),13,route);
                 
                    route.setLocationID(13);
                    m.setLoctorf13(true);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            } 
              
             
              if((MemberDB.getCurrentSteps(m) >= 126086) )       
            {
                
                boolean setToTrue = true;
                 int locID = 14; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(14);
                    m.setLoctorf14(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
             
               if((MemberDB.getCurrentSteps(m) >= 128410) )       
            {
                
                boolean setToTrue = true;
                 int locID = 15; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(15);
                    m.setLoctorf15(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
              
              if((MemberDB.getCurrentSteps(m) >= 130522) )       
            {
                
                boolean setToTrue = true;
                 int locID = 16; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(16);
                    m.setLoctorf16(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            } 
              
              
              if((MemberDB.getCurrentSteps(m) >= 132211) )       
            {
                
                boolean setToTrue = true;
                 int locID = 17; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(17);
                    m.setLoctorf17(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            } 
                
              
              if((MemberDB.getCurrentSteps(m) >= 135168) )       
            {
                
                boolean setToTrue = true;
                 int locID = 18; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(18);
                    m.setLoctorf18(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }  
              
            
               if((MemberDB.getCurrentSteps(m) >= 140026) )       
               {
                
                boolean setToTrue = true;
                 int locID = 19; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(19);
                    m.setLoctorf19(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
               
               
               if((MemberDB.getCurrentSteps(m) >= 143405) )       
            {
                
                boolean setToTrue = true;
                 int locID = 20; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(20);
                    m.setLoctorf20(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }    
              
                if((MemberDB.getCurrentSteps(m) >= 156710) )       
            {
                
                boolean setToTrue = true;
                 int locID = 21; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(21);
                    m.setLoctorf21(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
               
               
               if((MemberDB.getCurrentSteps(m) >= 167693) )       
            {
                
                boolean setToTrue = true;
                 int locID = 22; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(22);
                    m.setLoctorf22(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }   
             
              if((MemberDB.getCurrentSteps(m) >= 182899) )       
            {
                
                boolean setToTrue = true;
                 int locID = 23; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(23);
                    m.setLoctorf23(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }   
               
             if((MemberDB.getCurrentSteps(m) >= 187344) )       
            {
                
                boolean setToTrue = true;
                 int locID = 24; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(24);
                    m.setLoctorf24(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            } 
             
             if((MemberDB.getCurrentSteps(m) >= 194093 ) )       
            {
                
                boolean setToTrue = true;
                 int locID = 25; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(25);
                    m.setLoctorf25(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            } 
             
             
              if((MemberDB.getCurrentSteps(m) >= 194726) )       
            {
                
                boolean setToTrue = true;
                 int locID = 26; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(26);
                    m.setLoctorf26(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            } 
             
              
             if((MemberDB.getCurrentSteps(m) >= 203597) )       
            {
                
                boolean setToTrue = true;
                 int locID = 27; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(27);
                    m.setLoctorf27(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }  
             
             
                if((MemberDB.getCurrentSteps(m) >= 205920) )       
            {
                
                boolean setToTrue = true;
                 int locID = 28; 
                
                 if(MemberDB.getTORFValueForLocation(m3.getMemid(),locID)==true) 
                 {
                     
                    msg3 ="";
                     
                 }
                 else if (MemberDB.getTORFValueForLocation(m3.getMemid().trim(),locID)==false)
                 {
                     
                     RouteWithStepsDB.setLocationValueToTrue(setToTrue,locID,route);
                     MemberDB.setLocationValueForMemberToTrue(setToTrue,m3.getMemid(),locID,route);
                 
                    route.setLocationID(28);
                    m.setLoctorf28(setToTrue);
                    //destinationVisited3=true;
                 }
               
                else
                {
                    
                   
                    
                    
                }
                //route.setUnlockedLocation(noErrors);
                //3 is the location id
                 
  
            }
             
             
              
              
            
            int locid3 =3;
            int locid2 =2;
            
            
                     boolean loc3IsFalse = false;
                     //loc2IsFalse =  (boolean)request.getAttribute("loc2IsFalse");
                
                     if(loc3IsFalse==false)
                     {
                         
                         loc3IsFalse = false;
                         
                         
                     }
                     else if((boolean)request.getAttribute("loc3IsFalse")==true)
                     {
                         loc3IsFalse= true;
                         
                     }
                     
            
                   
                   
                      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),1)==true)
              
                    {
                        
                       
                         msg5a+= "<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,1) + " see Tour Place? " + "<br>"+
                                
                                 "<button id='loc1' value = '1' onclick=form.action='LocationsUnlocked1.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked1.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages"+
              "</a>"+"</td>"+"<br>" ;
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
                         m3.setLoctorf1(true); 
                     
                    }
                   
                     
                     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),2)==true)
              
                    {
                        
                       
                         msg5+=  "<td>" +"You Passed "  + RouteWithStepsDB.getDestination(route,2) + " see Tour Place? " + "<br>"+
                                
                                 "<button id='loc2' value = '2' onclick=form.action='LocationsUnlocked2.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked2.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages"+
              "</a>"+"</td>"+"<br>" ;
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
                         m3.setLoctorf2(true); 
                     
                    }
                           
                     
                     
                       if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),3)==true)
              
                    {
                        
                       
                        msg6+= "<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,3) + " see Tour Place? " + "<br>"+
                                 
                                 "<button id='loc3' value = '3' onclick=form.action='LocationsUnlocked3.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked3.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
                         m3.setLoctorf3(true); 
                     
                    }
                     
                     
                      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),4)==true)
              
                    {
                        
                       
                        msg7+= "<td>" +"You Passed "  + RouteWithStepsDB.getDestination(route,4) + " see Tour Place? " + "<br>"+
                                  
                                 "<button id='loc4' value = '4' onclick=form.action='LocationsUnlocked4.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked4.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages"+
              "</a>"+"</td>"+"<br>" ;
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
                         m3.setLoctorf4(true); 
                     
                    }   
                       
                     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),5)==true)
              
                    {
                        
                       
                         msg8+= "<td>" +" You Passed "  + RouteWithStepsDB.getDestination(route,5) + " see Tour Place? " + "<br>"+
                                  "<input type='button' value='Yes'>" + "<a href='LocationsUnlocked.jsp' id='CreateCourse' >"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash' >"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
                         m3.setLoctorf5(true); 
                     
                    }   
                         
                    
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),6)==true)
              
     {
                        
                       
          msg9+="<td>"  + " You Passed "  + RouteWithStepsDB.getDestination(route,6) + " see Tour Place? " + "<br>"+
                                  "<input type='button' value='Yes'>" + "<a href='LocationsUnlocked.jsp' id='CreateCourse' >"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash' >"+"  stay on this webpage and clear messages "+
              "</a>" + "</td>"+"<br>" ;               
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf6(true); 
                     
    }                    
       
     
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),7)==true)
              
     {
                        
                       
          msg10+="<td>"+   "You Passed "  + RouteWithStepsDB.getDestination(route,7) + " see Tour Place? " + "<br>"+
                                  
                                 "<button id='loc7' value = '7' onclick=form.action='LocationsUnlocked7.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked7.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages"+
              "</a>"+ "</td>"+"<br>" ;             
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf7(true); 
                     
    }   
     
                     
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),8)==true)
              
     {
                        
                       
          msg11+="<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,8) + " See Tour Place? " + "<br>"+
                                  
                                 "<button id='loc8' value = '8' onclick=form.action='LocationsUnlocked8.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked8.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;               
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf8(true); 
                     
    }   
                      
                       
      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),9)==true)
              
     {
                        
                       
           msg12+="<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,9) + " See Tour Place? " + "<br>"+
                                  
                                 "<button id='loc9' value = '9' onclick=form.action='LocationsUnlocked9.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked9.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;               
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf9(true); 
                     
    }                      
      
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),10)==true)
              
     {
                        
        msg13+= "<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,10) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc10' value = '10' onclick=form.action='LocationsUnlocked10.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked10.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;              
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf10(true); 
                     
    } 
      
      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),11)==true)
              
     {
                        
                       
          msg14+="<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,11) + " See Tour Place? " + "<br>"+
                                 
                                 "<button id='loc11' value = '11' onclick=form.action='LocationsUnlocked11.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked11.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ; 
                     
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf11(true); 
                     
    } 
     
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),12)==true)
              
     {
                        
                       
         msg15+="<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,12) + " See Tour Place? " + "<br>"+
                                  
                                 "<button id='loc12' value = '12' onclick=form.action='LocationsUnlocked12.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked12.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;              
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf12(true); 
                     
    } 
      
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),13)==true)
              
     {
                        
                       
         msg16+="<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,13) + " See Tour Place? " + "<br>"+
                                  
                                 "<button id='loc13' value = '13' onclick=form.action='LocationsUnlocked13.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked13.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;                
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf13(true); 
                     
    } 
      
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),14)==true)
              
     {
                        
                       
        msg17+= "<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,14) + " See Tour Place? " + "<br>"+
                                 
                                 "<button id='loc14' value = '14' onclick=form.action='LocationsUnlocked14.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked14.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages"+
              "</a>"+"</td>"+"<br>" ;               
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf14(true); 
                     
    }  
    
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),15)==true)
              
     {
                        
                       
          msg18+="<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,15) + " See Tour Place? " + "<br>"+
                                 
                                 "<button id='loc15' value = '15' onclick=form.action='LocationsUnlocked15.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked15.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages"+
              "</a>"+"</td>"+"<br>" ;              
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf15(true); 
                     
    }  
       
    if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),16)==true)
              
     {
                        
                       
          msg19+="<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,16) + " See Tour Place? " + "<br>"+
                                 
                                 "<button id='loc16' value = '16' onclick=form.action='LocationsUnlocked16.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked16.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages"+
              "</a>"+"</td>"+"<br>" ;               
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf16(true); 
                     
    }  
     
     
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),17)==true)
              
     {
                        
                       
          msg20+= "<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,17) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc17' value = '17' onclick=form.action='LocationsUnlocked17.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked17.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;                
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf17(true); 
                     
    }  
    
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),18)==true)
              
     {
                        
                       
                         
          msg21+= "<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,18) + " See Tour Place? " + "<br>"+
                                 
                                 "<button id='loc18' value = '18' onclick=form.action='LocationsUnlocked18.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked18.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;               
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf18(true); 
                     
    }   
     
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),19)==true)
              
     {
                        
                       
                         
          msg26+= "<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,19) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc19' value = '19' onclick=form.action='LocationsUnlocked19.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked19.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;             
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf19(true); 
                     
    }   
    
      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),20)==true)
              
     {
                        
                       
          msg23+= "<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,20) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc20' value = '20' onclick=form.action='LocationsUnlocked20.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked20.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;              
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf20(true); 
                     
    }    
    
      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),21)==true)
              
     {
                        
                       
             msg24+= "<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,21) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc21' value = '21' onclick=form.action='LocationsUnlocked21.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked21.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;               
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf21(true); 
                     
    }  
    
      
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),22)==true)
              
     {
                        
                       
           msg25+="<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,22) + " See Tour Place? " + "<br>"+
                                  
                                 "<button id='loc22' value = '22' onclick=form.action='LocationsUnlocked22.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked22.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages"+
              "</a>"+"</td>"+"<br>" ;              
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf22(true); 
                     
    }    
      
      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),23)==true)
              
     {
                        
                       
         msg29+=  "<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,23) + " See Tour Place? " + "<br>"+
                               
                                 "<button id='loc23' value = '23' onclick=form.action='LocationsUnlocked23.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked23.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;               
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf23(true); 
                     
    }     
     
    if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),24)==true)
              
     {
                        
                       
         msg30+= "<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,24) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc24' value = '24' onclick=form.action='LocationsUnlocked24.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked24.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;             
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf24(true); 
                     
    }      
      
     if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),25)==true)
              
     {
                        
                       
         msg31+=  "<td>" + "Passed "  + RouteWithStepsDB.getDestination(route,25) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc25' value = '25' onclick=form.action='LocationsUnlocked25.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked25.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;              
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf25(true); 
                     
    }      
     
      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),26)==true)
              
     {
                        
                       
          msg32+="<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,26) + " See Tour Place? " + "<br>"+
                                 
                                 "<button id='loc26' value = '26' onclick=form.action='LocationsUnlocked26.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked26.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;             
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf26(true); 
                     
    } 
    
      
      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),27)==true)
              
     {
                        
                       
          msg33+=  "<td>" + "You Passed "  + RouteWithStepsDB.getDestination(route,27) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc27' value = '27' onclick=form.action='LocationsUnlocked27.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked27.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;                 
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf27(true); 
                     
    }  
      
     
      if(MemberDB.getTORFValueForLocation(m3.getMemid().trim(),28)==true)
              
     {
                        
            msg34+= "<td>" +  "You Passed "  + RouteWithStepsDB.getDestination(route,28) + " See Tour Place? " + "<br>"+
                                
                                 "<button id='loc1' value = '1' onclick=form.action='LocationsUnlocked1.jsp' >"
                                 + "Yes" + "</button>" 
                                 + "<a href='LocationsUnlocked1.jsp'>"+"see location "+ "</a>"+"&nbsp;"+
                                "&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp" +
                      "<input type='button' name='No' value='No'>"+  "<a href='index.jsp' id='splash'>"+" stay on this webpage and clear messages "+
              "</a>"+"</td>"+"<br>" ;             
                       
                    
                         //MemberDB.setLocationValueForMemberToTrueVar2(true,m3.getMemid(),2);   
                         
                         
       m3.setLoctorf28(true); 
                     
    }  
         
     
      
            if((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),2)==false)
                     && 5702-MemberDB.getCurrentSteps(m)>0)
            {
 
                    msg3 = "Good Work! " + "Only " + (5702-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf2(false);
        
                
            } 
           else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),3)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 5702 &&
                     25344-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (31046-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf3(false);
        
                
            } 
             
           /*
           else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),4)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 13115 &&
                     21715-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great Job! " + "Only " + (21715-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT LOCATION!";
                    m.setLoctorf4(false);
        
                
            } 
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),5)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 21715 &&
                     31820-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great Job! " + "Only " + (31820-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT LOCATION!";
                    m.setLoctorf5(false);
        
                
            } 
            
              else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),6)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 31820 &&
                     46440-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great Job! " + "Only " + (46440-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT LOCATION!";
                    m.setLoctorf6(false);
        
                
            } 
            */
               else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),7)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 31046 &&
                     73206-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (73206-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf7(false);
        
                
            } 
            
              else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),8)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 53965 &&
                     82579-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (82579-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf8(false);
        
                
            } 
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),9)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 82579 &&
                     92294-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (92294-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf9(false);
        
                
            } 
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),10)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 92294 &&
                     96730-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (96730-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf10(false);
        
                
            } 
            
            else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),11)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 96730 &&
                     99898-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (99898-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf11(false);
        
                
            } 
            
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),12)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 99898 &&
                     110246-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great Work! " + "Only " + (110246-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf12(false);
        
                
            }
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),13)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 110246 &&
                     120806-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great Work! " + "Only " + (120806-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf13(false);
        
                
            }
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),14)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 120806 &&
                     126086-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great WORK! " + "Only " + (126086-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf14(false);
        
                
            }
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),15)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 126086 &&
                     128410-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great Work! " + "Only " + (128410-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf15(false);
        
                
            }
            
            
              else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),16)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 128410 &&
                     130522-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (130522-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf16(false);
        
                
            }
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),17)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 130522 &&
                     132211-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (132211-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf17(false);
        
                
            }
            
            
              else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),18)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 132211 &&
                     135168-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (135168-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf18(false);
        
                
            }
            
            
              else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),19)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 135168 &&
                     140026-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (140026-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf19(false);
        
                
            }
            
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),20)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 140026 &&
                     143405-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great Work! " + "Only " + (143405-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf20(false);
        
                
            }
            
            
              else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),21)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 143405 &&
                     156710-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Great WORK! " + "Only " + (156710-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf21(false);
        
                
            }
            
            
              else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),22)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 156710 &&
                     167693-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (167693-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf22(false);
        
                
            }
            
            
             else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),23)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 167693 &&
                     182899-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (182899-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf23(false);
        
                
            }
  else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),24)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 182899 &&
                     187344-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (187334-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf24(false);
        
                
            }
            
    else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),25)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 187334 &&
                     194093-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (194093-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf25(false);
        
                
            }
            
  else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),26)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 194093 &&
                     194726-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (194727-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf26(false);
        
                
            }
            
  else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),27)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 194726 &&
                     203597-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (203597-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf27(false);
        
                
            }
            
  else if(((MemberDB.getTORFValueForLocation(m3.getMemid().trim(),28)==false)
                 
                   && MemberDB.getCurrentSteps(m) > 203597 &&
                     205920-MemberDB.getCurrentSteps(m)>0))
            {
 
                    msg3 = "Good Work! " + "Only " + (205920-MemberDB.getCurrentSteps(m)) + " steps to go "
                     + " until the NEXT TOUR PLACE!";
                    m.setLoctorf28(false);
        
                
            }
            

            

        else
        {
            
           
            
            
            
        }     
            
        }
       
       
        }
        }
       
        URL = "/index.jsp";
       
        session.setAttribute("member", m);
        session.setAttribute("routewithsteps",route);
        request.setAttribute("msg2", msg2);
        request.setAttribute("msg3",msg3);
        //request.setAttribute("finishedtour", finishedTour);
        request.setAttribute("m1", m);
        request.setAttribute("msg4", msg4);
         request.setAttribute("msg5", msg5);
        request.setAttribute("msg6", msg6);
        request.setAttribute("msgTooManySteps", msgTooManySteps);
        request.setAttribute("msg7", msg7);
         request.setAttribute("msg8", msg8);
        request.setAttribute("msg9", msg9);
        request.setAttribute("msg10", msg10);
        request.setAttribute("msg11", msg11);
        request.setAttribute("msg12", msg12);
        request.setAttribute("msg13", msg13);
        request.setAttribute("msg14", msg14);
        request.setAttribute("msg15", msg15);
        request.setAttribute("msg16", msg16);
        request.setAttribute("msg17", msg17);
        request.setAttribute("msg18", msg18);
        request.setAttribute("msg19", msg19);
        request.setAttribute("msg20", msg20);
        request.setAttribute("msg21", msg21);
      //  request.setAttribute("msg22", msg22);
        request.setAttribute("msg23", msg23);
        request.setAttribute("msg26", msg26);
        request.setAttribute("msg24", msg24); 
        request.setAttribute("msg25", msg25);
        
        request.setAttribute("msg28", msg28);
        request.setAttribute("msg29", msg29);
        
         request.setAttribute("msg30", msg30);
        request.setAttribute("msg31", msg31); 
         request.setAttribute("msg32", msg32);
        request.setAttribute("msg33", msg33);
        
         request.setAttribute("msg34", msg34);
          request.setAttribute("msg5a", msg5a);
        
        
        
        
        
        request.setAttribute("msgtest", msgTest);
        request.setAttribute("route", route);
        session.setAttribute("route", route);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
       
        }
         
     
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
