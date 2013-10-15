
 import java.awt.Graphics;

 import java.awt.Color;

 import java.awt.Button;

 import java.awt.BorderLayout;

 import java.awt.GridLayout;

 import java.awt.Panel;

 import java.awt.event.ActionEvent;

 import java.awt.event.ActionListener;

 import java.applet.*;

 public class linee extends Applet
 {

    final int SI=14;

    final int NO=0;

    Button R=new Button("Rosso");

    Button G=new Button("Verde");

    Button B=new Button("Blu");

    int r_=0;

    int g_=0;

    int b_=0;

    int ir=0;

    int ig=0;

    int ib=0;

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

                    ir=SI;
                    ig=NO;
                    ib=NO;
                    repaint();
                    }
                                }

                                        );



        G.addActionListener(new ActionListener()
                               {
                public void actionPerformed(ActionEvent e)
                {

                    ir=NO;
                    ig=SI;
                    ib=NO;
                    repaint();
                    }
                                }

                                        );


        B.addActionListener(new ActionListener()
                              {
               public void actionPerformed(ActionEvent e)
                {

                    ir=NO;
                    ig=NO;
                    ib=SI;
                    repaint();
                    }
                                }

                                        );




        add(np,BorderLayout.SOUTH);

        }

    public void paint(Graphics g)
    {


        for (int i=0;i<200;i+=10)
        {

            g.setColor(new Color(r_,g_,b_));

            r_=r_+ir;
            g_=g_+ig;
            b_=b_+ib;

            g.drawLine(0,i,i,200);

            }

        g.setColor(Color.black);
        g.drawLine(0,0,0,200);
        g.drawLine(0,200,200,200);

        r_=0;
        g_=0;
        b_=0;

        }

    }