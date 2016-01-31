package com.orionletizi.music.theory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Harmonic rhythm is the beatsPerChord at which chords change in relation to the beatsPerChord of notes:</p>
 * <blockquote>
 * https://en.wikipedia.org/wiki/Harmonic_rhythm
 * </blockquote>
 * <p>
 * This implementation encodes harmonic rhythm as the beatsPerChord of beats per chord change
 */
public class HarmonicRhythm {

  @JsonProperty
  private double beatsPerChord;

  public HarmonicRhythm() {
    // for Jackson
  }

  /**
   * Creates a new HarmonicRhythm
   *
   * @param beatsPerChord the beatsPerChord of beats per chord change
   */
  public HarmonicRhythm(double beatsPerChord) {
    assert beatsPerChord > 0;
    this.beatsPerChord = beatsPerChord;
  }

  /**
   * @return the number of beats per chord
   */
  @JsonIgnore
  public double getBeatsPerChord() {
    return beatsPerChord;
  }

  /**
   * @return the number of chords per beat
   */
  @JsonIgnore
  public double getChordsPerBeat() {
    return 1 / beatsPerChord;
  }

  @Override
  public boolean equals(Object obj) {
    boolean rv = false;
    if (obj instanceof HarmonicRhythm) {
      HarmonicRhythm that = (HarmonicRhythm) obj;
      rv = this.beatsPerChord == that.beatsPerChord;
    }
    return rv;
  }

  @Override
  public int hashCode() {
    return (int) beatsPerChord;
  }
}
