package com.example.jpadto.topic.domain;

import com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator;
import com.example.jpadto.technology.domain.Technology;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "topic")
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TopicIdGen")
    @GenericGenerator(
            name = "TopicIdGen",
            strategy = "com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "TOP"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    String id_topic;
    @ManyToOne(fetch = FetchType.LAZY)
    Technology id_technology;
    @Column
    String name;
    @Column
    String description;
}
