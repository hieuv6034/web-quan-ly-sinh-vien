package com.quanlysinhvien.model.respone;
import com.quanlysinhvien.model.AbstractModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponse extends AbstractModel<StudentResponse>{
    private String code;
    private String name;
    private String gender;
    private String image;
    private String lop;
    private String birthday;
    private String bank_number;
    private String bank;
    private String school_year_id;
    private String dob;
    private String address;
    private String identify_number;
    private String identify_date;
    private String identify_address;

}
