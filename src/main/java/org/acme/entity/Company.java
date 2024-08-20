package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_COMPANY")
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String registry;
    private String phone;
}
