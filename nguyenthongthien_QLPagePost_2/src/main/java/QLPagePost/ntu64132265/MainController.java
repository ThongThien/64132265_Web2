package QLPagePost.ntu64132265;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	public <T extends Identifiable> Optional<T> findById(List<T> list, int id) {
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
	
	@GetMapping("/page/view/{id}")
	public String pageView(@PathVariable int id, Model model) {
		findById(pages, id).ifPresent(page -> model.addAttribute("page",page));
		return "page-view";
	}
	
	@GetMapping("/page/delete/{id}")
	public String pageDelete(@PathVariable int id) {
		pages.removeIf(page -> page.getId() == id);
		return "redirect:/page/all";
	}
	
	@GetMapping("page/edit/{id}")
	public String pageEdit(@PathVariable int id, Model model) {
		findById(pages,id).ifPresent(page -> model.addAttribute("page", page));
		return "page-edit";
	}
	
	@PostMapping("/page/update/{id}")
	public String updatePage(
			@PathVariable int id,
			@RequestParam String pageName,
			@RequestParam String keyword,
			@RequestParam String content,
			@RequestParam int parentPageId ) {
		findById(pages, id).ifPresent(page -> {
			page.setPageName(pageName);
			page.setContent(content);
			page.setKeyword(keyword);
			page.setParentPageId(parentPageId);
		});
		return "redirect:/page/all";
	}
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
	
	@GetMapping("/post/delete/{id}")
	public String postDelete(@PathVariable int id) {
		posts.removeIf(post -> post.getId() == id);
		return "redirect:/post/all";
	}
	
	@GetMapping("/post/view/{id}")
	public String postView(@PathVariable int id, Model model) {
		findById(posts, id).ifPresent(post -> model.addAttribute("post",post));
		return "post-view";
	}
	
	@GetMapping("post/edit/{id}")
	public String postEdit(@PathVariable int id, Model model) {
		findById(posts,id).ifPresent(post -> model.addAttribute("post", post));
		return "post-edit";
	}
	
	@PostMapping("/post/update/{id}")
	public String updatePost(
			@PathVariable int id,
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam int categoryId  ) {
		findById(posts, id).ifPresent(post -> {
			post.setContent(content);
			post.setCategoryId(categoryId);
			post.setTitle(title);
		});
		return "redirect:/post/all";
	}
}
