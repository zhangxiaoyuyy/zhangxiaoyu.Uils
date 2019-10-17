package zhangxiaoyu.StringUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * .
 * 
 * @ClassName: StringUtil
 * @Description: TODO
 * @author: zxy
 * @date: 2019年8月9日 上午9:20:27
 */
public class StringUtil {
	
	/**
	 * 
	 * @Title: splitLen 
	 * @Description: 截取字符串
	 * @param content
	 * @param len
	 * @return: void
	 */
	public static String subLen(String content,Integer len) {
		String string = content.substring(0, len);
		return string;
	}

	/**
	 * 功能说明：实现判断传入的字符串是否为包含http的url地址
	 */
	public static boolean isHttpUrl(String src) {

		try {
			URL url = new URL(src);
			url.openConnection();
			return true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 字符串转为日期
	 * 
	 * @Title: getFormatDate
	 * @Description: TODO
	 * @param date
	 * @param pattern
	 * @return
	 * @return: Date
	 */
	public static Date getFormatDate(String date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(date);
		} catch (ParseException e) {
			// e.printStackTrace();
		}

		return null;

	}

	/**
	 * 
	 * @Title: isNumber
	 * @Description: 判断是否为整数
	 * @param obj
	 * @return
	 * @return: String
	 */
	public static String isNumber(Object obj) {
		if (obj instanceof Integer) {
			return "为整数";
		}
		return "不是整数";
	}

	/*
	 * 方法功能：根据正则在字符串提取一段值，用于后面在url地址里提取ID值。
	 * 例如在“http://news.cnstock.com/news,yw-201908-4413224.htm”把“4413224”提取出来。
	 */
	public static String getPlaceholderValue(String src, String regex) {
		String[] split = src.split(regex);
		return split[split.length - 1];
	}

	/**
	 * 
	 * @Title: split
	 * @Description: 字符串切割
	 * @param url
	 * @param chars 分割方式 | , ;
	 * @return
	 * @return: String[]
	 */
	public static String[] split(String url, String chars) {

		return url.split(chars);

	}

	/**
	 * 
	 * @Title: strToInt
	 * @Description: 字符串转整型
	 * @param str
	 * @return
	 * @return: Integer
	 */
	public static Integer strToInt(String str) {

		return Integer.parseInt(str);
	}
	/**
	 * 
	 * @Title: strToInt
	 * @Description: 字符串转整型
	 * @param str
	 * @return
	 * @return: Integer
	 */
	public static BigDecimal strToDouble(String str) {
		double d = Double.parseDouble(str);
		return BigDecimal.valueOf(d);
	}

	/*
	 * public static void main(String[] args) { BigDecimal decimal =
	 * strToDouble("8520"); System.out.println(decimal); }
	 */
	/**
	 * 
	 * @Title: strToDate
	 * @Description: 字符串转日期
	 * @param str
	 * @return
	 * @return: Integer
	 *
	 */
	public static Date strToDate(String str) {

		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = df.parse(str);
			return date;
		} catch (ParseException e) {
		}

		return null;

	}

	// 方法1：判断源字符串是否有值，空引号(空白字符串)也算没值 (5分)
	public static boolean hasLength(String src) {

		return src.length() > 0 && src != null;
	}

	// 方法2：判断源字符串是否有值，空引号(空白字符串)和空格也算没值 (5分)
	public static boolean hasText(String src) {
		return src.length() > 0 && src != null;

		// TODO 实现代码
	}

	// 方法3：返回参数length个中文汉字字符串，字符集必须在GB2312(相当于中文简体)范围内，例如“中呀被”(5分)
	public static String randomChineseString() {
		Random r = new Random();
		String str = (char) (r.nextInt(40869 - 19968 + 1) + 19968) + "";
		// String str = (char) (r.nextInt(40869 - 19968 + 1) + 19968) + "";
		// 判断是否是中文GB2312的编码
		try {
			if (str.equals(new String(str.getBytes("GB2312"), "GB2312"))) {
				return str;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return randomChineseString();
		// TODO 实现代码
	}

	public static String randomChineseString(int length) {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < length; i++) {
			str.append(randomChineseString());
		}
		return str.toString();
	}

	/**
	 * 
	 * @Title: generateChineseSex
	 * @Description:随机返回性别
	 * @return
	 * @return: String
	 */
	public static String generateChineseSex() {

		String[] strSex = { "男", "女" };
		Random r = new Random();

		String str1 = strSex[r.nextInt(strSex.length)];
		return str1;

	}

	public static String RandomEmil(int min,int max) {

		String[] strSex = { "@qq.com", "@163.com", "@gmail.com", "@sohu.com", "@hotmail.com" };
		Random r = new Random();
		String str1 = strSex[r.nextInt(strSex.length)];
		
		Random r1 = new Random();
		int x = r1.nextInt(20); 
		String str2 = "";
		if ( x>= 3 && x< 20) {
			for (int i = 0; i < r.nextInt(); i++) {
				Random r2 = new Random();
				
				str2 += r2.nextInt(9);
			}
		}
		if(str2.length()<3) {
			return "";
		}
		return str2+str1;

	}

	// 方法4：返回中文姓名，必须以真实姓开头，百家姓在“六、附百家姓”里，名使用1-2个随机汉字(8分)，内部调用randomChineseString()方法(3分)。返回示例：“刘呀被”、“欧阳及为”
	public static String generateChineseName() {

		String[] strName = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "楮", "卫", "蒋", "沈", "韩", "杨", "朱", "秦",
				"尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦",
				"章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
				"酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐",
				"于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵",
				"湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
				"屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闽", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭",
				"梅", "盛", "林", "刁", "锺", "徐", "丘", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝",
				"管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸",
				"左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "於", "惠", "甄", "麹", "家",
				"封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷",
				"车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "斜", "厉", "戎", "祖",
				"武", "符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "薄", "印", "宿", "白", "怀", "蒲", "邰",
				"从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党",
				"翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "郤", "璩", "桑", "桂", "濮", "牛", "寿", "通",
				"边", "扈", "燕", "冀", "郏", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦",
				"艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国",
				"文", "寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖",
				"融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相",
				"查", "后", "荆", "红", "游", "竺", "权", "逑", "盖", "益", "桓", "公", "晋", "楚", "阎", "法", "汝", "鄢", "涂", "钦", "岳",
				"帅", "缑", "亢", "况", "后", "有", "琴", "商", "牟", "佘", "佴", "伯", "赏", "墨", "哈", "谯", "笪", "年", "爱", "阳", "佟",
				"万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政", "濮阳", "淳于",
				"单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "锺离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "丌官", "司寇",
				"仉", "督", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "乐正", "壤驷", "公良", "拓拔", "夹谷", "宰父", "谷梁", "段干", "百里",
				"东郭", "南门", "呼延", "归", "海", "羊舌", "微生", "梁丘", "左丘", "东门", "西门", "南宫", "赵", "钱", "孙", "李", "周", "吴", "郑",
				"王", "冯", "陈", "楮", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华",
				"金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁",
				"韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺",
				"倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元",
				"卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧",
				"计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闽", "席",
				"季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "锺", "徐", "丘", "骆", "高", "夏",
				"蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应",
				"宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑",
				"裴", "陆", "荣", "翁", "荀", "羊", "於", "惠", "甄", "麹", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井",
				"段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲",
				"伊", "宫", "宁", "仇", "栾", "暴", "甘", "斜", "厉", "戎", "祖", "武", "符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司",
				"韶", "郜", "黎", "蓟", "薄", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙",
				"池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉",
				"宰", "郦", "雍", "郤", "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "郏", "浦", "尚", "农", "温", "别",
				"庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾",
				"终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利",
				"蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾",
				"毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红", "游", "竺", "权", "逑", "盖", "益",
				"桓", "公", "晋", "楚", "阎", "法", "汝", "鄢", "涂", "钦", "岳", "帅", "缑", "亢", "况", "后", "有", "琴", "商", "牟", "佘",
				"佴", "伯", "赏", "墨", "哈", "谯", "笪", "年", "爱", "阳", "佟", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方",
				"赫连", "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政", "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "锺离",
				"宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "丌官", "司寇", "仉", "督", "子车", "颛孙", "端木", "巫马", "公西", "漆雕",
				"乐正", "壤驷", "公良", "拓拔", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "南门", "呼延", "归", "海", "羊舌", "微生", "梁丘",
				"左丘", "东门", "西门", "南宫" };

		Random r = new Random();

		String str1 = strName[r.nextInt(strName.length)];
		String str2 = randomChineseString(r.nextInt(2) + 1);

		return str1 + str2;
		// TODO 实现代码
	}
}
