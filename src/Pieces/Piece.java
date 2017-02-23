package Pieces;

public abstract class Piece {
	private String color;
	private String name;
	
	public Piece(String color, String name){
	this.color = color;	
	this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getColor(){
		return this.color;
	}
}
