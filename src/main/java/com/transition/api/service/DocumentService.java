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

import com.transition.api.customException.UserNotFoundException;
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
	
	
	//save document for user 
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

		//find all documents for user by user Id
		public List<Document> findAllDocuments(long userId) {
			return documentRepo.findAllByUserUserId(userId);
		}

       //delete document by docId
		public void deleteDoc(long docId) {
			 documentRepo.findById(docId).orElseThrow(()-> new UserNotFoundException("Document with Id "+docId+" not found"));
			 documentRepo.deleteById(docId);
		}

		//update particular document by docId
		public void updateDocumentByID(long docId , MultipartFile file) throws IOException {
		Optional<Document> doc =documentRepo.findById(docId);
		if(doc.isPresent()) {
			Document getDoc =  doc.get();
			
			String existingFilePath = getDoc.getUserDocPath();
			
			if(existingFilePath!=null) {
				File existingFile = new File(existingFilePath);
				if(existingFile.exists()) {
					existingFile.delete();
				}
			}
			
			  byte[] bytes = file.getBytes();
	            Path path = Paths.get(uploadDir + File.separator + "document_" + docId + "_" + file.getOriginalFilename());
	            Files.write(path, bytes);

	            getDoc.setUserDocPath(path.toString());
	            documentRepo.save(getDoc);
			
		}
			
		}
		
		
}
