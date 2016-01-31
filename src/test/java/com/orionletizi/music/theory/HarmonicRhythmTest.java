package com.orionletizi.music.theory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HarmonicRhythmTest {

  @Test
  public void test() throws Exception {
    HarmonicRhythm harmonicRhythm = new HarmonicRhythm(1);
    assertEquals(1d, harmonicRhythm.getBeatsPerChord());
    assertEquals(1d, harmonicRhythm.getChordsPerBeat());

    harmonicRhythm = new HarmonicRhythm(2);
    assertEquals(2d, harmonicRhythm.getBeatsPerChord());
    assertEquals(0.5d, harmonicRhythm.getChordsPerBeat());
  }

  @Test
  public void testEqualsHashcodeAndSerialize() throws Exception {
    final ObjectMapper mapper = new ObjectMapper();
    final HarmonicRhythm harmonicRhythm = new HarmonicRhythm(1);

    final String serialized = mapper.writeValueAsString(harmonicRhythm);

    final HarmonicRhythm clone = mapper.readValue(serialized, HarmonicRhythm.class);

    assertEquals(harmonicRhythm, clone);
    assertEquals(harmonicRhythm.hashCode(), clone.hashCode());
  }

}