package com.orionletizi.music.theory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class ChordTest {

  @Test
  public void testSerialize() throws Exception {
    final ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

    final Chord chord = new Chord("I");

    final String json = mapper.writeValueAsString(chord);

    System.out.println(json);

    final Chord in = mapper.readValue(json, Chord.class);
    assertEquals(chord, in);
  }

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