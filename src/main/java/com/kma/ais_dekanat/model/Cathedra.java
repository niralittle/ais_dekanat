package com.kma.ais_dekanat.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by denysburlakov on 07.02.16.
 */
@Entity
public class Cathedra {
    private Integer cathedraId;
    private String name;
    private Department department;
    private Set<Professor> professors;

    @JsonView(Cathedra.Views.Public.class)
    @Id
    @GeneratedValue
    @Column(name = "cathedra_id")
    public Integer getCathedraId() {
        return cathedraId;
    }

    public void setCathedraId(Integer cathedraId) {
        this.cathedraId = cathedraId;
    }

    @JsonView(Cathedra.Views.Public.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(Cathedra.Views.Internal.class)
    @ManyToOne
    @JoinColumn
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "cathedra")
    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }
    public static final class Views {
        // show only public data
        public interface Public {}

        // show public and internal data
        public interface Internal extends Public {}
    }
}
