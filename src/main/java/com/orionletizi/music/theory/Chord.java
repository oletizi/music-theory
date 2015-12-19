package com.orionletizi.music.theory;

public class Chord {

  public static final Chord NULL = new Chord();
  private final String name;

  private Chord() {
    name = "null";
  }

  public Chord(String name) {
    this.name = name;
  }

  public boolean isNull() {
    return "null".equals(name);
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
