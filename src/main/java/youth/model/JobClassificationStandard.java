package youth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_classification_standard")
public class JobClassificationStandard {

    @Column(name = "classification")
    @Id
    private Integer classification;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "frequency")
    private Integer frequency;


    public JobClassificationStandard(){

    }

    public JobClassificationStandard(Integer classification, String jobName, Integer frequency) {
        this.classification = classification;
        this.jobName = jobName;
        this.frequency = frequency;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
