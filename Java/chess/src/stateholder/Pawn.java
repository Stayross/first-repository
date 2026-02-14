package stateholder;

import gamemaster.Event;
import java.util.Vector;
/**
 * Pawn class extends Piece
 * implements tis abstract methodous tis piece
 * @author Stavros Muron
 * @version 1.0.3
 */
public class Pawn extends Piece
{
	boolean hasMoved=false;
	/**
	 * Constructor : Dimiourgei to pioni
	 * Pre: @see class Piece -> methodoi setName , setColor , setStart
	 * Post: @see class Piece -> methodoi setName , setColor , setStart
	 * @param color : char me to xroma tou vasilia
	 * @param StartY : int me tin arxiki thesi tou pioniou ston aksona Y
	 * @param StartX : int me tin arxiki thesi tou pioniou ston aksona X
	 */
	public Pawn(char color,int StartY,int StartX)
	{
		super.setName("Pawn");
		super.setColor(color);
		super.setStart(StartY,StartX);
	}
	/**
	 * Ypologizei oles tis dinates kiniseis tou pioniou panw stin skakiera
	 * @return Vector: vector pou periexei oles tis dunates kiniseis tou pioniou
	 * @see Piece -> abstract method getMoves
	 */
	public Vector<Move> getMoves(Keli[][] board,boolean isvalid)
	{
		int X,Y;
		Vector<Move> A=new Vector();
		X=this.getNumberPositionX();
		Y=this.getNumberPositionY();
		if(this.getColor()=='w')
		{
			if((Y-1>=0))
			{
				if(!board[Y-1][X].hasPiece())
				{
					if((Y-1)==0)
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y-1][X])&& isvalid==true)
						{
							A.add(new Promotion(board[Y-1][X]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Promotion(board[Y-1][X]));
						}
					}
					else
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y-1][X])&& isvalid==true)
						{
							A.add(new SimpleMove(board[Y-1][X]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new SimpleMove(board[Y-1][X]));
						}
					}
					if(this.hasMoved==false && board[Y-2][X].hasPiece()==false)
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y-2][X])&& isvalid==true)
						{
							A.add(new SimpleMove(board[Y-2][X]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new SimpleMove(board[Y-2][X]));
						}
					}
				}
				if((X-1)>=0)
				{
					if(board[Y-1][X-1].hasPiece() && this.getColor()!=board[Y-1][X-1].getPiece().getColor())
					{
						if((Y-1)==0)
						{
							if(isvalid==true)
							{
							if(Event.isValidMove(board,board[Y][X],board[Y-1][X-1])&& isvalid==true)
							{
								A.add(new Capturepromotion(board[Y-1][X-1]));
							}
							}
							else if(isvalid==false)
							{
								A.add(new Capturepromotion(board[Y-1][X-1]));
							}
						}
						else
						{
							if(isvalid==true)
							{
							if(Event.isValidMove(board,board[Y][X],board[Y-1][X-1])&& isvalid==true)
							{
								A.add(new Capture(board[Y-1][X-1]));
							}
							}
							else if(isvalid==false)
							{
								A.add(new Capture(board[Y-1][X-1]));
							}
						}
					}
				}
				if((X+1)<=7)
				{
					if(board[Y-1][X+1].hasPiece() && this.getColor()!=board[Y-1][X+1].getPiece().getColor())
					{
						if((Y-1)==0)
						{
							if(isvalid==true)
							{
							if(Event.isValidMove(board,board[Y][X],board[Y-1][X+1])&& isvalid==true)
							{
								A.add(new Capturepromotion(board[Y-1][X+1]));
							}
							}
							else if(isvalid==false)
							{
								A.add(new Capturepromotion(board[Y-1][X+1]));
							}
						}
						else
						{
							if(isvalid==true)
							{
							if(Event.isValidMove(board,board[Y][X],board[Y-1][X+1])&& isvalid==true)
							{
								A.add(new Capture(board[Y-1][X+1]));
							}
							}
							else if(isvalid==false)
							{
								A.add(new Capture(board[Y-1][X+1]));
							}
						}	
					}
				}
			}
		}
		if(this.getColor()=='b')
		{
			if((Y+1<=7))
			{
				if(!board[Y+1][X].hasPiece())
				{
					if((Y+1)==7)
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y+1][X])&& isvalid==true)
						{
							A.add(new Promotion(board[Y+1][X]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new Promotion(board[Y+1][X]));
						}
					}
					else
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y+1][X])&& isvalid==true)
						{
							A.add(new SimpleMove(board[Y+1][X]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new SimpleMove(board[Y+1][X]));
						}
					}
					if(this.hasMoved==false && board[Y+2][X].hasPiece()==false)
					{
						if(isvalid==true)
						{
						if(Event.isValidMove(board,board[Y][X],board[Y+2][X])&& isvalid==true)
						{
							A.add(new SimpleMove(board[Y+2][X]));
						}
						}
						else if(isvalid==false)
						{
							A.add(new SimpleMove(board[Y+2][X]));
						}
					}
				}
				if((X-1)>=0)
				{
					if(board[Y+1][X-1].hasPiece() && this.getColor()!=board[Y+1][X-1].getPiece().getColor())
					{
						if((Y+1)==7)
						{
							if(isvalid==true)
							{
							if(Event.isValidMove(board,board[Y][X],board[Y+1][X-1])&& isvalid==true)
							{
								A.add(new Capturepromotion(board[Y+1][X-1]));
							}
							}
							else if(isvalid==false)
							{
								A.add(new Capturepromotion(board[Y+1][X-1]));
							}
						}
						else
						{
							if(isvalid==true)
							{
							if(Event.isValidMove(board,board[Y][X],board[Y+1][X-1])&& isvalid==true)
							{
								A.add(new Capture(board[Y+1][X-1]));
							}
							}
							else if(isvalid==false)
							{
								A.add(new Capture(board[Y+1][X-1]));
							}
						}
					}
				}
				if((X+1)<=7)
				{
					if(board[Y+1][X+1].hasPiece() && this.getColor()!=board[Y+1][X+1].getPiece().getColor())
					{
						if((Y+1)==7)
						{
							if(isvalid==true)
							{
							if(Event.isValidMove(board,board[Y][X],board[Y+1][X+1])&& isvalid==true)
							{
								A.add(new Capturepromotion(board[Y+1][X+1]));
							}
							}
							else if(isvalid==false)
							{
								A.add(new Capturepromotion(board[Y+1][X+1]));
							}
						}
						else
						{
							if(isvalid==true)
							{
							if(Event.isValidMove(board,board[Y][X],board[Y+1][X+1])&& isvalid==true)
							{
								A.add(new Capture(board[Y+1][X+1]));
							}
							}
							else if(isvalid==false)
							{
								A.add(new Capture(board[Y+1][X+1]));
							}
						}
					}
				}
			}
		}
		return A;
	}
	/**
	 * Orizei to pioni oti exei kinithei
	 */
	public void HasMoved()
	{
		this.hasMoved=true;
	}
	/**
	 * Orizei to pioni oti den exei kinithei
	 */
	public void HasNotMoved()
	{
		this.hasMoved=false;
	}
	/**
	 * Epistrefei boolean true an to pioni exei kinithei
	 * false an to pioni den exei kinithei
	 * @return boolean :true i false
	 */
	public boolean getMoved()
	{
		return this.hasMoved;
	}
}