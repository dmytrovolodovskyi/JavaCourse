package service;

import entites.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NoteService {

    Map<Long, Note> noteMap = new HashMap<>();
    private Long nextId = 1L;

    public Map<Long, Note> listAll() {
        return noteMap;
    }

    public Note add(Note note) {
        Long id = generateNextId();
        note.setId(id);
        noteMap.put(id, note);
        return note;
    }

    public void deleteById(Long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with ID " + id + " not found");
        }
        noteMap.remove(id);
    }

    public void update(Note note) {
        Long noteId = note.getId();
        if (!noteMap.containsKey(noteId)) {
            throw new IllegalArgumentException("Note with ID " + noteId + " not found");
        }
        noteMap.put(noteId, note);
    }

    public Note getById(Long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with ID " + id + " not found");
        }
        return noteMap.get(id);
    }

    private Long generateNextId(){
        return nextId++;
    }

}
