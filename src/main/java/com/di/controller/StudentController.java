package com.di.controller;
import com.di.dto.StudentDTO;
import com.di.service.StudentService;
import com.di.vo.*;
public class StudentController {
    private StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }

    public String process(String sno, String sname, String m1,String m2,String m3){
        //prepare VO object
        StudentVO vo = new StudentVO();
        vo.setSno(sno);
        vo.setSname(sname);
        vo.setM1(m1);
        vo.setM2(m2);
        vo.setM3(m3);

        //convert VO object to DTO object
        StudentDTO dto = new StudentDTO();
        dto.setSno(Integer.parseInt(vo.getSno()));
        dto.setSname(vo.getSname());
        dto.setM1(Integer.parseInt(vo.getM1()));
        dto.setM2(Integer.parseInt(vo.getM2()));
        dto.setM3(Integer.parseInt(vo.getM3()));
        //use service class
        String result = service.generateResult(dto);
        return result;
    }
}
