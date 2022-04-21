package com.emu.atm_service.model;

import javax.persistence.*;

@Entity
@Table
public class Bank {
    @Id
    @SequenceGenerator(
            name = "bank_id",
            sequenceName = "bank_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bank_id"
    )
    private Integer id;
    private String name;
    private String preferredAuthType;

    public Bank() {
    }

    public Bank(String name, String preferredAuthType) {
        this.name = name;
        this.preferredAuthType = preferredAuthType;
    }

    public Bank(Integer id, String name, String preferredAuthType) {
        this.id = id;
        this.name = name;
        this.preferredAuthType = preferredAuthType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredAuthType() {
        return preferredAuthType;
    }

    public void setPreferredAuthType(String preferredAuthType) {
        this.preferredAuthType = preferredAuthType;
    }
}
