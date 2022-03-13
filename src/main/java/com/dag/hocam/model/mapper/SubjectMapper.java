package com.dag.hocam.model.mapper;

import com.dag.hocam.model.dto.SubjectDto;
import com.dag.hocam.model.entity.Subject;
import com.dag.hocam.model.request.subject.CreateSubjectRequest;
import com.dag.hocam.model.request.subject.UpdateSubjectRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface SubjectMapper {

    SubjectMapper SUBJECT_MAPPER = Mappers.getMapper(SubjectMapper.class);

    SubjectDto convertToSubjectDto(Subject subject);

    List<SubjectDto> convertToSubjectDtoList(List<Subject> subjects);

    Subject createSubject(CreateSubjectRequest createSubjectRequest);

    void updateSubject(@MappingTarget Subject subject, UpdateSubjectRequest updateSubjectRequest);
}
