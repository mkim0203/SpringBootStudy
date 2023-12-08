package com.example.demo.common.model.settings;

import lombok.Data;

import java.util.List;

@Data
public class ModelData {
//	item1: 11
//    item2: "22"
//    list-data: [aa,bb]
//    list-data2:
//      - cc
//      - dd
	private int Item1;
	private String item2;
	private List<String> listData;
	private List<String> listData2;
	
	public int getItem1() {
		return Item1;
	}
	public void setItem1(int item1) {
		Item1 = item1;
	}
	public String getItem2() {
		return item2;
	}
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	public List<String> getListData() {
		return listData;
	}
	public void setListData(List<String> listData) {
		this.listData = listData;
	}
	public List<String> getListData2() {
		return listData2;
	}
	public void setListData2(List<String> listData2) {
		this.listData2 = listData2;
	}
	
}
