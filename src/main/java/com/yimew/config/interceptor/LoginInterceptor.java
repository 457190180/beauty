package com.yimew.config.interceptor;

import com.yimew.service.sys.JedisService;
import com.yimew.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JedisService jedisService;
    @Autowired
    private UserService userService;

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object arg2, ModelAndView arg3)
            throws Exception {


    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
            //TODO 登录用拦截器 请自行实现
//        Jedis jedis = null;
//        try {
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json; charset=utf-8");
//
//            ReturnData returnData = new ReturnData(null, Const.CODE.FAIL, "");
//
//            jedis = jedisService.getJedis();
//            String usercode = request.getHeader(Const.HEADER_KEY.USERCODE.getCode());
//            String token = request.getHeader(Const.HEADER_KEY.TOKEN.getCode());
//            if (CheckUtils.checkPropertysIsNull(usercode) || CheckUtils.checkPropertysIsNull(token)) {
//                returnData.setMsg("userCode or token is null");
//                PrintWriter out = response.getWriter();
//                out.append(JSONArray.toJSONString(returnData));
//                out.close();
//                return false;
//            }
//            byte[] bs = jedis.get((Const.REIDS_APPLICAT_KEY + usercode).getBytes());
//            User user = (User) SerializeUtil.unserialize(bs);
//            if (user == null) {
//                returnData.setCode(Const.CODE.LOGIN_FAIL);
//                returnData.setMsg("login out of time");
//                PrintWriter out = response.getWriter();
//                out.append(JSONArray.toJSONString(returnData));
//                out.close();
//                return false;
//            }
//            //判断用户token
//            String systoken = user.getToken();
//            if (!token.equals(systoken)) {
//                PrintWriter out = response.getWriter();
//                returnData.setCode(Const.CODE.LOGIN_FAIL);
//                returnData.setMsg("token error");
//                out.append(JSONArray.toJSONString(returnData));
//                out.close();
//                return false;
//            }
//
//            //从数据库中获取用户实时信息
//            User byId = userService.getById(usercode);
//            //判断用户是否存在
//            if(byId==null){
//                PrintWriter out = response.getWriter();
//                returnData.setMsg("user has not existed");
//                out.append(JSONArray.toJSONString(returnData));
//                out.close();
//                return false;
//            }
//            //判断用户状态
//            if(Const.STATE.ABNORMAL.equals(byId.getState())){
//                PrintWriter out = response.getWriter();
//                returnData.setMsg("user is disable");
//                out.append(JSONArray.toJSONString(returnData));
//                out.close();
//                return false;
//            }
//            //判断用户是否通过审核
//           /* if(!Const.APPROVE_STATE.APPROVED.equals(user.getIsApprove())){
//                PrintWriter out = response.getWriter();
//                returnData.setMsg("user is not approved");
//                out.append(JSONArray.toJSONString(returnData));
//                out.close();
//                return false;
//            }*/
//            //自动延期20分钟
//            jedis.expire(Const.REIDS_APPLICAT_KEY + usercode, 60 * 60 * 2);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            /*if (out != null) {
//                out.close();
//            }*/
//            if (jedis != null) {
//                jedisService.returnResource(jedis);
//            }
//        }
        return true;
    }

}
