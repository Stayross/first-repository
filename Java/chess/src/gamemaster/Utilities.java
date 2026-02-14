package gamemaster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import stateholder.Bishop;
import stateholder.Keli;
import stateholder.King;
import stateholder.Knight;
import stateholder.Pawn;
import stateholder.Piece;
import stateholder.Queen;
import stateholder.Rook;
/**
 * Utilities class 
 * vivliothiki pou periexei tis leitourgeies tou menu
 * @author Myron,Stavros
 * @version 1.0
 */
public class Utilities 
{
	private static int metritis=1;
	/**
	 * Apothikeuei tin skakiera(Keli[][]) se ena arxeio txt me sygekrimeni morfi
	 * @param Keli[][]-boards h skakiera pou theloume na apothikeusoume
	 * @param String-savename to onoma pou theloume na dwsoume sto arxeio
	 */
	public static void save(Keli[][] boards,String savename)
	{
		int i,j;
		File f=new File("saves/"+savename+".txt");
		if(!f.exists())
		{
			try 
		    {
				f.createNewFile();
			} catch (IOException e) {}
		try 
		{
			BufferedWriter fout =null;
			fout=new BufferedWriter(new FileWriter(f));
			fout.write(Player.getPlayer1());
			fout.newLine();
			fout.write(Player.getPlayer2());
			fout.newLine();
			fout.write(Player.getCurrentColor());
			fout.newLine();
			for(i=0;i<8;i++)
			{
				for(j=0;j<8;j++)
				{
					if(boards[i][j].hasPiece())
					{
						if(boards[i][j].getPiece().getColor()=='b')
						{
							if(boards[i][j].getPiece().getName().equals("King"))
							{
								fout.write("w ");
							}
							else
							{
								fout.write(boards[i][j].getPiece().getName().substring(0,1).toLowerCase()+" ");
							}
						}
						else
						{
							if(boards[i][j].getPiece().getName().equals("King"))
							{
								fout.write("W ");
							}
							else
							{
								fout.write(boards[i][j].getPiece().getName().substring(0,1).toUpperCase()+" ");
							}
						}
					}
					else
					{
						fout.write("x ");
					}
				}
				fout.newLine();
			}
			fout.close();
		} catch (Exception e) {e.printStackTrace();}
		}
		else
		{
			throw new IllegalArgumentException("Auto to onoma yparxei");
		}
	}
	/**
	 * Epistrefei mia skakiera(Keli[][]) afou tin exei diavasei apo arxeio txt 
	 * @param String-loadname to onoma tou arxeiou pou theloume na ginei to load
	 * @param Player-player to anti keimeno Player pou theloume na orisoume apo to load
	 * @return Keli[][]-h skakiera pou dimiourgithike apo to load
	 */
	public static Keli[][] load(String loadname,Player player)
	{
		int i,j=0,countbRooks=0,countbBishops=0;
		int countbKnights=0,countbPawns=0,countwPawns=0;
		int countwRooks=0,countwBishops=0,countwKnights=0;
		Keli[][] boards=new Keli[8][8];
		String seira;
		String onoma;
		File f=new File("saves/"+loadname);
		if(!f.exists())
		{
			throw new IllegalArgumentException("Lathos onoma arxeiou");
		}
		else
		{
			for(i=0;i<8;i++)
			{
				for(j=0;j<8;j++)
				{
					if(i%2==0)
					{
						if(j%2==0)
						{
							boards[i][j]=new Keli('w',i,j);
						}
						else
						{
							boards[i][j]=new Keli('b',i,j);
						}
					}
					else
					{
						if(j%2==0)
						{
							boards[i][j]=new Keli('b',i,j);
						}
						else
						{
							boards[i][j]=new Keli('w',i,j);
						}
					}
				}
			}
			i=0;
			j=0;
			try 
			{
			    BufferedReader fin = new BufferedReader(new FileReader(f));
			    seira=fin.readLine();
			    StringTokenizer tokens=new StringTokenizer(seira);
			    String name1=tokens.nextToken();
			    String color1=tokens.nextToken();
			    seira=fin.readLine();
			    tokens=new StringTokenizer(seira);
			    String name2=tokens.nextToken();
			    String color2=tokens.nextToken();
			    player=new Player(name1,name2,color1.toCharArray()[0],color2.toCharArray()[0]);
			    seira=fin.readLine();
			    tokens=new StringTokenizer(seira);
			    String currentcolor=tokens.nextToken();
			    Player.setCurrentColor(currentcolor.toCharArray()[0]);
			    while((seira=fin.readLine())!=null)
			    {
			    	j=0;
			    	tokens=new StringTokenizer(seira);
			    	while(tokens.hasMoreTokens())
			    	{
			    		onoma=tokens.nextToken();
			    		if(onoma.equals("w"))
			    		{
			    			boards[i][j].setPiece(new King('b',0,4));
			    		}
			    		else if(onoma.equals("q"))
			    		{
			    			boards[i][j].setPiece(new Queen('b',0,3));
			    		}
			    		else if(onoma.equals("k"))
			    		{
			    			if(countbKnights==0)
			    			{
			    				boards[i][j].setPiece(new Knight('b',0,1));
			    				countbKnights++;
			    			}
			    			else
			    			{
			    				boards[i][j].setPiece(new Knight('b',0,6));
			    			}
			    		}
			    		else if(onoma.equals("r"))
			    		{
			    			if(countbRooks==0)
			    			{
			    				boards[i][j].setPiece(new Rook('b',0,0));
			    				countbRooks++;
			    			}
			    			else
			    			{
			    				boards[i][j].setPiece(new Rook('b',0,7));
			    			}
			    		}
			    		else if(onoma.equals("b"))
			    		{
			    			if(countbBishops==0)
			    			{
			    				boards[i][j].setPiece(new Bishop('b',0,2));
			    				countbBishops++;
			    			}
			    			else
			    			{
			    				boards[i][j].setPiece(new Bishop('b',0,5));
			    			}
			    		}
			    		else if(onoma.equals("p"))
			    		{
			    			boards[i][j].setPiece(new Pawn('b',1,countbPawns));
			    			countbPawns++;
			    		}
			    		else if(onoma.equals("Q"))
			    		{
			    			boards[i][j].setPiece(new Queen('w',7,4));
			    		}
			    		else if(onoma.equals("W"))
			    		{
			    			boards[i][j].setPiece(new King('w',7,3));
			    		}
			    		else if(onoma.equals("K"))
			    		{
			    			if(countwKnights==0)
			    			{
			    				boards[i][j].setPiece(new Knight('w',7,1));
			    				countwKnights++;
			    			}
			    			else
			    			{
			    				boards[i][j].setPiece(new Knight('w',7,6));
			    			}
			    		}
			    		else if(onoma.equals("R"))
			    		{
			    			if(countwRooks==0)
			    			{
			    				boards[i][j].setPiece(new Rook('w',7,0));
			    				countwRooks++;
			    			}
			    			else
			    			{
			    				boards[i][j].setPiece(new Rook('w',7,7));
			    			}
			    		}
			    		else if(onoma.equals("B"))
			    		{
			    			if(countwBishops==0)
			    			{
			    				boards[i][j].setPiece(new Bishop('w',7,2));
			    				countwBishops++;
			    			}
			    			else
			    			{
			    				boards[i][j].setPiece(new Bishop('w',7,5));
			    			}
			    		}
			    		else if(onoma.equals("P"))
			    		{
			    			boards[i][j].setPiece(new Pawn('w',6,countwPawns));
			    			countwPawns++;
			    		}
			    		j++;
			    	}
			    	i++;
			    }
			    fin.close();
			}
			catch (Exception e) { e.printStackTrace(); }
			metritis=1;
			return boards;
		}
	}
	/**
	 * Ekteleitai ginete kainourgia kinisi
	 * Elenxei an exei ginei undo kai diagrafei to Vector<Keli[][]> analogos se poio board eimaste 
	 * @param Vector<Keli[][]>boards-Vector me oles tis skakieres(Kel[][]) pou exoun perasei
	 * @return Vector<Keli[][]>- o kainourgios Vector me tis skakieres afou exei ginei diagrafi
	 */
	public static Vector<Keli[][]> newMoveIsMade(Vector<Keli[][]> boards)
	{
		int i,j;
		Vector<Keli[][]> boards2=new Vector();
		if(metritis>=boards.size())
		{
			boards2.add(Keli.cloneBoard(boards.firstElement()));
			boards.clear();
			metritis=1;
			return boards2;
		}
		else if(metritis>1 && metritis<boards.size())
		{
			j=boards.size()-metritis;
			for(i=0;i<=j;i++)
			{
				boards2.add(Keli.cloneBoard(boards.get(i)));
			}
			boards.clear();
			metritis=1;
			return boards2;
		}
		else
		{
			metritis=1;
			return boards;
		}
	}
	/**
	 * Epistrefei int me ton arithmo ton undo h redo pou exoume kanei
	 * @return int
	 */
	public static int getMetritis()
	{
		return metritis;
	}
	/**
	 * Orizei ton int me ton arithmo ton undo kai redo se 1
	 */
	public static void resetMetritis()
	{
		metritis=1;
	}
	/**
	 * Dinei tin proigoumenei skakiera(Keli[][]) apo auti pou eimaste
	 * pre:Prepei na yparxei proigoumeni kinisi
	 * @param Vector<Keli[][]>-boards
	 * @return Keli[][]-skakiera
	 * @throws IllegalStateException("den yparxei kinisi gia na kaneis undo")
	 */
	public static Keli[][] undo(Vector<Keli[][]> boards) throws IllegalStateException
	{
		metritis=metritis+1;
		if(metritis>boards.size() || metritis<=0)
		{
			metritis=metritis-1;
			throw new IllegalStateException("den yparxei kinisi gia na kaneis undo");
		}
		return boards.get(boards.size()-metritis);
	}
	/**
	 * Dinei tin epomeni skakiera(Keli[][]) apo auti pou eimaste
	 * pre:Prepei na exei ginei undo kai na min exei ginei kainourgia kinisi
	 * @param Vector<Keli[][]>-boards
	 * @return Keli[][]-skakiera
	 * @throws IllegalStateException("den yparxei kinisi gia na kaneis redo")
	 */
	public static Keli[][] redo(Vector<Keli[][]> boards) throws IllegalStateException
	{
		metritis=metritis-1;
		if(metritis>boards.size() || metritis<=0)
		{
			metritis=metritis+1;
			throw new IllegalStateException("den yparxei kinisi gia na kaneis redo");
		}
		return boards.get((boards.size())-metritis);
	}
	/**
	 * Ftiaxnei mia kainourgia skakiera me ta pionia stia arxikes tous theseis kai tin epistrefei
	 * @return Keli[][]-skakiera
	 */
	public static Keli[][] newGame()
	{
		int i,j,k = 0;
		metritis=1;
		Piece[] piece=new Piece[32];
		Keli[][] board=new Keli[8][8];
		piece[0] = new Rook('b',0,0);	
		piece[1] = new Knight('b',0,1);
		piece[2] = new Bishop('b',0,2);
		piece[4] = new King('b',0,4);
		piece[3] = new Queen('b',0,3);
		piece[5] = new Bishop('b',0,5);
		piece[6] = new Knight('b',0,6);
		piece[7] = new Rook('b',0,7);
		piece[8] = new Pawn('b',1,0);
		piece[9] = new Pawn('b',1,1);
		piece[10] = new Pawn('b',1,2);
		piece[11] = new Pawn('b',1,3);
		piece[12] = new Pawn('b',1,4);
		piece[13] = new Pawn('b',1,5);
		piece[14] = new Pawn('b',1,6);
		piece[15] = new Pawn('b',1,7);		                      
		piece[16] = new Pawn('w',6,0);                      			
		piece[17] = new Pawn('w',6,1);		
		piece[18] = new Pawn('w',6,2);	
		piece[19] = new Pawn('w',6,3);	
		piece[20] = new Pawn('w',6,4);		
		piece[21] = new Pawn('w',6,5);
		piece[22] = new Pawn('w',6,6);
		piece[23] = new Pawn('w',6,7);
		piece[24] = new Rook('w',7,0);	
		piece[25] = new Knight('w',7,1);
		piece[26] = new Bishop('w',7,2);
		piece[28] = new King('w',7,3);
		piece[27] = new Queen('w',7,4);
		piece[29] = new Bishop('w',7,5);
		piece[30] = new Knight('w',7,6);
		piece[31] = new Rook('w',7,7);
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(i%2==0)
				{
					if(j%2==0)
					{
						board[i][j]=new Keli('w',i,j);
					}
					else
					{
						board[i][j]=new Keli('b',i,j);
					}
				}
				else
				{
					if(j%2==0)
					{
						board[i][j]=new Keli('b',i,j);
					}
					else
					{
						board[i][j]=new Keli('w',i,j);
					}
				}
			}
		}
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(i<2 || i>5)
				{
					board[i][j].setPiece(piece[k]);
					k++;
				}
			}
		}
		return board;
	}
}
