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
	
	@GetMapping("/balance/{type}")//indexよりinsertページ遷移・車種別のID取得
	
	public String insert(@PathVariable("type") String type, Model model) {
		
		System.out.println("type:" + type);	//車種別のID取得確認
		

	return "balance";
	}
	
	
	@GetMapping("/result")
	public String result(Model model) {
	
		return "result";
	
	}
	
	@GetMapping("/cost")
	public String insert2(Model model) {
	
		return "cost";
	
	}
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@PostMapping("/post") //ユーザー収支情報取得 balance.html TABLE userspec
	public String Post(String user_name,double income, double rent, double utility_c, double commu_c, RedirectAttributes attr){
	    
		
		System.out.println("checked PM1");//確認用
		
		
		attr.addFlashAttribute("user_name", user_name);
		 
		
//		attr.addFlashAttribute("income", income);
//	    attr.addFlashAttribute("rent", rent);
//	    attr.addFlashAttribute("utility_c", utility_c);
//	    attr.addFlashAttribute("commu_c", commu_c);
//	    
//		System.out.println(user_name);
//	    System.out.println(income);
//	    System.out.println(rent);
//	    System.out.println(utility_c);
//	    System.out.println(commu_c);//確認用2
	    
		jdbc.update("INSERT INTO userspec (user_name,income,rent,utility_c,commu_c) values(?,?,?,?,?);",
				user_name,income,rent,utility_c,commu_c); //DB userspec TABLEに格納
		
		//jdbc.update("UPDATE userspec SET income = ?,rent = ?, utility_c = ? , commu_c = ?", 
			//	income, rent, utility_c, commu_c);
	
		//attr.addFlashAttribute("users",jdbc.queryForMap("SELECT * FROM userspec"));
	    // where でユーザーid指定 1レコードを持ってきたいから queryMap
	    
	    
		return "redirect:/cost";
		 
	}
	
	@PostMapping("/post2") //ユーザー情報取得2 cost.html TABLE user_cost
	public String Post2(String user_name,double parking, double running, int loan, RedirectAttributes attr){
	    
		System.out.println("checked PM2");//確認用
		
		System.out.println(user_name);
		
		attr.addFlashAttribute("parking", parking);
	    attr.addFlashAttribute("running", running);
	    attr.addFlashAttribute("loan", loan);

	    
	    System.out.println(parking);
	    System.out.println(running);
	    System.out.println(loan);//確認用2

	    jdbc.update("UPDATE userspec SET parking = ?,running = ?, loan = ?  ", parking,running,loan);
	    
	    //jdbc.update("UPDATE userspec SET parking = ?,running = ?, loan = ? WHERE user_name = user_ name ", parking,running,loan);
	    
		return "redirect:/result";
	}
	
	
	
}
	
	









