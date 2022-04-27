package noteTests

import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*

class NoteService_getNote_test {
    @Test
    fun get() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)

        val note1 = Note(title = "title", text = "text")
        val note2 = Note(title = "title", text = "text")
        noteService.create(note1)
        noteService.create(note2)

        val expected = listOf(note1.copy(id = 1), note2.copy(id = 2))
        val actual = noteService.getNotes()

        assertEquals(expected, actual)
    }
    @Test
    fun getById() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)

        val note1 = Note(title = "title", text = "text")
        val note2 = Note(title = "title", text = "text")
        noteService.create(note1)
        noteService.create(note2)

        val expected = note2.copy(id = 2)
        val actual = noteService.getById(2)

        assertEquals(expected, actual)
    }
}