package com.iu.s3;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.model.board.NoticeVO;
import com.iu.s3.service.board.NoticeService;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	//noticeList
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public void noticeList(Model model, Pager pager) throws Exception{
		List<NoticeVO> ar = noticeService.noticeList(pager);
		model.addAttribute("list", ar);
		//저장소의 위치만 넘김
		model.addAttribute("pager", pager);
		
	}
	//noticeSelect
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView noticeSelect(int num) throws Exception{
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", noticeVO);
		mv.setViewName("notice/noticeSelect");
		return mv;
	
	}
	
	//noticeDelete
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public ModelAndView noticeDelete(NoticeVO noticeVO, int num) throws Exception{
		int result = noticeService.noticeDelete(num);
		ModelAndView mv = new ModelAndView();
		String msg = "fail";
		
		if (result > 0) {
			msg = "success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	//noticeWrite
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String noticeWrite() {
		return "notice/noticeWrite";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeVO noticeVO) throws Exception {
	
		int result = noticeService.noticeInsert(noticeVO);
		String msg = "fail";
		ModelAndView mv = new ModelAndView();
		
		if(result > 0) {
			msg="success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	//noticeUpdate
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public Model noticeUpdate (int num, Model model ) throws Exception {
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("vo", noticeVO);
		return model;
	}
	
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeUpdate(noticeVO);
	
		String msg = "수정 실패";
		if(result > 0) {
			msg = "수정 성공";
		}
	
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/common_result");
	
		return mv;
	}
	
	
}
