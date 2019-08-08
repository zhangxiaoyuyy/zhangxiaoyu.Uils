package zhangxiaoyu.StreamUtil;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void testCloseAll() {
	}

	@Test
	public void testReadTextFileInputStream() throws FileNotFoundException, IOException {
		String string = StreamUtil.readTextFile(new FileInputStream("G:\\小一\\老师代码\\2019-08-08\\上午\\视频/readme.txt"));
		System.out.println(string);
	}

	@Test
	public void testReadTextFileFile() throws FileNotFoundException, IOException {
		String string = StreamUtil.readTextFile(new File("G:\\\\小一\\\\老师代码\\\\2019-08-08\\\\上午\\\\视频/readme.txt"));
		System.out.println(string);
	}

}
