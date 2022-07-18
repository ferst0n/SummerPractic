package com.company.summerpractic.screen.library

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.Library

@UiController("Library.browse")
@UiDescriptor("library-browse.xml")
@LookupComponent("librariesTable")
class LibraryBrowse : StandardLookup<Library>()