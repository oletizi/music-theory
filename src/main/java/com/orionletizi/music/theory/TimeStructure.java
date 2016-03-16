package com.orionletizi.music.theory;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public abstract class TimeStructure<T extends TimeStructureSegment> {
  protected final List<T> segments;

  public TimeStructure() {
    segments = new ArrayList<>();
  }

  public void addSegment(final T segment) {
    segments.add(segment);
  }

  public List<T> getSegments() {
    // Note: returns the mutable field for editing purposes.
    return segments;
  }

  @JsonIgnore
  public double getBeatLength() {
    double rv = 0;
    for (T segment : segments) {
      rv += segment.getBeatCount();
    }
    return rv;
  }

  @JsonIgnore
  public double getMillisecondLength(final Tempo tempo) {
    return getBeatLength() * 1000 * 60 / tempo.getBPM();
  }
}
