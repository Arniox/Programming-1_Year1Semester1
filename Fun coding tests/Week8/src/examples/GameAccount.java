package examples;

import java.io.Serializable;

public class GameAccount implements Serializable {
	private String name;
	private String address;
	private Trophy trophy;
	private int score;
	//----------------------------------------------------------------
	public GameAccount(String name,String address,Trophy trophy,int score)
	{
		this.setName(name);
		this.setAddress(address);
		this.setScore(score);
		this.setTrophy(trophy);
	}
	//----------------------------------------------------------------
	public String toString()
	{
		return getName()+", "+getAddress()+", "+getTrophy()+", "+getScore();	
	}
	//----------------------------------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Trophy getTrophy() {
		return trophy;
	}
	public void setTrophy(Trophy trophy) {
		this.trophy = trophy;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	



	
	public static void main(String[] args) 
	{
		
		GameAccount outText = new GameAccount("Kenneth","123 Fake Street",Trophy.DIAMOND,65535);
		System.out.println(outText);
		GameAccountTextIO.output(outText, "GameAccount.txt");
		GameAccount inText = GameAccountTextIO.input("GameAccount.txt");
		System.out.println(inText);
		
		
		GameAccount outBinary = new GameAccount("Robin Banks","153 Safe Street",Trophy.PLATINUM,3);
		System.out.println(outBinary);
		GameAccountBinaryIO.output(outBinary,"GameAccount.bin");
		
		GameAccount inBinary = GameAccountBinaryIO.input("GameAccount.bin");
		System.out.println(inBinary);

	}
}
