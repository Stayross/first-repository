package stateholder;

import gamemaster.Event;
import java.util.Vector;
/**
 * Bishop class extends Piece
 * implements tis abstract methodous tis piece
 * @author Stavros Muron
 * @version 1.0.2
 */
public class Bishop extends Piece
{
	private boolean hasMoved=false;
	/**
	 * Constructor : Dimiourgei ton loxago
	 * Pre: @see class Piece -> methodoi setName , setColor , setStart
	 * Post: @see class Piece -> methodoi setName , setColor , setStart
	 * @param color : char me to xroma tou loxagou
	 * @param StartY : int me tin arxiki thesi tou loxagou ston aksona Y
	 * @param StartX : int me tin arxiki thesi tou loxagou ston aksona X
	 */
	public Bishop(char color,int StartY,int StartX)
	{
		super.setName("Bishop");
		super.setColor(color);
		super.setStart(StartY,StartX);
	}
	
	/**
	 * Ypologizei oles tis dinates kiniseis tou loxagou panw stin skakiera
	 * @return Vector: vector pou periexei oles tis dunates kiniseis tou loxagou
	 * @see Piece -> abstract method getMoves
	 */
	public Vector<Move> getMoves(Keli[][] board,boolean isvalid)
	{
		int X,Y,i;
		boolean end=false;
		Vector<Move> A=new Vector();
		X=this.getNumberPositionX();
		Y=this.getNumberPositionY();
		for(i=1;i<8;i++)
		{
			if((X+i)<=7 && (Y+i)<=7 && end==false && board[Y+i][X+i].hasPiece()==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[Y+i][X+i])&& isvalid==true)
				{
					A.add(new SimpleMove(board[Y+i][X+i]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[Y+i][X+i]));
				}
			}
			else if((X+i)<=7 && (Y+i)<=7 && end==false)
			{
				if(this.getColor()!=board[Y+i][X+i].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y+i][X+i])&& isvalid==true)
					{
						A.add(new Capture(board[Y+i][X+i]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[Y+i][X+i]));
						end=true;
					}
				}
				else
				{
					end=true;
				}
			}
		}
		end=false;
		for(i=1;i<8;i++)
		{
			if((X-i)>=0 && (Y-i)>=0 && end==false && board[Y-i][X-i].hasPiece()==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[Y-i][X-i])&& isvalid==true)
				{
					A.add(new SimpleMove(board[Y-i][X-i]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[Y-i][X-i]));
				}
			}
			else if((X-i)>=0 && (Y-i)>=0 && end==false)
			{
				if(this.getColor()!=board[Y-i][X-i].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y-i][X-i])&& isvalid==true)
					{
						A.add(new Capture(board[Y-i][X-i]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[Y-i][X-i]));
						end=true;
					}
				}
				else
				{
					end=true;
				}
			}
		}
		end=false;
		for(i=1;i<8;i++)
		{
			if((X+i)<=7 && (Y-i)>=0 && end==false && board[Y-i][X+i].hasPiece()==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[Y-i][X+i])&& isvalid==true)
				{
					A.add(new SimpleMove(board[Y-i][X+i]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[Y-i][X+i]));
				}
			}
			else if((X+i)<=7 && (Y-i)>=0 && end==false)
			{
				if(this.getColor()!=board[Y-i][X+i].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y-i][X+i])&& isvalid==true)
					{
						A.add(new Capture(board[Y-i][X+i]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[Y-i][X+i]));
						end=true;
					}
				}
				else
				{
					end=true;
				}
			}
		}
		end=false;
		for(i=1;i<8;i++)
		{
			if((X-i)>=0 && (Y+i)<=7 && end==false && board[Y+i][X-i].hasPiece()==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[Y+i][X-i])&& isvalid==true)
				{
					A.add(new SimpleMove(board[Y+i][X-i]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[Y+i][X-i]));
				}
			}
			else if((X-i)>=0 && (Y+i)<=7 && end==false)
			{
				if(this.getColor()!=board[Y+i][X-i].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y+i][X-i])&& isvalid==true)
					{
						A.add(new Capture(board[Y+i][X-i]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[Y+i][X-i]));
						end=true;
					}
				}
				else
				{
					end=true;
				}
			}
		}
		return A;
	}
	/**
	 * Orizei ton loxago oti exei kinithei
	 */
	public void HasMoved()
	{
		this.hasMoved=true;
	}
	/**
	 * Orizei ton loxago oti den exei kinithei
	 */
	public void HasNotMoved()
	{
		this.hasMoved=false;
	}
	/**
	 * Epistrefei boolean true an o loxagos exei kinithei
	 * false an o loxagos den exei kinithei
	 * @return boolean :true i false
	 */
	public boolean getMoved()
	{
		return this.hasMoved;
	}
}
