package com.devgang.ojakgyo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_code_group")
public class CodeGroup {
    @Id
    private String codeGroup;
    private String codeName;
    private String useYn;
    private LocalDateTime createdDate;
    private String createdId;
    private LocalDateTime updatedDate;
    private String updatedId;
}
