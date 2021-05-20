package music;

/**
 * A basic Note representation.
 * 
 * @author Dr. Dorn
 */
public class Note
{
    // instance data
    private double duration;
    private String noteName;
    
    //constructors
    public Note(String theNote, double theDuration) 
    {   
        noteName = theNote;
        duration = theDuration;
    }

    //methods
    public String toString()  //"G4 .125";
    {        
        return noteName + " " + duration ;
    }

}
