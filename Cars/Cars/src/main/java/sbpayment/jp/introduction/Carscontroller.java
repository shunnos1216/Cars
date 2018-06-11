package sbpayment.jp.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Carscontroller {
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@PostMapping("/post")
	public String Post(int income, int rent, int utility_c, int commu_c, RedirectAttributes attr){
	    
		
		
		attr.addFlashAttribute("income", income);
	    attr.addFlashAttribute("rent", rent);
	    attr.addFlashAttribute("utility_c", utility_c);
	    attr.addFlashAttribute("commu_c", commu_c);
	    
	    
		jdbc.update("INSERT INTO userspec (income,rent,utility_c,commu_c) values(?,?,?,?);",
				income,rent,utility_c,commu_c);
		jdbc.update("UPDATE userspec SET income = ?,rent = ?, utility_c = ? , commu_c = ?", 
				income, rent, utility_c, commu_c);
		
		model.addFlashAttribute("users",jdbc.queryForList("SELECT * FROM userspec"));
	    
	    
	    
	    return "redirect:/insert";
		
	}
	
	
	
	
	
	
	
//	@GetMapping("/form")
//	public String sample(int income, int rent, int utility_c, int commu_c, Model model) {
//		
//		int budget;//予算
//		
//		model.addAttribute("income", income);
//		model.addAttribute("rent", rent);
//		model.addAttribute("utility_c", utility_c);
//		model.addAttribute("commu_c", commu_c);
//		
//		
//		budget = income - ( rent + utility_c + commu_c);
//		
//		
//
//		jdbc.update("INSERT into userspec (income,rent,utility_c,commu_c, budget) values(?,?,?,?,?);", income,rent,utility_c,commu_c);
//		
//		model.addAttribute("users",jdbc.queryForList("SELECT * FROM userspec"));
//		
//		
//
//	return "index";
//	}

}










