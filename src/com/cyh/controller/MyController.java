package com.cyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cyh.DAO.CaoDAO;
import com.cyh.DAO.CollectwineDAO;
import com.cyh.DAO.OrderinfoDAO;
import com.cyh.DAO.OrderqDAO;
import com.cyh.DAO.ShoppingcartDAO;
import com.cyh.DAO.UserDAO;
import com.cyh.DAO.WineDAO;
import com.cyh.DAO.WineevaluteDAO;

import com.cyh.domain.Cao;
import com.cyh.domain.Collectwine;
import com.cyh.domain.Orderinfo;
import com.cyh.domain.Orderq;
import com.cyh.domain.Shoppingcart;
import com.cyh.domain.User;
import com.cyh.domain.Wine;
import com.cyh.domain.Wineevalute;

@Controller
@RequestMapping("/jsp")
public class MyController {

	@RequestMapping("/hello.do")
	//
	public String hello() {
		System.out.println("hello springmvc with annotation");
		return "index";
	}

	@RequestMapping("/showAll.do")
	public String toPerson6(Model model) throws Exception {

		CaoDAO person = new CaoDAO();
		List<Cao> ul = person.findAll();
		model.addAttribute("uList", ul);
		return "wineCheck";
	}
	@RequestMapping("/showLoginUser.do")
	public String userLogin(Cao cao,Model model){
		CaoDAO person = new CaoDAO();
		cao = person.findByLogin(cao);
		model.addAttribute("user", cao);
		return "wineCheck";
	}
//	@RequestMapping("/regist.do")
//	public String userRegist(Cao cao){
//		System.out.println("name="+cao.getUserName()+" password="+cao.getPassword());
//		CaoDAO cd=new CaoDAO();
//		cd.save(cao);
//		return "jsp/ok";
//	}
//	@RequestMapping("/login.do")
//	public String userLogin1(Cao cao,Model model){
//		System.out.println("name="+cao.getUserName()+" password="+cao.getPassword());
//		CaoDAO cd=new CaoDAO();
//		Cao c=null;
//		c=cd.findByLogin(cao);
//		if(c==null){
//			model.addAttribute("userinfo",c);
//			return "jsp/login";
//		}else{
//			return "jsp/ok";
//		}
//	}

	/**
	 * 全局
	 */
	@RequestMapping("/")
	public void quanju(HttpServletRequest request){
		User u=(User) request.getSession().getAttribute("userinfo");
		ShoppingcartDAO sd  =new ShoppingcartDAO();
		List<Shoppingcart> list=sd.findByUserId(u);
		int n=list.size();
		System.out.println("233333333333333333333333333333333333333333333333");
		request.getSession().setAttribute("cartnum", n);
	}
	/**
	 * 注册
	 */
	@RequestMapping("/regist.do")
	public ModelAndView userRegist(User user,HttpServletRequest request){
		System.out.println("name="+user.getUserName()+" password="+user.getPassWord());
		ModelAndView mv=new ModelAndView();
		String username=user.getUserName();
		UserDAO ud=new UserDAO();
		List<User> list=ud.findByUserName(username);
		if(list.size()==0){
		user.setBalance(0l);
		user.setUserType("1");
		ud.save(user);
		request.getSession().setAttribute("userinfo", user);
		mv.setViewName("jsp/homepage");
		return mv;
	}else{
		mv.addObject("msg", "该用户名已被注册");
		mv.setViewName("jsp/login");
		return mv;
	}
	}
	
	/**
	 * 登录
	 */
	@RequestMapping("/login.do")
	public String userLogin1(User user,HttpServletRequest request){
		System.out.println("name="+user.getUserName()+" password="+user.getPassWord());
		String path=(String) request.getSession().getAttribute("path");
		System.out.println("path: "+path);
		UserDAO ud=new UserDAO();
		User u=null;
		u=ud.findByLogin(user);
		if(u==null){
			return "jsp/login";
		}else{
			request.getSession().setAttribute("userinfo", u);
			if(path!=null){
				return path;
			}else{
			return "jsp/homepage";
			}
		}
	}
	/**
	 * 注销
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("userinfo");
		return "redirect:homepage.jsp";
	}
	
	/**
	 * 显示酒列表
	 */
	@RequestMapping("/showwines.do")
	public String showWines(String winetype,Model model){
		System.out.println("qqqqqqqqqqqqqq "+winetype);
		String type=winetype;
		WineDAO wd=new WineDAO();
		if(type.equals("wineall")){
			List<Wine> list=wd.findAll();
			model.addAttribute("wineinfo",list);
		}else{
			List<Wine> list=wd.findByWineType(type);
			model.addAttribute("wineinfo",list);
		}
		
		
		return "jsp/wines";
		
	}
	
	/**
	 * 酒品详细显示
	 */
	@RequestMapping("/showDetail.do")
	public String showDetail(int id,Model model){
		System.out.println("wine name="+id);
		WineDAO wd=new WineDAO();
		Wine w=wd.findById(id);
		String wineType=w.getWineType();
		
		List<Wine> list=wd.findByWineType(wineType);
		System.out.println("wine name="+w.getWineName()+"wineType="+wineType);
		
		WineevaluteDAO wed=new WineevaluteDAO();
		List<Wineevalute> we=wed.findByWineId(id);
		int n=we.size();		
		
		model.addAttribute("evaluteinfo", we);
		model.addAttribute("evalutetimes",n);
		model.addAttribute("winedetail",w);
		model.addAttribute("recommendwine", list);
		return "jsp/winedetail";
		
	}
	
	/**
	 * 加入购物车
	 */
	@RequestMapping("/addtocart.do")
	public String addtoCart(Integer id,Integer cartCount,HttpServletRequest request){
		System.out.println("wineID: "+id +"cartCount: "+cartCount);
		Boolean b=false;
		WineDAO wd=new WineDAO();
		Wine w=wd.findById(id);
		User u=(User) request.getSession().getAttribute("userinfo");
		int userid=u.getUserId();
		System.out.println("wineID: "+w.getWineId()+"userName: "+u.getUserName());
		ShoppingcartDAO sd=new ShoppingcartDAO();
		List<Shoppingcart> list=sd.findByUserId(u);
		if(list.size()==0){
			Shoppingcart shoppingcart = new Shoppingcart();
			shoppingcart.setCartCount(cartCount);
			shoppingcart.setWine(w);
			shoppingcart.setUser(u);
			sd.save(shoppingcart);
			System.out.println("wwwwwwwwwww");
		}else{
			for(Shoppingcart sc : list){
				System.out.println("1111111111"+sc.getWine().equals(w));
				System.out.println(sc.getWine().getWineId());
				System.out.println(w.getWineId());
				if(b=sc.getWine().getWineId().equals(w.getWineId())){
					int cartcount=cartCount+sc.getCartCount();
					int cartid=sc.getCartId();
					sd.updateCart(cartid, cartcount);
					System.out.println("eeeeeeeee");
					break;
				}}
			if(!b){
					System.out.println("2222222222");
					Shoppingcart shoppingcart = new Shoppingcart();
					shoppingcart.setCartCount(cartCount);
					shoppingcart.setWine(w);
					shoppingcart.setUser(u);
					sd.save(shoppingcart);
					System.out.println("rrrrrrrrrr");
				}
		}
		
		
		return "redirect:/jsp/showCart.do?id="+userid;
	}
	
	/**
	 * 显示购物车
	 */
	@RequestMapping("/showCart.do")
	public ModelAndView list(Integer id,Model model) {

		//取用户ID
		//User u = (User)request.getSession().getAttribute("user");
		ModelAndView mv=new ModelAndView();
		ShoppingcartDAO sd  =new ShoppingcartDAO();
		List<Shoppingcart> list=sd.findByUserId1(id);
		mv.addObject("shoppinglist",list);
		mv.setViewName("jsp/shopingCart");
		return mv;
		
	}
	

	/**
	 * 修改
	 */
	@RequestMapping("/updatecart.do")
	public String updateCart(Integer cartid,Integer id,Integer cartcount){
		
		System.out.println("cartID: "+cartid +"UserID: "+id+"cartCount: "+cartcount);
		ShoppingcartDAO sd  =new ShoppingcartDAO();
		sd.updateCart(cartid, cartcount);
		return "redirect:/jsp/showCart.do?id="+id;
	}
//	/**
//	 * 删除
//	 */
//	@RequestMapping("/deletewine.do")
//	public String delete(Integer cartid,Integer id) {
//		System.out.println("cartID: "+cartid+"userId"+id);
//		ShoppingcartDAO sd  =new ShoppingcartDAO();
//		sd.delete1(cartid);
//		return "redirect:/jsp/showCart.do?id="+id;
//	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/deletewine.do")
	public String delete(Integer cartid,Integer id) {
		System.out.println("cartID: "+cartid+"userId"+id);
		ShoppingcartDAO sd  =new ShoppingcartDAO();
		Shoppingcart c=sd.findById(cartid);
		System.out.println("ssss="+c.getCartId());
		sd.delete(c);
		return "redirect:/jsp/showCart.do?id="+id;
	}
	/**
	 * 下订单
	 */
	@RequestMapping("/order.do")
	public String order(Integer userid){
		UserDAO ud=new UserDAO();
		User user=ud.findById(userid);
		OrderqDAO oqd=new OrderqDAO();
		Orderq oq=new Orderq();
		oq.setUser(user);
		oq.setUname(null);
		oq.setAddress(null);
		oq.setPayorno(0);
		oq.setYoubian(null);
		oq.setPhone(null);
		oqd.save(oq);
		
		Long orderId=oq.getOrderId();
		OrderinfoDAO ofd=new OrderinfoDAO();
		ShoppingcartDAO sd  =new ShoppingcartDAO();
		List<Shoppingcart> buywines=sd.findByUserId(user);
		System.out.println("buwinessize="+buywines.size());
		Orderinfo of=new Orderinfo();
		for(Shoppingcart sc : buywines){
			
			System.out.println("cartcount="+sc.getCartCount()+"oqid="+oq.getOrderId()+"wineid"+sc.getWine().getWineId());
			of.setOrderCount(sc.getCartCount());
			of.setOrderq(oq);
			of.setWine(sc.getWine());
			ofd.save(of);
		}
		return "redirect:/jsp/myorder.do?userid="+userid+"&&orderId="+orderId;
	}
	/**
	 * 我的订单
	 */
	@RequestMapping("/myorder.do")
	public String order(Integer userid,Long orderId,Model model){
		System.out.println("userid="+userid+"orderId="+orderId);
		OrderqDAO oqd=new OrderqDAO();
		Orderq orderq=oqd.findById(orderId);
		model.addAttribute("orderq", orderq);
		
		OrderinfoDAO ofd=new OrderinfoDAO();
		List<Orderinfo> list=ofd.findByOrderId(orderId);
		model.addAttribute("orderinfo", list);
		return "jsp/orderInfo";
	}
	
	/**
	 * 确认信息
	 */
	@RequestMapping("/sureinfo.do")
	public String sureinfo(Long orderid,String uname,String address,String youbian,String phone,HttpServletRequest request){
		System.out.println("userID: "+"opuname "+uname+address + youbian + phone);
		
		User user=(User) request.getSession().getAttribute("userinfo");
		int userid=user.getUserId();
		OrderqDAO oqd=new OrderqDAO();
		int phone1=Integer.parseInt(phone);
		int youbian1=Integer.parseInt(youbian);
		oqd.updateOrderq(orderid,uname, address, phone1, youbian1);
		return "redirect:/jsp/myorder.do?userid="+userid+"&&orderId="+orderid;
	}
	
	/**
	 * 支付
	 */
	@RequestMapping("/checkout.do")
	public String checkout(Long orderid,Integer userid,Model model){
		UserDAO ud=new UserDAO();
		User user=ud.findById(userid);
		OrderqDAO oqd=new OrderqDAO();
		oqd.updateById(orderid);
		ShoppingcartDAO sd=new ShoppingcartDAO();
		sd.deleteByuserid(userid);
		OrderinfoDAO ofd=new OrderinfoDAO();
		List<Orderinfo> list= ofd.findByOrderId(orderid);
		WineDAO wd=new WineDAO();
		for(Orderinfo of: list){
			Wine w=wd.findById(of.getWine().getWineId());
			int wineCount=w.getWineCount()-of.getOrderCount();
			if(wineCount<0){
				wineCount=0;
			}
			System.out.println("00000001111"+w.getWineCount()+"99999"+of.getOrderCount());
			w.setWineCount(wineCount);
			System.out.println("00000000000"+wineCount);
			wd.update(w);
			
			WineevaluteDAO wed=new WineevaluteDAO();
			Wineevalute we=new Wineevalute();
			Date date=new Date();
			we.setUser(user);
			we.setWine(w);
			we.setEorno("0");
			we.setDate(date);
			wed.save(we);
		}
		
		return "redirect:/jsp/showallorders.do?userid="+userid;
	}
	/**
	 * 搜索
	 */
	@RequestMapping("/search.do")
	public String search(String keyword,Model model){
		WineDAO wd=new WineDAO();
		List<Wine> list=wd.searchlike(keyword);
		model.addAttribute("wineinfo",list);
		return "jsp/wines";
	
	}
	
	/**
	 * 添加收藏
	 */
	@RequestMapping("/collect.do")
	public String collect(Integer wineid,HttpServletRequest request,Model model){
		Boolean b=false;
		WineDAO wd=new WineDAO();
		Wine wine=wd.findById(wineid);
		
		User user=(User) request.getSession().getAttribute("userinfo");
		int userid=user.getUserId();
		
		CollectwineDAO cd=new CollectwineDAO();
		List<Collectwine> list=cd.findByUser(user);
		
		if(list.size()==0){
			Collectwine cw=new Collectwine();
			cw.setUser(user);
			cw.setWine(wine);
			cd.save(cw);
			System.out.println("wwwwwwwwwww");
		}else{
			for(Collectwine cw : list){
				System.out.println("1111111111"+cw.getWine().equals(wine));
				System.out.println(cw.getWine().getWineId());
				System.out.println(wine.getWineId());
				if(b=cw.getWine().getWineId().equals(wine.getWineId())){
					System.out.println("eeeeeeeee");
					break;
				}}
			if(!b){
					System.out.println("2222222222");
					Collectwine cw = new Collectwine();
					cw.setWine(wine);
					cw.setUser(user);
					cd.save(cw);
					System.out.println("rrrrrrrrrr");
				}
	}
		return "redirect:/jsp/showcollect.do?userid="+userid;
}
	
	/**
	 * 删除收藏
	 */
	@RequestMapping("/deletecollect.do")
	public String deletecollect(Integer collectid,Integer userid) {
		System.out.println("cartID: "+collectid+"userId"+userid);
		CollectwineDAO cd=new CollectwineDAO();
		Collectwine cw=cd.findById(collectid);
		System.out.println("ssss=");
		cd.delete(cw);
		return "redirect:/jsp/showcollect.do?userid="+userid;
	}
	
	/**
	 * 显示收藏
	 */
	@RequestMapping("/showcollect.do")
	public ModelAndView collectlist(Integer userid,Model model) {

		//取用户ID
		//User u = (User)request.getSession().getAttribute("user");
		ModelAndView mv=new ModelAndView();
		CollectwineDAO cd  =new CollectwineDAO();
		List<Collectwine> list=cd.findByUserId(userid);
		mv.addObject("collectlist",list);
		mv.setViewName("jsp/collect");
		return mv;
		
	}
	
	/**
	 * 修改个人信息
	 */
	@RequestMapping("/updateuserinfo.do")
	public String updateuserinfo(String address,Integer youbian,Integer phone,HttpServletRequest request,Model model) {
		User user=(User) request.getSession().getAttribute("userinfo");
		int userid=user.getUserId();
		UserDAO ud=new UserDAO();
		ud.update(address, youbian, phone, userid);
		return "redirect:/jsp/showuser.do";	
	}
	
	/**
	 * 个人中心
	 */
	@RequestMapping("/showuser.do")
	public String showuser(HttpServletRequest request,Model model) {
		User user=(User) request.getSession().getAttribute("userinfo");
		int userid=user.getUserId();
		UserDAO ud=new UserDAO();
		User u=ud.findById(userid);
		model.addAttribute("newuser", u);
		return "jsp/user";		
	}
	/**
	 * 待评价酒品
	 */
	@RequestMapping("/showevalute.do")
	public ModelAndView showevalute(Integer userid,Model model){
		ModelAndView mv=new ModelAndView();
		WineevaluteDAO wed=new WineevaluteDAO();
		List<Wineevalute> list=wed.findByUserId(userid);
		mv.addObject("evaluteinfo1",list);
		mv.setViewName("jsp/evalute");
		return mv;
	}
	
	/**
	 * 去评价酒品
	 */
	@RequestMapping("/goevalute.do")
	public ModelAndView goevalute(Integer evaluteid,Model model){
		ModelAndView mv=new ModelAndView();
		WineevaluteDAO wed=new WineevaluteDAO();
		Wineevalute we=wed.findById(evaluteid);
		mv.addObject("evalutewine",we);
		mv.setViewName("jsp/evalutethewine");
		return mv;
	}
	
	/**
	 * 评价酒品
	 */
	@RequestMapping("/submitevalute.do")
	public String submitevalute(Integer evaluteid,String evalute){
		System.out.println("eeeeeeeeeee+"+evalute);
		WineevaluteDAO wed=new WineevaluteDAO();
		Wineevalute we=wed.findById(evaluteid);
		int userid=we.getUser().getUserId();
		Date date=new Date();
		String eorno="1";
		wed.updateEvalute(date, eorno, evalute,evaluteid);
		return "redirect:/jsp/showevalute.do?userid="+userid;
	}
	/**
	 * 订单列表
	 */
	@RequestMapping("/showallorders.do")
	public ModelAndView showallorders(Integer userid,Model model){
		ModelAndView mv=new ModelAndView();
		OrderqDAO oqd=new OrderqDAO();
		List<Orderq> list=oqd.findByUserId2(userid);
		mv.addObject("orderlist",list);
		mv.setViewName("jsp/orderlist");
		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/deleteorder.do")
	public String deleteorder(Long orderid,Integer userid){
		OrderqDAO oqd=new OrderqDAO();
		Orderq oq=oqd.findById2(orderid);
		oqd.delete(oq);
		return "redirect:/jsp/showallorders.do?userid="+userid;
	}
	
	
	
}
