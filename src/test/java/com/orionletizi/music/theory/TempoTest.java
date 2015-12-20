package com.orionletizi.music.theory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TempoTest {

  @Test
  public void testSerialize() throws Exception {
    final ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    final Tempo tempo = Tempo.newTempoFromBPM(121.1f);

    final String json = mapper.writeValueAsString(tempo);
    assertEquals(tempo, mapper.readValue(json, tempo.getClass()));
  }

  @Test
  public void testEquals() throws Exception {
    assertEquals(Tempo.newTempoFromBPM(121.1f), Tempo.newTempoFromBPM(121.1f));
    assertNotEquals(Tempo.newTempoFromBPM(121), Tempo.newTempoFromBPM(121.1f));
  }

  @Test
  public void testHashcode() throws Exception {
    assertEquals(Tempo.newTempoFromBPM(121.1f).hashCode(), Tempo.newTempoFromBPM(121.1f).hashCode());
  }
}