package com.client.api.ws.rasmooplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter @Setter @ToString
// ou
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    private Long id;
    private String name;
    private String description;
}
