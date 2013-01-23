package de.amberhome.SimpleActionBar;

import java.lang.reflect.Field;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;

public class RHelper {

	public RHelper(BA ba) {


	}

	@Hide
	public static int getResourceId(String type, String resourceName) {
		int ret = 0;
		try {
			ret = (Integer) GetStaticField(BA.packageName + ".R$" + type, resourceName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	@Hide
	public static int[] getResourceArray(String type, String resourceName) {
		int ret[] = {0};

		try {
			ret = (int[]) GetStaticField(BA.packageName + ".R$" + type, resourceName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	@Hide
	public static Object GetStaticField(String classname, String field)
			throws Exception
			{
		Exception ex = null;
		Class<?> ob = Class.forName("java.lang.Object");
		Class<?> ot = Class.forName(classname);
		do
		{
			try
			{
				Field f = ot.getDeclaredField(field);
				f.setAccessible(true);
				return f.get(null);
			}
			catch (Exception e) {
				ex = e;
				ot = ot.getSuperclass();
			}
		}
		while (ot != ob);
		throw ex;
			}

}
