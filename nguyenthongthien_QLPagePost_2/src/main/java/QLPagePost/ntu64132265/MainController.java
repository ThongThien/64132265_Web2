package QLPagePost.ntu64132265;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import QLPagePost.ntu64132265.models.Identifiable;
import QLPagePost.ntu64132265.models.Page;
import QLPagePost.ntu64132265.models.Post;

@Controller
public class MainController {
	
	List<Page> pages = new ArrayList<>(Arrays.asList(
		new Page(1,"Page A","A","ABCD",1),
		new Page(2,"Page B","A","BCD",2),
		new Page(3,"Page C","A","CD",3)
	));
	
	List<Post> posts = new ArrayList<>(Arrays.asList(
			new Post(1,"Post A","ABCD",1),
			new Post(2,"Post B","BCD",2),
			new Post(3,"Post C","CD",3)
	));
	
	<T extends Identifiable> Optional<T> findById(List<T> list, int id) {
		return list.stream().filter(item -> item.getId()==id).findFirst();
	}
	
//	***********************************************************************************	
	@GetMapping("/")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/page/all")
	public String pageAll(Model model) {
		model.addAttribute("pages", pages);
		return "page-list";
	}
	@GetMapping("/page/new")
	public String pageNew(Model model) {
		model.addAttribute("pages",new Page());
		return "page-addNew";
	}
	
	@PostMapping("/page/save")
	public String savePage(
			@RequestParam String pageName,
			@RequestParam String keyword,
			@RequestParam String content,
			@RequestParam int parentPageId) {
		Page newPage = new Page(pages.size()+1, pageName, keyword, content, parentPageId);
		pages.add(newPage);
		return "redirect:/page/all";
	}
	
//	@GetMapping("/page/view/{id}")
//	public String pageView() {
//		return "page-list";
//	}
//	@GetMapping("/page/delete/{id}")
//	public String pageDelete() {
//		return "page-list";
//	}
	
//	***********************************************************************************
	@GetMapping("/post/all")
	public String postAll(Model model) {
		model.addAttribute("posts", posts);
		return "post-list";
	}
	@GetMapping("/post/new")
	public String postNew(Model model) {
		model.addAttribute("posts",new Post());
		return "post-addNew";
	}
	
	@PostMapping("/post/save")
	public String savePost(
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam int categoryId ){
		Post newPost = new Post(pages.size()+1, title, content, categoryId);
		posts.add(newPost);
		return "redirect:/post/all";
	}
}
