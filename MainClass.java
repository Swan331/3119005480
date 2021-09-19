import java.text.DecimalFormat;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner finn =null;
		try {
			finn = new Scanner(System.in);
			System.out.print("请输入路径");
			String[] words;
			words=finn.nextLine().split(" ");
			StringBuffer sb2 = getText.getArticle(words[2]);		
			StringBuffer sb1 = getText.getArticle(words[3]);
								
			SimHash hash1 = new  SimHash(sb1.toString(),  64 );
			SimHash hash2 = new  SimHash(sb2.toString(),  64 );
			
			int distance = hash1.getDistance(hash1.getStrSimHash() , hash2.getStrSimHash());
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
	       
	        
	        String outpath = words[4];
	        	        
	        String content = "\r\n抄袭论文文件的路径：" + words[3] + "\r\n论文原文的路径：" + words[2] + "\r\n论文重复率为" + decimalFormat.format(distance/64.0);
	        getText.writeArticle(outpath, content);
	        
		} catch (NullPointerException e1) {
			System.out.println("输入路径错误或文件不存在");
			e1.printStackTrace();
		} catch (Exception e) {
			System.out.println("输入错误导致程序出错");
			e.printStackTrace();
		} finally {
			if(finn != null) {
				finn.close();
			}
		}
		
       
	}
}
