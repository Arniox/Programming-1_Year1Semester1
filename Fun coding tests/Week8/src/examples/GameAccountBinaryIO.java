package examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameAccountBinaryIO {

	public static void output(GameAccount outBinary, String fileName) 
	{			
		DataOutputStream out;
		try {
			out = new DataOutputStream(new FileOutputStream(fileName));
			out.writeUTF(outBinary.getName());
			out.writeUTF(outBinary.getAddress());
			out.writeUTF(outBinary.getTrophy().toString());
			out.writeInt(outBinary.getScore());
			out.close();

		} catch (IOException e) 
		{

			e.printStackTrace();
		}


	}

	public static GameAccount input(String string) {

		DataInputStream in;
		GameAccount ga = null;
		try {
			in = new DataInputStream(new FileInputStream(string));

			String name = in.readUTF();
			String addr = in.readUTF();
			Trophy trophy = Trophy.valueOf(in.readUTF());			
			int score = in.readInt();			
			ga = new GameAccount(name,addr,trophy,score);			
			in.close();

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ga;
	}

}
