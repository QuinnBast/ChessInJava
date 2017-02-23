package Pieces;

public abstract class Piece {
	private String color;
	private String name;
	private int x;
	private int y;
	
	public Piece(String color, String name, int posx, int posy){
	this.color = color;	
	this.name = name;
	this.x = posx;
	this.y = posy;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setLocation(int posx, int posy){
		this.x = posx;
		this.y = posy;		
	}
	
	public int getXpos(){
		return this.x;
	}
	
	public int getYpos(){
		return this.y;
	}
}
