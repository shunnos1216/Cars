package sbpayment.jp.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Carscontroller {

	
	@GetMapping("/index")
	public String index(Model model) {
	return "index";
	}
	
	@GetMapping("/insert/{type}")//indexよりinsertページ遷移・車種別のID取得
	
	public String insert(@PathVariable("type") String type, Model model) {
		
		System.out.println("type:" + type);	//車種別のID取得確認
		

	return "insert";
	}
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@PostMapping("/post") //ユーザー情報取得
	public String Post(int income, int rent, int utility_c, int commu_c, RedirectAttributes attr){
	    
		System.out.println("checked PM1");//確認用
		
		attr.addFlashAttribute("income", income);
	    attr.addFlashAttribute("rent", rent);
	    attr.addFlashAttribute("utility_c", utility_c);
	    attr.addFlashAttribute("commu_c", commu_c);
	    
	    System.out.println(income);
	    System.out.println(rent);
	    System.out.println(utility_c);
	    System.out.println(commu_c);//確認用2
	    
		jdbc.update("INSERT INTO userspec (income,rent,utility_c,commu_c) values(?,?,?,?);",
				income,rent,utility_c,commu_c); //DB userspec TABLEに格納
		
		//jdbc.update("UPDATE userspec SET income = ?,rent = ?, utility_c = ? , commu_c = ?", 
			//	income, rent, utility_c, commu_c);
	
		attr.addFlashAttribute("users",jdbc.queryForList("SELECT * FROM userspec"));
	    // where でユーザーid指定
	    
	    
		return "redirect:/result";
		
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










