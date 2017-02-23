import Pieces.*;

public class ChessBoard{
	private Piece[][] board = new Piece[8][8];
	
	public ChessBoard(){
		for (int i=0; i<8; i++)
		{
			board[1][i] = new Pawn("white");
			board[2][i] = null;
			board[3][i] = null;
			board[4][i] = null;
			board[5][i] = null;
			board[6][i] = new Pawn("black");
		}
		board[7][0] = new Rook("black");
		board[7][1] = new Knight("black");
		board[7][2] = new Bishop("black");
		board[7][3] = new Queen("black");
		board[7][4] = new King("black");
		board[7][5] = new Bishop("black");
		board[7][6] = new Knight("black");
		board[7][7] = new Rook("black");
		
		board[0][0] = new Rook("white");
		board[0][1] = new Knight("white");
		board[0][2] = new Bishop("white");
		board[0][3] = new Queen("white");
		board[0][4] = new King("white");
		board[0][5] = new Bishop("white");
		board[0][6] = new Knight("white");
		board[0][7] = new Rook("white");
	}
	public Piece getPieceAtLocation(int x, int y){
		return board[x][y];
	}

}
	