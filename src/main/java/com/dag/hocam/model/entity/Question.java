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
@Table(name = "questions")
@Entity
@SuperBuilder
@SQLDelete(sql="Update questions SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class Question extends  BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String question;

    private String correctAnswer;

    @Column(name = "quiz_id")
    private Integer quizId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id",insertable = false,updatable = false,nullable = false)
    private Quiz quiz;
}
