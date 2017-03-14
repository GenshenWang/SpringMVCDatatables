package com.nomico.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class ExportCsvUtil {
	public static File createCSVFile(List exportData, LinkedHashMap rowMapper,
			OutputStream out) {

		File csvFile = null;
		BufferedWriter csvFileOutputStream = null;
		try {

			// GB2312使正确读取分隔符","
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
					out, "GB2312"), 1024 * 100);
			// 写入文件头部
			for (Iterator propertyIterator = rowMapper.entrySet().iterator(); propertyIterator
					.hasNext();) {
				Entry propertyEntry = (Entry) propertyIterator.next();
				csvFileOutputStream.write("\""
						+ propertyEntry.getValue().toString() + "\"");
				if (propertyIterator.hasNext()) {
					csvFileOutputStream.write(",");
				}
			}
			csvFileOutputStream.newLine();

			// 写入文件内容
			for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
				// Object row = (Object) iterator.next();
				LinkedHashMap row = (LinkedHashMap) iterator.next();
				System.out.println(row);

				for (Iterator propertyIterator = row.entrySet().iterator(); propertyIterator
						.hasNext();) {
					Entry propertyEntry = (Entry) propertyIterator.next();
					// System.out.println( BeanUtils.getProperty(row,
					// propertyEntry.getKey().toString()));
					csvFileOutputStream.write("\""
							+ propertyEntry.getValue().toString() + "\"");
					if (propertyIterator.hasNext()) {
						csvFileOutputStream.write(",");
					}
				}
				if (iterator.hasNext()) {
					csvFileOutputStream.newLine();
				}
			}
			csvFileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvFileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}
	
	public static File createTxtFile(String str,OutputStream out) {
		File txtFile = null;
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new OutputStreamWriter(out, "GBK"), 1024 * 100);
			   
			write.write(str);   			   			
			write.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				write.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return txtFile;
	}
}
