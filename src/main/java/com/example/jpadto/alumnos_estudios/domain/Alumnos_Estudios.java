package com.example.jpadto.alumnos_estudios.domain;

import com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator;
import com.example.jpadto.topic.domain.Topic;
import com.example.jpadto.student.domain.Student;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estudiante_asignatura")
@Getter
@Setter
public class Alumnos_Estudios {//student_topic
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumnos_EstudiosIdGen")
    @GenericGenerator(
            name = "alumnos_EstudiosIdGen",
            strategy = "com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "ALE"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    String id_study;
    @ManyToOne(cascade = CascadeType.ALL)//funciona
    //@JoinColumn(name = "id_student")
    Student student;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Topic.class)//falta hacer relacion con asignatura o topic
    //@JoinColumn(name = "id_topic")
    Topic id_topic;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;
}