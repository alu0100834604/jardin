//opciones para acomodar las fonteras
import java.awt.BorderLayout;

//acomodar el color (del fondo o de la escritura
import java.awt.Color;

//métodos para crear un container
import java.awt.Container;

//cambiar/acomodar la escritura
import java.awt.Font;

//acomodar los limites de la frontera
import javax.swing.BorderFactory;

//para crear un panel
import javax.swing.JPanel;

//introduce el métodos para un frame
import javax.swing.JFrame;

//el diálogo del colores
import javax.swing.JColorChooser;

//dibujar el rectángulo 
import java.awt.Graphics;

//mostrar un diálogo
import javax.swing.JOptionPane;

//crear un botón
import javax.swing.JButton;

//acomodar el dimensión (de frame etc.)
import java.awt.Dimension;

//implementa el método addactionlistener
import java.awt.event.ActionListener;

//implementa el método actionperformed
import java.awt.event.ActionEvent;

/*
clase para crear la rama 
author: abraham barato/christian siedler
fecha: 14/10/13
*/
public class inter_graphic extends JFrame implements ActionListener 
{
  private JButton changeColorButton; 
  private Color color = Color.LIGHT_GRAY;
  private Container container;
  private int alto;
  private int ancho;
  private int tamano_celda;
  private int offset_x;
  private int offset_y;
  private int[][] escenario;
  private Color[] colores;
  
  /*
  Método para crear un rectángulo y una leyenda
  author: abraham barato/christian siedler
  fecha: 14/10/13
  */
  
  public inter_graphic(int _alto, int _ancho, int _tamano_celda)
  {
    super(" Jardín prueba 1");
    setSize(1300, 700);
    setVisible(true);
    this.ancho = _alto;
    this.alto = _ancho;
    this.tamano_celda = _tamano_celda;
    this.offset_y = 100;
    this.offset_x = 250;
    this.escenario = new int[_ancho][_alto];

    this.escenario[1][1] = 1;
    this.escenario[1][2] = 3;
    this.escenario[1][3] = 3;
    this.escenario[2][2] = 3;
    this.escenario[0][0] = 2;
    this.escenario[2][2] = 3;
    this.escenario[3][2] = 3;

    //---------------------------------------------------------------------
    //editor: christian siedler, 14/10/13, V1.0: botón y diálogo
     //definir un contenedor
      container = getContentPane();
      container.setLayout(new BorderLayout());
    
      //crear und panel para los butóns al derecha
      JPanel rightsidepanel = new JPanel();
 	
	  //crear el butón y añadir un actionListener,  acomodar el tamaño
	  changeColorButton = new JButton("Change color");
	  changeColorButton.setPreferredSize(new Dimension(150,60));
	  changeColorButton.addActionListener(this);
	   
	  //BorderFactory: createEmptyBorder(int top,int left,int bottom,int right)
	  rightsidepanel.setBorder(BorderFactory.createEmptyBorder(250,50,10,10));
    
	  //añadir el botón al panel
	  rightsidepanel.add(changeColorButton, BorderLayout.SOUTH);
	
	  //añadir el contenedor al panel
	  container.add(rightsidepanel,BorderLayout.EAST);
    //--end: christian siedler
    //---------------------------------------------------------------------
    
  }//--end inter_graphic (constructor!)
  
  /*
  evento que cambiar el fondo
  author: christian siedler
  fecha: 14/10/13
  */
  public void actionPerformed(ActionEvent e){
	
		color = JColorChooser.showDialog(
				inter_graphic.this, "Choose a color", color );

		if (color == null) 
				color = Color.LIGHT_GRAY;
		getContentPane().setBackground(color);
		
  }//--end actionperformed 
  
  /*
  Método para crear un rectángulo y una leyenda
  author: abraham barato
  fecha: 14/10/13
  */
  public void leyenda(Graphics g)
  {
    int offset_leyenda = 20;

    String[] texto_leyenda = { "Césped bajo", "Césped alto", "Obstáculo", "Cortacesped" };
    for (int i = 0; i < texto_leyenda.length; i++) {
      g.setColor(this.colores[i]);
      g.fillRect(this.offset_x, this.ancho * this.tamano_celda + this.offset_y + offset_leyenda + this.tamano_celda * i, this.tamano_celda, this.tamano_celda);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Serif", 3, 18));
      g.drawString(texto_leyenda[i], this.offset_x + this.tamano_celda, this.ancho * this.tamano_celda + this.offset_y + offset_leyenda + this.tamano_celda * i + this.tamano_celda / 2);
      
    }
    
  }//--end leyenda

  /*
   Método para crear un rectángulo y una leyenda
   author: abraham barato
   fecha: 14/10/13
   */
  
  public void paint(Graphics g)
  {
   super.paint(g);

    this.colores = new Color[] { 
      new Color(88, 250, 88), 
      new Color(0, 255, 0), 
      new Color(255, 255, 0), 
      new Color(0, 0, 0) };
    for (int i = 0; i < this.alto; i++)
    {
      for (int j = 0; j < this.ancho; j++) {
        int indice_color_celda = this.escenario[i][j];
        g.setColor(this.colores[indice_color_celda]);
        g.drawRect(i * this.tamano_celda + this.offset_x, j * this.tamano_celda + this.offset_y, this.tamano_celda, this.tamano_celda);
        g.fillRect(i * this.tamano_celda + this.offset_x + 1, j * this.tamano_celda + this.offset_y + 1, this.tamano_celda - 1, this.tamano_celda - 1);
     
      }
    }
    
    leyenda(g);


  }//end--paint
  
 

  public static void main(String[] args)
  {
    String dim_str = JOptionPane.showInputDialog("Introduzca el alto");
    int alto = Integer.parseInt(dim_str);
    String dim_str2 = JOptionPane.showInputDialog("Introduzca el ancho");
    int ancho = Integer.parseInt(dim_str2);
    inter_graphic application = new inter_graphic(alto, ancho, 50);
    application.setDefaultCloseOperation(3);
  }//--end main
  
}//--end inter_graphic
