//ax is main matrix, a is generated matrix
package buttonpro;
import java.util.*;
class generator
{
    
	int[][] gen()
	{
		int x1=0;
		int a[][]=new int[5][5];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				a[i][j]=0;
			}
		}
                        Random ob=new Random();
			int x=ob.nextInt(4);
			int y=ob.nextInt(4);
			while(x==0)
				x=ob.nextInt(4);				
			for(int i=0;i<x;i++)
			{
				while(y==0)
					y=ob.nextInt(4);
				for(int j=0;j<y;j++)
				a[i][j]=1;
			}
			return a;			
	}
}

class game
{
       // Buttonpro xx=new Buttonpro();
//	static generator ob=new generator();
          static int score;
	  int x;//pos
	  int y;//pos
	  int ax[][]=new int[10][10];
	  int a1[][]=new int[5][5];
	  boolean u=false;
	public  int[][] mainy(int x1,int y1,int a1[][])
	{
		int u1=0;
		//System.out.println();		
		x=x1;
		y=y1;
                this.a1=a1;
	 for(int i=0;i<5;i++)
	 {
		 for(int j=0;j<5;j++)
		 {
			 if(a1[i][j]==1)
				 u=chk(x+i,y+j);
			if(u==false)
				break;
		 }
		 if(u==false)
			 break;
	 }
	 if(u==true)
	 {
	 for(int i=0;i<5;i++)
	 {
		 for(int j=0;j<5;j++)
		 {
			 if(a1[i][j]==1)
				 ax[x+i][y+j]=1;
		 }
	 }
	 nully();
         score+=10;
	 }	 
         
         return ax;
    }
	 boolean chk(int x,int y)
	{
		if((x<10 && y<10)&&(ax[x][y]!=1))
		{
		//ax[x][y]=1;
		return true;
		}
		else
			return false;
	}
	 void nully()
	{
		int flag=1;
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(ax[i][j]==0)
                                {
					flag=0;
                                        break;
                                }
			}
			if(flag==1)
			{
				for(int j=0;j<10;j++)
					ax[i][j]=0;
                                score+=100;
			}
			flag=1;
		}
		flag=1;
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(ax[j][i]==0)
                                {
					flag=0;
                                        break;
                                }
			}
			if(flag==1)
			{
				for(int j=0;j<10;j++)
					ax[j][i]=0;
                                score+=100;
			}
			flag=1;
		}
	}
         boolean gameover(int a1[][])
         {
             int x1=0;
             int y1=0;
             boolean tt=false;
             boolean ttt=false;
        for(x1=0;x1<10;x1++)
        {
            
           for(y1=0;y1<10;y1++)
           {
               
             for(int i=0;i<5;i++)
             {
                 for(int j=0;j<5;j++)
                 {
                     if(a1[i][j]==1)
                         tt=chk(x1+i,y1+j);
                     if(tt==false)
                         break;
                 }
                 if(tt==false)
                     break;
             }
             if(tt==true)
             {
                 ttt=true;
                 break;
             }
           }
           if(tt==true)
               break;
        }
        return ttt;
         }
         int score()
         {
          return score;   
         }
}