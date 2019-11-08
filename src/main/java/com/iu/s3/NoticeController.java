package com.iu.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.model.board.NoticeVO;
import com.iu.s3.service.board.NoticeService;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	//noticeList
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public void noticeList(Model model) throws Exception{
		List<NoticeVO> list = noticeService.noticeList();
		model.addAttribute("list", list);
		
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
//	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
//	public String noticeUpdate() {
//		return "notice/noticeUpdate";
//	}
	
	@RequestMapping(value = "noticeUpdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeUpdate(NoticeVO noticeVO, int num) throws Exception {

		noticeVO = noticeService.noticeSelect(num);
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeUpdate(noticeVO);
		String msg = "fail";
		
//		if(result > 0) {
//			msg="success";
//		}
		
		mv.addObject("vo", noticeVO);
//		mv.addObject("msg", msg);
//		mv.addObject("path", "noticeList");
		mv.setViewName("notice/noticeUpdate");

		return mv;
	}
	
	
}
