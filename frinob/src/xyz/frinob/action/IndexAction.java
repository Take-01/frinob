package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		session.clear();

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
