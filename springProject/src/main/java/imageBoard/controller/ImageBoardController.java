package imageBoard.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import imageBoard.bean.ImageBoardDTO;

@Controller
@RequestMapping(value="imageBoard")
public class ImageBoardController {

	@RequestMapping(value="imageBoardWriteForm", method=RequestMethod.GET)
	public String imageBoardWriteForm(Model model) {
		model.addAttribute("display", "/imageBoard/imageBoardWriteForm.jsp");
		
		return "/main/index";
	}
	
	// 1. 실제폴더 =  위치(실제폴더), 이름도 임시파일로(.tmp) 업로드되어 알아볼 수가 없다
	// 2. 실제폴더에 있는 파일 명(오리지널로 바꾸고)을 가상폴더(storage)로 복사시키기 
	// 3. imageBoardDTO의 image1에 값을 넣어준다 (그래야 dto를 가지고 db에 간다) >> controller에서 이뤄진다. 
	
	@RequestMapping(value="imageBoardWrite", method=RequestMethod.POST)
	public void imageBoardWrite(@ModelAttribute ImageBoardDTO imageBoardDTO, @RequestParam MultipartFile img) {
																			// 여기의 multipartfile의 이름을 view.jsp의 
																			// img 파일의 name과 같아야한다. 
		
		String filePath = "D:\\spring\\workSTS\\springProject\\src\\main\\webapp\\storage"; // 가상폴더 위치
		String fileName = img.getOriginalFilename(); // 오리지널 파일명으로 바꿈 
		File file = new File(filePath, fileName);
		
		// 파일 복사해서 가상폴더에 넣음
		try {
			// img에 있는 것을 내 file쪽으로 복사시킴
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		imageBoardDTO.setImage1(fileName);
	}
}
