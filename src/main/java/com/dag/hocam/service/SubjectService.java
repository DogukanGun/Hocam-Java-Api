package com.dag.hocam.service;

import com.dag.hocam.model.dto.ExampleQuestionDto;
import com.dag.hocam.model.dto.SubjectDto;
import com.dag.hocam.model.entity.ExampleQuestion;
import com.dag.hocam.model.entity.Subject;
import com.dag.hocam.model.request.subject.CreateSubjectRequest;
import com.dag.hocam.repository.ExampleQuestionRepository;
import com.dag.hocam.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.dag.hocam.model.mapper.ExampleQuestionMapper.EXAMPLE_QUESTION_MAPPER;
import static com.dag.hocam.model.mapper.SubjectMapper.SUBJECT_MAPPER;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final ExampleQuestionRepository exampleQuestionRepository;
    private final SubjectRepository subjectRepository;

    public SubjectDto createSubject(CreateSubjectRequest createSubjectRequest){
        Subject subject = Subject.builder()
                .subjectName(createSubjectRequest.getSubjectName())
                .subjectVideoUrl(createSubjectRequest.getSubjectVideoUrl()).build();
        Subject returnedSubject = subjectRepository.save(subject);
        for(int i=0;i<3;i++){
            ExampleQuestion exampleQuestion = EXAMPLE_QUESTION_MAPPER
                    .createExampleQuestion(createSubjectRequest.getExampleQuestionRequests().get(i));
            exampleQuestionRepository.save(exampleQuestion);
        }
        return SUBJECT_MAPPER.convertToSubjectDto(returnedSubject);
    }

    public SubjectDto getSubjectByName(String subjectName){
        Subject subject = subjectRepository.findBySubjectName(subjectName)
                .orElseThrow(()->new NotFoundException("Subject not found"));
        return SUBJECT_MAPPER.convertToSubjectDto(subject);
    }

    public List<ExampleQuestionDto> getExampleQuestionsBySubjectName(String subjectName){
        Subject subject = subjectRepository.findBySubjectName(subjectName)
                .orElseThrow(()->new NotFoundException("Subject not found"));
        return EXAMPLE_QUESTION_MAPPER.convertToExampleQuestionDtoList(subject.getExampleQuestions());
    }

}