import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReponse;
    private String texteReponse;
    private boolean estCorrecte;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Condidats candidat;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_choice_id")
    private AnswerChoice choice;

    // getters and setters
    public Long getId() {
        return idReponse;
    }

    public void setId(Long id) {
        this.idReponse = id;
    }

    public Condidats getCandidat() {
        return candidat;
    }

    public void setCandidat(Condidats candidat) {
        this.candidat = candidat;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerChoice getChoice() {
        return choice;
    }

    public void setChoice(AnswerChoice choice) {
        this.choice = choice;
    }
}