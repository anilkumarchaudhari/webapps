package com.java.springboot.SpringBootApps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.entity.Author;
import com.java.springboot.entity.Post;
import com.java.springboot.repository.AuthorRepository;
import com.java.springboot.repository.PostRepository;
import com.java.springboot.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	PostRepository postRepository;

	@Autowired
	AuthorRepository authorRepository;

	@RequestMapping("/")
	public Iterable<Post> findAll(){
		return postRepository.findAll();
	}
	
	@RequestMapping("/byAuthor/{first}")
	public List<Post> byAuthor(@PathVariable("first") String first){
		return postService.findAllByAuthorFirstName(first);
	}
	
	@RequestMapping("/slug/{slug}")
	public Post findPostBySlug(@PathVariable(value="slug") String slug ) {
		return postService.findPostBySlug(slug);
	}
	@RequestMapping("/slug/query/{slug}")
	public Post findPostBySlugQuery(@PathVariable(value="slug") String slug ) {
		return postService.findPostBySlugQuery(slug);
	}
	@RequestMapping("/slug/queryparam/{slug}")
	public Post findPostBySlugQueryParam(@PathVariable(value="slug") String slug ) {
		return postService.findPostBySlugQueryParam(slug);
	}
	
	@RequestMapping("/active")
	public List<Post> findPostByActive() {
		return postService.findActivePost(true);
	}
	
	@RequestMapping("/inactive")
	public List<Post> findPostByInActive() {
		return postService.findInActivePost();
	}
	
	@RequestMapping("/byKeyword/{keyword}")
	public List<Post> byKeyword( @PathVariable(value="keyword") String keyword ) {
		return postService.byKeyword(keyword);
	}
	
	@RequestMapping("/byKeyword/all/{keyword}")
	public List<Post> byKeywordLike( @PathVariable(value="keyword") String keyword ) {
		return postService.byKeywordLike(keyword);
	}
	
	  @RequestMapping("/author/{firstname}/keyword/{keyword}")
	  public List<Post>PostByAuthorFirstNameAndKeywords( @PathVariable(value="firstname") String firstname, @PathVariable(value="keyword") String keyword ) { 
		  return postService.PostByAuthorFirstNameAndKeywords(firstname,keyword); 
	  }
	 


	@PostConstruct
	public void loadData() {

		//delete existing data
		authorRepository.deleteAll();
		postRepository.deleteAll();
		//create Author
		Author au=new Author("Dan","Vega","danvega@gmail.com");
		authorRepository.save(au);

		//create posts
		createPosts(au);
	}
	private void createPosts(Author author) {

		Date yesterday = null;
		try {
			yesterday = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").parse("12/18/2015 12:00:00 PM");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Post post = new Post("Spring Data Rocks!");
		post.setSlug("spring-data-rocks");
		post.setTeaser( getTeaser() );
		post.setBody( getBody() );
		post.setPostedOn( yesterday );
		post.setKeywords( getSpringKeywords() );
		post.setActive(false);
		post.setAuthor( author );
		postRepository.save(post);

		Post grails = new Post("Grails is awesome!");
		grails.setSlug("grails-is-awesome");
		grails.setTeaser( getTeaser() );
		grails.setBody( getBody() );
		grails.setPostedOn( new Date() );
		grails.setKeywords( getGrailsKeywords() );
		grails.setActive(true);
		grails.setAuthor( author );
		postRepository.save(grails);

		Post trails = new Post("Trail is awesome!");
		trails.setSlug("trails-is-awesome");
		trails.setTeaser( getTeaser() );
		trails.setBody( getBody() );
		trails.setPostedOn( new Date() );
		trails.setKeywords( getTrailKeywords() );
		trails.setActive(true);
		trails.setAuthor( author );
		postRepository.save(trails);

	}

	private List<String> getSpringKeywords(){
		List<String> keywords = new ArrayList<String>();
		keywords.add("Spring");
		keywords.add("Spring Data");
		return keywords;
	}
	private List<String> getTrailKeywords(){
		List<String> keywords = new ArrayList<String>();
		keywords.add("Spring JPA");
		keywords.add("Spring JDBC");
		return keywords;
	}

	private List<String> getGrailsKeywords(){
		List<String> keywords = new ArrayList<String>();
		keywords.add("Grails");
		keywords.add("Groovy");
		return keywords;
	}

	private String getTeaser(){
		return "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam et euismod tortor. Pellentesque sed neque a magna sagittis placerat. Donec nisi dolor, efficitur nec dictum sit amet, sollicitudin consequat tortor. Integer a tincidunt erat, non tempor nisi. Duis quis ex ut tellus sagittis accumsan. Curabitur vehicula, dui ac aliquam sodales, lacus augue egestas odio, ac porttitor ipsum orci nec lectus. Maecenas maximus libero quam, eu mollis tellus blandit vitae.</p>";
	}

	private String getBody(){
		String body = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt et turpis non lobortis. Nullam pellentesque magna eros, et ultricies elit aliquet ut. Nunc et eros ligula. In purus nunc, iaculis quis aliquet ut, rutrum sed dolor. Proin ante turpis, euismod nec varius id, dapibus vel nisi. In bibendum mi in metus ultricies, fringilla gravida mi cursus. Integer nec sapien libero. Ut arcu ex, volutpat sed ex finibus, sodales efficitur eros. Sed sapien justo, tincidunt nec pharetra non, ultricies ac nunc. Mauris ac semper dui. Sed eleifend sit amet erat accumsan suscipit. Aliquam sit amet ipsum mauris. Maecenas sollicitudin, nibh sagittis vulputate tincidunt, neque neque vehicula augue, et lacinia dui nisi vulputate velit. Maecenas sit amet augue interdum, suscipit velit malesuada, fermentum orci.</p>";
		body += "<p>In sit amet mi sollicitudin, iaculis erat venenatis, fringilla turpis. Suspendisse potenti. Curabitur sed molestie eros. Phasellus ultrices, nisi a egestas commodo, ante nisl lobortis diam, at molestie quam lorem eget tellus. Maecenas venenatis sapien ut euismod tempus. Nunc gravida vitae ante faucibus iaculis. Donec nulla dolor, placerat sit amet iaculis at, ornare quis turpis. Proin pharetra vel massa at vulputate. Phasellus efficitur pretium auctor. Mauris tincidunt velit metus, ac varius ante porta vel.</p>";
		body += "<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec quis diam elementum, feugiat elit a, vestibulum neque. Proin in augue fringilla, sollicitudin dolor vel, fringilla libero. Aenean iaculis ante ligula, sit amet maximus ante viverra at. Quisque auctor arcu et ante consectetur vulputate. Suspendisse iaculis libero eu enim eleifend, non mattis leo aliquet. Fusce id nibh euismod, convallis leo ac, rutrum arcu. Nullam at urna commodo diam pharetra vulputate sed vitae mi. Aenean molestie ante nec finibus aliquet. Suspendisse ac turpis vehicula, semper tortor sit amet, sollicitudin ante. Morbi vehicula sem non elit tempor molestie. In convallis, quam ut porta sagittis, tortor nibh euismod dolor, eget sollicitudin massa mauris nec mi. Proin consectetur lacinia commodo. Quisque at consectetur velit. Pellentesque vel sagittis orci, sed scelerisque diam.</p>";
		return body;
	}

}
