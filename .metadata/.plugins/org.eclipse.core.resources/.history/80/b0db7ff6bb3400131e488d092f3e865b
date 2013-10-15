import java.awt.*;  // Per la classe Graphics
import java.applet.*;  // Per la classe Applet
import java.net.*; // Per leURL
import java.awt.event.*;  // Per gli eventi

/*
Come abbiamo gia detto i files per gli applet non sono altro che degli URL
*/

public class VisualizzaImmagine2 extends Applet
{
Image ImmaginePietro;

CheckboxGroup gruppo=new CheckboxGroup();

Checkbox b1=new Checkbox("Ferma",gruppo,true);

Checkbox b2=new Checkbox("Animata",gruppo,false);

Panel p=new Panel(new GridLayout(1,3));

public void init()
{

    setBackground(Color.white);
    setLayout(new BorderLayout());
    ImmaginePietro=getImage(getDocumentBase(),"pietro.jpg");

    p.add(new Label());
    p.add(b1);
    p.add(b2);

    b1.addItemListener(new IL());
    b2.addItemListener(new IL());

    add(p,BorderLayout.SOUTH);

    }

boolean MOVIMENTO=false;

int numero=0;

int inc=1;

public void paint(Graphics g)
{

    if (!MOVIMENTO)
    {
        g.drawImage(ImmaginePietro,0,0,this);

        getAppletContext().showStatus("Visualizzo l'immagine pietro.jpg, Immagine ferma, Applet creata da Pietro Castellucci");

        numero=0;

        }
     else
      {

        g.setPaintMode();

        g.drawImage(Elabora(ImmaginePietro,numero),0,0,this);

        for (int k=0;k<=99;k++)  getAppletContext().showStatus("Visualizzo l'immagine pietro.jpg, Frame "+numero+", Applet creata da Pietro Castellucci");

        getAppletContext().showStatus("Visualizzo l'immagine pietro.jpg, Frame "+numero+", Applet creata da Pietro Castellucci");

        if (numero>=10) inc=-1;

        if (numero<=0) inc=1;

        numero+=inc;

        }

        repaint();

  }

public void update(Graphics g)
{paint(g);}

Image Elabora (Image img, int frm)
{

    return img.getScaledInstance(324-(frm*20), 85-(frm*4),img.SCALE_FAST);

    }


public class IL implements ItemListener
{
    public void itemStateChanged(ItemEvent e)
    {

        if (b1.getState()) MOVIMENTO=false;
            else MOVIMENTO=true;
        repaint();
        }

    }
}