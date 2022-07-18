package com.company.summerpractic.app

import com.company.summerpractic.entity.Book
import com.company.summerpractic.entity.BooksRegistrationCard
import io.jmix.core.DataManager
import io.jmix.core.FetchPlan
import io.jmix.core.FetchPlans
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookTakingService {

    @Autowired
    private lateinit var dataManager: DataManager

    @Autowired
    private lateinit var fetchPlans: FetchPlans

    fun loadListOfBooksRegistrationCard(): MutableList<BooksRegistrationCard> {
        var fetchPlan = fetchPlans.builder(BooksRegistrationCard::class.java)
                .addFetchPlan(FetchPlan.BASE)
                .add("book")
                .build()
        return dataManager.load(BooksRegistrationCard::class.java)
                .all()
                .fetchPlan(fetchPlan)
                .list()



    }

}