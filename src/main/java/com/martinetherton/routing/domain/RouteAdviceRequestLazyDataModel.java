package com.martinetherton.routing.domain;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class RouteAdviceRequestLazyDataModel extends LazyDataModel<RouteAdviceRequest> {

	   private static final long serialVersionUID = -8832831134966938627L;

	   // SearchCriteria searchCriteria;

	   List<RouteAdviceRequest> routeAdviceRequests;

	    private RouteAdviceRequest selected;

	    public RouteAdviceRequestLazyDataModel(List<RouteAdviceRequest> routeAdviceRequests) {
	    	this.routeAdviceRequests = routeAdviceRequests;
	    }

	    @Override
	    public List<RouteAdviceRequest> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
			return routeAdviceRequests;
	    }

	    @Override
	    public int getRowCount() {
	    	return 5;
	    }

	    public RouteAdviceRequest getSelected() {
	    	return selected;
	    }

	    public void setSelected(RouteAdviceRequest selected) {
	    	this.selected = selected;
	    }

	    public int getCurrentPage() {
	    	return 1;
	    }

	    public int getPageSize() {
	    	return 5;
	    }
	

}
