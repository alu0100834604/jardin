import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class GridBagLayoutDemo{
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    private int row,column,index=1;
    private String sel_obstacle,sel_field;
    private String ficheropath = "src/camino_salida.txt";
    private String linea, dir, mowpos;
    private int localbutton,obstacletype;
    //todo: make dim dynamically
    private int dim = 6;
    
    //set a specific column, the actual chosen
    public void setcolumn(int _column){
    	this.column = _column;
    }
    //get a specific column, the actual chosen
    public int getcolumn(){
    	return this.column;
    }
    //set a row, the actual chosen
    public void setrow(int _row){
    	this.row = _row;
    }
    //get a specific row, the actual chosen
    public int getrow(){
    	return this.row;
    }
    
    
    //get a field, filled with an obstacle
    public String getobstaclefield(){
    	return this.sel_field;
    }

    public void setobstaclefield(String _sel_field){
    	this.sel_field = _sel_field;
    }
    
    //conversion of index to button number: r1,c1 -> 1 , r1,c2 -> 2 etc...
    public int matr2button(String _matr){
    	//ejemplo: r2,c4
    	int _row,_column,buttonnum=0;
    	
    	try{
    	_row = Character.getNumericValue(_matr.charAt(1));
    	
    	_column = Character.getNumericValue(_matr.charAt(4));
    	//if button is in the first row, select the column, otherwise calculate: 5. button - column 
    	buttonnum = (dim>1) ? (_row - 1) * dim + _column : _column;
    	
    	}
    	catch(Exception e){
    		System.out.println("matr2button failed");
    		
    	}
    	return buttonnum;
    }
    
    public String button2matr(int _button){
    	String _matr = "r1,c1";
    	int _row,_column;
    	
    	try{
    	 _matr = String.valueOf(_button);
    	if(dim>9){
    		_row = Character.getNumericValue(_matr.charAt(0));
    		_column = Character.getNumericValue(_matr.charAt(1));
    		_matr = "r"+ ((_row == 0) ?  "1": _row+1) + ",c" + _column;
    		System.out.println("dim>9: "+_matr);
    	}
    	if(dim<10){
    		_row = 1;
    		while(_button > (_row * dim)){
    			_row+=1;
    		}
    		_matr = "r" + (_row ) + ",c" + (_button - ((_row>1) ? ((_row -1)*dim) : 0));
    		System.out.println("dim<10: "+_matr);
    	}
    	}
    	catch(Exception e){
    		System.out.println("button2matr failed");
    	}

    	return _matr;
    }
    
    //return the path to the file, the exit is stored into
    public String getficheropath(){
    	return this.ficheropath;
    }
    //stores the way out of the garden
    public void setficheropath(String _ficheropath){
    	this.ficheropath = _ficheropath;
    }
    
    //a textfield shows the escape from the garden
    public void setReadTextField(String _setText){
    	this.linea = _setText;
    }
    
    
    //todo: make number of buttons dynamically
    JButton myButton[]=new JButton[dim*dim + 1];
    JTextField myWriteTextField = new JTextField();
	JTextField myReadTextField = new JTextField();
	
	/*
	 * método para set mower (cortacesped)
	 */
	
	//public static final ImageIcon image_working_mower = setinitialmower();
		

	public void setinitialmower(){
		
		try{
			ImageIcon image_working_mower = new ImageIcon("src/mower_working.png");
			
         	myButton[1].setIcon(image_working_mower);
         	myButton[1].setActionCommand("r"+1+",c"+1+"r");
         	mowpos = "r1,c1";
		}
         	catch(Exception e){
				System.out.println("no mower-image found");
	
         	}
	}
	
	/*
	 * método para buscar la salida
	 */
	public void findexit(){
		
		
	}
	/*
	 * getmower
	 */
	public String getmowerpos(){
		
		return this.mowpos;
	}
	
	
	/*
	 * el siguente posicion del cortacesped
	 */
	public void setmowerpos(String _mowpos){
		ImageIcon image_hierba_cortado = new ImageIcon("src/hierba_cortado.png");
		ImageIcon image_working_mower = new ImageIcon("src/mower_working.png");
		//System.out.println(_mowpos);
		//System.out.println(matr2button(_mowpos));
		myButton[matr2button(_mowpos)].setActionCommand(_mowpos + "r");
		//System.out.println(myButton[matr2button(_mowpos)].getActionCommand());
     	myButton[matr2button(_mowpos)].setIcon(image_working_mower);
     	myButton[matr2button(getmowerpos())].setIcon(image_hierba_cortado);
     	this.mowpos = _mowpos;

	}
	
	/*
	 * método para mover
	 */
	
	public int setmower(char _dir){
		
		
		switch (_dir){
		case 'E':
		case 'e':
			setmowerpos("r3,c4");
			System.out.println("dir: e");
			break;
		case 'O':
		case 'o':
			System.out.println("dir: o");
			break;
		case 'N':
		case 'n':
			System.out.println("dir: n");
			break;
		case 'S':
		case 's':
			System.out.println("dir: s");
			break;
		default:
			break;
		
		}
		return 1;
	}
	
	/*
	 * método para cortar
	 */
	public void cortar(){
		
	}
	
	/*
	 * método para poner los obstáculos y la Escritura y Lectura
	 */
	public void setfields(Container pane){
    	//Grid Constraints for buttons, radiobuttons and textfield
    	GridBagConstraints c = new GridBagConstraints();

    	ActionListener myListener = new ActionListener(){
    		
    		//implement: set image with specific picture
    		public void actionPerformed(ActionEvent e){
    			
    			String s = (String)e.getActionCommand();
    			
    			//check for type of button: button contains a number, radiobutton doesnt
    			if(s.matches(".*\\d.*")){
    				//when contains numbers set field and select picture
    				setobstaclefield(e.getActionCommand());
         	    	ImageIcon image_cat = new ImageIcon("src/hierba_cat.png");
         	    	ImageIcon image_tree = new ImageIcon("src/hierba_tree.png");
         	    	localbutton = matr2button(getobstaclefield());
         	    	System.out.println(button2matr(localbutton) + "from obstacles");
         	    	if(obstacletype == 1) {
         	    	
                 	myButton[localbutton].setIcon(image_tree);
                 
         	    	}
         	    	else{ 
         	    	myButton[localbutton].setIcon(image_cat);
         	    	}
    			}
    			//when radiobutton was selected, set either tree or cat to put as a new image
    			else if(s.equals("tree")){
    				//
    				obstacletype = 1;
    			}
    		  	if(s.equals("cat")){
    				obstacletype = 2;
    			}
    		  	
    		}//end actionperformed (click of button or radiobutton)
    	};//and of ActionListener
    	
    	//add buttons and radiobuttons to the panel
    	JRadioButton treeButton = new JRadioButton("Pone arból");

    	treeButton.setActionCommand("tree");
    	treeButton.setSelected(false);
    	
    	JRadioButton catButton = new JRadioButton("Pone cat");

    	catButton.setActionCommand("cat");
    	catButton.setSelected(false);
    	
    	ButtonGroup radiogroup = new ButtonGroup();
    	
    	radiogroup.add(treeButton);
    	radiogroup.add(catButton);
    	
    	
    	catButton.addActionListener(myListener);
    	treeButton.addActionListener(myListener);
  
    	//specify parameters, where to set, height etc.
    	
    //todo: dynamically arrange list
    	c.weightx =0;
    	c.weighty =0;
    	c.gridx = 1;
    	c.gridy = dim+1;
    	c.fill = GridBagConstraints.VERTICAL;
    	pane.add(treeButton,c);
    
    	c.weighty =0;
    	c.weightx =0;
    	c.gridx = 1;
    	c.gridy = dim+2;
    	c.fill = GridBagConstraints.VERTICAL;
    	pane.add(catButton,c);

    	
    	//create buttons and fill with images
    	//counts the buttons
    	index = 1;
    	ButtonGroup mybuttongroup = new ButtonGroup();
    	try{
    		//todo: make rows and columns dynamically
        	for(setrow(1);getrow()<=dim;setrow(getrow()+1)){
            	for(setcolumn(1);getcolumn()<=dim;setcolumn(getcolumn()+1)){
            
            		BufferedImage buttonIcon = ImageIO.read(new File("src/hierba_small.png"));
            		
            		myButton[index] = new JButton(new ImageIcon(buttonIcon));
            		
            		myButton[index].setActionCommand("r" + getrow() + ",c" + getcolumn());
            		
                	myButton[index].setBorder(BorderFactory.createEmptyBorder());
                	myButton[index].setContentAreaFilled(false);
            	
                	myButton[index].addActionListener(myListener);
                
                	c.fill = GridBagConstraints.HORIZONTAL;
                	c.gridx = getcolumn();
                	c.gridy = getrow();
            	
                	pane.add(myButton[index], c);
                	mybuttongroup.add(myButton[index]);
                	index++;
            	} // for inner for (end row)
            }//end for, create buttons (end column)
        	
          
    	}//end try   
    	catch (IOException e){
    		//in case no file exists
    		System.out.println("no garden image found");
    	}//end catch
    }//end setfields
   
    
/*
 * Método para poner texto y escribir en un campo y leer desde un fichero
 */
	 public void settextfield(Container pane){
     	GridBagConstraints c = new GridBagConstraints();

        JButton myReadButton = new JButton("Read text!");
        myReadButton.setActionCommand("Read");
        JButton myWriteButton = new JButton("Write text!");
        myWriteButton.setActionCommand("Write");
        
        //implment ActionListener for Read and Write Text from and to a file
        ActionListener myListener = new ActionListener(){
        
    		public void actionPerformed(ActionEvent e){
    			String s = (String)e.getActionCommand();
    			if(s.equals("Read")){
    				myReadTextField.setText(getficherotext());
    			}
    			if(s.equals("Write")){
    				myWriteTextField.setText(myReadTextField.getText());
    			}
    		}
    		
    	};
    	
    	//put buttons and textfield for read and write text out of file
        //todo: make dynamically
    	c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = dim+3;
        myReadTextField.setText("Read");
        pane.add(myReadTextField,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = dim+4;
        myWriteTextField.setText("Write");
        pane.add(myWriteTextField,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10,0,0,0);
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = dim+5;
        pane.add(myReadButton,c);
        myReadButton.addActionListener(myListener);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10,0,0,0);
        c.gridwidth = 2;
        c.gridx = 3;
        c.gridy = dim+5;
        pane.add(myWriteButton,c);
        myWriteButton.addActionListener(myListener);
        
    }//end setfields
    
	 
	/*
	 * añadir los componentes (textfields, botones..)
	 */
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
    panel.settextfield(pane);
    panel.setinitialmower();
    panel.setmower('E');
    }
    
    public String getficherotext(){
  	  File nombre = null;
  	  String dir = "src/camino_salida.txt";
  	  FileReader filepointer = null;
  	  BufferedReader bufferedpointer = null;
  	  
  	  try{
  		  //initialize la lectura
  		  nombre = new File (dir);
  		  
  		  //fileReader no tiene métodos que permitan leer líneas completas
  		  //pero sí BufferedReader
  		  filepointer = new FileReader (nombre);
  		  bufferedpointer = new BufferedReader(filepointer);
  		  
  		  //leer el fichero
  		  
  		  while((linea=bufferedpointer.readLine())!=null){
  			//System.out.println(linea);
  		  return linea;
  		  }
  		  return "no puedo leer";
  	  }
  	  catch(Exception e){
  		  e.printStackTrace();
  		  return "excepción de catch";
  	  }finally{
  		  // cerrar el fichero si todo va bien
  		  try{
  			  if(null != filepointer) {
  				  filepointer.close();
  			  }//--end close filepointer
  		  }catch (Exception e2){
  			  e2.printStackTrace();
  		  }//--end catch finally
  	  }
  	 
    }//end addComponentes

    
    /*
     * crear el GUI
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
    }//end creatAndShowGUI
 
    /*
     * main, llama al método createAndShowGUI
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }//end main
}//end class

