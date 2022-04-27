package noteTests

import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_editNote_test {
    @Test
    fun edit() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)

        val expected = Note(id = 1, title = "title", text = "newText")
        val actual = noteService.edit(note.copy(id = 1, text = "newText"))

        assertEquals(expected, actual)
    }
}