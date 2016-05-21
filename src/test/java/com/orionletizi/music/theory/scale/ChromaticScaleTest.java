package com.orionletizi.music.theory.scale;

import org.jfugue.theory.Note;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChromaticScaleTest {

  @Test
  public void testBasics() {
    final Scale scale = new ChromaticScale();
    Note c = new Note("C3");
    Note cSharp = new Note("C#3");
    Note b = new Note("B2");

    assertEquals(cSharp, scale.nextNote(c));
    assertEquals(b, scale.previousNote(c));
  }
}