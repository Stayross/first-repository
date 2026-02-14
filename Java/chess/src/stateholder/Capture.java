package stateholder;
/**
 * Capture class extends Move
 * implements tis methodous tis Move
 * @author Muron Stavros
 * @version 1.0
 */
public class Capture extends Move 
{
	private Keli cell;
	private String move;
	/**
	 * Constructor: Dimiourgei ena antikeimeno tis capture
	 * Pre: Keli pou periexei pioni
	 * @throws IllegalArgumentException("To keli den exei pioni");
	 * @param cell:Keli pou periexei pioni
	 */
	public Capture(Keli cell)
	{
		if(!cell.hasPiece())
		{
			throw new IllegalArgumentException("To keli den exei pioni");
		}
		this.cell=cell;
		this.move="capture";
	}
	/**
	 * Dinei to keli pou ginete to capture
	 * Post: Dinei to keli pou ginete to capture
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
