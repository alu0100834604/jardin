import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class GridBagLayoutDemo{
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    private int row,column,index=1;
 	String sel_obstacle,sel_field;
    
    public void setcolumn(int _column){
    	this.column = _column;
    }
    public int getcolumn(){
    	return this.column;
    }
    public void setrow(int _row){
    	this.row = _row;
    }
    public int getrow(){
    	return this.row;
    }
    public String getobstacle(){
    	return this.sel_obstacle;
    }
    public void setobstacle(String _obstacle){
    	this.sel_obstacle = _obstacle;
    }
    public String getobstaclefield(){
    	return this.sel_field;
    }
    public void setobstaclefield(String _sel_field){
    	this.sel_field = _sel_field;
    }
    

    JButton myButton[]=new JButton[10];
    public void setfields(Container pane){
    
	
    	GridBagConstraints c = new GridBagConstraints();
    	
    	try{
	
        	for(setrow(1);getrow()<=5;setrow(getrow()+1)){
            	for(setcolumn(1);getcolumn()<=5;setcolumn(getcolumn()+1)){
            
            		BufferedImage buttonIcon = ImageIO.read(new File("src/hierba_small.png"));
            		ImageIcon hierba = new ImageIcon("src/hierba_small.png");
            		
            		
            		myButton[index] = new JButton(new ImageIcon(buttonIcon));
            		myButton[index].setText(Integer.toString(index+1));
            		myButton[index].setActionCommand("r" + getrow() + ",c" + getcolumn());
            		
                	myButton[index].setBorder(BorderFactory.createEmptyBorder());
                	myButton[index].setContentAreaFilled(false);
            	
                	myButton[index].addActionListener(new ActionListener(){
                		
                	    public void actionPerformed (ActionEvent e){
                	    	 //System.out.println( e.getActionCommand());
                	    	setobstaclefield(e.getActionCommand());
                	    	
                	    	ImageIcon image = new ImageIcon("src/hierba_occupada.png");
                        	myButton[2].setIcon(image);
                	    }
                	    });
            	c.fill = GridBagConstraints.HORIZONTAL;
            	
    
            	c.gridx = getcolumn();
            	c.gridy = getrow();
            	
            	pane.add(myButton[index], c);
            	
            	index++;
            	}
        	}
            
    	} catch (IOException e){
    		System.out.println("false");
    	}
    }
   
    
    public void setobstacles(Container pane){
    	
    	
    	GridBagConstraints c = new GridBagConstraints();
    	//obstacles
    	ActionListener myListener = new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			System.out.println( e.getActionCommand());
    			setobstacle(e.getActionCommand());
    		}
    	};
    	
                	
    	
    	
    	JRadioButton treeButton = new JRadioButton("Pone arból");
    	treeButton.setMnemonic(KeyEvent.VK_N);
    	treeButton.setActionCommand("tree");
    	treeButton.setSelected(false);
    	
    	JRadioButton catButton = new JRadioButton("Pone cat");
    	catButton.setMnemonic(KeyEvent.VK_B);
    	catButton.setActionCommand("cat");
    	catButton.setSelected(false);
    	
    	ButtonGroup group = new ButtonGroup();
    	
    	group.add(treeButton);
    	group.add(catButton);
    	
    	
    	catButton.addActionListener(myListener);
    	treeButton.addActionListener(myListener);
    	
    	
  
    
    	c.weightx =0;
    	c.weighty =0;
    	c.gridx = 1;
    	c.gridy = 6;
    	c.fill = GridBagConstraints.HORIZONTAL;
    	pane.add(treeButton,c);
    
    	c.weighty =0;
    	c.weightx =0;
    	c.gridx = 2;
    	c.gridy = 6;
    	c.fill = GridBagConstraints.HORIZONTAL;
    	pane.add(catButton,c);
    	
    
    	
    }
	
    	
    
    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
 
        
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    if (shouldFill) {
    //natural height, maximum width
    c.fill = GridBagConstraints.HORIZONTAL;
    }
    GridBagLayoutDemo panel = new GridBagLayoutDemo();
   
    panel.setfields(pane);
    panel.setobstacles(pane);
    }


    

    

 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

