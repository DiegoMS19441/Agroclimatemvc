package br.com.fiap.agroclimate.agroclimatemvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Fazenda")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_fazenda")
    private Long id;

    @Column(name = "cnpj_fazenda", length = 14, nullable = false, unique = true)
    @NotBlank(message = "Esse campo precisa ser preenchido")
    @Digits(integer = 14, fraction = 0, message = "O CNPJ deve conter somente números")
    private String cnpj;

    @Column(name = "nm_fazenda", nullable = false, unique = true)
    @NotBlank(message = "Esse campo precisa de atenção")
    private String razaoSocial;

    @Column(name = "cep", nullable = false, length = 8)
    @Digits(integer = 8, fraction = 0, message = "O CEP deve conter somente números")
    private String cep;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "nr_endereco", nullable = false)
    private String numero;

    @Column(nullable = false, length = 30)
    @Email(message = "Esse campo precisa de atenção")
    private String email;

    @Column(name = "tel_fazenda", precision = 11)
    @NotBlank(message = "Telefone é um campo obrigatório")
    private String telefone;

    @Column(name = "tamanho_fazenda", precision = 9)
    @NotNull(message = "Tamanho é um campo obrigatório")
    private Integer tamanhoFazenda;

    @Column(name = "clima_fazenda")
    private Clima clima;


    @ManyToOne
    @JoinColumn(name = "id_agricultor")
    private Agricultor agricultor;

    @OneToMany(mappedBy = "fazenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Colheita> colheitas;

    @OneToOne
    @JoinColumn(name = "id_plantacao")
    private InfoPlantacao infoPlantacao;

    @OneToOne
    @JoinColumn(name = "id_solo")
    private Solo solo;

    @ManyToMany
    @JoinTable(
            name = "Fazenda_Safra",
            joinColumns = @JoinColumn(name = "id_fazenda"),
            inverseJoinColumns = @JoinColumn(name = "id_safra")
    )
    private List<Safra> safras;
}
