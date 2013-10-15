
 import java.awt.Graphics;

 import java.awt.Color;

 import java.awt.Button;

 import java.awt.BorderLayout;

 import java.awt.GridLayout;

 import java.awt.FlowLayout;

 import java.awt.Panel;

 import java.awt.Label;

 import java.awt.Choice;

 import java.awt.Font;

 import java.awt.Toolkit;

 import java.awt.Checkbox;

 import java.awt.Scrollbar;

 import java.awt.GraphicsEnvironment;

 import java.awt.event.ItemEvent;

 import java.awt.event.ItemListener;

 import java.awt.event.AdjustmentListener;

 import java.awt.event.AdjustmentEvent;

 import java.applet.*;

 public class grafDemo extends Applet
 {

    Scrollbar R=new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 255);

    Scrollbar G=new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 255);

    Scrollbar B=new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 255);

    Choice FN=new Choice();

    Choice GR=new Choice();

    Checkbox F=new Checkbox("Figure chiuse piene",false);

    int [] puntiX={1,100,200,300,399,300,200,100};

    int [] puntiY={200,150,50,150,200,100,250,130};

    int punti=8;

    public void init()
    {

        // Calcolo i Font del sistema:

     //   String[] NOMI=GraphicsEnvironment.
     //             getLocalGraphicsEnvironment().
     //             getAvailableFontFamilyNames();

        /*
        Per Java presente sui browser
            String [] NOMI=Toolkit.getDefaultToolkit().getFontList();
        */

        String [] NOMI=Toolkit.getDefaultToolkit().getFontList();

        try
        {
            int indice=0;

            while (true)
                {

                    FN.addItem(NOMI[indice++]);

                    }

            }
        catch (ArrayIndexOutOfBoundsException e)
        {};

        setLayout(new BorderLayout());

        Panel np=new Panel(new GridLayout(1,3));


        Panel rosso=new Panel(new FlowLayout());
        rosso.add(new Label("Rosso"));
        rosso.add(R);
        np.add(rosso);

        Panel verde=new Panel(new FlowLayout());
        verde.add(new Label("Verde"));
        verde.add(G);
        np.add(verde);

        Panel blu=new Panel(new FlowLayout());
        blu.add(new Label("Blu"));
        blu.add(B);
        np.add(blu);

        R.setUnitIncrement(10);
        R.setValue(255);

        G.setUnitIncrement(10);
        G.setValue(255);

        B.setUnitIncrement(10);
        B.setValue(255);

        add(np,BorderLayout.SOUTH);

        GR.addItem("Linea");

        GR.addItem("Rettangolo");

        GR.addItem("Rettangolo 3D");

        GR.addItem("Rettangolo Arrotondato");

        GR.addItem("Cerchio");

        GR.addItem("Ellisse");

        GR.addItem("Poligono generico");

        GR.addItem("Testo");

        GR.addItem("Arco");

        Panel up=new Panel(new GridLayout(1,3));

        up.add(GR);

        up.add(FN);

        up.add(F);

        add(up,BorderLayout.NORTH);

        R.addAdjustmentListener(new AL());

        G.addAdjustmentListener(new AL());

        B.addAdjustmentListener(new AL());

        GR.addItemListener(new IL());

        FN.addItemListener(new IL());

        F.addItemListener(new IL());

        }


    public void paint(Graphics g)
    {

        g.setColor(new Color(255-R.getValue(),
                             255-G.getValue(),
                             255-B.getValue()
                                ));

        g.setFont(new Font(FN.getSelectedItem(),0,40));

        boolean filled=F.getState();

        int pg=GR.getSelectedIndex();

        g.drawString(GR.getSelectedItem(),1,300);

        if (pg==0)
            {
                g.drawLine(1,100,399,300);
                return;
            }

        if (pg==1)
            {
                g.drawRect(50,100,250,100);
                if (filled) g.fillRect(50,100,250,100);
                return;
            }

        if (pg==2)
            {
                g.draw3DRect(50,100,250,100,true);
                return;
            }

        if (pg==3)
            {
                g.drawRoundRect(50,100,300,100,20,20);
                if (filled) g.fillRoundRect(50,100,300,100,20,20);
                return;
            }

        if (pg==4)
            {
                g.drawOval(100,100,200,200);
                if (filled) g.fillOval(100,100,200,200);
                return;
            }

        if (pg==5)
            {
                g.drawOval(100,100,200,100);
                if (filled) g.fillOval(100,100,200,100);
                return;
            }

        if (pg==6)
            {
                g.drawPolygon(puntiX,puntiY,punti);
                if (filled) g.fillPolygon(puntiX,puntiY,punti);
                return;
            }


        if (pg==7)
            {
                g.drawString("Questa è una stringa",1,200);
                return;
            }

        if (pg==8)
            {
                g.drawArc(1,50,398,200,10,270);
                if (filled) g.fillArc(1,50,398,200,10,270);
                return;
            }




    }

public class IL implements ItemListener
{
    public void itemStateChanged(ItemEvent e)
    {
        repaint();
        }

    }

public class AL implements AdjustmentListener
{
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        repaint();
        }

    }


 }