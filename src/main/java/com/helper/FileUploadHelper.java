package com.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class  FileUploadHelper  {

	public final String path=new ClassPathResource("static/img/").getFile().getAbsolutePath();

	public FileUploadHelper()throws IOException
	{
	}
	public boolean SaveFile(InputStream io,String filename)
	{
		boolean status=false;

		try {

			Files.copy(io,Paths.get(path+File.separator+filename), StandardCopyOption.REPLACE_EXISTING);

			status=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
