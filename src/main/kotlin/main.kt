fun main() {
    val noteService = NoteService()

    val note1 = Note(title = "Title1", text = "Text1")
    val note2 = Note(title = "Title1", text = "Text1")
    val note3 = Note(title = "Title1", text = "Text1")


    noteService.add(note1)
    noteService.add(note2)
    noteService.add(note3)
    println("First state" + noteService.get())

    noteService.edit(note1.copy(id = 1,text = "newText"))
    println("After Editing" + noteService.get())
    noteService.delete(note2.copy(id = 2))
    println("After Delete" + noteService.get())

    println(noteService.getById(3))

    val comment1 = Comment(noteId = 1, message = "Comment 1")
    val comment2 = Comment(noteId = 1, message = "Comment 2")


    noteService.addComment(comment1)
    noteService.addComment(comment2)
    noteService.editComment(comment1.copy(commentId = 1, message = "new comment message"))
    noteService.deleteComment(comment2.copy(commentId = 2))
    noteService.restoreComment(comment2.copy(commentId = 2))
    println(noteService.getComments(note1.copy(id = 1)))

    println(noteService.get())


}