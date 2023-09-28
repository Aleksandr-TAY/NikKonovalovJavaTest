package com.example.backenddeveloperpracticaltest.models.mapper;

import com.example.backenddeveloperpracticaltest.models.dto.AccountNubmerDto;
import com.example.backenddeveloperpracticaltest.models.entity.AccountNumberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountNumberMapper {
    AccountNubmerDto toDto(AccountNumberEntity accountNumberEntity);

    @Mapping(target = "id", ignore = true)
    AccountNumberEntity toEntity(AccountNubmerDto accountNubmerDto);
}
