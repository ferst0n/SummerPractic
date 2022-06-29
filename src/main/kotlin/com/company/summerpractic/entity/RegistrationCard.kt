package com.company.summerpractic.entity

import io.jmix.core.DeletePolicy
import io.jmix.core.annotation.DeletedBy
import io.jmix.core.annotation.DeletedDate
import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.entity.annotation.OnDelete
import io.jmix.core.metamodel.annotation.Composition
import io.jmix.core.metamodel.annotation.JmixEntity
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@JmixEntity
@Table(name = "REGISTRATION_CARD")
@Entity
open class RegistrationCard {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @Column(name = "PICKED_UP_DATE", nullable = false)
    @NotNull
    var pickedUpDate: LocalDateTime? = null

    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "READER_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    var reader: Reader? = null

    @OneToMany(mappedBy = "registrationCard")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    var employee: MutableList<Employee> = mutableListOf()

    @OneToMany(mappedBy = "registrationCard")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    var books: MutableList<Book> = mutableListOf()

    @Column(name = "RETURN_DATE", nullable = false)
    @NotNull
    var returnDate: LocalDateTime? = null

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