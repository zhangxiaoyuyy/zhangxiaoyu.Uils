/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: FileUtilIO.java 
 * @Prject: zhangxiaoyu.Utils
 * @Package: zhangxiaoyu.FileUtil 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月30日 下午8:24:03 
 * @version: V1.0   
 */
package zhangxiaoyu.FileUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName: FileUtilIO
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月30日 下午8:24:03
 */
public class FileUtilIO {

	/**
	 * 
	 * @Title: writerFile 
	 * @Description: 按照指定的编码把内容写入指定的文件中
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writerFile(String path, String content, String charset) throws IOException {

		File file = new File(path);
		if (!file.getParentFile().exists()) {
			// 创建父目录
			file.getParentFile().mkdirs();
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();
	}
	
	public static String readerFile(File articleFile,  String charset) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(articleFile), charset));
		
		StringBuffer sb = new StringBuffer();
		
		String content = null;
		
		while ((content = br.readLine())!=null) {
			
			sb.append(content);
		}
		br.close();
		
		return sb.toString();
	}


}
