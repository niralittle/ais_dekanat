package com.kma.ais_dekanat.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by denysburlakov on 06.02.16.
 */

@Entity
public class TestUser {
    @Id
    private int id;
    private String name;
}
