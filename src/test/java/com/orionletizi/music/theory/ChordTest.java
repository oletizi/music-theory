package com.orionletizi.music.theory;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class ChordTest {

  @Test
  public void testEquals() throws Exception {
    final Chord chord = new Chord("I");

    assertEquals(new Chord("I"), chord);
    assertFalse(new Chord("II").equals(chord));
  }

  @Test
  public void testHashcode() throws Exception {
    final Chord chord = new Chord("I");
    assertEquals(new Chord("I").hashCode(), chord.hashCode());
    assertEquals(new Chord("IV").hashCode(), new Chord("IV").hashCode());
  }
}