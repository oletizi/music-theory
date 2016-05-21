package com.orionletizi.music.theory.scale;

import org.jfugue.theory.Note;

public class ChromaticScale implements Scale {
  @Override
  public Note nextNote(Note note) {
    return new Note(note.getValue() + 1);
  }

  @Override
  public Note previousNote(Note note) {
    return new Note(note.getValue() - 1);
  }
}
