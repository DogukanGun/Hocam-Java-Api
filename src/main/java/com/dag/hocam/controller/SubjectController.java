package com.dag.hocam.controller;

import com.dag.hocam.model.dto.ExampleQuestionDto;
import com.dag.hocam.model.dto.SubjectDto;
import com.dag.hocam.model.request.subject.CreateSubjectRequest;
import com.dag.hocam.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("subjectbyname/{subjectName}")
    public SubjectDto getSubjectByName(@PathVariable String subjectName) {
        return subjectService.getSubjectByName(subjectName);
    }

    @PostMapping("question/{subjectName}")
    public List<ExampleQuestionDto> getExampleQuestionsBySubjectName(@PathVariable String subjectName) {
        return subjectService.getExampleQuestionsBySubjectName(subjectName);
    }

    @PostMapping("subject/all")
    public List<SubjectDto> getSubjects() {
        return subjectService.getAllSubjects();
    }

}
