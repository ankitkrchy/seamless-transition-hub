package com.transition.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.transition.api.entity.Document;
import com.transition.api.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private DocumentService docService;
	
		@PostMapping("/upload/{userId}")
		    public ResponseEntity<HttpStatus> uploadFile(@PathVariable long userId, @RequestParam("file") MultipartFile file) throws IOException {
			docService.uploadDocument(userId, file);
			String contentType = file.getContentType();
			if(contentType != null && (contentType.equals("application/pdf"))||
					(contentType.equals("application/msword"))||
					(contentType.equals("application/vnd.ms-excel"))
					) {
				return ResponseEntity.ok(HttpStatus.ACCEPTED);
			}
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);  
	    }
		
		@GetMapping("/get-document/{userId}")
		public List<Document> getAllDocumentsById(@PathVariable long userId){
			return docService.findAllDocuments(userId);
		}
}
