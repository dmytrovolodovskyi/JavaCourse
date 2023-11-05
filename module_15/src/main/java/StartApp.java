import entites.Note;
import service.NoteService;

public class StartApp {
    public static void main(String[] args) {

        Note note1 = new Note();
        note1.setTitle("1Title");
        note1.setContent("1Content");

        NoteService noteService = new NoteService();
        noteService.add(note1);
        Long noteId = note1.getId();
        noteService.getById(noteId);
    }
}
