fun main() {

    val notes = mutableListOf<Note>()

    val noteService = NoteService(notes)
    val commentService = CommentService(notes)

    val note1 = Note(title = "Title1", text = "Text1")
    val note2 = Note(title = "Title1", text = "Text1")
    val note3 = Note(title = "Title1", text = "Text1")

    noteService.create(note1)
    noteService.create(note2)
    noteService.create(note3)

    println("First state" + noteService.getNotes())

    noteService.edit(note1.copy(id = 1, text = "newText"))
    println("After Editing" + noteService.getNotes())
    noteService.delete(note2.copy(id = 2))
    println("After Delete" + noteService.getNotes())

    println(noteService.getById(3))

    val comment1 = Comment(noteId = 1, message = "Comment 1")
    val comment2 = Comment(noteId = 1, message = "Comment 2")


    commentService.create(comment1)
    commentService.create(comment2)
    commentService.edit(comment1.copy(commentId = 1, message = "new comment message"))
    commentService.delete(comment2.copy(commentId = 2))
    commentService.restore(comment2.copy(commentId = 2))
    println(commentService.getComments(note1.copy(id = 1)))
    println("*********")
    println(notes)
}