package GUI;

import gamemaster.Player;
import gamemaster.Utilities;
import gamemaster.Connector;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import stateholder.Keli;
import stateholder.Move;
/**
 * GraphicBoard class extends JFrame
 * Dimiourgei mia diepafi grafikwn
 * @author Muron Stavros
 * @version 1.0
 */
public class GraphicBoard extends JFrame 
{
	private static Keli cell;
	private static int click=1;
	private JPanel Playerpanel;
	private JLabel Playerlabel;
	private JPanel Cpanel;
	private JPanel Wpanel;
	private JPanel Spanel;
	private GraphicKeli[][] Clabel;
	private JLabel[] Wlabel;
	private JLabel[] Slabel;
	private Keli[][] board=new Keli[8][8];
	private Connector mesazon;
	private GraphicMenu menu;
	private Player player;
	
	/**
	 * Costructor: Dimiourgei mia diepafi grafikwn
	 * i opoia emfanizei ena Jframe me onoma Java Chess
	 * diastaseis 700x750 me menu kai to topothetei
	 * sto kentro tis othonis
	 */
	public GraphicBoard()
	{
		super("Java Chess");
		this.board=Utilities.newGame();
		this.mesazon=new Connector(this.board);			
		 // Get the size of the screen
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	    
	    // Determine the new location of the window
	    int w = this.getSize().width;
	    int h = this.getSize().height;
	    int x = (dim.width-w)/5;
	    int y = (dim.height-h)/8;	    
	    // Move the window
	    this.setLocation(x, y);		
		this.setSize(700, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initiMenuBar(true);
		this.setVisible(true);
	}
	
	//emfanizei tin skakiera sto Jframe
	void setBoard(Keli[][] board)
	{
		boolean a=this.menu.getRadioButton();
		this.getContentPane().removeAll();
		this.mesazon.setBoard(board);
		this.board=board;
		initializePlayerPanel();
		initiMenuBar(a);
		initializeBoard();
		initializeSpanel();
		initializeWpanel();
		initializeCpanel();
		initialize();
		this.setVisible(true);
	}
	
	//dimiourgei ena JPanel to opoio emfanizei to currentplayer
	private void initializePlayerPanel()
	{
		Playerpanel=new JPanel();
		String color;
		if(Player.getCurrentColor()=='w')
		{
			color="white";
		}
		else
		{
			color="black";
		}
		Playerlabel=new JLabel("Current player \""+Player.getCurrentPlayer()+"\"  Player color \""+color+"\"");
		Playerpanel.add(Playerlabel);
	}
	
	//Dimiourgei JPanel pou periexei Jlabels me ta gramata twn seirwn tis skakieras(a,b,c,d,e,f,g,h)
	private void initializeWpanel()
	{
		Wlabel=new JLabel[8];
		Wlabel[0]=new JLabel("a",JLabel.CENTER);  Wlabel[0].setOpaque(true);  Wlabel[0].setBackground(Color.orange);  this.Wpanel.add(Wlabel[0]);
		Wlabel[1]=new JLabel("b",JLabel.CENTER);  Wlabel[1].setOpaque(true);  Wlabel[1].setBackground(Color.pink);  this.Wpanel.add(Wlabel[1]);
		Wlabel[2]=new JLabel("c",JLabel.CENTER);  Wlabel[2].setOpaque(true);  Wlabel[2].setBackground(Color.orange);  this.Wpanel.add(Wlabel[2]);
		Wlabel[3]=new JLabel("d",JLabel.CENTER);  Wlabel[3].setOpaque(true);  Wlabel[3].setBackground(Color.pink);  this.Wpanel.add(Wlabel[3]);
		Wlabel[4]=new JLabel("e",JLabel.CENTER);  Wlabel[4].setOpaque(true);  Wlabel[4].setBackground(Color.orange);  this.Wpanel.add(Wlabel[4]);
		Wlabel[5]=new JLabel("f",JLabel.CENTER);  Wlabel[5].setOpaque(true);  Wlabel[5].setBackground(Color.pink);  this.Wpanel.add(Wlabel[5]);
		Wlabel[6]=new JLabel("g",JLabel.CENTER);  Wlabel[6].setOpaque(true);  Wlabel[6].setBackground(Color.orange);  this.Wpanel.add(Wlabel[6]);
		Wlabel[7]=new JLabel("h",JLabel.CENTER);  Wlabel[7].setOpaque(true);  Wlabel[7].setBackground(Color.pink);  this.Wpanel.add(Wlabel[7]);
	}
	
	//Dimiourgei JPanel pou periexei Jlabels me tous arithmous twn sthlwn tis skakieras(1,2,3,4,5,6,7,8)
	private void initializeSpanel()
	{
		int i;
		Slabel=new JLabel[8];
		for(i=0;i<8;i++)
		{
			if(i%2==0)
			{
				Slabel[i]=new JLabel(""+(i+1),JLabel.CENTER);
				Slabel[i].setOpaque(true);  Slabel[i].setBackground(Color.orange);
				this.Spanel.add(Slabel[i]);
			}
			else
			{
				Slabel[i]=new JLabel(""+(i+1),JLabel.CENTER);
				Slabel[i].setOpaque(true);  Slabel[i].setBackground(Color.pink);
				this.Spanel.add(Slabel[i]);
			}
		}
	}
	
	//Dimiourgei Cpanel me tin morfi tis skakieras
	private void initializeCpanel()
	{
		int i,j,k=0;
		this.Clabel= new GraphicKeli[8][8];
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				this.Clabel[i][j]=new GraphicKeli(this.board[i][j],this.mesazon,this);
				this.Cpanel.add(this.Clabel[i][j]);
				k++;
			}
		}
	}
	
	//Orizei ti morfi tis skakieras
	private void initializeBoard()
	{
		this.Cpanel=new JPanel();
		this.Wpanel=new JPanel();
		this.Spanel=new JPanel();
		GridLayout Center=new GridLayout();
		Center.setColumns(8);
		Center.setRows(8);
		GridLayout East=new GridLayout();
		East.setRows(8);
		GridLayout South=new GridLayout();
		South.setColumns(8);
		this.Cpanel.setLayout(Center);
		this.Wpanel.setLayout(East);
		this.Spanel.setLayout(South);	
	}
	
	//Syndeei ola ta Jpanel metaksy tous
	private void initialize()
	{
		GridBagLayout layout=new GridBagLayout();
		this.getContentPane().setLayout(layout);
		GridBagConstraints con=new GridBagConstraints();
		con.ipadx=200;
		con.ipady=200;
		con.gridx=10;
		con.gridy=10;
		con.fill=GridBagConstraints.CENTER;
		con.anchor=GridBagConstraints.CENTER;
		this.getContentPane().add(this.Cpanel,con);
		con.ipadx=10;
		con.ipady=355;
		con.gridx=0;
		con.gridy=10;
		con.fill=GridBagConstraints.CENTER;
		this.getContentPane().add(this.Wpanel,con);
		con.ipadx=445;
		con.ipady=0;
		con.gridx=10;
		con.gridy=20;
		con.fill=GridBagConstraints.CENTER;
		this.getContentPane().add(this.Spanel,con);
		con.ipadx=100;
		con.gridx=10;
		con.gridy=0;
		this.getContentPane().add(this.Playerpanel,con);
	}
	
	//Orizei to MenuBar
	private void initiMenuBar(boolean a)
	{
		menu=new GraphicMenu(this,this.mesazon,player);
		menu.initializeMenuBar(a);
		this.setJMenuBar(menu.getMenuBar());
	}
	
	//Xromatizei ta kelia ton dunaton kinisewn tou pioniou pou epileksame
	void Highlight(Vector<Move> propmove)
	{
		int k;
		if(this.menu.getRadioButton())
		{
			for(k=0;k<propmove.size();k++)
			{
				if(this.Clabel[propmove.get(k).getCell().getPosY()][propmove.get(k).getCell().getPosX()].getKeliColor()=='w')
				{
					this.Clabel[propmove.get(k).getCell().getPosY()][propmove.get(k).getCell().getPosX()].setBackground(Color.green.brighter());	
				}
				else
				{
					this.Clabel[propmove.get(k).getCell().getPosY()][propmove.get(k).getCell().getPosX()].setBackground(Color.green.darker());	
				}
			}
		}
	}
	
	//Vazei to arxiko xrwma sta kelia ton dunaton kinisewn tou pioniou pou epileksame
	void clearHighlight(Vector<Move> propmove)
	{
		int k;
		for(k=0;k<propmove.size();k++)
		{
			this.Clabel[propmove.get(k).getCell().getPosY()][propmove.get(k).getCell().getPosX()].clearHighlight();	
		}
	}
	
	static int getClick()
	{
		if(click==1)
		{
			return click;
		}
		else
		{
			return click;
		}
	}
	
	static void setClick(int a)
	{
		click=a;
	}
	
	void setCell(Keli a)
	{
		this.cell=a.clone();
	}
	
	Keli getCell()
	{
		return this.cell;
	}
}
