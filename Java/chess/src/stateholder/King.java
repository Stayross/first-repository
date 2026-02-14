package stateholder;

import gamemaster.Event;
import java.util.Vector;
/**
 * King class extends Piece
 * implements tis abstract methodous tis piece
 * @author Stavros Muron
 * @version 1.0.4
 */
public class King extends Piece
{
	private boolean hasMoved=false;
	/**
	 * Constructor : Dimiourgei ton vasilia
	 * Pre: @see class Piece -> methodoi setName , setColor , setStart
	 * Post: @see class Piece -> methodoi setName , setColor , setStart
	 * @param color : char me to xroma tou vasilia
	 * @param StartY : int me tin arxiki thesi tou vasilia ston aksona Y
	 * @param StartX : int me tin arxiki thesi tou vasilia ston aksona X
	 */
	public King(char color,int StartY,int StartX)
	{
		super.setName("King");
		super.setColor(color);
		super.setStart(StartY,StartX);
	}
	/**
	 * Ypologizei oles tis dinates kiniseis tou vasilia panw stin skakiera
	 * @return Vector: vector pou periexei oles tis dunates kiniseis tou vasilia
	 * @see Piece -> abstract method getMoves
	 */
	public Vector<Move> getMoves(Keli[][] board,boolean isvalid)
	{
		int X,Y,x,y;
		Vector<Move> A=new Vector();
		X=this.getNumberPositionX();
		Y=this.getNumberPositionY();
		if(X+1<=7)
		{
			x=X+1;
			if((Y+1)<=7)
			{
				y=Y+1;
				if(board[y][x].hasPiece()==false && board[y][x].getThreatend()==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
					{
						A.add(new SimpleMove(board[y][x]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[y][x]));
					}
				}
				else if(board[y][x].hasPiece())
				{
					if(board[y][x].getPiece().getColor()!=this.getColor() && board[y][x].getThreatend()==false)
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
						{
							A.add(new Capture(board[y][x]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[y][x]));
						}
					}
				}
			}
			if((Y-1)>=0)
			{
				y=Y-1;
				if(board[y][x].hasPiece()==false && board[y][x].getThreatend()==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
					{
						A.add(new SimpleMove(board[y][x]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[y][x]));
					}
				}
				else if(board[y][x].hasPiece())
				{
					if(board[y][x].getPiece().getColor()!=this.getColor() && board[y][x].getThreatend()==false)
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
						{
							A.add(new Capture(board[y][x]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[y][x]));
						}
					}
				}
			}
			y=Y;
			if(board[y][x].hasPiece()==false && board[y][x].getThreatend()==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
				{
					A.add(new SimpleMove(board[y][x]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[y][x]));
				}
			}
			else if(board[y][x].hasPiece())
			{
				if(board[y][x].getPiece().getColor()!=this.getColor() && board[y][x].getThreatend()==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
					{
						A.add(new Capture(board[y][x]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[y][x]));
					}
				}
			}
		}
		if(X-1>=0)
		{
			x=X-1;
			if((Y+1)<=7)
			{
				y=Y+1;
				if(board[y][x].hasPiece()==false && board[y][x].getThreatend()==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
					{
						A.add(new SimpleMove(board[y][x]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[y][x]));
					}
				}
				else if(board[y][x].hasPiece())
				{
					if(board[y][x].getPiece().getColor()!=this.getColor() && board[y][x].getThreatend()==false)
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
						{
							A.add(new Capture(board[y][x]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[y][x]));
						}
					}
				}
			}
			if((Y-1)>=0)
			{
				y=Y-1;
				if(board[y][x].hasPiece()==false && ((Keli) board[y][x]).getThreatend()==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
					{
						A.add(new SimpleMove(board[y][x]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new SimpleMove(board[y][x]));
					}
				}
				else if(board[y][x].hasPiece())
				{
					if(board[y][x].getPiece().getColor()!=this.getColor() && board[y][x].getThreatend()==false)
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
						{
							A.add(new Capture(board[y][x]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Capture(board[y][x]));
						}
					}
				}
			}
			y=Y;
			if(board[y][x].hasPiece()==false && board[y][x].getThreatend()==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
				{
					A.add(new SimpleMove(board[y][x]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[y][x]));
				}
			}
			else if(board[y][x].hasPiece())
			{
				if(board[y][x].getPiece().getColor()!=this.getColor() && board[y][x].getThreatend()==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
					{
						A.add(new Capture(board[y][x]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[y][x]));
					}
				}
			}
		}
		x=X;
		if(Y-1>=0)
		{
			y=Y-1;
			if(board[y][x].hasPiece()==false && board[y][x].getThreatend()==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
				{
					A.add(new SimpleMove(board[y][x]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[y][x]));
				}
			}
			else if(board[y][x].hasPiece())
			{
				if(board[y][x].getPiece().getColor()!=this.getColor() && board[y][x].getThreatend()==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
					{
						A.add(new Capture(board[y][x]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[y][x]));
					}
				}
			}
		}
		if(Y+1<=7)
		{
			y=Y+1;
			if(board[y][x].hasPiece()==false && board[y][x].getThreatend()==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
				{
					A.add(new SimpleMove(board[y][x]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[y][x]));
				}
			}
			else if(board[y][x].hasPiece())
			{
				if(board[y][x].getPiece().getColor()!=this.getColor() && board[y][x].getThreatend()==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[y][x])&& isvalid==true)
					{
						A.add(new Capture(board[y][x]));
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[y][x]));
					}
				}
			}
		}
		return A;
	}
	/**
	 * Orizei ton vasilia oti exei kinithei
	 */
	public void HasMoved()
	{
		this.hasMoved=true;
	}
	/**
	 * Orizei ton vasilia oti den exei kinithei
	 */
	public void HasNotMoved()
	{
		this.hasMoved=false;
	}
	/**
	 * Epistrefei boolean true an o vasilias exei kinithei
	 * false an o vasilias den exei kinithei
	 * @return boolean :true i false
	 */
	public boolean getMoved()
	{
		return this.hasMoved;
	}
}

