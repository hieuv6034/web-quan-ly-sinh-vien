package com.quanlysinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysinhvien.model.KmaclassModel;

public class KmaclassMapper implements RowMapper<KmaclassModel>{

	@Override
	public KmaclassModel mapRow(ResultSet rs) {
		
		try {
			KmaclassModel kmaclass = new KmaclassModel();
			kmaclass.setId(rs.getLong("id"));
			kmaclass.setCode(rs.getString("code"));
			kmaclass.setName(rs.getString("name"));
			kmaclass.setCourse_id(rs.getString("course_id"));
			kmaclass.setCreatedat(rs.getTimestamp("createdat"));
			kmaclass.setUpdatedat(rs.getTimestamp("updatedat"));
			return kmaclass;
		} catch (SQLException e) {
			return null;
		}

	}
	
}
