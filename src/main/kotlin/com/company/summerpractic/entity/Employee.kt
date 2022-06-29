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
@Table(name = "EMPLOYEE", indexes = [
    Index(name = "IDX_EMPLOYEE_LIBRARY_ID", columnList = "LIBRARY_ID"),
    Index(name = "IDX_EMPLOYEE", columnList = "REGISTRATION_CARD_ID")
])
@Entity
open class Employee {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @InstanceName
    @Column(name = "FULL_NAME", nullable = false)
    @NotNull
    var fullName: String? = null

    @Column(name = "VERSION", nullable = false)
    @Version
    var version: Int? = null

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    var lastModifiedBy: String? = null

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    var lastModifiedDate: Date? = null

    @CreatedBy
    @Column(name = "CREATED_BY")
    var createdBy: String? = null

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    var createdDate: Date? = null

    @DeletedBy
    @Column(name = "DELETED_BY")
    var deletedBy: String? = null

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    var deletedDate: Date? = null

    @JoinColumn(name = "LIBRARY_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    var library: Library? = null

    @JoinColumn(name = "REGISTRATION_CARD_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    var registrationCard: RegistrationCard? = null
}