package com.dag.hocam.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "quizes")
@Entity
@SuperBuilder
@SQLDelete(sql="Update quizes SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class Quiz extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String quizName;

    @Column(name = "topic_id")
    private Integer topicId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id",insertable = false,nullable = false,updatable = false)
    private Topic topic;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quiz")
    private List<Question> questions;
}
