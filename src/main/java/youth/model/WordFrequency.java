package youth.model;

import javax.persistence.*;

@Entity
@Table(name = "word_frequency")
public class WordFrequency {

    @Column(name = "word")
    @Id
    private String word;


    @Column(name = "frequency")
    private Integer frequency;


    public WordFrequency(){

    }

    public WordFrequency(String word, Integer frequency) {

        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
