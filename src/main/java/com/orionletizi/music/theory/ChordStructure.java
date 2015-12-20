package com.orionletizi.music.theory;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class ChordStructure {

  private final List<ChordStructureSegment> segments;

  public ChordStructure() {
    segments = new ArrayList<>();
  }

  public void addSegment(Chord chord, double beatCount) {
    segments.add(new ChordStructureSegment(chord, beatCount));
  }

  public Chord getChordForBeat(double beat) {
    float maxBeat = 0;
    for (ChordStructureSegment segment : segments) {
      maxBeat += segment.getBeatCount();
      if (0 < beat && beat <= maxBeat) {
        return segment.getChord();
      }
    }
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    boolean rv = false;
    if (obj instanceof ChordStructure) {
      return new EqualsBuilder().append(segments, ((ChordStructure) obj).segments).isEquals();
    }
    return rv;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(segments).build();
  }
}
