package data.Strategydata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import po.SalaryPO;

public class SalaryFileDAO  implements SalaryDAO{

	SalaryPO salaryPO;
	String path;
	
	public SalaryFileDAO(String file) {
	
		// TODO Auto-generated constructor stub
		path = "src/main/java/ser/"+ file+".ser";
		salaryPO = read();
	}

	public void setClerkSalary(double salary) {
		// TODO Auto-generated method stub
		//salaryPO.setClerkSalary(salary);
	}

	public void setDriverWage(double wage) {
		// TODO Auto-generated method stub
		//salaryPO.setDriverWage(wage);
	}

	public void setPostmanWage(double wage) {
		// TODO Auto-generated method stub
		//salaryPO.setPostmanWage(wage);
	}

	public double getClerkSalary() {
		// TODO Auto-generated method stub
		//return salaryPO.getClerkSalary();
		return 0.0;

	}

	public double getDriverWage() {
		// TODO Auto-generated method stub
		//return salaryPO.getDriverWage();
		return 0.0;

	}

	public double getPostmanWage() {
		// TODO Auto-generated method stub
		//return salaryPO.getPostmanWage();
		return 0.0;

	}

	public SalaryPO read() {
		// TODO Auto-generated method stub
//		ObjectInputStream is = null;
//
//		File file = new File(path);
//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//				return new SalaryPO(2000, 500, 0.15);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			is = new ObjectInputStream(new FileInputStream(file));
//			while (true) {
//				
//				SalaryPO temp = (SalaryPO) is.readObject();
//				salaryPO = temp;
//			}
//		} catch (Exception ex) {
//			try {
//				
//				if(is!=null)
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return salaryPO;
		
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		try {
			File f = new File(path);
			FileWriter fw =  new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	 try {		 
			ObjectOutputStream os;
			File file = new File(path);
			FileOutputStream fos = new FileOutputStream(file, true);
			if (file.length() < 1) {
				os = new ObjectOutputStream(fos);
			} else {
				os = new MyObjectOutputStream(fos);
			}
			os.writeObject(salaryPO);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	
	public class MyObjectOutputStream extends ObjectOutputStream {
		public MyObjectOutputStream() throws IOException {
			super();
		}

		public MyObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		protected void writeStreamHeader() throws IOException {
			return;
		}
}
}

