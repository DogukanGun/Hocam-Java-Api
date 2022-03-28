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
@Table(name = "completed_questions")
@Entity
@SuperBuilder
@SQLDelete(sql="Update completed_questions SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class CompletedQuestion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer quizId;

    private Integer questionId;
}
