package stateholder;

import gamemaster.Event;
import java.util.Vector;
/**
 * Queen class extends Piece
 * implements tis abstract methodous tis piece
 * @author Stavros Muron
 * @version 1.0.1
 */
public class Queen extends Piece
{
	private boolean hasMoved=false;
	/**
	 * Constructor : Dimiourgei tin vasilisa
	 * Pre: @see class Piece -> methodoi setName , setColor , setStart
	 * Post: @see class Piece -> methodoi setName , setColor , setStart
	 * @param color : char me to xroma tou vasilia
	 * @param StartY : int me tin arxiki thesi tis vasilisas ston aksona Y
	 * @param StartX : int me tin arxiki thesi tis vasilisas ston aksona X
	 */
	public Queen(char color,int StartY,int StartX)
	{
		super.setName("Queen");
		super.setColor(color);
		super.setStart(StartY,StartX);
	}
	/**
	 * Ypologizei oles tis dinates kiniseis tis vasilisas panw stin skakiera
	 * @return Vector: vector pou periexei oles tis dunates kiniseis tis vasilisas
	 * @see Piece -> abstract method getMoves
	 */
	public Vector<Move> getMoves(Keli[][] board, boolean isvalid)
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
		for(i=X+1;i<8;i++)
		{
			if(board[Y][i].hasPiece()==false && end==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[Y][i])&& isvalid==true)
				{
					A.add(new SimpleMove(board[Y][i]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[Y][i]));
				}
			}
			else if(end==false)
			{
				if(this.getColor()!=board[Y][i].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y][i])&& isvalid==true)
					{
						A.add(new Capture(board[Y][i]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[Y][i]));
						end=true;
					}
				}
				else if(end==false)
				{
					end=true;
				}
			}
		}
		end=false;
		for(i=X+1;i<8;i++)
		{
			if(board[Y][i].hasPiece()==false && end==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[Y][i])&& isvalid==true)
				{
					A.add(new SimpleMove(board[Y][i]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[Y][i]));
				}
			}
			else if(end==false)
			{
				if(this.getColor()!=board[Y][i].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y][i])&& isvalid==true)
					{
						A.add(new Capture(board[Y][i]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[Y][i]));
						end=true;
					}
				}
				else if(end==false)
				{
					end=true;
				}
			}
		}
		end=false;
		for(i=X-1;i>=0;i--)
		{
			if(board[Y][i].hasPiece()==false && end==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[Y][i])&& isvalid==true)
				{
					A.add(new SimpleMove(board[Y][i]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[Y][i]));
				}
			}
			else if(end==false)
			{
				if(this.getColor()!=board[Y][i].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[Y][i])&& isvalid==true)
					{
						A.add(new Capture(board[Y][i]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[Y][i]));
						end=true;
					}
				}
				else if(end==false)
				{
					end=true;
				}
			}
		}
		end=false;
		for(i=Y+1;i<8;i++)
		{
			if(board[i][X].hasPiece()==false && end==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[i][X])&& isvalid==true)
				{
					A.add(new SimpleMove(board[i][X]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[i][X]));
				}
			}
			else if(end==false)
			{
				if(this.getColor()!=board[i][X].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[i][X])&& isvalid==true)
					{
						A.add(new Capture(board[i][X]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[i][X]));
						end=true;
					}
				}
				else if(end==false)
				{
					end=true;
				}
			}
		}
		end=false;
		for(i=Y-1;i>=0;i--)
		{
			if(board[i][X].hasPiece()==false && end==false)
			{
				if(isvalid==true)
				{
				if(Event.isValidMove(board,board[Y][X],board[i][X])&& isvalid==true)
				{
					A.add(new SimpleMove(board[i][X]));
				}
				}
				else if(isvalid==false)
				{
					A.add(new SimpleMove(board[i][X]));
				}
			}
			else if(end==false)
			{
				if(this.getColor()!=board[i][X].getPiece().getColor() && end==false)
				{
					if(isvalid==true)
					{
					if(Event.isValidMove(board,board[Y][X],board[i][X])&& isvalid==true)
					{
						A.add(new Capture(board[i][X]));
						end=true;
					}
					}
					else if(isvalid==false)
					{
						A.add(new Capture(board[i][X]));
						end=true;
					}
				}
				else if(end==false)
				{
					end=true;
				}
			}
		}
		return A;
	}
	/**
	 * Orizei tin vasilisa oti exei kinithei
	 */
	public void HasMoved()
	{
		this.hasMoved=true;
	}
	/**
	 * Orizei tin vasilisa oti den exei kinithei
	 */
	public void HasNotMoved()
	{
		this.hasMoved=false;
	}
	/**
	 * Epistrefei boolean true an i vasilisa exei kinithei
	 * false an i vasilisa den exei kinithei
	 * @return boolean :true i false
	 */
	public boolean getMoved()
	{
		return this.hasMoved;
	}
}

