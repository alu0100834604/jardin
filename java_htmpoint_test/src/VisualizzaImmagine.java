import java.awt.*;  // Per la classe Graphics
import java.applet.*;  // Per la classe Applet
import java.net.*; // Per leURL
/*
Come abbiamo gia detto i files per gli applet non sono altro che degli URL
*/

public class VisualizzaImmagine extends Applet
{
Image ImmaginePietro;

public void init()
{

    setBackground(Color.white);

    ImmaginePietro=getImage(getDocumentBase(),"pietro.jpg");

    }

public void paint(Graphics g)
{

    g.drawImage(ImmaginePietro,0,0,this);
    getAppletContext().showStatus("Visualizzo l'immagine pietro.jpg, Applet creata da Pietro Castellucci");

    }

    }