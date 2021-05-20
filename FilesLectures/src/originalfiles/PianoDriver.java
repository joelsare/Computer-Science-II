package originalfiles;
import java.util.Scanner;

public class PianoDriver
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String filename;
		
		System.out.print("Song Filename? ");
		filename = in.nextLine();
		
		PlayerPiano noisyPiano = new PlayerPiano();
		noisyPiano.loadSong(filename);
		
		noisyPiano.playSong();
		
	}
	
}
