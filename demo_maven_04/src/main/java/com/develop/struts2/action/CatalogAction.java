package com.develop.struts2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.develop.struts2.bean.CatalogBean;
import com.develop.struts2.service.CatalogService;
import com.develop.struts2.utils.CommonUtility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CatalogAction extends ActionSupport implements ModelDriven<CatalogBean>{

	private static final long serialVersionUID = 1L;
	@Autowired
	private CatalogBean bean;
	
	@Autowired
	private CatalogService service;
	
	private List<CatalogBean> beans;
	
	public String execute()
	{
		beans = CommonUtility.createCatalogBeanList(service.listCatalog());
		return SUCCESS;
	}
	
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	
		service.deleteCatalog(Long.parseLong( request.getParameter("id")));
		return SUCCESS;
	}
	
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		bean = CommonUtility.createCatalogBean(service.searchCatalogById(Long.parseLong( request.getParameter("id"))));
		return SUCCESS;
	}
	
	public String saveOrUpdateCatalog()
	{
		service.saveOrUpdateCatalog(CommonUtility.createModel(bean));
		return SUCCESS;
	}
	
	public CatalogBean getModel() {
		return bean;
	}


	public List<CatalogBean> getBeans() {
		return beans;
	}

	public void seteans(List<CatalogBean> beans) {
		this.beans = beans;
	}

	public CatalogBean getBean() {
		return bean;
	}

	public void setBean(CatalogBean bean) {
		this.bean = bean;
	}
	
	

}
