package music;

import java.util.LinkedList;

/**
 * A collection of Notes to represent a Song.
 * 
 * @author Dr. Dorn
 */
public class Song
{
	// instance variables
	private double wholeNoteLength;
	private LinkedList<Note> notes;

	// constructor
	// "G4 .125; G4 .125; G4 .125; Eb4 .5";
	public Song(String theSong, double wholeNote)
	{
		this.wholeNoteLength = wholeNote;
		// construct an empty list
		notes = new LinkedList<Note>();

		while (theSong.length() > 0)
		{
			String n;

			// read a note
			int semi = theSong.indexOf(";");

			if (semi != -1)
			{
				n = theSong.substring(0, semi).trim();
				theSong = theSong.substring(semi + 1);
			} else
			{
				n = theSong.trim();
				theSong = "";
			}

			// build a Note object
			int space = n.indexOf(" ");
			
			Note theNote = new Note(n.substring(0, space),
									Double.parseDouble(n.substring(space + 1)));

			// put it in the list
			notes.add(theNote);
		}
	}

	// methods
	public String toString()
	{
		String result = "";
		for (Note n : notes)
		{
			result += n.toString() + "; ";
		}

		return result;
	}

	public double getTempo()
	{
		return this.wholeNoteLength;
	}

	public void insertAt(Note n, int x)
	{
		notes.add(x, n);
	}

	public void insert(Note n)
	{
		notes.add(n);
	}
	
	public void deleteAt(int x)
	{
		notes.remove(x);
	}

	public void playback()
	{
		SimpleSound.playSong(this.toString(), wholeNoteLength);
	}

}
