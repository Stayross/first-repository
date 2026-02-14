package stateholder;

/**
 * Keli class(to kathe koutaki tis skakieras)
 * @author Stavros, Muronas
 * @version 1.0
 */
public class Keli
{
	private char color;
	private boolean Threatend=false;
	private Piece piece;
	private int posX;
	private int posY;
	
	/**
	 * Constructor :Dimiourgei ena keli
	 * Pre: To char color prepei na einai 'w' i 'b'
	 * Pre: To int y kai to int x prepei na einai apo 0 mexri kai 7
	 * @throws IllegalArgumentException("Lathos xrwma keliou")
	 * @throws IllegalArgumentException("Lathos syntetagmeni y keliou")
	 * @throws IllegalArgumentException("Lathos syntetagmeni x keliou")
	 * @param color to xroma to keliou
	 * @param y : suntetagmeni tou keliou ston aksona y se int
	 * @param x : suntetagmeni tou keliou ston aksona x se int
	 */
	public Keli(char color,int y,int x)
	{
		if(color=='b' || color=='w')
		{
			this.color=color;
		}
		else
		{
			throw new IllegalArgumentException("Lathos xrwma keliou");
		}
		if(y<8 && y>=0)
		{
			this.posY=y;
		}
		else
		{
			throw new IllegalArgumentException("Lathos syntetagmeni y keliou");
		}
		if(x<8 && x>=0)
		{
			this.posX=x;
		}
		else
		{
			throw new IllegalArgumentException("Lathos syntetagmeni x keliou");
		}
		
	}
	
	/**
	 * Vazei ena pioni sto keli
	 * Post: an to piece!= vazei to pioni sto keli aliws to keli den periexei pioni
	 * @param piece : to pioni
	 */
	public void setPiece(Piece piece)
	{
		if(piece!=null)
		{
			this.piece=piece;
		}
		else
		{
			this.piece=null;
		}
	}
	/**
	 * Orizei an apeileite to keli i oxi
	 * Post: an boolean x true orizei oti to keli apeileite an false den apeileite
	 * @param x: boolean true or false
	 */
	public void setThreatend(boolean x)
	{
		this.Threatend=x;
	}
	/**
	 * Elegxei an yparxei pioni sto keli
	 * Post: true an exei pioni false an oxi
	 * @return :boolean true an exei pioni false an oxi
	 */
	public boolean hasPiece()
	{
		if(this.piece==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	/**
	 * Diagrafi tou pioniou apo to keli
	 * Post: to piece tou keliou orizete null
	 */
	public void erasePiece()
	{
		this.piece=null;
	}
	/**
	 * Dinei to xroma tou keliou
	 * Post: epistrefei to xrwma tou keliou char 'b' i 'w'
	 * @return char to xroma tou keliou 'b' i 'w'
	 */
	public char getColor()
	{
		return this.color;
	}
	
	/**
	 * epistrefei an apeileite to keli apo kapio pioni stin skakiera
	 * Post: epistrefei boolean true an apeileite false an oxi
	 * @return : boolean true an apeileite false an oxi
	 */
	public boolean getThreatend()
	{
		return this.Threatend;
	}
	
	/**
	 * Dinei to pioni pou yparxei sto keli
	 * Post: epistrefei Piece to opoio vriskete sto keli
	 * to antikeimeno Piece an to keli periexei pioni null an oxi 
	 * @return : Piece to pioni toy kelioy
	 */
	public Piece getPiece()
	{
		return this.piece;
	}
	
	/**
	 * Dinei tin syntetagmeni ston aksona x toy kelioy
	 * Post: epistrefei int x tin syntetagmeni tou keliou ston aksona x
	 * int x apo 0 mexri kai 7
	 * @return int pou periexei tin syntetagmeni x
	 */
	public int getPosX()
	{
		return this.posX;
	}
	/**
	 * Dinei tin syntetagmeni ston aksona y toy kelioy
	 * Post: epistrefei int y tin syntetagmeni tou keliou ston aksona y
	 * int y apo 0 mexri kai 7
	 * @return int pou periexei tin syntetagmeni y
	 */
	public int getPosY()
	{
		return this.posY;
	}

	/**
	 * Kanei overide tin methodo clone tis java.lang.object
	 * Epistrefei ena keli me tis idiotites toy kelioy
	 * @return Keli-diaforetiko antikeimeno apo to Keli pou egine clone 
	 */
	public Keli clone()
	{
		if(this.hasPiece())
		{
			Keli tempKeli=new Keli(this.getColor(),this.getPosY(),this.getPosX());
			tempKeli.setPiece(this.getPiece());
			tempKeli.hasPiece();
			tempKeli.setThreatend(this.getThreatend());
			return tempKeli;
		}
		else
		{
			Keli tempKeli=new Keli(this.getColor(),this.getPosY(),this.getPosX());
			tempKeli.piece=null;
			tempKeli.hasPiece();
			tempKeli.setThreatend(this.getThreatend());
			return tempKeli;
		}
	}
	/**
	 * Kanei overide tin methodo equals tis java.lang.object
	 * Elegxei an to keli isoute me kapio allo
	 * @param cell to keli pou theloume na elegxoume an einai iso 
	 * @return true an einai ,false an den einai isa
	 */
	public boolean equals(Object cell)
	{
		if(this.getPosY()==((Keli)cell).getPosY() && this.getPosX()==((Keli)cell).getPosX())
		{
			return true;
		}
		return false;
	}
	/**
	 * static methodos pou kanei clone ena Keli[8][8]
	 * @param board1-Keli[8][8]
	 * @return Keli[8][8]-diaforetiko antikeimeno apo to Keli[8][8] pou egine clone 
	 */
	public static Keli[][] cloneBoard(Keli[][] board1)
	{
		int i,j;
		Keli[][] board2=new Keli[8][8];
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				board2[i][j]=board1[i][j].clone();
			}
		}
		return board2;
	}
}
