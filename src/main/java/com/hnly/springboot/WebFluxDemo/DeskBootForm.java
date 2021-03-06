package com.hnly.springboot.WebFluxDemo;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class DeskBootForm implements WindowListener,ActionListener,lgjEventListener
{
	Frame MyMainForm;
	Button StartButton;
    Button CloseButton;
	
    TextField OutInforTextField;
    TextField StatusTextField;
    TextArea OutInforTextArea;
    TextArea StatusTextArea;    
    
    int mRowCount;
    int mUUidCount=10000;
    static  String[] Myargs;      
    int StartFlag;    
    PrintStream Oldout;    
    lgjEventManager MylgjEventManager;
    
    public static void main( String[] args )
    {
    	
    	Myargs= args;
    	if(args.length==1)
    	{
    		new DeskBootForm(args[0]); 
    	}
    	else
    	{
    	   new DeskBootForm(); 
    	}
    		
    	
    }
    public  DeskBootForm() 
   	{
    	
    	MyDeskSpringBootFormInit(); 
   	}
    
    public  DeskBootForm(String InIPListener) 
   	{
    	
    	MyDeskSpringBootFormInit(); 
   	}
    public  void MyDeskSpringBootFormInit() 
	{
		
		    Frame MyMainForm = new Frame("SpringBoot2调试工具【◆李庚君2016-2020◆】");
	        StartButton = new Button("Start");//启动
	        CloseButton = new Button("Close");//关闭
	        
	        StartButton.setFont(new Font("TimesRoman",Font.BOLD,68));
	        CloseButton.setFont(new Font("Times New Roman",Font.BOLD,68));        
	        StartButton.setBackground(Color.GRAY);
	        CloseButton.setBackground(Color.GRAY);        
	        StartButton.setForeground(Color.BLUE);
	        CloseButton.setForeground(Color.BLUE);
	        
	        StartButton.setActionCommand("start");
	        StartButton.addActionListener(this);
	        CloseButton.setActionCommand("close");
	        CloseButton.addActionListener(this);
	        	       
	      	        
	        OutInforTextArea=new TextArea("开始......\n"); 
	        StatusTextArea=new TextArea("就绪......\n");
	        OutInforTextArea.setForeground(Color.green);
	        OutInforTextArea.setBackground(Color.black);
	        StatusTextArea.setForeground(Color.WHITE);
	        StatusTextArea.setBackground(Color.black);
	       
	       
	        MyMainForm.addWindowListener(this);	       
	        MyMainForm.setLayout(new GridLayout(2,2));
	        MyMainForm.add(StartButton);
	        MyMainForm.add(CloseButton);       
	        MyMainForm.add(OutInforTextArea);
	        MyMainForm.add(StatusTextArea);	     

	        MyMainForm.pack();
	        MyMainForm.setSize(1200,1000);
	        MyMainForm.setVisible(true);
	        
	        //-----------------------------------------
	        mRowCount=0;
	        StartFlag=0;
	       	        
	         MylgjEventManager=new lgjEventManager();
	         MylgjEventManager.AddListener(this);
	        
	         try
		       {  
		            Oldout = System.out; 
		            lgjOutputStream MylgjOutputStream=new lgjOutputStream(MylgjEventManager);//传递事件管理对象给自定义输出流
		            PrintStream Myps = new PrintStream(MylgjOutputStream); 
		            System.setOut(Myps); 	
		          
		        }
		      catch (Exception e)
		      {  
		            e.printStackTrace();  
		     
		      }  
		
	}
	
    private void OutMessage(String Str,int Flag)
	{
		
		if(Flag==0)
		{
			StatusTextArea.append(Str+"\n");
		}
		
		else
		{
			mRowCount++;
			OutInforTextArea.append("["+String.valueOf(mRowCount)+"]"+Str+"\n");	
		}
		
	}
    public static void SpringStarter(String[] args) 
    {  
       
    	DeskBootApp.FormStarter(args);
        
    }  
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		String[] args=new String[1];
		args[0]="abc";
		
		if(cmd.equals("start") )
		 {
			
				if( StartFlag==0)
				{
					StartFlag++;
					SpringStarter(Myargs);
					OutMessage("启动服务成功！",0);	
		        	
		        	 System.out.println( " SpringApplication.runing......\n" );
				}				
					 
			  else
			  {
				
				OutMessage("已经启动服务成功！",0);	
			  }
			
			
						
		}
		if(cmd.equals("close") )
		{			
			
			  System.setOut(Oldout);
			  System.exit(0);//退出进程
			
			
		}
	}
    
    
    //自定义事件接收
    public void OutMessageEvent(lgjEventObject event)
    {
    	 OutMessage(String.valueOf(event.ResultCode)+"||"+event.ResultStr,1);
    	       
   
    	 
    }
    
 
     public void windowClosing(WindowEvent e)
	  {    	
		
		   System.out.println("Window Closing event\n");		   
		   System.setOut(Oldout);//恢复原状
		   System.exit(0);
	  }

	  public void windowIconified(WindowEvent e)
	   {
		  System.out.println("WindowIconified event\n");
	   }

       public void windowActivated(WindowEvent e)
        {
           System.out.println("WindowActivated event\n");
        }

      public void windowOpened(WindowEvent e)
        {
    	 System.out.println("windowOpened event\n");
        }
    
       public void windowDeiconified(WindowEvent e) 
        { 
    	 System.out.println("windowDeiconified event\n");
        }
   
       public void windowClosed(WindowEvent e) 
        {
    	 System.out.println("windowClosed event\n");
        }
    
       public void windowDeactivated(WindowEvent e) 
        { 
    	 System.out.println("windowDeactivated event\n");
        }
    
    
    
	
}
