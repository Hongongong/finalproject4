package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {

	
	// c:/fullstack/upload 파일 리스트 출력- 뷰 필요
	@RequestMapping("/filedownloadlist")
	ModelAndView downloadlist() {
		File f = new File("c:/fullstack/upload/");
		String [] filearray = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filearray", filearray);
		mv.setViewName("upload/downloadlist");
		return mv;
	}
	
	
	// 리스트에서 1개 파일 선택시 다운로드 - 뷰 불필요
	@RequestMapping("/filedownloadresult")
	void downloadresult(String filename, HttpServletResponse response) throws IOException {
		response.setContentType("application/download");
		//view 없다
		response.setContentLength( (int) (new File("c:/fullstack/upload/"+filename).length()) );
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(new File( "c:/fullstack/upload/"+filename )  );
		FileCopyUtils.copy(fin, out);
		fin.close();
		out.close();

	}
	
}





