package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;
import gamemaster.Player;
import gamemaster.Utilities;
import gamemaster.Connector;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import stateholder.Keli;
/**
 * GraphicMenu class 
 * Dimiourgei to menou tou Jframe
 * @author Muron Stavros
 * @version 1.0
 */
public class GraphicMenu 
{
	private JMenu file;
	private JMenu B2file;
	private JMenu edit;
	private JMenu settings;
	private JMenu help;
	private JMenuBar menu;
	private GraphicBoard board;
	private Connector mesazon;
	private Player player;
	private JRadioButtonMenuItem bRadio;
	
	GraphicMenu(GraphicBoard board,Connector mesazon,Player player)
	{
		this.player=player;
		this.board=board;
		this.mesazon=mesazon;
	}
	
	void initializeMenuBar(boolean a)
	{
		this.menu=new JMenuBar();
		initializeFile();
		initializeEdit();
		initializeSettings(a);
		initializeHelp();
		this.menu.add(this.file);
		this.menu.add(this.edit);
		this.menu.add(this.settings);
		this.menu.add(this.help);
	}
	
	JMenuBar getMenuBar()
	{
		return this.menu;
	}
	
	boolean getRadioButton()
	{
		return this.bRadio.isSelected();
	}
	
	private void initializeHelp()
	{
		this.help=new JMenu("help");
		JMenuItem about=new JMenuItem("About");
		this.help.add(about);
		about.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) 
			{
				clickAbout();
			}
		});
	}
	
	private void initializeFile()
	{
		int i;
		String name;
		this.file=new JMenu("File");
		JMenuItem B1file=new JMenuItem("New game");
		B1file.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) 
			{
				clickNewGame();
			}
		});
		this.B2file=new JMenu("Load");
		File f=new File("saves/");
		if(!f.exists())
		{
			f.mkdir();
		}
		else
		{
			File[] loads=f.listFiles();
			for(i=0;i<loads.length;i++)
			{
				JMenuItem items=new JMenuItem(loads[i].getName());
				items.addMouseListener(new MouseListener()
				{
					public void mouseClicked(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					public void mousePressed(MouseEvent e) {}
					public void mouseReleased(MouseEvent e) 
					{
						clickLoad(((JMenuItem)e.getSource()).getLabel());
					}	
				});
				B2file.add(items);
			}
		}
		JMenuItem B3file=new JMenuItem("Save");
		B3file.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) 
			{
				clickSave();
			}
		});
		JMenuItem B4file=new JMenuItem("Exit");
		B4file.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) 
			{
				clickExit();
			}
		});
		this.file.add(B1file);
		this.file.add(B2file);
		this.file.add(B3file);
		this.file.add(B4file);
	}
	
	private void initializeSettings(boolean a)
	{
		settings=new JMenu("Settings");
		this.bRadio=new JRadioButtonMenuItem("Proposed Moves");
		this.bRadio.setSelected(a);
		settings.add(this.bRadio);
	}
	
	private void initializeEdit()
	{
		this.edit=new JMenu("Edit");
		JMenuItem undo=new JMenuItem("Undo");
		undo.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) 
			{
				clickUndo();
			}	
		});
		this.edit.add(undo);
		JMenuItem redo=new JMenuItem("Redo");
		redo.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) 
			{
				clickRedo();
			}
			
		});
		this.edit.add(redo);
	}
	
	private void clickUndo()
	{
		int i,j;
		Keli[][] temp;
		try
		{
			temp=Utilities.undo(this.mesazon.getBoardsVector());
			for(i=0;i<8;i++)
			{
				for(j=0;j<8;j++)
				{
					if(temp[i][j].hasPiece())
					{
						if(temp[i][j].getPiece().getStartX()==j && temp[i][j].getPiece().getStartY()==i)
						{
							temp[i][j].getPiece().HasNotMoved();
						}
					}
				}
			}
			this.board.setBoard(temp);
			Player.changeCurrentColor();
		}catch(IllegalStateException e)
		{
			JOptionPane.showMessageDialog(this.board,"Previous move doesn't exist");
		}
	}
	
	private void clickRedo()
	{
		int i,j;
		Keli[][] temp;
		try
		{
			temp=Utilities.redo(this.mesazon.getBoardsVector());
			for(i=0;i<8;i++)
			{
				for(j=0;j<8;j++)
				{
					if(temp[i][j].hasPiece())
					{
						if(temp[i][j].getPiece().getStartX()==j && temp[i][j].getPiece().getStartY()==i)
						{
							temp[i][j].getPiece().HasNotMoved();
						}
					}
				}
			}
			this.board.setBoard(temp);
			Player.changeCurrentColor();
		}catch(IllegalStateException e)
		{
			JOptionPane.showMessageDialog(this.board,"Next move doesn't exist");
		}
	}
	
	private void clickNewGame()
	{
		String name1=null;
		while((name1==null || name1.equals("")))
		{
			name1=JOptionPane.showInputDialog(this.board,"Give the name of 1 player");
			if(name1!=null)
			{
				name1=name1.replaceAll(" ", "_");
			}
		}
		String name2=null;
		while((name2==null || name1.equals(name2)|| name2.equals("")))
		{
			name2=JOptionPane.showInputDialog(this.board,"Give the name of 2 player");
			if(name2!=null)
			{
				name2=name2.replaceAll(" ", "_");
			}
			if(name1.equals(name2))
			{
				JOptionPane.showMessageDialog(this.board,"Synonomatoi eistai?\nGive another name");
			}
		}
		String color=null;
		Object[] possibilities = {"White", "Black", "Random"};
		Icon icon=null;
		while(color==null)
		{
				color = (String)JOptionPane.showInputDialog(
		                    this.board,
		                    "Choose the color of player "+name1,
		                    "Color",
		                    JOptionPane.PLAIN_MESSAGE,
		                    icon,
		                    possibilities,
		                    "White");
		}
		if(color.equals("Random"))
		{
			Random random=new Random();
			if(random.nextBoolean()==true)
			{this.player=new Player(name1,name2,'w','b');}
			else
			{this.player=new Player(name1,name2,'b','w');}
		}
		else if(color.equals("White"))
		{
			this.player=new Player(name1,name2,'w','b');
		}
		else
		{
			this.player=new Player(name1,name2,'b','w');
		}
		this.mesazon.resetBoard(Utilities.newGame());
		this.board.setBoard(this.mesazon.getBoard());
	}
	
	
	private void clickLoad(String a)
	{
		int i,j;
		Keli[][] temp;
		try
		{
			temp=Utilities.load(a,player);
			for(i=0;i<8;i++)
			{
				for(j=0;j<8;j++)
				{
					if(temp[i][j].hasPiece())
					{
						if(temp[i][j].getPiece().getStartY()!=i)
						{
							temp[i][j].getPiece().HasMoved();
						}
					}
				}
			}
			this.mesazon.resetBoard(temp);
			this.board.setBoard(this.mesazon.getBoard());
		}catch(IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(this.board,"Wrong filename");
		}
	}
	
	private void clickSave()
	{
		String name=JOptionPane.showInputDialog(this.board,"Give savename");
		try
		{
			if(name!=null && name!="")
			{
				Utilities.save(this.mesazon.getBoard(), name);
			}
		}catch(IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(this.board,"The file already exist");
		}
	}
	
	private void clickExit()
	{
		if(JOptionPane.showConfirmDialog(this.board,"Are u sure u want to exit?")==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	
	private void clickAbout()
	{
		JOptionPane.showMessageDialog(this.board,"             Java Chess\n\n             The editors:\n        Stayros Lyberidis\n            Myron Gourlis\n\n             Version: 1.2.1");
	}
}
