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
@Table(name = "topics")
@Entity
@SuperBuilder
@SQLDelete(sql="Update topics SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class Topic extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String topicName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="topic")
    private List<Quiz> quizzes;
}
