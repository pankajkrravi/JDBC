package com.jspiders.demoapp;

public class PDFUse {
	public static void main(String[] args) {
		System.out.println("APP Start");
		PDFGenerator pdfgtr=PDFHelper.getPDF();
		pdfgtr.generatePDF();
		System.out.println("App end");
	}
}
