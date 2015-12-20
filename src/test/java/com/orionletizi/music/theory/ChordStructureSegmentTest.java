package com.orionletizi.music.theory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChordStructureSegmentTest {

  @Test
  public void testSerialize() throws Exception {
    final ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

    final ChordStructureSegment segment = new ChordStructureSegment(new Chord("I"), 4);
    final String json = mapper.writeValueAsString(segment);

    final ChordStructureSegment in = mapper.readValue(json, ChordStructureSegment.class);

    assertEquals(segment, in);
  }

  @Test
  public void testEquals() throws Exception {
    assertEquals(new ChordStructureSegment(new Chord("I"), 4), new ChordStructureSegment(new Chord("I"), 4));
  }

  @Test
  public void testHashcode() throws Exception {
    assertEquals(newChordStructureSegment("I", 3).hashCode(), newChordStructureSegment("I", 3).hashCode());
  }

  private ChordStructureSegment newChordStructureSegment(final String chordName, final int beatCount) {
    return new ChordStructureSegment(new Chord(chordName), beatCount);
  }
}