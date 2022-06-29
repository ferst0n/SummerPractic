package com.company.summerpractic.entity

import io.jmix.core.annotation.DeletedBy
import io.jmix.core.annotation.DeletedDate
import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@JmixEntity
@Table(name = "BOOK", indexes = [
    Index(name = "IDX_BOOK_LIBRARY_ID", columnList = "LIBRARY_ID"),
    Index(name = "IDX_BOOK_REGISTRATION_CARD_ID", columnList = "REGISTRATION_CARD_ID")
])
@Entity
open class Book {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @Column(name = "AUTHOR", nullable = false)
    @NotNull
    var author: String? = null

    @InstanceName
    @Column(name = "TITLE", nullable = false)
    @NotNull
    var title: String? = null

    @JoinColumn(name = "LIBRARY_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    var library: Library? = null

    @Column(name = "AMOUNT_IN_LIBRARY", nullable = false)
    @NotNull
    var amountInLibrary: Int? = null

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

    @JoinColumn(name = "REGISTRATION_CARD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    var registrationCard: RegistrationCard? = null
}