package cn.org.citycloud.zwhs.syl.utils;

/**
 * @author allen
 * 
 */
public enum APIInfo {
	/**
	 * 当API接受的参数不符合要求时返回此错误。如null值，日期格式错误等
	 */
	INPUT(1, "输入参数错误"), /**
	 * 输入的日期格式错误
	 */
	INPUT_DATE_ERR(101, "日期格式错误"), /**
	 * 
	 */
	INPUT_CMD_ERROR(102, "输入的cmd参数错误"), /**
	 * 当输入的参数缺少时
	 */
	INPUT_CANT_BE_NULL(102, "输入参数缺少"), /**
	 * 
	 */
	INPUT_VALUE_INVALID(103, "输入的参数不正确"),
	/**
	 * 
	 */
	INPUT_CITY_INVALID(1031, "输入的城市名错误"),
	/**
	 * 
	 */
	INPUT_POSITION_INVALID(1032, "输入的地理位置坐标错误"),
	/**
	 * 
	 */
	INPUT_SERVICE_INVALID(1032, "输入的服务类型不存在"),
	/**
	 * 
	 */
	INPUT_SORT_INVALID(1033, "输入的排序方式错误"), INPUT_ADDRESS_INVALID(1034,
			"输入的地址错误"),
	/**
	 * 用户未登录时返回此错误
	 */
	NOT_LOGGED(2, "用户未登录"),
	/**
	 * 注册期间可能的错误，用户已存在
	 */
	USER_EXISTS(2001, "用户已注册"),
	/**
	 * 用户无此权限时返回该错误
	 */
	AUTH_NOT_MATCH(3, "用户权限错误"), /**
	 * 操作数据库时返回错误
	 */
	DATABASE_ERROR(4, "数据库操作错误"), /**
	 * 
	 */
	DATABASE_INSERT_ERROR(401, "数据库写入错误"), /**
	 * 
	 */
	DATABASE_FETCH_ERROR(402, "数据库读取错误"),
	/**
	 * 
	 */
	SYSTEM_ERROR(5, "未知原因的系统错误"), /**
	 * 
	 */
	SUCCESS(0, "操作成功"), /**
	 * 业务内阻止的操作
	 */
	OPERATION_FAIL(6, "不支持的操作"), /**
	 * 
	 */
	NO_DATA(104, "未找到查询的数据"), /**
	 * 
	 */
	NETWORK_ERROR(7, "网络连接问题，请稍后再试"), 
	
	FAIL(9, "失败");

	private int code;
	private String msg;

	private APIInfo(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
}
