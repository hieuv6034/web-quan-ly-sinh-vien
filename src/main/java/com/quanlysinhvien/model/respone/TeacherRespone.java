package com.quanlysinhvien.model.respone;

import com.quanlysinhvien.model.AbstractModel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class  TeacherRespone extends AbstractModel<TeacherRespone> {
    private String code;
    private String fname;
    private String lname;
    private String image;
    private String department_name;
    private String gender;
    private String phone;
    private String dob;
    private String email;

}
