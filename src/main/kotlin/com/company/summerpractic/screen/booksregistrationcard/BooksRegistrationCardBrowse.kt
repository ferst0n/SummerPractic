package com.company.summerpractic.screen.booksregistrationcard

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.BooksRegistrationCard

@UiController("BooksRegistrationCard.browse")
@UiDescriptor("books-registration-card-browse.xml")
@LookupComponent("booksRegistrationCardsTable")
class BooksRegistrationCardBrowse : StandardLookup<BooksRegistrationCard>()