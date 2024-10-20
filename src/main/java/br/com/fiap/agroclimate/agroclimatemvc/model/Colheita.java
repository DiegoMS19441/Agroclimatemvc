package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "COLHEITA")
public class Colheita {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "ID_COLHEITA")
    private Long id;

    @Column(name = "DATA_COLHEITA", nullable = false)
    private LocalDateTime dataColheita;

    @Column(name = "QNT_COLHEITA")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name ="ID_FAZENDA")
    private Fazenda fazenda;

}
