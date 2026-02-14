package stateholder;
/**
 * Capturepromotion class extends Move
 * implements tis methodous tis Move
 * @author Muron Stavros
 * @version 1.0
 */
public class Capturepromotion extends Move 
{
	private Keli cell;
	private String move;
	/**
	 * Constructor: Dimiourgei ena antikeimeno tis capturepromotion
	 * Pre: Keli pou periexei pioni
	 * @throws IllegalArgumentException("To keli den exei pioni");
	 * @param cell:Keli pou periexei pioni
	 */
	public Capturepromotion(Keli cell)
	{
		if(!cell.hasPiece())
		{
			throw new IllegalArgumentException("To keli den exei pioni");
		}
		this.cell=cell;
		this.move="capture-promotion";
	}
	/**
	 * Dinei to keli pou ginete to capturepromotion
	 * Post: Dinei to keli pou ginete to capturepromotion
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
