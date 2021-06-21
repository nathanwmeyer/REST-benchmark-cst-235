package controllers;

import java.sql.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Bible;
import business.WordSearchBusinessInterface;

@ManagedBean 
@ViewScoped
public class FormController {

	@Inject
	WordSearchBusinessInterface service;

	public String howMany(Bible bible)//submit user's name using the Submit Button
	{
		
		FacesContext context = FacesContext.getCurrentInstance();
		bible = context.getApplication().evaluateExpressionGet(context, "#{bible}", Bible.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("bible", bible);
		
		Bible passage = service.getBible();
		System.out.println(passage.getPassage());
		bible.setPassage(passage.getPassage());
		
		int i = service.returnOccurences(bible);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", i);
		
		return "Result.xhtml";
	}
	
}
