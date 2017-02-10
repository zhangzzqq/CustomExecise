package com.example.filedelete;

import java.io.File;

public class FileDeleteTest {


	private static final String FILEPATH = "D:"+File.separator+"新建文件夹 - 副本";
	public static void main(String[] args) {
		// TODO Auto-generated method stub


//		FileUtils.deleteFile(new File(FileUtils.NEW_PATH));


		deleteFile(new File(FILEPATH));

	}


	private static void deleteFile(File file){

		if(file.exists()==false){

			return;
		}else{

			//是否是一个标准的文件夹
			if(file.isFile()){

				file.delete();
				return;
			}
			if(file.isDirectory()){

				//是否是一个目录

				File [] childFile = file.listFiles();
				if(childFile.length==0||childFile==null){
					file.delete();
					return;
				}

				for(File f :childFile){

					//删除子childFile文件
					deleteFile(f);
				}
				//删除父文件
				file.delete();
			}
		}

	}

}
