package com.company.summerpractic.screen.booksregistrationcard

import com.company.summerpractic.app.BookTakingService
import com.company.summerpractic.entity.BooksRegistrationCard
import io.jmix.ui.Dialogs
import io.jmix.ui.Notifications
import io.jmix.ui.action.DialogAction
import io.jmix.ui.screen.*
import org.springframework.beans.factory.annotation.Autowired


@UiController("BooksRegistrationCard.edit")
@UiDescriptor("books-registration-card-edit.xml")
@EditedEntityContainer("booksRegistrationCardDc")
class BooksRegistrationCardEdit : StandardEditor<BooksRegistrationCard>() {
    @Autowired
    private lateinit var dialogs: Dialogs

    @Autowired
    private lateinit var notifications: Notifications

    @Autowired
    private lateinit var bookTakingService: BookTakingService


    @Subscribe
    fun onBeforeCommitChanges(event: BeforeCommitChangesEvent) {
        var listOfRegistrationCard = bookTakingService.loadListOfBooksRegistrationCard()
        for(registrationCard in listOfRegistrationCard)
            for (registrationCardReader in registrationCard.readers)
                for (reader in editedEntity.readers)
                    if (reader.id == registrationCardReader.id && editedEntity.book!!.id == registrationCard.book!!.id && registrationCard.returnedDate == null) {
//                        notifications.create().withCaption("Читатель уже взял данную книгу!").show()
                        dialogs.createOptionDialog()
                                .withCaption("Confirmation")
                                .withMessage("Читатель уже взял данную книгу!")
                                .withActions(
                                        DialogAction(DialogAction.Type.OK).withHandler { e -> event.resume() },
                                        DialogAction(DialogAction.Type.CANCEL)
                                )
                                .show()
                        event.preventCommit()
                    }else if (reader.id == registrationCardReader.id && editedEntity.book!!.library!!.id == registrationCard.book!!.library!!.id  && editedEntity.gettingDate != registrationCard.gettingDate && registrationCard.returnedDate == null) {
//                        notifications.create().withCaption(mes.toString()).show()
                        dialogs.createOptionDialog()
                                .withCaption("Confirmation")
                                .withMessage("Читатель не вернул предыдущие книги в данной библиотеке!")
                                .withActions(
                                        DialogAction(DialogAction.Type.OK).withHandler { e -> event.resume() },
                                        DialogAction(DialogAction.Type.CANCEL)
                                )
                                .show()
                        event.preventCommit()
                    }
                    //                    else if (reader.id == registrationCardReader.id && editedEntity.book!!.title == registrationCard.book!!.title && editedEntity!!.book!!.library!!.id != registrationCard!!.book!!.library!!.id) {
////                        notifications.create().withCaption("Читатель уже взял данную книгу!").show()
//                        dialogs.createOptionDialog()
//                                .withCaption("Confirmation")
//                                .withMessage("Читатель не вернул данную книгу в другой библиотеке!")
//                                .withActions(
//                                        DialogAction(DialogAction.Type.OK).withHandler { e -> event.resume() },
//                                        DialogAction(DialogAction.Type.CANCEL)
//                                )
//                                .show()
//                        event.preventCommit()
//                    }
    }



}
