package com.company.summerpractic.screen.book

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.Book

@UiController("Book.browse")
@UiDescriptor("book-browse.xml")
@LookupComponent("booksTable")
class BookBrowse : StandardLookup<Book>()