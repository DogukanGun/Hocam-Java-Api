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
@Table(name = "questions_from_user")
@Entity
@SuperBuilder
@SQLDelete(sql="Update questions_from_user SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class QuestionFromUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 1350000)
    private String question;

    private String responseMail;

    private boolean solved;

    private String solvedBy;
}
