package upload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyPathConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// url -- 폴더 매핑 저장소
		registry.addResourceHandler("/upload/**")
		.addResourceLocations(UploadInform.uploadLocation);  
		// .addResourceLocations("file:///usr/mydir/upload/");  
		// 리눅스에선 /usr/mydir/upload 로 변경 필요
		
	}
	
}
