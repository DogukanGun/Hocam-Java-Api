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
@Table(name = "completed_quizes")
@Entity
@SuperBuilder
@SQLDelete(sql="Update completed_quizes SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class CompletedQuiz extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer quizId;

    private Double point;
}
