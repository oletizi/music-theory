package com.orionletizi.music.theory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TimeSignatureTest {

  @Test
  public void testSerialize() throws Exception {
    final ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    final TimeSignature sig = new TimeSignature(4, 4);

    final String json = mapper.writeValueAsString(sig);
    final TimeSignature in = mapper.readValue(json, sig.getClass());

    assertEquals(sig, in);
  }

  @Test
  public void testEquals() throws Exception {
    assertNotEquals(new TimeSignature(4, 4), new TimeSignature(3, 4));
    assertEquals(new TimeSignature(4, 4), new TimeSignature(4, 4));
  }

  @Test
  public void testHashcode() throws Exception {
    assertEquals(new TimeSignature(4, 4).hashCode(), new TimeSignature(4, 4).hashCode());
  }
}