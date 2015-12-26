package com.orionletizi.music.theory;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TimeSignature {
  private int beatsPerBar;
  private int beatUnit;

  private TimeSignature() {
    // for Jackson
  }

  public TimeSignature(final int beatsPerBar, final int beatUnit) {
    this.beatsPerBar = beatsPerBar;
    this.beatUnit = beatUnit;
  }

  @Override
  public String toString() {
    return beatsPerBar + "/" + beatUnit;
  }

  @Override
  public boolean equals(Object obj) {
    boolean rv = false;
    if (obj instanceof TimeSignature) {
      final TimeSignature that = (TimeSignature) obj;
      rv = new EqualsBuilder().append(beatsPerBar, that.beatsPerBar).append(beatUnit, that.beatUnit).isEquals();
    }
    return rv;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(beatsPerBar).append(beatUnit).build();
  }

  public int getBeatsPerBar() {
    return beatsPerBar;
  }

  public void setBeatsPerBar(int b) {
    this.beatsPerBar = b;
  }

  public int getBeatUnit() {
    return beatUnit;
  }

  public void setBeatUnit(int b) {
    this.beatUnit = b;
  }
}
