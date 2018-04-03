package restful;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 表现层状态转换
 * 1.操作Resources资源：文本(txt.html.json.xml.二进制)、图片、服务、音频等
 * 2.http协议:
 * 		get-获取资源
 * 		post-创建资源
 * 		put-创建（更新）资源
 * 		delete-删除资源
 * 3.可使用Restlet Client插件模拟请求
 * @author wsz
 * @date 2018年4月3日
 */
@Controller
public class RestfulController {
	
	/**
	 * 获取所有book资源
	 */
	@ResponseBody
	@RequestMapping(value="/book", method= RequestMethod.GET)
	public String book(HttpServletRequest request) {
		String contentType = request.getContentType();
		if("txt".equals(contentType)) {
			return "book.txt";
		}else if("html".equals(contentType)) {
			return "book.html";
		}
		return "book.default";
	}
	
	/**
	 * 获取资源
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/book/{bookId}", method=RequestMethod.GET)
	public String bookGet(@PathVariable("bookId")String bookId) {
		return "Get method,bookId:"+bookId;
	}
	
	/**
	 * 创建资源
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/book/{bookId}", method=RequestMethod.POST)
	public String bookPost(@PathVariable("bookId")String bookId) {
		return "Post method,bookId:"+bookId;
	}
	
	/**
	 * 更新资源
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/book/{bookId}", method=RequestMethod.PUT)
	public String bookPut(@PathVariable("bookId")String bookId) {
		return "Put method,bookId:"+bookId;
	}
	
	/**
	 * 删除资源
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/book/{bookId}", method=RequestMethod.DELETE)
	public String bookDelete(@PathVariable("bookId")String bookId) {
		return "Delete method,bookId:"+bookId;
	}
	
	
}
