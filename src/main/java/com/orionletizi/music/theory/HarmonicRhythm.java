package com.orionletizi.music.theory;

/**
 * <p>Harmonic rhythm is the beatsPerChord at which chords change in relation to the beatsPerChord of notes:</p>
 * <blockquote>
 * https://en.wikipedia.org/wiki/Harmonic_rhythm
 * </blockquote>
 * <p>
 * This implementation encodes harmonic rhythm as the beatsPerChord of beats per chord change
 */
public class HarmonicRhythm {

  private double beatsPerChord;

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
  public double getBeatsPerChord() {
    return beatsPerChord;
  }

  /**
   * @return the number of chords per beat
   */
  public double getChordsPerBeat() {
    return 1 / beatsPerChord;
  }
}
