package com.company.summerpractic.screen.reader

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.Reader

@UiController("Reader.browse")
@UiDescriptor("reader-browse.xml")
@LookupComponent("readersTable")
class ReaderBrowse : StandardLookup<Reader>()