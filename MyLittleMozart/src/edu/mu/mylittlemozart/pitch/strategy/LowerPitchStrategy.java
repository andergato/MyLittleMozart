package edu.mu.mylittlemozart.pitch.strategy;

public class LowerPitchStrategy implements PitchStrategy{
	
	/*
	 * In the LowerPitchStrategy, the note integer input will be decreased by two and returned.
	 */
	@Override
	public int modifyPitch(int note) {
		note = note - 2;
		return note;
	}
	
}
