package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Care extends BaseEntity{
    @NotNull
    @Column(unique=true)
    @Size(min=3,max=40)
    String name;

    @Min(1)
    @Max(120)
    int careDuration;

    @NotEmpty
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "care_type")
    Set<PetType> compatiblePetTypes;
}
