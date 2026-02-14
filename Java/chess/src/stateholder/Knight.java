package stateholder;

import gamemaster.Event;
import java.util.Vector;
/**
 * Knight class extends Piece
 * implements tis abstract methodous tis piece
 * @author Stavros Muron
 * @version 1.0.2
 */
public class Knight extends Piece
{
	private boolean hasMoved=false;
	/**
	 * Constructor : Dimiourgei ton ippo
	 * Pre: @see class Piece -> methodoi setName , setColor , setStart
	 * Post: @see class Piece -> methodoi setName , setColor , setStart
	 * @param color : char me to xroma tou vasilia
	 * @param StartY : int me tin arxiki thesi tou ippou ston aksona Y
	 * @param StartX : int me tin arxiki thesi tou ippou ston aksona X
	 */
	public Knight(char color,int StartY,int StartX)
	{
		super.setName("Knight");
		super.setColor(color);
		super.setStart(StartY,StartX);
	}
	/**
	 * Ypologizei oles tis dinates kiniseis tou ippou panw stin skakiera
	 * @return Vector: vector pou periexei oles tis dunates kiniseis tou ippou
	 * @see Piece -> abstract method getMoves
	 */
	public Vector<Move> getMoves(Keli[][] board, boolean isvalid)
	{
		int X,Y;
		Vector<Move> A=new Vector();
		X=this.getNumberPositionX();
		Y=this.getNumberPositionY();
		if((X+2)<=7)
		{
			if((Y+1)<=7)
			{
				if(board[Y+1][X+2].hasPiece())
				{
					if(this.getColor()!=board[Y+1][X+2].getPiece().getColor())
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y+1][X+2])&& isvalid==true)
						{
							A.add(new Capture(board[Y+1][X+2]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[Y+1][X+2]));
						}
					}
				}
				else
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y+1][X+2])&& isvalid==true)
					{
						A.add(new SimpleMove(board[Y+1][X+2]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[Y+1][X+2]));
					}
				}
			}
			if((Y-1)>=0)
			{
				if(board[Y-1][X+2].hasPiece())
				{
					if(this.getColor()!=board[Y-1][X+2].getPiece().getColor())
					{
						if(isvalid==true)
						{						
						if(Event.isValidMove(board,board[Y][X],board[Y-1][X+2])&& isvalid==true)
						{
							A.add(new Capture(board[Y-1][X+2]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[Y-1][X+2]));
						}
					}
				}
				else
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y-1][X+2])&& isvalid==true)
					{
						A.add(new SimpleMove(board[Y-1][X+2]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[Y-1][X+2]));
					}
				}
			}
		}
		if((X-2)>=0)
		{
			if((Y+1)<=7)
			{
				if(board[Y+1][X-2].hasPiece())
				{
					if(this.getColor()!=board[Y+1][X-2].getPiece().getColor())
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y+1][X-2])&& isvalid==true)
						{
							A.add(new Capture(board[Y+1][X-2]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[Y+1][X-2]));
						}
					}
				}
				else
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y+1][X-2])&& isvalid==true)
					{
						A.add(new SimpleMove(board[Y+1][X-2]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[Y+1][X-2]));
					}
				}
			}
			if((Y-1)>=0)
			{
				if(board[Y-1][X-2].hasPiece())
				{
					if(this.getColor()!=board[Y-1][X-2].getPiece().getColor())
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y-1][X-2])&& isvalid==true)
						{
							A.add(new Capture(board[Y-1][X-2]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[Y-1][X-2]));
						}
					}
				}
				else
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y-1][X-2])&& isvalid==true)
					{
						A.add(new SimpleMove(board[Y-1][X-2]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[Y-1][X-2]));
					}
				}
			}
		}
		if((Y+2)<=7)
		{
			if((X+1)<=7)
			{
				if(board[Y+2][X+1].hasPiece())
				{
					if(this.getColor()!=board[Y+2][X+1].getPiece().getColor())
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y+2][X+1])&& isvalid==true)
						{
							A.add(new Capture(board[Y+2][X+1]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[Y+2][X+1]));
						}
					}
				}
				else
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y+2][X+1])&& isvalid==true)
					{
						A.add(new SimpleMove(board[Y+2][X+1]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[Y+2][X+1]));
					}
				}
			}
			if((X-1)>=0)
			{
				if(board[Y+2][X-1].hasPiece())
				{
					if(this.getColor()!=board[Y+2][X-1].getPiece().getColor())
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y+2][X-1])&& isvalid==true)
						{
							A.add(new Capture(board[Y+2][X-1]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[Y+2][X-1]));
						}
					}
				}
				else
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y+2][X-1])&& isvalid==true)
					{
						A.add(new SimpleMove(board[Y+2][X-1]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[Y+2][X-1]));
					}
				}
			}
		}
		if((Y-2)>=0)
		{
			if((X+1)<=7)
			{
				if(board[Y-2][X+1].hasPiece())
				{
					if(this.getColor()!=board[Y-2][X+1].getPiece().getColor())
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y-2][X+1])&& isvalid==true)
						{
							A.add(new Capture(board[Y-2][X+1]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[Y-2][X+1]));
						}
					}
				}
				else
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y-2][X+1])&& isvalid==true)
					{
						A.add(new SimpleMove(board[Y-2][X+1]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[Y-2][X+1]));
					}
				}
			}
			if((X-1)>=0)
			{
				if(board[Y-2][X-1].hasPiece())
				{
					if(this.getColor()!=board[Y-2][X-1].getPiece().getColor())
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y-2][X-1])&& isvalid==true)
						{
							A.add(new Capture(board[Y-2][X-1]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[Y-2][X-1]));
						}
					}
				}
				else
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y-2][X-1])&& isvalid==true)
					{
						A.add(new SimpleMove(board[Y-2][X-1]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[Y-2][X-1]));
					}
				}
			}
		}	
		return A;	
	}
	/**
	 * Orizei ton ippo oti exei kinithei
	 */
	public void HasMoved()
	{
		this.hasMoved=true;
	}
	/**
	 * Orizei ton ippo oti den exei kinithei
	 */
	public void HasNotMoved()
	{
		this.hasMoved=false;
	}
	/**
	 * Epistrefei boolean true an o ippos exei kinithei
	 * false an o ippos den exei kinithei
	 * @return boolean :true i false
	 */
	public boolean getMoved()
	{
		return this.hasMoved;
	}
}

