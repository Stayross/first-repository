package stateholder;

import java.util.Vector;
/**
 * Abstract class Piece
 * Parexei kai orizei genikes plirofories pioniwn
 * @author Muron Stavros
 * @version 1.0
 */
public abstract class Piece 
{
	private String piece;
	private char color;
	private int positionY;
	private int positionX;
	private int StartX;
	private int StartY;
	/**
	 * Orizei ton onoma tou pioniou
	 * Pre: to String diaforo tou null
	 * Post: To onoma tou pioniou orizete ws String name
	 * @throws IllegalArgumentException("Name = null")
	 * @param name:String me to onoma tou pioniou
	 */
	public void setName(String name)
	{
		if(name==null)
		{
			throw new IllegalArgumentException("Name = null");
		}
		this.piece=name;
	}
	/**
	 * Orizei ton xroma tou pioniou
	 * Pre: to char color iso me 'w' i 'b'
	 * Post: To xroma tou pioniou orizete ws char color
	 * @throws IllegalArgumentException("Lathos orisma sto xrwma pioniou")
	 * @param color: char me to xroma tou pioniou
	 */
	public void setColor(char color)
	{
		if(color!= 'b' && color!= 'w')
		{
			throw new IllegalArgumentException("Lathos orisma sto xrwma pioniou");
		}
		this.color=color;
	}
	/**
	 * Orizei tin thesi tou pioniou stous aksones Y,X tis skakieras
	 * Pre: to int Y kai to int X apo 0 mexri kai 7
	 * Post: Orizei tin thesi tou pioniou
	 * @throws IllegalArgumentException("Lathos syntetagmenes pioniou")
	 * @param Y:int i thesi ston aksona Y
	 * @param X:int i thesi ston aksona X
	 */
	public void setNumberPosition(int Y,int X)
	{
		if(Y<0 || Y>7 || X<0 || X>7)
		{
			throw new IllegalArgumentException("Lathos syntetagmenes pioniou");
		}
		this.positionX=X;
		this.positionY=Y;
	}
	/**
	 * Dinei tin thesi tou pioniou ston aksona X
	 * Post: i thesi tou pioniou ston aksona X
	 * @return int pou periexei tin thesi tou pioniou ston aksona X
	 */
	public int getNumberPositionX()
	{
		return this.positionX;
	}
	/**
	 * Dinei tin thesi tou pioniou ston aksona Y
	 * Post: i thesi tou pioniou ston aksona Y
	 * @return int pou periexei tin thesi tou pioniou ston aksona Y
	 */
	public int getNumberPositionY()
	{
		return this.positionY;
	}
	/**
	 * Epistrefei to xroma tou pioniou
	 * Post: to xroma tou pioniou
	 * @return : char 'w' an to xrwma einai aspro i 'b' an einai mayro
	 */
	public char getColor()
	{
		return this.color;
	}
	/**
	 * Epistrefei to onoma tou pionioy 
	 * Post: to onoma tou pioniou
	 * @return String pou periexei to onoma tou pionioy
	 */
	public String getName()
	{
		return this.piece;
	}
	/**
	 * Orizei tin arxiki thesi tou pioniou stin skakiera
	 * Pre: to int Y kai to int X apo 0 mexri kai 7
	 * Post: Orizei tin arxiki thesi tou pioniou
	 * @throws IllegalArgumentException("Lathos syntetagmenes pioniou")
	 * @param Y:int i arxiki thesi ston aksona Y
	 * @param X:int i arxiki thesi ston aksona X
	 */
	public void setStart(int Y,int X)
	{
		if(Y<0 || Y>7 || X<0 || X>7)
		{
			throw new IllegalArgumentException("Lathos syntetagmenes pioniou");
		}
		this.StartY=Y;
		this.StartX=X;
	}
	/**
	 * Dinei tin arxiki thesi tou pioniou ston aksona X
	 * Post: i arxiki thesi tou pioniou ston aksona X
	 * @return int pou periexei tin arxiki thesi tou pioniou ston aksona X
	 */
	public int getStartX()
	{
		return this.StartX;
	}
	/**
	 * Dinei tin arxiki thesi tou pioniou ston aksona Y
	 * Post: i arxiki thesi tou pioniou ston aksona Y
	 * @return int pou periexei tin arxiki thesi tou pioniou ston aksona Y
	 */
	public int getStartY()
	{
		return this.StartY;
	}
	
	/**
	 * Abstract methodos 
	 * Dinei oles tis dunates kiniseis pou mporei na kanei to pioni
	 * @param board:Keli[8][8] pou periexei tin morfi tis skakieras
	 * @return Vector<Move> : oi dinates kiniseis tou pioniou
	 */
	public abstract Vector<Move> getMoves(Keli[][] board,boolean isvalid);
	/**
	 * Orizei oti exei kinithei to pioni
	 */
	public abstract void HasMoved();
	/**
	 * Orizei oti den exei kinithei to pioni
	 */
	public abstract void HasNotMoved();
	/**
	 * Epistrefei boolean true an to pioni exei kinithei
	 * false an to pioni den exei kinithei
	 * @return boolean :true i false
	 */
	public abstract boolean getMoved();
	
}