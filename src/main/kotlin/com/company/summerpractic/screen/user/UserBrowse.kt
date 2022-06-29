package com.company.summerpractic.screen.user

import com.company.summerpractic.entity.User
import io.jmix.ui.navigation.Route
import io.jmix.ui.screen.*

@UiController("User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
open class UserBrowse : StandardLookup<User>()