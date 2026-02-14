package gamemaster;
/**
 * Player class
 * @author Myron,Stavros
 * @version 1.0
 */
public class Player 
{
	private String player1,player2;
	private char color1,color2;
	private static String paiktis1,paiktis2;
	private static char xrwma1,xrwma2;
	private static char currentcolor;
	private static String currentplayer1,currentplayer2;
	/**
	 * Orizei tous paiktes tou paixnidiou me ta onomata kai to xrwma tous
	 * pre:to xrwma twn paiktwn prepei na einai char 'b' i 'w'
	 * @param name1-String onoma prwtou paikti
	 * @param name2-String onoma defterou paikti
	 * @param color1-char xrwma prwtou paikti
	 * @param color2-char xrwma defterou paikti
	 * @throws IllegalArgumentException("Lathos orismos xrwmatos")
	 */
	public Player(String name1,String name2,char color1,char color2) throws IllegalArgumentException
	{
		this.player1=name1;
		this.player2=name2;
		paiktis1=name1;
		paiktis2=name2;
		if(color1=='b' || color1=='w')
		{
			this.color1=color1;
			xrwma1=color1;
		}
		else
		{
			throw new IllegalArgumentException("Lathos orismos xrwmatos");
		}
		if(color2=='b' || color2=='w')
		{
			this.color2=color2;
			xrwma2=color2;
		}
		else
		{
			throw new IllegalArgumentException("Lathos orismos xrwmatos");
		}
		if(color1=='w')
		{
			currentcolor=color1;
			currentplayer1=name1;
			currentplayer2=name2;
		}
		else
		{
			currentcolor=color2;
			currentplayer1=name2;
			currentplayer2=name1;
		}
	}
	/**
	 * Epistrefei se String ton prwto paikti kai to xrwma tou
	 * @return String
	 */
	public static String getPlayer1()
	{
		return paiktis1+" "+xrwma1;
	}
	/**
	 * Epistrefei se String ton deftero paikti kai to xrwma tou
	 * @return String
	 */
	public static String getPlayer2()
	{
		return paiktis2+" "+xrwma2;
	}
	/**
	 * Orizei to xrwma pou exei seira na paixei sto paixnidi
	 * pre:to xrwma prepei na einai char 'b' h 'w'
	 * @param color-char me 'b' h 'w'
	 * @throws IllegalArgumentException("Lathos xrwma ston current player")
	 */
	public static void setCurrentColor(char color)
	{
		if(color=='w' || color=='b')
		{
			currentcolor=color;
		}
		else
		{	
			throw new IllegalArgumentException("Lathos xrwma ston current player");
		}
	}
	/**
	 * Epistrefei ton paiktei pou den exei seira na paixei
	 * @return String-me to onoma tou paikti
	 */
	public static String getTheOtherPlayer()
	{
		if(currentcolor=='w')
		{
			return currentplayer2;
		}
		else
		{
			return currentplayer1;
		}
	}
	/**
	 * Epistrefei ton paiktei pou exei seira na paixei
	 * @return String-me to onoma tou paikti
	 */
	public static String getCurrentPlayer()
	{
		if(currentcolor=='w')
		{
			return currentplayer1;
		}
		else
		{
			return currentplayer2;
		}
	}
	/**
	 * Epistrefei to xrwma pou eixei seira na paixei
	 * @return char-'b' h 'w'
	 */
	public static char getCurrentColor()
	{
		return currentcolor;
	}
	/**
	 * Allazei to xrwma pou exei seira na paixei
	 * p.x. an to xrwma 'w' to allazei se 'b' kai antistrofa 
	 */
	public static void changeCurrentColor()
	{
		if(currentcolor=='w')
		{
			currentcolor='b';
		}
		else
		{
			currentcolor='w';
		}
	}
	
	
}
