package com.dag.hocam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "example_question")
@Entity
@SuperBuilder
@SQLDelete(sql="Update example_question SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class ExampleQuestion extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String question;

    private String correctAnswer;

    private String solution;

    @Column(name = "subject_id")
    private Integer subjectId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id",insertable = false,updatable = false,nullable = false)
    private Subject subject;

}
