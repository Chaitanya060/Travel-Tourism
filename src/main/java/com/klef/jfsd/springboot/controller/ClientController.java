package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Client;
import com.klef.jfsd.springboot.repository.HotelRepository;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.ClientService;
import com.klef.jfsd.springboot.service.DestinationService;
import com.klef.jfsd.springboot.service.EmailService;
import com.klef.jfsd.springboot.util.OtpUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public ModelAndView demo()
	{
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	
	@GetMapping("/regprompt")
	public ModelAndView regprompt()
	{
		ModelAndView mv=new ModelAndView("regprompt");
		return mv;
	}
	@GetMapping("/userreg")
	public ModelAndView clientRegistration()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("userSignup");
		return mv;
	}
	
//	@PostMapping("/addclient")
//	public ModelAndView addClient(HttpServletRequest request,RedirectAttributes redirectAttributes)
//	{
//		ModelAndView mv=new ModelAndView();
//		String fname=request.getParameter("fname");
//		String lname=request.getParameter("lname");
//		String email=request.getParameter("email");
//		String mobile=request.getParameter("mobile");
//		String gender=request.getParameter("gender");
//		String dob = request.getParameter("dob");
//		String location=request.getParameter("location");
//		String password=request.getParameter("pwd1");
//		Client c=new Client();
//		c.setFname(fname);
//		c.setLname(lname);
//		c.setEmail(email);
//		c.setMobile(mobile);
//		c.setLocation(location);
//		c.setPassword(password);
//		c.setDob(dob);
//		c.setGender(gender);
//		String ack=clientService.addClient(c);
//		mv.setViewName("redirect:/login");
//		redirectAttributes.addFlashAttribute("ack", ack);
//		return mv;
//		
//	}
	@PostMapping("/checkclientlogin")
	public ModelAndView checkClientLogin(HttpServletRequest request,RedirectAttributes redirectAttributes)
	{
		String email=request.getParameter("email");
		String pswd=request.getParameter("pwd");
		Client c= clientService.checkClientLogin(email, pswd);
		ModelAndView mv=new ModelAndView();

		if(c!=null)
		{
			mv.setViewName("redirect:/home");
			//mv.addObject("ack","Login Success !");
			//redirectAttributes.addFlashAttribute("ack", "Login Success !");
			HttpSession session =request.getSession();
			session.setAttribute("clientId",c.getId());
			session.setAttribute("success", "Login Success !!");
			return mv;
		}
		mv.setViewName("redirect:/login");
		//mv.addObject("ack","Login Failed !");
		redirectAttributes.addFlashAttribute("failure", "Login Failed !");
		return mv;
	}
	
	@GetMapping("/home")
	public ModelAndView clientHome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("ClientId") != null) {
			mv.setViewName("home");
			return mv;
		}
	    mv.setViewName("redirect:/home");
	    return mv;
	}
	
//	from here it will be admin code
	
	@GetMapping("/adminlogin")
    public String AdminLoginPage() {
        return "adminlogin"; // JSP page name
    }

	@PostMapping("/adminlogin")
	public String adminLogin(
	    @RequestParam("email") String email, 
	    @RequestParam("password") String password, 
	    Model model) {
	    String hardcodedEmail = "admin@gmail.com";
	    String hardcodedPassword = "admin123";

	    if (email.equals(hardcodedEmail) && password.equals(hardcodedPassword)) {
	      
	        Admin admin = new Admin();
	        admin.setId(1);
	        admin.setAdminname("Administrator");
	        admin.setAdminpassword(hardcodedPassword);

	        model.addAttribute("admin", admin);
	        return "admindashboard"; 
	    } else {
	        model.addAttribute("error", "Invalid email or password");
	        return "adminlogin"; 
	    }
	}
//	otp generations
	
	@PostMapping("/addclient")
	public String addClientWithOtp(
	        @RequestParam String fname,
	        @RequestParam String lname,
	        @RequestParam String email,
	        @RequestParam String mobile,
	        @RequestParam String gender,
	        @RequestParam String dob,
	        @RequestParam String location,
	        @RequestParam String pwd1,
	        HttpSession session,
	        RedirectAttributes redirectAttributes) {
	    // Generate OTP
	    String otp = OtpUtil.generateOtp();
	    long otpGenerationTime = System.currentTimeMillis(); // Store OTP generation time

	    // Store data and OTP in the session for later verification
	    session.setAttribute("fname", fname);
	    session.setAttribute("lname", lname);
	    session.setAttribute("email", email);
	    session.setAttribute("mobile", mobile);
	    session.setAttribute("gender", gender);
	    session.setAttribute("dob", dob);
	    session.setAttribute("location", location);
	    session.setAttribute("password", pwd1);
	    session.setAttribute("otp", otp);
	    session.setAttribute("otpTime", otpGenerationTime);

	    // Send OTP via email
	    emailService.sendOtp(email, otp);
	    redirectAttributes.addFlashAttribute("success", "OTP sent to your email!");
	    return "redirect:/verifyOtp"; // Redirect to OTP verification page
	}
	
	
	@PostMapping("/verifyOtp")
	public String verifyOtp(@RequestParam String enteredOtp, HttpSession session, RedirectAttributes redirectAttributes) {
	    String generatedOtp = (String) session.getAttribute("otp");
	    Long otpTime = (Long) session.getAttribute("otpTime");

	    if (generatedOtp == null || otpTime == null) {
	        redirectAttributes.addFlashAttribute("error", "OTP expired or not generated. Please start again.");
	        return "redirect:/userreg";
	    }

	    // Check if OTP is expired (5 minutes = 300,000 ms)
	    if ((System.currentTimeMillis() - otpTime) > 300000) {
	        redirectAttributes.addFlashAttribute("error", "OTP expired. Please request a new OTP.");
	        return "redirect:/resendOtp";
	    }

	    if (generatedOtp.equals(enteredOtp)) {
	        // OTP is valid; complete registration
	        Client c = new Client();
	        c.setFname((String) session.getAttribute("fname"));
	        c.setLname((String) session.getAttribute("lname"));
	        c.setEmail((String) session.getAttribute("email"));
	        c.setMobile((String) session.getAttribute("mobile"));
	        c.setLocation((String) session.getAttribute("location"));
	        c.setPassword((String) session.getAttribute("password"));
	        c.setDob((String) session.getAttribute("dob"));
	        c.setGender((String) session.getAttribute("gender"));

	        String ack = clientService.addClient(c); // Save client to database
	        redirectAttributes.addFlashAttribute("success", ack);

	        // Clear session attributes after successful registration
	        session.invalidate();
	        return "redirect:/login";
	    } else {
	        redirectAttributes.addFlashAttribute("error", "Invalid OTP. Please try again.");
	        return "redirect:/verifyOtp";
	    }
	}
	
	@GetMapping("/resendOtp")
	public String resendOtp(HttpSession session, RedirectAttributes redirectAttributes) {
	    String email = (String) session.getAttribute("email");

	    if (email == null) {
	        redirectAttributes.addFlashAttribute("error", "No email found. Please restart the process.");
	        return "redirect:/userreg";
	    }

	    String otp = OtpUtil.generateOtp();
	    long otpGenerationTime = System.currentTimeMillis(); // Update OTP time

	    session.setAttribute("otp", otp);
	    session.setAttribute("otpTime", otpGenerationTime);

	    emailService.sendOtp(email, otp);
	    redirectAttributes.addFlashAttribute("success", "A new OTP has been sent to your email!");
	    return "redirect:/verifyOtp";
	}





	
	

}
