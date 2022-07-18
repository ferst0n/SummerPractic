package com.company.summerpractic.entity

import io.jmix.core.annotation.DeletedBy
import io.jmix.core.annotation.DeletedDate
import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import io.jmix.data.impl.lazyloading.NotInstantiatedList
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@JmixEntity
@Table(name = "BOOKS_REGISTRATION_CARD", indexes = [
    Index(name = "IDX_BOOKSREGISTRATIONCARD", columnList = "BOOK_ID")
])
@Entity
open class BooksRegistrationCard {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @InstanceName
    @JoinColumn(name = "BOOK_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    var book: Book? = null

    @JoinTable(name = "BOOKS_REGISTRATION_CARD_READER_LINK",
            joinColumns = [JoinColumn(name = "BOOKS_REGISTRATION_CARD_ID")],
            inverseJoinColumns = [JoinColumn(name = "READER_ID")])
    @ManyToMany
    var readers: MutableList<Reader> = NotInstantiatedList()

    @JoinTable(name = "BOOKS_REGISTRATION_CARD_EMPLOYEE_LINK",
            joinColumns = [JoinColumn(name = "BOOKS_REGISTRATION_CARD_ID")],
            inverseJoinColumns = [JoinColumn(name = "EMPLOYEE_ID")])
    @ManyToMany
    var employees: MutableList<Employee> = NotInstantiatedList()

    @Column(name = "GETTING_DATE")
    var gettingDate: LocalDate? = null

    @Column(name = "RETURNED_DATE")
    var returnedDate: LocalDate? = null

    @Column(name = "VERSION", nullable = false)
    @Version
    var version: Int? = null

    @CreatedBy
    @Column(name = "CREATED_BY")
    var createdBy: String? = null

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    var createdDate: Date? = null

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    var lastModifiedBy: String? = null

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    var lastModifiedDate: Date? = null

    @DeletedBy
    @Column(name = "DELETED_BY")
    var deletedBy: String? = null

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    var deletedDate: Date? = null

}