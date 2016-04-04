package com.kma.ais_dekanat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by denysburlakov on 07.02.16.
 */

@Entity
public class Department {

    private Integer departmentId;
    private String name;
    private String mainInfo;
    private Set<UniversityGroup> groups;
    private Set<Cathedra> cathedras;

    @JsonView(Department.Views.Public.class)
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer id) {
        this.departmentId = id;
    }

    @JsonView(Department.Views.Public.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(Department.Views.Public.class)
    @Column(name = "main_info", columnDefinition = "TEXT")
    public String getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;
    }

    @JsonView(Department.Views.Internal.class)
    @OneToMany(mappedBy = "department",fetch = FetchType.EAGER)
    public Set<UniversityGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<UniversityGroup> groups) {
        this.groups = groups;
    }

    @JsonView(Cathedra.Views.Internal.class)
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    public Set<Cathedra> getCathedras() {
        return cathedras;
    }

    public void setCathedras(Set<Cathedra> cathedras) {
        this.cathedras = cathedras;
    }

    public static final class Views {
        // show only public data
        public interface Public {}

        // show public and internal data
        public interface Internal extends Public {}
    }
}
