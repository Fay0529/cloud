package youth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import youth.bean.JobListBean;
import youth.bean.ResultMessageBean;
import youth.bean.SearchBean;
import youth.blservice.JobBLService;
import youth.blservice.JobListBLService;
import youth.model.JobClassificationStandard;
import youth.model.WordFrequency;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/*
* @author:MAX
*/
@Api(value = "职业列表模块", description = "职业列表相关接口")
@RestController
@RequestMapping("/joblist")
public class JobListController {

    @Autowired
    private JobListBLService jobListBLService;
    @Autowired
    public JobListController(JobListBLService jobListBLService){
        this.jobListBLService=jobListBLService;
    }

      /*
    得到收藏职业列表
     */

    @ApiOperation(value = "得到收藏职业列表", notes = "可能状态码：0,1,9<br>登录成功返回签名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String"),

    })
    @PostMapping("/save/get")
    public List<JobListBean> getSavedJobList(String phone) {
        //return "hhh";
        return jobListBLService.getSavedJobList(phone);

    }

       /*
    得到推荐职业列表
    未实现
     */

    @ApiOperation(value = "得到推荐职业列表", notes = "可能状态码：0,1,9<br>登录成功返回签名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String"),

    })
    @PostMapping("/recomand/get")
    public List<JobListBean> getRecomandJobList(String phone) {
        //return "hhh";
        return jobListBLService.getRecomandJobList(phone);
    }

//       /*
//    搜索职业
//
//     */
//
    @ApiOperation(value = "搜索职业", notes = "可能状态码：0,1,9<br>登录成功返回签名")

    @PostMapping("/job/search")
    public util.Page<JobListBean> searchJob(@RequestBody SearchBean searchBean) {
        //return "hhh";
        return jobListBLService.searchJob(searchBean);
}









     /*
    模糊搜索
     */

    @ApiOperation(value = "模糊搜索", notes = "可能状态码：0,1,9<br>登录成功返回签名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "关键词", required = true, dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int"),
            @ApiImplicitParam(name = "num", value = "条数", required = true, dataType = "String"),

    })
    @PostMapping("/fuzzySearch")
    public util.Page<JobListBean> search(String keyword, int page, int num) {
        //return "hhh";
        return jobListBLService.search(keyword, page, num);
    }


        /*
    得到热门搜索词汇（前10最热）
     */

    @ApiOperation(value = "得到热门搜索词汇", notes = "可能状态码：0,1,9<br>登录成功返回签名")
    @GetMapping("/getTop10HotWord")
    public List<WordFrequency> getHotSearchWord() {

        return jobListBLService.getHotSearchWord();

    }

        /*
    得到热门搜索职业（前10最热）
     */

    @ApiOperation(value = "得到热门搜索职业", notes = "可能状态码：0,1,9<br>登录成功返回签名")
    @GetMapping("/getTop10HotJob")
    public List<JobClassificationStandard> getHotJob() {

        return jobListBLService.getHotJob();

    }





}

