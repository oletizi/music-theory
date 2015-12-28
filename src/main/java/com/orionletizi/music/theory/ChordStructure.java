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

  public void addSegment(final Chord chord, final double beatCount) {
    segments.add(new ChordStructureSegment(chord, beatCount));
  }

  public void addSegment(final ChordStructureSegment segment) {
    segments.add(segment);
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

  public List<ChordStructureSegment> getSegments() {
    // Note: returns the mutable field for editing purposes.
    return segments;
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
