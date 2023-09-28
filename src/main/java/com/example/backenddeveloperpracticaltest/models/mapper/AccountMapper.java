package com.example.backenddeveloperpracticaltest.models.mapper;

import com.example.backenddeveloperpracticaltest.models.dto.AccountDto;
import com.example.backenddeveloperpracticaltest.models.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toDto(AccountEntity accountEntity);
    @Mapping(target = "id",ignore = true)
    AccountEntity toEntity(AccountDto accountDto);

    List<AccountDto> toDtoList(List<AccountEntity> accountEntityList);

}
