package com.realpacific.vehiclemanagement.beans

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Beans {
    /**
     * Prevents serializing lazy fields
     */
    @Bean
    fun providesObjectMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.registerModule(Hibernate5Module())
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        return mapper
    }
}