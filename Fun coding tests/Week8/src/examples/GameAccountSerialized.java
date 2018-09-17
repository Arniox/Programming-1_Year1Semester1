package examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameAccountSerialized {

	public static void main(String[] args)
	{
		GameAccount ga = new GameAccount("Bobby Pinns","123 Street",Trophy.DIAMOND, 5);

		ObjectOutputStream out;
		try {
			System.out.println(ga);
			out = new ObjectOutputStream(new FileOutputStream("GameAccount.ser"));
			out.writeObject(ga);
			out.close();
			
			GameAccount myGameAccount = null;
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("GameAccount.ser"));
			myGameAccount = (GameAccount) in.readObject();
			System.out.println(myGameAccount);
			in.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
