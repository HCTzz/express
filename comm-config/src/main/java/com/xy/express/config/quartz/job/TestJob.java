  
package com.xy.express.config.quartz.job;

import com.xy.express.config.quartz.JncStateJob;
import com.xy.express.config.quartz.service.TestService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;


/** 
 * Date:     2019年7月24日 下午12:41:11
 * @author   HeHaifeng  
 */
public class TestJob implements JncStateJob {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			ServletContext sevletContext = (ServletContext)context.getScheduler().getContext().get("context");
			ApplicationContext application = WebApplicationContextUtils.getWebApplicationContext(sevletContext);
			TestService testService = (TestService) application.getBean("testService");
			testService.test();
		}catch(Exception e) {
			
		}
	}

}
 