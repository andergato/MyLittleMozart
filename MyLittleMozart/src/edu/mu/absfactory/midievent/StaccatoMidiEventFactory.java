package edu.mu.absfactory.midievent;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StaccatoMidiEventFactory implements MidiEventFactory{
	
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		// TODO Auto-generated method stub
	int duration = tick - 120;
	ShortMessage noteOnCreation = new ShortMessage();
	noteOnCreation.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
	return new MidiEvent(noteOnCreation, duration);
	}
	
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException
	{
		// TODO Auto-generated method stub
		int duration = tick - 120;
		ShortMessage noteOffCreation = new ShortMessage();
		noteOffCreation.setMessage(ShortMessage.NOTE_ON, channel, note);
		return new MidiEvent(noteOffCreation, duration);
	}
}
