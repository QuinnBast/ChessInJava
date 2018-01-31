package Engine.Board.Pieces;

public class Location {
	private int x;
	private int y;
	private boolean isCastling = false;
	private boolean isEnPassant = false;
	
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public boolean isCastling(){
		return isCastling;
	}
	
	public void setIsCastling(){
		isCastling = true;
	}

	public boolean isEnPassant(){return isEnPassant;}

	public void setEnPassant(){this.isEnPassant = true;}

}
