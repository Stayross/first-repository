package gamemaster;

import java.util.Vector;

import stateholder.Keli;
import stateholder.Move;
/**
 * Event class periexei mono static methodous
 * Xrisimopoieitai san vivliothiki me ta events tou paixnidiou
 * mat,pat,isValiMove
 * @author Myron,Stavros
 * @version 1.0
 */
public class Event 
{
	/**
	 * Elenxei an sti skakiera(Keli[8][8]) pou dwsame yparxei mat 
	 * @param Keli[8][8]-board
	 * @return boolean-true an yparxei mat h false an oxi
	 */
	public static boolean isMat(Keli[][] board)
	{
		int i,j,k;
		boolean mat=false;
		Vector<Object> A=new Vector();
		if(isRoua(board))
		{
			for(i=0;i<8;i++)
			{
				for(j=0;j<8;j++)
				{
					if(board[i][j].hasPiece())
					{
						if(Player.getCurrentColor()==board[i][j].getPiece().getColor())
						{
							for(k=0;k<board[i][j].getPiece().getMoves(board,true).size();k++)
							{
								if(board[i][j].getPiece().getMoves(board,true).size()>0)
								{
									A.add(board[i][j].getPiece().getMoves(board,true).get(k));
								}
							}
						}
					}
				}
			}
			if(A.isEmpty())
			{
				mat=true;
			}
		}
		return mat;
	}
	/**
	 * Elenxei an sti skakiera(Keli[8][8]) pou dwsame yparxei pat 
	 * @param Keli[8][8]-board
	 * @return boolean-true an yparxei pat h false an oxi
	 */
	public static boolean isPat(Keli [][] board)
	{
		int i,j,k,metritis = 0,wBishops = 0,bBishops = 0;
		Vector<Object> A=new Vector();
		if(!isRoua(board))
		{
			for(i=0;i<8;i++)
			{
				for(j=0;j<8;j++)
				{
					if(board[i][j].hasPiece())
					{
						if(Player.getCurrentColor()==board[i][j].getPiece().getColor())
						{
							for(k=0;k<board[i][j].getPiece().getMoves(board,true).size();k++)
							{
								if(board[i][j].getPiece().getMoves(board,true).size()>0)
								{
									A.add(board[i][j].getPiece().getMoves(board,true).get(k));
								}
							}
						}
					}
				}
			}
			if(A.isEmpty())
			{
				return true;
			}
		}
		A.clear();
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(board[i][j].hasPiece())
				{
					metritis++;
					A.add(board[i][j]);
				}
			}
		}
		if(metritis==2)
		{
			return true;
		}
		else
		{
			for(k=0;k<A.size();k++)
			{
				if(((Keli)A.get(k)).getPiece().getName()=="Rook" || ((Keli)A.get(k)).getPiece().getName()=="Queen" || ((Keli)A.get(k)).getPiece().getName()=="Pawn" )
				{
					return false;
				}
				if(((Keli)A.get(k)).getPiece().getName()=="Bishop")
				{
					if(((Keli)A.get(k)).getPiece().getColor()=='w')
					{
						wBishops++;
					}
					else
					{
						bBishops++;
					}
				}
			}
			if(wBishops>1 || bBishops>1)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	/**
	 * Elenxei an mia kinisi pioniou se mia skakiera(Keli[][]) einai swsti h oxi
	 * @param Keli[][]-board skakiera
	 * @param Keli-start to keli pou einai to pioni
	 * @param Keli-end to keli pou paei to pioni
 	 * @return true an einai swsti h kinisi false an oxi
	 */
	public static boolean isValidMove(Keli[][] board,Keli start,Keli end)
	{
		Keli[][] ValidBoard=new Keli[8][8];
		ValidBoard=Keli.cloneBoard(board);
		if(end.hasPiece())
		{
			makeTheCapture(ValidBoard,start,end);
		}
		else
		{
			makeTheMove(ValidBoard,start,end);
		}
		if(isTempRoua(ValidBoard))
		{
			return false;
		}
		else
		{
			return true;
		}	
	}
	
	private static void  makeTheMove(Keli[][] board,Keli start,Keli end)
	{
		board[end.getPosY()][end.getPosX()].setPiece(start.getPiece());
		board[start.getPosY()][start.getPosX()].erasePiece();
	}
	
	private static void makeTheCapture(Keli[][] board,Keli start,Keli end)
	{
		board[end.getPosY()][end.getPosX()].erasePiece();
		board[end.getPosY()][end.getPosX()].setPiece(start.getPiece());
		board[start.getPosY()][start.getPosX()].erasePiece();
	}
	
	private static boolean isRoua(Keli[][] board)
	{
		int i,j;
		boolean roua=false;
		setBoardThreats(board);
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(board[i][j].hasPiece())
				{
					if(board[i][j].hasPiece())
					{
						if(Player.getCurrentColor()==board[i][j].getPiece().getColor())
						{
							if(board[i][j].getPiece().getName()=="King")
							{
								if(board[i][j].getThreatend())
								{
									roua=true;
								}
							}
						}
					}
				}	
			}
		}
		clearThreats(board);
		return roua;
	}
	
	private static boolean isTempRoua(Keli[][] board)
	{
		int i,j;
		boolean roua=false;
		setTempBoardThreats(board);
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(board[i][j].hasPiece())
				{
					if(board[i][j].hasPiece())
					{
						if(Player.getCurrentColor()==board[i][j].getPiece().getColor())
						{
							if(board[i][j].getPiece().getName()=="King")
							{
								if(board[i][j].getThreatend())
								{
									roua=true;
								}
							}
						}
					}
				}	
			}
		}
		clearThreats(board);
		return roua;
	}
	
	private static void setBoardThreats(Keli[][] board)
	{
		int i,j,k,Y,X;
		Vector<Object> A=new Vector();
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(board[i][j].hasPiece())
				{
					if(Player.getCurrentColor()!=board[i][j].getPiece().getColor())
					{
						for(k=0;k<board[i][j].getPiece().getMoves(board,true).size();k++)
						{
							if(board[i][j].getPiece().getMoves(board,true).size()>0)
							{
								A.add(board[i][j].getPiece().getMoves(board,true).get(k));
							}
						}
					}
				}
			}
		}
		for(i=0;i<A.size();i++)
		{
			Y=((Move)A.get(i)).getCell().getPosY();
			X=((Move)A.get(i)).getCell().getPosX();
			board[Y][X].setThreatend(true);
		}
	}
	
	private static void setTempBoardThreats(Keli[][] board)
	{
		int i,j,k,Y,X;
		Vector<Object> A=new Vector();
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(board[i][j].hasPiece())
				{
					if(Player.getCurrentColor()!=board[i][j].getPiece().getColor())
					{
						for(k=0;k<board[i][j].getPiece().getMoves(board,false).size();k++)
						{
							A.add(board[i][j].getPiece().getMoves(board,false).get(k));
						}
					}
				}
			}
		}
		for(i=0;i<A.size();i++)
		{
			Y=((Move)A.get(i)).getCell().getPosY();
			X=((Move)A.get(i)).getCell().getPosX();
			board[Y][X].setThreatend(true);
		}
	}
	
	private static void clearThreats(Keli[][] board)
	{
		int i,j;
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				board[i][j].setThreatend(false);
			}
		}
	}
					
}
