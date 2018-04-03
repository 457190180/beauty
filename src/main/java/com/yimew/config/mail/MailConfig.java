package com.yimew.config.mail;

import java.io.Serializable;

/**
 * * @author 作者 E-mail: * @date 创建时间：2017年10月17日 下午4:23:42 * @version 1.0
 * * @parameter * @since * @return
 */
public class MailConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String host;
	public Integer port;
	public String userName;
	public String passWord;
	public String emailForm;
	public String timeout;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmailForm() {
		return emailForm;
	}

	public void setEmailForm(String emailForm) {
		this.emailForm = emailForm;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}


}
