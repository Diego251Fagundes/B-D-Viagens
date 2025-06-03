package bd.viagens.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "viagem")
public class Viagem {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String destino;

    @Column(name = "local_partida")
    private String localPartida;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_partida")
    private Date dataPartida;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_retorno")
    private Date dataRetorno;

    @Column(name = "preco")
    private BigDecimal preco;

    @OneToMany(mappedBy = "viagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    protected Viagem() {}

    public Viagem(String destino, String localPartida, Date dataPartida, Date dataRetorno, BigDecimal preco, List<Reserva> reservas) {
        this.destino = destino;
        this.localPartida = localPartida;
        this.dataPartida = new Date(dataPartida.getTime());
        this.dataRetorno = new Date(dataRetorno.getTime());
        this.preco = preco;
        this.reservas = List.copyOf(reservas);
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}