package com.example.backenddeveloperpracticaltest.models.mapper;


import com.example.backenddeveloperpracticaltest.models.dto.AuditDto;
import com.example.backenddeveloperpracticaltest.models.entity.AuditEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditMapper {

    AuditDto toDto(AuditEntity auditEntity);

    @Mapping(target = "id", ignore = true)
    AuditEntity toEntity(AuditDto auditDto);

    @Mapping(target = "id", ignore = true)
    AuditEntity mergeToEntity(AuditDto transferDto,
                              @MappingTarget AuditEntity transferEntity);

    List<AuditDto> toDtoList(List<AuditEntity> auditEntityList);

}
