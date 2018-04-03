package com.yimew.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yimew.config.base.controller.BaseController;
import com.yimew.config.base.page.BasePage;
import com.yimew.config.web.Const;
import com.yimew.config.web.ReturnData;
import com.yimew.entity.sys.User;
import com.yimew.entity.wechatBase.TplMsg;
import com.yimew.entity.wechatBase.WechatParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * * @author 作者 E-mail: * @date 创建时间：2017年11月2日 上午9:59:52 * @version 1.0
 * * @parameter * @since * @return
 */
@Controller
@RequestMapping(value = "/app/wechat")
public class WechatController extends BaseController {
    @Autowired
    private JedisPool jedisPool;

    @RequestMapping(value = "/fastLogin", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "微信快速登录", httpMethod = "POST", response = ReturnData.class, notes = "微信快速登录")
    public @ResponseBody
    ReturnData fastLogin(@RequestBody @Validated WechatParam wechatParam, Errors errors, HttpServletRequest request) {
        return null;
    }

    @RequestMapping(value = "/sendTplMsgs", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "发送模版消息(群推)", httpMethod = "POST", response = ReturnData.class, notes = "发送模版消息(群推)")
    public @ResponseBody
    ReturnData sendTplMsgs(@RequestBody @Validated List<TplMsg> tplMsgs, Errors errors, HttpServletRequest request) {

        return new ReturnData(null, Const.CODE.SUCCESS, errors.toString());
    }
    @RequestMapping(value = "/test", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    @ApiOperation(value = "test", httpMethod = "GET", response = ReturnData.class, notes = "测试")
    public @ResponseBody
    ReturnData TEST( HttpServletRequest request)throws Exception {
        List<User> list = userService.getList(new BasePage());
        return new ReturnData(list, Const.CODE.SUCCESS,"test" );
    }

    @RequestMapping(value = "/sendTplMsg", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "发送模版消息(单推)", httpMethod = "POST", response = ReturnData.class, notes = "发送模版消息(单推)")
    public @ResponseBody
    ReturnData sendTplMsg(@RequestBody @Validated TplMsg tplMsg, Errors errors, HttpServletRequest request) {
            return new ReturnData(null, Const.CODE.FAIL);

    }

    @RequestMapping(value = "/refreshAccessToken", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "重新生成ACCESS_TOKEN", httpMethod = "POST", response = ReturnData.class, notes = "重新生成ACCESS_TOKEN")
    public @ResponseBody
    ReturnData refreshAccessToken(HttpServletRequest request) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.auth("6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9");
            String accessToken = jedis.get(Const.JEDIS_KEY.ACCESS_TOKEN.getKey());
            if (accessToken == null) {
                accessToken =  setAccessToken();
            }
            System.out.println(accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                //关闭连接
                jedis.close();
            }
        }
        return new ReturnData(null, Const.CODE.SUCCESS, "成功");
    }

    /**
     * 获取accesstoken
     *
     * @return
     */
    private String getAccessToken() {
        Jedis jedis = jedisPool.getResource();
        String accessToken = null;
        try {
            jedis.auth("6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9");
            accessToken = jedis.get(Const.JEDIS_KEY.ACCESS_TOKEN.getKey());
            if(accessToken==null){
                accessToken =  setAccessToken();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                //关闭连接
                jedis.close();
            }
        }
        return accessToken;
    }

    private String setAccessToken(){
        Jedis jedis = jedisPool.getResource();
        jedis.auth("6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9");
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Const.APPID + "&secret=" + Const.APP_SECRET;
        String doGet = "";
        String accessToken= null;
        try {
            JSONObject jsonObject = JSONArray.parseObject(doGet);
            accessToken = jsonObject.getString("access_token");
            String expiresInstr = jsonObject.getString("expires_in");

            jedis.set(Const.JEDIS_KEY.ACCESS_TOKEN.getKey(), accessToken);
            jedis.expire(Const.JEDIS_KEY.ACCESS_TOKEN.getKey(), Integer.valueOf(expiresInstr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessToken;
    }
}
