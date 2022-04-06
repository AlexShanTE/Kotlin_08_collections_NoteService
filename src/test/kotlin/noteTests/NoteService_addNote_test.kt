package noteTests
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_addNote_test {
    @Test
    fun add() {
        val service = NoteService()
        val note = service.add(Note(title = "title", text = "text"))
        val expectedNoteId = 1
        assertEquals(expectedNoteId, note.id)
    }
}
