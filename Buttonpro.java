package buttonpro;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Buttonpro extends JFrame {
    int a1[][]=new int[5][5];
     static int a[][]=new int[10][10];
    generator ob=new generator();
    game ob1=new game();
     JButton b[][]=new JButton[10][10];
     JLabel l;
     JLabel score;
     JButton b1[][]=new JButton[5][5];
      int aa[][]=new int[10][10];//save prev 
         
     GridBagConstraints c=new GridBagConstraints();
    public Buttonpro()
    {
        for(int i=0;i<10;i++)
                {
		 for(int j=0;j<10;j++)
			 a[i][j]=0;
                }    
        String s;
        setLayout(new GridBagLayout());//always
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {         
                 b[i][j]=new JButton(" ");
                 c.fill=GridBagConstraints.HORIZONTAL;
                 c.gridy=i;
                 c.gridx=j;
                 c.gridwidth=1;
                 add(b[i][j],c);
            } 
        }
         l=new JLabel(" ");
                 c.fill=GridBagConstraints.HORIZONTAL;
                 c.gridy=12;
                 c.gridx=0;
                 c.gridwidth=10;
                 add(l,c);
        int h=20;
        int p=0;
       for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {         
                 b1[i][j]=new JButton(" ");
                 c.fill=GridBagConstraints.HORIZONTAL;
                 c.gridy=h;
                 c.gridx=p;
                 p++;
                
                 c.gridwidth=1;
                 add(b1[i][j],c);
            } 
            h++;
            p=0;
        }
        score=new JLabel(" ");
                 c.fill=GridBagConstraints.HORIZONTAL;
                 c.gridy=25;
                 c.gridx=0;
                 c.gridwidth=10;
                 add(score,c);
        a1=ob.gen();
            for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
                {
                    if(a1[i][j]==1)
                    {
                       //b1[i][j].setText("1");
                        b1[i][j].setBackground(Color.red);
                                             }
                    else
                       // b1[i][j].setText("0");
                        b1[i][j].setBackground(Color.WHITE);
                        //b1[i][j].setOpaque(false);
                   // b1[i][j].setBorderPainted(false);
                }
            }
        
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
                b[i][j].addActionListener(new eventz());
       
        }
    }
    class eventz implements ActionListener
    {
       boolean ccc=false;  
           
        public void actionPerformed(ActionEvent e)
        {
            boolean flagg=true; 
            int y=0;       
            int f=0;
            int g=0;
            
            JButton v=(JButton)e.getSource();
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                {
                    if(b[i][j]==v)
                    {
                        f=i;
                        g=j;
                    }
                }
            }
           for(int i=0;i<10;i++)
           {
               for(int j=0;j<10;j++)
               {
                   aa[i][j]=a[i][j];
               }
           }
            ccc=ob1.gameover(a1);
            if(ccc==false)
            {
                //System.out.println("gameover");
                l.setText("GAME OVER!");
                score.setText("Score: "+String.valueOf(ob1.score()));       
                }
    
            else
            {
            a=ob1.mainy(f,g,a1);
            if(Arrays.deepEquals(a, aa))
                flagg=false;
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                {
                    //String x=String.valueOf(a[i][j]);
                    //b[i][j].setText(x);
                    if(a[i][j]==1)
                        b[i][j].setBackground(Color.red);
                    else
                        b[i][j].setBackground(Color.WHITE);
                }
            }
            y++;
             if(flagg==true)
              {
             a1=ob.gen();
        
              }
             flagg=true;
         for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
                {
                    if(a1[i][j]==1)
                    {
                       //b1[i][j].setText("1");
                        b1[i][j].setBackground(Color.red);
                    }
                    else
                       // b1[i][j].setText("0");
                        b1[i][j].setBackground(Color.WHITE);
                }
            }
            } 
        }
    }  
    public static void main(String[] args) {
           Buttonpro g = new Buttonpro();
           g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           g.setSize(1500,1500);
           g.setVisible(true);//always else popup wont appear
           g.setTitle("TILES");
    }    
}