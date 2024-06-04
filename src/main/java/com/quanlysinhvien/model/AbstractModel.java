package com.quanlysinhvien.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractModel<T> {
	private Long id;
	private Timestamp createdat;
	private Timestamp updatedat;
	private List<T> listResult = new ArrayList<>();//Lấy danh sách cần hiển thị
	private String type;
}
