package com.example.jpadto.registry_type.domain;

import com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registry_type")
@Getter
@Setter
public class Registry_type {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Registry_typeIdGen")
    @GenericGenerator(
            name = "Registry_typeIdGen",
            strategy = "com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "RET"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    String id_registry_type;// [pk, increment],
    @Column
    String name;
    @Column
    Date last_update;
    @Column
    boolean activo;

}
