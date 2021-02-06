import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;

public class ProjectI1_150117057_150116010_150117034 {

	public static void main(String[] args) throws Exception {
//Rümeysa Öztürk 150117057-Þükriye Soyer 150116010-Berra Mercan 150117034
		String inputString;
		String[] instruction = { "AND", "ADD", "ADDI", "LD", "ST", "ANDI", "CMP", "JUMP", "JE", "JA", "JB", "JBE",
				"JAE" };
		ArrayList<String> inputArray = new ArrayList<String>();
		BufferedReader input = new BufferedReader(new FileReader("input.txt"));
		File output = new File("out.hex");
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("v2.0 raw");
		bw.newLine();
		while ((inputString = input.readLine()) != null) {
			inputArray.add(inputString);
		}
		for (int i = 0; i < inputArray.size(); i++) {
			String[] splittedArray = inputArray.get(i).split("[, ]");
			for (int j = 0; j < splittedArray.length; j++) {
				for (int k = 0; k < instruction.length; k++) {
					if (splittedArray[j].equals(instruction[k])) {
						bw.write(toDecimal(instrucionSetToBinary(splittedArray)));
						bw.newLine();
					}
				}
			}
		}
		System.out.println("Output written successfully to the output file.");
		bw.close();
	}

	public static String instrucionSetToBinary(String array1[]) {
		String convert = "";
		switch (array1[0]) {
		case "ADD":
			convert += "001";
			convert += toBinarySRC(array1[1]);
			convert += toBinarySRC(array1[2]);
			convert += "0000";
			convert += toBinarySRC(array1[3]);
			return convert;
		case "ADDI":
			convert += "001";
			convert += toBinarySRC(array1[1]);
			convert += toBinarySRC(array1[2]);
			convert += "1";
			convert += toBinaryIMM(array1[3]);
			return convert;
		case "AND":
			convert += "010";
			convert += toBinarySRC(array1[1]);
			convert += toBinarySRC(array1[2]);
			convert += "0000";
			convert += toBinarySRC(array1[3]);
			return convert;
		case "ANDI":
			convert += "010";
			convert += toBinarySRC(array1[1]);
			convert += toBinarySRC(array1[2]);
			convert += "1";
			convert += toBinaryIMM(array1[3]);
			return convert;
		case "LD":
			convert += "011";
			convert += toBinarySRC(array1[1]);
			convert += toBinaryAddress(array1[2]);
			return convert;
		case "ST":
			convert = "100";
			convert += toBinarySRC(array1[1]);
			convert += toBinaryAddress(array1[2]);
			return convert;
		case "JUMP":
			convert += "101";
			convert += "000";
			convert += toBinaryAddress(array1[1]);
			return convert;
		case "CMP":
			convert += "110";
			convert += "000";
			convert += toBinarySRC(array1[1]);
			convert += "0000";
			convert += toBinarySRC(array1[2]);
			return convert;
		case "JA":
			convert += "111";
			convert += "000";
			convert += toBinaryAddress(array1[1]);
			return convert;
		case "JE":
			convert += "111";
			convert += "001";
			convert += toBinaryAddress(array1[1]);
			return convert;
		case "JB":
			convert += "111";
			convert += "010";
			convert += toBinaryAddress(array1[1]);
			return convert;
		case "JAE":
			convert += "111";
			convert += "011";
			convert += toBinaryAddress(array1[1]);
			return convert;
		case "JBE":
			convert += "111";
			convert += "101";
			convert += toBinaryAddress(array1[1]);
			return convert;
		}
		return convert;
	}

	public static String toBinarySRC(String str) {
		String s = str.replaceAll("R", "");
		s = new BigInteger(s, 16).toString(2);
		String a = "";
		int x = s.length();
		while (x != 3) {
			a += "0";
			x++;
		}
		return a.concat(s);
	}

	public static String toBinaryAddress(String str) {
		int b = Integer.parseInt(str);
		String s = str;
		s = new BigInteger(s, 16).toString(2);
		String a = "";
		String z = "";
		int lengthPos = s.length();
		if (b >= 0) {
			while (lengthPos != 10) {
				a += "0";
				lengthPos++;
			}
			z = a.concat(s);
		} else {
			String binary = Integer.toBinaryString(b);
			int lengthNeg = binary.length();
			while (lengthNeg != 10) {
				binary = binary.substring(1);
				z = binary;
				lengthNeg--;
			}
		}
		return z;
	}

	public static String toBinaryIMM(String str) {
		int b = Integer.parseInt(str);
		String s = str;
		s = new BigInteger(s, 16).toString(2);
		String a = "";
		String z = "";
		int lengthPos = s.length();
		if (b >= 0) {
			while (lengthPos != 6) {
				a += "0";
				lengthPos++;
			}
			z = a.concat(s);
		} else {
			String binary = Integer.toBinaryString(b);
			int lengthNeg = binary.length();
			while (lengthNeg != 6) {
				binary = binary.substring(1);
				z = binary;
				lengthNeg--;
			}
		}
		return z;
	}

	public static String toDecimal(String str) {
		String value = "";
		for (int i = 0; i < str.length(); i = i + 4) {
			String a = "";
			a += str.charAt(i);
			a += str.charAt(i + 1);
			a += str.charAt(i + 2);
			a += str.charAt(i + 3);
			int decimal = Integer.parseInt(a, 2);
			String s = String.valueOf(decimal);
			if (decimal == 10) {
				s = "A";
			} else if (decimal == 11) {
				s = "B";
			} else if (decimal == 12) {
				s = "C";
			} else if (decimal == 13) {
				s = "D";
			} else if (decimal == 14) {
				s = "E";
			} else if (decimal == 15) {
				s = "F";
			}
			value = value.concat(s);
		}
		return value;
	}
}