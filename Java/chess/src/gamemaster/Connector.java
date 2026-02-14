package gamemaster;

import java.util.Vector;
import stateholder.Bishop;
import stateholder.Keli;
import stateholder.Knight;
import stateholder.Move;
import stateholder.Piece;
import stateholder.Queen;
import stateholder.Rook;
/**
 * Connector class
 * Syndeei to user interface me ton gamemaster kai ton stateholder
 * @author Muron Stavros
 * @version 1.0.6
 */
public class Connector
{
	private Keli[][] board;
	private Keli cel1;
	private Keli cel2;
	private Vector<Move> proposedmoves;
	private Vector<Keli[][]> boards=new Vector();;
	private Piece promotion;
	
	/**
	 * Constructor: Dimiourgei ena antikeimeno Connector
	 * Penrei ena Keli[8][8] kai to apothikeuei stin metavliti this.board
	 * @param Keli[8][8]-board
	 */
	public Connector(Keli[][] board)
	{
		this.board=board;
	}
	/**
	 * Epistrefei Vector<move> pou periexei oles tis protinomenes kinisis tou pioniou
	 * post:epistrefei tis kiniseis tou pioniou
	 * @return Vectros<Move>
	 */
	public Vector<Move> getProposedMoves()
	{
		return this.proposedmoves;
	}
	/**
	 * Orizei tis proteinomenes kinisis enos pioniou
	 * post:Orizontai oi kiniseis tou pioniou
	 */
	public void setProposedMoves()
	{
		this.proposedmoves=this.boards.get(this.boards.size()-Utilities.getMetritis())[this.cel1.getPosY()][this.cel1.getPosX()].getPiece().getMoves(this.boards.get(this.boards.size()-Utilities.getMetritis()),true);
	}
	/**
	 * Orizei to keli pou periexei to pioni pou theloume na kinisoume
	 * post: orizete to keli pou periexei to pioni pou theloume na kinisoume
	 * @param Keli-cel
	 */
	public void setKeliFrom(Keli cel)
	{
		this.cel1=cel;
	}
	/**
	 * Orizei to keli pou theloume na pame to pioni
	 * post: orizete to keli pou theloume na pame to pioni
	 * @param Keli-cel
	 */
	public void setKeliTo(Keli cel)
	{
		this.cel2=cel;
	}
	/**
	 * Epistrefei to teleftaio board tou Vector<Keli[][]> pou periexei ta board tou torinou paixnidiou
	 * @return Keli[][]- to teleftaio board tou paixnidiou
	 */
	public Keli[][] getBoard()
	{
		return this.board;
	}
	/**
	 * Diagrafei to mexri twra paixnidi kai dimiourgei kainourgio me to board pou dinoume
	 * @param board-Keli[][]
	 */
	public void resetBoard(Keli[][] board)
	{
		this.board=board;
		this.boards.clear();
		this.boards.add(Keli.cloneBoard(board));
	}
	/**
	 * Orizei to current board tou paixnidiou
	 * @param Keli[][]-board
	 */
	public void setBoard(Keli[][] board)
	{
		this.board=board;
	}
	/**
	 * Epistrefei ton Vector<Keli[][]> pou periexei ola ta boards 
	 * @return Vector<Keli[][]>-me ta boards tou paixnidiou
	 */
	public Vector<Keli[][]> getBoardsVector()
	{
		return this.boards;
	}
	/**
	 * Ektelei tin kinisi panw sti skakiera(Keli[8][8]) kai apothikeuei
	 * se vector<Keli[][]> tin kainourgia skakiera pou dimiourgeitai  
	 */
	public void makeTheMove()
	{
		int i;
		boolean canmove=false;
		String movetype="";
		for(i=0;i<this.proposedmoves.size();i++)
		{
			if(this.proposedmoves.get(i).getCell().equals(this.cel2))
			{
				canmove = true;
				movetype = this.proposedmoves.get(i).getName();
			}
		}
		if(canmove)
		{
			this.boards=Utilities.newMoveIsMade(this.boards);
			if(movetype =="move")
			{
				this.boards.add(makemove());	
			}
			else if(movetype =="capture")
			{
				this.boards.add(makecapture());
			}
			else if(movetype =="promotion")
			{
				this.boards.add(makepromotion());
			}
			else if(movetype =="capture-promotion")
			{
				this.boards.add(makecaptruepromotion());
			}
			setBoard(this.boards.lastElement());
			Player.changeCurrentColor();
			Utilities.resetMetritis();
		}
	}
	/**
	 * Orizei to promotion tou pioniou
	 * pre:to Sting na einai Queen h Rook h Bishop h Knight
	 * @param prom-String me to onoma tou pioniou sto opoio tha proaxoume to pawn
	 * @throws IllegalArgumentException
	 */
	public void setPromotion(String prom) throws IllegalArgumentException
	{
		if(prom.equals("Queen"))
		{
			this.promotion=new Queen(this.cel1.getPiece().getColor(),0,0);
		}
		else if(prom.equals("Rook"))
		{
			this.promotion=new Rook(this.cel1.getPiece().getColor(),0,0);
			this.promotion.HasMoved();
		}
		else if(prom.equals("Knight"))
		{
			this.promotion=new Knight(this.cel1.getPiece().getColor(),0,0);
		}
		else if(prom.equals("Bishop"))
		{
			this.promotion=new Bishop(this.cel1.getPiece().getColor(),0,0);
		}
		else
		{
			throw new IllegalArgumentException("lathos onoma pioniou");
		}
	}
	
	private Keli[][] makemove()
	{
		Keli[][] board=new Keli[8][8];
		board=Keli.cloneBoard(this.boards.get(this.boards.size()-1));
		board[this.cel2.getPosY()][this.cel2.getPosX()].setPiece(board[this.cel1.getPosY()][this.cel1.getPosX()].getPiece());
		board[this.cel1.getPosY()][this.cel1.getPosX()].erasePiece();
		board[this.cel2.getPosY()][this.cel2.getPosX()].getPiece().HasMoved();
		return board;
	}
	private Keli[][] makecapture()
	{
		Keli[][] board=new Keli[8][8];
		board=Keli.cloneBoard(this.boards.get(this.boards.size()-1));
		board[this.cel2.getPosY()][this.cel2.getPosX()].erasePiece();
		board[this.cel2.getPosY()][this.cel2.getPosX()].setPiece(board[this.cel1.getPosY()][this.cel1.getPosX()].getPiece());
		board[this.cel1.getPosY()][this.cel1.getPosX()].erasePiece();
		board[this.cel2.getPosY()][this.cel2.getPosX()].getPiece().HasMoved();
		return board;
	}
	private Keli[][] makepromotion()
	{
		Keli[][] board=new Keli[8][8];
		board=Keli.cloneBoard(this.boards.get(this.boards.size()-1));
		board[this.cel2.getPosY()][this.cel2.getPosX()].setPiece(this.promotion);
		board[this.cel1.getPosY()][this.cel1.getPosX()].erasePiece();
		return board;
	}
	private Keli[][] makecaptruepromotion()
	{
		Keli[][] board=new Keli[8][8];
		board=Keli.cloneBoard(this.boards.get(this.boards.size()-1));
		board[this.cel2.getPosY()][this.cel2.getPosX()].erasePiece();
		board[this.cel2.getPosY()][this.cel2.getPosX()].setPiece(this.promotion);
		board[this.cel1.getPosY()][this.cel1.getPosX()].erasePiece();
		return board;
	}
}
