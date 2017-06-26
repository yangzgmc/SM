package com.st.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.sm.entity.Parent;
import com.st.sm.service.ParentService;

@Controller
@RequestMapping("/parentCon")
public class ParentController {
	@Autowired
	private ParentService  parentService;
	@RequestMapping("getAll")
	@ResponseBody
    public List<Parent> getAll(){
    	return parentService.getAll();
    }
	@RequestMapping("addParent")
	@ResponseBody
    public Parent addParent(Parent parent){
//		parent.setPa_Id("t11");
//		parent.setSt_Id("8");
//		parent.setPa_Name("小菊");
//		parent.setPa_Type(1);
//		parent.setPa_Phone("2222222222");
//		System.out.println("ssssssssssssssss");
    	return parentService.addParent(parent);
    }
	@RequestMapping("updateParent")
	@ResponseBody
    public void updateParent( Parent parent){
//		parent.setPa_Id("t11");
//		parent.setPa_Type(1);
//		parent.setPa_Phone("0000000000000");
		parentService.updateParent(parent);
		System.out.println("sssss");
    }
//	@RequestMapping("selectParentId")
//	@ResponseBody
//    public Parent selectParentId( final String id){
//		 Parent parent=parentService.selectParentId("1");
//		 System.out.println(parent.getPa_Name());
//		 return parent;
//		
//    }
	
     

}
