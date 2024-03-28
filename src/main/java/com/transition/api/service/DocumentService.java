package com.transition.api.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.transition.api.customException.CustomNotFoundException;
import com.transition.api.entity.Document;
import com.transition.api.entity.UserProfile;
import com.transition.api.repository.DocumentRepository;
import com.transition.api.repository.UserProfileRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepo;

	@Autowired
	private UserProfileRepository userProfileRepo;

	@Value("${upload.dir}")
	private String uploadDir;

	// save document for user
	public void uploadDocument(long userId, MultipartFile file) throws IOException {
		if(file.getSize()>1*1024*1024) {
			throw new IllegalArgumentException("File Size excceeds the max limit of 5MB");
		}
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
		if (checkUser.isPresent()) {
			String filePath = path.toString();
			Document document = new Document();
			document.setUserDocPath(filePath);
			UserProfile user = checkUser.get();
			document.setUser(user);
			documentRepo.save(document);
			log.info("User profile image uploaded successfully for user ID: {}" + userId);
		} else {
			log.error("Error while uploading Document for UserId : {}" + userId);
			throw new IllegalArgumentException("User with ID " + userId + " not found.");
		}
	}

	// find all documents for user by user Id
	public List<Document> findAllDocuments(long userId) {
		Optional<UserProfile> user = userProfileRepo.findById(userId);
		if (user.isPresent()) {
			log.info("Getting All Documents for UserId : {}" + userId);
			return documentRepo.findAllByUserUserId(userId);
		} else {
			log.error("Error while Getting Documents for UserId : {}" + userId);
			throw new IllegalArgumentException("User with ID " + userId + " not found.");
		}
	}

	// delete document by docId
	public void deleteDoc(long docId) {
		documentRepo.findById(docId)
				.orElseThrow(() -> new CustomNotFoundException("Document with Id " + docId + " not found"));
		log.debug("Deleting document for DocId :{}" + docId);
		documentRepo.deleteById(docId);
	}

	// update particular document by docId
	public void updateDocumentByID(long docId, MultipartFile file) throws IOException {
		Optional<Document> doc = documentRepo.findById(docId);
		if (doc.isPresent()) {
			Document getDoc = doc.get();

			String existingFilePath = getDoc.getUserDocPath();

			if (existingFilePath != null) {
				File existingFile = new File(existingFilePath);
				if (existingFile.exists()) {
					existingFile.delete();
				}
			}

			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadDir + File.separator + "document_" + docId + "_" + file.getOriginalFilename());
			Files.write(path, bytes);
			getDoc.setUserDocPath(path.toString());
			log.debug("Updating document for docId : {}" + docId);
			documentRepo.save(getDoc);

		}

	}

	//download doc in zip format
	public ResponseEntity<Object> getAllDocumentsInZip(long userId) throws IOException {
		//retrive all doc assotiated with user
		List<Document> documents = findAllDocuments(userId);
		if (documents.isEmpty()) {
			log.info("No document found for userId : "+userId);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid User Id");
		}
		
		//created ByteArrayOutputStream to hold the content of zip file content
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		//created a zipoutputstream to write the content in byteoutputstream
		ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
		try {

			for (int i = 0; i < documents.size(); i++) {
				Document document = documents.get(i);
				File file = new File(document.getUserDocPath());

				if (file.exists()) {
					log.debug("Adding files to zip : "+file.getName());
					//if file exits create a fileinputstream to read its content
					FileInputStream fileInputStream = new FileInputStream(file);
					try {
						//create a new zipentry for the file in the zip archive
						ZipEntry zipEntry = new ZipEntry(file.getName());
						zipOutputStream.putNextEntry(zipEntry);
						
						//read the file content and write it to zip entry 
						byte[] buffer = new byte[1024];
						int length;
						while ((length = fileInputStream.read(buffer)) > 0) {
							zipOutputStream.write(buffer, 0, length);
						}
						//closing the current zipentry 
						zipOutputStream.closeEntry();
					} finally {
						//closing fileinputstream
						fileInputStream.close();
					}

				}
			}
		} finally {
			//closing zipoutputstream 
			zipOutputStream.close();
		}

		HttpHeaders headers = new HttpHeaders();
		//content type is used for download and it tells data is binary
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//the content should treated as attachment and provide file name to attachment 
		headers.setContentDispositionFormData("attatchment", "user_" + userId + "_documents.zip");

		log.info("Returning all documents in zip file for user with Id : "+userId);
		return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
	}

	//view doc in bytes 
	public ResponseEntity<Object> viewUserDocument(long userId, long docId) {
		
		Optional<Document> documentCheck = documentRepo.findById(docId);
		if(documentCheck.isPresent()) {
			Document document = documentCheck.get();
			byte[] documentContent = null;
			try {
				documentContent = Files.readAllBytes(Paths.get(document.getUserDocPath()));
			} catch (IOException e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while viewing document");
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("filename", "doxument_" +docId+".bin");
			return new ResponseEntity<>(documentContent, headers, HttpStatus.OK);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
