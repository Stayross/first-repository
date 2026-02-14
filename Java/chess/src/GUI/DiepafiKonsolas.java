package GUI;

import gamemaster.Player;
import gamemaster.Utilities;
import gamemaster.Connector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import stateholder.Keli;

/**
 * DiepafiKonsolas class
 * Diepafi tou xristi me ton stateholder kai ton gamemaster
 * meso consolas(entoles apo pliktrologio)
 * @author Stavros Muron
 * @version 1.0
 */
public class DiepafiKonsolas {
	
	private String player1name;
	private String player2name;
	private char player1color;
	private char player2color;
	private boolean Newgame;
	private boolean Save;
	private boolean Load;
	private boolean Previous;
	private boolean Next;
	private int x2;
	private int y2;
	private int x1;
	private int y1;
	private Keli cell1;
	private Keli cell2;
	private Keli[][] board;
	private Player player;
	private Connector game;
	
	/**
	 * Constructor: Dimiourgei mia diepafi consolas
	 */
	public DiepafiKonsolas()
	{
		startgame();
	}
	/**
	 * Dinei ton pinaka Keli[8][8] se alfarithmitiki morfi
	 * Kanei overide tin methodo toString tis java.lang.object
	 * @return String pou periexei tin skakiera Keli[8][8] stin alfarithmitiki morfi tis
	 */
	public String toString()
	{
		int i,j;
		String A="";
		for(i=0;i<8;i++)
		{
			A=A+"|-||---|---|---|---|---|---|---|---|";
			A=A+"\n";
			for(j=0;j<8;j++)
			{
				if(this.board[i][j].getPiece()==null)
				{
					if(j==0)
					{
						if(i==0)
						{
							A=A+"|a|";
						}
						else if(i==1)
						{
							A=A+"|b|";
						}
						else if(i==2)
						{
							A=A+"|c|";
						}
						else if(i==3)
						{
							A=A+"|d|";
						}
						else if(i==4)
						{
							A=A+"|e|";
						}
						else if(i==5)
						{
							A=A+"|f|";
						}
						else if(i==6)
						{
							A=A+"|g|";
						}
						else if(i==7)
						{
							A=A+"|h|";
						}										
					}
					if(j!=7)
					{
						A=A+"|   ";
					}
					else
					{
						A=A+"|   |";
					}
				}
				else if(this.board[i][j].getPiece() != null)
				{
					if(j==0)
					{
						if(i==0)
						{
							A=A+"|a|";
						}
						else if(i==1)
						{
							A=A+"|b|";
						}
						else if(i==2)
						{
							A=A+"|c|";
						}
						else if(i==3)
						{
							A=A+"|d|";
						}
						else if(i==4)
						{
							A=A+"|e|";
						}
						else if(i==5)
						{
							A=A+"|f|";
						}
						else if(i==6)
						{
							A=A+"|g|";
						}
						else if(i==7)
						{
							A=A+"|h|";
						}						
					}
					if(this.board[i][j].getPiece().getColor()=='w')
					{												
						if(this.board[i][j].getPiece().getName()=="King")
						{
							if(j!=7)
							{
								A=A+"| W ";
							}
							else
							{
								A=A+"| W |";
							}
						}
						else 
						{
							if(j!=7)
							{
								A=A+"| "+this.board[i][j].getPiece().getName().substring(0,1)+" ";
							}
							else
							{
								A=A+"| "+this.board[i][j].getPiece().getName().substring(0,1)+" |";
							}
						}
					}
					else
					{
						if(this.board[i][j].getPiece().getName()=="King")
						{
							if(j!=7)
							{
								A=A+"| w ";
							}
							else
							{
								A=A+"| w |";
							}
						}
						else 
						{
							if(j!=7)
							{
								A=A+"| "+this.board[i][j].getPiece().getName().substring(0,1).toLowerCase()+" ";
							}
							else
							{
								A=A+"| "+this.board[i][j].getPiece().getName().substring(0,1).toLowerCase()+" |";
							}
						}
					}
				}
			}
			A=A+"\n";			
		}
		A=A+"|-||---|---|---|---|---|---|---|---|";
		A=A+"\n   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |";
		return A;
	}
	
	private void startgame() {

		getPlayersInformations();
		if(this.player1color=='b')
		{
			player=new Player(this.player2name, this.player1name, this.player2color, this.player1color);
		}
		else
		{
			player=new Player(this.player1name, this.player2name, this.player1color, this.player2color);
		}
		this.game=new Connector(Utilities.newGame());
		this.game.resetBoard(Utilities.newGame());
		this.board=this.game.getBoard();
		System.out.println(toString());
		System.out.println("o paixtis "+player.getCurrentPlayer()+" exei seira na paiksei");
		while(scan())
		{
			if(this.Newgame)
			{
				getPlayersInformations();
				if(this.player1color=='b')
				{
					player=new Player(this.player2name, this.player1name, this.player2color, this.player1color);
				}
				else
				{
					player=new Player(this.player1name, this.player2name, this.player1color, this.player2color);
				}
				this.board=Utilities.newGame();
				this.game.resetBoard(this.board);
				System.out.println(toString());
				System.out.println("o paixtis "+player.getCurrentPlayer()+" exei seira na paiksei");
				this.Newgame=false;
			}
			else if(this.Load)
			{
				System.out.println("Give the file name");
				InputStreamReader reader;
				reader=new InputStreamReader(System.in);
				BufferedReader scan= new BufferedReader(reader);
				String name=null;
				try {
					name = scan.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				load(name);
				System.out.println(toString());
				this.Load=false;
			}
			else if(this.Save)
			{
				saveGame();
				System.out.println(toString());
				this.Save=false;
			}
			else if(this.Next)
			{
				nextMove();
				System.out.println(toString());
				this.Next=false;
			}
			else if(this.Previous)
			{
				previousMove();
				System.out.println(toString());
				this.Previous=false;
			}
			else
			{
				cell1=board[this.y1][this.x1];
				cell2=board[this.y2][this.x2];
				
				if(cell1.hasPiece())
				{
					if(cell1.getPiece().getColor()==player.getCurrentColor())
					{
						this.game.setKeliFrom(this.cell1);
						this.game.setProposedMoves();
						this.game.setKeliTo(this.cell2);
						
						checkforpromotion();
						this.game.makeTheMove();
						this.board=this.game.getBoard();
						/*if(Event.isMat(this.board))
						{
							System.out.println("Mat");
						}
						else if(Event.isPat(this.board))
						{
							System.out.println("Pat");
						}
						else
						{
							System.out.println(toString());
							System.out.println("o paixtis "+player.getCurrentPlayer()+" exei seira na paiksei");
						}*/
						System.out.println(toString());
						System.out.println("o paixtis "+player.getCurrentPlayer()+" exei seira na paiksei");
					}
					else
					{
						System.out.println("Lathos dedomena einai seira tou paixth "+player.getCurrentPlayer());
					}
				}
				else
				{
					System.out.println("To keli pou edwses den periexei pioni");
				}
			}
		}
	}
	
	private void saveGame()
	{
		System.out.println("Give the file name");
		InputStreamReader reader;
		reader=new InputStreamReader(System.in);
		BufferedReader scan= new BufferedReader(reader);
		String name=null;
		try {
			name = scan.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try
		{
			if(name!=null && name!="")
			{
				Utilities.save(this.game.getBoard(), name);
			}
		}catch(IllegalArgumentException e)
		{
			System.out.println("The file is already exist");
		}
	}

	private void load(String a)
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
			this.game.resetBoard(temp);
			this.board=this.game.getBoard();
		}catch(IllegalArgumentException e)
		{
			System.out.println("The file not exist");
		}
	}
	
	private void previousMove() 
	{
		int i,j;
		Keli[][] temp;
		try
		{
			temp=Utilities.undo(this.game.getBoardsVector());
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
			this.board=temp;
			Player.changeCurrentColor();
		}catch(IllegalStateException e)
		{
			System.out.println("DEN YPARXEI PROIGOUMENI KINISI");
		}
	}

	private void nextMove()
	{
		int i,j;
		Keli[][] temp;
		try
		{
			temp=Utilities.redo(this.game.getBoardsVector());
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
			this.board=temp;
			Player.changeCurrentColor();
		}catch(IllegalStateException e)
		{
			System.out.println("DEN YPARXEI EPOMENI KINISI");
		}		
	}

	private void checkforpromotion() 
	{
		String promotionto ="";
		InputStreamReader reader;
		reader=new InputStreamReader(System.in);
		BufferedReader scan= new BufferedReader(reader);
		if(this.cell1.getPiece().getName()=="Pawn")
		{
			if(this.cell1.getPiece().getColor()=='w')
			{
				if(cell1.getPosY()==1 && cell2.getPosY()==0)
				{
					try 
					{
						while(!promotionto.equals("Queen") && !promotionto.equals("Bishop") && !promotionto.equals("Rook") && !promotionto.equals("Knight"))
						{	System.out.println("Dwse ti theleis na ginei to pioni");
							System.out.println("Queen, Bishop, Rook, Knight");
							promotionto=scan.readLine();
						}
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
					this.game.setPromotion(promotionto);
				}
			}
			else if(this.cell1.getPiece().getColor()=='b')
			{
				if(cell1.getPosY()==6 && cell2.getPosY()==7)
				{
					try 
					{
						while(!promotionto.equals("Queen") && !promotionto.equals("Bishop") && !promotionto.equals("Rook") && !promotionto.equals("Knight"))
						{	System.out.println("Dwse ti theleis na ginei to pioni");
							System.out.println("Queen, Bishop, Rook, Knight");
							promotionto=scan.readLine();
						}
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
					this.game.setPromotion(promotionto);
				}
			}
		}
	}

	private void getPlayersInformations()
	{
		String line;
		InputStreamReader reader;
		reader=new InputStreamReader(System.in);
		BufferedReader scan= new BufferedReader(reader);		
		
		try {
			System.out.println("Dwse ta onomata twn paiktwn");
			System.out.print("1os paikths: "); this.player1name=scan.readLine();
			System.out.print("2os paikths: "); this.player2name=scan.readLine();
			System.out.println("An theleis na ginei tuxaia epilogi xromatos dwse y .An oxi dwse otidipote allo");
			line=scan.readLine();
			if(line.equals("y"))
			{
				setRandomColors();
			}
			else
			{
				System.out.println("Dwse to xrwma tou paixth "+this.player1name+" (w gia aspra b gia maura) :");
				line=scan.readLine();
				if(line.equals("w") || line.equals("b"))
				{
					if(line.equals("w"))
					{this.player1color='w';  this.player2color='b';}
					else if(line.equals("b"))
					{this.player1color='b';  this.player2color='w';}
				}
				else
				{
					System.err.println("Lathos dedomena tha dwthoun tuxaia ta xromata");
					setRandomColors();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void setRandomColors()
	{
		Random random=new Random();
		if(random.nextBoolean()==true)
		{this.player1color='w';  this.player2color='b';}
		else
		{this.player1color='b';  this.player2color='w';}
		System.out.println("O paixtis "+this.player1name+" oristike na exei ta "+this.player1color+" .O paiktis "+this.player2name+" oristike na exei ta "+this.player2color);
	}
	
	
	
	private void printMenu()
	{
		System.out.println("1. New");
		System.out.println("2. Save");
		System.out.println("3. Load");
		System.out.println("4. Exit");
		System.out.println("5. Previous");
		System.out.println("6. Next");				
	}
	
	
	private boolean scan()
	{
		String line ="";
		boolean sosta_dedomena=false;
		InputStreamReader reader;
		
		this.Newgame=false;
		this.Save=false;
		this.Load=false;
		this.Previous=false;
		this.Next=false;
		
		reader=new InputStreamReader(System.in);
		BufferedReader scan= new BufferedReader(reader);
		
		printMenu();
		System.out.println("Give the move or the menu item number:");
		while(sosta_dedomena==false)
		{
			try
			{
				line=scan.readLine();
				if(line.equals("1"))
				{
					this.Newgame=true;
					return true;
				}
				else if(line.equals("2"))
				{
					this.Save=true;
					return true;
				}
				else if(line.equals("3"))
				{
					this.Load=true;
					return true;
				}
				else if(line.equals("4"))
				{
					return false;
				}
				else if(line.equals("5"))
				{
					this.Previous=true;
					return true;
				}
				else if(line.equals("6"))
				{
					this.Next=true;
					return true;
				}
				else
				{
					sosta_dedomena=checkDataFromKeyboard(line);
				}
				
			} catch (IOException e) {
				e.printStackTrace();}
			if(sosta_dedomena==false)
			{
				System.out.println("Give again:");
			}
		}
		return true;
	}
	
	private boolean checkDataFromKeyboard(String line)
	{
		
		line=line.replaceAll("-","");
		line=line.replaceAll(">","");
		line=line.replaceAll(" ", "");
		char[] Line=line.toCharArray();
		if(Line.length!=4)
		{
			System.err.println("H kinisi prepei na dinete me morfi (move from) -> (move to)");
			return false;
		}
		else
		{
			if(Line[0]!='a' && Line[0]!='b' && Line[0]!='c' && Line[0]!='d' && Line[0]!='e'&& Line[0]!='f'&& Line[0]!='g'&& Line[0]!='h')
			{
				System.err.println("Lathos syntetagmenes");
				return false;
			}
			this.y1 = (int) (Line[0]-97);
			
			if(Line[1]!='1' && Line[1]!='2' && Line[1]!='3' && Line[1]!='4' && Line[1]!='5'&& Line[1]!='6'&& Line[1]!='7'&& Line[1]!='8')
			{
				System.err.println("Lathos syntetagmenes");
				return false;
			}
			this.x1=(int) (Line[1]-49);
			if(Line[2]!='a' && Line[2]!='b' && Line[2]!='c' && Line[2]!='d' && Line[2]!='e'&& Line[2]!='f'&& Line[2]!='g'&& Line[2]!='h')
			{
				System.err.println("Lathos syntetagmenes");
				return false;
			}
			this.y2=(int) (Line[2]-97);	
			if(Line[3]!='1' && Line[3]!='2' && Line[3]!='3' && Line[3]!='4' && Line[3]!='5'&& Line[3]!='6'&& Line[3]!='7'&& Line[3]!='8')
			{
				System.err.println("Lathos syntetagmenes");
				return false;
			}
			this.x2= (int) (Line[3]-49);
		}		
		return true;
	}
}
