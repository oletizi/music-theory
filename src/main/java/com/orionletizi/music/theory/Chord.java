package com.orionletizi.music.theory;

public class Chord {

  private String name;
  private boolean isNull = false;

  private Chord() {
    isNull = true;
  }

  public Chord(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Chord && name.equals(((Chord) obj).name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return "Chord[" + name + "]";
  }
}
