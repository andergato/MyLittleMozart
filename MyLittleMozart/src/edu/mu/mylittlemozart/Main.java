package edu.mu.mylittlemozart;
import edu.mu.mylittlemozart.*;
import edu.mu.mylittlemozart.csv.*;
import edu.mu.mylittlemozart.csv.parsing.*;
import edu.mu.mylittlemozart.absfactory.*;
import edu.mu.mylittlemozart.absfactory.midievent.*;
import edu.mu.mylittlemozart.instrument.*;
import edu.mu.mylittlemozart.instrument.strategy.*;
import java.util.List;
import javax.sound.midi.*;

public class Main {
	
	public static void main(String[] args)
	{
		try {
			List<MidiEventData> midiEvent = MidiCsvParser.midiEventListCreator("/Users/ethanbrandwien/git/MyLittleMozart/MyLittleMozart/src/edu/mu/mylittlemozart/mystery_song.csv");
		    Sequence sequence = new Sequence(Sequence.PPQ, 384);
		    Track track = sequence.createTrack();
		    //System.out.println(midiEvent.get(4).getNote());
			
		    MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
		    //MidiEventFactoryAbstract factoryAbstractTwo = new StaggatoMidiEventFactory();
		    //MidiEventFactoryAbstract factoryAbstractThree = new LegatoMidiEventFactory();
		    
		    MidiEventFactory factory = factoryAbstract.createFactory();
		    
		    
		    //InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
			//instrumentStrategy.applyInstrument(track, 0);
		    //instrumentStrategy = new TrumpetStrategy();
		    //instrumentStrategy.applyInstrument(track, 1);
		    
		    //PitchStrategy pitchStrategy = new HigherPitchStrategy();
		    
		    for(MidiEventData event : midiEvent)
		    {
		    	//int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
		    	//modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
		    
		    	if(event.getNoteOnOff() == ShortMessage.NOTE_ON)
		    	{
		    		track.add(factory.createNoteOn(event.getStartEndTick(), event.getNote(), event.getVelocity(), event.getChannel())); 
		            System.out.println("added event: Note = " + event.getNote() + ", Velocity = " + event.getVelocity() + ", Tick = " + event.getStartEndTick() + event.getChannel());; //getNote not correct, needs to be modified note once strategies added
		    	} //hmmm no velocity or channel 
		    	else
		    	{
		    		track.add(factory.createNoteOff(event.getStartEndTick(), event.getNote(), event.getChannel())); 
		            System.out.println("added event: Note = " + event.getNote() + ", Tick = " + event.getStartEndTick() + event.getChannel()); ////getNote not correct, needs to be modified note once strategies added
		          //hmmm no velocity or channel 
		    	}
		    }
		    
		    Sequencer sequencer = MidiSystem.getSequencer();
		    sequencer.open();
		    sequencer.setSequence(sequence);
		    sequencer.start();
		    System.out.println("sequencer has started");
		    
		    while(sequencer.isRunning() | sequencer.isOpen())
		    {
		    	Thread.sleep(100);
		    }
		    	Thread.sleep(500);
		    	sequencer.close();
			    System.out.println("sequencer has closed"); //not printing

		    }catch(Exception e)
		  {
			 e.printStackTrace();
		  }
	  }
	}
