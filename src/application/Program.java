package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("PROGRAM STARTED!!");
		
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))){
			
			String linha = br.readLine();
			
			List<Product> list = new ArrayList<>();
			
			while(linha != null && !linha.equals("FIM")) {
				String[] fields = linha.split(" ");
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				Integer quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));
				
				
				linha = br.readLine();
			}
			
			
			try(BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(System.out))){
				
				for (Product item : list) {
					bw.write(" Produto " + item);
					bw.newLine();
				}
				
				
			}catch(IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}finally {
				if(br != null) {
					br.close();
				}
			}
			
			
		}catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		
	}

}
