package com.blogs.apis.service.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.blogs.apis.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// Get File name

		String name = file.getOriginalFilename();
		// Random name generate
		String randamId = UUID.randomUUID().toString();
		String filName1 = randamId.concat(name.substring(name.lastIndexOf(".")));

		// Full Path

		String filePath = path + File.separator + filName1;

		// create folder if not created

		File f = new File(path);
		if (!f.exists()) {

			f.mkdir();
		}

		// File Copy

		Files.copy(file.getInputStream(), Paths.get(filePath));

		return filName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path + File.separator + fileName;
		InputStream is = new FileInputStream(fullPath);

		return is;
	}

}
