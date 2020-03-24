package com.pdftool;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.text.PDFTextStripper;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class PdfTools {

	private static String filePath ="d:\\sf\\sf01.txt";

	public static void main(String[] args) throws IOException {
		
//		initPDF();
//		createOneMoreNullPage();
//		createPdfLoadSource();
//		removeLoadPage();
//		attrDocument();
//		addTextToLoadPdf();
		loadPdfText();
		
//		addMultipleLines();
		
//		addScript();
		
		
	}

	private static void addScript() throws IOException {
		PDDocument document = PDDocument.load(new File("D:\\a.pdf"));
		String javaScript = "app.alert( {cMsg: 'this is an example', nIcon: 3, nType: 0, cTitle: 'PDFBox Javascript example’} );";
		PDActionJavaScript PDAjavascript = new PDActionJavaScript(javaScript);
		document.getDocumentCatalog().setOpenAction(PDAjavascript);	
		document.save("d:\\a.pdf");
		System.out.println("create finish");
		document.close();
	}

	private static void addMultipleLines() throws IOException {
		String text1 = "This is an example of adding text to a page in the pdf document. we can add as many lines as ";
		String text2 ="we want like this using the <b class='notranslate'>showText()</b> method of theContentStream class";
		// 加载现有文档
		PDDocument document = PDDocument.load(new File("D:\\a.pdf"));

		PDPageContentStream stream = new PDPageContentStream(document, document.getPage(0),AppendMode.OVERWRITE,true);
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ITALIC, 10);
		stream.setLeading(14.5f);
		stream.newLineAtOffset(25, 725);
		stream.showText(text1);
		stream.newLine();
		stream.showText(text2);
		stream.endText();
		stream.close();
		
		
		
		document.save("d:\\a.pdf");
		document.close();
	}

	private static void loadPdfText() throws IOException {
		// 加载现有文档
		PDDocument document = null;
		 try {
             document = PDDocument.load(new File("D:\\sf.pdf"));
             int pageSize = document.getNumberOfPages();
             // 一页一页读取
             for (int i = 0; i < pageSize; i++) {
                 // 文本内容
                 PDFTextStripper stripper = new PDFTextStripper();
                 // 设置按顺序输出
                 stripper.setSortByPosition(true);
                 stripper.setStartPage(i + 1);
                 stripper.setEndPage(i + 1);
                 String text = stripper.getText(document);
                 System.out.println(text.trim());
                 System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                 // 图片内容
                 PDPage page = document.getPage(i);
                 PDResources resources = page.getResources();
                 Iterable<COSName> cosNames = resources.getXObjectNames();
                 if (cosNames != null) {
                     Iterator<COSName> cosNamesIter = cosNames.iterator();
                     while (cosNamesIter.hasNext()) {
                         COSName cosName = cosNamesIter.next();
                         if (resources.isImageXObject(cosName)) {
                             PDImageXObject Ipdmage = (PDImageXObject) resources.getXObject(cosName);
                             BufferedImage image = Ipdmage.getImage();
                            int randomUUID = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
							FileOutputStream out = new FileOutputStream("D:\\sf\\" + randomUUID + ".png");
                             try {
                                 ImageIO.write(image, "png", out);
                             } catch (IOException e) {
                             } finally {
                                 try {
                                     out.close();
                                 } catch (IOException e) {
                                 }
                             }
                             // 转文字
                             ITesseract instance = new Tesseract();
                             instance.setDatapath("D:\\tessdata"); //相对目录，这个时候tessdata目录和src目录平级
//                           instance.setDatapath("E:\\myProgram\\java\\ocrdemo\\tessdata");//支持绝对目录
                             instance.setLanguage("chi_sim");//选择字库文件（只需要文件名，不需要后缀名）
                             try {
                                 File imageFile = new File("D:\\sf\\" + randomUUID + ".png");
                                 String result = instance.doOCR(imageFile);//开始识别
                                 writeFile(filePath , result);
                                 System.out.println(i);//打印图片内容
                             } catch (Exception e) {
                                 System.out.println(e.toString());//打印图片内容
                             }
                         }
                     }
                 }
             }
         
	        } catch (InvalidPasswordException e) {
	        	e.printStackTrace();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        } finally {
	            try {
	                if (document != null) {
	                    document.close();
	                }
	            } catch (IOException e) {
	            }
	        }
		
	}
	private static void writeFile(String filePath,String content) {
        FileOutputStream out = null;
        try {
            //1.根据路径创建输出流对象
            out = new FileOutputStream(filePath,true) ;
            //2.把String字符串转换成byte数组；
            byte[] b = content.getBytes(); 
            //3.把byte数组输出
            out.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	private static void addTextToLoadPdf() throws IOException {
		// 加载现有文档
		PDDocument document = PDDocument.load(new File("D:\\abc.pdf"));
		// 获取需要修改的页面
		PDPage page = document.getPage(2);
		// 准备内容流
		PDPageContentStream stream = new PDPageContentStream(document, page,AppendMode.OVERWRITE,false);
		// 准备写入信息
		stream.beginText();
		String text = "hello  word.";
		stream.setFont(PDType1Font.COURIER,22);
		stream.newLineAtOffset(0, 0);
		stream.showText(text);
		stream.endText();
		
		// 关闭流
		stream.close();
		// 保存文档
		document.save("d:\\abc.pdf");
		// 关闭文档流
		document.close();
	}

	/**
	 * 设置添加文件属性
	 * @throws IOException
	 */
	private static void attrDocument() throws IOException {
		PDDocument document = PDDocument.load(new File("D:\\abc.pdf"));
		PDDocumentInformation pdd = document.getDocumentInformation();

		pdd.setAuthor("IoWiki");
		pdd.setTitle("Sample document");
		pdd.setCreator("PDF Examples");
		pdd.setSubject("Example document");
		Calendar date = new GregorianCalendar();
		date.set(2015, 11, 5);
		pdd.setCreationDate(date);
		date.set(2016, 6, 5);
		pdd.setModificationDate(date);
		pdd.setKeywords("sample, first example, my pdf");
		System.out.println(pdd.getAuthor());
		System.out.println(pdd.getCreator());
//		info.setAuthor("W.hy");
//		info.setCreator("W.hy");
//		document.addPage(new PDPage());
//		document.save("D:\\abc.pdf");
		document.close();
	}

	/**
	 * 删除指定的页面
	 * @throws IOException
	 */
	private static void removeLoadPage() throws IOException {
		PDDocument document = PDDocument.load(new File("D:\\abc.pdf"));
		int numberOfPages = document.getNumberOfPages();
		System.out.println("总页数"+numberOfPages);
		for (int i = 0; i < numberOfPages-2; i++) {
			document.removePage(i);
		}
		numberOfPages = document.getNumberOfPages();
		System.out.println("总页数"+numberOfPages);
		document.save("d:\\abc.pdf");
		document.close();
	}

	/**
	 * 加载现有的pdf，移到零一问文件（复制黏贴。稍稍快点）
	 * @throws IOException
	 */
	private static void createPdfLoadSource() throws IOException {
		PDDocument document = PDDocument.load(new File("D:\\1912.pdf"));
		document.addPage(new PDPage());
		document.save("d:\\abc.pdf");
		document.close();
	}

	/**
	 * 创建一个空页面的pdf文件
	 * @throws IOException 
	 */
	private static void createOneMoreNullPage() throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		document.save("d:\\abc.pdf");
		document.close();
		
	}

	/**
	 * 创建一个空的pdf文件
	 * 打开会报错，文件为空
	 */
	private static void initPDF() {
		PDDocument document = new PDDocument();
		try {
			document.save("d:\\a.pdf");
			System.out.println("创建完毕！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
