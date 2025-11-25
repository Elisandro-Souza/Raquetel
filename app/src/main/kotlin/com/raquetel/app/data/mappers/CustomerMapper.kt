package com.raquetel.app.data.mappers

import com.raquetel.app.data.local.entities.CustomerEntity
import com.raquetel.app.domain.entities.Customer
import com.raquetel.app.domain.entities.SkillLevel

fun CustomerEntity.toDomain(): Customer {
    return Customer(
        id = id,
        name = name,
        cpf = cpf,
        email = email,
        phone = phone,
        birthDate = birthDate,
        address = address,
        skillLevel = SkillLevel.valueOf(skillLevel)
    )
}

fun Customer.toEntity(): CustomerEntity {
    return CustomerEntity(
        id = id,
        name = name,
        cpf = cpf,
        email = email,
        phone = phone,
        birthDate = birthDate,
        address = address,
        skillLevel = skillLevel.name,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    )
}
