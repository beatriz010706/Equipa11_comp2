package lp.Equipa11_comp2.Entity;
/**
 * @author diogo garcia
 */
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "programa_estudante")
public class ProgramaEstudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int horasFeitas;
    private boolean emitirDiploma;

    @ManyToOne
    @JoinColumn(name = "id_estudante")
    private Estudante estudante;

    public ProgramaEstudante() {
        this.horasFeitas = 0;
        this.emitirDiploma = false;
    }

    public ProgramaEstudante(LocalDate dataInicio, LocalDate dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horasFeitas = 0;
        this.emitirDiploma = false;
    }

    // -----------------------------
    // Getters e Setters
    // -----------------------------
    public Long getId() { return id; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public int getHorasFeitas() { return horasFeitas; }
    public void setHorasFeitas(int horasFeitas) { this.horasFeitas = horasFeitas; }

    public boolean isEmitirDiploma() { return emitirDiploma; }
    public void setEmitirDiploma(boolean emitirDiploma) { this.emitirDiploma = emitirDiploma; }

    public Estudante getEstudante() { return estudante; }
    public void setEstudante(Estudante estudante) { this.estudante = estudante; }

    // -----------------------------
    // Métodos de negócio simples
    // -----------------------------

    public void adicionarHoras(int horas) {
        this.horasFeitas += horas;
    }

    public void concluirPrograma() {
        // marca como concluído apenas se tiver horas >= 30
        if (this.horasFeitas >= 30) {
            emitirDiploma = true;
        }
    }

    public boolean emitirDiploma() {
        return this.horasFeitas >= 30;
    }

    public double getProgresso() {
        return (this.horasFeitas / 30.0) * 100; // progresso em %
    }

    public void cancelarParticipacao() {
        this.horasFeitas = 0;
        this.emitirDiploma = false;
    }
}

