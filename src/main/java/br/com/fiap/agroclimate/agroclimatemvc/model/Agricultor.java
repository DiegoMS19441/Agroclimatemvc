package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "Agricultor")
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_AGRICULTOR")
    private Long id;

    @Column(name = "NM_AGRIGULTOR", nullable = false)
    private String nome;

    @Column(name = "EMAIL_AGRICULTOR", unique = true, nullable = false)
    private String email;

    @Column(name = "SENHA_AGRICULTOR", nullable = false)
    private String senha;

    @OneToMany(mappedBy = "agricultor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Fazenda> fazendas;

}
