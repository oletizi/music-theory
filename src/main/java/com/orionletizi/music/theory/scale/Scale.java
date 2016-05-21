package com.orionletizi.music.theory.scale;

import org.jfugue.theory.Note;

public interface Scale {
  Note nextNote(Note note);
  Note previousNote(Note note);
}
