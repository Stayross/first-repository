package GUI;

import gamemaster.Event;
import gamemaster.Player;
import gamemaster.Connector;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import stateholder.Keli;
import stateholder.Piece;

/**
 * GraphicKeli extends JLabel implements MouseListener
 * Dimiourgei graphiko keli 
 * @author Stavros Muron
 * @version 1.0
 */
public class GraphicKeli extends JLabel implements MouseListener
{
	private int X;
	private int Y;
	private Piece piece;
	private ImageIcon image=null;
	private Keli cell;
	private Connector mesazon;
	private GraphicBoard board;
	
	GraphicKeli(Keli cell,Connector mesazon,GraphicBoard board)
	{
		super("",JLabel.CENTER);
		this.addMouseListener(this);
		this.board=board;
		this.mesazon=mesazon;
		this.cell=cell.clone();
		this.setOpaque(true);
		if(cell.getColor()=='b')
		{
			this.setBackground(Color.DARK_GRAY);
		}
		else
		{
			this.setBackground(Color.LIGHT_GRAY);
		}
		this.Y=cell.getPosY();
		this.X=cell.getPosX();
		if(cell.getPiece()!=null)
		{
			this.piece=cell.getPiece();
			this.piece.setNumberPosition(Y,X);;
			InputStream inIcon = ClassLoader.getSystemResourceAsStream("chess2/"+cell.getPiece().getColor()+cell.getPiece().getName()+".png");
			BufferedImage imgIcon = null;
			try {
				imgIcon = ImageIO.read(inIcon);
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.image=new ImageIcon(imgIcon);
			this.setIcon(this.image);
		}
	}
	
	void clearHighlight()
	{
		if(this.cell.getColor()=='w')
		{
			this.setBackground(Color.LIGHT_GRAY);
		}
		else
		{
			this.setBackground(Color.DARK_GRAY);
		}
	}

	
	char getKeliColor()
	{
		return this.cell.getColor();
	}
	
	private void click1()
	{
		GraphicBoard.setClick(2);
		this.board.setCell(this.cell);
		this.mesazon.setKeliFrom(this.cell);
		this.mesazon.setProposedMoves();
		this.board.Highlight(this.mesazon.getProposedMoves());
	}
	
	private void click2()
	{
		GraphicBoard.setClick(1);
		this.mesazon.setKeliTo(this.cell);
		if(this.board.getCell().getPiece().getName()=="Pawn")
		{
			if(this.board.getCell().getPiece().getColor()=='w')
			{
				if(this.cell.getPosY()==0 && this.board.getCell().getPosY()==1)
				{
					Object[] possibilities = {"Queen", "Bishop", "Rook","Knight"};
					Icon icon=null;
					String s=null;
					while(s==null)
					{
							s = (String)JOptionPane.showInputDialog(
					                    this.board,
					                    "What u want to make the pawn ?",
					                    "Promotion",
					                    JOptionPane.PLAIN_MESSAGE,
					                    icon,
					                    possibilities,
					                    "Queen");
					}
					this.mesazon.setPromotion(s);
				}
			}
			else
			{
				if(this.cell.getPosY()==7 && this.board.getCell().getPosY()==6)
				{
					Object[] possibilities = {"Queen", "Bishop", "Rook","Knight"};
					Icon icon=null;
					String s=null;
					while(s==null)
					{
							s = (String)JOptionPane.showInputDialog(
					                    this.board,
					                    "What u want to make the pawn ?",
					                    "Promotion",
					                    JOptionPane.PLAIN_MESSAGE,
					                    icon,
					                    possibilities,
					                    "Queen");
					}
					this.mesazon.setPromotion(s);
				}
			}
		}
		this.mesazon.makeTheMove();
		this.board.setBoard(this.mesazon.getBoard());
		if(Event.isMat(this.mesazon.getBoard()))
		{
			JOptionPane.showMessageDialog(this.board,"Mat\nWinner is "+Player.getTheOtherPlayer());
		}
		/*if(Event.isPat(this.mesazon.getBoard()))
		{
			JOptionPane.showMessageDialog(this.board,"Pat\nWinner is nobody");
		}*/
	}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0)
	{
		if(GraphicBoard.getClick()==1)
		{
			if(this.cell.hasPiece() && Player.getCurrentColor()==this.cell.getPiece().getColor())
			{
				click1();
			}
		}
		else if(GraphicBoard.getClick()==2)
		{
			if(this.cell.hasPiece() && Player.getCurrentColor()==this.cell.getPiece().getColor())
			{
				if(!this.cell.equals(this.board.getCell()))
				{
					this.board.clearHighlight(this.mesazon.getProposedMoves());
					click1();
				}
			}
			if(this.cell.hasPiece() && Player.getCurrentColor()!=this.cell.getPiece().getColor())
			{
				click2();
			}
			else if(!this.cell.hasPiece())
			{
				click2();
			}
		}
	}
}
