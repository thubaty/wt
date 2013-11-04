package sk.th;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@Entity
@Table(name="Word")
public class Word {

    @Id
    private String slovak;

    private String english;

    public Word() {
    }

    public Word(String english, String slovak) {
        Assert.notNull(english);
        Assert.notNull(slovak);
        this.slovak = slovak.trim();
        this.english = english.trim();
    }

    public String getSlovak() {
        return slovak;
    }

    public void setSlovak(String slovak) {
        this.slovak = slovak;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    private static final Random RANDOM = new Random();

    public String getStyle() {
        return "label-" +  CSSCLASS.values()[RANDOM.nextInt(CSSCLASS.values().length)];
    }

    enum CSSCLASS {
        primary, success, info, warning, danger;
    }
}

