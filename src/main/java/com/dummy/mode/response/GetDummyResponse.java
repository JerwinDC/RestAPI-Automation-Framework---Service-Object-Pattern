package com.dummy.mode.response;

import java.util.LinkedHashMap;
import java.util.List;

public class GetDummyResponse {
	
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<LinkedHashMap<String, Object>> data;
	public Support support;
	
	public GetDummyResponse() {
		
	}

	public GetDummyResponse(int page, int per_page, int total, int total_pages, List<LinkedHashMap<String, Object>> data,
			Support support) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
		this.support = support;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<LinkedHashMap<String, Object>> getData() {
		return data;
	}

	public void setData(List<LinkedHashMap<String, Object>> data) {
		this.data = data;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	@Override
	public String toString() {
		return "GetDummyResponse [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
				+ total_pages + ", data=" + data + ", support=" + support + "]";
	}
	

	

}
