package Pieces;

import java.util.ArrayList;

import Engine.ChessBoard;

public abstract class Piece {
	private String color;
	private String name;
	private Location location;
	private String imagePath;
	
	public Piece(){
		
	}
	
	public Piece(String color, String name, int posx, int posy){
	this.color = color;	
	this.name = name;
	this.location = new Location(posx, posy);
	if(color == "white"){
		this.imagePath = "/Images/White"+name+".png";
	}
	else
		this.imagePath = "/Images/Black"+name+".png";
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getImagePath(){
		return this.imagePath;
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
	
	public abstract ArrayList<Location> getPossibleMoves();
}
