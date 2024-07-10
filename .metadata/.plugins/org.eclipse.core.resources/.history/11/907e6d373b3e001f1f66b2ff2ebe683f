import javax.persistence.*;
import java.util.List;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private Administrateur administrator;

    @OneToMany(mappedBy = "test")
    private List<Question> questions;

    @ManyToMany
    @JoinTable(
        name = "candidate_test",
        joinColumns = @JoinColumn(name = "test_id"),
        inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private List<Condidats> candidates;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Administrateur getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrateur administrator) {
        this.administrator = administrator;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Candidat> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidat> candidates) {
        this.candidates = candidates;
    }
}
