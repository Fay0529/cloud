package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import youth.model.User;
import youth.model.WordFrequency;

import javax.transaction.Transactional;
import java.util.List;


public interface WordFrequencyRepository extends JpaRepository<WordFrequency, String> {

    WordFrequency findByWord(String word);

    @Transactional
    @Modifying
    @Query(value = "UPDATE word_frequency u set u.frequency =u.frequency+1 WHERE u.word =:ph", nativeQuery = true)
    int searchPlus(@Param("ph") String word);

    @Transactional
    @Modifying
    @Query(value = "select  * from word_frequency order by frequency DESC limit 0,10", nativeQuery = true)
    List<WordFrequency> getTop10HotWord();



}
