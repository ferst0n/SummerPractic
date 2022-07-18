package com.company.summerpractic.screen.library

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.Library

@UiController("Library.edit")
@UiDescriptor("library-edit.xml")
@EditedEntityContainer("libraryDc")
class LibraryEdit : StandardEditor<Library>()