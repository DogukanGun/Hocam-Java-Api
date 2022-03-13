package com.dag.hocam.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subjects")
@Entity
@SuperBuilder
@SQLDelete(sql="Update subjects SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class Subject extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String subjectName;

    private String subjectVideoUrl;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "subject")
    private List<ExampleQuestion> exampleQuestions;

}
