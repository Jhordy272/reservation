package com.reservation.security.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol")
public class RolEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "name")
    private String name;
}
