package edu.mu.mylittlemozart.instrument.strategy;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/*
 * This strategy allows for use of the Trumpet Midi Instrument
 */
public class TrumpetStrategy implements InstrumentStrategy{
	//Trumpet Midi instrument number
	int instrument = 56;

	@Override
	public void applyInstrument(Track track, int channel) throws MidiUnavailableException, InvalidMidiDataException {
		ShortMessage sm = new ShortMessage( );
		sm.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrument, 0);
		track.add(new MidiEvent(sm, 0));
		
	}
	
	
}
