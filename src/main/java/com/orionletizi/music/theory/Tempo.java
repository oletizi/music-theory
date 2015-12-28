package com.orionletizi.music.theory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Tempo {
  @JsonProperty
  private double microsecondsPerQuarterNote;

  private Tempo() {
    // for Jackson
  }

  private Tempo(final double microsecondsPerQuarterNote) {
    this.microsecondsPerQuarterNote = microsecondsPerQuarterNote;
  }

  public double getMicrosecondsPerQuarterNote() {
    return microsecondsPerQuarterNote;
  }

  public double getBPM() {
    return 60d * 1000d * 1000d / microsecondsPerQuarterNote;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + ": " + getBPM() + "bpm";// / 60d / 1000d / 1000d);
  }

  @Override
  public boolean equals(Object obj) {
    boolean rv = false;
    if (obj instanceof Tempo) {
      rv = microsecondsPerQuarterNote == ((Tempo) obj).microsecondsPerQuarterNote;
    }
    return rv;
  }

  @Override
  public int hashCode() {
    return (int) microsecondsPerQuarterNote;
  }

  public static Tempo newTempoFromMicroseconds(final double us) {
    return new Tempo(us);
  }

  public static Tempo newTempoFromBPM(double bpm) {
    //  1 / bpm                     = min / beat
    // (1 / bpm) * 60 * 1000 * 1000 = us  / beat
    return new Tempo((1 / bpm) * 60 * 1000 * 1000);
  }

}
