package com.example.jpadto.score.domain;

import com.example.jpadto.registry_type.domain.Registry_type;
import com.example.jpadto.student.domain.Student;
import com.example.jpadto.topic.domain.Topic;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "score")
@Getter
@Setter
public class score {
    @Id
    String id_score;
    @ManyToOne
    Student id_student;
    @ManyToOne
    Registry_type id_registry_type;
    @NotNull
    float note;
    @NotNull
    String branch;
    @ManyToOne
    Topic id_topic;// [ref: > topic.id_topic]
    String coment;
    @NotNull
    Date creationDate;
}
