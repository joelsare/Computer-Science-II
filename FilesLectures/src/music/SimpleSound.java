package music;

import java.util.ArrayList;
import javax.sound.sampled.*;

/**
 * The SimpleSound class provides a basic interface to the computer's sound card.
 * The interface provides the same methods as the Scribbler's sound methods for
 * consistency.  There are also additional methods to demonstrate different
 * properties of sound representation.  This class makes use of some code provided
 * by Doug Harms in the Scribbler class.
 * 
 * @author Dr. Dorn
 * @version V1.0
 */
public class SimpleSound
{
    private static final double SAMPLE_RATE = 22000;  // 22Khz, high quality default sample rate

    /**
     * Causes the computer to emit a melodic single frequency tone.
     * 
     * @param   frequency   The frequency of the tone to emit.
     * @param   duration    The length of the tone to be emitted, in seconds.
     */
    public static void beep(int frequency, double duration)
    {
        beep(frequency, duration, SAMPLE_RATE, 1);
    }

    /**
     * Causes the computer to emit a melodic single frequency tone.
     * 
     * @param   frequency   The frequency of the tone to emit.
     * @param   duration    The length of the tone to be emitted, in seconds.
     * @param   sampleRate  The sampling rate to be used in construction of the tone, 
     *                      specified in hz.
     * @param   volume      The volume for the tone specified as a value between 0 (silent)
     *                      to 1 (max vol), inclusive.
     */
    public static void beep(int frequency, double duration, double sampleRate, double volume)
    {
        try
        {
            // construct sound buffer            
            int numSamples = (int) (sampleRate * duration); 
            byte[] samples = new byte[numSamples];           

            // fill the samples array
            for (int i = 0; i < numSamples; i++)
            {
                //now we have to compute the value for each sample based
                //on the position and the frequency
                samples[i] =  (byte) (Math.sin(2 * frequency * Math.PI * i / sampleRate) * (Byte.MAX_VALUE * volume));
            }

            // now we use this array to play the sound
            AudioFormat format = new AudioFormat((float) sampleRate, 8, 1, true, false);

            //Using SourceDataLine here instead of Clip because clip.drain doesn't seem to block properly
            SourceDataLine lineOut = AudioSystem.getSourceDataLine(format);

            lineOut.open(format);
            lineOut.start();            
            lineOut.write(samples, 0, numSamples);
            lineOut.drain();  //wait for sound to finish playing
            lineOut.close();
        }
        catch (Exception e)
        {
            System.out.println("Error in constructing sound");
        }
    }

    /*
    public void beep(int frequency1, int frequency2, double duration)
    {
        //not implemented yet

    }
    */

   
   /**
    * Causes the computer to play a song comprised of a sequence of 0 or more notes. The song is 
    * passed as a String comprised of note specifications separated by semicolons. A note specification 
    * is either a single note followed by a duration or a chord followed by a duration. A single note is
    * either a note name (e.g., A A# Bb B) or a frequency (e.g., 440); a chord consists of two single notes. 
    * Duration is expressed in terms of fraction of a wholenote. 
    * 
    * Note: playing of chords is not yet implemented.
    * 
    * @param    song    A sequence of 0 or more notes
    * @param    wholeNote   The duration of a whole note, in seconds
    */
    public static void playSong(String song, double wholeNote)
    {
        song s = new song(song);
        s.play(wholeNote);        
    }

    
    //----------Private inner classes below duplicated from Scribbler class written by Doug Harms------------
    /**
     * Class that represents a note, written by Doug Harms for Myro.Scribbler
     */
    private static class note
    {
        public note( String n )
        {
            // remove leading/trailing whitespace, collapse duplicate whitespace, and convert to lowercase
            String s = n.trim().replaceAll("\\s+"," ").toLowerCase();

            // Separate note specification from duration
            String parts[] = s.split("\\s");
            int numParts = parts.length;

            // now we'll parse the string.  Assume it's not valid
            valid = false;
            freq1 = freq2 = 0;

            // must be 2 or three parts
            if( numParts < 2 || numParts > 3 )
                return;

            // first item must be a note specification
            freq1 = parseNote( parts[0] );
            if( freq1 < 0 )
                return;

            // last item must be a double
            try
            {
                duration = Double.parseDouble( parts[numParts-1] );
            } catch (NumberFormatException e)
            {
                return;
            }

            // if there are 3 items then the middle must be a not specification
            if( numParts == 3 )
            {
                freq2 = parseNote( parts[1] );
                if( freq2 < 0 )
                    return;
            }

            // if we've made it this far, it's a valid note specification!
            valid = true;
        }

        public void play( double wholeNote )
        {
            if( freq2 != 0 )
            {
                //beep( freq1, freq2, duration*wholeNote );
            }
            else
            {
                beep( freq1, duration*wholeNote );
            }
        }

        public boolean isValid()
        {
            return valid;
        }

        private int freq1, freq2;
        private double duration;
        private boolean valid;

        private final String[] names={ "c","c#","db","d","d#","eb","e","f","f#","gb","g","g#","ab","a","a#","bb","b", "rest" };
        private final double[] freqs={
                16.35 /* C */,
                17.32, 17.32, /* C#, Db */
                18.35, /* D */
                19.45, 19.45, /* D#, Eb */
                20.60, /* E */
                21.83, /* F */
                23.12, 23.12, /* F#, Gb */
                24.50, /* G */
                25.96, 25.96, /* G#, Ab */
                27.50, /* A */
                29.14, 29.14, /* A#, Bb */
                30.87, /* B */
                0.0 /*rest*/
            };

        private int parseNote( String s )
        {
            int retVal=-1;  // assume invalid note name

            // if the first char is a digit, we'll assume it's a frequency
            if( Character.isDigit( s.charAt( 0 ) ) )
            {
                // convert to an int, if possible
                try
                {
                    retVal = Integer.parseInt( s );
                } catch ( NumberFormatException e) {};
            }
            else
            {
                // doesn't start with a digit so it must be a note name
                // determine octave (default is 5)
                int octave = 5;
                if( Character.isDigit( s.charAt( s.length()-1 ) ) )
                {
                    // determine octave number and remove the digit from s
                    octave = s.charAt( s.length()-1 ) - '0';
                    s = s.substring( 0, s.length()-1 );                   
                }

                // see if s is a valid note name, and if so calculate the frequency
                for( int i=0; i<names.length; i++ )
                {
                    if( s.equals( names[i] ) )
                    {
                        retVal = (int)Math.round( freqs[i] * Math.pow( 2, octave ) );
                        break;
                    }
                }
            }
            return retVal;
        }
    }

    /**
     * Class that represents a song, written by Doug Harms for Myro.Scribbler
     */
    private static class song
    {
        public song( String str )
        {
            notes = new ArrayList<note>();
            String[] specs = str.split( ";" );

            for( int i=0; i<specs.length; i++ )
            {
                note newNote = new note( specs[i] );
                if( newNote.isValid() )
                    notes.add( newNote );
            }
        }

        public void play( double wholeNote )
        {
            for( int i=0; i<notes.size(); i++ )
            {
                notes.get(i).play( wholeNote );
            }
        }

        private ArrayList<note> notes;

    }

}
