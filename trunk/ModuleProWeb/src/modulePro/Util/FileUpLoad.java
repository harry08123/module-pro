package modulePro.Util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUpLoad {
	//private String uploadPath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\ModulePro_v0.0\\print\\";
	private String uploadPath = "E:\\dev\\workspace\\ModulePro\\WebContent\\print\\";
	
	public FileUpLoad() {}
	
	public FileUpLoad(String uploadPath){
		this.uploadPath = uploadPath;
	}

	public String fileUpLoad(MultipartHttpServletRequest request){
		String originalFileName = "";
		String saveFileName = "";
		File dir = new File(uploadPath);
		if(!dir.isDirectory()) dir.mkdirs();
		
		Iterator<String> iter = request.getFileNames();
		while(iter.hasNext()){
			String uploadFileName = iter.next();
			
			MultipartFile file = request.getFile(uploadFileName);
			originalFileName = file.getOriginalFilename();
			saveFileName = originalFileName;
			
			if(saveFileName != null && !"".equals(saveFileName)){
				if(new File(uploadPath + saveFileName).exists()){
					String fileNameSplit[] = saveFileName.split("\\.");
					String newFileName = "";
					for(int i=0; i<fileNameSplit.length-1; i++){
						newFileName+=fileNameSplit[i];
					}
					newFileName+="_"+System.currentTimeMillis();
					saveFileName = newFileName+"."+fileNameSplit[fileNameSplit.length-1];
				}
				try {
					file.transferTo(new File(uploadPath + saveFileName));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return saveFileName;
	}
}
