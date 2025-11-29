	package lp.Equipa11_comp2.Entity;
/**
 * @author diogo garcia
 */
import jakarta.persistence.*;
import java.time.*;
@Entity
@Table(name = "programa_estudante")
public class ProgramaEstudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgramaEstudante;

    @ManyToOne
    @JoinColumn(name = "id_estudante")
    private Estudante estudante; // 1 estudante → vários registos ao longo dos anos (OK)

    private LocalDate dataInicio;
    private LocalDate dataFim;

    private int horasFeitas;

    private boolean emitirDiploma;

    // -----------------------------
    //  CONSTRUTORES
    // -----------------------------

    public ProgramaEstudante() {}

    public ProgramaEstudante(Estudante estudante, LocalDate dataInicio) {
        this.estudante = estudante;
        this.dataInicio = dataInicio;
        this.horasFeitas = 0;
        this.emitirDiploma = false;
    }

    // -----------------------------
    //  GETTERS E SETTERS
    // -----------------------------

    public Long getIdProgramaEstudante() { return idProgramaEstudante; }

    public Estudante getEstudante() { return estudante; }
    public void setEstudante(Estudante estudante) { this.estudante = estudante; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public int getHorasFeitas() { return horasFeitas; }
    public void setHorasFeitas(int horasFeitas) { this.horasFeitas = horasFeitas; }

    public boolean isEmitirDiploma() { return emitirDiploma; }
    public void setEmitirDiploma(boolean emitirDiploma) { this.emitirDiploma = emitirDiploma; }

    // -----------------------------
    //  MÉTODOS PEDIDOS
    // -----------------------------

    /**
     * Adiciona horas ao programa do estudante.
     */
    public void adicionarHoras(int horas) {
        if (horas > 0) {
            this.horasFeitas += horas;

            // verifica se já pode emitir diploma
            if (this.horasFeitas >= 30) {
                this.emitirDiploma = true;
            }
        }
    }
    /**
     * Marca o programa como concluído.
     * A dataFim é colocada no dia atual.
     */
    public void concluirPrograma() {
        this.dataFim = LocalDate.now();

        // Atualiza o estado do diploma
        if (this.horasFeitas >= 30) {
            this.emitirDiploma = true;
        }
    }
    /**
     * Permite emitir diploma apenas se tiver >= 30 horas.
     */
    public boolean emitirDiploma() {
        return this.horasFeitas >= 30;
    }

    /**
     * Retorna o progresso do estudante (0 a 100%).
     * Considera 30 horas como objetivo mínimo.
     */
    public double getProgresso() {
        double progresso = (double) horasFeitas / 30.0 * 100.0;
        return Math.min(progresso, 100.0);
    }
    /**
     * Cancela a participação do estudante.
     * Remove dataFim e zera horas.
     */
    public void cancelarParticipacao() {
        this.dataFim = null;
        this.horasFeitas = 0;
        this.emitirDiploma = false;
    }
}
