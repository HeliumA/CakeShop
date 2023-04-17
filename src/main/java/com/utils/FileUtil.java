package com.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
* 一个文件处理工具类
* 其中包含一个方法用于将文件转换为二进制数组。
* 接收一个 File 类型的参数，表示要转换的文件，然后将文件的内容读取到一个 InputStream 流中
* 再利用 ByteArrayOutputStream 流将数据转换为二进制数组，并返回该数组
*/

public class FileUtil {
	
	/**
	* 将传入的 File 对象转换为 byte 数组
	*/
	public static byte[] FileToByte(File file) throws IOException {
		
		@SuppressWarnings("resource")
		
		//从文件中读取数据并将其转换为流
		InputStream content = new FileInputStream(file);
		
		//创建一个 ByteArrayOutputStream 对象，用于缓存数据
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		
		//从流中读取数据，每次最多读取 100 个字节
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = content.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		
		//将 ByteArrayOutputStream 转换为 byte 数组并返回
		return swapStream.toByteArray();
	}
}
