package weibo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weibo.dashboard.controller.PostController;
import com.weibo.dashboard.entity.Post;
import com.weibo.dashboard.service.PostService;
import com.weibo.util.ResponseData;

import sun.net.www.content.text.plain;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration (locations={"classpath:conf/applicationContent.xml"})
//@WebAppConfiguration 
public class PostControllerTest {

//	@Autowired
//	private WebApplicationContext wac;
	private ObjectMapper objectMapper;
	private MockMvc mockMvc;
	
	@Mock
	private PostService postService;
	
	@InjectMocks
	private PostController postController;
	
	@Before
	public void setUp(){
		 MockitoAnnotations.initMocks(this);
		 this.mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
	}
	@Test
	public void testFindList() throws Exception{
//		ObjectMapper mapper = new ObjectMapper();
		
		List<Post> list = new ArrayList<Post>();
		Post p = new Post();
		p.setAuthorName("123");
//		p.setCommentList(commentList);
		p.setContent("123");
		p.setDate(new Date());
		p.setDisLikes(2);
		p.setLikes(23);
		p.setId(123123);
		list.add(p);
//		String str = mapper.writeValueAsString(list);
		
		when(postService.findList()).thenReturn(list);
		
		this.mockMvc.perform(get("/post/show")
				.accept(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andDo(print()).andReturn().getResponse().getContentAsString();
			
		verify(postService, times(1)).findList();
//		verifyNoMoreInteractions(postService);
	}
	
	@Test
	public void testadd() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		
		Post p = new Post();
		p.setAuthorName("zhao");
		p.setContent("nininini");
		p.setDate(new Date());
		p.setDisLikes(21);
		p.setLikes(21);
		p.setId(12345);
		
//		ResponseData rd = new ResponseData(p);
		String str = mapper.writeValueAsString(p);
		
		when(postService.insert(p)).thenReturn(123);
		
		this.mockMvc.perform(post("/post/new")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(str))
		.andExpect(status().isOk())
		.andDo(print()).andReturn().getResponse().getContentAsString();
		
		verify(postService, times(1)).insert(refEq(p));
	}
}
