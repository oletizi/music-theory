package com.orionletizi.music.theory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ChordStructureTest {

  private ChordStructure structure;
  private ChordStructure structure1;

  @Before
  public void before() {
    structure = new ChordStructure();
    structure.addSegment(new Chord("I"), 8);

    structure1 = new ChordStructure();
    structure1.addSegment(new Chord("I"), 8);
  }

  @Test
  public void testGetBeatLength() throws Exception {
    assertEquals(8, structure.getBeatLength(), 0);
  }

  @Test
  public void testGetMillisecondLength() throws Exception {
    double bpm = 120;
    Tempo tempo = Tempo.newTempoFromBPM(bpm);

    final double millis = structure.getMillisecondLength(tempo);
    final double beats = structure.getBeatLength();
    
    assertEquals(60 * 1000 * (beats / bpm), millis, 0);
  }

  @Test
  public void testSerialize() throws Exception {

    final ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    final ChordStructure structure = new ChordStructure();
    structure.addSegment(new Chord("I"), 8);
    final String json = mapper.writeValueAsString(structure);
    System.out.println(json);
    final ChordStructure in = mapper.readValue(json, ChordStructure.class);
    assertEquals(structure, in);
  }

  @Test
  public void testEquals() throws Exception {

    assertEquals(structure, structure1);
  }


  @Test
  public void testHashcode() throws Exception {
    assertEquals(structure.hashCode(), structure1.hashCode());
  }


  @Test
  public void test() throws Exception {
    final ChordStructure chordStructure = new ChordStructure();
    chordStructure.addSegment(new Chord("I"), 4);
    final Chord chord = chordStructure.getChordForBeat(3);

    assertEquals(new Chord("I"), chord);
    assertEquals(new Chord("I"), chordStructure.getChordForBeat(3.5));
    assertNull(chordStructure.getChordForBeat(-1));
    assertNull(chordStructure.getChordForBeat(0));
    assertNull(chordStructure.getChordForBeat(100));
  }
}