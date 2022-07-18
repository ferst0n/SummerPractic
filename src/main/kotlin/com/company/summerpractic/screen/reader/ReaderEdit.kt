package com.company.summerpractic.screen.reader

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.Reader

@UiController("Reader.edit")
@UiDescriptor("reader-edit.xml")
@EditedEntityContainer("readerDc")
class ReaderEdit : StandardEditor<Reader>()