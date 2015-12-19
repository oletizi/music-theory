package com.orionletizi.music.theory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChordStructureTest {

  @Test
  public void test() throws Exception {
    final ChordStructure chordStructure = new ChordStructure();
    chordStructure.addSegment(new Chord("I"), 4);
    final Chord chord = chordStructure.getChordForBeat(3);

    assertEquals(new Chord("I"), chord);
    assertEquals(new Chord("I"), chordStructure.getChordForBeat(3.5));
    assertEquals(Chord.NULL, chordStructure.getChordForBeat(-1));
    assertEquals(Chord.NULL, chordStructure.getChordForBeat(0));
    assertEquals(Chord.NULL, chordStructure.getChordForBeat(100));
  }
}