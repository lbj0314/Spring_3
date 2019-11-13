package com.iu.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.board.QnaService;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	
	//reply
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public String qnaReply(QnaVO qnaVO) throws Exception{
		int result = qnaService.qnaReply(qnaVO);
		return "qna/qnaList";
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public void qnaReply(Model model, int num) throws Exception {
		//이름을 안 넣으면 변수명 자체가 이름
		model.addAttribute("num", num);
	}
	
	//list
	@RequestMapping(value = "qnaList", method = RequestMethod.GET )
	public ModelAndView qnaList(Pager pager) throws Exception {
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		List<QnaVO> list = qnaService.qnaList(pager);
//		model.addAttribute("list", list);
//		model.addAttribute("pager", pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("pager", pager);
		mv.setViewName("qna/qnaList");
		
		return mv;
	}
	
	//select One
	@RequestMapping(value = "qnaSelect", method = RequestMethod.GET)
	public ModelAndView qnaSelect(int num) throws Exception{
		QnaVO qnaVO = qnaService.qnaSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", qnaVO);
		mv.setViewName("qna/qnaSelect");
		return mv;
	}
	
	//insert
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public String qnaWrite() throws Exception {
		return "qna/qnaWrite";
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaInsert(QnaVO qnaVO) throws Exception{
		int result = qnaService.qnaWrite(qnaVO);
		ModelAndView mv = new ModelAndView();
		String msg = "Write Fail";
		if (result > 0) {
			msg = "Write Success";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	//delete
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public ModelAndView qnaDelete(QnaVO qnaVO ,int num) throws Exception {
		int result = qnaService.qnaDelete(num);
		ModelAndView mv = new ModelAndView();
		String msg = "Delete Fail";
		if (result > 0) {
			msg = "Delete Success";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "qnaDelete");
		mv.setViewName("common/common_result");
		
		return mv;
	}
}
