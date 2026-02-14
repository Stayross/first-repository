package stateholder;
/**
 * SimpleMove class extends Move
 * implements tis methodous tis Move
 * @author Muron Stavros
 * @version 1.1
 */
public class SimpleMove extends Move 
{
	private Keli cell;
	private String move;
	/**
	 * Constructor: Dimiourgei ena antikeimeno tis SimpleMove
	 * Pre: Keli pou den periexei pioni
	 * @throws IllegalArgumentException("To keli exei pioni");
	 * @param cell:Keli pou den periexei pioni
	 */
	public SimpleMove(Keli cell)
	{
		if(cell.hasPiece())
		{
			throw new IllegalArgumentException("To keli exei pioni");
		}
		this.cell=cell;
		this.move="move";
	}
	/**
	 * Dinei to keli pou ginete to SimpleMove
	 * Post: Dinei to keli pou ginete to SimpleMove
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
