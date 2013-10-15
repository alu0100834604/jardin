
 import java.awt.Graphics;

 import java.awt.Color;

 import java.awt.Button;

 import java.awt.BorderLayout;

 import java.awt.GridLayout;

 import java.awt.Panel;

 import java.awt.event.ActionEvent;

 import java.awt.event.ActionListener;

 import java.applet.*;

 public class rect extends Applet
 {

    Button R=new Button("Rosso");

    Button G=new Button("Verde");

    Button B=new Button("Blu");

    int r_=0;

    int g_=0;

    int b_=0;


    public void init()
    {

        setLayout(new BorderLayout());

        Panel np=new Panel(new GridLayout(1,3));

        np.add(R);

        np.add(G);

        np.add(B);

        R.addActionListener(new ActionListener()
                               {
                public void actionPerformed(ActionEvent e)
                {

                    r_=255;
                    g_=0;
                    b_=0;
                    repaint();
                    }
                                }

                                        );



        G.addActionListener(new ActionListener()
                               {
                public void actionPerformed(ActionEvent e)
                {
                    r_=0;
                    g_=255;
                    b_=0;
                    repaint();
                    }
                                }

                                        );


        B.addActionListener(new ActionListener()
                              {
               public void actionPerformed(ActionEvent e)
                {
                    r_=0;
                    g_=0;
                    b_=255;
                    repaint();
                    }
                                }

                                        );




        add(np,BorderLayout.SOUTH);

        }

    public void paint(Graphics g)
    {

        g.setColor(new Color(r_,g_,b_));
        g.drawRect(1,1,50,50);

        g.draw3DRect(81,1,50,50,false);
        g.draw3DRect(1,60,50,50,true);

        g.drawRoundRect(1,130,100,100,20,20);

        g.fillRoundRect(1,130,100,100,20,20);

    }



 }