package com.reservation.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @NotNull
    private Integer id;

    @Column(name = "username")
    private String username;
}
