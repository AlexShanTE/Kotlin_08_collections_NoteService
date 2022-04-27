package noteTests
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*


class NoteService_deleteNote_test {
    @Test
    fun deleteTrue() {

        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)

        val expectedResultOfDelete = true
        val actualResultOfDelete = noteService.delete(note.copy(id = 1))
        assertEquals(expectedResultOfDelete, actualResultOfDelete)
    }
    @Test
    fun deleteFalse() {
        val notes = mutableListOf<Note>()
        val noteService = NoteService(notes)

        val note = Note(title = "title", text = "text")
        noteService.create(note)

        val expectedResultOfDelete = false
        val actualResultOfDelete = noteService.delete(note.copy(id = 9999))
        assertEquals(expectedResultOfDelete, actualResultOfDelete)
    }

}