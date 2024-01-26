package utilitis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilty {
  public static FileInputStream fi;
  public static FileOutputStream fo;
  public static XSSFWorkbook wb;
  public static XSSFSheet sheet;
  public static XSSFRow row;
  public static XSSFCell cell;
  static String path=null;
  public XLUtilty(String path){
	  this.path=path;
  }
  
  //Get row count
  public int getRowCount( String xlsheet) throws Exception {
	  fi=new FileInputStream(path);
	  wb=new XSSFWorkbook(fi);
	  sheet=wb.getSheet(xlsheet);
	  int rowCount=sheet.getLastRowNum();
	  wb.close();
	  fi.close();
	  return rowCount;
  }
  
  //get cell count
  public int getCellCount( String xlsheet,int rownum) throws Exception {
	  fi=new FileInputStream(path);
	  wb=new XSSFWorkbook(fi);
	  sheet=wb.getSheet(xlsheet);
	  row=sheet.getRow(rownum);
	  int cellCount=row.getLastCellNum();
	  wb.close();
	  fi.close();
	  return cellCount;
  }
  
  //get cellData
  
  public String getCellData(String xlsheet,int rownum,int cellnum) throws Exception {
	  fi=new FileInputStream(path);
	  wb=new XSSFWorkbook(fi);
	  sheet=wb.getSheet(xlsheet);
	  row=sheet.getRow(rownum);
	  cell=row.getCell(cellnum);
	  String data;
	  try {
	  DataFormatter formater=new DataFormatter();
	  String cellData=formater.formatCellValue(cell); //Returns the formated of a cell as a string regardless of the cell type
	  return cellData;
	  }catch(Exception e){
		  data="";//it will catch the empty cell data Exception
	  }
	  wb.close();
	  fi.close();
	  return data;
  }
  public String setCellData(String xlsheet,int rownum,int cellnum,String data) throws Exception {
	  fi=new FileInputStream(path);
	  wb=new XSSFWorkbook(fi);
	  sheet=wb.getSheet(xlsheet);
	  row=sheet.getRow(rownum);
	  cell=row.getCell(cellnum);
	  cell.setCellValue(data);
	  fo=new FileOutputStream(path);
	  wb.write(fo);
	  wb.close();
	  fi.close();
	  fo.close();
	  return data;
  }
}
