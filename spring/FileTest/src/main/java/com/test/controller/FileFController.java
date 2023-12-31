package com.test.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileFController {

	@GetMapping("/add.do")
	public String add() {
		
		
		return "add";
	}
	
	@PostMapping("/addok.do")
	public String addok(Model model, String txt, MultipartFile attach, HttpServletRequest req) {
		
		System.out.println(attach.getName()); // 태그의 이름
		System.out.println(attach.getOriginalFilename()); //업로드되는 파일의 이름
		System.out.println(attach.getContentType()); //파일의 종류
		System.out.println(attach.getSize());//사이즈
		System.out.println(attach.isEmpty());//첨부파일 유무
		
		String path = req.getRealPath("/resources/files");
		System.out.println(path);
		
		try {
			//파일명 중복 방지
			//1. 숫자 붙이기
			//2. 고유 파일명 만들기
			//  - 시간_파일명
			//  - 난수_파일명
			//3. UUID - Universally Unique > 네트워크 상에서 고유성이 보장되는 ID를 만들기 위한 표준
			// - 시간 + 난수 조합
			
			UUID uuid = UUID.randomUUID();
			
			File file = new File(path+"\\"+uuid+" "+attach.getOriginalFilename());
			attach.transferTo(file);
			
			model.addAttribute("txt",txt);
			model.addAttribute("filename",uuid+" "+attach.getOriginalFilename());
			model.addAttribute("orgfilename",attach.getOriginalFilename());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "addok";
	}
	
	@PostMapping("/multiaddok.do")
	public String multiaddok(Model model, String txt, MultipartFile[] attach, HttpServletRequest req) {
		
		for(MultipartFile file : attach) {
			System.out.println(file.getName()); // 태그의 이름
			System.out.println(file.getOriginalFilename()); //업로드되는 파일의 이름
			System.out.println(file.getContentType()); //파일의 종류
			System.out.println(file.getSize());//사이즈
			System.out.println(file.isEmpty());//첨부파일 유무
			System.out.println();
			
			try {
				UUID uuid = UUID.randomUUID();
				
				String filename = (uuid+" "+file.getOriginalFilename());
				file.transferTo(new File(req.getRealPath("/resources/files")+"\\"+filename));
				model.addAttribute("filename",uuid+" "+file.getOriginalFilename());
				model.addAttribute("orgfilename",file.getOriginalFilename());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("txt",txt);
		
		return "addok";
	}
	
	
	
	@GetMapping(value = "/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	   @ResponseBody
	   public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String filename, HttpServletRequest req) {

	      String path = req.getRealPath("/resources/files");
	      Resource resource = new FileSystemResource(path + "\\" + filename);

	      if (resource.exists() == false) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }

	      String resourceName = resource.getFilename();

	      // remove UUID
	      String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

	      HttpHeaders headers = new HttpHeaders();
	      try {

	         String downloadName = null;

	         if (userAgent.contains("Trident")) {
	            downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
	         } else if (userAgent.contains("Edge")) {
	            downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
	         } else {
	            downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
	         }


	         headers.add("Content-Disposition", "attachment; filename=" + downloadName);

	      } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	      }

	      return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	   }
}
