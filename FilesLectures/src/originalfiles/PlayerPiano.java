package originalfiles;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import music.Note;
import music.Song;



public class PlayerPiano
{
	private Song theSong;
	private String title;
	private String composer;
	
	public PlayerPiano()
	{
		//setup the instance variables here
		theSong = null;
		title = null;
		composer = null;
	}
	
	public boolean loadSong(String songFile)
	{
		//What's the general plan we need?
		Scanner in = null;
		boolean status = false;
		try
		{
			in = new Scanner (new File(songFile));
			title = in.nextLine();
			composer = in.nextLine();
			in.next();
			double tempo = in.nextDouble();
			System.out.println("tempo = " + tempo);
			theSong = new Song("", tempo);
			
			while (in.hasNextLine())
			{
				Note n = new Note(in.next(), in.nextDouble());
				System.out.println(n);
				if (in.hasNextLine())
				{
					in.nextLine();
				}
				theSong.insert(n);
			}
			in.close();
			status = true;
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("file could not be found");
		}
		return status;
	}
	
    /***
     * The play method will cause the PlayerPiano to emit the song
     * previous read from file through the computer speakers. And
     * display a little message about the song's contents.
     */
	public void playSong()
	{
        System.out.println("Now Playing:");
        System.out.println(title + " by: ");
        System.out.println(composer);
        theSong.playback();		
	}

}
