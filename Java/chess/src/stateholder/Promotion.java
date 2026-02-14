package stateholder;
/**
 * Promotion class extends Move
 * implements tis methodous tis Move
 * @author Muron Stavros
 * @version 1.0
 */
public class Promotion extends Move  
{
	private Keli cell;
	private String move;
	/**
	 * Constructor: Dimiourgei ena antikeimeno tis Promotion
	 * Pre: Keli pou den periexei pioni
	 * @throws IllegalArgumentException("To keli exei pioni");
	 * @param cell:Keli pou den periexei pioni
	 */
	public Promotion(Keli cell)
	{
		if(cell.hasPiece())
		{
			throw new IllegalArgumentException("To keli exei pioni");
		}
		this.cell=cell;
		this.move="promotion";
	}
	/**
	 * Dinei to keli pou ginete to promotion
	 * Post: Dinei to keli pou ginete to promotion
	 * @return Keli
	 */ 
	public Keli getCell()
	{
		return this.cell;
	}
	/**
	 * Dinei to onoma tou antikeimenou
	 * @return String : onoma tou antikeimenou
	 */
	public String getName()
	{
		return this.move;
	}

}
