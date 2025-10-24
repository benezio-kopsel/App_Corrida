package appcorrida.app_corrida.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Aplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String versao;

    @OneToMany(mappedBy = "aplicativo")
    private List<Motorista> lista_m; // Motoristas do aplicativo

    @OneToMany(mappedBy = "aplicativo")
    private List<Corrida> lista_c; // Corridas do aplicativo

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public List<Motorista> getLista_m() {
        return lista_m;
    }

    public void setLista_m(List<Motorista> lista_m) {
        this.lista_m = lista_m;
    }

    public List<Corrida> getLista_c() {
        return lista_c;
    }

    public void setLista_c(List<Corrida> lista_c) {
        this.lista_c = lista_c;
    }
}
