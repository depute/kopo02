package com.example.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.MemberService;
import com.example.vo.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
    private MemberService service;
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) throws Exception{
 
        logger.info("home");
        
        List<MemberVO> memberList = service.selectMember();
        
        model.addAttribute("memberList", memberList);
 
        return "home";
    }
    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model) throws Exception {
    	int pcnt=10;
    	int total=0;
    	String sel=request.getParameter("sel");
    	String con=request.getParameter("con");
    	if(sel==null) total=service.selectcnt();
    	else {
    		if(sel.equals("title")) total=service.selectcnttitle(con);
    		else if(sel.equals("content")) total=service.selectcntcontent(con);
    		else if(sel.equals("wrt")) total=service.selectcntwrt(con);
    	}
    	int max=total/pcnt;
    	if(total%pcnt>0) max++;
    	int p=1;
    	try {
    		p=Integer.parseInt(request.getParameter("p"));
    	} catch(Exception e) {
    		p=1;
    	}
    	if(p<1) p=1;
    	else if(p>max&&max>1) p=max;
    	p=(p-1)*pcnt;
    	
    	List<Fir> fir=service.selectFir(p);
    	if(sel!=null) {
    		if(sel.equals("title")) fir=service.selecttitle(con);
    		else if(sel.equals("content")) fir=service.selectcontent(con);
    		else if(sel.equals("wrt")) fir=service.selectwrt(con);
    	}
    	p=p/10+1;
    	model.addAttribute("fir",fir);
    	int pstart=1,pend=1;
    	if(p>=5) pstart=p-5;
    	pend=max;
    	model.addAttribute("p",p);
    	model.addAttribute("pstart",pstart);
    	model.addAttribute("pend",pend);
    	return "index";
    }
    @RequestMapping("/write")
    public String write(HttpServletRequest request,Model model) throws Exception {
    	int id=0;
    	try {
    		id=Integer.parseInt(request.getParameter("id"));
    	} catch(Exception e) {
    		
    	}
    	model.addAttribute("id",id);
    	return "write";
    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value="/insert")
    public String insert(HttpServletRequest request,@RequestParam("content") String content,@RequestParam("wrt") String wrt,@RequestParam("pass") String pass,Sec Sec,Fif Fif,Model model) throws Exception {
    	int id=1;
    	String rootid2=request.getParameter("rootid");
    	if(rootid2==null) {
    		String title=request.getParameter("title");
	    	try {
	    		id=Integer.parseInt(request.getParameter("id"));
	    		Sec.setId(id);
	        	Sec.setTitle(title.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	Sec.setContent(content.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	Sec.setWrt(wrt.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	Sec.setPass(pass.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	service.upd(Sec);
	    	} catch(Exception e) {
	        	List<Thi> sec=service.selectid();
	        	id=Thi.id;
	        	Thi.id=0;
	        	if(Integer.toString(id).length()<1) id=1;
	        	else id+=1;
	        	Sec.setId(id);
	        	Sec.setRootid(id);
	        	Sec.setTitle(title.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	Sec.setContent(content.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	Sec.setOrd(0);
	        	Sec.setP(id);
	        	Sec.setWrt(wrt.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	Sec.setPass(pass.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	service.insert(Sec);
	    	}
	    	return "redirect:view?id="+id;
    	}
    	else {
    		int rootid=Integer.parseInt(rootid2);
    		Fif.setRootid(rootid);
    		try {
	    		id=Integer.parseInt(request.getParameter("id"));
	    		Fif.setId(id);
	    		Fif.setContent(content.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	    		Fif.setWrt(wrt.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	    		Fif.setPass(pass.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	service.updre(Fif);
	    	} catch(Exception e) {
	    		try {
	    			id=service.selectreid(id);
	    		} catch(Exception ne) {
	    			id=0;
	    		}
	        	id+=1;
	        	Fif.setId(id);
	        	Fif.setContent(content.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	Fif.setWrt(wrt.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	Fif.setPass(pass.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt").replaceAll(" ", "&nbsp"));
	        	service.insertre(Fif);
	    	}
	    	return "redirect:view?id="+rootid;
    	}
    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value="/view")
    public String view(@RequestParam("id") int id,Model model) throws Exception {
    	service.updateview(id);
    	List<Fou> fou=service.selectview(id);
    	model.addAttribute("fou",fou);
    	List<re> re=service.selectre(id);
    	model.addAttribute("re",re);
    	return "view";
    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value="/update")
    public String upd(HttpServletRequest request,@RequestParam("id") int id,Thi Thi,Model model) throws Exception{
    	if(request.getParameter("rootid")==null) {
    		List<Fou> fou=service.selectview(id);
    		model.addAttribute("fou",fou);
    	}
    	else {
    		int rootid=Integer.parseInt(request.getParameter("rootid"));
    		Thi.setId(id);
    		Thi.setRootid(rootid);
    		List<Fif> fif=service.selectrev(Thi);
    		model.addAttribute("fou",fif);
    	}
    	return "write";
    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value="/delete")
    public String del(HttpServletRequest request,@RequestParam("id") int id,Thi thi,Model model) throws Exception{
    	if(request.getParameter("rootid")==null) {
    		service.del(id);
    	}
    	else {
    		thi.setId(id);
    		thi.setRootid(Integer.parseInt(request.getParameter("rootid")));
    		service.delre(thi);
    	}
    	return "redirect:index";
    }
}