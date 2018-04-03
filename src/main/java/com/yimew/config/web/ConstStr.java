package com.yimew.config.web;

public interface ConstStr {

    public static interface LOGIN{
        String USERCODE_NOT_EXIST ="用户名不存在";
        String PASSWORD_ERROR ="密码错误";
        String ROLE_ERROR ="用户角色异常";
        String APPROVE_ERROR ="用户审核未通过";
        String STATE_ERROR ="用户已被禁用";
    }

    public static interface COMMON_TIP{
        String REDIS_ERROR ="REDIS服务异常";
        String SUCCESS ="成功";
        String AUTHORITY_ERROR ="数据权限异常";
        String SAVE_ERROR ="新增失败";
        String EIDT_ERROR ="修改失败";
        String PASSWORD_ERROR="密码错误";
    }
}
