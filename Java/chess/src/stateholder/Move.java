package stateholder;
/**
 * Abstract class Move
 * Periexei plirofories gia to eidos tis kinisis
 * @author Stavros Muron
 * @version 1.0
 */
public abstract class Move 
{	
	/**
	 * Epistrefei to keli pou paei to pioni
	 * @return Keli pou paei to pioni
	 */
	public abstract Keli getCell();	
	/**
	 * Epistrefei String me to eidos tis kinisis
	 * Eidi kinisewn:
	 * SimpleMove
	 * Captrue
	 * Promotion
	 * Capture-Promotion
	 * @return String me ena apo ta parapanw eidi kinisewn
	 */
	public abstract String getName();
}
