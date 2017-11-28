package com.dxfjyygy.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by longjinwen on 27/11/2017.
 */
@Entity
@Table(name = "t_role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
