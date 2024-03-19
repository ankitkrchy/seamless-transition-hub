package com.transition.api.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.transition.api.entity.Document;
import com.transition.api.entity.UserProfile;
import com.transition.api.repository.DocumentRepository;
import com.transition.api.repository.UserProfileRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepo;
	
	
	@Autowired
	private UserProfileRepository userProfileRepo;
	
	@Value("${upload.dir}")
    private String uploadDir;
	
		public void uploadDocument(long userId, MultipartFile file) throws IOException {
		    File directory = new File(uploadDir);
		    if (!directory.exists()) {
		        boolean created = directory.mkdirs();
		        if (!created) {
		            throw new IOException("Failed to create directory: " + uploadDir);
		        }
		    }
	
		    byte[] bytes = file.getBytes();
		    Path path = Paths.get(uploadDir + File.separator + "user_" + userId + "_" + file.getOriginalFilename());
		    Files.write(path, bytes);	    

		    Optional<UserProfile> checkUser = userProfileRepo.findById(userId);
		    if(checkUser.isPresent()) {
		    	String filePath = path.toString();
			    Document document =new Document();
			     document.setUserDocPath(filePath);
			     UserProfile user = checkUser.get();
			     document.setUser(user);
			    documentRepo.save(document);
		    }else {
		    	throw new IllegalArgumentException("User with ID " + userId + " not found.");
		    }  
		}

		
		public List<Document> findAllDocuments(long userId) {
			return documentRepo.findAllByUserUserId(userId);
		}
		
		
}
