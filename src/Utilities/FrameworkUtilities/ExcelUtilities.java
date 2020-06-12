package Utilities.FrameworkUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities extends frameworkUtilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		generateExecutionId();
		createResultsLocation();
		
		
		createRunManagerInputStream(ProjectDirectory+"//RunManagers//BuildVerificationTests.xlsx");
		getRunManagerSuiteSheet("TestSuiteManager");
		getTotalNumberOfSuite();
				
		
		int testCaseNameColNum = findColumnNumber("TestSuiteName");
		int browserColNum = findColumnNumber("Browser");
		int executeColNum = findColumnNumber("Execute");
		int statusColNum = findColumnNumber("Status");
		int datasheetlocationColNum = findColumnNumber("DataSheetLocation");
		
		for(int i=1;i<totalNumberOfTests;i++) {
			currentTestNumber = i;
//			setTestSuiteStatus(statusColNum, "Passed");
			testDetails.put("TestCaseName",findTestSuiteDetails(testCaseNameColNum));
			testDetails.put("BrowserName",findTestSuiteDetails(browserColNum));
			testDetails.put("Execute",findTestSuiteDetails(executeColNum));
			testDetails.put("Status",findTestSuiteDetails(statusColNum));
			testDetails.put("DataSheetLocation",findTestSuiteDetails(datasheetlocationColNum));
			System.out.println(testDetails);
//			setTestStatus(statusColNum, "Passed");
//			writeDataToRunManager(ProjectDirectory+"//RunManagers//BuildVerificationTests.xlsx");
			copyFile(ProjectDirectory+"//RunManagers//BuildVerificationTests.xlsx",resultsLocation+"//BuildVerificationTests.xlsx");
			testDetails.clear();
		}
		
	}
	
	public static void copyFile(String InitialLocation,String CopyLocation) {
		FileSystem system = FileSystems.getDefault();
        Path original = system.getPath(InitialLocation);
        Path target = system.getPath(CopyLocation);

        try {
            // Throws an exception if the original file is not found.
            Files.copy(original, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
        	ex.printStackTrace();
        	throw new RuntimeException(ex.getMessage());
        }
	}

	public static final void createRunManagerInputStream(String FileLocation) {
		try {
			FileInputStream RunManagerFIS = new FileInputStream(FileLocation);
			RunManagerWorkBook = new XSSFWorkbook(RunManagerFIS);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} 
	}
	

	public static final void getRunManagerSuiteSheet(String SheetName) {	
			RunManagerMainSheet = RunManagerWorkBook.getSheet(SheetName);		
	}
	
	public static final void getTotalNumberOfSuite() {
		totalNumberOfTests = RunManagerMainSheet.getLastRowNum();
	}
	
	public static int findColumnNumber(String ColumnName) {
		Row row = RunManagerMainSheet.getRow(0);
		int r = row.getLastCellNum();
		for(int i=0;i<=r;i++)
		{
			Cell cell = row.getCell(i);
			if(cell != null) {
				String cellValue = cell.getStringCellValue();
				if(cellValue.equals(ColumnName))
				{
					System.out.println("ColumnName: "+ ColumnName +" is in columnnumber:" + i);
					return i;
				}
			}
			
		}
		System.out.println("ColumnName: "+ ColumnName +" is not present");
		return -1;
	}
	
	public static String findTestSuiteDetails(int ColumnNumber) {
		Row row = RunManagerMainSheet.getRow(currentTestNumber);
		Cell cell = row.getCell(ColumnNumber);
		if(cell != null) {
			String cellValue = cell.getStringCellValue();
			System.out.println("Column"+ ColumnNumber +" in row "+ currentTestNumber +"has value" + cellValue);
			return cellValue;
		}
		System.out.println("Column"+ ColumnNumber +" in row "+ currentTestNumber +"has value" + " .");
		return "";
	}
	
	
	
	public static void setTestSuiteStatus(int ColumnNumber,String status) {
		Row row = RunManagerMainSheet.getRow(currentTestNumber);
		Cell cell = row.createCell(ColumnNumber);
		System.out.println("CEll existing value" + (cell == null));
		cell.setCellValue(status);
	}
	
	public static final void writeDataToRunManager(String FileLocation) {	
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(FileLocation);
			RunManagerWorkBook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
}
