package wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.stream.FileCacheImageInputStream;




public class WC {
	
	static String filepath;//文件路径
	FileReader fr;
	BufferedReader br;

	
	public int l() {
		int countline = 0;
		
		try {
		fr = new FileReader(filepath);
		br = new BufferedReader(fr);
		
			while (br.readLine() != null) {
				countline++;
			}
			br.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return countline;
	}
	
	
	
	public int c() {
		int countchar = 0; 
		String s ="";
		String getfile;
			
		try {
			fr = new FileReader(filepath);
	        BufferedReader br=new BufferedReader(fr);
	        while((getfile = br.readLine())!=null){
	            s+=(getfile);
	        }
	        br.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		countchar=s.length();//字符串长度即为字符数
		return countchar;
	}
	
	
	
	public int w() {
		int countword = 0;
		String s ="";
		String getfile;
			
		try {
			fr = new FileReader(filepath);
	        BufferedReader br=new BufferedReader(fr);
	        while((getfile = br.readLine())!=null){
	            s+=(getfile)+"\n";
	        }
	        br.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		String[] str =s.split(" |\n");//用空格以及换行符区分单词
		countword =str.length;
		return countword;
		
	}
	 
	
	
    public void fileExist() {
    	System.out.println("请输入文件路径：");
		Scanner sc = new Scanner(System.in);
		filepath = sc.next();
		File file = new File(filepath );
		if(file.exists()) {
		new WC().l();
		System.out.println("行数："+new WC().l());
		new WC().c();
		System.out.println("字符数："+new WC().c());
		new WC().w();
		System.out.println("单词数："+new WC().w());	
		}
		else {
			System.out.println("文件路径无效。");
			fileExist();
		}
    }

		
	
	public static void main(String[] args) {
		WC wc = new WC();
		wc.fileExist();
	}
}