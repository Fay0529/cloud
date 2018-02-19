package youth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import youth.bean.*;
import youth.blservice.UserBLService;
import youth.model.User;

import java.util.List;
import java.util.Map;

//访问：localhost:8080/user/hello，路径中不用加cloud
@Api(value = "用户模块", description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserBLService userBLService;
    @Autowired
    public UserController(UserBLService userBLService){
        this.userBLService=userBLService;
    }

    /*
    登录
     */

    @ApiOperation(value = "账号密码登录", notes = "可能状态码：0,1,9<br>登录成功返回签名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),

    })
    @PostMapping("/login")
    public ResultMessageBean login(String phone, String password) {
        //return "hhh";
        return userBLService.login(phone,password);


    }


    /*
    注册
     */

    @ApiOperation(value = "注册", notes = "可能状态码：0,1,9<br>登录成功返回签名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "mail", value = "邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),

    })
    @PostMapping("/sign-up")
    public ResultMessageBean signUp(String phone, String password,String mail,String name) {


        return userBLService.signUp(phone,password,mail,name);


    }

    /*
    修改密码
     */

    @ApiOperation(value = "修改密码", notes = "可能状态码：0,1,9<br>登录成功返回签名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),

    })
    @PostMapping("/password")
    public ResultMessageBean editPassword(String phone, String password) {
       return userBLService.editPassword(phone,password);


    }




    /*
    填写用户基本信息
     */

    @ResponseBody
    @RequestMapping(
            value = "/userBasicMessage",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessageBean saveUserBasicMessage(@RequestBody UserBasicMessageBean userBasicMessageBean) {
        return null;
    }

     /*
    得到用户基本信息
     */

    @ApiOperation(value = "得到用户基本信息", notes = "可能状态码：45,44,34,35")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "MultipartFile")
    })
    @PostMapping("/getUserBasicMessage")
    public UserBasicMessageBean getUserBasicMessage(String phone) {
        return null;
    }

    /*
    填写教育信息
     */

    @ResponseBody
    @RequestMapping(
            value = "/education",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessageBean saveEducation(@RequestBody EducationBean educationBean) {
        return null;
    }

     /*
    得到教育信息
     */

    @ApiOperation(value = "得到教育信息", notes = "可能状态码：45,44,34,35")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "MultipartFile")
    })
    @PostMapping("/getEducation")
    public EducationBean getEducation(String phone) {
        return null;
    }


/*
  填写项目经历信息
     */

    @ResponseBody
    @RequestMapping(
            value = "/projectExperience",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessageBean saveProjectExperience(@RequestBody List<ProjectExperienceBean> projectExperienceBeans) {
        return null;
    }

     /*
    得到项目经历信息
     */

    @ApiOperation(value = "得到职业经历信息", notes = "可能状态码：45,44,34,35")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "MultipartFile")
    })
    @PostMapping("/getProjectExperience")
    public List<JobExperienceBean> getProjectExperience(String phone) {
        return null;
    }








   /*
    填写职业经历信息
     */

    @ResponseBody
    @RequestMapping(
            value = "/jobExperience",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessageBean saveJobExperience(@RequestBody List<JobExperienceBean> jobExperienceBeans) {
        return null;
    }

     /*
    得到职业经历信息
     */

    @ApiOperation(value = "得到职业经历信息", notes = "可能状态码：45,44,34,35")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "MultipartFile")
    })
    @PostMapping("/getJobExperience")
    public List<JobExperienceBean> getJobExperience(String phone) {
        return null;
    }



    /*
  填写用户技能
     */

    @ResponseBody
    @RequestMapping(
            value = "/skill",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessageBean saveSkill(@RequestBody List<SkillBean> skillBeans) {
        return null;
    }

     /*
    得到用户技能
     */

    @ApiOperation(value = "得到用户技能", notes = "可能状态码：45,44,34,35")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "MultipartFile")
    })
    @PostMapping("/getSkill")
    public List<SkillBean> getSkill(String phone) {
        return null;
    }


     /*
  填写用户职业预期
     */

    @ResponseBody
    @RequestMapping(
            value = "/expectation",
            method = RequestMethod.POST,
            produces = {"application/json; charset=UTF-8"})
    public ResultMessageBean saveExpectation(@RequestBody List<ExpectationBean> expectationBeans) {
        return null;
    }

     /*
    得到用户职业预期
     */

    @ApiOperation(value = "得到用户职业预期", notes = "可能状态码：45,44,34,35")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "MultipartFile")
    })
    @PostMapping("/getExpectation")
    public List<ExpectationBean> getExpectation(String phone) {
        return null;
    }



    @RequestMapping("/hello")
    public String say() {

        return "Helloxixiix";
    }











}
