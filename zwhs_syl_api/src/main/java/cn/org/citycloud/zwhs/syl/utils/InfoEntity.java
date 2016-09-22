package cn.org.citycloud.zwhs.syl.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * @author allen
 * 
 */
public class InfoEntity extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1081416565787763921L;
	private APIInfo error;

	/**
	 * @param error
	 */
	public InfoEntity(APIInfo error) {
		this.setError(error);
		this.put("ret", error.getCode());
		this.put("message", error.getMsg());
	}

	/**
	 * @param info
	 */
	public InfoEntity(String info) {
		this.put("ret", 9);
		this.put("message", info);
	}

	/**
	 * @param success
	 * @param info
	 */
	public InfoEntity(APIInfo success, Map<String, Object> info) {
		this(success);
		this.putAll(info);
	}

	/**
	 * @return the error
	 */
	public APIInfo getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(APIInfo error) {
		this.error = error;
	}
}
