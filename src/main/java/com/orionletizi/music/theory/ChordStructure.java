package com.orionletizi.music.theory;

import java.util.ArrayList;
import java.util.List;

public class ChordStructure {

  private final List<ChordSegment> segments = new ArrayList<>();

  public void addSegment(Chord chord, double beatCount) {
    segments.add(new ChordSegment(chord, beatCount));
  }

  public Chord getChordForBeat(double beat) {
    float maxBeat = 0;
    for (ChordSegment segment : segments) {
      maxBeat += segment.getBeatCount();
      if (0 < beat && beat <= maxBeat) {
        return segment.getChord();
      }
    }
    return Chord.NULL;
  }

  private class ChordSegment {
    private final Chord chord;
    private final double beatCount;

    public ChordSegment(final Chord chord, final double beatCount) {
      this.chord = chord;
      this.beatCount = beatCount;
    }

    public Chord getChord() {
      return chord;
    }

    public double getBeatCount() {
      return beatCount;
    }
  }
}
