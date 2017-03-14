package com.nomico.util;

import java.util.UUID;

public class GetUuid {

	public static String getUUID() {

		String str = UUID.randomUUID().toString().trim().replace("-", "");
		//System.out.println(str);
		return str;

	}
//	public static void main(String[] args) {
//		getUUID();
//	}

}
