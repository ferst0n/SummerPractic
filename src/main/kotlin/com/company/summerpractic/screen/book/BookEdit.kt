package com.company.summerpractic.screen.book

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.Book

@UiController("Book.edit")
@UiDescriptor("book-edit.xml")
@EditedEntityContainer("bookDc")
class BookEdit : StandardEditor<Book>()