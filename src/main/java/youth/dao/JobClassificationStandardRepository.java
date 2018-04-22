package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import youth.model.JobClassificationStandard;
import youth.model.WordFrequency;

import javax.transaction.Transactional;
import java.util.List;


public interface JobClassificationStandardRepository extends JpaRepository<JobClassificationStandard, String> {

   // WordFrequency findByWord(String word);

    @Transactional
    @Modifying
    @Query(value = "UPDATE job_classification_standard u set u.frequency =u.frequency+1 WHERE u.job_name =:ph", nativeQuery = true)
    int searchPlus(@Param("ph") String word);

    @Transactional
    @Modifying
    @Query(value = "select  * from job_classification_standard order by frequency DESC limit 0,10", nativeQuery = true)
    List<JobClassificationStandard> getTop10HotWord();



}
