package com.task.cubicfox.entity;

import com.sun.istack.NotNull;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 6)
    private Byte code;
    @NotNull
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @NotNull
    private Double price;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> userList;

}
