package com.example.jpadto.technology.domain;

import com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "technology")
@Getter
@Setter
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technologyIdGen")
    @GenericGenerator(
            name = "technologyIdGen",
            strategy = "com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "TEC"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    String id_technology;
    /*@OneToMany(mappedBy = "id_technology",targetEntity = topic.class)
    List<topic> topics;*/
    @Column
    String branch;
    @Column
    String name;
    @Column
    String description;
}
