package com.shs.entity.reference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("ITEM_STATUS"))
@Data
@NoArgsConstructor
public class ItemStatus {

    @Id
    @Column(name = "ID")
    private int itemStatusId;

    private String status;
}
