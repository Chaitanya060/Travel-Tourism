package com.klef.jfsd.springboot.controller;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Client;
import com.klef.jfsd.springboot.model.Destination;
import com.klef.jfsd.springboot.model.Hotels;
import com.klef.jfsd.springboot.repository.HotelRepository;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.ClientService;
import com.klef.jfsd.springboot.service.DestinationService;
import com.klef.jfsd.springboot.service.EmailService;
import com.klef.jfsd.springboot.service.HotelService;

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
	private HotelService hotelService;
	
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
	
	@GetMapping("/profile")
	public String ProfilePage(HttpSession session, Model model) {
	    // Retrieve the client object from the session
	    Client client = (Client) session.getAttribute("client");
	    
	    // Check if the client is logged in
	    if (client == null) {
	        return "redirect:/login"; // Redirect to login if not logged in
	    }
	    
	    // Pass the client object to the model for JSP access
	    model.addAttribute("client", client);
	    return "profile"; // Return the JSP page name
	}

//	@GetMapping("/profile")
//    public String ProfilePage() {
//        return "profile"; // JSP page name
//    }

	
	@PostMapping("/addclient")
	public ModelAndView addClient(HttpServletRequest request,RedirectAttributes redirectAttributes)
	{
		ModelAndView mv=new ModelAndView();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String gender=request.getParameter("gender");
		String dob = request.getParameter("dob");
		String location=request.getParameter("location");
		String password=request.getParameter("pwd1");
		Client c=new Client();
		c.setFname(fname);
		c.setLname(lname);
		c.setEmail(email);
		c.setMobile(mobile);
		c.setLocation(location);
		c.setPassword(password);
		c.setDob(dob);
		c.setGender(gender);
		String ack=clientService.addClient(c);
		mv.setViewName("redirect:/login");
		redirectAttributes.addFlashAttribute("ack", ack);
		return mv;
		
	}
	
//	@PostMapping("/checkclientlogin")
//	public ModelAndView checkClientLogin(HttpServletRequest request,RedirectAttributes redirectAttributes)
//	{
//		String email=request.getParameter("email");
//		String pswd=request.getParameter("pwd");
//		Client c= clientService.checkClientLogin(email, pswd);
//		ModelAndView mv=new ModelAndView();
//
//		if(c!=null)
//		{
//			mv.setViewName("redirect:/home");
//			//mv.addObject("ack","Login Success !");
//			//redirectAttributes.addFlashAttribute("ack", "Login Success !");
//			HttpSession session =request.getSession();
//			session.setAttribute("clientId",c.getId());
//			session.setAttribute("success", "Login Success !!");
//			return mv;
//		}
//		mv.setViewName("redirect:/login");
//		//mv.addObject("ack","Login Failed !");
//		redirectAttributes.addFlashAttribute("failure", "Login Failed !");
//		return mv;
//	}

	
	@PostMapping("/checkclientlogin")
	public ModelAndView checkClientLogin(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    String email = request.getParameter("email");
	    String pswd = request.getParameter("pwd");

	    // Validate client login using the service
	    Client client = clientService.checkClientLogin(email, pswd);
	    ModelAndView mv = new ModelAndView();

	    if (client != null) {
	        // Login successful
	        HttpSession session = request.getSession();
	        
	        // Store the full client object in the session
	        session.setAttribute("client", client);
	        
	        // Redirect to the home page or profile
	        mv.setViewName("redirect:/home"); // Or "redirect:/profile/" + client.getFname();
	        return mv;
	    }

	    // Login failed
	    mv.setViewName("redirect:/login");
	    redirectAttributes.addFlashAttribute("failure", "Invalid email or password!");
	    return mv;
	}

	
	@GetMapping("/home")
	public ModelAndView clientHome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("clientId") != null) {
			mv.setViewName("home");
			return mv;
		}
	    mv.setViewName("redirect:/login");
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
	
	@GetMapping("/admindashboard")
    public String AdminDashboardPage() {
        return "admindashboard"; // JSP page name
    }
	
	// this ia the destination files
	
	@GetMapping("adddestination")
	   public ModelAndView adddestination()
	   {
		   ModelAndView mv = new ModelAndView("adddestination");
		   return mv;
	   }
	
	 @PostMapping("insertdestination")
	   public ModelAndView insertproductdemo(HttpServletRequest request,@RequestParam("placeimage") MultipartFile file) throws IOException, SerialException, SQLException
	   {
		   String msg = null;
		   
		   ModelAndView mv = new ModelAndView();
		   
		   try
		   {
		   
		   String place = request.getParameter("place");
		   String description = request.getParameter("description");
		   String rating = request.getParameter("rating");
		   
		   
			  byte[] bytes = file.getBytes();
			  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			  
			  Destination d = new Destination();
			  d.setPlace(place);
			  d.setDescription(description);
			  d.setRating(rating);
			  d.setPlaceimage(blob);
			  
			  msg=destinationService.AddDestination(d);
			  System.out.println(msg);
			  mv.setViewName("destinationmsg");
			  mv.addObject("message",msg);
		   }	  
		   catch(Exception e)
		   {
			   msg = e.getMessage();
			   System.out.println(msg.toString());
			   mv.setViewName("destinationerror");
			   mv.addObject("message",msg);
		   }
		   return mv;
	   }
	 
	 @GetMapping("viewalldestination")
	   public ModelAndView viewalldestination()
	   {
		   List<Destination> destinationlist = destinationService.ViewAllDestination();
		   
		   ModelAndView mv = new ModelAndView("viewalldestination");
		   
		   mv.addObject("destinationlist", destinationlist);
		   
		   return mv;
	   }

	 @GetMapping("displayplaceimage")
	 public ResponseEntity<byte[]> displayplaceimage(@RequestParam("id") int id) throws IOException, SQLException
	 {
	   Destination destination =  destinationService.ViewDestinationByID(id);
	   byte [] imageBytes = null;
	   imageBytes = destination.getPlaceimage().getBytes(1,(int) destination.getPlaceimage().length());
	   return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	   
	 }
	 
	   @GetMapping("viewdestinationbyid")
	   public ModelAndView viewdestinationbyid()
	   {
	   	   List<Destination> destinationlist=destinationService.ViewAllDestination();
	   	   ModelAndView mv=new ModelAndView("viewdestinationbyid");
	   	   mv.addObject("destinationlist",destinationlist);
	   	   return mv;
	   }
	   @PostMapping("displaydestination")
	   public ModelAndView displaydestination(HttpServletRequest request) {
	       int did = Integer.parseInt(request.getParameter("did"));
	       Destination destination = destinationService.ViewDestinationByID(did);

	       ModelAndView mv = new ModelAndView("displaydestination");
	       mv.addObject("destination", destination);  // Ensure this matches "destination"
	       return mv;
	   }

	     
	      
	      
//	      from her the hotel one starts
	      
	      @GetMapping("addhotel")
	      public ModelAndView addhotel()
	      {
	   	   ModelAndView mv = new ModelAndView("addhotel");
	   	   return mv;
	      }
	      //MultipartFile to get images 
	      @PostMapping("inserthotel")
	      public ModelAndView inserthotel(HttpServletRequest request,@RequestParam("hotelimage") MultipartFile file) throws IOException, SerialException, SQLException
	      {
	   	   String msg = null;
	   	   
	   	   ModelAndView mv = new ModelAndView();
	   	   
	   	   try
	   	   {
	   	   String category = request.getParameter("category");
	   	   String hotelname = request.getParameter("hotelname");
	   	   String location = request.getParameter("location");
	   	   Double price = Double.valueOf(request.getParameter("price"));
	   	   Double rating = Double.valueOf(request.getParameter("rating"));
	   	   String description = request.getParameter("description");
	   	   
	   		  byte[] bytes = file.getBytes();
	   		  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
	   		  
	   		  Hotels h = new Hotels();
	   		  h.setCategory(category);
	   		  h.setHotelname(hotelname);
	   		  h.setDescription(description);
	   		  h.setPrice(price);
	   		  h.setHotelimage(blob);
	   		  h.setRating(rating);
	   		  h.setLocation(location);
	   		  
	   		  msg=hotelService.AddHotel(h);
	   		  System.out.println(msg);
	   		  mv.setViewName("hotelmsg");
	   		  mv.addObject("message",msg);
	   	   }	  
	   	   catch(Exception e)
	   	   {
	   		   msg = e.getMessage();
	   		   System.out.println(msg.toString());
	   		   mv.setViewName("hotelerror");
	   		   mv.addObject("message",msg);
	   	   }
	   	   return mv;
	      }
	      @GetMapping("viewallhotel")
	      public ModelAndView viewallhotel()
	      {
	   	   List<Hotels> hotellist = hotelService.ViewAllHotels();
	   	   
	   	   ModelAndView mv = new ModelAndView("viewallhotel");
	   	   
	   	   mv.addObject("hotellist", hotellist);
	   	   
	   	   return mv;
	      }
	      
	   @GetMapping("displayhotelimage")
	   public ResponseEntity<byte[]> displayhotelimagedemo(@RequestParam("id") int id) throws IOException, SQLException
	   {
	     Hotels hotel =  hotelService.ViewHotelByID(id);
	     byte [] imageBytes = null;
	     imageBytes = hotel.getHotelimage().getBytes(1,(int) hotel.getHotelimage().length());

	     return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	   }

	      @GetMapping("viewhotelbyid")
	   public ModelAndView  viewhotelbyid()
	   {
	   	   List<Hotels> hotellist=hotelService.ViewAllHotels();
	   	   ModelAndView mv=new ModelAndView("viewhotelbyid");
	   	   mv.addObject("hotellist",hotellist);
	   	   return mv;
	   }
	      
	      @PostMapping("displayhotel")
	      public ModelAndView displayhotel(HttpServletRequest request)
	      {
	   	   int hid=Integer.parseInt(request.getParameter("hid"));
	   	   Hotels hotel=hotelService.ViewHotelByID(hid);
	   	   ModelAndView mv=new ModelAndView("displayhotel");
	   	   mv.addObject("hotel",hotel);
	   	   return mv;
	      }
	      @GetMapping("viewhotelbycategory")
	      public ModelAndView viewhotelByCategory()
	      {
	   	   ModelAndView mv=new ModelAndView("viewhotelbycategory");
	   	   return mv;
	      }
	      @PostMapping("displayhotelbycategory")
	      public ModelAndView viewhotelByCategory(HttpServletRequest request)
	      {
	   	   String category=request.getParameter("category");
	   	   List<Hotels> hotellist=hotelService.viewAllHotelByCategory(category);
	   	   ModelAndView mv=new ModelAndView("displayhotelbycategory");
	   	   mv.addObject("hotellist",hotellist);
	   	   return mv;
	      } 

}
