package com.orionletizi.music.theory;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ChordStructureSegment extends TimeStructureSegment {

  private Chord chord;
  private HarmonicRhythm harmonicRhythm;

  public ChordStructureSegment() {
  }

  public ChordStructureSegment(final Chord chord, final double beatCount) {
    this.chord = chord;
    this.beatCount = beatCount;
    harmonicRhythm = new HarmonicRhythm(beatCount);
  }

  public Chord getChord() {
    return chord;
  }

  public void setChord(final Chord chord) {
    this.chord = chord;
  }

  @Override
  public boolean equals(Object obj) {
    boolean rv = false;
    if (obj instanceof ChordStructureSegment) {
      final ChordStructureSegment that = (ChordStructureSegment) obj;
      rv = new EqualsBuilder()
          .append(chord, that.chord)
          .append(getBeatCount(), that.getBeatCount()).isEquals();
    }
    return rv;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(chord).append(getBeatCount()).build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("chord", chord).append("beatCount", getBeatCount()).build();
  }

  public HarmonicRhythm getHarmonicRhythm() {
    return harmonicRhythm;
  }
}
