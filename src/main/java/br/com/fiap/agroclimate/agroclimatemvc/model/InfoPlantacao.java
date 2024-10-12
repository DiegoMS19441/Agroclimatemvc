package br.com.fiap.agroclimate.agroclimatemvc.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
@Entity

@Table(name = "Plantacao")
public class InfoPlantacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id_plantacao")
    private Long id;

    @Column(name = "data_plantacao")
    private LocalDateTime dataPlantacao;

    @Column(name = "item_plantado")
    private String itemPlantado;

    @Column(name = "area_plantada")
    private Integer areaPlantada;

    @OneToOne(mappedBy = "infoPlantacao")
    private Fazenda fazenda;
}
