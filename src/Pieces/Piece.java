package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public abstract class Piece {
	private String color;
	private String name;
	private Location location;
	
	public Piece(String color, String name, int posx, int posy){
	this.color = color;	
	this.name = name;
	this.location = new Location(posx, posy);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setLocation(int posx, int posy){
		this.location.setX(posx);
		this.location.setY(posy);
	}
	
	public Location getLocation(){
		return this.location;
	}
	
	public abstract ArrayList<Location> getPossibleMoves(ChessBoard board);
}
