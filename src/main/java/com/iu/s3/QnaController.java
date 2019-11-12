package com.iu.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.dao.board.QnaDAO;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.board.QnaService;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
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
	
	//insert
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public String qnaWrite() {
		return "qna/qnaWrite";
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaInsert(QnaVO qnaVO) throws Exception{
		int result = qnaService.qnaInsert(qnaVO);
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
}
