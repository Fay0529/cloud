package youth.blservice;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import youth.bean.JobListBean;
import youth.bean.SearchBean;
import youth.model.JobClassificationStandard;
import youth.model.WordFrequency;

import java.util.List;

/*
* @author:MAX
*/
public interface JobListBLService {


    public List<JobListBean> getSavedJobList(String phone);
    public List<JobListBean> getRecomandJobList(String phone);
    public youth.util.Page<JobListBean> searchJob(@RequestBody SearchBean searchBean);
    public youth.util.Page<JobListBean> search(String keyword, int page, int num);
    public List<WordFrequency> getHotSearchWord();
    public List<JobClassificationStandard> getHotJob();

}

