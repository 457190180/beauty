package com.yimew.controller.api;

import com.yimew.config.base.controller.BaseController;
import com.yimew.entity.demo.Demo;
import com.yimew.util.ErrorUtils;
import com.yimew.util.http.ResponseMessage;
import com.yimew.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/app/demo")
@Api(description = "demoController")
public class DemoController extends BaseController<Demo> {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);


    @RequestMapping(value = "", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "demo新增")
    public @ResponseBody
    ResponseMessage add(@RequestBody @Validated Demo demo, Errors errors, HttpServletRequest request) throws Exception  {
        if (errors.hasErrors()) {
            return Result.error(ErrorUtils.getErrorInfo(errors));
        }
        return Result.success( demoService.insertSelective(demo, getUser()));
    }



}
